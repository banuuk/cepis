<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="authz"%>


<%
	if (session.getMaxInactiveInterval() <= 0) {
		session.setMaxInactiveInterval(900);
	}
%>

<authz:authorize ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_ADVISOR,ROLE_STUDENT_ACCOUNT_MANAGER_VIEW,ROLE_ADVISOR">
	<%
		// Normal Session Timeout Value
		session.setMaxInactiveInterval(5400);
	%>
</authz:authorize>
<authz:authorize ifAnyGranted="ROLE_DEVELOPER,ROLE_ADVISING_MANAGER">
	<%
		// Overwrite Session Timeout for ROLE_ADVISING_MANAGER
		session.setMaxInactiveInterval(-1);
	%>
</authz:authorize>

<%@ include file="/common/header.jsp"%>

<link href="${facesContext.externalContext.requestContextPath}/css/newStyle.css" rel="stylesheet" type="text/css"/>
	
<script type="text/javascript">
	document.title = "CEPIS Portal Home";
</script>
<f:view beforePhase="#{searchEngineController.initSearchEngineView}">

	<a4j:outputPanel id="addMessages" ajaxRendered="true" style="align:center;">
		<h:panelGrid columns="1" width="98%" id="messageSection">
			<rich:messages errorClass="cepiserror" infoClass="cepissuccess"
			warnClass="cepiswarning" tooltip="true" id="cepisMsgs"/>
		</h:panelGrid>
		<a4j:status onstart="showModalInfoWindow();" onstop="hideModalInfoWindow()"/>
	</a4j:outputPanel>
		
	<authz:authorize ifNotGranted="ROLE_STUDENT" ifAnyGranted="ROLE_STUDENT_ACCOUNT_MANAGER_VIEW,ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_ASSESSMENT_MANAGER">
		<h:panelGroup layout="block">		
			<a4j:include viewId="search.jsp" />		
		</h:panelGroup>
	</authz:authorize>
	
	<authz:authorize ifAllGranted="ROLE_STUDENT">
		<h:panelGroup layout="block">		
			<a4j:include viewId="student.jsp" />		
		</h:panelGroup>
	</authz:authorize>
	

</f:view>
<%@ include file="/common/footer.jsp"%>