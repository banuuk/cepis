<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<!-- Action Modal Panels -->
<rich:modalPanel id="mySchedulerViewPanel"  width="600" height="500"
domElementAttachment="parent">
	<f:facet name="header">
		<h:outputText value="View Selected Advising Appointment" />
	</f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<h:graphicImage value="/images/icons/cancel.png" id="hideViewlink"
				styleClass="hidelink" alt="X" />
			<rich:componentControl for="mySchedulerViewPanel"
				attachTo="hideViewlink" operation="hide" event="onclick" />
		</h:panelGroup>
	</f:facet>
	<h:form>
		<rich:messages style="color:red;"></rich:messages>

		<h:panelGrid columns="3"
			style="padding-right: 10px; padding-left: 10px">

			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Appointment Time: " /></font>
			</h:panelGroup>
			<rich:spacer width="35" height="10" title="Here is a spacer..." />
			<h:outputText id="view_session_time" style="width: 200px"
				value="#{advisingManagementController.selectedAdvisingSession.sessionTime}">
			</h:outputText>
			<authz:authorize ifAnyGranted="ROLE_ADVISOR,ROLE_ADVISING_MANAGER">
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
							value="Student Name: " /></font>
				</h:panelGroup>
				<rich:spacer width="35" height="10" title="Here is a spacer..." />
				<h:outputText id="view_student_name" style="width: 200px"
					value="#{advisingManagementController.selectedAdvisingSession.user}">
				</h:outputText>
			</authz:authorize>
			<authz:authorize ifAnyGranted="ROLE_STUDENT,ROLE_ADVISING_MANAGER">
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
							value="Advisor Name: " /></font>
				</h:panelGroup>
				<rich:spacer width="35" height="10" title="Here is a spacer..." />
				<h:outputText id="view_advisor_name" style="width: 200px"
					value="#{advisingManagementController.selectedAdvisingSession.advisor}">
				</h:outputText>
			</authz:authorize>
		</h:panelGrid>

		<rich:separator lineType="beveled" height="8" align="center"
			style="margin: 10px" />

		<h:panelGrid columns="3"
			style="padding-right: 10px; padding-left: 10px">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Appointment Type: " /></font>
			</h:panelGroup>
			<rich:spacer width="15" height="10" title="Here is a spacer..." />
			<h:outputText id="view_session_type" style="width: 200px"
				value="#{advisingManagementController.selectedSessionType}">
			</h:outputText>

			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Appointment Status: " /></font>
			</h:panelGroup>
			<rich:spacer width="15" height="10" title="Here is a spacer..." />
			<h:outputText id="view_session_status" style="width: 200px"
				value="#{advisingManagementController.sessionStatus}">
			</h:outputText>
			<authz:authorize ifAnyGranted="ROLE_STUDENT,ROLE_ADVISOR">
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
							value="Comments :"></h:outputText></font>
				</h:panelGroup>
				<rich:spacer width="15" height="10" title="Here is a spacer..." />
				<rich:panel bodyClass="rich-laguna-panel-no-header"
					style="width:100%;">
					<h:outputText id="view_pre_session_text"
						value="#{advisingManagementController.preSessionText}"
						style="width:200px" />
				</rich:panel>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
							value="Appointment Summary :"></h:outputText></font>
				</h:panelGroup>
				<rich:spacer width="15" height="10" title="Here is a spacer..." />
				
				<rich:editor value="#{advisingManagementController.sessionText}"
								width="300" theme="advanced" readonly="true" />
			</authz:authorize>
			<authz:authorize ifAnyGranted="ROLE_ADVISOR">
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
							value="Advisor Notes:"></h:outputText></font>
				</h:panelGroup>
				<rich:spacer width="15" height="10" title="Here is a spacer..." />
				<rich:panel bodyClass="rich-laguna-panel-no-header"
					style="width:100%;">
					<h:outputText id="view_advisor_notes"
						value="#{advisingManagementController.advisorNotes}"
						style="width:200px">
					</h:outputText>
				</rich:panel>
			</authz:authorize>
			<authz:authorize ifAnyGranted="ROLE_STUDENT">
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
							value="Student Notes:"></h:outputText></font>
				</h:panelGroup>
				<rich:spacer width="15" height="10" title="Here is a spacer..." />
				<rich:panel bodyClass="rich-laguna-panel-no-header"
					style="width:100%;">
					<h:outputText id="view_student_notes"
						value="#{advisingManagementController.studentNotes}"
						style="width:200px">
					</h:outputText>
				</rich:panel>
			</authz:authorize>
		</h:panelGrid>
	</h:form>
</rich:modalPanel>

<rich:modalPanel id="mySchedulerEditPanel" width="550" autosized="true"
	domElementAttachment="parent" minHeight="150">
	<f:facet name="header">
		<h:outputText value="Edit Selected Advising Appointment" />
	</f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<h:graphicImage value="/images/icons/cancel.png" id="hideEditlink"
				styleClass="hidelink" alt="X" />
			<rich:componentControl for="mySchedulerEditPanel"
				attachTo="hideEditlink" operation="hide" event="onclick" />
		</h:panelGroup>
	</f:facet>
	
	<a4j:outputPanel id="addMessages" ajaxRendered="true" style="align:center;">
		<h:panelGrid columns="1" width="95%" id="messageSection">
			<rich:messages errorClass="cepiserror" infoClass="cepissuccess"
			warnClass="cepiswarning" tooltip="true" id="cepisMsgs"/>
		</h:panelGrid>
		<a4j:status onstart="showModalInfoWindow();" onstop="hideModalInfoWindow()"/>
	</a4j:outputPanel>

	<h:panelGroup layout="block" style="overflow:auto;">
		<rich:tabPanel switchType="ajax">
			<rich:tab id="Appointment_Tab" label="Appointment">
				<h:form>
					<h:panelGrid columns="3"
						style="padding-right: 10px; padding-left: 10px">
						<h:panelGroup>
							<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
									value="Appointment Time: " /></font>
						</h:panelGroup>
						<rich:spacer width="35" height="10" title="Here is a spacer..." />
						<h:outputText id="view_session_time" style="width: 200px"
							value="#{advisingManagementController.selectedAdvisingSession.sessionTime}">
						</h:outputText>
						<authz:authorize ifAnyGranted="ROLE_ADVISOR,ROLE_ADVISING_MANAGER">
							<h:panelGroup>
								<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Student Name: " /></font>
							</h:panelGroup>
							<rich:spacer width="35" height="10" title="Here is a spacer..." />
							<h:outputText id="view_student_name" style="width: 200px"
								value="#{advisingManagementController.selectedAdvisingSession.user}">
							</h:outputText>
						</authz:authorize>
						<authz:authorize ifAnyGranted="ROLE_STUDENT,ROLE_ADVISING_MANAGER">
							<h:panelGroup>
								<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Advisor Name: " /></font>
							</h:panelGroup>
							<rich:spacer width="35" height="10" title="Here is a spacer..." />
							<h:outputText id="edit_advisor_name" style="width: 200px"
								value="#{advisingManagementController.selectedAdvisingSession.advisor}">
							</h:outputText>
						</authz:authorize>
					</h:panelGrid>
					<rich:separator lineType="beveled" height="8" align="center"
						style="margin: 10px" />
					<h:panelGrid columns="2"
						style="padding-right: 10px; padding-left: 10px">
						<h:panelGroup>
							<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
									value="Appointment Type: " /></font>
						</h:panelGroup>
						<h:selectOneListbox id="edit_session_type"
							value="#{advisingManagementController.selectedSessionType}"
							size="1" required="true"
							requiredMessage="Appointment Type: Value is required.">
							<f:selectItem itemLabel="Personal" itemValue="Personal" />
							<f:selectItem itemLabel="Registration" itemValue="Registration" />
							<f:selectItem itemLabel="Program Issues"
								itemValue="Program Issues" />
							<f:selectItem itemLabel="Program Audit" itemValue="Program Audit" />
							<f:selectItem itemLabel="Early Alerts" itemValue="Early Alerts" />
							<f:selectItem itemLabel="Other" itemValue="Other" />
						</h:selectOneListbox>
						<authz:authorize ifAnyGranted="ROLE_ADVISOR,ROLE_ADVISING_MANAGER">
							<h:panelGroup>
								<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Appointment Status: " /></font>
							</h:panelGroup>
							<h:selectOneListbox id="edit_session_status"
								value="#{advisingManagementController.sessionStatus}" size="1"
								required="true"
								disabled="#{advisingManagementController.sessionStatus eq 'Cancelled'}"
								requiredMessage="Appointment Status: Value is required.">
								<f:selectItem itemLabel="Scheduled" itemValue="Scheduled" />
								<f:selectItem itemLabel="Checked In" itemValue="Checked In" />
								<f:selectItem itemLabel="Completed" itemValue="Completed" />
								<f:selectItem itemLabel="Cancelled" itemValue="Cancelled" />
								<f:selectItem itemLabel="No Show" itemValue="No Show" />
							</h:selectOneListbox>
						</authz:authorize>
						<authz:authorize ifAnyGranted="ROLE_STUDENT">
							<h:panelGroup>
								<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Appointment Status: " /></font>
							</h:panelGroup>
							<h:outputText
								value="#{advisingManagementController.sessionStatus}">
							</h:outputText>
						</authz:authorize>
						<authz:authorize ifAnyGranted="ROLE_STUDENT">
							<h:panelGroup>
								<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
										value="Comments :"></h:outputText></font>
							</h:panelGroup>
							<h:inputTextarea id="edit_pre_session_text"
								value="#{advisingManagementController.preSessionText}"
								style="width:300px" rows="4">
							</h:inputTextarea>
						</authz:authorize>
						<authz:authorize ifAnyGranted="ROLE_ADVISOR">
							<h:panelGroup>
								<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
										value="Comments :"></h:outputText></font>
							</h:panelGroup>
							<rich:panel bodyClass="rich-laguna-panel-no-header"
								style="width:100%;">
								<h:outputText
									value="#{advisingManagementController.preSessionText}"
									style="width:300px">
								</h:outputText>
							</rich:panel>
						</authz:authorize>
						<authz:authorize ifAnyGranted="ROLE_ADVISOR">
							<h:panelGroup>
								<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
										value="Appt. Summary :"></h:outputText></font>
							</h:panelGroup>
							<rich:editor id="edit_session_text"
								value="#{advisingManagementController.sessionText}"
								style="height:200px;" width="100" theme="advanced" />
						</authz:authorize>
						<authz:authorize ifAnyGranted="ROLE_STUDENT">
							<h:panelGroup>
								<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
										value="Appt. Summary : "></h:outputText></font>
								<h:graphicImage id="apptSummaryInfo" value="/images/info.png"
									style="border:0" styleClass="pic" alt="i" />
								<rich:toolTip for="apptSummaryInfo"
									value="View the appointment summary entered by your advisor here." />
							</h:panelGroup>
							<rich:editor value="#{advisingManagementController.sessionText}"
								width="300" theme="advanced" readonly="true" />
						</authz:authorize>
						<authz:authorize ifAnyGranted="ROLE_STUDENT">
							<h:panelGroup>
								<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
										value="Student Notes:"></h:outputText></font>
								<h:graphicImage id="studentNoteInfo" value="/images/info.png"
									style="border:0" styleClass="pic" alt="i" />
								<rich:toolTip for="studentNoteInfo"
									value="This is your personal note section. No one except you can view/edit this section. Even your advisor can't see this section. Feel free to add appointment related information here." />
							</h:panelGroup>
							<h:inputTextarea id="edit_student_notes"
								value="#{advisingManagementController.studentNotes}"
								style="width:300px" rows="4">
							</h:inputTextarea>
						</authz:authorize>
						<authz:authorize ifAnyGranted="ROLE_ADVISOR">
							<h:panelGroup>
								<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
										value="Advisor Notes:"></h:outputText></font>
								<h:graphicImage id="advisorNoteInfo" value="/images/info.png"
									style="border:0" styleClass="pic" alt="i" />
								<rich:toolTip for="advisorNoteInfo"
									value="This is your personal note section. No one except you can view/edit this section." />
							</h:panelGroup>
							<h:inputTextarea id="edit_advisor_notes"
								value="#{advisingManagementController.advisorNotes}"
								style="width:300px" rows="4">
							</h:inputTextarea>
						</authz:authorize>
						<authz:authorize ifAnyGranted="ROLE_ADVISING_MANAGER">
							<authz:authorize ifNotGranted="ROLE_ADVISOR">
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
											value="Comment: " /></font>
									<h:graphicImage id="commentReasonInfo" value="/images/info.png"
										style="border:0" styleClass="pic" alt="i" />
									<rich:toolTip for="commentReasonInfo"
										value="Please use this section to add any information about this appointment change." />
								</h:panelGroup>
								<h:inputTextarea id="appt_mgr_reason"
									value="#{advisingManagementController.preSessionText}"
									style="width:250px" rows="4">
								</h:inputTextarea>
							</authz:authorize>
						</authz:authorize>
					</h:panelGrid>
					<authz:authorize ifAnyGranted="ROLE_ADVISOR">
						<h:panelGroup>
							<h:selectBooleanCheckbox
								value="#{advisingManagementController.notifyChanges}"></h:selectBooleanCheckbox>
						&nbsp;&nbsp;&nbsp;
				<h:outputText
								value=" Send notification email to the student about these changes."></h:outputText>
							<h:panelGroup>
								<h:graphicImage id="notifyInfo" url="/images/info.png" alt="i" />
								<rich:toolTip for="notifyInfo"
									value="Student will receive a notification email only if you have modified the appointment summary and selected this option." />
							</h:panelGroup>
						</h:panelGroup>
					</authz:authorize>
					<a4j:commandButton value="Edit"
						reRender="scheduler,advising_manager_table,student_datatable,ems_appt_datatable"
						style="display: block; margin: 20px auto;"
						action="#{advisingManagementController.editAdvisingSession}"
						oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('mySchedulerEditPanel')}.hide();">
					</a4j:commandButton>
				</h:form>
			</rich:tab>
			<authz:authorize ifAnyGranted="ROLE_ADVISOR">
				<rich:tab id="HoldLift_Tab" label="Hold Lift">
					<h:form>
						<h:panelGrid width="100%">
							<h:outputText value="Recent HoldLifts:" styleClass="boldText"></h:outputText>
							<rich:dataTable id="studentRecentHoldLiftsTable"
								styleClass="scrollTable" headerClass="head1"
								rowClasses="normalRow,alternateRow" width="100%"
								sortMode="single"
								columnClasses="standardTable_Column,standardTable_ColumnCentered,standardTable_Column"
								var="holdLift"
								value="#{advisingManagementController.recentHoldLifts}" rows="4">
								<rich:column sortable="true"
									sortBy="#{holdLift.term.ukTermCode}" id="rcol_1" width="100px"
									label="Term" sortOrder="DESCENDING">
									<f:facet name="header">
										<h:outputText value="Term" />
									</f:facet>
									<h:outputText value="#{holdLift.term}" />
								</rich:column>
								<rich:column id="rcol_2" width="100px" label="Lifted By">
									<f:facet name="header">
										<h:outputText value="Lifted By" />
									</f:facet>
									<h:outputText value="#{holdLift.liftedBy}" />
								</rich:column>
								<rich:column id="rcol_3" width="100px" label="Lifted On">
									<f:facet name="header">
										<h:outputText value="Lifted On" />
									</f:facet>
									<h:outputText value="#{holdLift.addedOn}" />
								</rich:column>
							</rich:dataTable>
							<rich:spacer height="25px"></rich:spacer>
							<h:outputText value="HoldLifts linked to this appointment:"
								styleClass="boldText"></h:outputText>
							<rich:dataTable id="appointmentHoldLiftsTable"
								styleClass="scrollTable" headerClass="head1"
								rowClasses="normalRow,alternateRow" width="100%"
								sortMode="single"
								columnClasses="standardTable_Column,standardTable_ColumnCentered,standardTable_Column"
								var="holdLift"
								value="#{advisingManagementController.appointmentHoldLifts}">
								<rich:column sortable="true"
									sortBy="#{holdLift.term.ukTermCode}" id="acol_1" width="100px"
									label="Term" sortOrder="DESCENDING">
									<f:facet name="header">
										<h:outputText value="Term" />
									</f:facet>
									<h:outputText value="#{holdLift.term}" />
								</rich:column>
								<rich:column id="acol_2" width="100px" label="Lifted By">
									<f:facet name="header">
										<h:outputText value="Lifted By" />
									</f:facet>
									<h:outputText value="#{holdLift.liftedBy}" />
								</rich:column>
								<rich:column id="acol_3" width="100px" label="Lifted On">
									<f:facet name="header">
										<h:outputText value="Lifted On" />
									</f:facet>
									<h:outputText value="#{holdLift.addedOn}" />
								</rich:column>
							</rich:dataTable>
						</h:panelGrid>
						<rich:separator lineType="beveled" height="8" align="center"
							style="margin: 10px" />
						<!-- Add Hold lifts -->

						<rich:panel bodyClass="rich-laguna-panel-no-header"
							style="width:80%;margin: 40px auto;">
							<h:panelGrid columns="3"
								style="padding-right: 10px; padding-left: 10px">

								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
											value="Select Term: " /></font>
								</h:panelGroup>
								<rich:spacer width="15" height="10" title="Here is a spacer..." />
								<h:selectOneListbox id="term_list_id" style="width:200px"
									value="#{advisingManagementController.selectedHoldLiftTerm}"
									size="1" converter="#{UKTermDataConverter}">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.ukTermList}"
										var="ukTerm" itemLabel="#{ukTerm.shortDesc}" />
									<f:validator validatorId="UKTermDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
											value="Lifted By: " /></font>
								</h:panelGroup>
								<rich:spacer width="15" height="10" title="Here is a spacer..." />
								<h:outputText
									value="#{advisingManagementController.selectedAdvisingSession.advisor}"></h:outputText>
							</h:panelGrid>
							<h:panelGrid width="100%">
								<a4j:commandButton id="add_hold_data" value="Add Hold Lift"
									style="display: block; margin: auto;" ajaxSingle="true"
									process="term_list_id" limitToList="true"
									reRender="studentRecentHoldLiftsTable,appointmentHoldLiftsTable,term_list_id"
									action="#{advisingManagementController.addHoldLift}" />
							</h:panelGrid>
						</rich:panel>
					</h:form>
				</rich:tab>
				
			</authz:authorize>
			<authz:authorize ifAnyGranted="ROLE_ADVISOR">
				<rich:tab id="PastAppointments_Tab" label="Past Appointments">
					<h:form id="pastAppointments_Form">
						<rich:extendedDataTable id="pastAppt_table"  style="margin: 1px auto"
								var="advisingsession" selectedClass="selectedRow"
								height="150px" width="95%" rowClasses="odd-row, even-row"
								binding="#{advisingManagementController.pastAppointmentsTable}"	
								value="#{advisingManagementController.pastAppointments}"							
								onRowMouseOver="this.style.backgroundColor='#B3C9E0'"
								onRowMouseOut="this.style.backgroundColor='#{rowKeyVar}'" >
								<a4j:support event="onRowClick" reRender="pastAppointmentsText_Area"
									action="#{advisingManagementController.takePastAppointmentSelection}">
								</a4j:support>
								<rich:column id="col_1" label="Appointment Time" width="36%">
									<f:facet name="header">
										<h:outputText styleClass="studentDataHeader"
											value="Appointment Time" id="session_time" />
									</f:facet>
									<h:outputText value="#{advisingsession.sessionTime}"
										id="advisingsession_sessiontime" />
								</rich:column>
								<rich:column id="col_2" label="Advisor" width="31%">
									<f:facet name="header">
										<h:outputText styleClass="studentDataHeader" value="Advisor"
											id="advisor" />
									</f:facet>
									<h:outputText value="#{advisingsession.advisor.shortDesc}"
										id="advisingsession_advisor" />
								</rich:column>
								<rich:column id="col_3" label="Session Type" width="33%">
									<f:facet name="header">
										<h:outputText styleClass="studentDataHeader"
											value="Appointment Type" id="session_type" />
									</f:facet>
									<h:outputText value="#{advisingsession.sessionType}"
										id="advisingsession_sessiontype" />
								</rich:column>	
							</rich:extendedDataTable>
							<h:panelGrid id="pastAppointmentsText_Area" columns="2">							
								<h:outputLabel for="apptSummary" value="Appt. Summary: " style="color:#062E8A; font:Tahoma"/>				
								<rich:editor width="415" id="apptSummary" readonly="true" 
								value="#{advisingManagementController.selectedPastAppointment.sessionText}" />										
								<h:outputText value="Advisor Notes:" style="color:#062E8A; font:Tahoma"/>	
								<h:inputTextarea id="advisorNotes" style="width:200px" disabled="true"
								value="#{advisingManagementController.selectedPastAppointment.advisorNotes}"/>
								<h:outputLabel for="comments" value="Comments:" style="color:#062E8A; font:Tahoma"/>
								<h:inputTextarea id="comments" style="width:300px" disabled="true"
								value="#{advisingManagementController.selectedPastAppointment.preSessionText}" rows="4"/>
								<h:outputLabel for="studentNotes" value="Student Notes:" style="color:#062E8A; font:Tahoma"/>
								<h:inputTextarea id="studentNotes" style="width:300px" disabled="true"
								value="#{advisingManagementController.selectedPastAppointment.studentNotes}" rows="4"/>
							</h:panelGrid>				
						</h:form>
				</rich:tab>
			</authz:authorize>
		</rich:tabPanel>
	</h:panelGroup>
</rich:modalPanel>

<rich:modalPanel id="mySchedulerCancelPanel" width="450"
	autosized="true">
	<f:facet name="header">
		<h:outputText value="Cancel Selected Advising Appointment" />
	</f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<h:graphicImage value="/images/icons/cancel.png" id="hideCancellink"
				styleClass="hidelink" alt="X" />
			<rich:componentControl for="mySchedulerCancelPanel"
				attachTo="hideCancellink" operation="hide" event="onclick" />
		</h:panelGroup>
	</f:facet>
	<h:form>
		<rich:messages errorClass="cepiserror" infoClass="cepissuccess"
			warnClass="cepiswarning"></rich:messages>
		<authz:authorize ifAnyGranted="ROLE_ADVISOR,ROLE_ADVISING_MANAGER">
			<p>When canceling a student's advising appointment, it frees the
				slot that is tied to the appointment and changes the appointment's
				status to cancelled.</p>

			<p>You may cancel an appointment at anytime but student's may
				only cancel an appointment up until 48 hours before the designated
				time.</p>
		</authz:authorize>
		<authz:authorize ifAnyGranted="ROLE_STUDENT">
			<p>You may cancel an Advising Appointment electronically up to
				two days before the appointment is scheduled. If you need to cancel
				within the two days of your scheduled appointment, please call the
				Academic Services office at (859) 257-7971.</p>
		</authz:authorize>

		<rich:separator lineType="beveled" height="8" align="center"
			style="margin: 10px" />

		<h:panelGrid columns="3"
			style="padding-right: 10px; padding-left: 10px">

			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Appointment Time: " /></font>
			</h:panelGroup>
			<rich:spacer width="35" height="10" title="Here is a spacer..." />
			<h:outputText id="view_session_time" style="width: 200px"
				value="#{advisingManagementController.selectedAdvisingSession.sessionTime}">
			</h:outputText>
			<authz:authorize ifAnyGranted="ROLE_ADVISOR,ROLE_ADVISING_MANAGER">
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
							value="Student Name: " /></font>
				</h:panelGroup>
				<rich:spacer width="35" height="10" title="Here is a spacer..." />
				<h:outputText id="view_student_name" style="width: 200px"
					value="#{advisingManagementController.selectedAdvisingSession.user}">
				</h:outputText>
			</authz:authorize>
			<authz:authorize ifAnyGranted="ROLE_STUDENT,ROLE_ADVISING_MANAGER">
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
							value="Advisor Name: " /></font>
				</h:panelGroup>
				<rich:spacer width="35" height="10" title="Here is a spacer..." />
				<h:outputText id="view_advisor_name" style="width: 200px"
					value="#{advisingManagementController.selectedAdvisingSession.advisor}">
				</h:outputText>
			</authz:authorize>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Reason: " /></font>
				<h:graphicImage id="cancelReasonInfo" value="/images/info.png"
					style="border:0" styleClass="pic" alt="i" />
				<rich:toolTip for="cancelReasonInfo"
					value="Please provide the reason for cancelling this appointment if you have one. This will help the advisors to keep record of the cancelled appointments." />
			</h:panelGroup>
			<rich:spacer width="35" height="10" title="Here is a spacer..." />
			<h:inputTextarea id="add_appt_reason"
				value="#{advisingManagementController.apptReason}"
				style="width:250px" rows="4">
			</h:inputTextarea>
		</h:panelGrid>
		<authz:authorize ifAnyGranted="ROLE_ADVISOR,ROLE_ADVISING_MANAGER">
			<a4j:commandButton value="Cancel"
				reRender="scheduler,advising_manager_table,ems_appt_datatable"
				style="display: block; margin: 20px auto;"
				action="#{advisingManagementController.cancelAdvisingSession}"
				oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('mySchedulerCancelPanel')}.hide();">
			</a4j:commandButton>
		</authz:authorize>
		<authz:authorize ifAnyGranted="ROLE_STUDENT">
			<a4j:commandButton value="Cancel"
				reRender="student_datatable,ems_appt_datatable"
				style="display: block; margin: 20px auto;"
				action="#{advisingManagementController.cancelAdvisingSessionWithTimeConstraint}"
				oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('mySchedulerCancelPanel')}.hide();">
			</a4j:commandButton>
		</authz:authorize>
	</h:form>
</rich:modalPanel>
<authz:authorize ifAnyGranted="ROLE_ADVISOR,ROLE_ADVISING_MANAGER">
	<rich:modalPanel id="mySchedulerDeletePanel" width="450"
		autosized="true">
		<f:facet name="header">
			<h:outputText value="Delete Selected Advising Appointment" />
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="/images/icons/cancel.png" id="hideDeletelink"
					styleClass="hidelink" alt="X" />
				<rich:componentControl for="mySchedulerDeletePanel"
					attachTo="hideDeletelink" operation="hide" event="onclick" />
			</h:panelGroup>
		</f:facet>
		<h:form>
			<rich:messages style="color:red;"></rich:messages>

			<p>When deleting a student's advising appointment, it frees the
				slot that is tied to the appointment and removes all history of the
				appointment.</p>

			<rich:separator lineType="beveled" height="8" align="center"
				style="margin: 10px" />

			<h:panelGrid columns="3"
				style="padding-right: 10px; padding-left: 10px">

				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
							value="Appointment Time: " /></font>
				</h:panelGroup>
				<rich:spacer width="35" height="10" title="Here is a spacer..." />
				<h:outputText id="view_session_time" style="width: 200px"
					value="#{advisingManagementController.selectedAdvisingSession.sessionTime}">
				</h:outputText>

				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
							value="Student Name: " /></font>
				</h:panelGroup>
				<rich:spacer width="35" height="10" title="Here is a spacer..." />
				<h:outputText id="view_student_name" style="width: 200px"
					value="#{advisingManagementController.selectedAdvisingSession.user}">
				</h:outputText>
			</h:panelGrid>

			<a4j:commandButton value="Delete"
				reRender="scheduler,advising_manager_table,student_table"
				style="display: block; margin: 20px auto;"
				action="#{advisingManagementController.deleteAdvisingSession}"
				oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('mySchedulerDeletePanel')}.hide();">
			</a4j:commandButton>
		</h:form>
	</rich:modalPanel>
</authz:authorize>
<authz:authorize ifAnyGranted="ROLE_ADVISOR,ROLE_ADVISING_MANAGER">
	<rich:modalPanel id="mySchedulerNewPanel" width="500" autosized="true">
		<f:facet name="header">
			<h:outputText value="Schedule a new Appointment" />
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="/images/icons/cancel.png" id="hideNewlink"
					styleClass="hidelink" alt="X" />
				<rich:componentControl for="mySchedulerNewPanel"
					attachTo="hideNewlink" operation="hide" event="onclick" />
			</h:panelGroup>
		</f:facet>
		<h:panelGroup layout="block" style="overflow:auto;">
			<rich:tabPanel switchType="ajax">
				<rich:tab label="Appointment">
					<h:form>
					
						<a4j:outputPanel id="addMessages" ajaxRendered="true" style="align:center;">
							<h:panelGrid columns="1" width="95%" id="messageSection">
								<rich:messages errorClass="cepiserror" infoClass="cepissuccess"
								warnClass="cepiswarning" tooltip="true" id="cepisMsgs"/>
							</h:panelGrid>
							<a4j:status onstart="showModalInfoWindow();" onstop="hideModalInfoWindow()"/>
						</a4j:outputPanel>
						
						<a4j:include viewId="schedule-advisingsession.jsp"></a4j:include>
						<h:panelGrid columns="2" width="100%">
							<authz:authorize ifAnyGranted="ROLE_ADVISOR">
								<a4j:commandButton id="advisor_schedule_button" value="Schedule"
									style="display: block; margin: auto;"
									reRender="advising_manager_table,scheduler,schedule_student_wsid,student_schedule_advisor_list,student_schedule_advising_session_list,student_schedule_session_type_id,student_comment_section"
									action="#{advisingManagementController.createAdvisingSessionSelectedUser}">
									<f:setPropertyActionListener
										target="#{advisingManagementController.selectedAdvisor}"
										value="#{advisingManagementController.currentAdvisor}" />
								</a4j:commandButton>
							</authz:authorize>
							<authz:authorize ifNotGranted="ROLE_ADVISOR">
								<authz:authorize ifAnyGranted="ROLE_ADVISING_MANAGER">
									<a4j:commandButton id="advisng_mgr_schedule_button"
										value="Schedule" style="display: block; margin: auto;"
										reRender="advising_manager_table,scheduler,schedule_student_wsid,student_schedule_advisor_list,student_schedule_advising_session_list,student_schedule_session_type_id,student_comment_section"
										action="#{advisingManagementController.createAdvisingSessionSelectedUser}" />
								</authz:authorize>
							</authz:authorize>
							<a4j:commandButton id="reset_button" value="Clear"
								style="display: block; margin: auto;" ajaxSingle="true"
								reRender="schedule_student_wsid,student_schedule_advisor_list,student_schedule_advising_session_list,student_schedule_session_type_id,student_comment_section">
								<f:setPropertyActionListener
									target="#{advisingManagementController.preSessionText}"
									value="#{null}" />
								<f:setPropertyActionListener
									target="#{advisingManagementController.selectedSessionType}"
									value="#{null}" />
								<f:setPropertyActionListener
									target="#{advisingManagementController.selectedAdvisingSessionSlot}"
									value="#{null}" />
								<f:setPropertyActionListener
									target="#{advisingManagementController.selectedAdvisor}"
									value="#{null}" />
								<f:setPropertyActionListener
									target="#{cepisConfigurationManager.selectedUser}"
									value="#{null}" />
							</a4j:commandButton>
						</h:panelGrid>
					</h:form>
				</rich:tab>
			</rich:tabPanel>
		</h:panelGroup>
	</rich:modalPanel>
</authz:authorize>