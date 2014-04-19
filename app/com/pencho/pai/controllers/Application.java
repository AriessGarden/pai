package com.pencho.pai.controllers;

import static play.data.Form.form;

import com.pencho.pai.models.User;
import com.pencho.pai.views.html.comment;
import com.pencho.pai.views.html.file;
import com.pencho.pai.views.html.help;
import com.pencho.pai.views.html.index;
import com.pencho.pai.views.html.news;
import com.pencho.pai.views.html.post;
import com.pencho.pai.views.html.product;
import com.pencho.pai.views.html.shop;
import com.pencho.pai.views.html.user;
import com.pencho.pai.views.html.message;
import com.pencho.pai.views.html.wholeSale;
import com.pencho.pai.views.html.snapShot;
import com.pencho.pai.views.html.search;
import com.pencho.pai.views.html.share;
import com.pencho.pai.views.html.wardrobe;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import utils.DataFormatUtil;
import utils.SecurityUtil;

public class Application extends Controller {

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	/**
	 * 4 view
	 * 
	 * @author Aries
	 * @return a page
	 */
	public static Result user() {
		return ok(user.render());
	}

	/**
	 * 4 view
	 * 
	 * @author Aries
	 * @return a page
	 */
	public static Result shop() {
		return ok(shop.render());
	}

	/**
	 * 4 view
	 * 
	 * @author Aries
	 * @return a page
	 */
	public static Result product() {
		return ok(product.render());
	}

	/**
	 * 4 view
	 * 
	 * @author Aries
	 * @return a page
	 */
	public static Result comment() {
		return ok(comment.render());
	}

	/**
	 * 4 view
	 * 
	 * @author Aries
	 * @return a page
	 */
	public static Result help() {
		return ok(help.render());
	}

	/**
	 * 4 view
	 * 
	 * @author Aries
	 * @return a page
	 */
	public static Result news() {
		return ok(news.render());
	}

	/**
	 * 4 view
	 * 
	 * @author Aries
	 * @return a page
	 */
	public static Result post() {
		return ok(post.render());
	}

	/**
	 * 4 view
	 * 
	 * @author Aries
	 * @return a page
	 */
	public static Result file() {
		return ok(file.render());
	}

	/**
	 * 4 view
	 * 
	 * @author Bill
	 * @return a page
	 * 
	 */
	public static Result search() {
		return ok(search.render());
	}

	/**
	 * 4 view
	 * 
	 * @author sandy
	 * @return a page
	 */
	public static Result message() {
		return ok(message.render());
	}

	/**
	 * 4 view
	 * 
	 * @author sandy
	 * @return a page
	 */
	public static Result snapShot() {
		return ok(snapShot.render());
	}

	/**
	 * 4 view
	 * 
	 * @author sandy
	 * @return a page
	 */
	public static Result wholeSale() {
		return ok(wholeSale.render());
	}

	/**
	 * 4 view
	 * 
	 * @author sandy
	 * @return a page
	 */
	public static Result share() {
		return ok(share.render());
	}

	/**
	 * 4 view
	 * 
	 * @author sandy
	 * @return a page
	 */
	public static Result wardrobe() {
		return ok(wardrobe.render());
	}

	/**
	 * 4 login parameter
	 * 
	 * @author Aries
	 */
	public static class Login {
		public String phone;

		public String password;

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}

	/**
	 * @author Aries
	 * @return
	 */
	public static Result login() {

		Form<Login> loginForm = form(Login.class).bindFromRequest();
		if (loginForm.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "in parameter"));

		User user = UserController.findByPhone(loginForm.get().getPhone());

		if (user == null)
			return ok(DataFormatUtil.toJsend("fail", "you don't exist "));

		if (!user.getSignup())
			return ok(DataFormatUtil.toJsend("fail", "sign up first!"));

		user = UserController.authenticate(loginForm.get().getPhone(),
				loginForm.get().getPassword());

		if (user == null)
			return ok(DataFormatUtil.toJsend("fail", "wrong psw"));

		if (!user.getValidated())
			return ok(DataFormatUtil.toJsend("fail", "Activate first!"));

		session("id", user.getId() + "");
		session("expire", SecurityUtil.getExpire(60 * 24 * 7));
		return ok(DataFormatUtil.toJsend("success", "user", user.toJson()));

	}

	/**
	 * Logout and clean the session.
	 * 
	 * @author Aries
	 * @return
	 */
	public static Result logout() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "u logout already!"));
		session().clear();
		return ok(DataFormatUtil.toJsend("success", ""));
	}

	/**
	 * Show if you are login. look in the cookie
	 * 
	 * @author Ari
	 * @return
	 */
	public static Result MyStatus() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		return ok(DataFormatUtil.toJsend("success", "user id = "
				+ session().get("id") + ", expire = " + session().get("expire")
				+ ", now is = " + DataFormatUtil.getNow()));
	}

}
