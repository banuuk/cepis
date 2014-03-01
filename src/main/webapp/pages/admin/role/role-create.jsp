<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:view afterPhase="#{userDetailController.initApplicationComponent}">
	<h:message for="create_role_manager">
	</h:message>
	<h:form id="create_role_manager">
		<br />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/warning.gif"
				rendered="#{userDetailController.userDetailWarnStatus}" alt="!"
				title="Warning!" />
			<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
				value="#{userDetailController.userDetailStatusMessage}" /></font>
		</h:panelGrid>
		<hr />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Create new role for CEPIS System" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<br />
		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Role Name:"></h:outputText></font>
				<br />
				<h:outputText value="e.g., ROLE_" style="color:gray"></h:outputText>
			</h:panelGroup>
			<h:inputText value="#{userDetailController.rolename}"
				style="width:200px"></h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Role short description:"></h:outputText></font>
				<br />
				<h:outputText
					value="Short description for the Role. Max 255 characters"
					style="color:gray"></h:outputText>
			</h:panelGroup>
			<h:inputTextarea value="#{userDetailController.roledesc}"
				style="width:200px" rows="2"></h:inputTextarea>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Other Information:"></h:outputText></font>
				<br />
				<h:outputText
					value="Other Information about the role. Max 1000 characters"
					style="color:gray"></h:outputText>
			</h:panelGroup>
			<h:inputTextarea value="#{userDetailController.otherInfo}"
				style="width:200px" rows="3"></h:inputTextarea>
			<h:message for="create_role_button"></h:message>
			<h:commandButton id="create_role_button" value="Create"
				action="#{userDetailController.createRole}"></h:commandButton>
		</h:panelGrid>
	</h:form>

</f:view>