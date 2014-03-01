<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<h:panelGrid columns="3" style="padding-right: 10px; padding-left: 10px">


	<authz:authorize ifAnyGranted="ROLE_ADVISOR,ROLE_ADVISING_MANAGER">
		<h:panelGroup>
			<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Select a Student" /><br /> <h:outputText
					value="from the current WorkingSet"></h:outputText></font>&nbsp;<h:graphicImage
				url="/images/info.png" alt="i"
				title="Name: #{workingSetController.activeWorkingSetName}, Desc: #{workingSetController.activeWorkingSetDescription}" />
		</h:panelGroup>
		<rich:spacer width="15" height="10" title="Here is a spacer..." />
		<h:selectOneListbox id="schedule_student_wsid"
			value="#{cepisConfigurationManager.selectedUser}" size="1"
			converter="#{UserDataConverter}" style="width: 220px;"
			required="true"
			requiredMessage="User: You must select a user from the working set.">
			<f:selectItem itemLabel="Select One" />
			<f:selectItems value="#{workingSetController.activeWSUsersList}"
				var="user" itemLabel="#{user.fullName}" />
			<f:validator validatorId="UserDataValidator" />
		</h:selectOneListbox>
	</authz:authorize>
	
	
	
	
	<authz:authorize ifAnyGranted="ROLE_STUDENT,ROLE_ADVISING_MANAGER">
		<h:panelGroup>
			<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Select an advisor: " /></font>
			<a4j:commandLink reRender="advisorInfoPanel"
				oncomplete="#{rich:component('advisorInfoPanel')}.show();"
				ajaxSingle="true">
				<h:graphicImage value="/images/info.png" style="border:0"
					styleClass="pic" alt="i"
					title="For information on determining who your advisor is, please visit the Academic Service and Teacher Certification website" />
			</a4j:commandLink>
		</h:panelGroup>
		<rich:spacer width="15" height="10" title="Here is a spacer..." />
		<h:selectOneListbox id="student_schedule_advisor_list"
			value="#{advisingManagementController.selectedAdvisor}" size="1"
			style="width:220px" converter="#{AdvisorDataConverter}"
			required="true" requiredMessage="Advisor: Value is required.">
			<f:selectItem itemLabel="Select One" />
			<f:selectItems
				value="#{advisingManagementController.advisorSelectItemList}" />
			<f:validator validatorId="AdvisorDataValidator" />
			<a4j:support event="onchange" ajaxSingle="true"
				reRender="availableSlots"
				actionListener="#{advisingManagementController.valueChangeAdvisor}" />
		</h:selectOneListbox>
	</authz:authorize>
		
	
	<authz:authorize ifNotGranted="ROLE_ADVISING_MANAGER">
		<authz:authorize ifAnyGranted="ROLE_ADVISOR">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Advisor: " /></font>
			</h:panelGroup>
			<rich:spacer width="15" height="10" title="Here is a spacer..." />
			<h:outputText value="#{advisingManagementController.currentAdvisor}"></h:outputText>
		</authz:authorize>
	</authz:authorize>
	
	
	<h:panelGroup>
		<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
				value="Select a date and time: " /></font>
	</h:panelGroup>
	
	
	<rich:spacer width="15" height="10" title="Here is a spacer..." />
	
	<h:panelGroup id="availableSlots">
		<authz:authorize ifAnyGranted="ROLE_STUDENT">
			<h:selectOneListbox id="student_schedule_advising_session_list"
				size="1"
				value="#{advisingManagementController.selectedAdvisingSessionSlot}"
				converter="#{AdvisingSessionSlotDataConverter}" style="width:220px"
				required="true" requiredMessage="Time slot: Value is required.">
				<f:selectItem itemLabel="Select One" />
				<f:selectItems
					value="#{advisingManagementController.studentAdvisingSessionSlotList}"
					var="advisingSessionSlot" itemLabel="#{advisingSessionSlot}" />
				<f:validator validatorId="AdvisingSessionSlotDataValidator" />
			</h:selectOneListbox>
		</authz:authorize>
		<authz:authorize ifAnyGranted="ROLE_ADVISOR,ROLE_ADVISING_MANAGER">
			<h:selectOneListbox
				id="advising_manager_schedule_advising_session_list"
				value="#{advisingManagementController.selectedAdvisingSessionSlot}"
				size="1" converter="#{AdvisingSessionSlotDataConverter}"
				style="width:220px" required="true"
				requiredMessage="Time slot: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems
					value="#{advisingManagementController.advisingSessionSlotList}"
					var="advisingSessionSlot" itemLabel="#{advisingSessionSlot}" />
				<f:validator validatorId="AdvisingSessionSlotDataValidator" />
			</h:selectOneListbox>
		</authz:authorize>
	</h:panelGroup>
	
	
	
	<authz:authorize ifAnyGranted="ROLE_ADVISOR,ROLE_ADVISING_MANAGER">
		<h:panelGroup>
			<font class="ws10" color="#062E8A" face="Tahoma">
				<h:outputText value="Send Conformation Email :" />
			</font>		
		</h:panelGroup>	
		<rich:spacer width="1" height="1" title="Here is a spacer..." />
		<h:selectBooleanCheckbox value="#{advisingManagementController.sendConformationEmail }"/>		
	</authz:authorize>
	
	
</h:panelGrid>

<rich:separator lineType="beveled" height="8" align="center"
	style="margin: 10px" />

<h:panelGrid columns="3" style="padding-right: 10px; padding-left: 10px">

	<h:panelGroup>
		<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
				value="Appointment Type: " /></font>
		<a4j:commandLink reRender="sessionTypeInfoPanel" ajaxSingle="true"
			oncomplete="#{rich:component('sessionTypeInfoPanel')}.show();">
			<h:graphicImage value="/images/info.png" style="border:0"
				styleClass="pic" alt="i"
				title="If you can't find your appointment type, select the 'Other' option." />
		</a4j:commandLink>
	</h:panelGroup>
	<rich:spacer width="20" height="10" title="Here is a spacer..." />
	<h:selectOneListbox id="student_schedule_session_type_id"
		value="#{advisingManagementController.selectedSessionType}" size="1"
		required="true" requiredMessage="Appointment Type: Value is required.">
		<f:selectItem itemLabel="Registration" itemValue="Registration" />
		<f:selectItem itemLabel="Personal" itemValue="Personal" />
		<f:selectItem itemLabel="Program Issues" itemValue="Program Issues" />
		<f:selectItem itemLabel="Graduation Audit"
			itemValue="Graduation Audit" />
		<f:selectItem itemLabel="Early Alerts" itemValue="Early Alerts" />
		<f:selectItem itemLabel="Other" itemValue="Other" />
	</h:selectOneListbox>

	<h:panelGroup>
		<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
				value="Comments :"></h:outputText></font>
	</h:panelGroup>
	<rich:spacer width="20" height="10" title="Here is a spacer..." />
	<h:inputTextarea id="student_comment_section"
		value="#{advisingManagementController.preSessionText}"
		style="width:200px" rows="5">
	</h:inputTextarea>
</h:panelGrid>
