package utils;

import java.util.Calendar;

import org.mongojack.DBCursor;

import com.pencho.pai.controllers.UserController;
import com.pencho.pai.models.User;

/**
 * Test 4 star of the day
 * 
 * @author aries
 * 
 */
public class DailyTimerThreadUtil implements Runnable {

	@Override
	public void run() {
		while (true) {
			if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) != 0)
				try {
					Thread.sleep(1000 * 60);
				} catch (InterruptedException e) {
					play.Logger
							.info("Utils->DailyTimerThreadUtil doesn't sleep well");
				}
			else {
				DBCursor<User> dbUserList = UserController.userCollectionJackson
						.find();
				while (dbUserList.hasNext()) {
					dbUserList.next().setStar(0.);
				}
			}
		}
	}
}
