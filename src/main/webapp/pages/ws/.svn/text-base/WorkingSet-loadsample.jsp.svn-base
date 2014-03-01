
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Load Sample data to Working Set</title>
</head>
<body>
<f:view>
	<h:form id="load_ws">
		<h:outputText value="Load Sample Data (Search module will be replaced for this)"></h:outputText><br/>
		<h:selectManyListbox id="wsid"
			value="#{workingSetController.selectedWSUsersList}" size="10">
			<f:selectItems 
				value="#{workingSetController.sampleData}" />
		</h:selectManyListbox>
		<br/>
		
		<hr>
		<h:commandLink id="wshome" action="ws_home">
			<h:outputText value="WS Home"></h:outputText>
		</h:commandLink>&nbsp;&nbsp;|&nbsp;&nbsp;
		
		<h:commandLink id="cepishome" action="home">
			<h:outputText value="Home"></h:outputText>
		</h:commandLink>
		<h:message for="wshome" style="color:RED" />
		<h:message for="cepishome" style="color:RED" />
	</h:form>
	<h:message for="load_ws" style="color:RED" />
</f:view>
</body>
</html>