package utils;

import java.util.List;
import java.util.Map;

import play.mvc.Controller;
import play.mvc.Result;

import com.pencho.pai.controllers.UserController;
import com.pencho.pai.models.User;

/**
 * A util 2 judge user's authority
 * 
 * @author aries
 * 
 */
public class UsersAuthorityUtil extends Controller {

	/**
	 * blockAction
	 * 
	 * @param userID
	 * @return
	 */
	public static Result inBlockListAction(String userID) {
		if (isBlocked(userID))
			return ok(DataFormatUtil.toJsend("fail", "u have been blocked"));

		return null;
	}

	/**
	 * friendAction
	 * 
	 * @param userID
	 * @return
	 */
	public static Result notInFriendListAction(String userID) {
		if (!isFriend(userID))
			return ok(DataFormatUtil.toJsend("fail", "U're not his friend"));

		return null;
	}

	/**
	 * if u're blocked
	 * 
	 * @author aries
	 * @return
	 */
	public static boolean isBlocked(String userID) {
		User user = UserController.userCollectionJackson.findOneById(userID);
		if (user == null)
			return true;
		List<String> blockList = user.getBlackList();
		return blockList.contains(Controller.session().get("id"));
	}

	/**
	 * if u're his/her friend or not.
	 * 
	 * @author aries
	 * @return
	 */
	public static boolean isFriend(String userID) {
		User user = UserController.userCollectionJackson.findOneById(userID);
		if (user == null)
			return false;
		Map<String, String> friendList = user.getFriends();
		if ("true".equals(friendList.get(Controller.session().get("id"))))
			return true;
		return false;
	}

	/**
	 * ___________________
	 * 
	 * @author aries
	 * @return
	 */
	public static boolean is_____________() {
		// TODO:- -+ I don't know what 2 do now.
		return false;
	}
}
