
package com.pencho.pai.views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object post extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Post -->
<h1>--------------------------------------------->>> Post >>></h1>


<h4> 	>>Create Post</h4>
<br/>	>>URL :POST	/post/create
<br/>	>>Required Parameter :
<br/>	>>Return value :Post information
<br/>	>>Description :
<br/>
Create Post :	
		<form method="POST" action="/post/create">
pictureID:
			<input type="text" name="pictureID"> 
videoID:
			<input type="text" name="videoID"> 
description:
			<input type="text" name="description"> 
isPublic:	 true or false
			<input type="text" name="isPublic">
showOff: true or false
			<input type="text" name="showOff">

Categories:
			<input type="text" name="categories">
brand:
			<input type="text" name="brand">
tag1:
			<input type="text" name="tag1">
tag2:
			<input type="text" name="tag2">
tag3:
			<input type="text" name="tag3">

			<input type="submit" value="Create" >
		</form>

<h4> 	>>Edit Post</h4>
<br/>	>>URL :POST	/post/edit
<br/>	>>Required Parameter :
<br/>	>>Return value :Post information
<br/>	>>Description :
<br/>
edit Post :	
		<form method="POST" action="/post/edit">
pictureID:
			<input type="text" name="pictureID"> 
videoID:
			<input type="text" name="videoID"> 
description:
			<input type="text" name="description"> 
isPublic:	 true or false
			<input type="text" name="isPublic">
showOff: true or false
			<input type="text" name="showOff">

Categories:
			<input type="text" name="categories">
brand:
			<input type="text" name="brand">
tag1:
			<input type="text" name="tag1">
tag2:
			<input type="text" name="tag2">
tag3:
			<input type="text" name="tag3">

			<input type="submit" value="Edit" >
		</form>
		
<h4> 	>>delete post </h4>
<br/>	>>URL :POST	/post/delete
<br/>	>>Required Parameter :
<br/>	>>Return value :
<br/>	>>Description :
<br/>
delete post :	
		<form method="POST" action="/post/delete">
id:	
			<input type="text" name="id">		
			<input type="submit" value="delete" >
		</form>
		
		
<h4> 	>>get all public post</h4>
<br/>	>>URL :GET	/post/getPublic
<br/>	>>Required Parameter :
<br/>	>>Return value :Post information
<br/>	>>Description :
<br/>
get all post form userID :	
		<form method="GET" action="/post/getPublic">
start:		<input type="text" name="start">
end:		<input type="text" name="end">	
			<input type="submit" name="get" >
		</form>
		
<h4> 	>>get all follower post</h4>
<br/>	>>URL :GET	/post/getFollower
<br/>	>>Required Parameter :
<br/>	>>Return value :Post information
<br/>	>>Description :
<br/>
get all follower post :	
		<form method="GET" action="/post/getFollower">
start:		<input type="text" name="start">
end:		<input type="text" name="end">	
			<input type="submit" name="get" >
		</form>
		
<h4> 	>>get all friend post</h4>
<br/>	>>URL :GET	/post/getFriend
<br/>	>>Required Parameter :
<br/>	>>Return value :Post information
<br/>	>>Description :
<br/>
get all friend post :	
		<form method="GET" action="/post/getFriend">
start:		<input type="text" name="start">
end:		<input type="text" name="end">	
			<input type="submit" name="get" >
		</form>
		

<h4> 	>>get ShowOff post form userID</h4>
<br/>	>>URL :GET	/post/getShowOff
<br/>	>>Required Parameter :
<br/>	>>Return value :Post information
<br/>	>>Description :
<br/>
ShowOff post form userID :	
		<form method="GET" action="/post/getShowOff">
userid:		<input type="text" name="userID">
start:		<input type="text" name="start">
end:		<input type="text" name="end">	
			<input type="submit" name="get" >
		</form>
		
		
<h4> 	>>get all post form userID if your or friend you get public and private else you get public</h4>
<br/>	>>URL :GET	/post/getAllFromUserID
<br/>	>>Required Parameter :
<br/>	>>Return value :Post information
<br/>	>>Description :
<br/>
get all post form userID :	
		<form method="GET" action="/post/getAllFromUserID">
userid:		<input type="text" name="userID">
start:		<input type="text" name="start">
end:		<input type="text" name="end">	
			<input type="submit" name="get" >
		</form>
		
		
<h4> 	>>if u like this Post or not</h4>
<br/>	>>URL :"POST"	/post/like
<br/>	>>Required Parameter :
<br/>	>>Return value :Post information
<br/>	>>Description :like value 0 or 1
<br/>
Find Post :	
		<form method="POST" action="/post/like">
PostID:	<input type="text" name="id">
like:		<input type="text" name="isLike">
			<input type="submit" value="like/unlike" >
		</form>


<h4> 	>>get one Post</h4>
<br/>	>>URL :GET	/post/get
<br/>	>>Required Parameter :
<br/>	>>Return value :Post information
<br/>	>>Description :
<br/>
Find Post :	
		<form method="GET" action="/post/get">
postID:	<input type="text" name="postID">
			<input type="submit" value="get" >
		</form>







"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Feb 24 09:58:27 CST 2014
                    SOURCE: /home/aries/git/pai_mongodb/app/com/pencho/pai/views/post.scala.html
                    HASH: 7f3f6ec09c2fea87b96e5c81944f9fdb33a7a00f
                    MATRIX: 869->0
                    LINES: 29->1
                    -- GENERATED --
                */
            