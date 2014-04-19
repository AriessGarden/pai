
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
object snapShot extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> SnapShot -->
<h1>--------------------------------------------->>> SnapShot >>></h1>


<h4> 	>>Create snapshot</h4>
<br/>	>>URL :POST	/snapshot/create
<br/>	>>Required Parameter :
<br/>	>>Return value :snapshot information
<br/>	>>Description :
<br/>
Create snapshot :	
		<form method="POST" action="/snapshot/create">
pictureID:
			<input type="text" name="pictureID"> 
isPublic:	 true or false
			<input type="text" name="isPublic">
			<input type="submit" value="Create" >
		</form>

<h4> 	>>get snapshot form userID</h4>
<br/>	>>URL :GET	/snapshot/getByUserID
<br/>	>>Required Parameter :
<br/>	>>Return value :Post information 
<br/>	>>Description :
<br/>
snapshot form userID :	
		<form method="GET" action="/snapshot/getByUserID">
userid:		<input type="text" name="userID">
start:		<input type="text" name="start">
end:		<input type="text" name="end">	
			<input type="submit" name="get" >
		</form>
		
<h4> 	>>if u like this snapshot or not</h4>
<br/>	>>URL :"POST"	/snapshot/like
<br/>	>>Required Parameter :
<br/>	>>Return value :Post information
<br/>	>>Description :like value 0 or 1
<br/>
Find Post :	
		<form method="POST" action="/snapshot/like">
snapShotID:	<input type="text" name="id">
like:		<input type="text" name="isLike">
			<input type="submit" value="like/unlike" >
		</form>
		
<h4> 	>>delete this snapshot</h4>
<br/>	>>URL :"POST"	/snapshot/destroy
<br/>	>>Required Parameter :
<br/>	>>Return value :
<br/>	>>Description :
<br/>	
		<form method="POST" action="/snapshot/destroy">
snapshotID:	<input type="text" name="id">
			<input type="submit" value="delete" >
		</form>
		
<h4> 	>>get one snapshot</h4>
<br/>	>>URL :GET	/snapshot/get
<br/>	>>Required Parameter :
<br/>	>>Return value :Post information
<br/>	>>Description :
<br/>
Find wardrobe :	
		<form method="GET" action="/snapshot/get">
snapshotID:	<input type="text" name="snapshotID">
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
                    SOURCE: /home/aries/git/pai_mongodb/app/com/pencho/pai/views/snapShot.scala.html
                    HASH: fb0779b00a673536de2fb459971ce733c861467c
                    MATRIX: 873->0
                    LINES: 29->1
                    -- GENERATED --
                */
            