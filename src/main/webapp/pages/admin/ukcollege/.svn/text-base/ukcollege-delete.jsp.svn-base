<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:view afterPhase="#{appComponentController.initApplicationComponent}">
	<h:message for="delete_ukcollege_manager">
	</h:message>
	<h:form id="delete_ukcollege_manager">
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
					value="Delete existing ukcollege from CEPIS System" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<br />
		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma">Select UKCollege:</font>
			</h:panelGroup>
			<h:selectOneListbox id="ukcollege_list_id"
				value="#{appComponentController.selectedUKCollege}" size="1"
				converter="#{UKCollegeDataConverter}" style="width:200px">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.ukCollegeList}"
					var="ukcollege" itemLabel="#{ukcollege.collegeName}" />
				<f:validator validatorId="UKCollegeDataValidator" />
			</h:selectOneListbox>
			<h:message for="delete_ukcollege_button"></h:message>
			<h:commandButton id="delete_ukcollege_button" value="Delete"
				action="#{appComponentController.deleteUKCollege}"></h:commandButton>
		</h:panelGrid>
	</h:form>
</f:view>