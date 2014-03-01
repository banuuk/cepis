<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ include file="/common/header.jsp"%>

<script type="text/javascript">
	document.title = "CEPIS Control Panel";
	var global_title = document.getElementById('global_title');
	global_title.innerHTML = "CEPIS Control Panel";
</script>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css" />
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css" />
<f:view locale="en">
	<a4j:outputPanel ajaxRendered="true">
		<h:panelGrid columns="1">
			<h:messages errorClass="cepiserror" infoClass="cepissuccess"
				warnClass="cepiswarning"></h:messages>
		</h:panelGrid>
		<a4j:status onstart="showModalInfoWindow();"
			onstop="hideModalInfoWindow()"></a4j:status>
	</a4j:outputPanel>
	<rich:tabPanel switchType="ajax" immediate="true">
		<rich:tab label="Who Am I?">
			<a4j:include viewId="profile/whoami.jsp" />
		</rich:tab>
		<rich:tab label="Recent Log Ins">
			<a4j:include viewId="profile/lastlogin.jsp" />
		</rich:tab>
		<authz:authorize
			ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_BADGE_MANAGER">
			<rich:tab label="Upload Profile Picture">
				<a4j:include viewId="picture/imageuploader.jsp" />
			</rich:tab>
		</authz:authorize>
		<authz:authorize
			ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_VIEW">
			<rich:tab label="Ping UK LDAP">
				<a4j:include viewId="ping/ukldap.jsp" />
			</rich:tab>
		</authz:authorize>
	</rich:tabPanel>

	<rich:modalPanel id="ajaxLoadingModalBox" minHeight="50" minWidth="120"
		height="100" width="120" zindex="2000">
		<f:facet name="header">
			<h:outputText value="Sending Request ..."/>
		</f:facet>
		<h:outputText value="Please wait ..."/>
		<br />
		<br />&nbsp;&nbsp;&nbsp;
				<h:graphicImage value="/images/loader.gif" style="border:0" alt="loading ..."/>
	</rich:modalPanel>
	<script type="text/javascript">
		var infoWindowAMShown = false;
		var infoWindowAMTimer;
		function showModalInfoWindow() {
			infoWindowAMTimer = setTimeout(
				"if(!infoWindowAMShown){Richfaces.showModalPanel('ajaxLoadingModalBox');infoWindowAMShown=true;}", 500);					
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
</f:view>
<%@ include file="/common/footer.jsp"%>