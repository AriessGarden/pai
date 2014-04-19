package utils;

import javapns.back.PushNotificationManager;
import javapns.back.SSLConnectionHelper;
import javapns.data.Device;
import javapns.data.PayLoad;

public class APNSUtil {

	/**
	 * Apns push 4 apple(test).
	 * 
	 * @author aries
	 * @param deviceToken
	 * @param msg
	 * @param badge
	 * @throws Exception
	 */
	public void push(String deviceToken, String msg, int badge)
			throws Exception {
		try {
			// 从客户端获取的deviceToken
			deviceToken = "3fe6356d713da06499fa68e2bec05c0303987cbaf1edf4d9cf21bef33cf0b3fc";
			msg = "我是message";
			badge = 1;

			System.out.println("Push Start deviceToken:" + deviceToken);
			// 定义消息模式
			PayLoad payLoad = new PayLoad();
			payLoad.addAlert(msg);
			payLoad.addBadge(badge);
			payLoad.addSound("default");
			// 注册deviceToken
			PushNotificationManager pushManager = PushNotificationManager
					.getInstance();
			pushManager.addDevice("iPhone", deviceToken);
			// 连接APNS
			String host = "gateway.sandbox.push.apple.com";
			int port = 2195;
			String path = "/home/pencho/workspace/apns_iphone/";
			String certificatePath = (path + "zhengshu.p12");
			// certificatePath 步骤一中生成的*.p12文件位置
			String certificatePassword = "12345";
			pushManager.initializeConnection(host, port, certificatePath,
					certificatePassword,
					SSLConnectionHelper.KEYSTORE_TYPE_PKCS12);
			// 发送推送
			Device client = pushManager.getDevice("iPhone");
			pushManager.sendNotification(client, payLoad);
			// 停止连接APNS
			pushManager.stopConnection();
			// 删除deviceToken
			pushManager.removeDevice("iPhone");
			System.out.println("Push End");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
