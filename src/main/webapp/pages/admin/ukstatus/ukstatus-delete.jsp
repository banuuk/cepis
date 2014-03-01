<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:view afterPhase="#{userDetailController.initApplicationComponent}">
	<h:message for="delete_ukstatus_manager">
	</h:message>
	<h:form id="delete_ukstatus_manager">
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
					value="Delete existing status" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<br />
		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma">Select
				Status: </font>
			</h:panelGroup>
			<h:selectOneListbox id="ukstatus_list_id"
				value="#{userDetailController.selectedUKStatus}" size="1"
				style="width:200px" converter="#{UKStatusDataConverter}">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.ukStatusList}"
					var="ukStatus" itemLabel="#{ukStatus.shortDesc}" />
				<f:validator validatorId="UKStatusDataValidator" />

			</h:selectOneListbox>


			<h:message for="delete_ukstatus_button"></h:message>

			<h:commandButton id="delete_ukstatus_button" value="Delete"
				action="#{userDetailController.deleteUKStatus}"></h:commandButton>
		</h:panelGrid>
	</h:form>
</f:view>
