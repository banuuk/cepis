<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
</div>
</td>
</tr>
<tr valign="top" style="height: 30px">
	<td valign="top" align="center">
		<div class="wpmd"></div>
	</td>
</tr>
</table>
</td>
</tr>
<tr width="1024px">
	<td>
		<table border="0" cellpadding="0" cellspacing="0" align="center">
			<jsp:include page="/common/footer1.jsp"></jsp:include>
		</table>
	</td>
</tr>
</table>
</div>
</div>
</div>
</div>
<script type="text/javascript"
	src="/cepis/js/codebase/dhtmlxcommon.js"></script>
<script type="text/javascript"
	src="/cepis/js/codebase/dhtmlxmenu.js"></script>
<script type="text/javascript"
	src="/cepis/js/codebase/dhtmlxtoolbar.js"></script>
<script type="text/javascript"
	src="/cepis/js/codebase/ext/dhtmlxmenu_ext.js"></script>
<script type="text/javascript"
	src="/cepis/js/codebase/dhtmlxcommon.js"></script>
<script type="text/javascript"
	src="/cepis/js/codebase/dhtmlxtabbar.js"></script>


	<script type="text/javascript">
		var menu;
		var toolbar;
	
		menu = new dhtmlXMenuObject("menuObj");
		toolbar = new dhtmlXToolbarObject("toolbarObj");
	
		menu.setIconsPath("/cepis/js/codebase/imgs/");
		toolbar.setIconsPath("/cepis/js/codebase/imgs/");
	
		menu.addNewChild(null, 0, "home", "Home");
		menu.setHref("home", "/cepis/pages/index.cps", "");
		
	</script>

	<authz:authorize ifAnyGranted="ROLE_STUDENT">
		<script type="text/javascript">	
			menu.addNewChild(null, 1, "ems", "My Profile");
			menu.setHref("ems", "/cepis/pages/ems/index.cps", "");
			
			menu.addNewChild(null, 2, "account", "My Account");
			menu.setHref("account", "/cepis/pages/account/index.cps", "");
			
			menu.addNewChild(null, 3, "advising", "My Appointments");
			menu.setHref("advising", "/cepis/pages/advising/index.cps", "");		
		</script>
	</authz:authorize>

	<authz:authorize ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_VIEW">		
		<script type="text/javascript">
		
			menu.addNewChild(null, 1, "account", "Account Management");
			menu.setHref("account", "/cepis/pages/account/index.cps", "");
			
			menu.addNewChild(null, 2, "ems", "EMS");
			menu.setHref("ems", "/cepis/pages/ems/index.cps", "");
			
			menu.addNewChild(null, 3, "ws", "Working Set");
			menu.setHref("ws", "/cepis/pages/ws/index.cps", "");
		</script>	
	</authz:authorize>
	
	<authz:authorize ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_VIEW,ROLE_ADVISOR,ROLE_ADVISING_MANAGER,ROLE_CONFERENCE_MANAGER,ROLE_EPSB_MANAGER,ROLE_ASSESSMENT_MANAGER,ROLE_BADGE_MANAGER,ROLE_ASSESSMENT_MANAGER">
		<script type="text/javascript">
			menu.addNewChild(null, 4, "other", "Other Apps");
		</script>
	</authz:authorize>	
	
	<authz:authorize
		ifAnyGranted="ROLE_ADVISOR,ROLE_ADVISING_MANAGER">
		<script type="text/javascript">
			menu.addNewChild("other", 1, "advising", "Advising Appointments", false, "");
			menu.setHref("advising", "/cepis/pages/advising/index.cps", "");
		</script>
	</authz:authorize>
	
	<authz:authorize ifAnyGranted="ROLE_DEVELOPER,ROLE_ASSESSMENT_MANAGER">
		<script type="text/javascript">
			menu.addNewChild("other", 2, "assessment", "Student Assessment", false, "");
			menu.setHref("assessment", "/cepis/pages/assessment/index.cps", "");
		</script>
	</authz:authorize>
	
	<authz:authorize
		ifAnyGranted="ROLE_DEVELOPER,ROLE_ADMINISTRATOR,ROLE_BADGE_MANAGER,ROLE_ADVISING_MANAGER">
		<script type="text/javascript">
			menu.addNewChild("other", 3, "barcode", "Barcode App", false, "");
			menu.setHref("barcode", "/cepis/pages/barcode/index.cps", "");
		</script>
	</authz:authorize>
	
	<authz:authorize
		ifAnyGranted="ROLE_DEVELOPER,ROLE_ADMINISTRATOR,ROLE_CONFERENCE_MANAGER">
		<script type="text/javascript">
			menu.addNewChild("other", 4, "conference", "Conference Management",	false, "");
			menu.setHref("conference", "/cepis/pages/conference/index.cps", "");
		</script>
	</authz:authorize>
	
	<authz:authorize
		ifAnyGranted="ROLE_DEVELOPER,ROLE_ADMINISTRATOR,ROLE_STUDENT_ACCOUNT_MANAGER_VIEW">
		<script type="text/javascript">
			menu.addNewChild("other", 5, "scholarship", "Scholarship", false, "");
			menu.setHref("scholarship","/cepis/pages/scholarship/index.cps", "");
		</script>
	</authz:authorize>
	
	<authz:authorize
		ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_ADVISOR,ROLE_ADVISING_MANAGER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">
		<script type="text/javascript">
			menu.addNewChild("other", 6, "notes", "Notes And Email", false, "");
			menu.setHref("notes", "/cepis/pages/notes/index.cps", "");
		</script>
	</authz:authorize>
	
 	<authz:authorize 
 		ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_VIEW"> 
 		<script type="text/javascript"> 
 			menu.addNewChild("other", 7, "tep", "TEP", false, "");
 			menu.setHref("tep", "/cepis/pages/tep/index.cps", "");
 		</script> 
 	</authz:authorize> 
 	
 	<authz:authorize 
 		ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_VIEW"> 
 		<script type="text/javascript"> 
 			menu.addNewChild("other", 8, "certification", "Certification", false, "");
 			menu.setHref("certification", "/cepis/pages/certification/index.cps", "");
 		</script> 
 	</authz:authorize> 
	
	<script type="text/javascript">
		menu.addNewSeparator("home");
		menu.addNewSeparator("account");
		menu.addNewSeparator("ems");
		menu.addNewSeparator("ws");
		menu.addNewSeparator("assessment");
		menu.addNewSeparator("conference");
		menu.addNewSeparator("notes");		
	</script>


	<script type="text/javascript">
		toolbar.addText("info", 0, 'Welcome ${whoamiController.preferredName}');
	</script>

	<authz:authorize ifAnyGranted="ROLE_DEVELOPER,ROLE_ADMINISTRATOR">
		<script type="text/javascript">
			toolbar.addSeparator("sep1", 1);
			toolbar.addButton("admin", 2, "Administrator", "", "");
		</script>
	</authz:authorize>
	 
	<authz:authorize
		ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT,ROLE_STUDENT_ACCOUNT_MANAGER_VIEW,ROLE_ADVISOR,ROLE_ADVISING_MANAGER">
		<script type="text/javascript">
			toolbar.addSeparator("sep7", 3);
			toolbar.addInput("search", 4, "", 100);
			toolbar.setItemToolTip("search", "CEPIS Search Engine");
			toolbar.addButton("searchb", 5, "", "zoom.png", "");
		</script>
	</authz:authorize>
	<authz:authorize ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">
		<script type="text/javascript">
			toolbar.addSeparator("sep3", 6);
			var id = "add";		
			var opts = null;
		</script>		
		<script type="text/javascript">			
			opts = Array(Array(id + 'id1', 'obj', 'New CEPIS User'));		
			toolbar.addButtonSelect(id, 7, "Add", opts, 'new.gif', null);		
		</script>	
	</authz:authorize>
	
	<authz:authorize
		ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT,ROLE_STUDENT_ACCOUNT_MANAGER_VIEW,ROLE_ADVISOR,ROLE_ADVISING_MANAGER">
		<script type="text/javascript">
			toolbar.addSeparator("sep8", 8);
			toolbar.addButton("cp", 9, "Control Panel", "", "");
		</script>
	</authz:authorize>

	<script type="text/javascript">
		toolbar.addSeparator("sep9", 10);
		toolbar.addButton("logout", 11, "Log Out", "", "");
		toolbar.setAlign("right");
		toolbar.attachEvent("onEnter", function(id, value) {
			if (id == 'search') {
				window.location = "/cepis/pages/index.cps?q=" + value;
			}
		});
		toolbar
				.attachEvent(
						"onClick",
						function(id) {
							if (id == 'logout') {
								window.location = "/cepis/j_spring_security_logout";
							} else if (id == 'cp') {
								window.location = "/cepis/pages/cp/index.cps";
							} else if (id == 'whoami') {
								window.location = "/cepis/pages/profile/index.cps";
							} else if (id == 'admin') {
								window.location = "/cepis/pages/admin/index.cps";
							} else if (id == 'searchb') {
								window.location = "/cepis/pages/index.cps?q=" + toolbar.getValue('search');										
							} else if (id == 'calsetting') {
								window.location = "/cepis/pages/calendar/mycalendar_settings.cps";
							} else if (id == 'mycal') {
								window.location = "/cepis/pages/calendar/mycalendar.cps";
							}  else if (id == 'addid1') {
								window.location = "/cepis/pages/account/add/index.cps";
							}
						});
	</script>
	<!-- Google +1 button -->
	<script type="text/javascript">
		(function() {
			var po = document.createElement('script');
			po.type = 'text/javascript';
			po.async = true;
			po.src = 'https://apis.google.com/js/plusone.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(po, s);
		})();
	</script>
	<div id="fb-root"></div>
	<script type="text/javascript">
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/all.js#xfbml=1";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>
	<!-- Twitter Hashtag buuton -->
	<script type="text/javascript">
		!function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (!d.getElementById(id)) {
				js = d.createElement(s);
				js.id = id;
				js.src = "//platform.twitter.com/widgets.js";
				fjs.parentNode.insertBefore(js, fjs);
			}
		}(document, "script", "twitter-wjs");
	</script>
	<!-- Google Analytics -->
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
</body>
</html>