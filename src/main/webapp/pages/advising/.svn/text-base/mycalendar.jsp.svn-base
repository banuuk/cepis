<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<link href="${facesContext.externalContext.requestContextPath}/css/calendar.css"
	media="screen" rel="stylesheet" type="text/css" />
<f:subview id="mycalendarView">
	<h:form>
		<!--  myCalendar -->
		<h:outputText value="#{advisingManagementController.initMyCalendar}"></h:outputText>
		<h:panelGrid columns="2" rowClasses="alignTop"
			columnClasses="calendarcol1,calendarcol2" width="100%">
			<h:panelGroup style="width:100%;align:center;text-align:center;">
				<!-- Side Calendar -->
				<rich:calendar id="scheduleNavigator"
					value="#{advisingManagementController.selectedDate}" popup="false">
					<a4j:support event="onchanged" reRender="scheduler,tool_options"
						ajaxSingle="true"
						actionListener="#{advisingManagementController.valueChangeSelectedWeek}" />
					<f:facet name="footer">
						<h:panelGrid columns="2">
							<h:outputText value="{selectedDateControl}"
								styleClass="calendarcontrol" />
							<h:outputText value="{todayControl}" styleClass="calendarcontrol" />
						</h:panelGrid>
					</f:facet>
				</rich:calendar>
			</h:panelGroup>
			<h:panelGrid width="100%">
				<h:panelGrid width="100%">
					<rich:toolBar height="25" width="100%"
						style="margin: 0px auto 0px auto" id="tool_options">
						<!-- Left Tools -->
						<rich:toolBarGroup location="left" style="padding: 2px 5px;">
							<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel">
								<rich:toolTip followMouse="true" direction="top-right"
									showDelay="500">
									<span style="white-space: nowrap"> Schedule a new
										appointment. </span>
								</rich:toolTip>
								<a4j:commandLink ajaxSingle="true"
									reRender="mySchedulerNewPanel"
									oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('mySchedulerNewPanel')}.show();">
									<h:graphicImage id="advisingmanagernewpic"
										value="/images/icons/date_add.png" style="border:0"
										styleClass="pic" alt=""/>
									<h:outputLabel value="New" for="advisingmanagernewpic"
										style="cursor: pointer; padding: 2px 10px; color: #000000; text-decoration: underline;" />
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
									<f:setPropertyActionListener
										target="#{advisingManagementController.apptReason}"
										value="#{null}" />
								</a4j:commandLink>
							</rich:panel>
						</rich:toolBarGroup>
						<rich:toolBarGroup location="left" style="padding: 2px 5px;"
							rendered="#{advisingManagementController.appointmentSelected}">
							<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel"
								rendered="false">
								<rich:toolTip followMouse="true" direction="top-right"
									showDelay="500">
									<span style="white-space: nowrap"> View full details of
										the selected advising appointment. </span>
								</rich:toolTip>
								<a4j:commandLink reRender="mySchedulerViewPanel"
									action="#{advisingManagementController.takeSelection}"
									oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('mySchedulerViewPanel')}.show();">
									<h:graphicImage id="advisingmanagerviewpic" 
										value="/images/find.gif" style="border:0" styleClass="pic" alt=""/>
									<h:outputLabel value="View" for="advisingmanagerviewpic"
										style="cursor: pointer; padding: 2px 10px; color: #000000; text-decoration: underline;" />
									<f:setPropertyActionListener value="#{true}"
										target="#{advisingManagementController.myCalendarMode}" />
									<f:setPropertyActionListener
										target="#{advisingManagementController.apptReason}"
										value="#{null}" />
								</a4j:commandLink>
							</rich:panel>
							<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel">
								<rich:toolTip followMouse="true" direction="top-right"
									showDelay="500">
									<span style="white-space: nowrap"> View/Update the selected
										appointment. </span>
								</rich:toolTip>
								<a4j:commandLink reRender="mySchedulerEditPanel"
									action="#{advisingManagementController.takeSelection}"
									oncomplete="#{rich:component('mySchedulerEditPanel')}.show();">
									<h:graphicImage id="advisoreditpic" value="/images/edit.gif"
										style="border:0" styleClass="pic" alt=""/>
									<h:outputLabel value="Open" for="advisoreditpic"
										style="cursor: pointer; padding: 2px 12px 2px 2px; color: #000000; text-decoration: underline;" />
									<f:setPropertyActionListener value="#{true}"
										target="#{advisingManagementController.myCalendarMode}" />
									<f:setPropertyActionListener
										target="#{advisingManagementController.apptReason}"
										value="#{null}" />
								</a4j:commandLink>
							</rich:panel>
							<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel">
								<rich:toolTip followMouse="true" direction="top-right"
									showDelay="500">
									<span style="white-space: nowrap"> Cancel the selected
										advising appointment. </span>
								</rich:toolTip>
								<a4j:commandLink reRender="mySchedulerCancelPanel"
									action="#{advisingManagementController.takeSelection}"
									oncomplete="#{rich:component('mySchedulerCancelPanel')}.show();">
									<h:graphicImage id="advisorcancelpic"
										value="/images/icons/cancel.png" style="border:0"
										styleClass="pic" alt=""/>
									<h:outputLabel value="Cancel" for="advisorcancelpic"
										style="cursor: pointer; padding: 2px 12px 2px 2px; color: #000000; text-decoration: underline;" />
									<f:setPropertyActionListener value="#{true}"
										target="#{advisingManagementController.myCalendarMode}" />
									<f:setPropertyActionListener
										target="#{advisingManagementController.apptReason}"
										value="#{null}" />
								</a4j:commandLink>
							</rich:panel>
							<authz:authorize ifAnyGranted="ROLE_ADVISOR,ROLE_DEVELOPER">
								<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel">
									<rich:toolTip followMouse="true" direction="top-right"
										showDelay="500">
										<span style="white-space: nowrap"> Delete the selected
											advising appointment. </span>
									</rich:toolTip>
									<a4j:commandLink reRender="mySchedulerDeletePanel"
										action="#{advisingManagementController.takeSelection}"
										oncomplete="#{rich:component('mySchedulerDeletePanel')}.show();">
										<h:graphicImage id="advisordeletepic"
											value="/images/icons/delete.png" style="border:0"
											styleClass="pic" alt=""/>
										<h:outputLabel value="Delete" for="advisordeletepic"
											style="cursor: pointer; padding: 2px 10px 2px 2px; color: #000000; text-decoration: underline;" />
										<f:setPropertyActionListener value="#{true}"
											target="#{advisingManagementController.myCalendarMode}" />
									</a4j:commandLink>
								</rich:panel>
							</authz:authorize>
						</rich:toolBarGroup>
						<authz:authorize ifAnyGranted="ROLE_ADVISOR">
							<rich:toolBarGroup location="left" style="padding: 2px 5px;"
								rendered="#{advisingManagementController.currentView=='SLOT'}">
								<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel">
									<rich:toolTip followMouse="true" direction="top-right"
										showDelay="500">
										<span style="white-space: nowrap"> Save the updated
											appointment slots. </span>
									</rich:toolTip>
									<a4j:commandLink
										actionListener="#{advisingManagementController.createAdvisingSessionSlots}">
										<h:graphicImage id="slotsave" value="/images/save.png"
											style="border:0" styleClass="pic" alt=""/>
										<h:outputLabel value="Save" for="slotsave"
											style="cursor: pointer; padding: 2px 12px 2px 2px; color: #000000; text-decoration: underline;" />
									</a4j:commandLink>
								</rich:panel>
							</rich:toolBarGroup>
						</authz:authorize>
						<!-- Right Tools -->
						<rich:toolBarGroup location="right" itemSeparator="line"
							id="right_tool_options">
							<rich:dropDownMenu>
								<f:facet name="label">
									<h:panelGroup>
										<h:outputText value="View" />
									</h:panelGroup>
								</f:facet>
								<authz:authorize ifAnyGranted="ROLE_ADVISOR">
									<rich:menuItem submitMode="ajax" id="view1" value="Day"
										reRender="scheduler,tool_options" ajaxSingle="true"
										disabled="#{advisingManagementController.currentView=='DAY'}"
										actionListener="#{advisingManagementController.showDay}" />

									<rich:menuItem submitMode="ajax" id="view2" value="Week"
										reRender="scheduler,tool_options" ajaxSingle="true"
										disabled="#{advisingManagementController.currentView=='WEEK'}"
										actionListener="#{advisingManagementController.showWeek}" />

									<rich:menuItem submitMode="ajax" id="view3" value="Work Week"
										reRender="scheduler,tool_options" ajaxSingle="true"
										disabled="#{advisingManagementController.currentView=='WORKWEEK'}"
										actionListener="#{advisingManagementController.showWorkWeek}" />

									<rich:menuItem submitMode="ajax" id="view4" value="Month"
										reRender="scheduler,tool_options" ajaxSingle="true"
										disabled="#{advisingManagementController.currentView=='MONTH'}"
										actionListener="#{advisingManagementController.showMonth}" />

									<rich:menuItem submitMode="ajax" id="view5" value="Agenda"
										reRender="scheduler,tool_options" ajaxSingle="true"
										disabled="#{advisingManagementController.currentView=='AGENDA'}"
										actionListener="#{advisingManagementController.showAgenda}" />
									<rich:menuSeparator id="menuSeparator11" />
									<rich:menuItem submitMode="ajax" id="slots" value="Slots"
										styleClass="buttonClass" reRender="scheduler,tool_options"
										ajaxSingle="true"
										disabled="#{advisingManagementController.currentView=='SLOT'}"
										actionListener="#{advisingManagementController.showAppointmentSlots}" />
								</authz:authorize>
								<rich:menuItem submitMode="ajax" id="schedule" value="Scheduler"
									reRender="scheduler,tool_options" ajaxSingle="true"
									disabled="#{advisingManagementController.currentView=='SCHEDULE'}"
									actionListener="#{advisingManagementController.showAdvisorSchedules}" />
							</rich:dropDownMenu>
						</rich:toolBarGroup>
						<rich:toolBarGroup location="right">
							<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel"
								rendered="#{advisingManagementController.currentView=='SCHEDULE'}">
								<rich:toolTip followMouse="true" direction="top-right"
									showDelay="500">
									<span style="white-space: nowrap"> Show filters. </span>
								</rich:toolTip>
								<rich:toggleControl for="filterPanel" value="#{'Filters'}">
								</rich:toggleControl>
							</rich:panel>
						</rich:toolBarGroup>
					</rich:toolBar>
				</h:panelGrid>

				<!-- myCalendar Display -->
				<h:panelGroup id="scheduler">
					<authz:authorize ifAnyGranted="ROLE_ADVISOR,ROLE_STUDENT,ROLE_ADVISING_MANAGER">
						<h:panelGroup id="cepisScheduler">
							<t:schedule value="#{advisingManagementController.model}"
								id="scheduleView1" submitOnClick="true"
								rendered="#{advisingManagementController.currentView=='' || advisingManagementController.currentView=='DAY' || advisingManagementController.currentView=='WORKWEEK' || advisingManagementController.currentView=='WEEK' || advisingManagementController.currentView=='MONTH'}"
								hourNotation="12"
								visibleEndHour="#{scheduleSettings2.visibleEndHour}"
								visibleStartHour="#{scheduleSettings2.visibleStartHour}"
								workingEndHour="#{scheduleSettings2.workingEndHour}"
								workingStartHour="#{scheduleSettings2.workingStartHour}"
								readonly="#{scheduleSettings2.readonly}" theme="evolution"
								tooltip="#{scheduleSettings2.tooltip}"
								renderZeroLengthEntries="#{scheduleSettings2.renderZeroLength}"
								expandToFitEntries="#{scheduleSettings2.expandToFitEntries}"
								headerDateFormat="#{scheduleSettings2.headerDateFormat}"
								compactWeekRowHeight="#{scheduleSettings2.compactWeekRowHeight}"
								compactMonthRowHeight="#{scheduleSettings2.compactMonthRowHeight}"
								detailedRowHeight="#{scheduleSettings2.detailedRowHeight}"
								entryRenderer="#{scheduleEntryRenderer}"
								mouseListener="#{advisingManagementController.scheduleClicked}"
								action="#{advisingManagementController.myCalendarAction}"
								binding="#{advisingManagementController.schedule}"
								entryClass="customEventStyle" textClass="customTextStyle">
							</t:schedule>
						</h:panelGroup>
						<h:panelGroup id="cepisAgenda"
							rendered="#{advisingManagementController.currentView=='AGENDA'}">
							<rich:extendedDataTable
								value="#{advisingManagementController.myCalendarDataModel}"
								var="advisingsession" id="advisor_table" width="100%"
								height="300px" sortMode="single" selectionMode="multi"
								tableState="#{advisingManagementController.tableState}"
								selection="#{advisingManagementController.selection}"
								binding="#{advisingManagementController.agendaTable}"
								enableContextMenu="false" rowClasses="odd-row, even-row"
								onRowMouseOver="this.style.backgroundColor='#B3C9E0'"
								onRowMouseOut="this.style.backgroundColor='#{rowKeyVar}'"
								selectedClass="selectedRow"
								noDataLabel="No appointments found for the selected date. Try another date.">
								<a4j:support event="onRowDblClick"
									reRender="mySchedulerEditPanel"
									action="#{advisingManagementController.takeSelection}"
									oncomplete="Richfaces.showModalPanel('mySchedulerEditPanel')">
									<f:setPropertyActionListener value="#{true}"
										target="#{advisingManagementController.myCalendarMode}" />
									<f:setPropertyActionListener
										target="#{advisingManagementController.apptReason}"
										value="#{null}" />
								</a4j:support>
								<rich:column sortable="true"
									sortBy="#{advisingsession.sessionDate}" id="col_1"
									filterBy="#{advisingsession.sessionDate}" filterEvent="onkeyup"
									width="200px" label="Appointment Time">
									<f:facet name="header">
										<h:outputText value="Appointment Time"
											styleClass="studentDataHeader" />
									</f:facet>
									<h:outputText value="#{advisingsession.sessionTime}"></h:outputText>
								</rich:column>
								<rich:column sortable="true"
									sortBy="#{advisingsession.user.fullName}" id="col_2"
									filterBy="#{advisingsession.user.fullName}"
									filterEvent="onkeyup" width="200px" label="Student Name">
									<f:facet name="header">
										<h:outputText value="Student Name"
											styleClass="studentDataHeader" />
									</f:facet>
									<h:outputText value="#{advisingsession.user.fullName}"></h:outputText>
								</rich:column>
								<rich:column sortable="true"
									sortBy="#{advisingsession.sessionType}" id="col_3"
									filterBy="#{advisingsession.sessionType}" filterEvent="onkeyup"
									width="120px" label="Appointment Type">
									<f:facet name="header">
										<h:outputText value="Appointment Type"
											styleClass="studentDataHeader" />
									</f:facet>
									<h:outputText value="#{advisingsession.sessionType}"></h:outputText>
								</rich:column>
								<rich:column sortable="true"
									sortBy="#{advisingsession.sessionStatus}" id="col_4"
									filterBy="#{advisingsession.sessionStatus}"
									filterEvent="onkeyup" width="120px" label="Appointment Status">
									<f:facet name="header">
										<h:outputText value="Appointment Status"
											styleClass="studentDataHeader" />
									</f:facet>
									<h:outputText value="#{advisingsession.sessionStatus}"></h:outputText>
								</rich:column>
								<rich:column width="150px" label="Comment">
									<f:facet name="header">
										<h:outputText value="Comment" styleClass="studentDataHeader" />
									</f:facet>
									<h:outputText value="#{advisingsession.preSessionText}"></h:outputText>
								</rich:column>
							</rich:extendedDataTable>
							<rich:spacer height="15px"></rich:spacer>
							<h:panelGrid width="100%" style="align:right;text-align:right;">
								<a4j:commandLink id="addToWS" reRender="advisor_table"
									actionListener="#{advisingManagementController.addToWS}">
									<h:outputLabel for="wsicon" value="Add To "
										style="cursor: pointer;  color: #000000; text-decoration: underline;" />
									<h:graphicImage id="wsicon" value="/images/icons/cart.png"
										style="padding: 2px 12px 2px 2px;border:0;" styleClass="pic" alt="Working Set:"/>
								</a4j:commandLink>
								<rich:toolTip for="addToWS" followMouse="true" showDelay="500"
									value="Add users of the selected appointments to the current working set (#{workingSetController.activeWorkingSetName})."></rich:toolTip>
							</h:panelGrid>
						</h:panelGroup>
					</authz:authorize>
					<authz:authorize ifAnyGranted="ROLE_ADVISOR,ROLE_ADVISING_MANAGER">
						<h:panelGroup id="advisorSchedules"
							rendered="#{advisingManagementController.currentView=='SCHEDULE'}">
							<h:panelGrid width="100%">
								<rich:togglePanel id="filterPanel" switchType="client"
									stateOrder="hide,show" initialState="show">
									<f:facet name="hide">
										<h:panelGroup></h:panelGroup>
									</f:facet>
									<f:facet name="show">
										<h:panelGroup>
											<rich:panel style="margin-left: auto; margin-right: auto;">
												<f:facet name="header">
													<h:outputText value="Filters" />
												</f:facet>
												<h:panelGrid width="100%" columns="3">
													<rich:panel bodyClass="rich-laguna-panel-no-header"
														style="align:center;">
														<h:outputText value="Filter By Advisor"
															styleClass="boldText"></h:outputText>
														<br />
														<rich:pickList id="advisorsPickList" immediate="true"
															value="#{advisingManagementController.selectedAdvisorList}"
															converter="#{AdvisorDataConverter}"
															converterMessage="Convert Error">
															<f:selectItems
																value="#{advisingManagementController.advisorsOptions}" />
															<f:validator validatorId="AdvisorDataValidator" />
															<a4j:support event="onlistchanged" ajaxSingle="true"
																reRender="advisorSchedulesTable" />
														</rich:pickList>
													</rich:panel>
													<rich:spacer width="25px"></rich:spacer>
													<rich:panel bodyClass="rich-laguna-panel-no-header"
														style="align:center;">
														<h:outputText value="Filter By Date" styleClass="boldText"></h:outputText>
														<br />
														<h:panelGrid columns="2">
															<h:outputText value="From: " styleClass="ws10"
																style="color:#062E8A;"></h:outputText>
															<rich:calendar id="starttime"
																value="#{advisingManagementController.selectedStartSessionDate}"
																cellWidth="24px" datePattern="MMM d,yyyy - HH:mm"
																resetTimeOnDateSelect="true" defaultTime="00:00"
																cellHeight="22px" style="width:200px"
																todayControlMode="hidden">
																<f:facet name="optionalFooter">
																	<a4j:commandButton value="Today"
																		onfocus="#{rich:component('starttime')}.selectDate(new Date(new Date().getTime()-3600000));#{rich:component('starttime')}.doCollapse();"
																		style="align:right; text-align:right" />
																</f:facet>
																<a4j:support event="onchanged" ajaxSingle="true"
																	actionListener="#{advisingManagementController.valueChangeStartSessionDate}"
																	reRender="starttime,endtime,advisorSchedulesTable" />
															</rich:calendar>
															<h:outputText value="To: " styleClass="ws10"
																style="color:#062E8A;"></h:outputText>
															<rich:calendar id="endtime"
																value="#{advisingManagementController.selectedEndSessionDate}"
																cellWidth="24px" datePattern="MMM d,yyyy - HH:mm"
																resetTimeOnDateSelect="true" defaultTime="23:59"
																cellHeight="22px" style="width:200px"
																todayControlMode="hidden">
																<f:facet name="optionalFooter">
																	<a4j:commandButton value="Today"
																		onfocus="#{rich:component('endtime')}.selectDate(new Date());#{rich:component('endtime')}.doCollapse();"
																		style="align:right; text-align:right" />
																</f:facet>
																<a4j:support event="onchanged" ajaxSingle="true"
																	reRender="advisorSchedulesTable" />
															</rich:calendar>
														</h:panelGrid>
													</rich:panel>
												</h:panelGrid>
											</rich:panel>
										</h:panelGroup>
									</f:facet>
								</rich:togglePanel>
								<rich:extendedDataTable
									value="#{advisingManagementController.selectedAdvisorsAdvisingSessionDataModel}"
									var="advisingsession" id="advisorSchedulesTable" width="100%"
									height="300px" sortMode="single" selectionMode="multi"
									tableState="#{advisingManagementController.tableState}"
									selection="#{advisingManagementController.selection}"
									binding="#{advisingManagementController.schedulerTable}"
									enableContextMenu="false" rowClasses="odd-row, even-row"
									onRowMouseOver="this.style.backgroundColor='#B3C9E0'"
									onRowMouseOut="this.style.backgroundColor='#{rowKeyVar}'"
									selectedClass="selectedRow"
									noDataLabel="No appointments found.">
									<a4j:support event="onRowDblClick"
										reRender="mySchedulerEditPanel"
										action="#{advisingManagementController.takeSelection}"
										oncomplete="Richfaces.showModalPanel('mySchedulerEditPanel')">
										<f:setPropertyActionListener value="#{false}"
											target="#{advisingManagementController.myCalendarMode}" />
										<f:setPropertyActionListener
											target="#{advisingManagementController.apptReason}"
											value="#{null}" />
									</a4j:support>
									<rich:column sortable="true"
										sortBy="#{advisingsession.advisor}" id="col_1"
										filterBy="#{advisingsession.advisor}" filterEvent="onblur"
										width="140px" label="Advisor">
										<f:facet name="header">
											<h:outputText value="Advisor" />
										</f:facet>
										<h:outputText value="#{advisingsession.advisor}"></h:outputText>
									</rich:column>
									<rich:column sortable="true"
										sortBy="#{advisingsession.sessionDate}" id="col_2"
										filterBy="#{advisingsession.sessionDate}"
										filterEvent="onkeyup" width="160px" label="Appointment Time">
										<f:facet name="header">
											<h:outputText value="Appointment Time" />
										</f:facet>
										<h:outputText value="#{advisingsession.sessionTime}"></h:outputText>
									</rich:column>
									<rich:column sortable="true"
										sortBy="#{advisingsession.user.fullName}" id="col_3"
										filterBy="#{advisingsession.user.fullName}"
										filterEvent="onkeyup" width="140px" label="Student Name">
										<f:facet name="header">
											<h:outputText value="Student Name" />
										</f:facet>
										<h:outputText value="#{advisingsession.user.fullName}"></h:outputText>
									</rich:column>
									<rich:column sortable="true"
										sortBy="#{advisingsession.sessionType}" id="col_4"
										width="140px" label="Appointment Type">
										<f:facet name="header">
											<h:outputText value="Appointment Type"
												styleClass="studentDataHeader" />
										</f:facet>
										<h:outputText value="#{advisingsession.sessionType}"></h:outputText>
									</rich:column>
									<rich:column id="col_5" width="140px" label="Status">
										<f:facet name="header">
											<h:outputText value="Status" />
										</f:facet>
										<h:outputText value="#{advisingsession.sessionStatus}"></h:outputText>
									</rich:column>
									<authz:authorize ifAnyGranted="ROLE_ADVISOR, ROLE_ADVISING_MANAGER">
										<rich:column width="150px" label="Comment">
											<f:facet name="header">
												<h:outputText value="Comment" styleClass="studentDataHeader" />
											</f:facet>
											<h:outputText value="#{advisingsession.preSessionText}"></h:outputText>
										</rich:column>
									</authz:authorize>
								</rich:extendedDataTable>
								<rich:spacer height="15px"></rich:spacer>
								<h:panelGrid width="100%" style="align:right;text-align:right;">
									<a4j:commandLink id="addToWS_Schedule"
										reRender="advisorSchedulesTable"
										actionListener="#{advisingManagementController.addToWS}">
										<h:outputLabel for="wsicon_Schedule" value="Add To "
											style="cursor: pointer;  color: #000000; text-decoration: underline;" />
										<h:graphicImage id="wsicon_Schedule"
											value="/images/icons/cart.png"
											style="padding: 2px 12px 2px 2px;border:0;" styleClass="pic" alt="Working Set:"/>
									</a4j:commandLink>
									<rich:toolTip for="addToWS" followMouse="true" showDelay="500"
										value="Add users of the selected appointments to the current working set (#{workingSetController.activeWorkingSetName})."></rich:toolTip>
								</h:panelGrid>
							</h:panelGrid>
						</h:panelGroup>
					</authz:authorize>
					<authz:authorize ifAnyGranted="ROLE_ADVISOR">
						<h:panelGroup id="cepisSlot"
							rendered="#{advisingManagementController.currentView=='SLOT'}">
							<script type="text/javascript">
								function selectAll(id, pID, selector) {
									//using jquery to select appropriate checkboxes
									//all checkboxes with id like pID are assigned value of checkbox id
									//ignores disabled checkboxes
									jQuery(
											"input:checkbox:not(:disabled)[id"
													+ selector + "=" + pID
													+ "]").attr(
											'checked',
											jQuery("input[id$=" + id + "]").is(
													':checked'));
								}
							</script>
							<h:panelGrid columns="6" width="100%"
								id="advisor_create_advisor_available_slots"
								style="margin-left: auto; margin-right: auto; margin-top: 0px; border-style:solid; border-width:1px; border-color: #BED6F8;">
								<h:panelGroup>
									<h:panelGrid columns="2">
										<f:facet name="header">
											<h:outputText value="Slots" />
										</f:facet>
										<h:outputText value="Slot #1"></h:outputText>
										<h:selectBooleanCheckbox id="slot1_all"
											onchange="selectAll('slot1_all', 'slot_1', '$');">
										</h:selectBooleanCheckbox>
										<h:outputText value="Slot #2"></h:outputText>
										<h:selectBooleanCheckbox id="slot2_all"
											onchange="selectAll('slot2_all', 'slot_2', '$');">
										</h:selectBooleanCheckbox>
										<h:outputText value="Slot #3"></h:outputText>
										<h:selectBooleanCheckbox id="slot3_all"
											onchange="selectAll('slot3_all', 'slot_3', '$');">
										</h:selectBooleanCheckbox>
										<h:outputText value="Slot #4"></h:outputText>
										<h:selectBooleanCheckbox id="slot4_all"
											onchange="selectAll('slot4_all', 'slot_4', '$');">
										</h:selectBooleanCheckbox>
										<h:outputText value="Slot #5"></h:outputText>
										<h:selectBooleanCheckbox id="slot5_all"
											onchange="selectAll('slot5_all', 'slot_5', '$');">
										</h:selectBooleanCheckbox>
										<h:outputText value="Slot #6"></h:outputText>
										<h:selectBooleanCheckbox id="slot6_all"
											onchange="selectAll('slot6_all', 'slot_6', '$');">
										</h:selectBooleanCheckbox>
										<h:outputText value="Slot #7"></h:outputText>
										<h:selectBooleanCheckbox id="slot7_all"
											onchange="selectAll('slot7_all', 'slot_7', '$');">
										</h:selectBooleanCheckbox>
										<h:outputText value="Slot #8"></h:outputText>
										<h:selectBooleanCheckbox id="slot8_all"
											onchange="selectAll('slot8_all', 'slot_8', '$');">
										</h:selectBooleanCheckbox>
										<h:outputText value="Slot #9"></h:outputText>
										<h:selectBooleanCheckbox id="slot9_all"
											onchange="selectAll('slot9_all', 'slot_9', '$');">
										</h:selectBooleanCheckbox>
										<h:outputText value="Slot #10"></h:outputText>
										<h:selectBooleanCheckbox id="slot10_all"
											onchange="selectAll('slot10_all', 'slot_10', '$');">
										</h:selectBooleanCheckbox>
										<h:outputText value="Slot #11"></h:outputText>
										<h:selectBooleanCheckbox id="slot11_all"
											onchange="selectAll('slot11_all', 'slot_11', '$');">
										</h:selectBooleanCheckbox>
										<h:outputText value="Slot #12"></h:outputText>
										<h:selectBooleanCheckbox id="slot12_all"
											onchange="selectAll('slot12_all', 'slot_12', '$');">
										</h:selectBooleanCheckbox>
										<h:outputText value="Slot #13"></h:outputText>
										<h:selectBooleanCheckbox id="slot13_all"
											onchange="selectAll('slot13_all', 'slot_13', '$');">
										</h:selectBooleanCheckbox>
										<h:outputText value="Slot #14"></h:outputText>
										<h:selectBooleanCheckbox id="slot14_all"
											onchange="selectAll('slot14_all', 'slot_14', '$');">
										</h:selectBooleanCheckbox>
										<h:outputText value="Slot #15"></h:outputText>
										<h:selectBooleanCheckbox id="slot15_all"
											onchange="selectAll('slot15_all', 'slot_15', '$');">
										</h:selectBooleanCheckbox>
										<h:outputText value="Slot #16"></h:outputText>
										<h:selectBooleanCheckbox id="slot16_all"
											onchange="selectAll('slot16_all', 'slot_16', '$');">
										</h:selectBooleanCheckbox>
									</h:panelGrid>
								</h:panelGroup>
								<h:panelGroup>
									<h:panelGrid id="monday" columns="2" style="text-align: right;">
										<f:facet name="header">
											<h:panelGroup>
												<h:outputText
													value="#{advisingManagementController.weekDays[0]}"
													style="color:#006699;" />
												<h:selectBooleanCheckbox id="monday_all"
													onchange="selectAll('monday_all', 'monday_slot', '*');">
												</h:selectBooleanCheckbox>
											</h:panelGroup>
										</f:facet>
										
										
										
										<h:outputText value="8:30-9:00"></h:outputText>
										<h:selectBooleanCheckbox id="monday_slot_1"
											disabled="#{advisingManagementController.disabledCheckboxArray[0][0]}"
											value="#{advisingManagementController.selectedCheckboxArray[0][0]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="9:00-9:30"></h:outputText>
										<h:selectBooleanCheckbox id="monday_slot_2"
											disabled="#{advisingManagementController.disabledCheckboxArray[0][1]}"
											value="#{advisingManagementController.selectedCheckboxArray[0][1]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="9:30-10:00"></h:outputText>
										<h:selectBooleanCheckbox id="monday_slot_3"
											disabled="#{advisingManagementController.disabledCheckboxArray[0][2]}"
											value="#{advisingManagementController.selectedCheckboxArray[0][2]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="10:00-10:30"></h:outputText>
										<h:selectBooleanCheckbox id="monday_slot_4"
											disabled="#{advisingManagementController.disabledCheckboxArray[0][3]}"
											value="#{advisingManagementController.selectedCheckboxArray[0][3]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="10:30-11:00"></h:outputText>
										<h:selectBooleanCheckbox id="monday_slot_5"
											disabled="#{advisingManagementController.disabledCheckboxArray[0][4]}"
											value="#{advisingManagementController.selectedCheckboxArray[0][4]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="11:00-11:30"></h:outputText>
										<h:selectBooleanCheckbox id="monday_slot_6"
											disabled="#{advisingManagementController.disabledCheckboxArray[0][5]}"
											value="#{advisingManagementController.selectedCheckboxArray[0][5]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="11:30-12:00"></h:outputText>
										<h:selectBooleanCheckbox id="monday_slot_7"
											disabled="#{advisingManagementController.disabledCheckboxArray[0][6]}"
											value="#{advisingManagementController.selectedCheckboxArray[0][6]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="12:00-12:30"></h:outputText>
										<h:selectBooleanCheckbox id="monday_slot_8"
											disabled="#{advisingManagementController.disabledCheckboxArray[0][7]}"
											value="#{advisingManagementController.selectedCheckboxArray[0][7]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="12:30-1:00"></h:outputText>
										<h:selectBooleanCheckbox id="monday_slot_9"
											disabled="#{advisingManagementController.disabledCheckboxArray[0][8]}"
											value="#{advisingManagementController.selectedCheckboxArray[0][8]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="1:00-1:30"></h:outputText>
										<h:selectBooleanCheckbox id="monday_slot_10"
											disabled="#{advisingManagementController.disabledCheckboxArray[0][9]}"
											value="#{advisingManagementController.selectedCheckboxArray[0][9]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="1:30-2:00"></h:outputText>
										<h:selectBooleanCheckbox id="monday_slot_11"
											disabled="#{advisingManagementController.disabledCheckboxArray[0][10]}"
											value="#{advisingManagementController.selectedCheckboxArray[0][10]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="2:00-2:30"></h:outputText>
										<h:selectBooleanCheckbox id="monday_slot_12"
											disabled="#{advisingManagementController.disabledCheckboxArray[0][11]}"
											value="#{advisingManagementController.selectedCheckboxArray[0][11]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="2:30-3:00"></h:outputText>
										<h:selectBooleanCheckbox id="monday_slot_13"
											disabled="#{advisingManagementController.disabledCheckboxArray[0][12]}"
											value="#{advisingManagementController.selectedCheckboxArray[0][12]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="3:00-3:30"></h:outputText>
										<h:selectBooleanCheckbox id="monday_slot_14"
											disabled="#{advisingManagementController.disabledCheckboxArray[0][13]}"
											value="#{advisingManagementController.selectedCheckboxArray[0][13]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="3:30-4:00"></h:outputText>
										<h:selectBooleanCheckbox id="monday_slot_15"
											disabled="#{advisingManagementController.disabledCheckboxArray[0][14]}"
											value="#{advisingManagementController.selectedCheckboxArray[0][14]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="4:00-4:30"></h:outputText>
										<h:selectBooleanCheckbox id="monday_slot_16"
											disabled="#{advisingManagementController.disabledCheckboxArray[0][15]}"
											value="#{advisingManagementController.selectedCheckboxArray[0][15]}">
										</h:selectBooleanCheckbox>
										
										
										
										
									</h:panelGrid>
								</h:panelGroup>
								<h:panelGroup>
									<h:panelGrid columns="2" style="text-align: right;">
										<f:facet name="header">
											<h:panelGroup>
												<h:outputText
													value="#{advisingManagementController.weekDays[1]}"
													style="color:#006699;" />
												<h:selectBooleanCheckbox id="tuesday_all"
													onchange="selectAll('tuesday_all', 'tuesday_slot', '*');">
												</h:selectBooleanCheckbox>
											</h:panelGroup>
										</f:facet>
										<h:outputText value="8:30-9:00"></h:outputText>
										<h:selectBooleanCheckbox id="tuesday_slot_1"
											disabled="#{advisingManagementController.disabledCheckboxArray[1][0]}"
											value="#{advisingManagementController.selectedCheckboxArray[1][0]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="9:00-9:30"></h:outputText>
										<h:selectBooleanCheckbox id="tuesday_slot_2"
											disabled="#{advisingManagementController.disabledCheckboxArray[1][1]}"
											value="#{advisingManagementController.selectedCheckboxArray[1][1]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="9:30-10:00"></h:outputText>
										<h:selectBooleanCheckbox id="tuesday_slot_3"
											disabled="#{advisingManagementController.disabledCheckboxArray[1][2]}"
											value="#{advisingManagementController.selectedCheckboxArray[1][2]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="10:00-10:30"></h:outputText>
										<h:selectBooleanCheckbox id="tuesday_slot_4"
											disabled="#{advisingManagementController.disabledCheckboxArray[1][3]}"
											value="#{advisingManagementController.selectedCheckboxArray[1][3]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="10:30-11:00"></h:outputText>
										<h:selectBooleanCheckbox id="tuesday_slot_5"
											disabled="#{advisingManagementController.disabledCheckboxArray[1][4]}"
											value="#{advisingManagementController.selectedCheckboxArray[1][4]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="11:00-11:30"></h:outputText>
										<h:selectBooleanCheckbox id="tuesday_slot_6"
											disabled="#{advisingManagementController.disabledCheckboxArray[1][5]}"
											value="#{advisingManagementController.selectedCheckboxArray[1][5]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="11:30-12:00"></h:outputText>
										<h:selectBooleanCheckbox id="tuesday_slot_7"
											disabled="#{advisingManagementController.disabledCheckboxArray[1][6]}"
											value="#{advisingManagementController.selectedCheckboxArray[1][6]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="12:00-12:30"></h:outputText>
										<h:selectBooleanCheckbox id="tuesday_slot_8"
											disabled="#{advisingManagementController.disabledCheckboxArray[1][7]}"
											value="#{advisingManagementController.selectedCheckboxArray[1][7]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="12:30-1:00"></h:outputText>
										<h:selectBooleanCheckbox id="tuesday_slot_9"
											disabled="#{advisingManagementController.disabledCheckboxArray[1][8]}"
											value="#{advisingManagementController.selectedCheckboxArray[1][8]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="1:00-1:30"></h:outputText>
										<h:selectBooleanCheckbox id="tuesday_slot_10"
											disabled="#{advisingManagementController.disabledCheckboxArray[1][9]}"
											value="#{advisingManagementController.selectedCheckboxArray[1][9]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="1:30-2:00"></h:outputText>
										<h:selectBooleanCheckbox id="tuesday_slot_11"
											disabled="#{advisingManagementController.disabledCheckboxArray[1][10]}"
											value="#{advisingManagementController.selectedCheckboxArray[1][10]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="2:00-2:30"></h:outputText>
										<h:selectBooleanCheckbox id="tuesday_slot_12"
											disabled="#{advisingManagementController.disabledCheckboxArray[1][11]}"
											value="#{advisingManagementController.selectedCheckboxArray[1][11]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="2:30-3:00"></h:outputText>
										<h:selectBooleanCheckbox id="tuesday_slot_13"
											disabled="#{advisingManagementController.disabledCheckboxArray[1][12]}"
											value="#{advisingManagementController.selectedCheckboxArray[1][12]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="3:00-3:30"></h:outputText>
										<h:selectBooleanCheckbox id="tuesday_slot_14"
											disabled="#{advisingManagementController.disabledCheckboxArray[1][13]}"
											value="#{advisingManagementController.selectedCheckboxArray[1][13]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="3:30-4:00"></h:outputText>
										<h:selectBooleanCheckbox id="tuesday_slot_15"
											disabled="#{advisingManagementController.disabledCheckboxArray[1][14]}"
											value="#{advisingManagementController.selectedCheckboxArray[1][14]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="4:00-4:30"></h:outputText>
										<h:selectBooleanCheckbox id="tuesday_slot_16"
											disabled="#{advisingManagementController.disabledCheckboxArray[1][15]}"
											value="#{advisingManagementController.selectedCheckboxArray[1][15]}">
										</h:selectBooleanCheckbox>
									</h:panelGrid>
								</h:panelGroup>
								<h:panelGroup>
									<h:panelGrid columns="2" style="text-align: right;">
										<f:facet name="header">
											<h:panelGroup>
												<h:outputText
													value="#{advisingManagementController.weekDays[2]}"
													style="color:#006699;" />
												<h:selectBooleanCheckbox id="wednesday_all"
													onchange="selectAll('wednesday_all', 'wednesday_slot', '*');">
												</h:selectBooleanCheckbox>
											</h:panelGroup>
										</f:facet>
										<h:outputText value="8:30-9:00"></h:outputText>
										<h:selectBooleanCheckbox id="wednesday_slot_1"
											disabled="#{advisingManagementController.disabledCheckboxArray[2][0]}"
											value="#{advisingManagementController.selectedCheckboxArray[2][0]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="9:00-9:30"></h:outputText>
										<h:selectBooleanCheckbox id="wednesday_slot_2"
											disabled="#{advisingManagementController.disabledCheckboxArray[2][1]}"
											value="#{advisingManagementController.selectedCheckboxArray[2][1]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="9:30-10:00"></h:outputText>
										<h:selectBooleanCheckbox id="wednesday_slot_3"
											disabled="#{advisingManagementController.disabledCheckboxArray[2][2]}"
											value="#{advisingManagementController.selectedCheckboxArray[2][2]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="10:00-10:30"></h:outputText>
										<h:selectBooleanCheckbox id="wednesday_slot_4"
											disabled="#{advisingManagementController.disabledCheckboxArray[2][3]}"
											value="#{advisingManagementController.selectedCheckboxArray[2][3]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="10:30-11:00"></h:outputText>
										<h:selectBooleanCheckbox id="wednesday_slot_5"
											disabled="#{advisingManagementController.disabledCheckboxArray[2][4]}"
											value="#{advisingManagementController.selectedCheckboxArray[2][4]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="11:00-11:30"></h:outputText>
										<h:selectBooleanCheckbox id="wednesday_slot_6"
											disabled="#{advisingManagementController.disabledCheckboxArray[2][5]}"
											value="#{advisingManagementController.selectedCheckboxArray[2][5]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="11:30-12:00"></h:outputText>
										<h:selectBooleanCheckbox id="wednesday_slot_7"
											disabled="#{advisingManagementController.disabledCheckboxArray[2][6]}"
											value="#{advisingManagementController.selectedCheckboxArray[2][6]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="12:00-12:30"></h:outputText>
										<h:selectBooleanCheckbox id="wednesday_slot_8"
											disabled="#{advisingManagementController.disabledCheckboxArray[2][7]}"
											value="#{advisingManagementController.selectedCheckboxArray[2][7]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="12:30-1:00"></h:outputText>
										<h:selectBooleanCheckbox id="wednesday_slot_9"
											disabled="#{advisingManagementController.disabledCheckboxArray[2][8]}"
											value="#{advisingManagementController.selectedCheckboxArray[2][8]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="1:00-1:30"></h:outputText>
										<h:selectBooleanCheckbox id="wednesday_slot_10"
											disabled="#{advisingManagementController.disabledCheckboxArray[2][9]}"
											value="#{advisingManagementController.selectedCheckboxArray[2][9]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="1:30-2:00"></h:outputText>
										<h:selectBooleanCheckbox id="wednesday_slot_11"
											disabled="#{advisingManagementController.disabledCheckboxArray[2][10]}"
											value="#{advisingManagementController.selectedCheckboxArray[2][10]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="2:00-2:30"></h:outputText>
										<h:selectBooleanCheckbox id="wednesday_slot_12"
											disabled="#{advisingManagementController.disabledCheckboxArray[2][11]}"
											value="#{advisingManagementController.selectedCheckboxArray[2][11]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="2:30-3:00"></h:outputText>
										<h:selectBooleanCheckbox id="wednesday_slot_13"
											disabled="#{advisingManagementController.disabledCheckboxArray[2][12]}"
											value="#{advisingManagementController.selectedCheckboxArray[2][12]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="3:00-3:30"></h:outputText>
										<h:selectBooleanCheckbox id="wednesday_slot_14"
											disabled="#{advisingManagementController.disabledCheckboxArray[2][13]}"
											value="#{advisingManagementController.selectedCheckboxArray[2][13]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="3:30-4:00"></h:outputText>
										<h:selectBooleanCheckbox id="wednesday_slot_15"
											disabled="#{advisingManagementController.disabledCheckboxArray[2][14]}"
											value="#{advisingManagementController.selectedCheckboxArray[2][14]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="4:00-4:30"></h:outputText>
										<h:selectBooleanCheckbox id="wednesday_slot_16"
											disabled="#{advisingManagementController.disabledCheckboxArray[2][15]}"
											value="#{advisingManagementController.selectedCheckboxArray[2][15]}">
										</h:selectBooleanCheckbox>
									</h:panelGrid>
								</h:panelGroup>
								<h:panelGroup>
									<h:panelGrid columns="2" style="text-align: right;">
										<f:facet name="header">
											<h:panelGroup>
												<h:outputText
													value="#{advisingManagementController.weekDays[3]}"
													style="color:#006699;" />
												<h:selectBooleanCheckbox id="thursday_all"
													onchange="selectAll('thursday_all', 'thursday_slot', '*');">
												</h:selectBooleanCheckbox>
											</h:panelGroup>
										</f:facet>
										<h:outputText value="8:30-9:00"></h:outputText>
										<h:selectBooleanCheckbox id="thursday_slot_1"
											disabled="#{advisingManagementController.disabledCheckboxArray[3][0]}"
											value="#{advisingManagementController.selectedCheckboxArray[3][0]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="9:00-9:30"></h:outputText>
										<h:selectBooleanCheckbox id="thursday_slot_2"
											disabled="#{advisingManagementController.disabledCheckboxArray[3][1]}"
											value="#{advisingManagementController.selectedCheckboxArray[3][1]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="9:30-10:00"></h:outputText>
										<h:selectBooleanCheckbox id="thursday_slot_3"
											disabled="#{advisingManagementController.disabledCheckboxArray[3][2]}"
											value="#{advisingManagementController.selectedCheckboxArray[3][2]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="10:00-10:30"></h:outputText>
										<h:selectBooleanCheckbox id="thursday_slot_4"
											disabled="#{advisingManagementController.disabledCheckboxArray[3][3]}"
											value="#{advisingManagementController.selectedCheckboxArray[3][3]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="10:30-11:00"></h:outputText>
										<h:selectBooleanCheckbox id="thursday_slot_5"
											disabled="#{advisingManagementController.disabledCheckboxArray[3][4]}"
											value="#{advisingManagementController.selectedCheckboxArray[3][4]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="11:00-11:30"></h:outputText>
										<h:selectBooleanCheckbox id="thursday_slot_6"
											disabled="#{advisingManagementController.disabledCheckboxArray[3][5]}"
											value="#{advisingManagementController.selectedCheckboxArray[3][5]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="11:30-12:00"></h:outputText>
										<h:selectBooleanCheckbox id="thursday_slot_7"
											disabled="#{advisingManagementController.disabledCheckboxArray[3][6]}"
											value="#{advisingManagementController.selectedCheckboxArray[3][6]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="12:00-12:30"></h:outputText>
										<h:selectBooleanCheckbox id="thursday_slot_8"
											disabled="#{advisingManagementController.disabledCheckboxArray[3][7]}"
											value="#{advisingManagementController.selectedCheckboxArray[3][7]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="12:30-1:00"></h:outputText>
										<h:selectBooleanCheckbox id="thursday_slot_9"
											disabled="#{advisingManagementController.disabledCheckboxArray[3][8]}"
											value="#{advisingManagementController.selectedCheckboxArray[3][8]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="1:00-1:30"></h:outputText>
										<h:selectBooleanCheckbox id="thursday_slot_10"
											disabled="#{advisingManagementController.disabledCheckboxArray[3][9]}"
											value="#{advisingManagementController.selectedCheckboxArray[3][9]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="1:30-2:00"></h:outputText>
										<h:selectBooleanCheckbox id="thursday_slot_11"
											disabled="#{advisingManagementController.disabledCheckboxArray[3][10]}"
											value="#{advisingManagementController.selectedCheckboxArray[3][10]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="2:00-2:30"></h:outputText>
										<h:selectBooleanCheckbox id="thursday_slot_12"
											disabled="#{advisingManagementController.disabledCheckboxArray[3][11]}"
											value="#{advisingManagementController.selectedCheckboxArray[3][11]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="2:30-3:00"></h:outputText>
										<h:selectBooleanCheckbox id="thursday_slot_13"
											disabled="#{advisingManagementController.disabledCheckboxArray[3][12]}"
											value="#{advisingManagementController.selectedCheckboxArray[3][12]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="3:00-3:30"></h:outputText>
										<h:selectBooleanCheckbox id="thursday_slot_14"
											disabled="#{advisingManagementController.disabledCheckboxArray[3][13]}"
											value="#{advisingManagementController.selectedCheckboxArray[3][13]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="3:30-4:00"></h:outputText>
										<h:selectBooleanCheckbox id="thursday_slot_15"
											disabled="#{advisingManagementController.disabledCheckboxArray[3][14]}"
											value="#{advisingManagementController.selectedCheckboxArray[3][14]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="4:00-4:30"></h:outputText>
										<h:selectBooleanCheckbox id="thursday_slot_16"
											disabled="#{advisingManagementController.disabledCheckboxArray[3][15]}"
											value="#{advisingManagementController.selectedCheckboxArray[3][15]}">
										</h:selectBooleanCheckbox>
									</h:panelGrid>
								</h:panelGroup>
								<h:panelGroup>
									<h:panelGrid columns="2" style="text-align: right;">
										<f:facet name="header">
											<h:panelGroup>
												<h:outputText
													value="#{advisingManagementController.weekDays[4]}"
													style="color:#006699;" />
												<h:selectBooleanCheckbox id="friday_all"
													onchange="selectAll('friday_all', 'friday_slot', '*');">
												</h:selectBooleanCheckbox>
											</h:panelGroup>
										</f:facet>
										<h:outputText value="8:30-9:00"></h:outputText>
										<h:selectBooleanCheckbox id="friday_slot_1"
											disabled="#{advisingManagementController.disabledCheckboxArray[4][0]}"
											value="#{advisingManagementController.selectedCheckboxArray[4][0]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="9:00-9:30"></h:outputText>
										<h:selectBooleanCheckbox id="friday_slot_2"
											disabled="#{advisingManagementController.disabledCheckboxArray[4][1]}"
											value="#{advisingManagementController.selectedCheckboxArray[4][1]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="9:30-10:00"></h:outputText>
										<h:selectBooleanCheckbox id="friday_slot_3"
											disabled="#{advisingManagementController.disabledCheckboxArray[4][2]}"
											value="#{advisingManagementController.selectedCheckboxArray[4][2]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="10:00-10:30"></h:outputText>
										<h:selectBooleanCheckbox id="friday_slot_4"
											disabled="#{advisingManagementController.disabledCheckboxArray[4][3]}"
											value="#{advisingManagementController.selectedCheckboxArray[4][3]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="10:30-11:00"></h:outputText>
										<h:selectBooleanCheckbox id="friday_slot_5"
											disabled="#{advisingManagementController.disabledCheckboxArray[4][4]}"
											value="#{advisingManagementController.selectedCheckboxArray[4][4]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="11:00-11:30"></h:outputText>
										<h:selectBooleanCheckbox id="friday_slot_6"
											disabled="#{advisingManagementController.disabledCheckboxArray[4][5]}"
											value="#{advisingManagementController.selectedCheckboxArray[4][5]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="11:30-12:00"></h:outputText>
										<h:selectBooleanCheckbox id="friday_slot_7"
											disabled="#{advisingManagementController.disabledCheckboxArray[4][6]}"
											value="#{advisingManagementController.selectedCheckboxArray[4][6]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="12:00-12:30"></h:outputText>
										<h:selectBooleanCheckbox id="friday_slot_8"
											disabled="#{advisingManagementController.disabledCheckboxArray[4][7]}"
											value="#{advisingManagementController.selectedCheckboxArray[4][7]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="12:30-1:00"></h:outputText>
										<h:selectBooleanCheckbox id="friday_slot_9"
											disabled="#{advisingManagementController.disabledCheckboxArray[4][8]}"
											value="#{advisingManagementController.selectedCheckboxArray[4][8]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="1:00-1:30"></h:outputText>
										<h:selectBooleanCheckbox id="friday_slot_10"
											disabled="#{advisingManagementController.disabledCheckboxArray[4][9]}"
											value="#{advisingManagementController.selectedCheckboxArray[4][9]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="1:30-2:00"></h:outputText>
										<h:selectBooleanCheckbox id="friday_slot_11"
											disabled="#{advisingManagementController.disabledCheckboxArray[4][10]}"
											value="#{advisingManagementController.selectedCheckboxArray[4][10]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="2:00-2:30"></h:outputText>
										<h:selectBooleanCheckbox id="friday_slot_12"
											disabled="#{advisingManagementController.disabledCheckboxArray[4][11]}"
											value="#{advisingManagementController.selectedCheckboxArray[4][11]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="2:30-3:00"></h:outputText>
										<h:selectBooleanCheckbox id="friday_slot_13"
											disabled="#{advisingManagementController.disabledCheckboxArray[4][12]}"
											value="#{advisingManagementController.selectedCheckboxArray[4][12]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="3:00-3:30"></h:outputText>
										<h:selectBooleanCheckbox id="friday_slot_14"
											disabled="#{advisingManagementController.disabledCheckboxArray[4][13]}"
											value="#{advisingManagementController.selectedCheckboxArray[4][13]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="3:30-4:00"></h:outputText>
										<h:selectBooleanCheckbox id="friday_slot_15"
											disabled="#{advisingManagementController.disabledCheckboxArray[4][14]}"
											value="#{advisingManagementController.selectedCheckboxArray[4][14]}">
										</h:selectBooleanCheckbox>
										<h:outputText value="4:00-4:30"></h:outputText>
										<h:selectBooleanCheckbox id="friday_slot_16"
											disabled="#{advisingManagementController.disabledCheckboxArray[4][15]}"
											value="#{advisingManagementController.selectedCheckboxArray[4][15]}">
										</h:selectBooleanCheckbox>
									</h:panelGrid>
								</h:panelGroup>
							</h:panelGrid>
						</h:panelGroup>
					</authz:authorize>
				</h:panelGroup>
			</h:panelGrid>
		</h:panelGrid>
	</h:form>
</f:subview>