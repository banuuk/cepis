<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:view afterPhase="#{userDetailController.initApplicationComponent}">
	<h:message for="update_advisor_manager">
	</h:message>
	<h:form id="update_advisor_manager">
		<br />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/warning.gif"
				rendered="#{userDetailController.userDetailWarnStatus}" alt="Warning!"
				title="Warning!" />
			<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
				value="#{userDetailController.userDetailStatusMessage}" /></font>
		</h:panelGrid>
		<hr />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Create new advisor" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<br />
		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Select Advisor:"></h:outputText></font>
				<br />
				<h:outputText value="e.g., ADMS-CA-901" style="color:gray" />
			</h:panelGroup>
			<h:selectOneListbox id="wsid"
				value="#{userDetailController.selectedAdvisor}" size="1"
				style="width:200px" converter="#{AdvisorDataConverter}">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.advisorList}"
					var="advisor" itemLabel="#{advisor.shortDesc}" />
				<f:validator validatorId="AdvisorDataValidator" />
				<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{userDetailController.valueChangeEditAdvisor}"
						reRender="student_schedule_session_type_id,officeloc,advisorgroup_list_id" />
			</h:selectOneListbox>

			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Select a status:"></h:outputText></font>
				<br />
				<h:outputText value="e.g., ACTIVE" style="color:gray" />
			</h:panelGroup>
			<h:selectOneListbox id="student_schedule_session_type_id"
				value="#{userDetailController.status}" size="1" required="true"
				requiredMessage="Session Type: Value is required.">
				<f:selectItem itemLabel="Active" itemValue="ACTIVE" />
				<f:selectItem itemLabel="Inactive" itemValue="INACTIVE" />
			</h:selectOneListbox>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Office Location: " /></font>
				<br />
				<h:outputText
					value="Please select your current office location. This address will be used in sending emails to your students. Keep this information updated. If you don't see any office address in this list, please go to account management and add your office address in the address tab."
					style="color:gray" />
			</h:panelGroup>
			<h:selectOneListbox id="officeloc" value="#{userDetailController.officeLocation}"
				size="1" converter="#{AddressDataConverter}" style="width: 200px;"
				required="true"
				requiredMessage="Address: Value is required. If you don't see any office address in this list, please go to account management and add your office address in the address tab."
				converterMessage="convert error"
				validatorMessage="Address: Value is invalid">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems value="#{userDetailController.addressList}"
					var="address"
					itemLabel="(#{address.addressType}) #{address.street1} #{address.street2}, #{address.city}, #{address.state} - #{address.zip}, #{address.country}" />
				<f:validator validatorId="AddressDataValidator" />
			</h:selectOneListbox>
			
			<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma">Select
					Advisor Group:</font>
				</h:panelGroup>
				<h:selectOneListbox id="advisorgroup_list_id"
					value="#{userDetailController.selectedAdvisorGroup}" size="1"
					converter="#{AdvisorGroupDataConverter}" style="width:200px">
					<f:selectItem itemLabel="Select One" itemValue="NA" />
					<f:selectItems
						value="#{cepisGlobalComponentConfigurator.advisorGroupList}"
						var="advisorgroup" itemLabel="#{advisorgroup.name}" />
					<f:validator validatorId="AdvisorGroupDataValidator" />
				</h:selectOneListbox>

			<h:message for="edit_advisor_button"></h:message>
			<h:commandButton id="edit_advisor_button" value="Update"
				action="#{userDetailController.editAdvisorStatus}"></h:commandButton>
		</h:panelGrid>
	</h:form>
</f:view>