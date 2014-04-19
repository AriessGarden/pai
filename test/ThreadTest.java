import java.util.Calendar;

import com.pencho.pai.models.User;

public class ThreadTest implements Runnable {

	@Override
	public void run() {
		long start = Calendar.getInstance().getTimeInMillis();
		for (int x = 0; x < 10000; x++) {
			dbTest.userCollectionJackson.insert(new User());
		}
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println(end - start);
	}
}
