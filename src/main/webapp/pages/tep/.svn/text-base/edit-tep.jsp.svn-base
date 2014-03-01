<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:subview id="edit-tep" >
	<h:form id="tepAdmission_area" styleClass="styleish">
		<h:outputText value="TEP Admission"  style="font-family: Arial, Helvetica, sans-serif;
		font-size: 16px; color: navy; font-weight:bold;"/>
		<rich:separator lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>
		<h:panelGrid columns="2" cellpadding="2" width="100%">
			<h:panelGroup id="tepAdmission" layout="block">
				<h:panelGrid columns="2" cellpadding="2" width="100%">
					<h:outputLabel for="tepAdmissionId" styleClass="small" value="TEP Admission ID :"/>
					<h:selectOneListbox id="tepAdmissionId" size="1" styleClass="smallInput"
					converter="#{TepAdmissionDataConverter}" 
					value="#{tepController.selectedTepAdmission}" 
					required="true" requiredMessage="TEP Admission ID: Value is required.">							
						<f:selectItem itemLabel="-- Select One --" itemValue="" />						
						<f:selectItems value="#{tepController.tepAdmissionList}" var="tepAdmission"
						itemLabel="TEP Admission ID: #{tepAdmission.id}" itemValue="#{tepAdmission}" />	
						<a4j:support event="onchange" reRender="tepAdmission_area"
						ajaxSingle="true" limitToList="true"
						actionListener="#{tepController.prepTepAdmissionEdit}"/>						
					</h:selectOneListbox>	
					<h:outputLabel for="admissionDate" styleClass="small" value="Admission Date : " />
					<rich:calendar id="admissionDate" value="#{tepController.admissionDate}"
					cellWidth="24px" datePattern="MMM d,yyyy" enableManualInput="true"
					cellHeight="22px" style="width:200px"/>				
					<h:outputLabel for="overallGPA" styleClass="small" value="Overall GPA : *" />
					<h:inputText id="overallGPA" value="#{tepController.overallGpa}"
					required="true" requiredMessage="Overall GPA: Value Is Required."/>				
					<h:outputLabel for="totalHours" styleClass="small" value="Total Hours : *" />
					<h:inputText id="totalHours" value="#{tepController.totalHours}"
					required="true" requiredMessage="Total Hours: Value Is Required."/>			
					<h:outputLabel for="reportYear" styleClass="small" value="Report Year Code : *" />																
					<h:selectOneMenu id="reportYear" styleClass="smallInput"
					value="#{tepController.selectedReportYear}"
					converter="#{ReportYearDataConverter}"	
					required="true" requiredMessage="Report Year Code: Value is required.">
						<f:selectItem itemValue="" itemLabel="-- Select --" />
						<f:selectItems var="reportYear"
						value="#{tepController.reportYearList}"
						itemValue="#{reportYear}"
						itemLabel="#{reportYear.reportYearCode}  |  #{reportYear.description}" />
					</h:selectOneMenu>					
					<h:outputLabel for="cohortTerm" styleClass="small" value="Term / Cohort : *" />
					<h:selectOneMenu id="cohortTerm" styleClass="smallInput"
					value="#{tepController.selectedCohortTerm}"
					converter="#{UKTermDataConverter}"	
					required="true" requiredMessage="Cohort / Term: Value is required.">
						<f:selectItem itemValue="" itemLabel="-- Select --" />
						<f:selectItems var="cohortTerm"
						value="#{cepisGlobalComponentConfigurator.ukTermList}"
						itemValue="#{cohortTerm}"
						itemLabel="#{cohortTerm.ukTermCode}  |  #{cohortTerm.shortDesc}" />
					</h:selectOneMenu>
					<h:outputLabel for="applicationLevel" styleClass="small" value="Application Level : *" />
					<h:selectOneMenu id="applicationLevel" styleClass="smallInput"
					value="#{tepController.selectedApplicationLevel}" 
					required="true" requiredMessage="Application Level: Value is required."  >							
						<f:selectItem itemValue="" itemLabel="-- Select --" />
						<f:selectItem itemValue="Graduate" itemLabel="Graduate" />
						<f:selectItem itemValue="Undergraduate" itemLabel="Undergraduate" />
						<f:selectItem itemValue="Certification Only" itemLabel="Certification Only" />
					</h:selectOneMenu>					
					<h:outputLabel for="admissionStatus" styleClass="small" value="Admission Status : *" />
					<h:selectOneMenu id="admissionStatus" styleClass="smallInput"
					value="#{tepController.selectedAdmissionStatus}">
						<f:selectItem itemValue="" itemLabel="-- Select --" />
						<f:selectItem itemValue="APPLY" itemLabel="Applied | Applied for TEP" />
						<f:selectItem itemValue="ADMIT" itemLabel="Admit | Admitted into TEP" />
						<f:selectItem itemValue="DENIED" itemLabel="Denied | Denied admission into TEP" />
						<f:selectItem itemValue="WDRWN" itemLabel="Withdrawn | Application Withdrawn" />	
					</h:selectOneMenu>
					<h:outputLabel for="portfolioReview" styleClass="small" value="Portfolio Review : " />
					<h:selectOneMenu id="portfolioReview" styleClass="smallInput"
					value="#{tepController.portfolioReview}">
						<f:selectItem itemValue="" itemLabel="-- Select --" />
						<f:selectItem itemValue="COMPLETE" itemLabel="Complete" />	
					</h:selectOneMenu>						
					<h:outputLabel for="primary" styleClass="small" value="Primary : *" />
					<h:selectOneMenu id="primary" styleClass="smallInput"
					value="#{tepController.primary}"
					required="true"	requiredMessage="Primary : Value is required.">
						<f:selectItem itemValue="" itemLabel="-- Select --" />
						<f:selectItem itemValue="No" itemLabel="No" />
						<f:selectItem itemValue="Yes" itemLabel="Yes" />	
					</h:selectOneMenu>						
					<h:outputLabel for="admissionMemo" styleClass="small" value="Admission Memo : " />
					<h:inputTextarea id="admissionMemo" value="#{tepController.tepAdmissionMemo}"/>				
				</h:panelGrid>
			</h:panelGroup>	
			<h:panelGroup id="programProfile" layout="block">				
				<h:panelGrid columns="2" cellpadding="2" width="100%" styleClass="highlightClass">
					<h:outputLabel for="programUidCode" styleClass="small" value="Program UID Code :"/>
					<h:outputText id="programUidCode" value="#{tepController.userprogramprofileid}"/>
					<h:outputLabel for="programGroup" styleClass="small" value="Program Group :"/>
					<h:selectOneListbox immediate="true" id="programGroup"
					style="width:200px"
					value="#{tepController.selectedProgramGroup}"
					onchange="sumbit()" size="1"
					converter="#{ProgramGroupDataConverter}" required="true"
					requiredMessage="Program Group: Value is required.">
						<f:selectItem itemLabel="-- Select --" itemValue="" />
						<f:selectItems var="programGroup"
						value="#{cepisGlobalComponentConfigurator.programGroupList}"
						itemLabel="#{programGroup.programGroupCode} - #{programGroup.description} (#{programGroup.status})" />
						<f:validator validatorId="ProgramGroupDataValidator" />
					</h:selectOneListbox>
					<h:outputLabel for="programTrack" styleClass="small" value="Program Track :"/>
					<h:selectOneListbox immediate="true" id="programTrack"
					style="width:200px"
					value="#{tepController.selectedProgramTrack}"
					onchange="sumbit()" size="1"
					converter="#{ProgramTrackDataConverter}" required="true"
					requiredMessage="Program Track: Value is required.">
						<f:selectItem itemLabel="-- Select --" itemValue="" />
						<f:selectItems var="programTrack"
						value="#{cepisGlobalComponentConfigurator.programTrackList}"
						itemLabel="#{programTrack.programTrackCode} - #{programTrack.description} (#{programTrack.status})" />
						<f:validator validatorId="ProgramTrackDataValidator" />
					</h:selectOneListbox>						
					<h:outputLabel for="advisor" styleClass="small" value="Advisor :"/>
					<h:selectOneListbox immediate="true" id="advisor"
					style="width:200px" onchange="sumbit()"
					value="#{tepController.selectedAdvisor}" size="1"
					converter="#{AdvisorDataConverter}">
						<f:selectItem itemLabel="-- Select --" itemValue="" />
						<f:selectItems var="advisor"
						value="#{cepisGlobalComponentConfigurator.advisorList}"
						itemLabel="#{advisor.shortDesc}" />
						<f:validator validatorId="AdvisorDataValidator" />
					</h:selectOneListbox>
					<h:outputLabel for="ukAnticipatedCompleteTerm" styleClass="small" value="Anticipated Completion Term :"/>
					<h:selectOneListbox id="ukAnticipatedCompleteTerm" style="width:200px"
					value="#{tepController.selectedUkAnticipatedCompleteTerm}"
					size="1" converter="#{UKTermDataConverter}" required="true"
					requiredMessage="Anticipated Complete Term: Value is required.">
						<f:selectItem itemLabel="-- Select --" itemValue="NA" />
						<f:selectItems var="ukTerm"
						value="#{cepisGlobalComponentConfigurator.ukTermList}" 
						itemLabel="#{ukTerm.shortDesc}" />
						<f:validator validatorId="UKTermDataValidator" />
					</h:selectOneListbox>
				</h:panelGrid>
			</h:panelGroup>
			<h:commandButton id="updateAdmissionAndProgramProfile" 
			value="Update Admission & Program Profile"
			styleClass="buttonStyle"
			action="#{tepController.updateTepAdmission}"/>						
		</h:panelGrid>
	</h:form>
	<h:outputText value="TEP Application"  style="font-family: Arial, Helvetica, sans-serif;
	font-size: 16px; color: navy; font-weight:bold;"/>
	<rich:separator lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>
	<h:form id="tepApplication_area" styleClass="styleish">
		<h:panelGrid columns="2" cellpadding="5" width="100%">		
			<h:panelGroup id="tepApplication_col_1" layout="block">
				<h:panelGrid columns="2" cellpadding="5" width="100%">
					<h:outputLabel for="tepApplicationId" styleClass="small" value="TEP Application ID :"/>
					<h:selectOneListbox id="tepApplicationId" size="1"
					converter="#{TepApplicationDataConverter}" styleClass="mediumInput"
					value="#{tepController.selectedTepApplication}" 
					required="true" requiredMessage="TEP Application ID: Value is required.">					
						<f:selectItem itemLabel="-- Select One --" itemValue="" />
						<f:selectItems value="#{tepController.tepApplicationList}" var="tepApplication"
						itemValue = "#{tepApplication}" itemLabel="TEP Application ID: #{tepApplication.id}" />
						<a4j:support event="onchange" reRender="tepApplication_area"
						ajaxSingle="true" limitToList="true"
						actionListener="#{tepController.prepTepApplicationEdit}"/>
					</h:selectOneListbox>
					<h:outputLabel for="applicationDate" styleClass="small" value="Application Date : *" />
					<rich:calendar id="applicationDate" value="#{tepController.applicationDate}"
					cellWidth="24px" datePattern="MMM d,yyyy" enableManualInput="true"
					cellHeight="22px" style="width:200px" required="true" 
					requiredMessage="Application Date: Value is required."/>					
					<h:outputLabel for="facultyRecommendation" styleClass="small" value="Faculty Recommendation : *" />
					<h:selectOneMenu id="facultyRecommendation" styleClass="mediumInput"
					value="#{tepController.selectedFacultyRecommendationCode}"
					converter="#{ApplicationStatusDataConverter}"	
					required="true" requiredMessage="Faculty Recommendation: Value is required.">
						<f:selectItem itemValue="" itemLabel="-- Select --" />
						<f:selectItems var="facultyRecommendationCode"
						value="#{tepController.applicationStatusList}"
						itemValue="#{facultyRecommendationCode}"
						itemLabel="#{facultyRecommendationCode.applicationStatusCode} | 
						#{facultyRecommendationCode.applicationStatusDescription}" />
					</h:selectOneMenu>
					<h:outputLabel for="facultyRecommendationDate" styleClass="small" value="Faculty Recommendation Date: " />
					<rich:calendar id="facultyRecommendationDate" value="#{tepController.facultyRecommendationDate}"
					cellWidth="24px" datePattern="MMM d,yyyy" enableManualInput="true"
					cellHeight="22px" style="width:200px">
					</rich:calendar>	
					<h:outputLabel for="applicationStatus" styleClass="small" value="Application Status : *" />
					<h:selectOneMenu id="applicationStatus" styleClass="mediumInput"
					value="#{tepController.selectedApplicationStatus}"
					converter="#{ApplicationStatusDataConverter}"	
					required="true" requiredMessage="Application Status: Value is required.">
						<f:selectItem itemValue="" itemLabel="-- Select --" />
						<f:selectItems var="applicationStatus"
						value="#{tepController.applicationStatusList}"
						itemValue="#{applicationStatus}"
						itemLabel="#{applicationStatus.applicationStatusCode} | 
						#{applicationStatus.applicationStatusDescription}" />
					</h:selectOneMenu>
					<h:outputLabel for="followUpDate" styleClass="small" value="Follow Up Date : " />
					<rich:calendar id="followUpDate" value="#{tepController.followUpDate}"
					cellWidth="24px" datePattern="MMM d,yyyy" enableManualInput="true"
					cellHeight="22px" style="width:200px">
					</rich:calendar>
					<h:outputLabel for="changeStatusDate" styleClass="small" value="Change Status Date : " />
					<rich:calendar id="changeStatusDate" value="#{tepController.changeStatusDate}"
					cellWidth="24px" datePattern="MMM d,yyyy" enableManualInput="true"
					cellHeight="22px" style="width:200px">
					</rich:calendar>
				</h:panelGrid>
			</h:panelGroup>
			<h:panelGroup id="tepApplication_col_2" layout="block">
				<h:panelGrid columns="2" cellpadding="5" width="100%">	
					<h:outputLabel for="processMemo" styleClass="small" value="Process Memo : " />
					<h:inputTextarea id="processMemo" value="#{tepController.processMemo}" cols="50" rows="3"/>
					<h:outputLabel for="facultyMemo" styleClass="small" value="Faculty Memo : " />
					<h:inputTextarea id="facultyMemo" value="#{tepController.facultyMemo}" cols="50" rows="3"/>
					<h:outputLabel for="studentMemo" styleClass="small" value="Student Memo : " />
					<h:inputTextarea id="studentMemo" value="#{tepController.studentMemo}" cols="50" rows="3"/>
				</h:panelGrid>
			</h:panelGroup>
			<h:commandButton id="updateApplication" styleClass="buttonStyle" value="Update Application"
			action="#{tepController.updateTepApplication}">
				<a4j:support reRender="tepAdmission_area" limitToList="true" /> 
			</h:commandButton>
		</h:panelGrid>		
	</h:form>
</f:subview>
