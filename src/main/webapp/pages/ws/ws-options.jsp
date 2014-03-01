
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Working Set Operations</title>
</head>
<body>
<f:view afterPhase="#{workingSetController.initWS}">
	<h:message for="savedelete_ws">
	</h:message>
	<h:form id="savedelete_ws">
		<h:outputText value="Working Set: "></h:outputText>
		<h:outputText value="#{workingSetController.activeWorkingSetName}"></h:outputText>
		<br />
		<h:outputText
			value="#{workingSetController.activeWorkingSetWarnStatus}"></h:outputText>&nbsp;&nbsp;
		<h:outputText
			value="#{workingSetController.activeWorkingSetStatusMessage}"></h:outputText>
		<hr />
		<h:commandLink action="#{workingSetController.newWS}">New</h:commandLink>&nbsp;&nbsp;|&nbsp;&nbsp;<h:commandLink
			action="ws_open">Open</h:commandLink>
		<br />
		<h:outputLink>all</h:outputLink>&nbsp;&nbsp;|&nbsp;&nbsp;<h:outputLink>none</h:outputLink>
		<br />
		<h:selectManyListbox id="wsid"
			value="#{workingSetController.selectedWSUsersList}" size="10"
			converter="#{UserDataConverter}" style="width:200px">
			<f:selectItems value="#{workingSetController.activeWSUsersList}"
				var="user" itemLabel="#{user.fullName}" />
			<f:validator validatorId="UserDataValidator" />
		</h:selectManyListbox>
		<br />
		<h:message for="wsid" style="color:RED" />
		<br />
		<h:commandButton value="Delete"
			action="#{workingSetController.deleteWSUsers}" onclick="if (!confirm('Are you sure?')) return false"></h:commandButton>
			&nbsp; &nbsp; &nbsp;
		<h:commandButton value="Save" action="ws_save"></h:commandButton>
		<br/>
		<br/>
		<h:commandLink action="ws_home">
			<h:outputText value="WS Home"></h:outputText>
		</h:commandLink>&nbsp;&nbsp;|&nbsp;&nbsp;
		
		<h:commandLink action="home">
			<h:outputText value="Home"></h:outputText>
		</h:commandLink>

	</h:form>

</f:view>
</body>
</html>