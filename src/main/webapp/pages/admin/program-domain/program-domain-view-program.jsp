
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<html>
<head>
<title>CEPIS Program Domain Manager - View Programs</title>
</head>
<body>
<f:view afterPhase="#{appComponentController.initApplicationComponent}">
	<h:message for="view_program_domain_manager">
	</h:message>
	<h:form id="view_program_domain_manager">
		<h:outputText
			value="View Program list for existing program domain in CEPIS Portal for College of Education"></h:outputText>
		<hr />
		<h:outputText value="#{appComponentController.appComponentWarnStatus}"></h:outputText>&nbsp;&nbsp;
		<h:outputText
			value="#{appComponentController.appComponentStatusMessage}"></h:outputText>
		<hr />
		<a4j:region selfRendered="true"
			ajaxListener="#{appComponentController.valueChangeProgramDomainProgramList}"
			id="programdomainprogramlist_ajaxregion">
			<a4j:status
				startText="Please wait ... Request sent to the CEPIS Portal"
				stopText="CEPIS Portal reply received">
				<h:selectOneListbox id="program_domain_list_id"
					value="#{appComponentController.selectedProgramDomain}" size="1"
					converter="#{ProgramDomainDataConverter}">
					<f:selectItem itemLabel="Select One" itemValue="NA"/>
					<f:selectItems value="#{cepisGlobalComponentConfigurator.programDomainList}"
						var="programDomain" itemLabel="#{programDomain.shortDesc}" />
					<f:validator validatorId="ProgramDomainDataValidator" />
					<a4j:support event="onchange"
						reRender="program_domain_list_id,program_domain_program_list_id" />
				</h:selectOneListbox>
				<br />
			</a4j:status>
			<br />
			<h:selectOneListbox id="program_domain_program_list_id"
				value="#{appComponentController.selectedProgram}" size="10"
				converter="#{ProgramDataConverter}" disabled="true">
				<f:selectItems
					value="#{appComponentController.programDomain_ProgramList}"
					var="program" itemLabel="#{program.shortDesc}" />
				<f:validator validatorId="ProgramDataValidator" />

			</h:selectOneListbox>
			<br />
		</a4j:region>

	</h:form>

</f:view>
</body>
</html>