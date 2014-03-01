<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:subview id="view-tep" >
	<h:form id="tepAdmission_area">
			
		<h:outputLabel for="tepAdmissionLine" value="TEP Admission "  styleClass="medium-bold"/>	
		<h:outputLabel for="tepAdmissionLine" value="  User: #{tepController.selectedUser.fullName }"  styleClass="tiny"/>		
		<rich:separator id="tepAdmissionLine" lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>
	
		<h:panelGroup id="tepAdmission_list" layout="block" style="padding-bottom:10px">			
			<rich:extendedDataTable id="tepAdmission_table" 				
			styleClass="basicTable" selectedClass="selectedRow"
			rowClasses="oddRow,evenRow"	
			width="100%" height="200px"
			onRowMouseOver="this.style.backgroundColor='#B3C9E0'"				
			onRowMouseOut="this.style.backgroundColor='#{rowKeyVar}'"
			var="tepAdmission" 
			binding="#{tepController.tepAdmissionTable}"				
			value="#{tepController.tepAdmissionList}"				
			noDataLabel="No TEP Admission Records Found.">				
				<a4j:support event="onRowClick" reRender="admissionMemo_area"
					action="#{tepController.takeTepAdmissionSelection}">
				</a4j:support>
				<rich:column id="tepId_Col" width="5%">
					<f:facet name="header">
						<h:outputText value="ID" />
					</f:facet>
					<h:outputText value="#{tepAdmission.id}"/>
				</rich:column>
				<rich:column id="term_Col" width="10%">
					<f:facet name="header">
						<h:outputText value="Term" />
					</f:facet>
					<h:outputText value="#{tepAdmission.cohortTermShortDesc}"/>
				</rich:column>
				<rich:column id="admissionDate_Col" width="15%">
					<f:facet name="header">
						<h:outputText value="Admission Date" />
					</f:facet>
					<h:outputText value="#{tepAdmission.tepAdmissionDateString}"/>
				</rich:column>
				<rich:column id="programCode_Col" width="10%">
					<f:facet name="header">
						<h:outputText value="Program" />
					</f:facet>
					<h:outputText value="#{tepAdmission.programProfileCodeString}"/>
				</rich:column>			
				<rich:column id="tepAdmissionStatus_Col" width="15%">
					<f:facet name="header">
						<h:outputText value="Admission Status" />
					</f:facet>
					<h:outputText value="#{tepAdmission.tepAdmissionCode}"/>
				</rich:column>	
				<rich:column id="applicationLevel_Col" width="15%">
					<f:facet name="header">
						<h:outputText value="Application Level" />
					</f:facet>
					<h:outputText value="#{tepAdmission.applicationLevel}"/>
				</rich:column>	
				<rich:column id="overallGPA_Col" width="10%">
					<f:facet name="header">
						<h:outputText value="GPA" />
					</f:facet>
					<h:outputText value="#{tepAdmission.overallGPA}"/>
				</rich:column>	
				<rich:column id="totalHours_Col" width="10%">
					<f:facet name="header">
						<h:outputText value="Total Hours" />
					</f:facet>
					<h:outputText value="#{tepAdmission.totalHours}"/>
				</rich:column>	
				<rich:column id="primary_Col" width="10%">
					<f:facet name="header">
						<h:outputText value="Primary" />
					</f:facet>
					<h:outputText value="#{tepAdmission.primaryString}"/>
				</rich:column>
			</rich:extendedDataTable>
			<h:panelGrid id="admissionMemo_area" columns="2" cellpadding="2" width="70%">			
				<h:outputLabel for="admissionMemo" styleClass="small" value="Selected TEP Admission Memo:"/>
				<h:inputTextarea id="admissionMemo" 
				value="#{tepController.selectedTepAdmission.admissionMemo}"
				rows="4" cols="50" disabled="true"/>	
			</h:panelGrid>		
		</h:panelGroup>
	</h:form>
	<h:outputLabel for="tepApplicationLine" value="TEP Application "  styleClass="medium-bold"/>		
	<rich:separator id="tepApplicationLine" lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>
	<h:form id="tepApplication_area">
		<h:panelGroup id="tepApplication_list">				
			<rich:extendedDataTable id="tepApplication_table"			
			styleClass="basicTable" selectedClass="selectedRow"					
			rowClasses="oddRow,evenRow" 				
			width="100%" height="200px" 	
			onRowMouseOver="this.style.backgroundColor='#B3C9E0'"				
			onRowMouseOut="this.style.backgroundColor='#{rowKeyVar}'"	
			enableContextMenu="false" var="tepApplication"		
			binding="#{tepController.tepApplicationTable}"
			value="#{tepController.tepApplicationList}"
			noDataLabel="No TEP Application Records Found.">
				<a4j:support event="onRowClick" reRender="applicationMemo_area"
					action="#{tepController.takeTepApplicationSelection}">
				</a4j:support>	
				<rich:column id="tepId_Col" width="5%">
					<f:facet name="header">
						<h:outputText value="ID" />
					</f:facet>
					<h:outputText value="#{tepApplication.id}"/>
				</rich:column>
				<rich:column id="applicationDate_Col" width="10%">
					<f:facet name="header">
						<h:outputText value="Application Date" />
					</f:facet>
					<h:outputText value="#{tepApplication.applicationDateString}"/>
				</rich:column>
				<rich:column id="facultyRecommendationDate_Col" width="18%">
					<f:facet name="header">
						<h:outputText value="Faculty Recommendation Date" />
					</f:facet>
					<h:outputText value="#{tepApplication.facultyRecommendationDateString}"/>
				</rich:column>
				<rich:column id="followUpDate_Col" width="10%">
					<f:facet name="header">
						<h:outputText value="Follow Up Date" />
					</f:facet>
					<h:outputText value="#{tepApplication.followUpDateString}"/>
				</rich:column>
				<rich:column id="changeStatusDate_Col" width="12%">
					<f:facet name="header">
						<h:outputText value="Change Status Date" />
					</f:facet>
					<h:outputText value="#{tepApplication.changeStatusDateString}"/>
				</rich:column>			
				<rich:column id="programProfile_Col" width="10%">
					<f:facet name="header">
						<h:outputText value="Program Profile" />
					</f:facet>
					<h:outputText value="#{tepApplication.programProfile.userprogramprofileid}"/>
				</rich:column>	
				<rich:column id="cohortTerm_Col" width="10%">
					<f:facet name="header">
						<h:outputText value="Cohort Term" />
					</f:facet>
					<h:outputText value="#{tepApplication.cohortTerm.shortDesc}"/>
				</rich:column>	
				<rich:column id="applicationStatus_Col" width="10%">
					<f:facet name="header">
						<h:outputText value="Application Status" />
					</f:facet>
					<h:outputText value="#{tepApplication.applicationStatus.applicationStatusCode}"/>
				</rich:column>	
				<rich:column id="facultyRecommendation_Col" width="15%">
					<f:facet name="header">
						<h:outputText value="Faculty Recommendation" />
					</f:facet>
					<h:outputText value="#{tepApplication.facultyRecommendation.applicationStatusCode}"/>
				</rich:column>	
			</rich:extendedDataTable>	
			<h:panelGrid id="applicationMemo_area"  columns="2" cellpadding="2" width="75%">	
				<h:outputLabel for="processMemo" styleClass="small" value="Selected Tep Application Process Memo:"/>	
				<h:inputTextarea id="processMemo" 
				value="#{tepController.selectedTepApplication.processMemo}"
				rows="4" cols="50" disabled="true"/>
				<h:outputLabel for="facultyMemo" styleClass="small" value="Selected Tep Application Faculty Memo:"/>
				<h:inputTextarea id="facultyMemo" 
				value="#{tepController.selectedTepApplication.facultyMemo}"
				rows="4" cols="50" disabled="true"/>
				<h:outputLabel for="studentMemo" styleClass="small" value="Selected Tep Application Student Memo:"/>
				<h:inputTextarea id="studentMemo" 
				value="#{tepController.selectedTepApplication.studentMemo}"
				rows="4" cols="50" disabled="true"/>
			</h:panelGrid>
		</h:panelGroup>
	</h:form>
</f:subview>