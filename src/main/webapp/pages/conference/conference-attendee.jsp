<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<style>
.center {
	text-align: center;
}
</style>
<f:subview id="attendee">
	<h:form>
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="CEPIS Conference Attendees" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<h:panelGroup layout="block" style="text-align:center;align:center;">
			<h:panelGrid columns="3">
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Select a conference: *" /></font>
				</h:panelGroup>
				<h:selectOneListbox id="conferenceid"
					value="#{conferenceManagementController.selectedConference}"
					size="1" converter="#{ConferenceDataConverter}"
					style="width: 200px;" required="true"
					requiredMessage="Conference List is a required field.">
					<f:selectItem itemLabel="Select One" itemValue="NA" />
					<f:selectItems
						value="#{conferenceManagementController.conferenceList}"
						var="conference" itemLabel="#{conference.name}" />
					<a4j:support event="onchange" ajaxSingle="true"
						reRender="attendeeTable,deleteAttendeePanel" />
				</h:selectOneListbox>
				<a4j:commandLink id="createConferencelink"
					oncomplete="#{rich:component('createConferencePanel')}.show()"
					reRender="createConferencePanel">
					<h:graphicImage value="/images/icons/report_add.png"
						style="border:0" styleClass="pic" alt="+"/>
					<f:setPropertyActionListener value="#{null}"
						target="#{conferenceManagementController.name}" />
					<f:setPropertyActionListener value="#{null}"
						target="#{conferenceManagementController.type}" />
					<f:setPropertyActionListener value="#{null}"
						target="#{conferenceManagementController.conferenceDate}" />
					<f:setPropertyActionListener value="#{null}"
						target="#{conferenceManagementController.shortDesc}" />
				</a4j:commandLink>
				<rich:toolTip for="createConferencelink"
					value="Create a new conference" />
			</h:panelGrid>
		</h:panelGroup>
		<rich:spacer height="20" />

		<rich:dataTable id="attendeeTable"
			value="#{conferenceManagementController.attendeeList}" var="attendee"
			rows="25" width="100%">
			<f:facet name="header">
				<h:panelGrid columns="2" columnClasses="attendeecol1,attendeecol2" width="100%">
					<rich:datascroller align="right" for="attendeeTable" id="sc2" reRender="sc1"
						ajaxSingle="false" />
					<h:outputText>
						<h:panelGroup layout="block" style="text-align:right;align:right;">
							<a4j:commandLink id="addAttendeelink" ajaxSingle="true"
								reRender="createAttendeePanel"
								oncomplete="#{rich:component('createAttendeePanel')}.show()">
								<h:outputText> Add </h:outputText>
								<h:graphicImage value="/images/icons/user_add.png"
									style="border:0" styleClass="pic" alt=""/>
							</a4j:commandLink>
							<rich:toolTip for="addAttendeelink"
								value="Add attendees to a conference" />&nbsp;
							 &nbsp;|&nbsp;
						<a4j:commandLink id="deleteAttendeeLink" ajaxSingle="true"
								reRender="attendeeTable"
								oncomplete="#{rich:component('deleteAttendeePanel')}.show()">
								<h:outputText> Remove </h:outputText>
								<h:graphicImage value="/images/icons/user_delete.png"
									style="border:0" styleClass="pic" alt=""/>
							</a4j:commandLink>
							<rich:toolTip for="deleteAttendeeLink"
								value="Remove attendees from a conference" />&nbsp;
							</h:panelGroup>&nbsp;
							</h:outputText>
				</h:panelGrid>
			</f:facet>
			<rich:column sortBy="#{attendee.user.fullName}">
				<f:facet name="header">
					<h:outputText value="Name" />
				</f:facet>
				<h:outputText value="#{attendee.user.fullName}" />
			</rich:column>
			<rich:column sortBy="#{attendee.attended}">
				<f:facet name="header">
					<h:outputText value="Checked-In?" />
				</f:facet>
				<h:graphicImage rendered="#{attendee.attended}"
					value="/images/icons/tick.png" style="border:0" styleClass="pic" alt="Yes"/>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="Description" />
				</f:facet>
				<h:outputText value="#{fn:substring(attendee.shortDesc,0,100)} ..." />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="Options" />
				</f:facet>
				<a4j:commandLink ajaxSingle="true" immediate="true"
					reRender="updateAttendeePanel"
					oncomplete="#{rich:component('updateAttendeePanel')}.show()">
					<h:graphicImage value="/images/icons/user_edit.png"
						style="border:0" styleClass="pic" alt="Edit"/>
					<f:setPropertyActionListener value="#{attendee}"
						target="#{conferenceManagementController.selectedAttendee}" />
					<f:setPropertyActionListener value="#{attendee.user}"
						target="#{cepisConfigurationManager.selectedUser}" />
					<f:setPropertyActionListener value="#{attendee.attended}"
						target="#{conferenceManagementController.attended}" />
					<f:setPropertyActionListener value="#{attendee.shortDesc}"
						target="#{conferenceManagementController.shortDesc}" />
				</a4j:commandLink> &nbsp; 
            </rich:column>
			<f:facet name="footer">
				<rich:datascroller id="sc1" ajaxSingle="false" reRender="sc2" />
			</f:facet>
		</rich:dataTable>
	</h:form>
	<rich:modalPanel id="updateAttendeePanel" autosized="true" width="450">
		<f:facet name="header">
			<h:outputText
				value="Update the attendee detail (#{conferenceManagementController.selectedAttendee.user}) for the conference '#{conferenceManagementController.selectedConference.name}'."
				style="padding-right:15px;" />
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="/images/icons/cancel.png"
					styleClass="hidelink" id="hideattendeeupdatelink" alt="X"/>
				<rich:componentControl for="updateAttendeePanel"
					attachTo="hideattendeeupdatelink" operation="hide" event="onclick" />
			</h:panelGroup>
		</f:facet>
		<h:form>
			<rich:messages style="color:red;"></rich:messages>
			<h:panelGrid columns="1">
				<h:panelGrid columns="2">
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
							value="Attended?: " /></font>
						<br />
						<h:outputText value="Check-In status" style="color:gray" />
					</h:panelGroup>
					<h:selectOneMenu value="#{conferenceManagementController.attended}"
						style="width:200px">
						<f:selectItem itemLabel="No" itemValue="#{false}" />
						<f:selectItem itemLabel="Yes" itemValue="#{true}" />
					</h:selectOneMenu>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
							value="Short Description :"></h:outputText></font>
						<br>
						<h:outputText
							value="Short description for the drop-down box. Max 1024 characters"
							style="color:gray"></h:outputText>
					</h:panelGroup>
					<h:inputTextarea
						value="#{conferenceManagementController.shortDesc}"
						style="width:200px" rows="2">
						<f:validateLength minimum="0" maximum="1024" />
					</h:inputTextarea>
				</h:panelGrid>
				<a4j:commandButton value="Edit" reRender="attendeeTable"
					action="#{conferenceManagementController.updateAttendee}"
					oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('createConferencePanel')}.hide();"></a4j:commandButton>
			</h:panelGrid>
		</h:form>
	</rich:modalPanel>
	<rich:modalPanel id="deleteAttendeePanel" autosized="true" width="200">
		<f:facet name="header">
			<h:outputText value="Delete the selected attendees"
				style="padding-right:15px;" />
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="/images/icons/cancel.png"
					styleClass="hidelink" id="hidedeletelink" alt="X"/>
				<rich:componentControl for="deleteAttendeePanel"
					attachTo="hidedeletelink" operation="hide" event="onclick" />
			</h:panelGroup>
		</f:facet>
		<h:form>
			<rich:messages style="color:red;"></rich:messages>
			<h:panelGrid columns="2">
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="Select Attendees to delete :"></h:outputText></font>
					<br>
					<h:outputText
						value="from the conference #{conferenceManagementController.selectedConference.name}"
						style="color:gray"></h:outputText>
				</h:panelGroup>
				<h:selectManyListbox id="alistid" size="25"
					value="#{conferenceManagementController.selectedAttendees}"
					converter="#{AttendeeDataConverter}" style="width: 200px;"
					required="true" requiredMessage="Select atleast one attendee.">
					<f:selectItems
						value="#{conferenceManagementController.attendeeList}"
						var="attendee" itemLabel="#{attendee.user.fullName}" />
				</h:selectManyListbox>
			</h:panelGrid>
			<a4j:commandButton value="Remove" reRender="alistid,attendeeTable"
				action="#{conferenceManagementController.removeAttendees}"
				oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('createConferencePanel')}.hide();"></a4j:commandButton>

		</h:form>
	</rich:modalPanel>
</f:subview>
