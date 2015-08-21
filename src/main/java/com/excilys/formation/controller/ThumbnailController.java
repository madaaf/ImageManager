package com.excilys.formation.controller;

import com.excilys.formation.dto.ThumbnailRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by loic on 04/09/2014.
 */
public interface ThumbnailController {
  ModelAndView processImages(@Valid @ModelAttribute ThumbnailRequest thumbnailDto, final BindingResult result);
  ModelAndView doGet();
}
