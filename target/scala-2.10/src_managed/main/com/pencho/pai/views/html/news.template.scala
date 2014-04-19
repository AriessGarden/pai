
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
object news extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> news -->
<h1>--------------------------------------------->>> news >>></h1>


<h4> 	>>Create news</h4>
<br/>	>>URL :POST	/news/create
<br/>	>>Required Parameter :
<br/>	>>Return value :news information
<br/>	>>Description :
<br/>
Create news :	
		<form method="POST" action="/news/create">
pictureID:
			<input type="text" name="pictureID"> 
videoID:
			<input type="text" name="videoID"> 
newsText:
			<input type="text" name="newsText"> 
ifLiked
			<input type="text" name="ifLiked">

			<input type="submit" value="CreateNews" >
		</form>

 
<h4> 	>>Get news </h4>
<br/>	>>URL :GET	/news/get
<br/>	>>Required Parameter :start, end
<br/>	>>Return value :news information
<br/>	>>Description :
<br/>
		<form method="GET" action="/news/get">

Range from :	<input type="text" name="start" >
to :			<input type="text" name="end" >
			<input type="submit" value="get news">
		</form> 
<br />

 
    	
 <h4> 	>>if u like this news or not</h4>
<br/>	>>URL :"POST"	/news/like
<br/>	>>Required Parameter :
<br/>	>>Return value :news information
<br/>	>>Description :like value 0 or 1
<br/>
		
Find product :	
		<form  method="POST" action="/news/like">
newsID:	<input type="text" name="id">
like:		<input type="text" name="isLike">
			<input type="submit" value="like/unlike" >
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
                    SOURCE: /home/aries/git/pai_mongodb/app/com/pencho/pai/views/news.scala.html
                    HASH: 13f21c64702125367055443cedb89b1df490633f
                    MATRIX: 869->0
                    LINES: 29->1
                    -- GENERATED --
                */
            