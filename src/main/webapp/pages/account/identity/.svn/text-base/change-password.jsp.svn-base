<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>
<link
	href="${facesContext.externalContext.requestContextPath}/css/font.css"
	media="screen" rel="stylesheet" type="text/css" />
<link
	href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css" />
<f:subview id="change_password">
	<h:form id="change_password_manager">
		<br />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="Change Password" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<br />

		<authz:authorize ifAnyGranted="ROLE_NONUK">
			<h:panelGrid columns="2"
				style="padding-right: 100px; padding-left: 100px">
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
							value="Old Password: *" /></font>
					<br />
					<h:outputText value="Enter old password" style="color:gray" />
				</h:panelGroup>
				<h:inputSecret id="oldCepisPwd"
					value="#{accountManagementController.oldPassword}"
					style="width:180px" required="true"
					requiredMessage="Old Password: Value is required."
					validatorMessage="Old Password: Value is invalid.">
					<f:validateLength maximum="100" />
				</h:inputSecret>
				<h:outputText
				value="#{accountManagementController.disableBypassOldPasswordCheck}"></h:outputText>
			</h:panelGrid>
		</authz:authorize>
		<authz:authorize
			ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD,ROLE_STUDENT_ACCOUNT_MANAGER_EDIT,ROLE_NONUK">
			<h:outputText
				value="#{accountManagementController.enableBypassOldPasswordCheck}"></h:outputText>
		</authz:authorize>
		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Password: *" /></font>
			</h:panelGroup>
			<h:inputSecret id="cepisPwd"
				value="#{accountManagementController.password}" style="width:180px"
				required="true" requiredMessage="Password: Value is required."
				validatorMessage="Password: Value is invalid.">
				<f:validateLength maximum="100" />
			</h:inputSecret>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Password (Verify): *" /></font>
			</h:panelGroup>
			<h:inputSecret id="cepisVerifyPwd"
				value="#{accountManagementController.verifyPassword}"
				style="width:180px" required="true"
				requiredMessage="Verify Password: Value is required."
				validatorMessage="Verify Password: Value is invalid.">
				<a4j:support event="onblur" ajaxSingle="true" process="cepisPwd"
					limitToList="true"
					actionListener="#{accountManagementController.valueChangeVerifyPassword}"
					reRender="addMessages" />
				<f:validateLength maximum="100" />
			</h:inputSecret>
		</h:panelGrid>
		<a4j:commandButton id="change_password_button" value="Change Password"
			style="display: block; margin: auto;"
			action="#{accountManagementController.changePassword}" />
	</h:form>
</f:subview>