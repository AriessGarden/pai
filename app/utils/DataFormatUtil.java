package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import play.libs.Json;
import scala.util.parsing.json.JSONArray;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class DataFormatUtil {
	public static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	/**
	 * transform object to string and null to ""
	 */
	public static String objectToString(Object object) {
		if (object != null)
			return object.toString();
		else
			return "";
	}

	/**
	 * get the current date in the good format
	 */
	public static String getNow() {
		Calendar c1 = Calendar.getInstance();
		return sdf.format(c1.getTime());
	}

	/**
	 * change java Date to string format
	 */
	public static String dateToString(Date date) {
		if (date != null)
			return sdf.format(date);
		return "";
	}

	/**
	 * transform obj data to jsend status and data
	 */
	public static ObjectNode toJsend(String status, ObjectNode data) {
		ObjectNode result = Json.newObject();
		result.put("status", status);
		if (data == null)// don't display the master group
			result.put("data", "");
		else
			result.put("data", data);
		return result;
	}

	/**
	 * transform string data to jsend status and data
	 */
	public static ObjectNode toJsend(String status, String data) {
		ObjectNode result = Json.newObject();
		result.put("status", status);
		result.put("data", data);
		return result;
	}

	/**
	 * transform string data to jsend status and data and feed data
	 */
	public static ObjectNode toJsend(String status, String dataname,
			ObjectNode data) {
		ObjectNode result = Json.newObject();
		ObjectNode dataResult = Json.newObject();

		if (data == null)// don't display the master or system
			dataResult.put(dataname, "");
		else
			dataResult.put(dataname, data);

		result.put("status", status);
		result.put("data", dataResult);
		return result;
	}

	/**
	 * transform string data to jsend status and arraydata and feed data
	 */
	public static ObjectNode toJsend(String status, String dataname,
			ArrayNode data) {
		ObjectNode result = Json.newObject();
		ObjectNode dataResult = Json.newObject();
		if (data.size() > 0)// if data
			if (data.get(0) == null)// don't display the master or system (obj 1
									// of array is null)
				data.remove(0);
		dataResult.putArray(dataname).addAll(data);

		result.put("status", status);
		result.put("data", dataResult);
		return result;
	}

	/**
	 * transform string data to jsend status and data and feed data
	 */
	public static ObjectNode toJsend(String status, String dataname, String data) {
		ObjectNode result = Json.newObject();
		ObjectNode dataResult = Json.newObject();

		dataResult.put(dataname, data);

		result.put("status", status);
		result.put("data", dataResult);
		return result;
	}

	/**
	 * transform string data to jsend status and arraydata and feed data
	 */
	public static ObjectNode toJsend(String status, String dataname,
			ArrayNode data, String dataname2, int data2) {
		ObjectNode result = Json.newObject();
		ObjectNode dataResult = Json.newObject();
		if (data.size() > 0)// if data
			if (data.get(0) == null)// don't display the master or system (obj 0
									// of array is null)
				data.remove(0);

		dataResult.putArray(dataname).addAll(data);
		dataResult.put(dataname2, data2);
		result.put("status", status);
		result.put("data", dataResult);
		return result;
	}

	/**
	 * transform string data to jsend status and arraydata and feed data
	 */
	public static ObjectNode toJsend(String status, String dataname,
			String data, String dataname2, int data2) {
		ObjectNode result = Json.newObject();
		ObjectNode dataResult = Json.newObject();

		dataResult.put(dataname, data);
		dataResult.put(dataname2, data2);
		result.put("status", status);
		result.put("data", dataResult);
		return result;
	}

	// with long
	/**
	 * transform string data to jsend status and arraydata and feed data
	 */
	public static ObjectNode toJsend(String status, String dataname,
			ArrayNode data, String dataname2, long data2) {
		ObjectNode result = Json.newObject();
		ObjectNode dataResult = Json.newObject();
		if (data.size() > 0)// if data
			if (data.get(0) == null)// don't display the master or system (obj 0
									// of array is null)
				data.remove(0);

		dataResult.putArray(dataname).addAll(data);
		dataResult.put(dataname2, data2);
		result.put("status", status);
		result.put("data", dataResult);
		return result;
	}

	/**
	 * transform string data to jsend status and arraydata and feed data
	 */
	public static ObjectNode toJsend(String status, String dataname,
			String data, String dataname2, long data2) {
		ObjectNode result = Json.newObject();
		ObjectNode dataResult = Json.newObject();

		dataResult.put(dataname, data);
		dataResult.put(dataname2, data2);
		result.put("status", status);
		result.put("data", dataResult);
		return result;
	}

	/**
	 * transform string data to jsend status and arraydata and feed data
	 */
	public static ObjectNode toJsend(String status, String dataname,
			JSONArray data) {
		ObjectNode result = Json.newObject();
		ObjectNode dataResult = Json.newObject();

		dataResult.put(dataname, data.toString());
		result.put("status", status);
		result.put("data", dataResult);
		return result;
	}

	public static double distance(double xa, double xb, double ya, double yb) {

		return Math.sqrt((xa - xb) * (ya - yb) - (ya - yb) * (ya - yb));

	}

	/*
	 * Calculate distance between two points in latitude and longitude taking
	 * into account height difference. If you are not interested in height
	 * difference pass 0.0. Uses Haversine method as its base.
	 * 
	 * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
	 * el2 End altitude in meters
	 */
	public static double distance(double lat1, double lat2, double lon1,
			double lon2, double el1, double el2) {

		final int R = 6371; // Radius of the earth

		Double latDistance = deg2rad(lat2 - lat1);
		Double lonDistance = deg2rad(lon2 - lon1);
		Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
				* Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000; // convert to meters

		// double height = el1 - el2;
		// distance = Math.pow(distance, 2) + Math.pow(height, 2);
		return distance;
	}

	/**
	 * 4 change
	 * 
	 * @author aries
	 * @param deg
	 * @return
	 */
	public static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

}
