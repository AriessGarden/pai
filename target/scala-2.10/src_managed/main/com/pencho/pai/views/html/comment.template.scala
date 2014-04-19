
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
object comment extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Comment -->
<h1>--------------------------------------------->>> Comment >>></h1>


<h4> 	>>Create Comment</h4>
<br/>	>>URL :POST	/comment/create
<br/>	>>Required Parameter :
<br/>	>>Return value :comment information
<br/>	>>Description :
<br/>
Create comment :	
		<form method="POST" action="/comment/create">
helpID	
			<input type="text" name="helpID">
productID	
			<input type="text" name="productID">
postID	
			<input type="text" name="postID">
pictureID:
			<input type="text" name="pictureID"> 
videoID:
			<input type="text" name="videoID"> 
audioID:
			<input type="text" name="audioID"> 
description:
			<input type="text" name="description"> 
			<input type="submit" value="CreateComment" >
		</form>
		

<h4> 	>>Edit Comment</h4>
<br/>	>>URL :POST	/comment/edit
<br/>	>>Required Parameter :
<br/>	>>Return value :comment information
<br/>	>>Description :
<br/>
Edit comment :	
		<form method="POST" action="/comment/edit">
comment id :
			<input type="text" name="id">
helpID	
			<input type="text" name="helpID">
productID	
			<input type="text" name="productID">
postID	
			<input type="text" name="postID">
pictureID:
			<input type="text" name="pictureID"> 
videoID:
			<input type="text" name="videoID"> 
audioID:
			<input type="text" name="audioID"> 
description:
			<input type="text" name="description"> 
			<input type="submit" value="EditComment" >
		</form>
		

<h4> 	>>Delete Comment</h4>
<br/>	>>URL :POST	/comment/delete
<br/>	>>Required Parameter :
<br/>	>>Return value :comment information
<br/>	>>Description :
<br/>
Delete comment :	
		<form method="POST" action="/comment/delete">
commentID:
			<input type="text" name="id"> 
			<input type="submit" value="Delete" >
		</form>
		

<h4> 	>>Get all comment of current user</h4>
<br/>	>>URL :GET	/comment/findByUserID
<br/>	>>Required Parameter :
<br/>	>>Return value :comments information
<br/>	>>Description :
<br/>
		<form method="GET" action="/comment/findByUserID">
Find all my comments:
Range from :		<input type="text" name="start" >
to :				<input type="text" name="end" >
    		<input type="submit" value= FindCommentsByUserID>
    	</form>
    	

<h4> 	>>Get comments by help id</h4>
<br/>	>>URL :GET	/comment/findByHelpID
<br/>	>>Required Parameter :HelpID
<br/>	>>Return value :comments information
<br/>	>>Description :
<br/>
		<form method="GET" action="/comment/findByHelpID">
Find all  comments of Help :
HelpID:			<input type="text" name="helpID"> 
Range from :	<input type="text" name="start" >
to :			<input type="text" name="end" >
			<input type="submit" value= FindCommentsByHelpID>
		</form> 
<br />


<h4> 	>>Get comments by product id</h4>
<br/>	>>URL :GET	/comment/findByProductID
<br/>	>>Required Parameter :ProductID
<br/>	>>Return value :comments information
<br/>	>>Description :
<br/>
		<form method="GET" action="/comment/findByProductID">
Find all  comments of Product :
ProductID:			<input type="text" name="productID"> 
Range from :	<input type="text" name="start" >
to :			<input type="text" name="end" >
			<input type="submit" value= FindCommentsByProductID>
		</form> 
<br />


<h4> 	>>Get comments by post id</h4>
<br/>	>>URL :GET	/comment/findByPostID
<br/>	>>Required Parameter :PostID
<br/>	>>Return value :comments information
<br/>	>>Description :
<br/>
		<form method="GET" action="/comment/findByPostID">
Find all  comments of post :
postID:			<input type="text" name="postID"> 
Range from :	<input type="text" name="start" >
to :			<input type="text" name="end" >
			<input type="submit" value= FindCommentsByPostID>
		</form> 
<br />








"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Feb 24 09:58:27 CST 2014
                    SOURCE: /home/aries/git/pai_mongodb/app/com/pencho/pai/views/comment.scala.html
                    HASH: d235fcddc4bde176bbaef4b5aaa697fc95dc4418
                    MATRIX: 872->0
                    LINES: 29->1
                    -- GENERATED --
                */
            