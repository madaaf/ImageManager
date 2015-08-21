package com.excilys.formation.dto;

import java.util.List;

/**
 * Created by loic on 04/09/2014.
 */
public class ThumbnailResponse {
  private int processed;
  private List<String> thumbnails;

  public ThumbnailResponse() {}

  public ThumbnailResponse(int processed, List<String> thumbnails) {
    this.processed = processed;
    this.thumbnails = thumbnails;
  }

  public int getProcessed() {
    return processed;
  }

  public void setProcessed(int processed) {
    this.processed = processed;
  }

  public List<String> getThumbnails() {
    return thumbnails;
  }

  public void setThumbnails(List<String> thumbnails) {
    this.thumbnails = thumbnails;
  }

  @Override
  public String toString() {
    return "ThumbnailResponse{" +
        "processed=" + processed +
        ", thumbnails=" + thumbnails +
        '}';
  }
}
