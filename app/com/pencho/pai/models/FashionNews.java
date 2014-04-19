package com.pencho.pai.models;

import java.util.HashSet;
import java.util.Set;

import play.libs.Json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pencho.pai.controllers.UserController;

/**
 * 
 * @author Bill
 * 
 */
public class FashionNews {

	@org.mongojack.ObjectId
	@JsonProperty("_id")
	private String id;
	
	private String pictureID = "";
	private String videoID = "";
	private String newsText = "";

	private Set<String> peopleWhoLike = new HashSet<String>();
	private String isLike; // only for bind like value
	private int like = 0;
	
	public ObjectNode toJson() {
		ObjectNode data = Json.newObject();
		data.put("id", id);
		data.put("pictureID", pictureID);
		data.put("newsText", newsText);
		data.put("like", like);
		if(peopleWhoLike.contains(UserController.session().get("id")))
			data.put("ilikeit", "true");
		else
			data.put("ilikeit", "false");
		return data;
	}
	
	public String getPictureID() {
		return pictureID;
	}
	public void setPictureID(String pictureID) {
		this.pictureID = pictureID;
	}
	public String getNewsText() {
		return newsText;
	}
	public void setNewsText(String newsText) {
		this.newsText = newsText;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public String getIsLike() {
		return isLike;
	}
	public String getVideoID() {
		return videoID;
	}
	public void setVideoID(String videoID) {
		this.videoID = videoID;
	}
	public void setIsLike(String isLike) {
		this.isLike = isLike;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Set<String> getPeopleWhoLike() {
		return peopleWhoLike;
	}

	public void setPeopleWhoLike(Set<String> peopleWhoLike) {
		this.peopleWhoLike = peopleWhoLike;
	}
	
}
