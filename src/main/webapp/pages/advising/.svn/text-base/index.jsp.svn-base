<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ include file="/common/header.jsp"%>
<script type="text/javascript">
	document.title = "CEPIS Advising and Appointments";
	var global_title = document.getElementById('global_title');
	global_title.innerHTML = "CEPIS Advising and Appointments";
</script>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/appointment.css"
	media="screen" rel="stylesheet" type="text/css"/>
<link rel="stylesheet"
	href="${facesContext.externalContext.requestContextPath}/css/sticky.min.css"
	type="text/css" />
<f:view afterPhase="#{advisingManagementController.initCalendarView}">
	<a4j:loadScript src="resource://jquery.js" />
	<a4j:outputPanel ajaxRendered="true" style="align:center" id="msgs">
		<h:panelGrid columns="1" id="apptmsgs" width="95%">
			<rich:messages errorClass="cepiserror" infoClass="cepissuccess"
				warnClass="cepiswarning"></rich:messages>
		</h:panelGrid>
		<a4j:status onstart="showModalInfoWindow();"
			onstop="hideModalInfoWindow()"></a4j:status>
	</a4j:outputPanel>
	<h:outputText value="#{advisingManagementController.initSessionDate}"></h:outputText>
	<authz:authorize ifAnyGranted="ROLE_STUDENT">
		<authz:authorize ifNotGranted="ROLE_ADVISOR,ROLE_ADVISING_MANAGER">
			<a4j:include viewId="student.jsp" />
		</authz:authorize>
	</authz:authorize>
	<authz:authorize ifAnyGranted="ROLE_ADVISOR,ROLE_ADVISING_MANAGER">
		<a4j:include viewId="mycalendar.jsp" />
	</authz:authorize>
	<authz:authorize ifAnyGranted="ROLE_DEVELOPER">
		<rich:spacer height="25px"></rich:spacer>
		<!-- Developer Console -->
		<a4j:outputPanel ajaxRendered="true" style="align:center">
			<h:panelGrid columns="1" width="100%">
				<h:panelGroup>
					<a4j:log id="debug" popup="false" title="CEPIS - Ajax Debug Window"
						rendered="true" width="900px" height="100px"></a4j:log>
				</h:panelGroup>
			</h:panelGrid>
		</a4j:outputPanel>
	</authz:authorize>
	<a4j:include viewId="advisingsession-panel.jsp"></a4j:include>
	<!-- Looading Panel -->
	<rich:modalPanel id="ajaxLoadingModalBox" minHeight="50" minWidth="120"
		height="100" width="120" zindex="2000">
		<f:facet name="header">
			<h:outputText value="Sending Request ..."></h:outputText>
		</f:facet>
		<h:outputText value="Please wait ..."></h:outputText>
		<br />
		<br />&nbsp;&nbsp;&nbsp;
				<h:graphicImage value="/images/loader.gif"
			style="border:0; margin: auto" alt="Loading ..."></h:graphicImage>
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
	<script type="text/javascript"
		src="${facesContext.externalContext.requestContextPath}/js/sticky.min.js"></script>
	<a4j:outputPanel ajaxRendered="true" style="align:center">
		<h:panelGroup rendered="#{cepisConfigurationManager.messageSummary > 0}">
		<script type="text/javascript">
	if (jQuery('.cepiserror,.cepiswarning,.cepissuccess').length) {
		var docViewTop = jQuery(window).scrollTop();
		var docViewBottom = docViewTop + jQuery(window).height();

		var elemTop = jQuery('.cepiserror,.cepiswarning,.cepissuccess')
				.offset().top;
		var elemBottom = elemTop
				+ jQuery('.cepiserror,.cepiswarning,.cepissuccess').height();

		if (!((elemBottom >= docViewTop) && (elemTop <= docViewBottom)
				&& (elemBottom <= docViewBottom) && (elemTop >= docViewTop))) {
			// Show sticky message
			jQuery()
					.sticky(
							'<h:outputText value="#{cepisConfigurationManager.messageSummary} notification(s) available."/>');
		}

	}
</script>
</h:panelGroup>
	</a4j:outputPanel>
</f:view>
<%@ include file="/common/footer.jsp"%>