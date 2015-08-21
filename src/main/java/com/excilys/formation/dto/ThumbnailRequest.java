package com.excilys.formation.dto;

import javax.validation.constraints.Min;

/**
 * Created by loic on 04/09/2014.
 */
public class ThumbnailRequest {
  @Min(5)
  private int width;
  @Min(5)
  private int height;
  @Min(0)
  private int limit;

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  @Override
  public String toString() {
    return "ThumbnailRequest{" +
        "width=" + width +
        ", height=" + height +
        ", limit=" + limit +
        '}';
  }
}
