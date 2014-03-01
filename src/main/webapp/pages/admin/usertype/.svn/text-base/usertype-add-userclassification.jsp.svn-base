<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a4j"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:view afterPhase="#{appComponentController.initApplicationComponent}">
	<h:message for="add_usertype_manager">
	</h:message>
	<h:form id="add_usertype_manager">
		<br />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/warning.gif"
				rendered="#{appComponentController.appComponentWarnStatus}" alt="!"
				title="Warning!" />
			<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
				value="#{appComponentController.appComponentStatusMessage}" /></font>
		</h:panelGrid>
		<hr />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Add a userclassification to a usertype" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<br />
		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma">Select
				User Type:</font>
			</h:panelGroup>
			<h:selectOneListbox id="usertype_list_id"
				value="#{appComponentController.selectedUserType}" size="1"
				converter="#{UserTypeDataConverter}" style="width:200px">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.userTypeList}"
					var="userType" itemLabel="#{userType.shortDesc}" />
				<f:validator validatorId="UserTypeDataValidator" />
			</h:selectOneListbox>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma">Select
				UserClassification:</font>
			</h:panelGroup>
			<h:selectOneListbox id="usertype_userclassification_list_id"
				value="#{appComponentController.selectedUserClassification}" size="1"
				converter="#{UserClassificationDataConverter}" style="width:200px">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.userClassificationList}"
					var="userClassification" itemLabel="#{userClassification.shortDesc}" />
				<f:validator validatorId="UserClassificationDataValidator" />
			</h:selectOneListbox>
			<h:message for="view_usertype_button"></h:message>
			<h:commandButton id="view_usertype_button" value="Add"
				action="#{appComponentController.addUserClassificationToUserType}"></h:commandButton>
		</h:panelGrid>
	</h:form>
</f:view>