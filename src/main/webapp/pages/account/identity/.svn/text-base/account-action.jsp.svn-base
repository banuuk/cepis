<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>

<link
	href="${facesContext.externalContext.requestContextPath}/css/datascroller.css"
	media="screen" rel="stylesheet" type="text/css" />
<link
	href="${facesContext.externalContext.requestContextPath}/css/font.css"
	media="screen" rel="stylesheet" type="text/css" />
<link
	href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css" />
<f:subview id="deactivate-user"
	rendered="#{cepisConfigurationManager.selectedUser.enabled==1}">
	<h:form id="deactivate_user_manager">
		<br />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Deactivate this user's account?. The selected user will not be able to log into the CEPIS portal anymore." /></font>
				<br />
				<h:outputText
					value="Note: This will not remove any data from this user's account." />
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">
			<h:message for="deactivate-user_button"></h:message>
			<h:commandButton id="deactivate-user_button" value="Deactivate"
				action="#{accountManagementController.deactivateUserAccount}"
				onclick="if (!confirm('Are you sure you want to proceed?. This user #{cepisConfigurationManager.selectedUser} will not be able to log into the portal. If you change your mind later, you can activate this account in this page.')) return false">
			</h:commandButton>
		</h:panelGrid>

	</h:form>
</f:subview>

<f:subview id="activate-user"
	rendered="#{cepisConfigurationManager.selectedUser.enabled==0}">
	<h:form id="activate_user_manager">
		<br />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="This account has already been deactivated. You can activate this account again by clicking this button." /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">
			<h:message for="activate-user_button"></h:message>
			<h:commandButton id="activate-user_button" value="Activate"
				action="#{accountManagementController.activateUserAccount}">
			</h:commandButton>
		</h:panelGrid>

	</h:form>
</f:subview>