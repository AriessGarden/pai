package utils;

import java.text.ParseException;
import java.util.Calendar;

import org.mindrot.jbcrypt.BCrypt;

import play.mvc.Controller;

/**
 * Password utility class. This handles password encryption and validation.
 * <p/>
 * User: yesnault Date: 25/01/12
 */
public class SecurityUtil extends Controller {

	/**
	 * Create an encrypted password from a clear string.
	 * 
	 * @param clearString
	 *            the clear string
	 * @return an encrypted password of the clear string
	 * @throws AppException
	 *             APP Exception, from NoSuchAlgorithmException
	 */

	public static String createPassword(String clearString) {
		return BCrypt.hashpw(clearString, BCrypt.gensalt());
	}

	/**
	 * @param candidate
	 *            the clear text
	 * @param encryptedPassword
	 *            the encrypted password string to check.
	 * @return true if the candidate matches, false otherwise.
	 */
	public static boolean checkPassword(String candidate,
			String encryptedPassword) {
		if (candidate == null) {
			return false;
		}
		if (encryptedPassword == null) {
			return false;
		}
		return BCrypt.checkpw(candidate, encryptedPassword);
	}

	/**
	 * create new.
	 * 
	 * @author ari
	 * @return
	 */
	public static boolean isLogin() {
		if (session().get("id") != null) {

			if (!isExpire(session().get("expire"))) {
				return true;
			}
			// System.out.println("3 clear the session: " + session());
			// session().clear();
		}
		return false;
	}

	/**
	 * say if the given string date is expired
	 */
	public static boolean isExpire(String dateString) {
		if (dateString != null) {
			Calendar c1 = Calendar.getInstance();
			try {
				c1.setTime(DataFormatUtil.sdf.parse(dateString));
			} catch (ParseException pe) {
				play.Logger
						.debug("Exception : Data format exception in SecurityUtil line:83."
								+ dateString);
				return false;
			}
			return c1.before(Calendar.getInstance());
		}
		return true;
	}

	public static boolean isBlank(String input) {
		return input == null || input.isEmpty() || input.trim().isEmpty();
	}

	public static boolean isBlank(int input) {
		return input == 0;
	}

	/**
	 * 
	 * get expire date for cookie
	 * 
	 * @author aries
	 */
	public static String getExpire(int time) {
		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.MINUTE, time);
		return DataFormatUtil.sdf.format(c1.getTime());
	}
}