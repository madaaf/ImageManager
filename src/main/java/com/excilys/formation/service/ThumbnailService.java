package com.excilys.formation.service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * ThumbnailService
 */
public interface ThumbnailService {

  /**
   * Process thumbnailing of provided image resources with defined width and height
   * @param width the maximum width of the thumbnail in px
   * @param height the maximum height of the thumbnail in px
   * @return a list of the filenames
   */
  @Transactional
  public List<String> processImages(int width, int height);

  /**
   * Process thumbnailing of provided image resources with defined width and height, and a maximum number of images
   * @param width the maximum width of the thumbnail in px
   * @param height the maximum height of the thumbnail in px
   * @param limit the maximum number of images to process
   * @return a list of the filenames
   */
  @Transactional
  public List<String> processImages(int width, int height, int limit);

  /**
   * Retrieve processed thumbnail with fileName
   * @param fileName the thumbnail fileName to retrieve
   * @return the byte[] of the thumbnail file
   */
  public byte[] getThumbnail(String fileName);
}
