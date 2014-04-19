import java.util.Calendar;

import org.mongojack.JacksonDBCollection;

import com.mongodb.DBCollection;
import com.pencho.pai.dao.DAO;
import com.pencho.pai.models.User;

public class dbTest {
	public static final DBCollection userCollection = DAO.database
			.getCollection("test");
	public static final JacksonDBCollection<User, String> userCollectionJackson = JacksonDBCollection
			.wrap(userCollection, User.class, String.class);

	public static void main(String[] args) {

		new Thread(new ThreadTest()).start();
//		 new Thread(new ThreadTest()).start();
//		 new Thread(new ThreadTest()).start();
//		 new Thread(new ThreadTest()).start();
//		 new Thread(new ThreadTest()).start();
//		 new Thread(new ThreadTest()).start();
//		 new Thread(new ThreadTest()).start();
//		 new Thread(new ThreadTest()).start();
//		 new Thread(new ThreadTest()).start();

	}
}
