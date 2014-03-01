	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
	<head>
	<link rel="stylesheet" type="text/css" href="/coesis/scripts/css/dropdown_new.css" />
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

	<cfoutput><body bgcolor="##CCCCCC" ></cfoutput>
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
		