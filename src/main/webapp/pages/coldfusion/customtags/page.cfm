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

			<script type="text/javascript" src="#application.webroot#/js/main_banner.js"></script>			
			<script type="text/javascript" src="#application.webroot#/js/nifty.js"></script>
			
			<script type="text/javascript" src="#application.webroot#/js/MochiKit/__package__.js"></script>
			<script type="text/javascript" src="#application.webroot#/js/MochiKit/MochiKit.js"></script>
			<script type="text/javascript" src="#application.webroot#/js/MochiKit/rounded_corners.js"></script>
			
			<script type="text/javascript" src="#application.webroot#/js/fsmenu.js"></script>
			<script type="text/javascript" src="#application.webroot#/js/epsb.js"></script>
			 
			<link type="text/css" href="#application.webroot#/css/workspace.css" rel="stylesheet"/>
			<link type="text/css" href="#application.webroot#/css/tab.css" rel="stylesheet"/>
			<link type="text/css" href="#application.webroot#/css/search.css" rel="stylesheet"/>
			<link type="text/css" href="#application.webroot#/css/results.css" rel="stylesheet"/>
			<link type="text/css" href="#application.webroot#/css/add.css" rel="stylesheet"/>
			<link type="text/css" href="#application.webroot#/css/reports.css" rel="stylesheet"/>
			<link type="text/css" href="#application.webroot#/css/epsb.css" rel="stylesheet"/>
			
			<link rel="stylesheet" type="text/css" href="#application.webroot#/css/common.css">
			<link rel="stylesheet" type="text/css" href="#application.webroot#/css/niftyCorners.css">
			<link rel="stylesheet" type="text/css" href="#application.webroot#/css/niftyPrint.css" media="print">
			<!-- <link rel="stylesheet" href="#application.webroot#/css/banner.css" type="text/css"> -->
			<link rel="stylesheet" type="text/css" id="listmenu-h" href="#application.webroot#/css/dropdown.css" title="Horizontal 'Earth'" />
		</cfoutput>
	
		<script type="text/javascript">
			function niftyLoad() {
				if(!NiftyCheck()) {
					return;
				}
				Rounded("div#footer","all","#000066","#FFFFFF","smooth border #000066");
				Rounded("div#ws","all","#000066","#FFFFFF","smooth border #000066");

			}	
			
			function goToJavaPortal() {
				document.pageForm.action="https://cepis.coe.uky.edu:8443/coesis/UserLogin.do?dispatch=authenticate";						
				document.pageForm.submit();								
			}	
			
			function goToAccountMaintenance() {
				document.pageForm.action="https://cepis.coe.uky.edu:8443/coesis/UserLogin.do?dispatch=accountmaint";						
				document.pageForm.submit();								
			}	
		</script>
		
	</head>
	<cfif isDefined("session.user.id")>
		<cfform name="pageForm" method="post">
				<cfquery datasource="#application.dsn#" name="FindIdentity">
						select *  
						from tblComputer 
						where UID = <cfqueryparam value="#session.user.uid#">
				</cfquery>								
				<cfoutput query="FindIdentity"><input type="hidden" name="username" value="#Computeraddress#"/></cfoutput>	
		</cfform>		
	</cfif>
		
	<cfoutput><body bgcolor="##CCCCCC" onLoad="niftyLoad();#attributes.onLoad#">
		<div id="bhead">
			<a href="https://www.uky.edu/Education/">
				<img src="#application.webroot#/images/coelogo.jpg" alt="UK College of Education" width="249" height="97" hspace="8" border="0" align="left">
			</a>
			<br>EPSB Web Service<br></cfoutput>
			<div id="buser">Go back to <a style="color: #FFFFFF;text-decoration: none underline;" href="/cepis/pages/index.cps">CEPIS Portal</a></div>
			<cfif isDefined("session.user.id")>
			<div id="buser"><cfoutput>#application.user#</cfoutput></div>

		<cfoutput>
		<div class="menu" id="menuWrap">
		
		<ul class="menulist" id="listMenuRoot">
			<li><a class="hide" href="##" onClick="goToJavaPortal();">CAR</a></li>
			<li><a class="hide" href="##" onClick="goToAccountMaintenance();">ACCOUNT MAINTENANCE</a></li>			
			<li><a class="hide" href="#application.webroot#/MainPage.cfm">MAIN PAGE</a></li>
			<cfif Session.Security.search EQ true>
			<li><a class="hide" href="#application.webroot#/search/index.cfm">SEARCH</a>
				<ul>
					<li><a href="#application.webroot#/search/ViewWorkingSet.cfm">View WorkingSet</a></li>
				</ul>
			</li>
			</cfif>
			<li><a class="hide" >APPLICATIONS</a>
				<ul>
				<cfif Session.Security.account EQ true>
				<li><a class="hide">Account Maintenance</a>
					<ul>
					<cfif Session.Security.account_add EQ true>
						<li><a href="#application.webroot#/account/add/AddMain.cfm">Add Records</a></li>
					</cfif>
					<cfif Session.Security.account_view EQ true>
						<li><a href="#application.webroot#/account/view/ViewMain.cfm">View Records</a></li>
					</cfif>
					<cfif Session.Security.account_edit EQ true>
						<li><a href="#application.webroot#/account/edit/EditMain.cfm">Edit Records</a></li>
					</cfif>
					<cfif Session.Security.account_delete EQ true>
						<li><a href="#application.webroot#/account/delete/DeleteMain.cfm">Delete Records</a></li>
					</cfif>
					</ul>
				</li>
				</cfif>
			
				<cfif Session.Security.Advising  EQ true>			
			   <li>
			   			<a class="hide">Advising Application</a>
					<ul>
						<cfif Session.Security.view_notes EQ true>
						<li><a href="#application.webroot#/advising/Notes.cfm">Notes</a></li>
						</cfif>
						<cfif Session.Security.view_academic_info EQ true>
						<li><a href="#application.webroot#/advising/View_Course.cfm">Academic Info</a></li>
						</cfif>
					</ul>
 				</li>
			</cfif>
				<cfif Session.Security.Alignment EQ true>
				<li><a href="#application.webroot#/alignment/">Alignment Module</a></li>
				</cfif>
						
				</ul>
			</li>
			
			<cfif Session.Security.EPSB EQ true>
			<li><a class="hide">EPSB</a>
				<ul>
					<li><a href="#application.webroot#/webservice/uk_data.cfm">Admissions & Exit</a></li>
					<!---<li><a href="#application.webroot#/webservice/EPSB_Gaci.cfm">Gaci</a></li>--->
				</ul>
			</li>
			</cfif>
			
			<cfif Session.Security.REPORTS EQ true>
			<li><a class="hide">REPORTS</a>
				<ul>
                <cfif Session.Security.standard_reports EQ true>
				<li><a class="hide">Standard Reports</a>
					<ul style=" top: -1px; margin-top: 0;left:-150px;">
						<li><a href="#application.webroot#/standard_reports/tabular_report.cfm">UK Daily Data</a></li>
						<li><a href="#application.webroot#/standard_reports/PraxisForm.cfm">Praxis Report</a></li>
					</ul>
				</li>
				</cfif>
				<cfif Session.Security.standard_reports EQ true>
			   <li><a class="hide">Session Reports</a>
					<ul style=" top: -1px; margin-top: 0;left:-150px;">
						<li><a href="#application.webroot#/session_reports/sreport_ByDemo.cfm">By Demograhics</a></li>
						<li><a href="#application.webroot#/session_reports/sreport_ByPgm.cfm">By Program</a></li>
						<li><a href="#application.webroot#/session_reports/sreport_ByPgmFaculty.cfm">By Program Faculty</a></li>
						<li><a href="#application.webroot#/session_reports/sreport_ByPraxisScore.cfm">By Praxis Score</a></li>
						<li><a href="#application.webroot#/session_reports/sreport_ByACTE.cfm">By ACTE Score</a></li>
						<li><a href="#application.webroot#/session_reports/sreport_ByStuACTE.cfm">By ACTE Score(Tranextr)</a></li>
						<li><a href="#application.webroot#/session_reports/sreport_ByGRE.cfm">By GRE Score</a></li>
					</ul>
				</li>
				</cfif>
				</ul>
			</li>
			</cfif>
			<li><a class="hide" href="#application.webroot#/Logout.cfm">LOGOUT</a>
		</ul>
</ul>

<script type="text/javascript">
//<![CDATA[

var listMenu = new FSMenu('listMenu', true, 'display', 'block', 'none');

listMenu.animations[listMenu.animations.length] = FSMenu.animFade;
listMenu.animations[listMenu.animations.length] = FSMenu.animSwipeDown;

var arrow = null;
if (document.createElement && document.documentElement)
{	
 arrow = document.createElement('span');
 arrow.appendChild(document.createTextNode('>'));

 // Feel free to replace the above two lines with these for a small arrow image...
 //arrow = document.createElement('img');
 //arrow.src = 'arrow.gif';
 //arrow.style.borderWidth = '0';
 arrow.className = 'subind';
}
addEvent(window, 'load', new Function('listMenu.activateMenu("listMenuRoot", arrow)'));

//]]>
</script>

		</div>
		</cfoutput>
		</cfif>

		</div>

		</div>
		
		<div id="ws">
			<div id="wspace">
				<cfoutput>
				<div class="heading">#attributes.title#</div>
				#thisTag.GeneratedContent#
				</cfoutput>
			</div>
		</div>

		<div id="footer">
			<a href="http://www.uky.edu/Education">College of Education</a> - <A HREF="http://www.uky.edu/">University of Kentucky</a> is an <a href="http://www.uky.edu/Home/Web/eo/"/>equal opportunity university</a>. <br>
			
			
			
		</div>
		</body>
		</html>
		<cfset thisTag.GeneratedContent = "">
	</cfif>
