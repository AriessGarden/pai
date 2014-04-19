
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
object share extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Share -->
<h1>--------------------------------------------->>> Share >>></h1>


<h4> 	>>Share Post</h4>
<br/>	>>URL :POST	/share/post
<br/>	>>Required Parameter :
<br/>	>>Return value :Post information
<br/>	>>Description :
<br/>
Create Post :	
		<form method="POST" action="/share/post">
postID:
			<input type="text" name="id"> 
isPublic:	 true or false
			<input type="text" name="isPublic">
			<input type="submit" value="Share" >
		</form>

<h4> 	>>Share Product</h4>
<br/>	>>URL :POST	/share/product
<br/>	>>Required Parameter :
<br/>	>>Return value :Post information
<br/>	>>Description :
<br/>
Create Post :	
		<form method="POST" action="/share/product">
productID:
			<input type="text" name="id"> 
isPublic:	 true or false
			<input type="text" name="isPublic">
			<input type="submit" value="Share" >
		</form>
		
<h4> 	>>Share SnapShot</h4>
<br/>	>>URL :POST	/share/snapshot
<br/>	>>Required Parameter :
<br/>	>>Return value :Post information
<br/>	>>Description :
<br/>
Create Post :	
		<form method="POST" action="/share/snapshot">
snapshotID:
			<input type="text" name="id"> 
isPublic:	 true or false
			<input type="text" name="isPublic">
			<input type="submit" value="Share" >
		</form>
		
<h4> 	>>Share Wardrobe</h4>
<br/>	>>URL :POST	/share/wardrobe
<br/>	>>Required Parameter :
<br/>	>>Return value :Post information
<br/>	>>Description :
<br/>
Create Post :	
		<form method="POST" action="/share/wardrobe">
wardrobeID:
			<input type="text" name="id"> 
isPublic:	 true or false
			<input type="text" name="isPublic">
			<input type="submit" value="Share" >
		</form>
		
		
<h4> 	>>Get all shared stuff</h4>
<br/>	>>URL :GET	/share/getByUserID
<br/>	>>Required Parameter :userID,type
<br/>	>>Return value :Shared information
<br/>	>>Description : if u don't fullfill this form,means current user(yourself),type default is post.
<br/>
Create Post :	
		<form method="GET" action="/share/getByUserID">
userID:
			<input type="text" name="userID"> 
type:		<input type="text" name="theType">
			<input type="submit" value="Share" >
		</form>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Feb 25 13:55:27 CST 2014
                    SOURCE: /home/aries/git/pai_mongodb/app/com/pencho/pai/views/share.scala.html
                    HASH: 0e4025c536fe585050d7fd1199125aa1a36254fa
                    MATRIX: 870->0
                    LINES: 29->1
                    -- GENERATED --
                */
            