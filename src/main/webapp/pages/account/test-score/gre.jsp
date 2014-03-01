<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="authz"%>
	
<f:subview id="gre">
	<h:form id="gre_manager"  styleClass="styleish">				
		<h:panelGroup>						
			<h:outputLabel for="studentId" value="Student ID: "  styleClass="small" />
			<h:outputText id="studentId" value ="#{testScoreController.currentlySelectedUser.ukID}" />				
		</h:panelGroup>			
		<h:panelGroup id="gre_list">			
			<rich:extendedDataTable id="gre_Table" styleClass="basicTable"
				rowClasses="oddRow,evenRow"
				selectedClass="selectedRow"
				width="100%" height="200px"
				var="greTestScore"
				value="#{testScoreController.greTestScoreList}"
				binding="#{testScoreController.greTable}">	
				<a4j:support event="onRowClick" 
					action="#{testScoreController.takeGreSelection}">
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
		<h:panelGrid columns="2">
			<authz:authorize ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT" >
				<a4j:commandButton id="edit_gre" value="Edit Selected" styleClass="buttonStyle"  
				limitToList="true" ajaxSingle="true"  oncomplete="Richfaces.showModalPanel('selectedGreScoreEditPanel')"  
				reRender="selectedGreScoreEditPanel" action="#{testScoreController.prepGreEdit}"/>
			</authz:authorize>
			
			<authz:authorize ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_DELETE" >									 
				<h:commandButton id="delete_test" value="Delete Selected" styleClass="buttonStyle" 
					action="#{testScoreController.deleteGreTestScoreFromUser}"  >
					<a4j:support reRender="gre_manager:gre_list" limitToList="true" />
				</h:commandButton>
			</authz:authorize>
		</h:panelGrid>
	</h:form>
	
	<authz:authorize ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT" >
		<h:form id="gre_entry_form" styleClass="styleish">
			<h:panelGroup id="gre_entry">		
				<h:panelGrid columns="2" cellpadding="5"  styleClass="highlightClass" width="50%">				
					<h:outputLabel for="testDate" styleClass="small" value="Test Date : *"/>
					<rich:calendar id="testDate" value="#{testScoreController.greTestDate}"
						cellWidth="24px" datePattern="MMM d,yyyy" enableManualInput="true"
						cellHeight="22px" style="width:200px" required="true" requiredMessage="Test Date: Value is required.">
					</rich:calendar>	
					<h:outputLabel for="receivedDate" styleClass="small" value="Received Date : *"/>
					<rich:calendar id="receivedDate" value="#{testScoreController.greReceivedDate}"
						cellWidth="24px" datePattern="MMM d,yyyy" enableManualInput="true"
						cellHeight="22px" style="width:200px" required="true" requiredMessage="Received Date: Value is required.">
					</rich:calendar>	
					<h:outputLabel for="verbal" styleClass="small" value="Verbal :"/>
					<h:inputText id="verbal" value="#{testScoreController.greVerbal}" 
					required="true" requiredMessage="Verbal: Value is required.">
						<f:convertNumber />
					</h:inputText>	
					<h:outputLabel for="quantitative" styleClass="small" value="Quantitative : "/>
					<h:inputText id="quantitative" value="#{testScoreController.greQuantitative}" 
					required="true" requiredMessage="Quantitative: Value is required.">
						<f:convertNumber />
					</h:inputText>		
					<h:outputLabel for="analytic" styleClass="small" value="Analytic : "/>
					<h:inputText id="analytic" value="#{testScoreController.greAnalytic}" 
					required="true" requiredMessage="Analytic: Value is required.">
						<f:convertNumber />
					</h:inputText>		
					<h:outputLabel for="grePrimary" styleClass="small" value="Primary Score : "/>
					<h:selectBooleanCheckbox value="#{testScoreController.grePrimary}"/>							
					<h:commandButton id="add_new" value="Add New" styleClass="buttonStyle" 
					action="#{testScoreController.addGreTestScoreToUser}">
						<a4j:support reRender="gre_manager:gre_list" limitToList="true" /> 
					</h:commandButton> 								
				</h:panelGrid>				
			</h:panelGroup>			
		</h:form>		
	</authz:authorize>	
		
	<rich:modalPanel id="selectedGreScoreEditPanel" height="450" width="400" autosized="true" domElementAttachment="parent">
		<f:facet name="header">
			<h:outputText value="Edit GRE Score" />
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="/images/icons/cancel.png" id="hideViewlink"
				styleClass="hidelink" alt="X" />
				<rich:componentControl for="selectedGreScoreEditPanel"
				attachTo="hideViewlink" operation="hide" event="onclick" />
			</h:panelGroup>
		</f:facet>
		<h:form styleClass="styleish">
			<rich:messages style="color:red;"/>		
			<h:panelGrid columns="2" cellpadding="5"  styleClass="highlightClass" width="100%">	
			
				<h:outputLabel for="editTestDate" value="Test Date: " styleClass="small"/>
				<rich:calendar id="editTestDate" value="#{testScoreController.selectedGreTestScore.testDate}"
					cellWidth="24px" datePattern="MMM d,yyyy" enableManualInput="true"
					cellHeight="22px" style="width:200px" required="true" requiredMessage="Test Date: Value is Required">
				</rich:calendar>	
				<h:outputLabel for="verbal" value="Verbal: " styleClass="small"/>
				<h:inputText id="verbal" value="#{testScoreController.selectedGreTestScore.verbal}" 
				required="true" requiredMessage="Verbal: Value is required.">
					<f:convertNumber />
				</h:inputText>	
				<h:outputLabel for="quantitative" value="Quantitative: " styleClass="small"/>
				<h:inputText id="quantitative" value="#{testScoreController.selectedGreTestScore.quantitative}" 
				required="true" requiredMessage="Quantitative: Value is required.">
					<f:convertNumber />
				</h:inputText>		
				<h:outputLabel for="analytic" value="Analytic: " styleClass="small"/>
				<h:inputText id="analytic" value="#{testScoreController.selectedGreTestScore.analytic}" 
				required="true" requiredMessage="Analytic: Value is required.">
					<f:convertNumber />
				</h:inputText>		
				<h:outputLabel for="grePrimary" value="Primary Score: " styleClass="small"/>
				<h:selectBooleanCheckbox value="#{testScoreController.selectedGreTestScore.primaryBoolean}"/>						
								
				<a4j:commandButton id="edit_test" value="Edit"	styleClass="buttonStyle"  
				reRender="gre_manager:gre_list" limitToList="true" 
				action="#{testScoreController.editGreTestScoreForUser}"  
				oncomplete="Richfaces.hideModalPanel('selectedGreScoreEditPanel')" /> 									
			
			</h:panelGrid>
		</h:form>			
	</rich:modalPanel>
</f:subview>