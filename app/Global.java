
import play.Application;
import play.GlobalSettings;
import utils.DailyTimerThreadUtil;

public class Global extends GlobalSettings {

	/**
	 * @author aries
	 * test 1
	 */
	@Override
	public void onStart(Application app) {
		new Thread(new DailyTimerThreadUtil()).start();
	}
}
