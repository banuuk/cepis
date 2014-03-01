<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:subview id="report-tep" >
	<h:form id="tepReport_area" styleClass="styleish">
		<h:outputLabel for="reportInfo" value="Create TEP Admission Report  "  styleClass="medium-bold"/>	
		<rich:toolTip for="reportInfo" showEvent="onclick" 
		value="Choose from possible search criteria below to create a report and export it to excel."  />
		<h:graphicImage id="reportInfo" url="/images/person.png" alt="i" styleClass="tooltip"/>
		<rich:separator lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>				
		<h:panelGrid columns="3" cellpadding="2" width="100%">
			<h:panelGroup id="col_1" layout="block">
				<h:panelGrid columns="2" cellpadding="2" width="100%">
					<h:outputLabel for="ukMajor" styleClass="small" value="Major : "/>
					<h:selectOneListbox id="ukMajor" size="1" styleClass="mediumInput"
					converter="#{UKMajorDataConverter}" 
					value="#{tepController.selectedUkMajor}" >							
						<f:selectItem itemLabel="-- Select One --" itemValue="" />						
						<f:selectItems value="#{cepisGlobalComponentConfigurator.ukMajorList}"
						var="ukMajor" itemLabel="#{ukMajor.shortDesc}" itemValue="#{ukMajor}" />										
					</h:selectOneListbox>
					<h:outputLabel for="reportYear" styleClass="small" value="Report Year Code : *" />												
					<h:selectOneMenu id="reportYear" styleClass="mediumInput"
					value="#{tepController.selectedReportYearCode}"
					converter="#{ReportYearDataConverter}" 
					required="true" requiredMessage="Report Year Code: Value is required">
						<f:selectItem itemValue="" itemLabel="-- Select --" />
						<f:selectItems var="reportYear"
						value="#{tepController.reportYearList}"
						itemValue="#{reportYear}"
						itemLabel="#{reportYear.reportYearCode}  |  #{reportYear.description}" />
						<a4j:support event="onchange" ajaxSingle="true"
						limitToList="true"
						actionListener="#{tepController.valueChangeReportYear}"
						reRender="col_2" />
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGroup>
			<h:panelGroup id="col_2" layout="block">
				<h:panelGrid columns="2" cellpadding="2" width="100%">
					<h:outputLabel for="admissionStatus" styleClass="small" value="Admission Status : " />
					<h:selectOneMenu id="admissionStatus" styleClass="mediumInput"
					value="#{tepController.selectedAdmissionStatus}">
						<f:selectItem itemValue="" itemLabel="-- Select --" />
						<f:selectItem itemValue="APPLY" itemLabel="Applied | Applied for TEP" />
						<f:selectItem itemValue="ADMIT" itemLabel="Admit | Admitted into TEP" />
						<f:selectItem itemValue="DENIED" itemLabel="Denied | Denied admission into TEP" />
						<f:selectItem itemValue="WDRWN" itemLabel="Withdrawn | Application Withdrawn" />	
					</h:selectOneMenu>		
					<h:outputLabel for="ukTerm" styleClass="small" rendered="#{tepController.renderReportUKTerm}" value="Term Code : " />												
					<h:selectOneMenu id="ukTerm" styleClass="mediumInput"
					value="#{tepController.selectedReportTerm}" 
					converter="#{UKTermDataConverter}" 
					rendered="#{tepController.renderReportUKTerm}">
						<f:selectItem itemValue="" itemLabel="-- Select --" />
						<f:selectItems var="term"
						value="#{tepController.termList}"
						itemValue="#{term}"
						itemLabel="#{term.ukTermCode}  |  #{term.description}" />
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGroup>
			<h:panelGroup id="col_3" layout="block">
				<h:panelGrid columns="2" cellpadding="2" width="100%">
					<h:outputLabel for="ukStatus" styleClass="small" value="UK Status : " />
					<h:selectOneListbox id="ukStatus" styleClass="mediumInput" size="1"
					converter="#{UKStatusDataConverter}"
					value="#{tepController.selectedUkStatus}">
						<f:selectItem itemValue="" itemLabel="-- Select --" />
						<f:selectItems value="#{cepisGlobalComponentConfigurator.ukStatusList}"
							var="ukStatus" itemLabel="#{ukStatus.shortDesc}" />
						<f:validator validatorId="UKStatusDataValidator" />	
					</h:selectOneListbox>
				</h:panelGrid>
			</h:panelGroup>
			<h:commandButton id="search" styleClass="buttonStyle" value="Search" 
			action="#{tepController.search}">
				<a4j:support event="onchanged" ajaxSingle="true" reRender="tepAdmission_table" />
			</h:commandButton> 		
		</h:panelGrid>	
		<rich:toolBar height="25px" width="100%" itemSeparator="line" style="margin: 20px auto 0px auto">
			<rich:toolBarGroup>
				<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel">
					<rich:toolTip followMouse="true" direction="top-right"
						showDelay="500">
						<span style="white-space: nowrap"> Export Data Table to Excel</span>
					</rich:toolTip>
					<a4j:htmlCommandLink id="exportExcel" 					 
					 action="#{tepController.exportHtmlTableToExcel}">
						<h:graphicImage id="exportExcelPic" value="/images/excel.png"
						style="border:0" styleClass="pic" alt="O" width="25px" height="25px" />
						<h:outputLabel value="Export" for="exportExcelPic"
						style="cursor: pointer; padding: 2px 10px; color: #000000; text-decoration: underline;" />							
					</a4j:htmlCommandLink>
				</rich:panel>
			</rich:toolBarGroup>
		</rich:toolBar>
		<rich:extendedDataTable id="tepAdmission_table"
		styleClass="basicTable" rowClasses="oddRow,evenRow"
		width="99.8%" height="500px" 		
		enableContextMenu="false" 			
		var="tepAdmission"	
		binding="#{tepController.reportTepAdmissionTable}"	
		value="#{tepController.reportTepAdmissionList}" 
		noDataLabel="No TEP Admission Records Found.">				
			<rich:column id="tepId_Col" width="6%">
				<f:facet name="header">
					<h:outputText value="TEP ID" />
				</f:facet>
				<h:outputText value="#{tepAdmission.id}"/>
			</rich:column>	
			<rich:column id="ukId_Col" width="6%">
				<f:facet name="header">
					<h:outputText value="UK ID" />
				</f:facet>
				<h:outputText value="#{tepAdmission.user.ukID}"/>
			</rich:column>	
			<rich:column id="lastName_Col" width="10%">
				<f:facet name="header">
					<h:outputText value="Last Name" />
				</f:facet>
				<h:outputText value="#{tepAdmission.user.lName}"/>
			</rich:column>
			<rich:column id="firstName_Col" width="10%">
				<f:facet name="header">
					<h:outputText value="First Name" />
				</f:facet>
				<h:outputText value="#{tepAdmission.user.fName}"/>
			</rich:column>
			<rich:column id="ukMajor_Col" width="10%">
				<f:facet name="header">
					<h:outputText value="UK Major" />
				</f:facet>
				<h:outputText value="#{tepAdmission.programProfile.ukMajor.ukMajorCode}"/>
			</rich:column>
			<rich:column id="reportYear_Col" width="10%">
				<f:facet name="header">
					<h:outputText value="Report Year Code" />
				</f:facet>
				<h:outputText value="#{tepAdmission.reportYear.reportYearCode}"/>
			</rich:column>
			<rich:column id="term_Col" width="8%">
				<f:facet name="header">
					<h:outputText value="Term Code" />
				</f:facet>
				<h:outputText value="#{tepAdmission.cohortTerm.ukTermCode}"/>
			</rich:column>
			<rich:column id="admissionStatus_Col" width="10%">
				<f:facet name="header">
					<h:outputText value="Admission Status" />
				</f:facet>
				<h:outputText value="#{tepAdmission.tepAdmissionCode}"/>
			</rich:column>	
			<rich:column id="ukEmailAddress_Col" width="15%">
				<f:facet name="header">
					<h:outputText value="UK Email" />
				</f:facet>
				<h:outputText value="#{tepAdmission.user.ukyEmailAddress}"/>
			</rich:column>	
			<rich:column id="memo_Col" width="15%">
				<f:facet name="header">
					<h:outputText value="Memo" />
				</f:facet>
				<h:outputText value="#{tepAdmission.admissionMemo}"/>
			</rich:column>	
		</rich:extendedDataTable>		
	</h:form>	
</f:subview>