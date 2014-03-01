<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<link rel="STYLESHEET" type="text/css"
	href="${facesContext.externalContext.requestContextPath}/js/codebase/dhtmlxtabbar.css"/>
<script src="${facesContext.externalContext.requestContextPath}/js/codebase/dhtmlxcommon.js"></script>
<script src="${facesContext.externalContext.requestContextPath}/js/codebase/dhtmlxtabbar.js"></script>
<%@ include file="/common/header.jsp"%>
<script type="text/javascript">
	document.title = "CEPIS Administrator Panel";
	var global_title = document.getElementById('global_title');
	global_title.innerHTML = "CEPIS Administrator Panel";
</script>
<f:view
	beforePhase="#{accountManagementController.initAccountManagement}">
	<br />
	<a4j:outputPanel ajaxRendered="true" style="align:center">
		<h:panelGrid columns="1">
			<h:messages errorClass="cepiserror" infoClass="cepissuccess"
				warnClass="cepiswarning"></h:messages>
		</h:panelGrid>
		<a4j:status onstart="showModalInfoWindow();"
			onstop="hideModalInfoWindow()"></a4j:status>
	</a4j:outputPanel>
	<br />
	<h:form>
		<h:commandLink value="Refresh list"
			action="#{cepisGlobalComponentConfigurator.loadGlobalComponent}">
		</h:commandLink>
		<div id="a_tabbar" style="width: 100%; height: 720px;"></div>
	</h:form>
	<script>
	tabbar = new dhtmlXTabBar("a_tabbar", "top");
	tabbar.setSkin('dhx_blue');
	tabbar.setImagePath("/cepis/js/codebase/imgs/");
	tabbar.enableAutoSize(true, true);
	tabbar.enableAutoReSize(true);
	tabbar.addTab("a0", "College", "100px");
	tabbar.addTab("a1", "Department", "100px");
	tabbar.addTab("a2", "Role", "100px");
	tabbar.addTab("a3", "Program", "100px");
	tabbar.addTab("a4", "Program Domain", "100px");
	tabbar.addTab("a5", "Program Group", "100px");
	tabbar.addTab("a6", "Program track", "100px");
	tabbar.addTab("a7", "Major", "100px");
	tabbar.addTab("a8", "Status", "100px");
	tabbar.addTab("a9", "Term", "100px");
	tabbar.addTab("a10", "Cohort Type", "100px");
	tabbar.addTab("a11", "Cohort Term", "100px");
	tabbar.addTab("a12", "Advisor Group", "100px");
	tabbar.addTab("a13", "Advisor", "100px");
	tabbar.addTab("a14", "User Type", "100px");
	tabbar.addTab("a15", "User Classification", "100px");
	tabbar.addTab("a16", "Address Type", "100px");
	tabbar.addTab("a17", "Phone Type", "100px");
	tabbar.addTab("a18", "Email Address Type", "100px");
	tabbar.addTab("a19", "Ethnic", "100px");
	tabbar.addTab("a20", "Ranking", "100px");

	tabbar.setHrefMode("iframes-on-demand");

	tabbar.setContentHref("a0", "ukcollege/index.cps");
	tabbar.setContentHref("a1", "ukdepartment/index.cps");
	tabbar.setContentHref("a10", "cohorttype/index.cps");
	tabbar.setContentHref("a11", "cohortterm/index.cps");
	tabbar.setContentHref("a14", "usertype/index.cps");
	tabbar.setContentHref("a15", "userclassification/index.cps");
	tabbar.setContentHref("a12", "advisorgroup/index.cps");
	tabbar.setContentHref("a13", "advisor/index.cps");
	tabbar.setContentHref("a16", "addresstype/index.cps");
	tabbar.setContentHref("a18", "emailaddresstype/index.cps");
	tabbar.setContentHref("a17", "phonetype/index.cps");
	tabbar.setContentHref("a3", "program/index.cps");
	tabbar.setContentHref("a4", "program-domain/index.cps");
	tabbar.setContentHref("a5", "program-group/index.cps");
	tabbar.setContentHref("a6", "program-track/index.cps");
	tabbar.setContentHref("a2", "role/index.cps");
	tabbar.setContentHref("a7", "ukmajor/index.cps");
	tabbar.setContentHref("a8", "ukstatus/index.cps");
	tabbar.setContentHref("a9", "ukterm/index.cps");
	tabbar.setContentHref("a19", "ethnic/index.cps");
	tabbar.setContentHref("a20", "ranking/index.cps");

	tabbar.setTabActive("a0");
	tabbar.normalize();
</script>
	<rich:modalPanel id="ajaxLoadingModalBox" minHeight="50" minWidth="120"
		height="100" width="120" zindex="2000">
		<f:facet name="header">
			<h:outputText value="Sending Request ..."></h:outputText>
		</f:facet>
		<h:outputText value="Please wait ..."></h:outputText>
		<br />
		<br />&nbsp;&nbsp;&nbsp;
				<h:graphicImage value="/images/loader.gif" style="border:0" alt="loading ..."></h:graphicImage>
	</rich:modalPanel>
	<script type="text/javascript">
	var infoWindowAMShown = false;
	var infoWindowAMTimer;
	function showModalInfoWindow() {
		infoWindowAMTimer = setTimeout(
				"if(!infoWindowAMShown){Richfaces.showModalPanel('ajaxLoadingModalBox');infoWindowAMShown=true;}",
				500);
	}
	function hideModalInfoWindow() {
		if (infoWindowAMShown) {
			Richfaces.hideModalPanel('ajaxLoadingModalBox');
			infoWindowAMShown = false;
		} else {
			if (infoWindowAMTimer)
				clearTimeout(infoWindowAMTimer);
		}
	}
</script>
	<a4j:outputPanel ajaxRendered="true" style="align:center">
		<h:panelGrid columns="1">
			<authz:authorize ifAllGranted="ROLE_DEVELOPER">
				<h:panelGroup>
					<a4j:log id="debug" popup="false" title="CEPIS - Ajax Debug Window"
						rendered="true" width="900px" height="100px"></a4j:log>
				</h:panelGroup>
			</authz:authorize>
		</h:panelGrid>
	</a4j:outputPanel>
</f:view>
<%@ include file="/common/footer.jsp"%>