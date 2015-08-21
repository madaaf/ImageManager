package com.excilys.formation.webservice;

import com.excilys.formation.dto.ThumbnailResponse;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by loic on 04/09/2014.
 */
public interface ThumbnailWebService {

  ThumbnailResponse createThumbnails(int width, int height);
  ThumbnailResponse createThumbnails(int width, int height, int limit);
  byte[] getThumbnail(@PathVariable String fileName);
}
