
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
object wardrobe extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Wardrobe -->
<h1>--------------------------------------------->>> Wardrobe >>></h1>


<h4> 	>>Create Wardrobe</h4>
<br/>	>>URL :POST	/wardrobe/create
<br/>	>>Required Parameter :
<br/>	>>Return value :snapshot information
<br/>	>>Description :
<br/>
Create Wardrobe :	
		<form method="POST" action="/wardrobe/create">
pictureID:
			<input type="text" name="pictureID"> 
isPublic:	 true or false
			<input type="text" name="isPublic">
isOnlyMe:	 true or false
			<input type="text" name="isOnlyMe">
categories:	
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

<h4> 	>>get Wardrobe form userID</h4>
<br/>	>>URL :GET	/wardrobe/getByUserID
<br/>	>>Required Parameter :
<br/>	>>Return value :Post information 
<br/>	>>Description :
<br/>
Wardrobe form userID :	
		<form method="GET" action="/wardrobe/getByUserID">
userid:		<input type="text" name="userID">
start:		<input type="text" name="start">
end:		<input type="text" name="end">	
			<input type="submit" name="get" >
		</form>
		
<h4> 	>>if u like this Wardrobe or not</h4>
<br/>	>>URL :"POST"	/wardrobe/like
<br/>	>>Required Parameter :
<br/>	>>Return value :Post information
<br/>	>>Description :like value 0 or 1
<br/>	
		<form method="POST" action="/wardrobe/like">
WardrobeID:	<input type="text" name="id">
like:		<input type="text" name="isLike">
			<input type="submit" value="like/unlike" >
		</form>
		
		
<h4> 	>>delete this Wardrobe</h4>
<br/>	>>URL :"POST"	/wardrobe/destroy
<br/>	>>Required Parameter :
<br/>	>>Return value :
<br/>	>>Description :
<br/>	
		<form method="POST" action="/wardrobe/destroy">
WardrobeID:	<input type="text" name="id">
			<input type="submit" value="delete" >
		</form>
		
<h4> 	>>get one wardrobe</h4>
<br/>	>>URL :GET	/wardrobe/get
<br/>	>>Required Parameter :
<br/>	>>Return value :Post information
<br/>	>>Description :
<br/>
Find wardrobe :	
		<form method="GET" action="/wardrobe/get">
wardrobeID:	<input type="text" name="wardrobeID">
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
                    SOURCE: /home/aries/git/pai_mongodb/app/com/pencho/pai/views/wardrobe.scala.html
                    HASH: 9c34c406e271ac71472b40dcab4d256bb5e53c7e
                    MATRIX: 873->0
                    LINES: 29->1
                    -- GENERATED --
                */
            