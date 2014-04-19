package utils;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;

import javax.imageio.ImageIO;

import org.apache.commons.io.output.ByteArrayOutputStream;

import play.Logger;

import com.mortennobel.imagescaling.DimensionConstrain;
import com.mortennobel.imagescaling.ResampleOp;

/**
 * To create a thumbnail
 * 
 * @author Aries Sep 25, 2013 5:05:38 PM
 */
public class ImageUtil {

	/**
	 * Create thumbnail
	 * 
	 * @author Aries
	 * @param source
	 * @param width
	 * @param length
	 * @param type
	 * @return ByteArrayOutputStream
	 * @throws FileNotFoundException
	 */
	public static ByteArrayOutputStream scale(BufferedImage source, int width,
			int length, String type) throws FileNotFoundException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ResampleOp resampleOp = new ResampleOp(
					DimensionConstrain.createMaxDimension(width, length, true));
			BufferedImage rescaled = resampleOp.filter(source, null);
			ImageIO.write(rescaled, type, baos);
		} catch (Exception e) {
			Logger.info("Create Image thumbnail fail! " + e);
		}
		return baos;
	}
}