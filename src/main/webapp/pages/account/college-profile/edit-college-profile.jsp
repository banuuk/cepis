<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:subview id="edit-college-profile">
	<h:form id="edit_usercollegeprofile_manager" styleClass="styleish">
	
		<h:outputLabel for="collegeProfileEdit-separator" value="Edit User College Profile" styleClass="medium-bold"/>	
		<rich:separator id="collegeProfileEdit-separator" lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>
		
		<h:panelGrid columns="2" style="padding-right: 100px; padding-left: 100px">
		
			<h:outputLabel for="collegeProfile_list" styleClass="small" value="User College Profile Information : " />
			<h:selectOneListbox id="collegeProfile_list"
			value="#{accountManagementController.selectedUserCollegeProfile}"
			size="1" converter="#{UserCollegeProfileDataConverter}"
			style="width: 200px;" required="true"
			requiredMessage="User College Profile: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems value="#{accountManagementController.userCollegeProfileList}"
				var="collegeprofile" itemLabel="#{collegeprofile.ukCollege} - #{collegeprofile.ukDepartment} - #{collegeprofile.userClassification}" />
				<f:validator validatorId="UserCollegeProfileDataValidator" />
				<a4j:support event="onchange" ajaxSingle="true"
				action="#{accountManagementController.valueChangeEditUserCollegeProfile}"
				reRender="userType_list,userClassification_list,ukCollege_list,ukDepartment_list,ukStatus_list,ukStartTerm_list,ukEndTerm_list,cohortType_list,cohortTerm_list,shortDesc" />
			</h:selectOneListbox>
			
			<h:outputLabel for="userType_list" styleClass="small" value="User Type : *" />
			<h:selectOneListbox id="userType_list" immediate="true" onchange="sumbit()"
			value="#{accountManagementController.selectedUserType}" size="1"
			converter="#{UserTypeDataConverter}" style="width:200px"
			required="true" requiredMessage="User Type: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems value="#{cepisGlobalComponentConfigurator.userTypeList}"
				var="usertype" itemLabel="#{usertype.shortDesc}" />
				<f:validator validatorId="UserTypeDataValidator" />
			</h:selectOneListbox>
			
			<h:outputLabel for="userClassification_list" styleClass="small" value="User Classification : *" />
			<h:selectOneListbox id="userClassification_list" immediate="true" onchange="sumbit()"
			value="#{accountManagementController.selectedUserClassification}"
			size="1" converter="#{UserClassificationDataConverter}"
			style="width:200px" required="true"
			requiredMessage="User classification: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems value="#{cepisGlobalComponentConfigurator.userClassificationList}"
				var="userclassification" itemLabel="#{userclassification.shortDesc}" />
				<f:validator validatorId="UserClassificationDataValidator" />
			</h:selectOneListbox>
			
			<h:outputLabel for="ukCollege_list" styleClass="small" value="College : *" />
			<h:selectOneListbox id="ukCollege_list" immediate="true" onchange="sumbit()"
			value="#{accountManagementController.selectedUkCollege}" size="1"
			converter="#{UKCollegeDataConverter}" style="width:200px"
			required="true" requiredMessage="College: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems value="#{cepisGlobalComponentConfigurator.ukCollegeList}"
				var="ukcollege" itemLabel="#{ukcollege.collegeName}" />
				<f:validator validatorId="UKCollegeDataValidator" />
			</h:selectOneListbox>
			
			<h:outputLabel for="ukDepartment_list" styleClass="small" value="Department : *" />
			<h:selectOneListbox id="ukDepartment_list" immediate="true" onchange="sumbit()"
			value="#{accountManagementController.selectedUkDepartment}" size="1"
			converter="#{UKDepartmentDataConverter}" style="width:200px"
			required="true" requiredMessage="Department: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems value="#{cepisGlobalComponentConfigurator.ukDepartmentList}"
				var="ukdepartment" itemLabel="#{ukdepartment.departmentCode} | #{ukdepartment.departmentName}" />
				<f:validator validatorId="UKDepartmentDataValidator" />
			</h:selectOneListbox>
			
			<h:outputLabel for="ukStatus_list" styleClass="small" value="Status : " />
			<h:selectOneListbox id="ukStatus_list" onchange="sumbit()" immediate="true"
			value="#{accountManagementController.cpSelectedUKStatus}" size="1"
			converter="#{UKStatusDataConverter}" style="width:200px">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems value="#{cepisGlobalComponentConfigurator.ukStatusList}"
				var="ukStatus" itemLabel="#{ukStatus.statusCode} | #{ukStatus.description}" />
				<f:validator validatorId="UKStatusDataValidator" />
			</h:selectOneListbox>
			
			<h:outputLabel for="ukStartTerm_list" styleClass="small" value="Start Term : " />
			<h:selectOneListbox id="ukStartTerm_list" onchange="sumbit()" immediate="true" 
			value="#{accountManagementController.cpSelectedUKStartTerm}"
			size="1" converter="#{UKTermDataConverter}" style="width:200px">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems value="#{cepisGlobalComponentConfigurator.ukTermList}"
				var="ukTerm" itemLabel="#{ukTerm.ukTermCode} | #{ukTerm.description}" />
				<f:validator validatorId="UKTermDataValidator" />
			</h:selectOneListbox>
			
			<h:outputLabel for="ukEndTerm_list" styleClass="small" value="End Term : " />
			<h:selectOneListbox id="ukEndTerm_list" style="width:200px"
			onchange="sumbit()" immediate="true"
			value="#{accountManagementController.cpSelectedUKEndTerm}"
			size="1" converter="#{UKTermDataConverter}">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems value="#{cepisGlobalComponentConfigurator.ukTermList}" 
				var="ukTerm" itemLabel="#{ukTerm.shortDesc}" />
				<f:validator validatorId="UKTermDataValidator" />
			</h:selectOneListbox>
			
			<h:outputLabel for="cohortType_list" styleClass="small" value="Cohort Type : " />
			<h:selectOneListbox id="cohortType_list" immediate="true"
			onchange="sumbit()" size="1"
			value="#{accountManagementController.selectedCohortType}" 
			converter="#{CohortTypeDataConverter}" style="width:200px">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems value="#{cepisGlobalComponentConfigurator.cohortTypeList}"
				var="cohorttype" itemLabel="#{cohorttype.shortDesc}" />
				<f:validator validatorId="CohortTypeDataValidator" />
			</h:selectOneListbox>
			
			<h:outputLabel for="cohortTerm_list" styleClass="small" value="Cohort Term : " />
			<h:selectOneListbox id="cohortTerm_list" immediate="true"
			onchange="sumbit()" size="1"
			value="#{accountManagementController.selectedCohortTerm}"
			converter="#{CohortTermDataConverter}" style="width:200px">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems value="#{cepisGlobalComponentConfigurator.cohortTermList}"
				var="cohortterm" itemLabel="#{cohortterm.shortDesc}" />
				<f:validator validatorId="CohortTermDataValidator" />
			</h:selectOneListbox>
			
			<h:outputLabel for="shortDesc" styleClass="small" value="Short Description :"/>
			<h:inputTextarea id="shortDesc" style="width:200px" rows="2"
			value="#{accountManagementController.cpShortDesc}">
				<f:validateLength minimum="0" maximum="255" />
			</h:inputTextarea>
			
			<h:message for="edit_usercollegeprofile_button"/>
			<h:commandButton id="edit_usercollegeprofile_button" value="Save"
			styleClass="buttonStyle" action="#{accountManagementController.editUserCollegeProfile}"/>
		</h:panelGrid>

	</h:form>
</f:subview>