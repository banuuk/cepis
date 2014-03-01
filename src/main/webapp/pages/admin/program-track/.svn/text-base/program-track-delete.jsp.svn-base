<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:view afterPhase="#{appComponentController.initApplicationComponent}">
	<h:message for="delete_program_track_manager">
	</h:message>
	<h:form id="delete_program_track_manager">
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
					value="Delete existing program track from CEPIS System" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<br />
		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma">Select
				Program Track:</font>
			</h:panelGroup>
			<h:selectOneListbox id="program_track_list_id"
				value="#{appComponentController.selectedProgramTrack}" size="1"
				converter="#{ProgramTrackDataConverter}" style="width:200px">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.programTrackList}"
					var="programTrack" itemLabel="#{programTrack.shortDesc}" />
				<f:validator validatorId="ProgramTrackDataValidator" />
			</h:selectOneListbox>
			<h:message for="delete_program_track_button"></h:message>
			<h:commandButton id="delete_program_track_button" value="Delete"
				action="#{appComponentController.deleteProgramTrack}"></h:commandButton>
		</h:panelGrid>
	</h:form>
</f:view>