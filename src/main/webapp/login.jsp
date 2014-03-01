<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1" />
<meta http-equiv="keywords"
	content="cepis,portal,education,research,information,system" />
<meta http-equiv="description" content="CEPIS 2.x Information System." />
<meta name="copyright" content="&copy; 2012 University of Kentucky" />
<meta name="robots" content="NONE" />
<meta name="author" content="Keerthiram Murugesan" />
<meta http-equiv="expires" content="Mon, 22 Jul 2012 11:12:01 GMT" />
<link rel="shortcut icon"
	href="http://education.uky.edu/sites/all/themes/maincoesite/favicon.ico"
	type="image/x-icon" />
<title>College of Education (CEPIS) - Login</title>
<link
	href="${facesContext.externalContext.requestContextPath}/css/font.css"
	media="screen" rel="stylesheet" type="text/css" />
<link
	href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css" />
<style type="text/css">
img,div {
	behavior: url(/cepis/css/iepngfix.htc)
}

/*----------Text Styles----------*/
.ws6 {
	font-size: 8px;
}

.ws7 {
	font-size: 9.3px;
}

.ws8 {
	font-size: 11px;
}

.ws9 {
	font-size: 12px;
}

.ws10 {
	font-size: 13px;
}

.ws11 {
	font-size: 15px;
}

.ws12 {
	font-size: 16px;
}

.ws14 {
	font-size: 19px;
}

.ws16 {
	font-size: 21px;
}

.ws18 {
	font-size: 24px;
}

.ws20 {
	font-size: 27px;
}

.ws22 {
	font-size: 29px;
}

.ws24 {
	font-size: 32px;
}

.ws26 {
	font-size: 35px;
}

.ws28 {
	font-size: 37px;
}

.ws36 {
	font-size: 48px;
}

.ws48 {
	font-size: 64px;
}

.ws72 {
	font-size: 96px;
}

.wpmd {
	font-size: 13px;
	font-family: 'Arial';
	font-style: normal;
	font-weight: normal;
}

/*----------Para Styles----------*/
DIV,UL,OL /* Left */ {
	margin-top: 0px;
	margin-bottom: 0px;
}

a.style1:link {
	color: #366B96;
	text-decoration: none underline;
}

a.style1:visited {
	color: #366B96;
	text-decoration: none underline;
}

a.style1:active {
	color: #366B96;
	text-decoration: none underline;
}

a.style1:hover {
	color: #333333;
	text-decoration: none;
}

a.style2:link {
	color: #C0C0C0;
	text-decoration: none underline;
}

a.style2:visited {
	color: #C0C0C0;
	text-decoration: none underline;
}

a.style2:active {
	color: #C0C0C0;
	text-decoration: none;
}

a.style2:hover {
	color: #FFFFFF;
	text-decoration: none;
}

div#container {
	position: relative;
	width: 1024px;
	margin-top: 0px;
	margin-left: auto;
	margin-right: auto;
	text-align: left;
}

body {
	text-align: center;
	margin: 0
}
</style>
<script type="text/javascript">
	var _gaq = _gaq || [];
	_gaq.push([ '_setAccount', 'UA-6429061-3' ]);
	_gaq.push([ '_trackPageview' ]);

	(function() {
		var ga = document.createElement('script');
		ga.type = 'text/javascript';
		ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl'
				: 'http://www')
				+ '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(ga, s);
	})();
</script>
</head>

<body background="images/pat2.jpg" bgcolor="#065164"
	onload="javascript:checkVersion()">

	<div id="container">
		<div id="text1"
			style="position: absolute; overflow: hidden; left: 962px; top: 30px; width: -80px; height: 328px; z-index: 0">
		</div>

		<div id="image4"
			style="position: absolute; overflow: hidden; left: 264px; top: 6px; width: 0px; height: 0px; z-index: 1">
			<img src="images/mid3" alt="" border="0px" width="0px" height="0px" />
		</div>

		<div id="image1"
			style="position: absolute; overflow: hidden; left: 0px; top: 0px; width: 1024px; height: 120px; z-index: 2">
			<img src="images/bg_head.jpg" alt="" border="0px" width="1024px" height="120px" />
		</div>

		<div id="image2"
			style="position: absolute; overflow: hidden; left: 0px; top: 156px; width: 1024px; height: 350px; z-index: 3">
			<img src="images/loginPage3.jpg" alt="" border="0px" width="1024px"	height="350px" />
		</div>

		<div id="text2"
			style="position: absolute; overflow: hidden; left: 23px; top: 215px; width: 216px; height: 80px; z-index: 4">
			<div class="wpmd">
				<div>
					<font class="ws9" color="#366B96" face="Tahoma">
						<b>166 Taylor Education Building</b>
					</font>
				</div>
				<div>
					<font class="ws9" color="#366B96" face="Tahoma">
						<b>Lexington, KY 40506-0001</b>
					</font>
				</div>
				<div>
					<font class="ws9" color="#366B96" face="Tahoma">
						<b>(859) 257-7971</b>
					</font>
				</div>
			</div>
		</div>

		<div id="text3"
			style="position: absolute; overflow: hidden; left: 24px; top: 340px; width: 467px; height: 146px; z-index: 5">
			<div class="wpmd">
				<div>
					<font class="ws8" color="#366B96" face="Tahoma">
						<b>For All Users:</b>
					</font>
				</div>
				<div>
					<font class="ws8" color="#333333" face="Tahoma">
						<br /> 
					</font>
				</div>
				<div>
					<font class="ws8" color="#333333" face="Tahoma">
						To access the contents of the CEPIS Information System, 
						all users should login into the system with a valid UKY 
						LinkBlue username &amp;	password (registered in our CEPIS System).
					</font>
				</div>
				<div>
					<font class="ws8" color="#333333" face="Tahoma">
						<br /> 
					</font>
				</div>
				<div>
					<font class="ws8" color="#366B96" face="Tahoma">
						<b>To Request a Login:</b>
					</font>
				</div>
				<div>
					<font class="ws8" color="#333333" face="Tahoma">
						<br /> 
					</font>
				</div>
				<div>
					<font class="ws8" color="#333333" face="Tahoma"> 
						Please contact the above address if you haven't  
						registered your Linkblue username in our CEPIS System. 
					</font>
				</div>
				<div>
					<font class="ws8" color="#333333" face="Tahoma">
						<br /> 
					</font>
				</div>
				<div>
					<font class="ws8" color="#333333" face="Tahoma"><br /> </font>
				</div>
			</div>
		</div>

		<div id="text4"
			style="position: absolute; overflow: hidden; left: 568px; top: 245px; width: 358px; height: 55px; z-index: 6">
			<div class="wpmd">
				<div align="center">
					<font class="ws9" color="#366B96" face="Tahoma">
						<b>Use your 
						<a href="http://www.uky.edu/UKHome/subpages/linkblue.html" target="_blank">
							LinkBlue
						</a> 
						<b>username</b> &amp; 
						<b>password</b>
						to log into the portal.
					</b></font>
				</div>
			</div>
		</div>

		<form name="form1" action="j_spring_security_check" method="post"
			style="margin: 0px">

			<div id="text53"
				style="position: absolute; overflow: hidden; left: 599px; top: 275px; width: 330px; height: 45px; z-index: 11">
				<div class="ws8">
					<div align="center">
						<%
							String login_error_code = request.getParameter("c");
							if (login_error_code != null) {
								if (login_error_code.equals("1")) {
						%>
									<b> 
										<font class="ws8" face="Tahoma" color="RED"> 
											<spring:message code="cepis.portal.msg.badCredentials" />
										</font>
									</b>
						<%
							} else if (login_error_code.equals("2")) {
						%>
								<b> 
									<font class="ws8" face="Tahoma" color="GREEN"> 
										<spring:message	code="cepis.portal.msg.successLogout" />
									</font>
								</b>
						<%
							} else if (login_error_code.equals("3")) {
						%>
								<b> 
									<font class="ws8" face="Tahoma" color="RED"> 
										<spring:message	code="cepis.portal.msg.expiredSession" htmlEscape="false" />
									</font>
								</b>
						<%
							} else if (login_error_code.equals("4")) {
						%>
								<b> 
									<font class="ws8" face="Tahoma" color="RED">
										<spring:message	code="cepis.portal.msg.invalidSession" /> 
									</font>
								</b>
						<%
							}
							}
						%>
					</div>
				</div>
			</div>
			
			<input name='j_username' id="j_username" type='text' 
				style="position: absolute; width: 193px; left: 701px; top: 318px; z-index: 8" />
				
			<input name='j_password' type="password"
				style="position: absolute; width: 195px; left: 699px; top: 354px; z-index: 9" />
				
			<input type="checkbox" name="_spring_security_remember_me"
				style="position: absolute; left: 608px; top: 380px; z-index: 10" />&nbsp;
				
			<input name="formbutton1" type="submit" value="Log In"
				style="position: absolute; left: 700px; top: 413px; z-index: 10" />
				
			<input name="formbutton2" type="reset" value="Clear"
				style="position: absolute; left: 800px; top: 413px; z-index: 14" />
				
			<script type="text/javascript">
				document.getElementById('j_username').focus();
			</script>
		</form>

		<div id="text5"
			style="position: absolute; overflow: hidden; left: 599px; top: 322px; width: 90px; height: 21px; z-index: 11">
			<div class="wpmd">
				<div align="center">
					<font color="#366B96" face="Tahoma"><b>Username:</b></font>
				</div>
			</div>
		</div>

		<div id="text567"
			style="position: absolute; overflow: hidden; left: 639px; top: 383px; width: 290px; height: 21px; z-index: 11">
			<div class="ws7">
				<div align="center">
					<font color="#366B96" face="Tahoma">
						Remember me for one day
						(Not recommended for shared computers)
					</font>
				</div>
			</div>
		</div>

		<div id="text6"
			style="position: absolute; overflow: hidden; left: 599px; top: 358px; width: 90px; height: 21px; z-index: 12">
			<div class="wpmd">
				<div align="center">
					<font color="#366B96" face="Tahoma"><b>Password:</b></font>
				</div>
			</div>
		</div>

		<div id="text7"
			style="position: absolute; overflow: hidden; left: 258px; top: 537px; width: 531px; height: 27px; z-index: 13">
			<div class="wpmd">
				<div>
					<font color="#C0C0C0" face="Tahoma">College of
						Education&nbsp;&nbsp;&nbsp;&nbsp; |&nbsp;&nbsp;&nbsp;&nbsp;
						University of Kentucky&nbsp;&nbsp;&nbsp;&nbsp;
						|&nbsp;&nbsp;&nbsp;&nbsp; An Equal Opportunity University</font>
				</div>
			</div>
		</div>
		<div id="text767"
			style="position: absolute; overflow: hidden; left: 900px; top: 537px; z-index: 13">
			<div class="wpmd">
				<p>
					<a href="http://validator.w3.org/check?uri=referer"><img
						src="http://www.w3.org/Icons/valid-xhtml10"
						alt="Valid XHTML 1.0 Transitional" height="31" width="88" /></a>
				</p>
			</div>
		</div>

		<div id="hr1"
			style="position: absolute; overflow: hidden; left: 14px; top: 185px; width: 981px; height: 17px; z-index: 15">
			<hr size="2" width="981px" />
		</div>

		<div id="text8"
			style="position: absolute; overflow: hidden; left: 316px; top: 165px; width: 467px; height: 26px; z-index: 16">
			<div class="wpmd">
				<div>
					<font class="ws12" color="#366B96" face="Tahoma"><b>College
							of Education&nbsp; -&nbsp; CEPIS Information System</b></font>
				</div>
			</div>
		</div>

		<div id="text9"
			style="position: absolute; overflow: hidden; left: 21px; top: 288px; width: 467px; height: 146px; z-index: 17">
			<div class="wpmd">
				<div>
					<font class="ws9" color="#366B96" face="Tahoma"><b>W</b></font><font
						class="ws9" color="#333333" face="Tahoma"><b>elcome to
							the College of Education CEPIS Web Portal</b></font>
				</div>
			</div>
		</div>

		<div id="image3"
			style="position: absolute; overflow: hidden; left: 492px; top: 224px; width: 128px; height: 128px; z-index: 18">
			<img src="images/22.png" alt="" border="0px" width="128px"
				height="128" />
		</div>

		<div id="text10"
			style="position: absolute; overflow: hidden; left: 682px; top: 274px; width: 242px; height: 21px; z-index: 19">
			<div class="wpmd">
				<div align="center">
					<font color="#FF0000" face="Tahoma"><b></b></font>
				</div>
			</div>
		</div>

	</div>
	<script type="text/javascript">
		function getInternetExplorerVersion()
		//Returns the version of Internet Explorer or a -1
		//(indicating the use of another browser).
		{
			var rv = -1; // Return value assumes failure.
			if (navigator.appName == 'Microsoft Internet Explorer') {
				var ua = navigator.userAgent;
				var re = new RegExp("MSIE ([0-9]{1,}[\.0-9]{0,})");
				if (re.exec(ua) != null)
					rv = parseFloat(RegExp.$1);
			}
			return rv;
		}
		function checkVersion() {
			var ver = getInternetExplorerVersion();

			if (ver > -1) {
				alert('Sorry, we currently don\'t support Internet Explorer. Please use Firefox, Chrome or Safari Web Browsers.');
			}
		}
	</script>
</body>
</html>