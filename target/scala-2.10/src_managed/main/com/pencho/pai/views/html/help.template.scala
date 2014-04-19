
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
object help extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Help -->
<h1>--------------------------------------------->>> Help >>></h1>


<h4> 	>>Create Help</h4>
<br/>	>>URL :POST	/help/create
<br/>	>>Required Parameter :
<br/>	>>Return value :help information
<br/>	>>Description :
<br/>
Create help :	

		<form method="POST" action="/help/create">
pictureID:
			<input type="text" name="pictureID"> 
			
description:
			<input type="text" name="description"> 
			<input type="submit" value="CreateHelp" >
		</form>

<h4> 	>>Edit Help</h4>
<br/>	>>URL :POST	/help/edit
<br/>	>>Required Parameter :
<br/>	>>Return value :help information
<br/>	>>Description :
<br/>
edit help :	

		<form method="POST" action="/help/edit">
pictureID:
			<input type="text" name="pictureID"> 
			
description:
			<input type="text" name="description"> 
			<input type="submit" value="Edit" >
		</form>
		
<h4> 	>>delete help </h4>
<br/>	>>URL :POST	/help/delete
<br/>	>>Required Parameter :
<br/>	>>Return value :
<br/>	>>Description :
<br/>
delete help :	
		<form method="POST" action="/help/delete">
id:	
			<input type="text" name="id">		
			<input type="submit" value="delete" >
		</form>
		

Retrieve help :

<h4> 	>>Get help by username</h4>
<br/>	>>URL :GET	/help/findByUsername
<br/>	>>Required Parameter : username
<br/>	>>Return value :helps information
<br/>	>>Description :
<br/>
		<form method="GET" action="/help/findByUsername">
Find all my helps:
Username :		<input type="text" name="username" >
    		<input type="submit" value= "FindHelpsByUsername">
    	</form>
<br/>

Delete help :	

		<form method="get" action="/help/delete">
helpID	
			<input type="text" name="helpID">
			<input type="submit" value="DeleteHelp" >
		</form>	
<br/>
<br/>

get help :
<h4> 	>>Get helps </h4>
<br/>	>>URL :GET	/help/get
<br/>	>>Required Parameter :
<br/>	>>Return value :helps information
<br/>	>>Description :
<br/>
		<form method="GET" action="/help/get">
Range from :	<input type="text" name="start" >
to :			<input type="text" name="end" >
			<input type="submit" value= GetHelp>
		</form> 
<br />

save help :

<h4> 	>>Save help</h4>
<br/>	>>URL :POST	/help/saveHelp
<br/>	>>Required Parameter :id
<br/>	>>Return value :helps information
<br/>	>>Description :
<br/>
		<form method="POST" action="/help/saveHelp">
id :	<input type="text" name="id" >
			<input type="submit" value= Save>
		</form> 
<br />


unsave help :

<h4> 	>>unsave help</h4>
<br/>	>>URL :POST	/help/unsaveHelp
<br/>	>>Required Parameter :id
<br/>	>>Return value :status
<br/>	>>Description :
<br/>
		<form method="POST" action="/help/unsaveHelp">
id :	<input type="text" name="id" >
			<input type="submit" value= remove>
		</form> 
<br />


get saved help :

<h4> 	>>Get helps save by you</h4>
<br/>	>>URL :GET	/help/getSavedHelp
<br/>	>>Required Parameter :
<br/>	>>Return value :helps information
<br/>	>>Description :
<br/>
		<form method="GET" action="/help/getSavedHelp">
			<input type="submit" value= GetSavedHelp>
		</form> 
<br />

<h4> 	>>if u like this help</h4>
<br/>	>>URL :"POST"	/help/like
<br/>	>>Required Parameter :
<br/>	>>Return value :help information
<br/>	>>Description :like value 0 or 1
<br/>
Like this help :	
		<form method="POST" action="/help/like">
helpID:	<input type="text" name="id">
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
                    SOURCE: /home/aries/git/pai_mongodb/app/com/pencho/pai/views/help.scala.html
                    HASH: 174d9d6995a915e8421461e38f460ff9b3dfbadd
                    MATRIX: 869->0
                    LINES: 29->1
                    -- GENERATED --
                */
            