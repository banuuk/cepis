<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ include file="/common/header.jsp"%>

<script type="text/javascript">
	document.title = "CEPIS Add Manager ";
	var global_title = document.getElementById('global_title');
	global_title.innerHTML = "CEPIS Add a Person";
</script>

<link href="${facesContext.externalContext.requestContextPath}/css/font.css"
	media="screen" rel="stylesheet" type="text/css" />
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css" />
<link href="${facesContext.externalContext.requestContextPath}/css/add.css"
	media="screen" rel="stylesheet" type="text/css" />
	
<f:view afterPhase="#{accountManagementController.initAccountManagement}">
	<h:form id="add_manager">
			
		<a4j:outputPanel id="addMessages" ajaxRendered="true" style="align:center;">
			<h:panelGrid columns="1" width="98%" id="messageSection">
				<rich:messages errorClass="cepiserror" infoClass="cepissuccess"
				warnClass="cepiswarning" tooltip="true" id="cepisMsgs"/>
			</h:panelGrid>
			<a4j:status onstart="showModalInfoWindow();" onstop="hideModalInfoWindow()"/>
		</a4j:outputPanel>
				
		<h:panelGrid width="100%" style="align:center;text-align:center;">
		
			<h:panelGroup>			
				<h:commandButton value="Add User"
				style="font-weight: bold; width: 145px"
				action="#{accountManagementController.addCEPISUser}"/>				
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
				<a4j:commandButton value="Clear"
				reRender="part1,nonUKUserOption,psp_enable,psp,address_enable,address,email_enable,email,phone_enable,phone,role_enable,role,report_enable,report"
				ajaxSingle="true" style="font-weight: bold; width: 145px"
				limitToList="true"
				action="#{accountManagementController.clearAllValues}"/>
				
			</h:panelGroup>
			
		</h:panelGrid>
		<h:panelGrid width="100%" id="nonUKSection"
			style="align:right;text-align:right;">
			<h:panelGroup>
				<h:selectBooleanCheckbox id="nonUKUserOption"
					title="Enable Non-UK user options"
					value="#{accountManagementController.enableNonUKUserOptions}">
					<a4j:support event="onclick" ajaxSingle="true" limitToList="true"
						reRender="identitySection,collegeProfileSection,role_enable,role"
						actionListener="#{accountManagementController.valueChangeNonUKUserOptions}"></a4j:support>
				</h:selectBooleanCheckbox>&nbsp;<h:outputLabel for="nonUKUserOption" value="Non-UK user"></h:outputLabel>
			</h:panelGroup>
		</h:panelGrid>
		<h:panelGrid id="part1" columns="3"
			style="valign:top;padding-left: 10px" width="100%">
			<h:panelGroup layout="block" id="identitySection"
				style="width:100%;height:394px; z-index:15;background-color:#F0F0F0">
				<h:panelGroup layout="block"
					style="background-color:#C6D0F1;text-align: center;height:22px">
					<font class="ws12" color="#366B96" face="Tahoma"><b>Identity
							Information</b></font>
				</h:panelGroup>
				<h:panelGroup layout="block"
					style="background-color: #FFFFFF;height:3px;z-index:51;"></h:panelGroup>
				<h:panelGroup layout="block" style="height:10px;z-index:51;"></h:panelGroup>

				<h:panelGrid columns="2"
					rendered="#{accountManagementController.enableNonUKUserOptions}">
					<h:panelGroup style="width:150px;" layout="block">
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
								value="Username: *" /></font>
					</h:panelGroup>
					<h:inputText value="#{accountManagementController.username}"
						style="width:180px" required="true"
						requiredMessage="User name: Value is required."
						validatorMessage="Username: Value is invalid. Please use characters from these sets: (A-Z), (a-z) and (0-9).">
						<a4j:support event="onblur" ajaxSingle="true" limitToList="true"
							actionListener="#{accountManagementController.valueChangeCheckDuplicateUsername}"
							reRender="addMessages" />
						<f:validateRegex pattern="[A-Za-z0-9]+" />
						<f:validateLength maximum="50" />
					</h:inputText>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
								value="Password: *" /></font>
					</h:panelGroup>
					<h:inputSecret id="cepisPwd"
						value="#{accountManagementController.password}"
						style="width:180px" required="true"
						requiredMessage="Password: Value is required."
						validatorMessage="Password: Value is invalid.">
						<f:validateLength maximum="100" />
					</h:inputSecret>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
								value="Password (Verify): *" /></font>
					</h:panelGroup>
					<h:inputSecret id="cepisVerifyPwd"
						value="#{accountManagementController.verifyPassword}"
						style="width:180px" required="true"
						requiredMessage="Password: Value is required."
						validatorMessage="Password: Value is invalid.">
						<a4j:support event="onblur" ajaxSingle="true"
							process="cepisPwd" limitToList="true"
							actionListener="#{accountManagementController.valueChangeVerifyPassword}"
							reRender="addMessages" />
						<f:validateLength maximum="100" />
					</h:inputSecret>
				</h:panelGrid>
				<h:panelGrid columns="2"
					rendered="#{!accountManagementController.enableNonUKUserOptions}">
					<h:panelGroup style="width:150px;" layout="block">
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
								value="Link Blue Username: *" /></font>
					</h:panelGroup>
					<h:inputText value="#{accountManagementController.username}"
						style="width:180px" required="true"
						requiredMessage="User name: Value is required."
						validatorMessage="Link Blue Username: Value is invalid. Please use characters from these sets: (A-Z), (a-z) and (0-9).">
						<a4j:support event="onblur" ajaxSingle="true"
							actionListener="#{accountManagementController.valueChangeAccessLDAPInfo}"
							reRender="ukid,lname,fname,mname,usertype,pp,email_address,emailaddress,phoneno" />
						<f:validateRegex pattern="[A-Za-z0-9]+" />
						<f:validateLength maximum="50" />
					</h:inputText>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
								value="UK ID: *" /></font>
					</h:panelGroup>
					<h:inputText id="ukid" value="#{accountManagementController.ukID}"
						disabled="#{accountManagementController.enableNonUKUserOptions}"
						style="width:180px" required="true"
						requiredMessage="UK ID: Value is required."
						validatorMessage="UK ID: Value is invalid.">
						<f:validateRegex pattern="\d{8}" />
					</h:inputText>
				</h:panelGrid>
				<h:panelGrid columns="2">
					<h:panelGroup style="width:150px;" layout="block">
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
								value="SSN: " /></font>
					</h:panelGroup>
					<h:inputSecret id="ssn" redisplay="true"
						value="#{accountManagementController.ssn}" style="width:180px"
						validatorMessage="SSN: Value is invalid. Use 123456789 pattern for the social security number.">
						<f:validateRegex pattern="\d{9}" />
					</h:inputSecret>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
								value="Last Name: *" /></font>
					</h:panelGroup>
					<h:inputText id="lname"
						value="#{accountManagementController.lName}" style="width:180px"
						required="true" requiredMessage="Last name: Value is required."
						validatorMessage="Last name: Maximum 50 Characters.">
						<f:validateLength maximum="50" />
					</h:inputText>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
								value="First Name: *" /></font>
					</h:panelGroup>
					<h:inputText id="fname"
						value="#{accountManagementController.fName}" style="width:180px"
						required="true" requiredMessage="First name: Value is required."
						validatorMessage="First name: Maximum 50 Characters.">
						<f:validateLength maximum="50" />
					</h:inputText>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
								value="Middle Name: " /></font>
					</h:panelGroup>
					<h:inputText id="mname"
						value="#{accountManagementController.mName}" style="width:180px"
						validatorMessage="Middle name: Maximum 30 Characters.">
						<f:validateLength maximum="30" />
					</h:inputText>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
								value="Maiden Name: " /></font>
					</h:panelGroup>
					<h:inputText value="#{accountManagementController.maidenName}"
						style="width:180px"
						validatorMessage="Maiden name: Maximum 50 Characters.">
						<f:validateLength maximum="50" />
					</h:inputText>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
								value="Suffix: " /></font>
					</h:panelGroup>
					<h:inputText value="#{accountManagementController.suffix}"
						style="width:180px"
						validatorMessage="Suffix: Maximum 25 Characters.">
						<f:validateLength maximum="25" />
					</h:inputText>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
								value="Gender: " /></font>
					</h:panelGroup>
					<h:selectOneMenu value="#{accountManagementController.gender}"
						style="width:180px">
						<f:selectItem itemLabel="Select One" itemValue="" />
						<f:selectItem itemLabel="Male" itemValue="Male" />
						<f:selectItem itemLabel="Female" itemValue="Female" />
					</h:selectOneMenu>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
								value="Title: " /></font>
					</h:panelGroup>
					<h:inputText value="#{accountManagementController.title}"
						style="width:180px"
						validatorMessage="Title: Maximum 25 Characters.">
						<f:validateLength maximum="25" />
					</h:inputText>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
								value="Date of Birth: " /></font>
					</h:panelGroup>
					<h:inputText id="birthdate"
						value="#{accountManagementController.dOB}" style="width:180px"
						validatorMessage="Birth date: Invalid format. Use mm/dd/yyyy">
						<f:convertDateTime pattern="MM/dd/yyyy" />
					</h:inputText>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
								value="Badge Holder: " /></font>
					</h:panelGroup>
					<h:selectOneMenu value="#{accountManagementController.badgeHolder}"
						style="width:180px">
						<f:selectItem itemLabel="No" itemValue="0" />
						<f:selectItem itemLabel="Yes" itemValue="1" />
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGroup>
			<h:panelGroup layout="block" id="collegeProfileSection"
				style="width:100%;height:394px; z-index:15;background-color:#F0F0F0">
				<h:panelGroup layout="block"
					style="background-color:#C6D0F1;text-align: center;height:22px">
					<font class="ws12" color="#366B96" face="Tahoma">
						<b>College Profile Information</b>
					</font>
				</h:panelGroup>
				<h:panelGroup layout="block" style="background-color: #FFFFFF;height:3px;z-index:51;"/>
				<h:panelGroup layout="block" style="height:10px;z-index:51;"/>
				<h:panelGrid columns="2">
					<h:panelGroup style="width:150px;" layout="block">
						<font class="ws10" color="#062E8A" face="Tahoma">
							<h:outputText value="User Type: *" />
						</font>
					</h:panelGroup>
					<h:panelGroup id="usertype">
						<h:selectOneListbox id="cp_usertype_list_id"
							value="#{accountManagementController.selectedUserType}" size="1"
							converter="#{UserTypeDataConverter}" style="width:180px"
							required="true" requiredMessage="User Type: Value is required.">
							<f:selectItem itemLabel="Select One" itemValue="" />
							<f:selectItems value="#{cepisGlobalComponentConfigurator.userTypeList}"
							var="usertype" itemLabel="#{usertype.shortDesc}" />
							<a4j:support event="onchange" ajaxSingle="true" reRender="pp"
							actionListener="#{accountManagementController.valueChangeAddProgramProfileView}" />
							<f:validator validatorId="UserTypeDataValidator" />
						</h:selectOneListbox>
					</h:panelGroup>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma">
							<h:outputText value="User Classification: *" />
						</font>
					</h:panelGroup>
					<h:selectOneListbox id="cp_userclassification_list_id"
					value="#{accountManagementController.selectedUserClassification}"
					size="1" converter="#{UserClassificationDataConverter}"
					style="width:180px" required="true"
					requiredMessage="User Classification: Value is required.">
						<f:selectItem itemLabel="Select One" itemValue="" />
						<f:selectItems var="userclassification" itemLabel="#{userclassification.shortDesc}" 
						value="#{cepisGlobalComponentConfigurator.userClassificationList}" />
						<f:validator validatorId="UserClassificationDataValidator" />
					</h:selectOneListbox>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma">
							<h:outputText value="College: *" />
						</font>
					</h:panelGroup>
					<h:selectOneListbox id="cp_ukcollege_list_id"
					value="#{accountManagementController.selectedUkCollege}" size="1"
					converter="#{UKCollegeDataConverter}" style="width:180px"
					required="true" requiredMessage="College: Value is required.">
						<f:selectItem itemLabel="Select One" itemValue="" />
						<f:selectItems value="#{cepisGlobalComponentConfigurator.ukCollegeList}"
						var="ukcollege" itemLabel="#{ukcollege.collegeName}" />
						<f:validator validatorId="UKCollegeDataValidator" />
					</h:selectOneListbox>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma">
							<h:outputText value="Department: *" />
						</font>
					</h:panelGroup>
					<h:selectOneListbox id="cp_ukdepartment_list_id"
					value="#{accountManagementController.selectedUkDepartment}"
					size="1" converter="#{UKDepartmentDataConverter}"
					style="width:180px" required="true"
					requiredMessage="Department: Value is required.">
						<f:selectItem itemLabel="Select One" itemValue="" />
						<f:selectItems value="#{cepisGlobalComponentConfigurator.ukDepartmentList}"
						var="ukdepartment" itemLabel="#{ukdepartment.departmentCode} | #{ukdepartment.departmentName}" />
						<f:validator validatorId="UKDepartmentDataValidator" />
					</h:selectOneListbox>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma">
							<h:outputText value="Status: " />
						</font>
					</h:panelGroup>

					<h:selectOneListbox id="cp_ukstatus_list_id" style="width:180px"
						value="#{accountManagementController.cpSelectedUKStatus}" size="1"
						converter="#{UKStatusDataConverter}">
						<f:selectItem itemLabel="Select One" itemValue="NA" />
						<f:selectItems
							value="#{cepisGlobalComponentConfigurator.ukStatusList}"
							var="ukStatus" itemLabel="#{ukStatus.statusCode} | #{ukStatus.description}" />
						<a4j:support event="onchange" ajaxSingle="true"
							actionListener="#{accountManagementController.valueChangeAddProgramProfileView}"
							reRender="pp" />
						<f:validator validatorId="UKStatusDataValidator" />
					</h:selectOneListbox>

					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
								value="Start Term: " /></font>
					</h:panelGroup>
					<h:selectOneListbox id="cp_ukstartterm_list_id" style="width:180px"
						value="#{accountManagementController.cpSelectedUKStartTerm}"
						size="1" converter="#{UKTermDataConverter}">
						<f:selectItem itemLabel="Select One" itemValue="NA" />
						<f:selectItems
							value="#{cepisGlobalComponentConfigurator.ukTermList}"
							var="ukTerm" itemLabel="#{ukTerm.ukTermCode} | #{ukTerm.description}" />
						<f:validator validatorId="UKTermDataValidator" />
					</h:selectOneListbox>
					
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
								value="Cohort Type: " /></font>
					</h:panelGroup>
					<h:selectOneListbox id="cp_cohorttype_list_id"
						value="#{accountManagementController.selectedCohortType}" size="1"
						converter="#{CohortTypeDataConverter}" style="width:180px">
						<f:selectItem itemLabel="Select One" itemValue="NA" />
						<f:selectItems
							value="#{cepisGlobalComponentConfigurator.cohortTypeList}"
							var="cohorttype" itemLabel="#{cohorttype.shortDesc}" />
						<f:validator validatorId="CohortTypeDataValidator" />
					</h:selectOneListbox>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
								value="Cohort Term: " /></font>
					</h:panelGroup>
					<h:selectOneListbox id="cp_cohortterm_list_id"
						value="#{accountManagementController.selectedCohortTerm}" size="1"
						converter="#{CohortTermDataConverter}" style="width:180px">
						<f:selectItem itemLabel="Select One" itemValue="NA" />
						<f:selectItems
							value="#{cepisGlobalComponentConfigurator.cohortTermList}"
							var="cohortterm" itemLabel="#{cohortterm.shortDesc}" />
						<f:validator validatorId="CohortTermDataValidator" />
					</h:selectOneListbox>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
								value="Short Description :"></h:outputText></font>
					</h:panelGroup>
					<h:inputTextarea id="shortdesc"
						value="#{accountManagementController.cpShortDesc}"
						style="width:180px" rows="2">
						<f:validateLength minimum="0" maximum="255" />
					</h:inputTextarea>
				</h:panelGrid>
			</h:panelGroup>
			<h:panelGroup layout="block"
				style="width:100%;height:394px; z-index:15;background-color:#F0F0F0">
				<h:panelGroup layout="block"
					style="background-color:#C6D0F1;text-align: center;height:22px">
					<font class="ws12" color="#366B96" face="Tahoma"><b>Program
							Profile Information</b></font>
				</h:panelGroup>
				<h:panelGroup layout="block"
					style="background-color: #FFFFFF;height:3px;z-index:51;"></h:panelGroup>
				<h:panelGroup layout="block" style="height:10px;z-index:51;"></h:panelGroup>
				<h:panelGroup id="pp">
					<h:panelGrid columns="2" style="padding-left:4px;"
						rendered="#{accountManagementController.showProgramProfile}">
						<h:panelGroup style="width:150px;" layout="block">
							<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
									value="Program Domain: *" /></font>
						</h:panelGroup>
						<h:selectOneListbox id="pp_program_domain_list_id"
							style="width:180px"
							value="#{accountManagementController.selectedProgramDomain}"
							size="1" converter="#{ProgramDomainDataConverter}"
							required="true"
							requiredMessage="Program Domain: Value is required.">
							<f:selectItem itemLabel="Select One" itemValue="" />
							<f:selectItems
								value="#{cepisGlobalComponentConfigurator.programDomainList}"
								var="programDomain"
								itemLabel="#{programDomain.programDomainCode} | #{programDomain.shortDesc} (#{programDomain.status})" />
							<f:validator validatorId="ProgramDomainDataValidator" />
							<a4j:support event="onchange" ajaxSingle="true"
								limitToList="true"
								actionListener="#{accountManagementController.valueChangeProgramDomain}"
								reRender="pp_program_list_id" />
						</h:selectOneListbox>
						<h:panelGroup>
							<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
									value="Program: *" /></font>
						</h:panelGroup>
						<h:selectOneListbox id="pp_program_list_id" style="width:180px"
							value="#{accountManagementController.selectedProgram}" size="1"
							converter="#{ProgramDataConverter}" required="true"
							requiredMessage="Program: Value is required.">
							<f:selectItem itemLabel="Select One" itemValue="" />
							<f:selectItems
								value="#{cepisGlobalComponentConfigurator.programListInProgramDomain}"
								var="program"
								itemLabel="#{program.shortDesc} (#{program.status})" />
							<f:validator validatorId="ProgramDataValidator" />

						</h:selectOneListbox>
						<h:panelGroup>
							<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
									value="Program Group: *" /></font>
						</h:panelGroup>
						<h:selectOneListbox id="pp_program_group_list_id"
							style="width:180px"
							value="#{accountManagementController.selectedProgramGroup}"
							size="1" converter="#{ProgramGroupDataConverter}" required="true"
							requiredMessage="Program Group: Value is required.">
							<f:selectItem itemLabel="Select One" itemValue="" />
							<f:selectItems
								value="#{cepisGlobalComponentConfigurator.programGroupList}"
								var="programGroup" itemLabel="#{programGroup.shortDesc}" />
							<f:validator validatorId="ProgramGroupDataValidator" />
						</h:selectOneListbox>
						<h:panelGroup>
							<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
									value="Program Track: *" /></font>
						</h:panelGroup>
						<h:selectOneListbox id="pp_program_track_list_id"
							style="width:180px"
							value="#{accountManagementController.selectedProgramTrack}"
							size="1" converter="#{ProgramTrackDataConverter}" required="true"
							requiredMessage="Program Track: Value is required.">
							<f:selectItem itemLabel="Select One" itemValue="" />
							<f:selectItems
								value="#{cepisGlobalComponentConfigurator.programTrackList}"
								var="programTrack" itemLabel="#{programTrack.shortDesc}" />
							<f:validator validatorId="ProgramTrackDataValidator" />
						</h:selectOneListbox>
						<h:panelGroup>
							<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
									value="Major: *" /></font>
						</h:panelGroup>
						<h:selectOneListbox id="pp_ukmajor_list_id" style="width:180px"
							value="#{accountManagementController.selectedUKMajor}" size="1"
							converter="#{UKMajorDataConverter}" required="true"
							requiredMessage="Major: Value is required.">
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
						<h:selectOneListbox id="pp_ukstatus_list_id" style="width:180px"
							value="#{accountManagementController.ppSelectedUKStatus}"
							size="1" converter="#{UKStatusDataConverter}">
							<f:selectItem itemLabel="Select One" itemValue="NA" />
							<f:selectItems
								value="#{cepisGlobalComponentConfigurator.ukStatusList}"
								var="ukStatus" itemLabel="#{ukStatus.statusCode} | #{ukStatus.description}" />
							<f:validator validatorId="UKStatusDataValidator" />
						</h:selectOneListbox>
						<h:panelGroup>
							<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
									value="Start Term: *" /></font>
						</h:panelGroup>
						<h:selectOneListbox id="pp_ukstartterm_list_id"
							style="width:180px"
							value="#{accountManagementController.ppSelectedUKStartTerm}"
							size="1" converter="#{UKTermDataConverter}" required="true"
							requiredMessage="Start Term: Value is required.">
							<f:selectItem itemLabel="Select One" itemValue="NA" />
							<f:selectItems
								value="#{cepisGlobalComponentConfigurator.ukTermList}"
								var="ukTerm" itemLabel="#{ukTerm.ukTermCode} | #{ukTerm.description}" />
							<f:validator validatorId="UKTermDataValidator" />
						</h:selectOneListbox>				
						
						<h:panelGroup>
							<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
									value="Anticipated Complete Term:" /></font>
						</h:panelGroup>
						<h:selectOneListbox id="pp_uk_anticipated_complete_term_list_id"
							style="width:180px"
							value="#{accountManagementController.selectedUKAnticipatedCompleteTerm}"
							size="1" converter="#{UKTermDataConverter}" >
							<f:selectItem itemLabel="Select One" itemValue="NA" />
							<f:selectItems
								value="#{cepisGlobalComponentConfigurator.ukTermList}"
								var="ukTerm" itemLabel="#{ukTerm.ukTermCode} | #{ukTerm.description}" />
							<f:validator validatorId="UKTermDataValidator" />
						</h:selectOneListbox>			
						
						
						<h:panelGroup>
							<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
									value="Professional Advisor: " /></font>
						</h:panelGroup>
						<h:selectOneListbox id="pp_advisor_list_id" style="width:180px"
							value="#{accountManagementController.selectedAdvisor}" size="1"
							converter="#{AdvisorDataConverter}" >
							<f:selectItem itemLabel="Select One" itemValue="" />
							<f:selectItems
								value="#{cepisGlobalComponentConfigurator.advisorList}"
								var="advisor" itemLabel="#{advisor.shortDesc}" />
							<f:validator validatorId="AdvisorDataValidator" />
						</h:selectOneListbox>
						
						<h:panelGroup>
							<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
									value="Faculty Advisor: " /></font>
						</h:panelGroup>
						<h:selectOneListbox id="pp_facultyAdvisor_list_id" style="width:180px"
							value="#{accountManagementController.selectedFacultyAdvisor}" size="1"
							converter="#{FacultyAdvisorDataConverter}" >
							<f:selectItem itemLabel="Select One" itemValue="" />
							<f:selectItems
								value="#{cepisGlobalComponentConfigurator.facultyAdvisorList}"
								var="facultyAdvisor" itemLabel="#{facultyAdvisor.shortDesc}" />
							<f:validator validatorId="FacultyAdvisorDataValidator" />
						</h:selectOneListbox>
						
						<h:panelGroup>
							<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
									value="Short Description :"></h:outputText></font>
						</h:panelGroup>
						<h:inputTextarea id="ppShortdesc"
							value="#{accountManagementController.ppShortDesc}"
							style="width:180px" rows="2">
							<f:validateLength minimum="0" maximum="255" />
						</h:inputTextarea>
					</h:panelGrid>
				</h:panelGroup>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<br />
		<br />
		<h:panelGrid id="part2" columns="1"
			style="valign:top;padding-left: 25px" width="100%">
			<h:panelGroup layout="block"
				style="width: 100%;  z-index: 21;align:center;background-color:#F0F0F0">
				<h:panelGroup layout="block"
					style="background-color:#C6D0F1;text-align: center;height:22px">
					<font class="ws12" color="#366B96" face="Tahoma"><b>Optional
							Details</b></font>
				</h:panelGroup>
				<h:panelGroup layout="block"
					style="background-color: #FFFFFF;height:3px;z-index:51;"></h:panelGroup>
				<h:panelGroup layout="block" style="height:10px;z-index:51;"></h:panelGroup>
				<h:panelGroup layout="block" style="text-align: right;"
					rendered="false">
					<font class="ws10" color="#366B96" face="Tahoma"><a
						href="javascript:animatedcollapse.show(['myDiv1','myDiv2','myDiv3','myDiv4','myDiv5'])"
						class="style1"><b>Expand All</b></a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
						href="javascript:animatedcollapse.hide(['myDiv1','myDiv2','myDiv3','myDiv4','myDiv5'])"
						class="style1"><b>Collapse All</b></a></font>&nbsp;&nbsp;<hr size=2 />
				</h:panelGroup>

				<table border=0 cellpadding=0 cellspacing=0 width="100%">
					<tr valign=middle align=center bgcolor="#FFFFFF">
						<td width="100%">
							<table border=0 cellpadding=0 cellspacing=0 width="100%">
								<tr valign=middle align=center bgcolor="#F0F0F0">
									<td width="100%"><br />
										<table bgcolor="#F0F0F0" border=0 cellpadding=0 cellspacing=0
											width="100%">
											<tr valign=top>
												<td width="33%" height=24>
													<!--Start of table-->
													<table bgcolor="#F0F0F0" border=0 cellpadding=0
														cellspacing=0 width="100%">
														<tr valign=top>
															<td width="98%" bgcolor="#C6D0F1">
																<div class="wpmd">
																	<h:panelGroup layout="block"
																		style="background-color:#C6D0F1;text-align: center;height:22px">

																		<h:selectBooleanCheckbox id="psp_enable"
																			title="Add User Personal Profile information"
																			value="#{accountManagementController.showPersonalProfile}">
																			<a4j:support event="onclick" ajaxSingle="true"
																				limitToList="true" reRender="psp"></a4j:support>
																		</h:selectBooleanCheckbox>
													&nbsp;&nbsp;&nbsp; 
													<font class="ws12" color="#366B96" face="Tahoma"><b>Add
																				User Personal Profile</b></font>
																	</h:panelGroup>
																</div>
															</td>
														</tr>
														<tr valign=top>
															<td valign=middle align=center>
																<div id="myDiv1">
																	<h:panelGroup id="psp">
																		<h:panelGrid columns="2"
																			rendered="#{accountManagementController.showPersonalProfile}">
																			<h:panelGroup>
																				<font class="ws10" color="#062E8A" face="Tahoma">
																					<h:outputText value="Ethnicity: *" />
																				</font>
																			</h:panelGroup>
																			<h:selectOneListbox id="ethnic_list_id"
																				value="#{accountManagementController.addUserPersonalProfile.ethnic}"
																				size="1" converter="#{EthnicDataConverter}"
																				style="width:180px" required="true"
																				requiredMessage="Ethnicity: Value is required.">
																				<f:selectItem itemLabel="Select One" itemValue="" />
																				<f:selectItems
																					value="#{cepisGlobalComponentConfigurator.ethnicList}"
																					var="ethnic" itemLabel="#{ethnic}" />
																				<f:validator validatorId="EthnicDataValidator" />
																			</h:selectOneListbox>
																			<h:panelGroup>
																				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
																						value="Citizenship: *" /></font>
																			</h:panelGroup>
																			<h:selectOneListbox
																				value="#{accountManagementController.addUserPersonalProfile.citizen}"
																				size="1" style="width:180px" required="true"
																				requiredMessage="Citizen: Value is required.">
																				<f:selectItems
																					value="#{cepisGlobalComponentConfigurator.countries}"
																					var="country" itemLabel="#{country}" />
																			</h:selectOneListbox>

																			<h:panelGroup>
																				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
																						value="Diploma Type: " /></font>
																			</h:panelGroup>
																			<h:selectOneListbox id="diplomaType_id"
																				style="width:180px"
																				value="#{accountManagementController.addUserPersonalProfile.diplomaType}"
																				size="1">
																				<f:selectItem itemLabel="Select One" itemValue="NA" />
																				<f:selectItem itemLabel="High School"
																					itemValue="High School" />
																				<f:selectItem itemLabel="Homeschool"
																					itemValue="Homeschool" />
																				<f:selectItem itemLabel="GED" itemValue="GED" />
																				<f:selectItem itemLabel="Foreign"
																					itemValue="Foreign" />
																			</h:selectOneListbox>
																			<h:panelGroup>
																				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
																						value="Diploma State: " /></font>
																			</h:panelGroup>
																			<h:inputText
																				value="#{accountManagementController.addUserPersonalProfile.diplomaState}"
																				style="width:180px"
																				validatorMessage="Diploma State: Value is invalid. Allowed characters are alphabets (small and capital letters), numbers and special charecters such as space ( ) comma (,) and fullstop (.)">
																				<f:validateRegex pattern="[A-Za-z0-9 ,.]+" />
																				<f:validateLength maximum="50" />
																			</h:inputText>

																			<h:panelGroup>
																				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
																						value="Diploma Year: " /></font>
																			</h:panelGroup>
																			<h:inputText
																				value="#{accountManagementController.addUserPersonalProfile.diplomaYear}"
																				style="width:180px"
																				validatorMessage="Diploma Year: Value is invalid. Use (e.g., 2011)">
																				<f:validateRegex pattern="\d{4}" />
																			</h:inputText>
																			<h:panelGroup>
																				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
																						value="High School: " /></font>
																			</h:panelGroup>
																			<h:inputText
																				value="#{accountManagementController.addUserPersonalProfile.highSchool}"
																				style="width:180px"
																				validatorMessage="High School: Value is invalid. Allowed characters are alphabets (small and capital letters), numbers and special charecters such as space ( ) comma (,) and fullstop (.)">
																				<f:validateRegex pattern="[A-Za-z0-9 .,]+" />
																				<f:validateLength maximum="50" />
																			</h:inputText>
																			<h:panelGroup>
																				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
																						value="High School City: " /></font>
																			</h:panelGroup>
																			<h:inputText
																				value="#{accountManagementController.addUserPersonalProfile.highSchoolCity}"
																				style="width:180px"
																				validatorMessage="High School City: Value is invalid. Allowed characters are alphabets (small and capital letters), numbers and special charecters such as space ( ) comma (,) and fullstop (.)">
																				<f:validateRegex pattern="[A-Za-z0-9 .,]+" />
																				<f:validateLength maximum="50" />
																			</h:inputText>
																			<h:panelGroup>
																				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
																						value="High School County: " /></font>
																			</h:panelGroup>
																			<h:inputText
																				value="#{accountManagementController.addUserPersonalProfile.highSchoolCounty}"
																				style="width:180px"
																				validatorMessage="High School County: Value is invalid. Allowed characters are alphabets (small and capital letters), numbers and special charecters such as space ( ) comma (,) and fullstop (.)">
																				<f:validateRegex pattern="[A-Za-z0-9 .,]+" />
																				<f:validateLength maximum="50" />
																			</h:inputText>
																		</h:panelGrid>
																	</h:panelGroup>
																</div>
															</td>
														</tr>
													</table>
												</td>
												<td width=16 height=24><br /></td>
												<td width="33%" height=24>
													<!--Start of table-->
													<table bgcolor="#F0F0F0" border=0 cellpadding=0
														cellspacing=0 width="100%">
														<tr valign=top>
															<td width="98%" bgcolor="#C6D0F1">
																<div class="wpmd">
																	<h:panelGroup layout="block"
																		style="background-color:#C6D0F1;text-align: center;height:22px">

																		<h:selectBooleanCheckbox id="email_enable"
																			title="Add Email Address information"
																			value="#{accountManagementController.showEmail}">
																			<a4j:support event="onclick" ajaxSingle="true"
																				limitToList="true" reRender="email"></a4j:support>
																		</h:selectBooleanCheckbox>
													&nbsp;&nbsp;&nbsp; 
													<font class="ws12" color="#366B96" face="Tahoma"><b>Add
																				Email</b></font>
																	</h:panelGroup>
																</div>
															</td>
														</tr>
														<tr valign=top>
															<td valign=middle align=center>
																<div id="myDiv2">
																	<br />
																	<h:panelGroup id="email">
																		<h:panelGrid columns="2"
																			rendered="#{accountManagementController.showEmail}">
																			<h:panelGroup>
																				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
																						value="Email Address: *" /></font>
																			</h:panelGroup>
																			<h:inputText id="emailaddress"
																				value="#{accountManagementController.address}"
																				style="width:180px" required="true"
																				requiredMessage="Email Address: Value is required."
																				validatorMessage="Email Address: Value is invalid.">
																				<f:validateRegex
																					pattern="[_a-zA-Z0-9-]+(\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.(([0-9]{1,3})|([a-zA-Z]{2,3})|(aero|coop|info|museum|name))" />
																				<f:validateLength maximum="255" />
																			</h:inputText>
																			<h:panelGroup>
																				<font class="ws10" color="#062E8A" face="Tahoma">
																					<h:outputText value="Email Address Type : *"></h:outputText>
																				</font>
																			</h:panelGroup>
																			<h:selectOneListbox id="email_addresstype_list_id"
																				value="#{accountManagementController.selectedEmailAddressType}"
																				size="1"
																				converter="#{EmailAddressTypeDataConverter}"
																				style="width:180px" required="true"
																				requiredMessage="Email Address Type: Value is required.">
																				<f:selectItem itemLabel="Select One" itemValue="" />
																				<f:selectItems
																					value="#{cepisGlobalComponentConfigurator.emailAddressTypeList}"
																					var="emailaddresstype"
																					itemLabel="#{emailaddresstype.desc}" />
																				<f:validator
																					validatorId="EmailAddressTypeDataValidator" />
																			</h:selectOneListbox>
																		</h:panelGrid>
																	</h:panelGroup>
																</div>
															</td>
														</tr>
													</table>
												</td>
												<td width=14 height=24><br /></td>
												<td width="33%" height=24>
													<!--Start of table-->
													<table bgcolor="#F0F0F0" border=0 cellpadding=0
														cellspacing=0 width="100%">
														<tr valign=top>
															<td width="98%" bgcolor="#C6D0F1">
																<div class="wpmd">
																	<h:panelGroup layout="block"
																		style="background-color:#C6D0F1;text-align: center;height:22px">

																		<h:selectBooleanCheckbox id="address_enable"
																			title="Add Address information"
																			value="#{accountManagementController.showAddress}">
																			<a4j:support event="onclick" ajaxSingle="true"
																				limitToList="true" reRender="address"></a4j:support>
																		</h:selectBooleanCheckbox>
													&nbsp;&nbsp;&nbsp; 
													<font class="ws12" color="#366B96" face="Tahoma"><b>Add
																				Address</b></font>
																	</h:panelGroup>
																</div>
															</td>
														</tr>
														<tr valign=top>
															<td valign=middle align=center>
																<div id="myDiv3">
																	<br />
																	<h:panelGroup id="address">
																		<h:panelGrid columns="2"
																			rendered="#{accountManagementController.showAddress}">
																			<h:panelGroup>
																				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
																						value="Street Address 1: *" /></font>
																			</h:panelGroup>
																			<h:inputText id="street1"
																				value="#{accountManagementController.street1}"
																				style="width:180px" required="true"
																				requiredMessage="Street1: Value is required."
																				validatorMessage="Street Address 1: Maximum 150 characters">
																				<f:validateLength maximum="150" />
																			</h:inputText>
																			<h:panelGroup>
																				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
																						value="Street Address 2: " /></font>
																			</h:panelGroup>
																			<h:inputText
																				value="#{accountManagementController.street2}"
																				style="width:180px"
																				validatorMessage="Street Address 2: Maximum 150 characters">
																				<f:validateLength minimum="0" maximum="150" />
																			</h:inputText>
																			<h:panelGroup>
																				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
																						value="City : *" /></font>
																			</h:panelGroup>
																			<h:inputText
																				value="#{accountManagementController.city}"
																				style="width:180px" required="true"
																				requiredMessage="City: Value is required."
																				validatorMessage="City: Maximum 50 characters">
																				<f:validateLength maximum="50" />
																			</h:inputText>
																			<h:panelGroup>
																				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
																						value="State : *" /></font>
																			</h:panelGroup>
																			<h:inputText
																				value="#{accountManagementController.state}"
																				style="width:180px" required="true"
																				requiredMessage="State: Value is required."
																				validatorMessage="State: Maximum 20 characters">
																				<f:validateLength maximum="20" />
																			</h:inputText>
																			<h:panelGroup>
																				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
																						value="Zip Code: *" /></font>
																			</h:panelGroup>
																			<h:inputText
																				value="#{accountManagementController.zip}"
																				style="width:180px" required="true"
																				requiredMessage="Zip code: Value is required."
																				validatorMessage="Street1: Minimum 5 characters and maximum 10 characters">
																				<f:validateLength minimum="5" maximum="10" />
																			</h:inputText>
																			<h:panelGroup>
																				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
																						value="Country : *" /></font>
																			</h:panelGroup>
																			<h:selectOneListbox id="country_list_id"
																				value="#{accountManagementController.country}"
																				size="1" style="width:180px" required="true"
																				requiredMessage="Country: Value is required.">
																				<f:selectItems
																					value="#{cepisGlobalComponentConfigurator.countries}"
																					var="country" itemLabel="#{country}" />
																			</h:selectOneListbox>

																			<h:panelGroup>
																				<font class="ws10" color="#062E8A" face="Tahoma">
																					<h:outputText value="Address Type : *"></h:outputText>
																				</font>
																			</h:panelGroup>
																			<h:selectOneListbox id="addresstype_list_id"
																				value="#{accountManagementController.selectedAddressType}"
																				size="1" converter="#{AddressTypeDataConverter}"
																				style="width:180px" required="true"
																				requiredMessage="Address Type: Value is required.">
																				<f:selectItem itemLabel="Select One" itemValue="" />
																				<f:selectItems
																					value="#{cepisGlobalComponentConfigurator.addressTypeList}"
																					var="addresstype" itemLabel="#{addresstype.desc}" />
																				<f:validator validatorId="AddressTypeDataValidator" />
																			</h:selectOneListbox>
																		</h:panelGrid>
																	</h:panelGroup>
																</div>
															</td>
														</tr>
													</table>
												</td>
											</tr>
											<tr valign=top>
												<td width="33%" height=21><br /></td>
												<td width=16 height=21><br /></td>
												<td width="33%" height=21><br /></td>
												<td width=14 height=21><br /></td>

												<td width="33%" height=21><br /></td>
											</tr>
											<tr valign=top>
												<td width="33%" height=21>
													<!--Start of table-->
													<table bgcolor="#F0F0F0" border=0 cellpadding=0
														cellspacing=0 width="100%">
														<tr valign=top>
															<td width="98%" bgcolor="#C6D0F1">
																<div class="wpmd">
																	<h:panelGroup layout="block"
																		style="background-color:#C6D0F1;text-align: center;height:22px">

																		<h:selectBooleanCheckbox id="phone_enable"
																			title="Add Phone information"
																			value="#{accountManagementController.showPhone}">
																			<a4j:support event="onclick" ajaxSingle="true"
																				limitToList="true" reRender="phone"></a4j:support>
																		</h:selectBooleanCheckbox>
																		&nbsp;&nbsp;&nbsp; 
																		<font class="ws12" color="#366B96" face="Tahoma">
																			<b>Add	Phone</b>
																		</font>
																	</h:panelGroup>
																</div>
															</td>
														</tr>
														<tr valign=top>
															<td valign=middle align=center>
																<div id="myDiv4">
																	<br />
																	<h:panelGroup id="phone">
																		<h:panelGrid columns="2"
																			rendered="#{accountManagementController.showPhone}">
																			<h:panelGroup>
																				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
																						value="Phone no: *" /></font>
																			</h:panelGroup>
																			<h:inputText id="phoneno"
																				value="#{accountManagementController.phoneNo}"
																				style="width:180px" required="true"
																				requiredMessage="Phone No: Value is required."
																				validatorMessage="Phone no: Value is invalid. Use e.g., (123) 456-7890.">
																				<f:validateRegex
																					pattern="\((\d{3})\) (\d{3})-(\d{4})" />
																			</h:inputText>
																			<h:panelGroup>
																				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
																						value="Extension : " /></font>
																			</h:panelGroup>
																			<h:inputText
																				value="#{accountManagementController.ext}"
																				style="width:180px"
																				validatorMessage="Phone no: Value is invalid. Use numbers">
																				<f:validateRegex pattern="\d+" />
																				<f:validateLength maximum="50" />
																			</h:inputText>
																			<h:panelGroup>
																				<font class="ws10" color="#062E8A" face="Tahoma">
																					<h:outputText value="Phone Type : *"></h:outputText>
																				</font>
																			</h:panelGroup>
																			<h:selectOneListbox id="phonetype_list_id"
																				value="#{accountManagementController.selectedPhoneType}"
																				size="1" converter="#{PhoneTypeDataConverter}"
																				style="width:180px" required="true"
																				requiredMessage="Phone Type: Value is required.">
																				<f:selectItem itemLabel="Select One" itemValue="" />
																				<f:selectItems
																					value="#{cepisGlobalComponentConfigurator.phoneTypeList}"
																					var="phonetype" itemLabel="#{phonetype.desc}" />
																				<f:validator validatorId="PhoneTypeDataValidator" />
																			</h:selectOneListbox>
																			<script type="text/javascript">
																				jQuery(
																						"input[id$=phoneno]")
																						.mask(
																								"(999) 999-9999");
																			</script>
																		</h:panelGrid>
																	</h:panelGroup>
																</div>
															</td>
														</tr>
													</table>
												</td>
												<td width=16 height=21><br /></td>
												<td width="33%" height=21>
													<!--Start of table-->
													<table bgcolor="#F0F0F0" border=0 cellpadding=0
														cellspacing=0 width="100%">
														<tr valign=top>
															<td width="98%" bgcolor="#C6D0F1">
																<div class="wpmd">
																	<h:panelGroup layout="block"
																		style="background-color:#C6D0F1;text-align: center;height:22px">

																		<h:selectBooleanCheckbox id="role_enable"
																			title="Add Role(s)"
																			value="#{accountManagementController.showRole}">
																			<a4j:support event="onclick" ajaxSingle="true"
																				limitToList="true" reRender="role"></a4j:support>
																		</h:selectBooleanCheckbox>
													&nbsp;&nbsp;&nbsp; 
													<font class="ws12" color="#366B96" face="Tahoma"><b>Add
																				Role(s)</b></font>
																	</h:panelGroup>
																</div>
															</td>
														</tr>
														<tr valign=top>
															<td valign=middle align=center>
																<div id="myDiv5">
																	<h:panelGroup id="role">


																		<h:panelGrid columns="2"
																			rendered="#{accountManagementController.showRole}">
																			<h:panelGroup>
																				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
																						value="Select Roles: *" /></font>
																			</h:panelGroup>
																			<h:selectManyListbox id="role_list_id"
																				value="#{accountManagementController.selectedRoles}"
																				size="5" converter="#{RoleDataConverter}"
																				style="width: 300px;" required="true"
																				requiredMessage="Roles: Atleast one role should be selected">
																				<f:selectItem itemLabel="Select many" itemValue="NA" />
																				<f:selectItems
																					value="#{cepisGlobalComponentConfigurator.roleList}"
																					var="role" itemLabel="#{role.rolename}" />
																				<f:validator validatorId="RoleDataValidator" />
																				<a4j:support event="onchange" ajaxSingle="true"
																					reRender="wses"
																					actionListener="#{accountManagementController.valueChangeAddRole}" />
																			</h:selectManyListbox>
																		</h:panelGrid>
																		<h:panelGrid id="wses" columns="2"
																			rendered="#{accountManagementController.showRole}">
																			<h:panelGroup id="customws"
																				rendered="#{accountManagementController.selectCustomRoleWorkingSet}">
																				<h:panelGroup>
																					<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
																							value="Available Working Sets: *" /></font>
																				</h:panelGroup>
																			</h:panelGroup>


																			<h:selectOneListbox id="wslistid"
																				rendered="#{accountManagementController.selectCustomRoleWorkingSet}"
																				value="#{accountManagementController.selectedWorkingSet}"
																				size="1" converter="#{WorkingSetDataConverter}"
																				style="width:180px" required="true"
																				requiredMessage="Working Set: You should assign a working set to the custom role">
																				<f:selectItem itemLabel="Select One" itemValue="NA" />
																				<f:selectItems
																					value="#{workingSetController.activeWSList}"
																					var="ws" itemLabel="#{ws.name}" />
																				<f:validator validatorId="WorkingSetDataValidator" />
																			</h:selectOneListbox>

																		</h:panelGrid>

																	</h:panelGroup>
																</div>
															</td>
														</tr>
													</table>
												</td>												
											</tr>
										</table></td>
								</tr>
								<tr bgcolor="#F0F0F0">
									<td height=20></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr bgcolor="#FFFFFF">
						<td height=20></td>
					</tr>
					<tr bgcolor="#FFFFFF">
						<td height=20 valign=middle align=center><h:commandButton
								value="Add User" style="font-weight: bold; width: 145px"
								action="#{accountManagementController.addCEPISUser}">
							</h:commandButton>

							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a4j:commandButton value="Clear"
								reRender="part1,psp_enable,psp,address_enable,address,email_enable,email,phone_enable,phone,role_enable,role,report_enable,report"
								ajaxSingle="true" style="font-weight: bold; width: 145px"
								limitToList="true"
								action="#{accountManagementController.clearAllValues}">
							</a4j:commandButton></td>
					</tr>
					<tr bgcolor="#FFFFFF">
						<td height=20/>
					</tr>
					<tr>
						<td height=20/>
					</tr>
				</table>
			</h:panelGroup>
		</h:panelGrid>
		<rich:modalPanel id="ajaxLoadingModalBox" minHeight="50"
			minWidth="120" height="100" width="120" zindex="2000">
			<f:facet name="header">
				<h:outputText value="Sending Request ..."></h:outputText>
			</f:facet>
			<h:outputText value="Please wait ..."></h:outputText>
			<br />
			<br />&nbsp;&nbsp;&nbsp;
				<h:graphicImage value="/images/loader.gif" style="border:0"
				alt="loading ..."></h:graphicImage>
		</rich:modalPanel>

		<script type="text/javascript">
			var infoWindowAMShown = false;
			var infoWindowAMTimer;
			function showModalInfoWindow() {
				infoWindowAMTimer = setTimeout(
						"if(!infoWindowAMShown){Richfaces.showModalPanel('ajaxLoadingModalBox');infoWindowAMShown=true;}",
						500);
			}
			function hideModalInfoWindow() {
				if (infoWindowAMShown) {
					Richfaces.hideModalPanel('ajaxLoadingModalBox');
					infoWindowAMShown = false;
				} else {
					if (infoWindowAMTimer)
						clearTimeout(infoWindowAMTimer);
				}
			}
		</script>

	</h:form>
	<a4j:loadScript src="resource://jquery.js" />
</f:view>

<%@ include file="/common/footer.jsp"%>


<script type="text/javascript"
	src="${facesContext.externalContext.requestContextPath}/js/account.js"></script>
<script type="text/javascript"
	src="${facesContext.externalContext.requestContextPath}/js/jquery.maskedinput-1.2.2.js"></script>
<script type="text/javascript">
	jQuery("input[id$=ukid]").mask("99999999");
	//jQuery("input[id$=ssn]").mask("999999999");
	jQuery("input[id$=birthdate]").mask("99/99/9999");
	jQuery("input[id$=phoneno]").mask("(999) 999-9999");
</script>