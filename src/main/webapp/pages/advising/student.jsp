<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:subview id="show_panel">
	<h:form>
		<rich:togglePanel id="student_appt_list" switchType="client"
			stateOrder="hide,show">
			<f:facet name="hide">
				<h:panelGroup></h:panelGroup>
			</f:facet>
			<f:facet name="show">
				<h:panelGrid width="100%">
					<rich:toolBar height="25px" width="80%" itemSeparator="line"
						style="margin: 20px auto 0px auto">
						<rich:toolBarGroup>
							<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel">
								<rich:toolTip followMouse="true" direction="top-right"
									showDelay="500">
									<span style="white-space: nowrap"> View full details of
									the selected advising appointment</span>
								</rich:toolTip>
								<a4j:commandLink reRender="mySchedulerViewPanel"
									ajaxSingle="true" process="student_datatable"
									action="#{advisingManagementController.takeSelection}"
									oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('mySchedulerViewPanel')}.show();">
									<h:graphicImage id="studentviewpic" value="/images/find.gif"
										style="border:0" styleClass="pic" alt="" />
									<h:outputLabel value="View" for="studentviewpic"
										style="cursor: pointer; padding: 2px 10px; color: #000000; text-decoration: underline;" />
									<f:setPropertyActionListener value="#{false}"
										target="#{advisingManagementController.myCalendarMode}" />
									<f:setPropertyActionListener
										target="#{advisingManagementController.apptReason}"
										value="#{null}" />
								</a4j:commandLink>
							</rich:panel>
						</rich:toolBarGroup>
						<rich:toolBarGroup>
							<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel">
								<rich:toolTip followMouse="true" direction="top-right"
									showDelay="500">
									<span style="white-space: nowrap"> Update information
									for the selected advising appointment</span>
								</rich:toolTip>
								<a4j:commandLink reRender="mySchedulerEditPanel"
									ajaxSingle="true" process="student_datatable"
									action="#{advisingManagementController.takeSelection}"
									oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('mySchedulerEditPanel')}.show();">
									<h:graphicImage id="studenteditpic" value="/images/edit.gif"
										style="border:0" styleClass="pic" alt="" />
									<h:outputLabel value="Edit" for="studenteditpic"
										style="cursor: pointer; padding: 2px 10px; color: #000000; text-decoration: underline;" />
									<f:setPropertyActionListener value="#{false}"
										target="#{advisingManagementController.myCalendarMode}" />
									<f:setPropertyActionListener value="#{null}"
										target="#{advisingManagementController.apptReason}" />										
								</a4j:commandLink>
							</rich:panel>
						</rich:toolBarGroup>
						<rich:toolBarGroup>
							<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel">
								<rich:toolTip followMouse="true" direction="top-right"
									showDelay="500">
									<span style="white-space: nowrap"> Cancel the selected
									advising appointment</span>
								</rich:toolTip>
								<a4j:commandLink reRender="mySchedulerCancelPanel"
									ajaxSingle="true" process="student_datatable"
									action="#{advisingManagementController.takeSelection}"
									oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('mySchedulerCancelPanel')}.show();">
									<h:graphicImage id="studentcancelpic"
										value="/images/icons/delete.png" style="border:0"
										styleClass="pic" alt="" />
									<h:outputLabel value="Cancel" for="studentcancelpic"
										style="cursor: pointer; padding: 2px 10px; color: #000000; text-decoration: underline;" />
									<f:setPropertyActionListener value="#{false}"
										target="#{advisingManagementController.myCalendarMode}" />
									<f:setPropertyActionListener value="#{null}"
										target="#{advisingManagementController.apptReason}" />										 
								</a4j:commandLink>
							</rich:panel>
						</rich:toolBarGroup>
						<rich:toolBarGroup location="right" itemSeparator="line">
							<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel">
								<rich:toggleControl id="hide_appt_list" value="#{'Hide'}"
									switchToState="hide">
								</rich:toggleControl>
								<rich:toolTip followMouse="true" direction="top-right"
									showDelay="500" value="Hide my recent
								appointments" />
							</rich:panel>
							<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel">
								<rich:toolTip followMouse="true" direction="top-right"
									showDelay="500"
									value="To
					view, edit or cancel an existing appointment, select the
					appointment and click on the desired function">
								</rich:toolTip>
								<h:graphicImage url="/images/info.png" alt="i" title="Info" />
							</rich:panel>
						</rich:toolBarGroup>
					</rich:toolBar>
					<h:panelGroup id="student_table">
						<a4j:region immediate="true">
							<rich:extendedDataTable style="margin: 1px auto"
								value="#{advisingManagementController.userAdvisingSessionDataModel}"
								var="advisingsession" id="student_datatable" width="80%"
								height="300px" sortMode="single" selectionMode="single"
								tableState="#{advisingManagementController.tableState}"
								selection="#{advisingManagementController.selection}"
								rowClasses="odd-row, even-row"
								onRowMouseOver="this.style.backgroundColor='#B3C9E0'"
								onRowMouseOut="this.style.backgroundColor='#{rowKeyVar}'"
								selectedClass="selectedRow">
								<rich:column width="190px" label="Appointment Time" id="col_1">
									<f:facet name="header">
										<h:outputText styleClass="studentDataHeader"
											value="Appointment Time" id="session_time" />
									</f:facet>
									<h:outputText value="#{advisingsession.sessionTime}"
										id="advisingsession_sessiontime" />
								</rich:column>
								<rich:column id="col_2" width="190px" label="Advisor">
									<f:facet name="header">
										<h:outputText styleClass="studentDataHeader" value="Advisor"
											id="advisor" />
									</f:facet>
									<h:outputText value="#{advisingsession.advisor.shortDesc}"
										id="advisingsession_advisor" />
								</rich:column>
								<rich:column id="col_3" width="150px" label="Appointment Type">
									<f:facet name="header">
										<h:outputText styleClass="studentDataHeader"
											value="Appointment Type" id="session_type" />
									</f:facet>
									<h:outputText value="#{advisingsession.sessionType}"
										id="advisingsession_sessiontype" />
								</rich:column>
								<rich:column id="col_4" width="190px" label="Appointment Status">
									<f:facet name="header">
										<h:outputText styleClass="studentDataHeader"
											value="Appointment Status" id="session_status" />
									</f:facet>
									<h:outputText value="#{advisingsession.sessionStatus}"
										id="advisingsession_sessionstatus" />
								</rich:column>
								<rich:column id="col_8" label="Last Edit" width="145px">
									<f:facet name="header">
										<h:outputText styleClass="studentDataHeader" value="Last Edit"
											id="last_edit" />
									</f:facet>
									<h:outputText value="#{advisingsession.lastEdit}"
										id="advisingsession_lastedit" />
								</rich:column>
								<a4j:support event="onRowDblClick"
									reRender="mySchedulerEditPanel"
									action="#{advisingManagementController.takeSelection}"
									oncomplete="Richfaces.showModalPanel('mySchedulerEditPanel')">
									<f:setPropertyActionListener
										target="#{advisingManagementController.apptReason}"
										value="#{null}" />
								</a4j:support>
							</rich:extendedDataTable>
						</a4j:region>
					</h:panelGroup>
				</h:panelGrid>
			</f:facet>
		</rich:togglePanel>
	</h:form>
</f:subview>
<f:subview id="student-schedule-advisingsession">
	<h:form>
		<rich:panel style="width:80%;margin:10px auto;">
			<f:facet name="header">
				<h:outputText value="Appointment Scheduler" />
			</f:facet>
			<h:panelGrid width="100%" style="align:right;text-align:right;">
				<h:panelGroup>
					<rich:toggleControl for="student_appt_list" switchToState="show">
						<a4j:commandButton styleClass="buttonClass" id="show_appt_list"
							value="#{'My Recent Appointments'}" ajaxSingle="true"
							reRender="student_datatable" />
					</rich:toggleControl>
					<rich:toolTip for="show_appt_list"
						value="Show all my recent appointments" followMouse="true"
						showDelay="500"></rich:toolTip>&nbsp;&nbsp;
				</h:panelGroup>
			</h:panelGrid>
			<rich:togglePanel id="student_schedule_info" switchType="client"
				stateOrder="showInfo,hideInfo">
				<f:facet name="hideInfo">
					<h:panelGrid style="padding-right: 10px; padding-left: 10px">
						<h:panelGroup>
							<h:outputText value="Instructions" styleClass="instructionText"></h:outputText>
							&nbsp;&nbsp;<rich:toggleControl id="show_info"
								value="#{'(Show)'}" switchToState="showInfo">
							</rich:toggleControl>
							<rich:toolTip for="show_info" value="Show Instructions"
								followMouse="true" showDelay="500"></rich:toolTip>
						</h:panelGroup>
					</h:panelGrid>
				</f:facet>
				<f:facet name="showInfo">
					<h:panelGroup>
						<h:panelGrid style="padding-right: 10px; padding-left: 10px">
							<h:panelGroup>
								<h:outputText value="Instructions" styleClass="instructionText"></h:outputText>
							&nbsp;&nbsp;<rich:toggleControl id="hide_info"
									value="#{'(Hide)'}" switchToState="hideInfo">
								</rich:toggleControl>
								<rich:toolTip for="hide_info" value="Hide Instructions"
									followMouse="true" showDelay="500"></rich:toolTip>
							</h:panelGroup>
							<ul>
								<li><font size="2">To schedule an advising
								appointment, follow the steps listed below:</font>
								<ol>
									<li><font size="2">Select your advisor from the
									drop down menu</font></li>
									<li><font size="2">Select an available time slot</font></li>
									<li><font size="2">Indicate appointment type</font></li>
									<li><font size="2">Insert additional comments in
									the available space, if necessary</font></li>
									<li><font size="2">Click "Schedule"</font></li>
								</ol>
								</li>
								<li><font size="2"><b>You will receive a
								confirmation message by email. Be sure to print or write down
								the date, time and location.</b></font></li>
								<li><font size="2">If you need to speak with a
								College of Education advisor, please call the Academic Services
								Office at <b>(859) 257-7971</b>.</font></li>
								<li><font size="2">If you had any problem in
								scheduling an appointment, please call the above number. Make
								sure you have all the relevant information about the problem
								while calling us. If possible, please take a screen shot of the
								error page.</font></li>
								<li><font size="2">To view your list of advising
								appointments, select <b>My Recent Appointments</b> button at the
								top-right corner.</font></li>
							</ul>
						</h:panelGrid>
					</h:panelGroup>
				</f:facet>
			</rich:togglePanel>
			<rich:spacer height="25px"></rich:spacer>
			<rich:panel bodyClass="rich-laguna-panel-no-header"
				style="width:50%;margin: 40px auto;">
				<a4j:include viewId="schedule-advisingsession.jsp"/>
				<h:panelGrid columns="2" width="100%" style="align:center;margin:10px;">
					<a4j:commandButton id="student_schedule_button" value="Schedule"
						style="display: block; margin: auto;"
						reRender="student_datatable,student_schedule_advisor_list,student_schedule_advising_session_list,student_schedule_session_type_id,student_comment_section"
						action="#{advisingManagementController.createAdvisingSession}" />
					<a4j:commandButton id="student_reset_button" value="Clear"
						style="display: block; margin: auto;" ajaxSingle="true"
						reRender="student_schedule_advisor_list,student_schedule_advising_session_list,student_schedule_session_type_id,student_comment_section">
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
					</a4j:commandButton>
				</h:panelGrid>
			</rich:panel>
		</rich:panel>
	</h:form>
	<rich:modalPanel id="advisorInfoPanel" width="350" autosized="true">
		<f:facet name="header">
			<h:outputText value="Advisor Information" />
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="/images/icons/cancel.png"
					id="advisorInfolink" styleClass="hidelink" alt="X" />
				<rich:componentControl for="advisorInfoPanel"
					attachTo="advisorInfolink" operation="hide" event="onclick" />
			</h:panelGroup>
		</f:facet>
		For information on determining who your advisor is, please visit the Academic Service and Teacher Certification website: 
		<a href="http://education.uky.edu/AcadServ/content/academic-advising">http://education.uky.edu/AcadServ/content/academic-advising</a>.
	</rich:modalPanel>

	<rich:modalPanel id="sessionTypeInfoPanel" width="350" autosized="true">
		<f:facet name="header">
			<h:outputText value="Appointment Type Information" />
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="/images/icons/cancel.png"
					id="sessionTypeInfolink" styleClass="hidelink" alt="X" />
				<rich:componentControl for="sessionTypeInfoPanel"
					attachTo="sessionTypeInfolink" operation="hide" event="onclick" />
			</h:panelGroup>
		</f:facet>
		<h:outputText
			value="Information about the different session types goes here."></h:outputText>
	</rich:modalPanel>
</f:subview>
