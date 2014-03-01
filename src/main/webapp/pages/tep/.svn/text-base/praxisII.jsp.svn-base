<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:subview id="praxisII">	
	<h:form id="praxisII_manager_form">					
		<h:panelGroup id="praxisII_list">			
			<rich:extendedDataTable id="praxisII_Table" 
				styleClass="basicTable" selectedClass="selectedRow"
				rowClasses="oddRow,evenRow"				 
				width="100%" height="150px"
				onRowMouseOver="this.style.backgroundColor='#B3C9E0'"				
 				onRowMouseOut="this.style.backgroundColor='#{rowKeyVar}'"
				enableContextMenu="false" var="praxisIITestScore" 
				value="#{tepController.praxisIITestScoreList}"				
				binding="#{tepController.praxisIITable}"					
				noDataLabel="No Praxis II Scores Found.">					
				<a4j:support event="onRowClick" reRender="tep_entry"
					action="#{tepController.takePraxisIISelection}">
				</a4j:support>						
				<rich:column id="praxisIITestCode_Col" width="9%"
				sortable="true" sortBy="#{praxisIITestScore.praxisIICode}">
					<f:facet name="header">
						<h:outputText value="Test Code" />
					</f:facet>
					<h:panelGroup>
						<h:outputText value="#{praxisIITestScore.praxisIICode}"/>
					</h:panelGroup>
				</rich:column>
				<rich:column id="praxisIITestTitle_Col" width="28%"
				sortable="true" sortBy="#{praxisIITestScore.praxisIITest.title}">
					<f:facet name="header">
						<h:outputText value="Test Title" />
					</f:facet>
					<h:outputText value="#{praxisIITestScore.praxisIITest.title}"/>
				</rich:column>
				<rich:column id="praxisIITestDate_Col" width="9%"
				sortable="true" sortBy="#{praxisIITestScore.testDate}">
					<f:facet name="header">
						<h:outputText value="Test Date" />
					</f:facet>
					<h:outputText value="#{praxisIITestScore.testDate}"/>
				</rich:column>
				<rich:column id="praxisIIScore_Col" width="9%"
				sortable="true" sortBy="#{praxisIITestScore.score}">
					<f:facet name="header">
						<h:outputText value="Score" />
					</f:facet>
					<h:panelGroup>
						<h:outputText value="#{praxisIITestScore.scoreInt}"/>							
					</h:panelGroup>
				</rich:column>		
				<rich:column id="praxisIICutoff_Col" width="9%"
				sortable="true" sortBy="#{praxisIITestScore.praxisIITest.cutoffScore}">
					<f:facet name="header">
						<h:outputText value="Cutoff" />
					</f:facet>
					<h:outputText value="#{praxisIITestScore.praxisIITest.cutoffScore}"/>
				</rich:column>			
				<rich:column id="praxisIIMadeCutoff_Col" width="9%"
				sortable="true" sortBy="#{praxisIITestScore.cutoff}">
					<f:facet name="header">
						<h:outputText value="Made Cutoff" />
					</f:facet>
					<h:outputText value="#{praxisIITestScore.cutoff}"/>
				</rich:column>					
				<rich:column id="praxisIIReceivedDate_Col" width="9%"
				sortable="true" sortBy="#{praxisIITestScore.receivedDate}">
					<f:facet name="header">
						<h:outputText value="Received Date" />
					</f:facet>
					<h:panelGroup>
						<h:outputText value="#{praxisIITestScore.receivedDate}"/>							
					</h:panelGroup>
				</rich:column>
				<rich:column id="praxisIIPrimary_Col" width="9%"
				sortable="true" sortBy="#{praxisIITestScore.primaryString}">
					<f:facet name="header">
						<h:outputText value="Primary" />
					</f:facet>
					<h:outputText value="#{praxisIITestScore.primaryString}"/>
				</rich:column>
				<rich:column id="praxisIILastEdit_Col" width="9%"
				sortable="true" sortBy="#{praxisIITestScore.lastEdit}">
					<f:facet name="header">
						<h:outputText value="Last Edit" />
					</f:facet>
					<h:outputText value="#{praxisIITestScore.lastEdit}"/>
				</rich:column>					
			</rich:extendedDataTable>
		</h:panelGroup>	
	</h:form>	
</f:subview>