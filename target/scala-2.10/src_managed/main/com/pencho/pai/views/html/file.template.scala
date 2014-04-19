
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
object file extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> File -->
<h1>--------------------------------------------->>> File >>></h1>
    
    
<h4> 	>>Get file</h4>
<br/>	>>URL :GET	/file/:fileType/:fileID+ExtName
<br/>	>>Required Parameter :/file/fileType/fileID+ExtName
<br/>	>>Return value :FileStream
<br/>	>>Description :Any downloaded file except text must ask for this URL with fileID!
<br/>


<h4> 	>>Upload File</h4>
<br/>	>>URL :POST	/file/videos/new
<br/>	>>Required Parameter :a File
<br/>	>>Return value :FileName or status
<br/>	>>Description :Any uploaded file except text must ask for this URL then take this fileID back to the owner!
						And give me the thumbnail size u want.
<br/>
		<form action="file/videos/new" method="POST" enctype="multipart/form-data">
Upload file video:
      		<input type="file" name="file" />
    		<button type="submit">Upload</button>
   		</form>
   		
   		
<h4> 	>>Get file list of current user</h4>
<br/>	>>URL :GET	file/videos/mine
<br/>	>>Required Parameter :
<br/>	>>Return value :File-list
<br/>	>>Description :
<br/>
		<form method="GET" action="file/videos/mine">
See all your video:
			<button type="submit">My videos</button>
		</form>


<h4> 	>>Delete file</h4>
<br/>	>>URL :POST /file/videos/destroy/fileID+ExtName
<br/>	>>Required Parameter :fileID+ExtName
<br/>	>>Return value :fileType or status
<br/>	>>Description :Name mustn't be blank!
<br/>
See delete one of your videos   	
   		<script type="text/javascript"> 
   	    	function goDeleteVideos () """),format.raw/*47.37*/("""{"""),format.raw/*47.38*/("""
				document.deleteVideos.action="file/videos/destroy/"+
												document.deleteVideos.elements["filedelete"].value;
				return true; """),format.raw/*50.18*/("""}"""),format.raw/*50.19*/("""
		</script>
		
		<form name="deleteVideos" method="POST" onsubmit="return goDeleteVideos();" >
video Name : 
			<input type="text" name="filedelete">
			<button type="submit">Delete My videos</button>
    	</form>
    
    
<h4> 	>>Upload File</h4>
<br/>	>>URL :POST	/file/sounds/new
<br/>	>>Required Parameter :a File
<br/>	>>Return value :FileName or status
<br/>	>>Description :Any uploaded file except text must ask for this URL then take this fileID back to the owner!
<br/>
    	<form action="file/sounds/new" method="POST" enctype="multipart/form-data">
Upload file sounds:
      		<input type="file" name="file" />
    		<button type="submit">Upload</button>
   		</form>
   	
   	
<h4> 	>>Get file list of current user</h4>
<br/>	>>URL :GET	file/sounds/mine
<br/>	>>Required Parameter :
<br/>	>>Return value :File-list
<br/>	>>Description :
<br/>
   		<form method="GET" action="file/sounds/mine">
See all your sounds:
       		<button type="submit">My sounds</button>
    	</form>
   	
   		<script type="text/javascript"> 
   	    	function goDeleteSounds () """),format.raw/*85.37*/("""{"""),format.raw/*85.38*/("""
		  		document.deleteSounds.action="file/sounds/destroy/"+  
		  										document.deleteSounds.elements["filedelete"].value;
				return true; """),format.raw/*88.18*/("""}"""),format.raw/*88.19*/("""
		</script>
	
	
<h4> 	>>Delete file</h4>
<br/>	>>URL :POST /file/sounds/destroy/fileID+ExtName
<br/>	>>Required Parameter :fileID+ExtName
<br/>	>>Return value :fileType or status
<br/>	>>Description :Name mustn't be blank!
<br/>	
See delete one of your sounds 
		<script type="text/javascript"> 
   	    	function goDeleteSounds () """),format.raw/*100.37*/("""{"""),format.raw/*100.38*/("""
				document.deleteSounds.action="file/sounds/destroy/"+
												document.deleteSounds.elements["filedelete"].value;
				return true; """),format.raw/*103.18*/("""}"""),format.raw/*103.19*/("""
		</script>
   		<form name="deleteSounds" method="POST" onsubmit="return goDeleteSounds();" >
sound Name: 
			<input type="text" name="filedelete">
       		<button type="submit">Delete My sounds</button>
    	</form>
        	
     
<h4> 	>>Upload File</h4>
<br/>	>>URL :POST	/file/pictures/new
<br/>	>>Required Parameter :a File
<br/>	>>Return value :FileName or status
<br/>	>>Description :Any uploaded file except text must ask for this URL then take this fileID back to the owner!
<br/>      	
    	<form action="file/pictures/new" method="POST" enctype="multipart/form-data">
Upload file pictures:
      		<input type="file" name="file" />
    		<button type="submit">Upload</button>
   		</form>
   	
   	
<h4> 	>>Get file list of current user</h4>
<br/>	>>URL :GET	file/pictures/mine
<br/>	>>Required Parameter :
<br/>	>>Return value :File-list
<br/>	>>Description :
<br/>  	
   		<form method="GET" action="file/pictures/mine">
See all your pictures:    
       		<button type="submit">My pictures</button>
    	</form>
   	
   	
<h4> 	>>Delete file</h4>
<br/>	>>URL :POST /file/pictures/destroy/fileID+ExtName
<br/>	>>Required Parameter :fileID+ExtName
<br/>	>>Return value :fileType or status
<br/>	>>Description :Name mustn't be blank!
<br/>
   		<script type="text/javascript"> 
   	    	function goDeletePicture () """),format.raw/*144.38*/("""{"""),format.raw/*144.39*/("""
		 		document.deletePicture.action="file/pictures/destroy/"+  
		 										document.deletePicture.elements["filedelete"].value;
				return true; """),format.raw/*147.18*/("""}"""),format.raw/*147.19*/("""
		</script>
See delete one of your picture:		
   		<form name="deletePicture" method="POST" onsubmit="return goDeletePicture();" >
picture Name : 
			<input type="text" name="filedelete">
       		<button type="submit">Delete My pictures</button>
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
                    SOURCE: /home/aries/git/pai_mongodb/app/com/pencho/pai/views/file.scala.html
                    HASH: 8a1ce1c1b876143250abdbf9ae14478b2d2e54bd
                    MATRIX: 869->0|2489->1592|2518->1593|2685->1732|2714->1733|3813->2804|3842->2805|4015->2950|4044->2951|4406->3284|4436->3285|4604->3424|4634->3425|5994->4756|6024->4757|6200->4904|6230->4905
                    LINES: 29->1|75->47|75->47|78->50|78->50|113->85|113->85|116->88|116->88|128->100|128->100|131->103|131->103|172->144|172->144|175->147|175->147
                    -- GENERATED --
                */
            