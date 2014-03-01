<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a4j"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:view afterPhase="#{appComponentController.initApplicationComponent}">
	<h:message for="add_program_domain_manager">
	</h:message>
	<h:form id="add_program_domain_manager">
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
					value="Add a program to a program domain" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<br />
		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma">Select
				Program Domain:</font>
			</h:panelGroup>
			<h:selectOneListbox id="program_domain_list_id"
				value="#{appComponentController.selectedProgramDomain}" size="1"
				converter="#{ProgramDomainDataConverter}" style="width:200px">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.programDomainList}"
					var="programDomain" itemLabel="#{programDomain.shortDesc}" />
				<f:validator validatorId="ProgramDomainDataValidator" />
			</h:selectOneListbox>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma">Select
				Program:</font>
			</h:panelGroup>
			<h:selectOneListbox id="program_domain_program_list_id"
				value="#{appComponentController.selectedProgram}" size="1"
				converter="#{ProgramDataConverter}" style="width:200px">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.programList}"
					var="program" itemLabel="#{program.shortDesc}" />
				<f:validator validatorId="ProgramDataValidator" />
			</h:selectOneListbox>
			<h:message for="view_program_domain_button"></h:message>
			<h:commandButton id="view_program_domain_button" value="Add"
				action="#{appComponentController.addProgramToProgramDomain}"></h:commandButton>
		</h:panelGrid>
	</h:form>
</f:view>