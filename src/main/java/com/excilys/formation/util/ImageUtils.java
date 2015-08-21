package com.excilys.formation.util;

import com.mortennobel.imagescaling.DimensionConstrain;
import com.mortennobel.imagescaling.ResampleOp;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by loic on 04/09/2014.
 */
public class ImageUtils {

  private static List<String> extensions = Collections.unmodifiableList(Arrays.asList(".jpg",".png",".jpeg",".gif"));

  /**
   * Determine if a file is an image or not
   * @param f the file to check
   * @return true if the file is an image, false otherwise
   * @throws java.lang.NullPointerException if parameter is null
   */
  public static boolean isImage(File f) {
    String fileName = f.getName();
    String ext = fileName.substring(fileName.lastIndexOf('.'));
    return extensions.contains(ext.toLowerCase().trim());
  }


  /**
   * Resize image to desired size
   * @param originalImageFile the image file
   * @param destDir the destination directory
   * @param maxWidth the maximum width in px
   * @param maxHeight the maximum height in px
   * @return the resulting BufferedImage fitting the dimensions provided
   * @throws java.lang.NullPointerException if destDir is null, originalImageFile is null or is not an image
   */
  public static String resizeImage(File originalImageFile, File destDir, int maxWidth, int maxHeight) {
    try {
      File destFile = new File(destDir, UUID.randomUUID().toString()+".png");
      ImageIO.write(resizeImage(ImageIO.read(originalImageFile), maxWidth, maxHeight), "png", destFile);
      return destFile.getName();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Resize image to desired size
   * @param originalImage the BufferedImage
   * @param maxWidth the maximum width in px
   * @param maxHeight the maximum height in px
   * @return the resulting BufferedImage fitting the dimensions provided
   */
  private static BufferedImage resizeImage(BufferedImage originalImage, int maxWidth, int maxHeight) {
    DimensionConstrain dimenConstrain = DimensionConstrain.createMaxDimension(maxWidth, maxHeight, true);
    ResampleOp resampleOp = new ResampleOp(dimenConstrain);
    return resampleOp.filter(originalImage, null);
  }
}
