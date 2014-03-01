<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:subview id="praxisI">
	<h:form id="praxisI_manager_form">
		<h:panelGroup id="praxisI_list">
			<rich:extendedDataTable id="praxisI_Table" 
				styleClass="basicTable" selectedClass="selectedRow"
				rowClasses="oddRow,evenRow" 
				width="100%" height="150px"
				onRowMouseOver="this.style.backgroundColor='#B3C9E0'"				
 				onRowMouseOut="this.style.backgroundColor='#{rowKeyVar}'"
				enableContextMenu="false" var="praxisITestScore" 
				value="#{tepController.praxisITestScoreList}"
				binding="#{tepController.praxisITable}"
				noDataLabel="No Praxis I Scores Found.">
				<a4j:support event="onRowClick" reRender="tep_entry"
					action="#{tepController.takePraxisISelection}">
				</a4j:support>
				<rich:column id="praxisITestId_Col" width="10%" sortable="true"
					sortBy="#{praxisITestScore.id}">
					<f:facet name="header">
						<h:outputText value="Test ID" />
					</f:facet>
					<h:panelGroup>
						<h:outputText value="#{praxisITestScore.id}" />
					</h:panelGroup>
				</rich:column>
				<rich:column id="praxisITestCode_Col" width="10%" sortable="true"
					sortBy="#{praxisITestScore.praxisICode}">
					<f:facet name="header">
						<h:outputText value="Test Code" />
					</f:facet>
					<h:panelGroup>
						<h:outputText value="#{praxisITestScore.praxisICode}" />
					</h:panelGroup>
				</rich:column>
				<rich:column id="praxisITestTitle_Col" width="30%" sortable="true"
					sortBy="#{praxisITestScore.praxisITest.title}">
					<f:facet name="header">
						<h:outputText value="Test Title" />
					</f:facet>
					<h:outputText value="#{praxisITestScore.praxisITest.title}" />
				</rich:column>
				<rich:column id="praxisITestDate_Col" width="10%" sortable="true"
					sortBy="#{praxisITestScore.testDate}">
					<f:facet name="header">
						<h:outputText value="Test Date" />
					</f:facet>
					<h:outputText value="#{praxisITestScore.testDate}" />
				</rich:column>
				<rich:column id="praxisIScore_Col" width="10%" sortable="true"
					sortBy="#{praxisITestScore.score}">
					<f:facet name="header">
						<h:outputText value="Score" />
					</f:facet>
					<h:panelGroup>
						<h:outputText value="#{praxisITestScore.scoreInt}" />
					</h:panelGroup>
				</rich:column>				
				<rich:column id="praxisIMadeCutoff_Col" width="10%" sortable="true"
					sortBy="#{praxisITestScore.cutOffString}">
					<f:facet name="header">
						<h:outputText value="Made Cutoff" />
					</f:facet>
					<h:outputText value="#{praxisITestScore.cutOffString}" />
				</rich:column>
				<rich:column id="praxisIReceivedDate_Col" width="10%" sortable="true"
					sortBy="#{praxisITestScore.dateRecieved}">
					<f:facet name="header">
						<h:outputText value="Received Date" />
					</f:facet>
					<h:panelGroup>
						<h:outputText value="#{praxisITestScore.dateRecieved}" />
					</h:panelGroup>
				</rich:column>
				<rich:column id="praxisIPrimary_Col" width="10%" sortable="true"
					sortBy="#{praxisITestScore.primarystring}">
					<f:facet name="header">
						<h:outputText value="Primary" />
					</f:facet>
					<h:outputText value="#{praxisITestScore.primaryString}" />
				</rich:column>				
			</rich:extendedDataTable>
		</h:panelGroup>
	</h:form>
</f:subview>