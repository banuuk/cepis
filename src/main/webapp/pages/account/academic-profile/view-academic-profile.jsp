<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:subview id="view-academic-profile">
	<h:form id="form">
		<h:panelGrid id="courseList" columns="2" columnClasses="col1,col2"
			width="100%" style="align:center;">
			<rich:extendedDataTable
				binding="#{accountManagementController.dataTable}" id="coursesTable"
				value="#{accountManagementController.coursesDataModel}" var="course"
				height="200px" groupingColumn="col_2"
				noDataLabel="No Course Information Available. If you think this is an error, please check the UK ID in the General Section. "
				sortMode="single" selectionMode="single" reRender="coursesTable"
				tableState="#{accountManagementController.tableState}"
				selection="#{accountManagementController.selection}">
				<rich:column sortable="true" sortBy="#{course.term}" id="col_2"
					filterBy="#{course.term}" width="100px" label="Term"
					sortOrder="DESCENDING">
					<f:facet name="header">
						<h:outputText value="Term" id="term_code" />
					</f:facet>
					<h:outputText value="#{course.term}" id="course_term" />
				</rich:column>
				<rich:column id="col_3" width="100px" label="Course ID">
					<f:facet name="header">
						<h:outputText value="Course ID" id="course_id" />
					</f:facet>
					<h:outputText value="#{course.no}" id="course_no" />
				</rich:column>
				<rich:column id="col_4" width="100px" label="Grade">
					<f:facet name="header">
						<h:outputText value="Grade" id="grade" />
					</f:facet>
					<h:outputText value="#{course.gpa}" id="course_gpa" />
				</rich:column>
				<a4j:support reRender="selectiontable" limitToList="true"
					id="extended_table_bean_take_selection"
					action="#{accountManagementController.takeSelection}"
					event="onselectionchange" />
			</rich:extendedDataTable>
			<h:panelGroup layout="block">
				<rich:panel>
					<f:facet name="header">
						<h:outputText value="Currently selected course:" />
					</f:facet>
					<rich:dataTable
						value="#{accountManagementController.selectedCourses}" var="sel"
						id="selectiontable">
						<rich:column>
							<h:panelGrid columns="2">
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Course: " /></font>
									<br />
								</h:panelGroup>
								<h:outputText value="#{sel.no}" />
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Term: " /></font>
									<br />
								</h:panelGroup>
								<h:outputText value="#{sel.term}" />
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Title: " /></font>
									<br />
								</h:panelGroup>
								<h:outputText value="#{sel.title}" />
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Grade: " /></font>
									<br />
								</h:panelGroup>
								<h:outputText value="#{sel.gpa}" />
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="# Hours: " /></font>
									<br />
								</h:panelGroup>
								<h:outputText value="#{sel.gpaHours}" />
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="# Credits: " /></font>
									<br />
								</h:panelGroup>
								<h:outputText value="#{sel.gpaPoints}" />
							</h:panelGrid>
						</rich:column>
					</rich:dataTable>
				</rich:panel>
			</h:panelGroup>
		</h:panelGrid>
	</h:form>
</f:subview>