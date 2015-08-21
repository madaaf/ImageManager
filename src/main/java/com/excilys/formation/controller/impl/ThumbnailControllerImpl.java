package com.excilys.formation.controller.impl;

import com.excilys.formation.controller.ThumbnailController;
import com.excilys.formation.dto.ThumbnailRequest;
import com.excilys.formation.dto.ThumbnailResponse;
import com.excilys.formation.service.ThumbnailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by excilys on 06/08/15.
 */
@Controller
@RequestMapping("/")
public class ThumbnailControllerImpl implements ThumbnailController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ThumbnailController.class);

  @Autowired
  private ThumbnailService service;

  @Override
  @RequestMapping(method = RequestMethod.POST)
  public ModelAndView processImages(@Valid @ModelAttribute ThumbnailRequest thumbnailDto, BindingResult result) {
    ModelAndView modelAndView = new ModelAndView();
    if (result.hasErrors()) {
      LOGGER.debug("ERROR IN SPRING FORM: {}", thumbnailDto);
      modelAndView.setViewName("index");
      modelAndView.addObject("thumbnailDto", new ThumbnailRequest());
      modelAndView.addObject("errors", true);
    } else {
      ThumbnailResponse response = new ThumbnailResponse();
      List<String> filenames = service.processImages(thumbnailDto.getWidth(), thumbnailDto.getHeight(), thumbnailDto.getLimit());
      response.setProcessed(filenames.size());
      response.setThumbnails(filenames);
      modelAndView.setViewName("thumbnails");
      modelAndView.addObject("response", response);
      modelAndView.addObject("errors", false);
    }

    return modelAndView;
  }

  @Override
  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView doGet() {
    ModelAndView modelAndView = new ModelAndView("index");
    modelAndView.addObject("thumbnailDto", new ThumbnailRequest());
    return modelAndView;
  }
}
