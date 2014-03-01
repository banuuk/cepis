<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="authz" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:subview id="conference">
	<h:form>
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="CEPIS Conference" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<rich:spacer height="20" />
		<authz:authorize ifAnyGranted="ROLE_DEVELOPER">
			<a4j:commandLink value="Sync Old Data" rendered="#{false}"
				actionListener="#{conferenceManagementController.syncOldConferenceData}"></a4j:commandLink>
		</authz:authorize>
		<rich:dataTable id="conferenceTable"
			value="#{conferenceManagementController.conferenceList}"
			var="conference" rows="25" width="100%">
			<f:facet name="header">
				<h:panelGrid columns="2" columnClasses="attendeecol1,attendeecol2"
					width="100%">
					<rich:datascroller align="right" for="conferenceTable" id="sc2"
						reRender="sc1" ajaxSingle="false" />
					<h:outputText>
						<h:panelGroup layout="block" style="text-align:right;align:right;">
							<a4j:commandLink id="createConferencelink"
								oncomplete="#{rich:component('createConferencePanel')}.show()"
								reRender="createConferencePanel">
								<h:outputText>Register new conference </h:outputText>
								<h:graphicImage value="/images/icons/report_add.png"
									style="border:0" styleClass="pic" alt=""/>
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
								value="Register new conference" />&nbsp;
							</h:panelGroup>
					</h:outputText>
				</h:panelGrid>

			</f:facet>
			<rich:column filterBy="#{conference.name}"
				sortBy="#{conference.name}" filterEvent="onkeyup">
				<f:facet name="header">
					<h:outputText value="Name" />
				</f:facet>
				<h:outputText value="#{conference.name}" />
			</rich:column>
			<rich:column sortBy="#{conference.type}">
				<f:facet name="header">
					<h:outputText value="Type" />
				</f:facet>
				<h:outputText value="#{conference.type}" />
			</rich:column>
			<rich:column sortBy="#{conference.conferenceDate}">
				<f:facet name="header">
					<h:outputText value="Date" />
				</f:facet>
				<h:outputText value="#{conference.conferenceDate}" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="Description" />
				</f:facet>
				<h:outputText
					value="#{fn:substring(conference.shortDesc,0,100)} ...">
				</h:outputText>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="Options" />
				</f:facet>
				<a4j:commandLink id="editConferenceLink" ajaxSingle="true"
					reRender="editConferencePanel"
					oncomplete="#{rich:component('editConferencePanel')}.show()">
					<h:graphicImage value="/images/icons/page_white_edit.png"
						style="border:0" styleClass="pic" alt=""/>
					<f:setPropertyActionListener value="#{conference}"
						target="#{conferenceManagementController.selectedConference}" />
					<f:setPropertyActionListener value="#{conference.name}"
						target="#{conferenceManagementController.name}" />
					<f:setPropertyActionListener value="#{conference.type}"
						target="#{conferenceManagementController.type}" />
					<f:setPropertyActionListener value="#{conference.conferenceDate}"
						target="#{conferenceManagementController.conferenceDate}" />
					<f:setPropertyActionListener value="#{conference.shortDesc}"
						target="#{conferenceManagementController.shortDesc}" />
				</a4j:commandLink>
				<rich:toolTip for="editConferenceLink"
					value="Update information for this conference." />&nbsp; 
				<a4j:commandLink id="deleteConferenceLink" ajaxSingle="true"
					reRender="deleteConferencePanel"
					oncomplete="#{rich:component('deleteConferencePanel')}.show()">
					<h:graphicImage value="/images/icons/delete.png" style="border:0"
						styleClass="pic" alt=""/>
					<f:setPropertyActionListener value="#{conference}"
						target="#{conferenceManagementController.selectedConference}" />
				</a4j:commandLink>
				<rich:toolTip for="deleteConferenceLink"
					value="Delete this conference." />&nbsp;
				<a4j:commandLink id="addAttendeelink" ajaxSingle="true"
					reRender="createAttendeePanel"
					oncomplete="#{rich:component('createAttendeePanel')}.show()">
					<h:graphicImage value="/images/icons/user_add.png" style="border:0"
						styleClass="pic" alt=""/>
					<f:setPropertyActionListener value="#{conference}"
						target="#{conferenceManagementController.selectedConference}" />
					<f:setPropertyActionListener value="#{null}"
						target="#{cepisConfigurationManager.selectedUser}" />
					<f:setPropertyActionListener value="#{null}"
						target="#{conferenceManagementController.admissionType}" />
					<f:setPropertyActionListener value="#{null}"
						target="#{conferenceManagementController.ukClassification}" />
					<f:setPropertyActionListener value="#{null}"
						target="#{conferenceManagementController.ukmajor}" />
					<f:setPropertyActionListener value="#{false}"
						target="#{conferenceManagementController.attended}" />
					<f:setPropertyActionListener value="#{null}"
						target="#{conferenceManagementController.shortDesc}" />
				</a4j:commandLink>
				<rich:toolTip for="addAttendeelink"
					value="Add an attendee to a conference." />&nbsp;
			</rich:column>
			<f:facet name="footer">
				<rich:datascroller id="sc1" ajaxSingle="false" reRender="sc2" />
			</f:facet>
		</rich:dataTable>
	</h:form>

	<rich:modalPanel id="editConferencePanel" autosized="true" width="200">
		<f:facet name="header">
			<h:outputText value="Update conference details"
				style="padding-right:15px;" />
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="/images/icons/cancel.png"
					styleClass="hidelink" id="hideconferenceeditlink" alt="X"/>
				<rich:componentControl for="editConferencePanel"
					attachTo="hideconferenceeditlink" operation="hide" event="onclick" />
			</h:panelGroup>
		</f:facet>
		<h:form>
			<rich:messages style="color:red;"></rich:messages>
			<h:panelGrid columns="1">
				<h:panelGrid columns="2">

					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
							value="Name: *" /></font>
						<br />
						<h:outputText value="Conference name" style="color:gray" />
					</h:panelGroup>
					<h:inputText value="#{conferenceManagementController.name}"
						style="width:200px" required="true"
						requiredMessage="Conference name is a required field.">
						<f:validateLength maximum="255" />
					</h:inputText>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
							value="Type: *" /></font>
						<br />
						<h:outputText value="Conference type" style="color:gray" />
					</h:panelGroup>
					<rich:comboBox value="#{conferenceManagementController.type}"
						style="width:200px" required="true"
						requiredMessage="Conference type is a required field."
						defaultLabel="Select conference type">
						<f:selectItem itemValue="Advising Conference" />
						<f:selectItem itemValue="General" />
						<f:selectItem itemValue="Not Applicable" />
						<f:validateLength maximum="255" />
					</rich:comboBox>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
							value="Date: *" /></font>
						<br />
						<h:outputText value="Conference date" style="color:gray" />
					</h:panelGroup>
					<rich:calendar
						value="#{conferenceManagementController.conferenceDate}"
						popup="true" style="width:200px" required="true"
						requiredMessage="Conference date is a required field.">
						<f:validateLength maximum="255" />
					</rich:calendar>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
							value="Short Description :"></h:outputText></font>
						<br />
						<h:outputText
							value="Short description for the drop-down box. Max 1024 characters"
							style="color:gray"></h:outputText>
					</h:panelGroup>
					<h:inputTextarea
						value="#{conferenceManagementController.shortDesc}"
						style="width:200px" rows="10">
						<f:validateLength minimum="0" maximum="1024" />
					</h:inputTextarea>
				</h:panelGrid>
				<a4j:commandButton value="Edit"
					reRender="conferenceTable,conferenceid"
					action="#{conferenceManagementController.updateConference}"
					oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('editConferencePanel')}.hide();"></a4j:commandButton>

			</h:panelGrid>
		</h:form>
	</rich:modalPanel>
	<rich:modalPanel id="deleteConferencePanel" autosized="true"
		width="200">
		<f:facet name="header">
			<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
				value="Are you sure, you want to delete the conference #{conferenceManagementController.selectedConference.name}?. This action will permanently remove all the information related to this conference, including the attendees list. Please note that this operation cannot be reversed." /></font>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="/images/icons/cancel.png"
					styleClass="hidelink" id="hidedeletelink" alt="X"/>
				<rich:componentControl for="deleteConferencePanel"
					attachTo="hidedeletelink" operation="hide" event="onclick" />
			</h:panelGroup>
		</f:facet>
		<h:form>
			<h:panelGroup style="width:60%;align:center;text-align:center;">
				<h:outputText
					value="Are you sure, delete the conference #{conferenceManagementController.selectedConference.name}?"
					style="padding-right:15px;" />
				<h:panelGrid style="width:60%;align:center;text-align:center;"
					columns="2" columnClasses="confCol1,confCol2">
					<a4j:commandButton value="Yes" ajaxSingle="true"
						reRender="conferenceTable,conferenceid"
						action="#{conferenceManagementController.deleteConference}"
						oncomplete="#{rich:component('deleteConferencePanel')}.hide();" />
					<a4j:commandButton value="Cancel"
						onclick="#{rich:component('deleteConferencePanel')}.hide();return false;" />
				</h:panelGrid>
			</h:panelGroup>
		</h:form>
	</rich:modalPanel>
</f:subview>
