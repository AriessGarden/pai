package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VideoUtil {

	/**
	 * Create thumbnail
	 * 
	 * @author Aries
	 * @param inFile
	 * @param outFile
	 * @param length
	 * @param width
	 * @return boolean
	 */
	public static boolean transfer(String inFile, String outFile, int length,
			int width) {
		String command = "ffmpeg -i " + inFile
				+ " -y -f image2 -vframes 1 -s " + length + "x"
				+ width + " " + outFile;
		try {
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(command);
			java.io.InputStream stderr = proc.getErrorStream();
			InputStreamReader isr = new InputStreamReader(stderr);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null)
				System.out.println(line);
		} catch (Throwable t) {
			// t.printStackTrace();
			play.Logger.info("Create video failed " + DataFormatUtil.getNow());
			return false;
		}
		return true;
	}
}
