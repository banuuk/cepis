<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:view afterPhase="#{userDetailController.initApplicationComponent}">
	<h:message for="create_ukmajor_manager">
	</h:message>
	<h:form id="create_ukmajor_manager">
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
					value="Create new major for CEPIS System" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<br />
		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="UKMajor Code:"></h:outputText></font>
				<br />
				<h:outputText value="e.g., ADMS-CA-901" style="color:gray" />
			</h:panelGroup>
			<h:inputText value="#{userDetailController.code}" style="width:200px"></h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="UKMajor short description:"></h:outputText></font>
				<br>
				<h:outputText
					value="Short description for the drop-down box. Max 255 characters"
					style="color:gray"></h:outputText>
			</h:panelGroup>
			<h:inputTextarea value="#{userDetailController.shortDesc}"
				style="width:200px" rows="2"></h:inputTextarea>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="UKMajor description:"></h:outputText></font>
				<br>
				<h:outputText
					value="General description about the ukmajor. Max 1000 characters"
					style="color:gray"></h:outputText>
			</h:panelGroup>
			<h:inputTextarea value="#{userDetailController.description}"
				style="width:200px" rows="3"></h:inputTextarea>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="UKMajor Degree Level:"></h:outputText></font>
				<br>
				<h:outputText
					value="Degree level of this major. possible values - B,D,M,N,S"
					style="color:gray"></h:outputText>
			</h:panelGroup>
			<h:inputText value="#{userDetailController.degreeLevel}"
				style="width:200px"></h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="UKMajor status:"></h:outputText></font>
				<br>
				<h:outputText
					value="Status of the UKMajor. possible values - current,old,unknown"
					style="color:gray"></h:outputText>
			</h:panelGroup>
			<h:inputText value="#{userDetailController.status}"
				style="width:200px"></h:inputText>
			<h:message for="create_ukmajor_button"></h:message>
			<h:commandButton id="create_ukmajor_button" value="Create"
				action="#{userDetailController.createUKMajor}"></h:commandButton>
		</h:panelGrid>
	</h:form>
</f:view>