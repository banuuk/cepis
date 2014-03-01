<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:subview id="add-program-profile">
	<h:form id="add_userprogramprofile_manager" styleClass="styleish">
	
		<h:outputLabel for="programProfileAdd-separator" value="Add User Program Profile" styleClass="medium-bold"/>	
		<rich:separator id="programProfileAdd-separator" lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>
		
		<h:panelGrid columns="2" style="padding-right: 100px; padding-left: 100px">
		
			<h:outputLabel for="programDomain_list" styleClass="small" value="Program Domain : *" />
			<h:selectOneListbox id="programDomain_list" style="width:200px"
			value="#{accountManagementController.selectedProgramDomain}"
			size="1" converter="#{ProgramDomainDataConverter}" required="true"
			requiredMessage="Program Domain: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems value="#{cepisGlobalComponentConfigurator.programDomainList}" var="programDomain"
				itemLabel="#{programDomain.programDomainCode} - #{programDomain.description} (#{programDomain.status})" />
				<f:validator validatorId="ProgramDomainDataValidator" />
				<a4j:support event="onchange" ajaxSingle="true" limitToList="true" reRender="program_list"
				actionListener="#{accountManagementController.valueChangeProgramDomain}" />
			</h:selectOneListbox>
			
			<h:outputLabel for="program_list" styleClass="small" value="Program : *" />
			<h:selectOneListbox id="program_list" style="width:200px"
			value="#{accountManagementController.selectedProgram}" size="1"
			converter="#{ProgramDataConverter}" required="true"
			requiredMessage="Program: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems value="#{cepisGlobalComponentConfigurator.programListInProgramDomain}"
				var="program" itemLabel="#{program.programCode} - #{program.description} (#{program.status})" />
				<f:validator validatorId="ProgramDataValidator" />
			</h:selectOneListbox>
			
			<h:outputLabel for="programGroup_list" styleClass="small" value="Program Group : *" />
			<h:selectOneListbox id="programGroup_list" style="width:200px"
			value="#{accountManagementController.selectedProgramGroup}" size="1"
			converter="#{ProgramGroupDataConverter}" required="true"
			requiredMessage="Program Group: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems value="#{cepisGlobalComponentConfigurator.programGroupList}" var="programGroup"
				itemLabel="#{programGroup.programGroupCode} - #{programGroup.description} (#{programGroup.status})" />
				<f:validator validatorId="ProgramGroupDataValidator" />
			</h:selectOneListbox>
			
			<h:outputLabel for="programTrack_list" styleClass="small" value="Program Track : *" />
			<h:selectOneListbox id="programTrack_list" style="width:200px"
			value="#{accountManagementController.selectedProgramTrack}" size="1"
			converter="#{ProgramTrackDataConverter}" required="true"
			requiredMessage="Program Track: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems value="#{cepisGlobalComponentConfigurator.programTrackList}" var="programTrack"
				itemLabel="#{programTrack.programTrackCode} - #{programTrack.description} (#{programTrack.status})" />
				<f:validator validatorId="ProgramTrackDataValidator" />
			</h:selectOneListbox>
			
			<h:outputLabel for="programTrack_list" styleClass="small" value="Major : *" />
			<h:selectOneListbox id="ukmajor_list" style="width:200px"
			value="#{accountManagementController.selectedUKMajor}" size="1"
			converter="#{UKMajorDataConverter}" required="true"
			requiredMessage="Major: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems value="#{cepisGlobalComponentConfigurator.ukMajorList}"
				var="ukMajor" itemLabel="#{ukMajor.ukMajorCode} | #{ukMajor.description}" />
				<f:validator validatorId="UKMajorDataValidator" />
			</h:selectOneListbox>
			
			<h:outputLabel for="ukStatus_list" styleClass="small" value="Status : " />
			<h:selectOneListbox id="ukStatus_list" style="width:200px"
			value="#{accountManagementController.ppSelectedUKStatus}" size="1"
			converter="#{UKStatusDataConverter}">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems value="#{cepisGlobalComponentConfigurator.ukStatusList}"
				var="ukStatus" itemLabel="#{ukStatus.statusCode} | #{ukStatus.description}" />
				<f:validator validatorId="UKStatusDataValidator" />
				<a4j:support event="onchange" ajaxSingle="true" limitToList="true"
				actionListener="#{accountManagementController.valueChangeUserProgramProfileStatus}"
				reRender="finalGPA, finalGPA_label" />
			</h:selectOneListbox>
			
			<h:outputLabel for="ukStartTerm_list" styleClass="small" value="Start Term : *" />
			<h:selectOneListbox id="ukStartTerm_list" style="width:200px"
			value="#{accountManagementController.ppSelectedUKStartTerm}"
			size="1" converter="#{UKTermDataConverter}" required="true"
			requiredMessage="Start Term: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems value="#{cepisGlobalComponentConfigurator.ukTermList}" var="ukTerm"
				itemLabel="#{ukTerm.ukTermCode} | #{ukTerm.description}" />
				<f:validator validatorId="UKTermDataValidator" />
			</h:selectOneListbox>
		
			<h:outputLabel for="ukAnticipatedCompleteTerm_list" styleClass="small" value="Anticipated Complete Term : *" />
			<h:selectOneListbox id="ukAnticipatedCompleteTerm_list" style="width:200px"
			value="#{accountManagementController.selectedUKAnticipatedCompleteTerm}"
			size="1" converter="#{UKTermDataConverter}" required="true"
			requiredMessage="Anticipated Complete Term: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems value="#{cepisGlobalComponentConfigurator.ukTermList}" var="ukTerm"
				itemLabel="#{ukTerm.shortDesc}" />
				<f:validator validatorId="UKTermDataValidator" />
			</h:selectOneListbox>
			
			<h:outputLabel for="ukcompleteterm_list" styleClass="small" value= "End Term : " />
			<h:selectOneListbox id="ukcompleteterm_list" style="width:200px"
			value="#{accountManagementController.selectedUKCompleteTerm}"
			onchange="sumbit()" size="1" converter="#{UKTermDataConverter}">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems value="#{cepisGlobalComponentConfigurator.ukTermList}"
				var="ukTerm" itemLabel="#{ukTerm.shortDesc}" />
				<f:validator validatorId="UKTermDataValidator" />
			</h:selectOneListbox>
		
			<h:outputLabel for="advisor_list" styleClass="small" value="Professional Advisor :" />
			<h:selectOneListbox id="advisor_list" style="width:200px"
			value="#{accountManagementController.selectedAdvisor}" size="1"
			converter="#{AdvisorDataConverter}">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems value="#{cepisGlobalComponentConfigurator.advisorList}"
				var="advisor" itemLabel="#{advisor.shortDesc}" />
				<f:validator validatorId="AdvisorDataValidator" />
			</h:selectOneListbox>
			
			<h:outputLabel for="facultyAdvisor_list" styleClass="small"  value="Faculty Advisor :" />
			<h:selectOneListbox id="facultyAdvisor_list" style="width:200px"
				value="#{accountManagementController.selectedFacultyAdvisor}" size="1"
				converter="#{FacultyAdvisorDataConverter}">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.facultyAdvisorList}"
					var="facultyAdvisor" itemLabel="#{facultyAdvisor.shortDesc}" />
				<f:validator validatorId="FacultyAdvisorDataValidator" />
			</h:selectOneListbox>
			
			<h:panelGroup id="finalGPA_label">
				<h:outputLabel for="finalGPA" styleClass="small" value="Final GPA : "
				rendered="#{accountManagementController.showProgramProfileCompleteOptions}" />
			</h:panelGroup>
			<h:panelGroup id="finalGPA">
				<rich:inputNumberSpinner value="#{accountManagementController.finalGPA}" step="0.1"
				rendered="#{accountManagementController.showProgramProfileCompleteOptions}"/>
			</h:panelGroup>
			<h:outputLabel for="degreeAwarded" styleClass="small" value="Degree Awarded : " />
			<h:selectOneListbox id="degreeAwarded" style="width:200px"
			value="#{accountManagementController.degreeAwarded}" size="1">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItem itemLabel="NO" itemValue="0" />
				<f:selectItem itemLabel="YES" itemValue="1" />
				<f:converter converterId="javax.faces.Integer" />
			</h:selectOneListbox>
			
			<h:panelGroup>
				<h:outputLabel for="recommend" styleClass="small" value="Certification Recommended : " />
				<h:graphicImage id="recommend" url="/images/person.png" alt="i" />
				<rich:toolTip for="recommend" value="Select this option if the student has been recommended for a certification, even if there is no valid certification profile associated with the selected student."/>
			</h:panelGroup>
			<h:selectBooleanCheckbox id="recommendCertification"
			value="#{accountManagementController.recommendCertification}"/>
			
			<h:panelGroup>
				<h:outputLabel for="hide" styleClass="small" value="Hide User Program Profile : " />
				<h:graphicImage id="hide" url="/images/person.png" alt="i" />
				<rich:toolTip for="hide" value="Hide this program profile from the selected student." />
			</h:panelGroup>
			<h:selectBooleanCheckbox id="hideCertification"
			value="#{accountManagementController.hiddenToStudent}"/>
			
			<h:outputLabel for="memo" styleClass="small" value="Memo :"/>
			<h:inputTextarea id="memo" value="#{accountManagementController.ppShortDesc}"
			style="width:200px" rows="2">
				<f:validateLength minimum="0" maximum="255" />
			</h:inputTextarea>
			<h:message for="addUserProgramProfile_button"/>
			<h:commandButton id="addUserProgramProfile_button" value="Add" styleClass="buttonStyle"
			action="#{accountManagementController.addUserProgramProfileToUser}"/>
		</h:panelGrid>
	</h:form>
</f:subview>