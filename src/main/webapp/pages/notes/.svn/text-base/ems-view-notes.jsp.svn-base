<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>

<link href="${facesContext.externalContext.requestContextPath}/css/newStyle.css" media="screen"
	rel="stylesheet" type="text/css"/>

<f:subview id="ems-notes-section">
	<h:form>
			<h:outputText value="#{accountManagementController.initNotes}" />
			<h:panelGroup id="notesArea">
		    <rich:extendedDataTable
				value="#{accountManagementController.selectedNotesDataModel}"
				var="note" id="notesTable" 
				styleClass="basicTable" width="100%" height="300px"				
				tableState="#{accountManagementController.noteTableState}"
				selection="#{accountManagementController.noteSelection}"
				binding="#{accountManagementController.noteTable}"
				enableContextMenu="false"
				onRowMouseOver="this.style.backgroundColor='#B3C9E0'"
				onRowMouseOut="this.style.backgroundColor='#{rowKeyVar}'"
				selectedClass="selectedRow"	noDataLabel="No notes found.">
				<a4j:support event="onRowDblClick"
					reRender="selectedNoteEditPanel"
					action="#{accountManagementController.takeNoteSelection}"
					oncomplete="Richfaces.showModalPanel('selectedNoteEditPanel')">					
				</a4j:support>
				<rich:column id="noteId_Col" width="10%" label="Note ID"
					sortable="true" sortBy="#{note.id}">					 
					<f:facet name="header">
						<h:outputText value="Note ID"/>
					</f:facet>
					<h:outputText value="#{note.id}"/>
				</rich:column>				
				<rich:column id="category_Col" width="40%" label="Category"
					 sortable="true" sortBy="#{note.category}">					
					<f:facet name="header">
						<h:outputText value="Category"/>
					</f:facet>
					<h:outputText value="#{note.category}"/>
				</rich:column>				
				<rich:column id="dateEntered_Col" width="20%" label="Date Entered" 
					sortable="true" sortBy="#{note.creationDate}">
					<f:facet name="header">
						<h:outputText value="Date Entered"/>
					</f:facet>
					<h:outputText value="#{note.creationDate}"/>
				</rich:column>
				<rich:column id="enteredBy_Col" width="10%" label="Date Entered" 
					sortable="true" sortBy="#{note.enteredBy}">
					<f:facet name="header">
						<h:outputText value="Entered By"/>
					</f:facet>
					<h:outputText value="#{note.enteredBy}"/>
				</rich:column>
				<rich:column id="emailSent_Col" width="10%" label="Status"
					sortable="true" sortBy="#{note.emailSent}">
					<f:facet name="header">
						<h:outputText value="Email Sent"/>
					</f:facet>
					<h:outputText value="#{note.emailSentString}"/>
				</rich:column>		
				<rich:column id="notePrivate_Col" width="10%" label="Private"
					sortable="true" sortBy="#{note.noteHidden}">
					<f:facet name="header">
						<h:outputText value="Private"/>
					</f:facet>
					<h:outputText value="#{note.noteHiddenString}"/>
				</rich:column>					
			</rich:extendedDataTable>
		</h:panelGroup>
	</h:form>
	<rich:modalPanel id="selectedNoteEditPanel" width="450" autosized="true" domElementAttachment="parent"
		styleClass="entry-selected-window">
		<f:facet name="header">
			<h:outputText value="Edit Selected Note" />
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="/images/icons/cancel.png" id="hideViewlink"
					styleClass="hidelink" alt="X" />
				<rich:componentControl for="selectedNoteEditPanel"
					attachTo="hideViewlink" operation="hide" event="onclick" />
			</h:panelGroup>
		</f:facet>
		<h:form>
			<rich:messages style="color:red;"/>	
			<h:panelGrid>			
				<h:panelGroup>
					<h:outputLabel for="view_note_id" value="Note ID: " styleClass="small"/>												
					<h:outputText id="view_note_id" value="#{accountManagementController.selectedNote.id}"/>	
				</h:panelGroup>		
				
				<h:panelGroup>					
					<h:outputLabel for="view_entered_by" value="Entered By: " styleClass="small"/>
					<h:outputText id="view_entered_by" value="#{accountManagementController.selectedNote.enteredBy}"/>
				</h:panelGroup>
				<h:panelGroup>					
					<h:outputLabel for="note_category" value="Category: " styleClass="small"/>
					<h:outputText id="note_category" value="#{accountManagementController.selectedNote.category}"/>
				</h:panelGroup>				
			</h:panelGrid>	
			<rich:separator lineType="beveled" height="8" align="center" style="margin: 10px" />	
			<h:panelGrid>								
				<h:panelGroup>
					<h:outputLabel for="note_content"  value="Note: " styleClass="small"/>								
					<rich:editor id="note_content" value="#{accountManagementController.selectedNote.noteContent}" readonly="true" width="350" />			
				</h:panelGroup>			 					
			</h:panelGrid>
		</h:form>
	</rich:modalPanel>
</f:subview>