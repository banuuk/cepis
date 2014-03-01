<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<link href="${facesContext.externalContext.requestContextPath}/css/appointment.css"
	media="screen" rel="stylesheet" type="text/css" />

<f:subview id="ems-advisingsession-section">
	<h:form>
		<h:panelGrid width="100%">
			<rich:toolBar height="25px" width="95%" itemSeparator="line"
				style="margin: 20px auto 0px auto">
				<rich:toolBarGroup>
					<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel">
						<rich:toolTip followMouse="true" direction="top-right"
							showDelay="500">
							<span style="white-space: nowrap"> View full details of
								the selected advising appointment</span>
						</rich:toolTip>
						<a4j:commandLink reRender="mySchedulerViewPanel" ajaxSingle="true"
							process="ems_appt_datatable"
							action="#{advisingManagementController.takeSelection}"
							oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('mySchedulerViewPanel')}.show();">
							<h:graphicImage id="studentviewpic" value="/images/find.gif"
								style="border:0" styleClass="pic" alt="O" />
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
							<span style="white-space: nowrap"> View/Update information for
								the selected advising appointment</span>
						</rich:toolTip>
						<a4j:commandLink reRender="mySchedulerEditPanel" ajaxSingle="true"
							process="ems_appt_datatable"
							action="#{advisingManagementController.takeSelection}"
							oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('mySchedulerEditPanel')}.show();">
							<h:graphicImage id="studenteditpic" value="/images/edit.gif"
								style="border:0" styleClass="pic" alt="E" />
							<h:outputLabel value="Edit" for="studenteditpic"
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
							<span style="white-space: nowrap"> Cancel the selected
								advising appointment</span>
						</rich:toolTip>
						<a4j:commandLink reRender="mySchedulerCancelPanel"
							ajaxSingle="true" process="ems_appt_datatable"
							action="#{advisingManagementController.takeSelection}"
							oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('mySchedulerCancelPanel')}.show();">
							<h:graphicImage id="studentcancelpic"
								value="/images/icons/delete.png" style="border:0"
								styleClass="pic" alt="X" />
							<h:outputLabel value="Cancel" for="studentcancelpic"
								style="cursor: pointer; padding: 2px 10px; color: #000000; text-decoration: underline;" />
							<f:setPropertyActionListener value="#{false}"
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
								ajaxSingle="true" process="ems_appt_datatable"
								action="#{advisingManagementController.takeSelection}"
								oncomplete="#{rich:component('mySchedulerDeletePanel')}.show();">
								<h:graphicImage id="advisordeletepic"
									value="/images/icons/delete.png" style="border:0"
									styleClass="pic" />
								<h:outputLabel value="Delete" for="advisordeletepic"
									style="cursor: pointer; padding: 2px 10px 2px 2px; color: #000000; text-decoration: underline;" />
								<f:setPropertyActionListener value="#{false}"
									target="#{advisingManagementController.myCalendarMode}" />
							</a4j:commandLink>
						</rich:panel>
					</authz:authorize>
				</rich:toolBarGroup>
				<rich:toolBarGroup location="right" itemSeparator="line">
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
						value="#{advisingManagementController.EMSAdvisingSessionDataModel}"
						var="advisingsession" id="ems_appt_datatable" width="95%"
						height="150px" sortMode="single" selectionMode="single"
						tableState="#{advisingManagementController.tableState}"
						selection="#{advisingManagementController.selection}"
						rowClasses="odd-row, even-row"
						onRowMouseOver="this.style.backgroundColor='#B3C9E0'"
						onRowMouseOut="this.style.backgroundColor='#{rowKeyVar}'"
						selectedClass="selectedRow">
						<rich:column id="col_1" label="Appointment Time" width="19%">
							<f:facet name="header">
								<h:outputText styleClass="studentDataHeader"
									value="Appointment Time" id="session_time" />
							</f:facet>
							<h:outputText value="#{advisingsession.sessionTime}"
								id="advisingsession_sessiontime" />
						</rich:column>
						<rich:column id="col_2" label="Advisor" width="19%">
							<f:facet name="header">
								<h:outputText styleClass="studentDataHeader" value="Advisor"
									id="advisor" />
							</f:facet>
							<h:outputText value="#{advisingsession.advisor.shortDesc}"
								id="advisingsession_advisor" />
						</rich:column>
						<rich:column id="col_3" label="Session Type"  width="19%">
							<f:facet name="header">
								<h:outputText styleClass="studentDataHeader"
									value="Appointment Type" id="session_type" />
							</f:facet>
							<h:outputText value="#{advisingsession.sessionType}"
								id="advisingsession_sessiontype" />
						</rich:column>
						<rich:column id="col_4" label="Appointment Status"  width="19%">
							<f:facet name="header">
								<h:outputText styleClass="studentDataHeader"
									value="Appointment Status" id="session_status" />
							</f:facet>
							<h:outputText value="#{advisingsession.sessionStatus}"
								id="advisingsession_sessionstatus" />
						</rich:column>
						<rich:column id="col_8" label="Last Edit" width="19%">
							<f:facet name="header">
								<h:outputText styleClass="studentDataHeader" value="Last Edit"
									id="last_edit" />
							</f:facet>
							<h:outputText value="#{advisingsession.lastEdit}"
								id="advisingsession_lastedit" />
						</rich:column>
						<a4j:support event="onRowDblClick" reRender="mySchedulerEditPanel"
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
	</h:form>
	<a4j:include viewId="advisingsession-panel.jsp"></a4j:include>
</f:subview>