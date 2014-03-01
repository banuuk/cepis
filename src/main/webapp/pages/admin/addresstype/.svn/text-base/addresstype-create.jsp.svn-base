<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:view afterPhase="#{userDetailController.initApplicationComponent}">
	<h:message for="create_addresstype_manager">
	</h:message>
	<h:form id="create_addresstype_manager">
		<br />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/warning.gif"
				rendered="#{userDetailController.userDetailWarnStatus}" alt="Warning!"
				title="Warning!" />
			<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
				value="#{userDetailController.userDetailStatusMessage}" /></font>
		</h:panelGrid>
		<hr />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Create new addresstype for CEPIS System" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<br />
		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Code:"></h:outputText></font>
				<br />
				<h:outputText value="e.g., ADMS-CA-901" style="color:gray" />
			</h:panelGroup>
			<h:inputText value="#{userDetailController.code}" style="width:200px"></h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Short description:"></h:outputText></font>
				<br>
				<h:outputText
					value="Short description for the drop-down box. Max 255 characters"
					style="color:gray"></h:outputText>
			</h:panelGroup>
			<h:inputTextarea value="#{userDetailController.shortDesc}"
				style="width:200px" rows="2"></h:inputTextarea>
			<h:message for="create_addresstype_button"></h:message>
			<h:commandButton id="create_addresstype_button" value="Create"
				action="#{userDetailController.createAddressType}"></h:commandButton>
		</h:panelGrid>
	</h:form>
</f:view>