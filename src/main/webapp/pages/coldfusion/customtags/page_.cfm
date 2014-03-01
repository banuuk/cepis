<cfsetting showDebugOutput="No">
<cfif thisTag.HasEndTag is 'False'>
   <cfabort showError="An end tag is required.">
</cfif>

<cfparam name="attributes.title" default="">
<cfparam name="attributes.onLoad" default="">

<cfif thisTag.ExecutionMode is 'end'>
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
	<head>
		<cfif isDefined("thisTag.headerData")>
			<cfloop from="1" to="#arraylen(thisTag.headerData)#" index="i" step="2">
				<cfoutput>#thisTag.headerData[i].generatedContent#</cfoutput>
			</cfloop>
		</cfif>
		
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		
		<cfoutput>
			<title>#attributes.title#</title>

			<script type="text/javascript" src="#application.webroot#/scripts/js/main_banner.js"></script>			
			<script type="text/javascript" src="#application.webroot#/scripts/js/nifty.js"></script>
			<script type="text/javascript" src="#application.webroot#/scripts/js/__package__.js"></script>
			<script type="text/javascript" src="#application.webroot#/scripts/js/MochiKit.js"></script>
			<script type="text/javascript" src="#application.webroot#/scripts/js/rounded_corners.js"></script>
			<link rel="stylesheet" type="text/css" href="#application.webroot#/scripts/css/dropdown_new.css" />						
			<link rel="stylesheet" type="text/css" href="#application.webroot#/scripts/css/common.css">
			<link rel="stylesheet" type="text/css" href="#application.webroot#/scripts/css/niftyCorners.css">
			<link rel="stylesheet" type="text/css" href="#application.webroot#/scripts/css/niftyPrint.css" media="print">
			
			<link type="text/css" href="#application.webroot#/scripts/css/workspace.css" rel="stylesheet"/>
			<link type="text/css" href="#application.webroot#/scripts/css/tab.css" rel="stylesheet"/>
			<link type="text/css" href="#application.webroot#/scripts/css/search.css" rel="stylesheet"/>
			<link type="text/css" href="#application.webroot#/scripts/css/results.css" rel="stylesheet"/>
			<link type="text/css" href="#application.webroot#/scripts/css/add.css" rel="stylesheet"/>
			<link type="text/css" href="#application.webroot#/scripts/css/reports.css" rel="stylesheet"/>
			
			<link rel="stylesheet" href="#application.webroot#/scripts/banner.css" type="text/css">
		</cfoutput>
	
		<script type="text/javascript">
			function niftyLoad() {
				if(!NiftyCheck()) {
					return;
				}
				Rounded("div#footer","all","#000066","#FFFFFF","smooth border #000066");
				Rounded("div#ws","all","#000066","#FFFFFF","smooth border #000066");

			}
		</script>
		<script type="text/javascript">
		sfHover = function() {
			var sfEls = document.getElementById("nav").getElementsByTagName("LI");
			for (var i=0; i<sfEls.length; i++) {
				sfEls[i].onmouseover=function() {
					this.className+=" sfhover";
				}
				sfEls[i].onmouseout=function() {
					this.className=this.className.replace(new RegExp(" sfhover\\b"), "");
				}
			}
		}
		if (window.attachEvent) window.attachEvent("onload", sfHover);
		</script>
				
	</head>

	<cfoutput><body bgcolor="##CCCCCC" onLoad="niftyLoad();#attributes.onLoad#"></cfoutput>
		<div id="bhead">
			<a href="http://www.uky.edu/Education/"><img src="http://www.uky.edu/Education/nav/coelogo.jpg" alt="UK College of Education" width="249" height="97" hspace="8" border="0" align="left"></a>
			<br>CEPIS PORTAL<br>
			<cfif isDefined("session.user.id")>
			<div id="buser"><cfoutput>#session.user.id#</cfoutput></div>

				<cfoutput>
				<ul id="nav">
					<li><a href="#application.webroot#/MainPage.cfm">MAIN PAGE</a></li>
					
					<li><a href="#application.webroot#/search/index.cfm">SEARCH</a>
						<ul>
						<li><a href="#application.webroot#/search/ViewResults.cfm">View Results</a></li>
						</ul>
					</li>
					
					<li><a href="">APPLICATIONS</a>
						<ul>
							<li><a href="">Account >></a>
								<ul>
									<li><a href="#application.webroot#/account/add/AddIdentity.cfm">Add Records</a></li>
									<li><a href="#application.webroot#/account/edit/EditIdentity.cfm">Edit Records</a></li>
									<li><a href="#application.webroot#/account/view/ViewIdentity.cfm">View Records</a></li>
									<li><a href="#application.webroot#/account/delete/DeleteIdentity.cfm">Delete Records</a></li>
								</ul>
							</li>
						
							<li><a href="">Advising >></a>
								<ul>
									<li><a href="#application.webroot#/advising/Create_Note.cfm">Create Note</a></li>
									<li><a href="#application.webroot#/advising/Review_Note.cfm">Review Note</a></li>
									<li><a href="#application.webroot#/advising/Send_Email.cfm">Send Email</a></li>
									<li><a href="#application.webroot#/advising/View_Course.cfm">Course Listing</a></li>
								</ul>
							</li>
							
							<li><a href="#application.webroot#/alignment/">Alignment</a></li>
							<li><a href="">UK Daily Data</a></li>
							<li><a href="">CAS</a></li>
						</ul>
					</li>
					
					<li><a href="">REPORTS</a>
						<ul>
							<li><a href="">Standard Reports >></a>
								<ul>
									<li><a href="#application.webroot#/standard_reports/tabular_report.cfm">Tabular</a></li>
									<li><a href="#application.webroot#/standard_reports/graphical_report.cfm">Graphical</a></li>
								</ul>
							</li>
					
							<li><a href="">Session Reports >></a>
								<ul>
									<li><a href="#application.webroot#/session_reports/s_reports.cfm">Data Analyzed</a></li>
									<li><a href="#application.webroot#/session_reports/GenderReport.cfm">By Gender</a></li>
									<li><a href="#application.webroot#/session_reports/EthinicityReport.cfm">By Ethinicity</a></li>
								</ul>
							</li>
						</ul>
					</li>
						
					<li><a href="#application.webroot#/Logout.cfm">LOGOUT</a></li>
			  </ul><br/><br/>
			</cfoutput>
			</cfif>
		
		<div id="ws">
			<div id="wspace">
				<cfoutput>
				<div class="heading">#attributes.title#</div>
				#thisTag.GeneratedContent#
				</cfoutput>
			</div>
		</div>

		<div id="footer">
			For best viewing, a <a href="http://www.uky.edu/Education/browsers.html"><u>current
			browser</u></a> is recommended.<br>
			The University of Kentucky is an equal opportunity university</a>. <br>
			Some web sites to which these materials link are NOT managed by the University of Kentucky.<br>
			The university does not review, control, or take responsibility for the content of those sites.	All material presented on the University of Kentucky College of Education web pages
			are protected from reproduction or distribution by federal copyright legislation unless otherwise noted.
		Updated on <cfoutput>#DateFormat(Now(),"MM-DD-YYYY")#</cfoutput> by vpadm3@uky.edu and raj.alli@uky.edu</font>
		</div>
		</body>
		</html>
		<cfset thisTag.GeneratedContent = "">
	</cfif>