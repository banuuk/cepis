<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:subview id="gre">
	<h:form id="gre_manager_form">
		<h:panelGroup id="gre_list">			
			<rich:extendedDataTable id="gre_Table" 
				styleClass="basicTable" selectedClass="selectedRow"
				rowClasses="oddRow,evenRow"
				width="100%" height="150px"				
				onRowMouseOver="this.style.backgroundColor='#B3C9E0'"				
 				onRowMouseOut="this.style.backgroundColor='#{rowKeyVar}'"				
				enableContextMenu="false" var="greTestScore" 
				binding="#{tepController.greTable}"
				value="#{tepController.greTestScoreList}" 				
				noDataLabel="No GRE Scores Found.">	
				<a4j:support event="onRowClick" reRender="tep_entry"
					action="#{tepController.takeGreSelection}">
				</a4j:support>					
				<rich:column id="greId_Col" width="16%">
					<f:facet name="header">
						<h:outputText value="GRE ID" />
					</f:facet>
					<h:outputText value="#{greTestScore.greId}"/>
				</rich:column>
				<rich:column id="greVerbal_Col" width="12%">
					<f:facet name="header">
						<h:outputText value="Verbal" />
					</f:facet>
					<h:panelGroup>
						<h:outputText value="#{greTestScore.verbal}"/>
					</h:panelGroup>
				</rich:column>
				<rich:column id="greQuantitative_Col" width="12%">
					<f:facet name="header">
						<h:outputText value="Quantitative" />
					</f:facet>
					<h:outputText value="#{greTestScore.quantitative}"/>
				</rich:column>
				<rich:column  id="greAnalytic_Col" width="12%">
					<f:facet name="header">
						<h:outputText value="Analytic" />
					</f:facet>
					<h:outputText value="#{greTestScore.analytic}"/>
				</rich:column>
				<rich:column id="greTestDate_Col" width="12%">
					<f:facet name="header">
						<h:outputText value="Test Date" />
					</f:facet>
					<h:outputText value="#{greTestScore.testDate}"/>
				</rich:column>
				<rich:column id="greReceivedDate_Col" width="12%">
					<f:facet name="header">
						<h:outputText value="Received Date" />
					</f:facet>
					<h:outputText value="#{greTestScore.dateRecieved}"/>
				</rich:column>
				<rich:column id="greCutoff_Col" width="12%">
					<f:facet name="header">
						<h:outputText value="Made Cutoff" />
					</f:facet>
					<h:outputText value="#{greTestScore.cutOffString}"/>
				</rich:column>
				<rich:column id="grePrimary_Col" width="12%">
					<f:facet name="header">
						<h:outputText value="Primary" />
					</f:facet>
					<h:outputText value="#{greTestScore.primaryString}"/>
				</rich:column>
			</rich:extendedDataTable>			
		</h:panelGroup>
	</h:form>
</f:subview>