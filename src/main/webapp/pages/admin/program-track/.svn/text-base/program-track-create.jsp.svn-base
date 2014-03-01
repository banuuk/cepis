
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<html>
<head>
<title>CEPIS Program Track Manager - Add option</title>
</head>
<body>
<f:view afterPhase="#{appComponentController.initApplicationComponent}">
	<h:message for="create_program_track_manager">
	</h:message>
	<h:form id="create_program_track_manager">
		<h:outputText
			value="Create new program track in CEPIS Portal for College of Education"></h:outputText>
		<hr />
		<h:outputText value="#{appComponentController.appComponentWarnStatus}"></h:outputText>&nbsp;&nbsp;
		<h:outputText
			value="#{appComponentController.appComponentStatusMessage}"></h:outputText>
		<hr />
		<h:outputText value="Program Track Code:"></h:outputText>&nbsp;&nbsp;&nbsp;&nbsp;
		      <h:inputText value="#{appComponentController.code}"></h:inputText>&nbsp;&nbsp;&nbsp;&nbsp;<br>
		<h:outputText value="e.g., ADMS-CA-901" style="color:gray"></h:outputText>

		<br />
		<h:outputText value="Program Track short description:"></h:outputText>&nbsp;&nbsp;&nbsp;&nbsp;
		<h:inputText value="#{appComponentController.shortDesc}"></h:inputText>&nbsp;&nbsp;&nbsp;&nbsp;
		<br>
		<h:outputText
			value="Short description for the drop-down box. Max 255 characters"
			style="color:gray"></h:outputText>
		<br />
		<h:outputText value="Program Track description:"></h:outputText>&nbsp;&nbsp;&nbsp;&nbsp;
		<h:inputText value="#{appComponentController.description}"></h:inputText>&nbsp;&nbsp;&nbsp;&nbsp;
		<br>
		<h:outputText
			value="General description about the program track. Max 1000 characters"
			style="color:gray"></h:outputText>
		<br />
		<h:outputText value="Program Track status:"></h:outputText>&nbsp;&nbsp;&nbsp;&nbsp;
		<h:inputText value="#{appComponentController.status}"></h:inputText>&nbsp;&nbsp;&nbsp;&nbsp;
		<br>
		<h:outputText
			value="Status of the program track. possible values - current,old,unknown"
			style="color:gray"></h:outputText>
		<br />
		<h:message for="create_program_track_button"></h:message>
		<br />
		<h:commandButton id="create_program_track_button" value="Create"
			action="#{appComponentController.createProgramTrack}"></h:commandButton>


	</h:form>

</f:view>
</body>
</html>