package com.pencho.pai.controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.output.ByteArrayOutputStream;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import utils.DataFormatUtil;
import utils.ImageUtil;
import utils.SecurityUtil;
import utils.VideoUtil;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import com.pencho.pai.dao.DAO;

public class FileManager extends Controller {

	/**
	 * fileType can be videos OR sounds OR pictures
	 * 
	 * @author Aries
	 * @param fileType
	 * @return
	 */
	public static Result createFile(String fileType, int width, int length, int width2,int length2) {

		String userID = session().get("id");

		// if u login
		 if (!SecurityUtil.isLogin() || session().get("id") == null)
		 return ok(DataFormatUtil.toJsend("fail", "login first"));

		try {
			// read request file
			MultipartFormData body = request().body().asMultipartFormData();
			// File obj.
			FilePart inFile = body.getFile("file");
			// File name
			String inFileName = inFile.getFilename();
			String xFileName = inFileName.substring(
					inFileName.lastIndexOf(".") + 1, inFileName.length());
			// Store by GridFS
			GridFS gfsFile = new GridFS(DAO.database, fileType);
			GridFSInputFile in = gfsFile.createFile(inFile.getFile());

			// Create a thumbnail only 4 pictures
			if (fileType.equals("pictures")) {
				System.out.println("----------------------------pict");
				// thumbnail 4 pic
				BufferedImage bufferedImage = ImageIO.read(inFile.getFile());
				ByteArrayOutputStream baos = ImageUtil.scale(bufferedImage,
						width, length, xFileName);
				GridFSInputFile thumbnail = gfsFile.createFile(baos
						.toByteArray());
				thumbnail.put("userID", userID);
				thumbnail.setFilename(in.getId() + ".thumb");
				thumbnail.save();
				
				//thumbnail2 4 pic
				BufferedImage bufferedImage2 = ImageIO.read(inFile.getFile());
				ByteArrayOutputStream baos2 = ImageUtil.scale(bufferedImage,
						width2, length2, xFileName);
				GridFSInputFile thumbnail2 = gfsFile.createFile(baos
						.toByteArray());
				thumbnail2.put("userID", userID);
				thumbnail2.setFilename(in.getId() + ".thumb2");
				thumbnail2.save();

				// Create a thumbnail only 4 videos
			} else if (fileType.equals("videos")) {
				System.out.println("----------------------------videos");
				//Thumbnail
				VideoUtil.transfer(inFile.getFile().getPath(),
						"/home/aries/Data" + in.getId(), width, length);
				GridFSInputFile thumbnail = gfsFile.createFile(new File(
						"/home/aries/Data/" + in.getId()));
				thumbnail.put("userID", userID);
				thumbnail.setFilename(in.getId() + ".thumb");
				thumbnail.save();
				new File("/home/aries/Data/" + in.getId()).delete();
				
				//Thumbnail2
				VideoUtil.transfer(inFile.getFile().getPath(),
						"/home/aries/Data/" + in.getId(), width2, length2);
				GridFSInputFile thumbnail2 = gfsFile.createFile(new File(
						"/home/aries/Data/" + in.getId()));
				thumbnail2.put("userID", userID);
				thumbnail2.setFilename(in.getId() + ".thumb2");
				thumbnail2.save();
				new File("/home/aries/Data/" + in.getId()).delete();
			}

			// all media info
			in.setFilename(in.getId() + "." + xFileName);
			in.put("userID", userID);
			
			in.put("type", inFile.getContentType());
			in.save();

			return ok(DataFormatUtil.toJsend("success", in.getId() + "."
					+ xFileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(DataFormatUtil.toJsend("fail", ""));
	}

	/**
	 * Delete files
	 * 
	 * @author Aries
	 * @param fileType
	 * @param fileName
	 * @return
	 */
	public static Result destroyFile(String fileType, String fileName) {

		// if u login
		 if (!SecurityUtil.isLogin())
		 return ok(DataFormatUtil.toJsend("fail", "login first"));

		String userID = session().get("id");

		if (fileName.trim().equals(""))
			return ok(DataFormatUtil.toJsend("fail",
					"File name mustn't b blank"));

		try {
			GridFS gfsFile = new GridFS(DAO.database, fileType);
			DBCursor results = gfsFile.getFileList();
			DBObject result = results.next();
			if (userID.equals(result.get("userID").toString())
					&& gfsFile.find(fileName).size() != 0) {
				gfsFile.remove(fileName);
				gfsFile.remove(fileName.substring(0, 25) + "thumb");
				return ok(DataFormatUtil.toJsend("success", fileType));
			} else {
				return ok(DataFormatUtil
						.toJsend("message", "File is not exits"));
			}
		} catch (Exception e) {
			return ok(DataFormatUtil.toJsend("fail", "No data now!"));
		}
	}

	/**
	 * Get all files of an user himself
	 * 
	 * @author Aries
	 * @param fileType
	 * @param page
	 * @param nbObjectByPage
	 * @return
	 */
	public static Result getMyFile(String fileType, int page, int nbObjectByPage) {

		// if u login
		 if (!SecurityUtil.isLogin())
		 return ok(DataFormatUtil.toJsend("fail", "login first"));

		String userID = session().get("id");
		ArrayNode dataOfArray = Json.newObject().arrayNode();
		try {
			GridFS gfsFile = new GridFS(DAO.database, fileType);
			DBCursor results = gfsFile.getFileList();
			while (results.hasNext()) {
				DBObject result = results.next();
				if (userID.equals(result.get("userID").toString())) {
					dataOfArray.add(Json.parse(result.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(DataFormatUtil.toJsend("success", fileType, dataOfArray,
				"pageMax", nbObjectByPage));
	}

	/**
	 * @author Aries
	 * @param fileType
	 * @param fileName
	 * @return stream
	 * @throws IOException
	 */
	public static Result getFile(String fileType, String fileName)
			throws IOException {


		try {
			GridFS gfsFile = new GridFS(DAO.database, fileType);
			GridFSDBFile fileForOutput = gfsFile.findOne(fileName);
			
//			String type = fileForOutput.get("type").toString();
//			System.out.print(type+"-----------------------------");
//			String xFileName = fileName.substring(
//					fileName.lastIndexOf(".") + 1, fileName.length());
			return ok(fileForOutput.getInputStream());//.as(type);
		} catch (Exception e) {
			return ok(DataFormatUtil.toJsend("message", fileName + "("
					+ fileType + ")" + " is not exist"));
		}
	}
}
