<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>logging out ...</title>
<script type="text/javascript">
	function logOutUser() {
		document.getElementById('logout:go').click();
	}
</script>
</head>
<body onload="javascript:logOutUser();">
	<f:view>
		<h:form id="logout">
			<h:outputText value=" Logging out. Please wait ... "
				style='font-family: "Book Antiqua", "Times New Roman", Serif; font-size: 14px; color: #FFFFFF; background-color: #FF0000' />
			<h:commandButton id="go" value=""
				action="#{whoamiController.logOut}"
				style="; background-color: #FFFFFF; height: 19px; width: 0px; ">
			</h:commandButton>
		</h:form>
	</f:view>

</body>
</html>