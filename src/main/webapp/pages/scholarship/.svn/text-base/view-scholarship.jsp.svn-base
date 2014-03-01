<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:subview id="view-tep" >
	<h:form id="tepAdmission_area">
			
		<h:outputLabel for="scholarshipLine" value="Scholarship Application " styleClass="medium-bold"/>	
		<h:outputLabel for="scholarshipLine" value="  User: #{scholarshipController.selectedUser.fullName }" styleClass="tiny"/>		
		<rich:separator id="scholarshipLine" lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>
	
		<h:panelGroup id="scholarship_list" layout="block" style="padding-bottom:10px">			
			<rich:extendedDataTable id="scholarship_table"
			styleClass="basicTable" selectedClass="selectedRow"
			rowClasses="oddRow,evenRow"
			width="100%" height="200px"
			onRowMouseOver="this.style.backgroundColor='#B3C9E0'"	
			onRowMouseOut="this.style.backgroundColor='#{rowKeyVar}'"
			var="scholarship"
			binding="#{scholarshipController.scholarshipTable}"
			value="#{scholarshipController.studentScholarshipList}"
			noDataLabel="No Scholarship Records Found.">
					
				<a4j:support event="onRowClick" reRender=" "
				action="#{scholarshipController.takeTepAdmissionSelection}">
				</a4j:support>
				
				
				
				<rich:column id="scholarshipId_Col" width="5%">
					<f:facet name="header">
						<h:outputText value="ID" />
					</f:facet>
					<h:outputText value="#{scholarship.id}"/>
				</rich:column>
				
				
				
			</rich:extendedDataTable>
			
			
		</h:panelGroup>
	</h:form>
</f:subview>