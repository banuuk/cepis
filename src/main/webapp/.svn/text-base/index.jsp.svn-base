<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loading ...</title>
<script type="text/javascript">
	function initializeUser(){
		document.getElementById('init:go').click();
	}
</script>
</head>
<body onload="javascript:initializeUser();">
<f:view>
	<h:form id="init">
		<h:outputText value=" Loading ... "
			style='font-family: "Book Antiqua", "Times New Roman", Serif; font-size: 14px; color: #FFFFFF; background-color: #FF0000' />
		<h:commandButton id="go" value=""
			actionListener="#{initController.initialize}" action="home"
			style="; background-color: #FFFFFF; height: 19px; width: 0px; ">
			<f:attribute name="request" value="#{request}" />
		</h:commandButton>
	</h:form>
</f:view>

</body>
</html>