<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<link
	href="${facesContext.externalContext.requestContextPath}/css/datascroller.css"
	media="screen" rel="stylesheet" type="text/css" />
<link
	href="${facesContext.externalContext.requestContextPath}/css/font.css"
	media="screen" rel="stylesheet" type="text/css" />
<link
	href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css" />
<f:subview id="edit-program-profile">
	<h:form id="edit_userprogramprofile_manager">
		<br />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="Edit User program profile" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />

		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma">
					<h:outputText value="User Program Profile Information: " />
				</font>
			</h:panelGroup>

			<h:selectOneListbox id="programProfileListid"
				value="#{accountManagementController.selectedUserProgramProfile}"
				size="1" converter="#{UserProgramProfileDataConverter}"
				style="width: 200px;" required="true" immediate="true"
				requiredMessage="User program profile: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems
					value="#{accountManagementController.userProgramProfileList}"
					var="programprofile"
					itemLabel="#{programprofile.program} - #{programprofile.programDomain}" />
				<f:validator validatorId="UserProgramProfileDataValidator" />
				<a4j:support event="onchange" ajaxSingle="true" limitToList="true"
					action="#{accountManagementController.valueChangeEditUserProgramProfile}"
					reRender="program_list_id,program_domain_list_id,program_group_list_id,program_track_list_id,ukmajor_list_id,ukstatus_list_id,ukstartterm_list_id,ukchangeterm_list_id,ukanticipatedcompleteterm_list_id,ukcompleteterm_list_label,ukcompleteterm_list_id,advisor_list_id,final_gpa_label,final_gpa,degree_awarded_id,recommend_certification,hidden,shortDesc,facultyAdvisor_list_id" />
			</h:selectOneListbox>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Program Domain: *" /></font>
			</h:panelGroup>
			<h:selectOneListbox id="program_domain_list_id" style="width:200px"
				value="#{accountManagementController.selectedProgramDomain}"
				size="1" converter="#{ProgramDomainDataConverter}" required="true"
				requiredMessage="Program Domain: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems var="programDomain"
					value="#{cepisGlobalComponentConfigurator.programDomainList}"					
					itemLabel="#{programDomain.programDomainCode} - #{programDomain.description} (#{programDomain.status})" />
				<f:validator validatorId="ProgramDomainDataValidator" />
				<a4j:support event="onchange" ajaxSingle="true" limitToList="true"
					actionListener="#{accountManagementController.valueChangeProgramDomain}"
					reRender="program_list_id" />
			</h:selectOneListbox>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Program: *" /></font>
			</h:panelGroup>
			<h:selectOneListbox id="program_list_id" style="width:200px"
				value="#{accountManagementController.selectedProgram}" size="1"
				converter="#{ProgramDataConverter}" required="true"
				requiredMessage="Program: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.programListInProgramDomain}"
					var="program" itemLabel="#{program.programCode} - #{program.description} (#{program.status})" />
				<f:validator validatorId="ProgramDataValidator" />

			</h:selectOneListbox>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Program Group: *" /></font>
			</h:panelGroup>
			<h:selectOneListbox immediate="true" id="program_group_list_id"
				style="width:200px"
				value="#{accountManagementController.selectedProgramGroup}"
				onchange="sumbit()" size="1"
				converter="#{ProgramGroupDataConverter}" required="true"
				requiredMessage="Program Group: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.programGroupList}"
					var="programGroup" itemLabel="#{programGroup.programGroupCode} - #{programGroup.description} (#{programGroup.status})" />
				<f:validator validatorId="ProgramGroupDataValidator" />
			</h:selectOneListbox>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Program Track: *" /></font>
			</h:panelGroup>
			<h:selectOneListbox immediate="true" id="program_track_list_id"
				style="width:200px"
				value="#{accountManagementController.selectedProgramTrack}"
				onchange="sumbit()" size="1"
				converter="#{ProgramTrackDataConverter}" required="true"
				requiredMessage="Program Track: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.programTrackList}"
					var="programTrack" itemLabel="#{programTrack.programTrackCode} - #{programTrack.description} (#{programTrack.status})" />
				<f:validator validatorId="ProgramTrackDataValidator" />
			</h:selectOneListbox>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Major: *" /></font>
			</h:panelGroup>
			<h:selectOneListbox immediate="true" id="ukmajor_list_id"
				style="width:200px"
				value="#{accountManagementController.selectedUKMajor}" size="1"
				onchange="sumbit()" converter="#{UKMajorDataConverter}"
				required="true" requiredMessage="Major: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.ukMajorList}"
					var="ukMajor" itemLabel="#{ukMajor.ukMajorCode} | #{ukMajor.description}" />
				<f:validator validatorId="UKMajorDataValidator" />
			</h:selectOneListbox>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Status: " /></font>
			</h:panelGroup>
			<h:selectOneListbox immediate="true" id="ukstatus_list_id"
				style="width:200px"
				value="#{accountManagementController.ppSelectedUKStatus}" size="1"
				converter="#{UKStatusDataConverter}">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.ukStatusList}"
					var="ukStatus" itemLabel="#{ukStatus.statusCode} | #{ukStatus.description}" />
				<f:validator validatorId="UKStatusDataValidator" />
				<a4j:support event="onchange" ajaxSingle="true" limitToList="true"
					actionListener="#{accountManagementController.valueChangeUserProgramProfileStatus}"
					reRender="ukcompleteterm_list_id,ukcompleteterm_list_label,final_gpa,final_gpa_label" />
			</h:selectOneListbox>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Start Term: *" /></font>
			</h:panelGroup>
			<h:selectOneListbox immediate="true" id="ukstartterm_list_id"
				style="width:200px"
				value="#{accountManagementController.ppSelectedUKStartTerm}"
				size="1" onchange="sumbit()" converter="#{UKTermDataConverter}"
				required="true" requiredMessage="Start Term: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.ukTermList}" var="ukTerm"
					itemLabel="#{ukTerm.ukTermCode} | #{ukTerm.description}" />
				<f:validator validatorId="UKTermDataValidator" />
			</h:selectOneListbox>		
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Anticipated Complete Term: *" /></font>
			</h:panelGroup>
			<h:selectOneListbox id="ukanticipatedcompleteterm_list_id"
				style="width:200px"
				value="#{accountManagementController.selectedUKAnticipatedCompleteTerm}"
				size="1" converter="#{UKTermDataConverter}" required="true"
				requiredMessage="Anticipated Complete Term: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.ukTermList}" var="ukTerm"
					itemLabel="#{ukTerm.shortDesc}" />
				<f:validator validatorId="UKTermDataValidator" />
			</h:selectOneListbox>
			<h:panelGroup id="ukcompleteterm_list_label">
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma">
						<h:outputText value="End Term:" />
					</font>
				</h:panelGroup>
			</h:panelGroup>
			<h:panelGroup id="ukcompleteterm_list_id">
				<h:selectOneListbox style="width:200px"
					value="#{accountManagementController.selectedUKCompleteTerm}"
					onchange="sumbit()" size="1" converter="#{UKTermDataConverter}">
					<f:selectItem itemLabel="Select One" itemValue="NA" />
					<f:selectItems
						value="#{cepisGlobalComponentConfigurator.ukTermList}"
						var="ukTerm" itemLabel="#{ukTerm.shortDesc}" />
					<f:validator validatorId="UKTermDataValidator" />
				</h:selectOneListbox>
			</h:panelGroup>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma">
					<h:outputText value="Professional Advisor:" />
				</font>
			</h:panelGroup>
			<h:selectOneListbox immediate="true" id="advisor_list_id"
				style="width:200px"
				value="#{accountManagementController.selectedAdvisor}" size="1"
				onchange="sumbit()" converter="#{AdvisorDataConverter}">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.advisorList}"
					var="advisor" itemLabel="#{advisor.shortDesc}" />
				<f:validator validatorId="AdvisorDataValidator" />
			</h:selectOneListbox>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma">
					<h:outputText value="Faculty Advisor:" />
				</font>
			</h:panelGroup>
			<h:selectOneListbox immediate="true" id="facultyAdvisor_list_id"
				style="width:200px"
				value="#{accountManagementController.selectedFacultyAdvisor}" size="1"
				onchange="sumbit()" converter="#{FacultyAdvisorDataConverter}">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.facultyAdvisorList}"
					var="facultyAdvisor" itemLabel="#{facultyAdvisor.shortDesc}" />
				<f:validator validatorId="FacultyAdvisorDataValidator" />
			</h:selectOneListbox>
			<h:panelGroup id="final_gpa_label">
				<h:panelGroup
					rendered="#{accountManagementController.showProgramProfileCompleteOptions}">
					<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
							value="Final GPA: *" /></font>
					<h:graphicImage id="gpa" url="/images/info.png" alt="i" title="i" />
					<rich:toolTip for="gpa"
						value="Enter the final GPA of the completed student."></rich:toolTip>
				</h:panelGroup>
			</h:panelGroup>
			<h:panelGroup id="final_gpa">
				<rich:inputNumberSpinner
					rendered="#{accountManagementController.showProgramProfileCompleteOptions}"
					value="#{accountManagementController.finalGPA}" step="0.5"
					maxValue="4" required="true"
					requiredMessage="Final GPA: Value is required.">
				</rich:inputNumberSpinner>
			</h:panelGroup>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Degree Awarded: " /></font>
			</h:panelGroup>
			<h:selectOneListbox id="degree_awarded_id" style="width:200px"
				value="#{accountManagementController.degreeAwarded}" size="1">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItem itemLabel="NO" itemValue="0" />
				<f:selectItem itemLabel="YES" itemValue="1" />
				<f:converter converterId="javax.faces.Integer" />
			</h:selectOneListbox>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Certification Recommended? " /></font>
				<h:graphicImage id="recommend" url="/images/info.png" alt="i"
					title="i" />
				<rich:toolTip for="recommend"
					value="Select this option if the student has been recommended for a certification, even if there is no valid certification profile associated with the selected student."></rich:toolTip>
			</h:panelGroup>
			<h:selectBooleanCheckbox id="recommend_certification"
				value="#{accountManagementController.recommendCertification}"></h:selectBooleanCheckbox>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Hidden? " /></font>
				<h:graphicImage id="hide" url="/images/info.png" alt="i"
					title="Info" />
				<rich:toolTip for="hide"
					value="Hide this program profile from the selected student."></rich:toolTip>
			</h:panelGroup>
			<h:selectBooleanCheckbox id="hidden"
				value="#{accountManagementController.hiddenToStudent}"></h:selectBooleanCheckbox>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="Memo :"></h:outputText></font>
				<br />
				<h:outputText
					value="Short description for the drop-down box. Max 255 characters"
					style="color:gray"></h:outputText>
			</h:panelGroup>
			<h:inputTextarea id="shortDesc"
				value="#{accountManagementController.ppShortDesc}"
				style="width:200px" rows="2">
				<f:validateLength minimum="0" maximum="255" />
			</h:inputTextarea>
			<h:message for="edit_userprogramprofile_button"></h:message>
			<h:commandButton id="edit_userprogramprofile_button" value="Save"
				action="#{accountManagementController.editUserProgramProfile}"></h:commandButton>
		</h:panelGrid>

	</h:form>
</f:subview>