package utils;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * http://sms.webchinese.cn WebService ,4 send MSG
 * 
 * @author Aries
 * 
 */
public class MsgUtil {

	public static void send(String phone, String number) throws Exception {

		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");
		post.addRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=gbk");
		NameValuePair[] data = {
//				new NameValuePair("Uid", "Aries"),
//				new NameValuePair("Key", "4df64e1a9b5520aeec5c"),// 536620
				new NameValuePair("Uid", "Pencho"),
				new NameValuePair("Key", "e04727a8f4a481b0e477"),// 791228
				new NameValuePair("smsMob", phone),
				new NameValuePair("smsText",
						"verification code: "
								+ number+",u have 3 minutes") };
		post.setRequestBody(data);

		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:" + statusCode);
		for (Header h : headers) {
			System.out.println(h.toString());
		}
		String result = new String(post.getResponseBodyAsString().getBytes(
				"gbk"));
		System.out.println(result);

		post.releaseConnection();
	}
}
