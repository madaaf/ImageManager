package com.excilys.formation.webservice.impl;

import com.excilys.formation.dto.ThumbnailResponse;
import com.excilys.formation.service.ThumbnailService;
import com.excilys.formation.webservice.ThumbnailWebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by excilys on 06/08/15.
 */
@RestController
@RequestMapping("/thumbnails")
public class ThumbnailWebServiceImpl implements ThumbnailWebService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ThumbnailWebServiceImpl.class);

  private static final int MINIMUM_SCALING_RATE = 5;

  @Autowired
  private ThumbnailService service;

  @Override
  @RequestMapping(value = "/{width}/{height}", method = RequestMethod.POST)
  public ThumbnailResponse createThumbnails(@PathVariable int width, @PathVariable int height) {
    if (width < MINIMUM_SCALING_RATE || height < MINIMUM_SCALING_RATE) {
      throw new IllegalArgumentException();
    }

    LOGGER.debug("PROCESS IMAGES");
    List<String> filenames = service.processImages(width, height);
    return new ThumbnailResponse(filenames.size(), filenames);
  }

  @Override
  @RequestMapping(value = "/{width}/{height}/{limit}", method = RequestMethod.POST)
  public ThumbnailResponse createThumbnails(@PathVariable int width, @PathVariable int height, @PathVariable int limit) {
    if (width < MINIMUM_SCALING_RATE || height < MINIMUM_SCALING_RATE) {
      throw new IllegalArgumentException();
    }

    LOGGER.debug("PROCESS IMAGES (with limit)");
    List<String> filenames = service.processImages(width, height, limit);
    return new ThumbnailResponse(filenames.size(), filenames);
  }

  @Override
  @RequestMapping(value = "/{fileName}", method = RequestMethod.GET)
  public byte[] getThumbnail(@PathVariable String fileName) {
    fileName += ".png";
    LOGGER.debug("GET THUMBNAIL {}", fileName);
    return service.getThumbnail(fileName);
  }


  // Exception Handlers
  @ExceptionHandler(value = IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity invalidArgs() {
    LOGGER.debug("BAD ARGUMENTS");
    return new ResponseEntity(HttpStatus.BAD_REQUEST);
  }
}
