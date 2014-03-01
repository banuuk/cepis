<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:subview id="advising-manager-schedule-custom-advisingsession">
	<h:form>

		<p>Manually schedule an advising appointment for a student below.
		Select the advisor from the list of advisors, select from the
		available time slots, and then select a student from your working set.</p>
		<h:panelGrid columns="2" style="margin:auto;">
			<rich:panel style="width:400px; margin: 40px auto;">
				<f:facet name="header">
					<h:outputText value="Schedule Form" />
				</f:facet>

				<h:panelGrid columns="3"
					style="padding-right: 10px; padding-left: 10px">

					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
							value="Select the advisor: " /></font>
					</h:panelGroup>
					<rich:spacer width="15" height="10" title="Here is a spacer..." />
					<h:selectOneListbox id="advising_manager_schedule_advisor_list"
						value="#{advisingManagementController.selectedAdvisor}" size="1"
						converter="#{AdvisorDataConverter}" style="width:220px"
						required="true" requiredMessage="Advisor: Value is required.">
						<f:selectItem itemLabel="Select One" itemValue="NA" />
						<f:selectItems
							value="#{advisingManagementController.activeAdvisorList}"
							var="advisor" itemLabel="#{advisor.shortDesc}" />
						<f:validator validatorId="AdvisorDataValidator" />
						<a4j:support event="onchange" ajaxSingle="true"
							reRender="advising_manager_schedule_advising_session_list" />
					</h:selectOneListbox>

					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
							value="Select a date and time: " /></font>
					</h:panelGroup>
					<rich:spacer width="15" height="10" title="Here is a spacer..." />
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
				</h:panelGrid>

				<rich:separator lineType="beveled" height="8" align="center"
					style="margin: 10px" />

				<h:panelGrid columns="3"
					style="padding-right: 10px; padding-left: 10px">

					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
							value="Appointment Type: " /></font>
					</h:panelGroup>
					<rich:spacer width="20" height="10" title="Here is a spacer..." />
					<h:selectOneListbox id="advising_manager_schedule_session_type_id"
						value="#{advisingManagementController.selectedSessionType}"
						size="1" required="true"
						requiredMessage="Appointment Type: Value is required.">
						<f:selectItem itemLabel="Personal" itemValue="Personal" />
						<f:selectItem itemLabel="Registration" itemValue="Registration" />
						<f:selectItem itemLabel="Program Issues"
							itemValue="Program Issues" />
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
					<h:inputTextarea
						value="#{advisingManagementController.preSessionText}"
						style="width:200px" rows="5">
					</h:inputTextarea>
				</h:panelGrid>


				<h:commandButton id="advising_manager_schedule_button"
					value="Schedule" style="display: block; margin: auto;"
					action="#{advisingManagementController.createAdvisingSessionSelectedUser}">
				</h:commandButton>

			</rich:panel>
			<h:panelGroup id="workingSet">
				<rich:panel style="height:250px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:outputText>Working Set:  </h:outputText>
							<font color="#062E8A" face="Tahoma"><B><h:outputText
								id="ws_name"
								value=" #{workingSetController.activeWorkingSetName}"></h:outputText></B></font>&nbsp;&nbsp;<h:graphicImage
								url="/images/info.png" alt="i"
								title="#{workingSetController.activeWorkingSetDescription}" />
						</h:panelGroup>
					</f:facet>
					<h:panelGrid columns="1">
						<h:form>
							<h:panelGroup style="vertical-align:center;" layout="block">
								<h:selectOneListbox id="wsid"
									value="#{cepisConfigurationManager.selectedUser}" size="12"
									converter="#{UserDataConverter}" style="width: 200px;"
									required="true" onchange="submit();"
									valueChangeListener="#{accountManagementController.updateSelectedUser}"
									requiredMessage="User: You must select a user from the working set.">
									<f:selectItems
										value="#{workingSetController.activeWSUsersList}" var="user"
										itemLabel="#{user.fullName}" />
									<f:validator validatorId="UserDataValidator" />
								</h:selectOneListbox>
							</h:panelGroup>
							<div class="wpmd">
							<div align=right><font class="ws8" color="#062E8A"
								face="Tahoma"><a
								href="${facesContext.externalContext.requestContextPath}/pages/ws/index.cps"
								title="Working Set"><span>More options &gt;&gt;</span></a>
							&nbsp;&nbsp;&nbsp;&nbsp;</font></div>
							</div>
						</h:form>
					</h:panelGrid>
				</rich:panel>
			</h:panelGroup>
		</h:panelGrid>
	</h:form>
</f:subview>