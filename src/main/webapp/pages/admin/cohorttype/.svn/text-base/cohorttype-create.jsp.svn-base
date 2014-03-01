<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:view afterPhase="#{appComponentController.initApplicationComponent}">
	<h:message for="create_cohorttype_manager">
	</h:message>
	<h:form id="create_cohorttype_manager">
		<br />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/warning.gif"
				rendered="#{appComponentController.appComponentWarnStatus}" alt="Warning!"
				title="Warning!" />
			<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
				value="#{appComponentController.appComponentStatusMessage}"></h:outputText>
			</font>
		</h:panelGrid>
		<hr />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Create new Cohort Type"></h:outputText> </font>
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
				<h:outputText value="e.g., ADMS-CA-901" style="color:gray"></h:outputText>
			</h:panelGroup>
			<h:inputText value="#{appComponentController.code}"
				style='width:200px'></h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Short description:"></h:outputText></font>
				<br />
				<h:outputText
					value="Short description for the drop-down box. Max 255 characters"
					style="color:gray"></h:outputText>
				<br />
			</h:panelGroup>
			<h:inputTextarea value="#{appComponentController.shortDesc}"
				style='width:200px' rows="2"></h:inputTextarea>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Description:"></h:outputText></font>
				<br />
				<h:outputText
					value="General description about the cohorttype. Max 1000 characters"
					style="color:gray"></h:outputText>
				<br />
			</h:panelGroup>
			<h:inputTextarea value="#{appComponentController.description}"
				style='width:200px' rows="3"></h:inputTextarea>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Status:"></h:outputText></font>
				<br />
				<h:outputText
					value="Status of the cohorttype. possible values - current,old,unknown"
					style="color:gray"></h:outputText>
				<br />
			</h:panelGroup>
			<h:inputText value="#{appComponentController.status}"
				style='width:200px'></h:inputText>&nbsp;&nbsp;&nbsp;&nbsp;
			<h:message for="create_cohorttype_button"></h:message>
			<h:commandButton id="create_cohorttype_button" value="Create"
				action="#{appComponentController.createCohortType}"></h:commandButton>
		</h:panelGrid>
	</h:form>
</f:view>
