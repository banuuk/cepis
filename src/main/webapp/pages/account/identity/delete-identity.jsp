<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<link href="${facesContext.externalContext.requestContextPath}/css/datascroller.css"
	media="screen" rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:subview id="delete-user">
	<h:form id="remove_user_manager">
		<br />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Delete this user's account" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">
			<h:message for="remove_user_button"></h:message>
			<h:commandButton id="remove_user_button" value="Delete"
				action="#{accountManagementController.removeUserAccount}"
				onclick="if (!confirm('Are you sure you want to proceed?. This will delete all the information about #{cepisConfigurationManager.selectedUser} stored in our CEPIS Portal.')) return false">
			</h:commandButton>
		</h:panelGrid>

	</h:form>
</f:subview>