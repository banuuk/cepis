<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:view afterPhase="#{appComponentController.initApplicationComponent}">
	<h:message for="create_ukcolleges_manager">
	</h:message>
	<h:form id="create_ukcolleges_manager">
		<br />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/warning.gif"
				rendered="#{appComponentController.appComponentWarnStatus}" alt="!"
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
					value="Create new UK College"></h:outputText> </font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<br />
		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="College Code:"></h:outputText></font>
				<br />
				<h:outputText value="e.g., ADMS-CA-901" style="color:gray"></h:outputText>
			</h:panelGroup>
			<h:inputText value="#{appComponentController.code}"
				style='width:200px'></h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="College Name:"></h:outputText></font>
				<br />
				<h:outputText value="Max 255 characters" style="color:gray"></h:outputText>
				<br />
			</h:panelGroup>
			<h:inputText value="#{appComponentController.collegeName}"
				style='width:200px'></h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="College Address:"></h:outputText></font>
				<br />
				<h:outputText value="Max 255 characters" style="color:gray"></h:outputText>
				<br />
			</h:panelGroup>
			<h:inputText value="#{appComponentController.collegeAddress}"
				style='width:200px'></h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="College Phone:"></h:outputText></font>
				<br />
				<h:outputText value="Max 255 characters" style="color:gray"></h:outputText>
				<br />
			</h:panelGroup>
			<h:inputText value="#{appComponentController.phone}"
				style='width:200px'></h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="College Dean Name:"></h:outputText></font>
				<br />
				<h:outputText value="Max 255 characters" style="color:gray"></h:outputText>
				<br />
			</h:panelGroup>
			<h:inputText value="#{appComponentController.collegeDeanName}"
				style='width:200px'></h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Sort Info:"></h:outputText></font>
				<br />
				<h:outputText value="Max 255 characters" style="color:gray"></h:outputText>
				<br />
			</h:panelGroup>
			<h:inputText value="#{appComponentController.speedSort}"
				style='width:200px'></h:inputText>
			<h:message for="create_ukcolleges_button"></h:message>
			<h:commandButton id="create_ukcolleges_button" value="Create"
				action="#{appComponentController.createUKCollege}"></h:commandButton>
		</h:panelGrid>
	</h:form>
</f:view>
