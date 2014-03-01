<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ include file="/common/header.jsp"%>

<script type="text/javascript">
	document.title = "CEPIS Notes";
	var global_title = document.getElementById('global_title');
	global_title.innerHTML = "CEPIS Notes";
</script>
<link href="${facesContext.externalContext.requestContextPath}/css/newStyle.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>

<f:view locale="en">
	<a4j:outputPanel ajaxRendered="true" style="align:center" id="msgs">
		<h:panelGrid columns="1" id="notesmsgs" width="95%">
			<rich:messages errorClass="cepiserror" infoClass="cepissuccess"
				warnClass="cepiswarning"/>
		</h:panelGrid>
		<a4j:status onstart="showModalInfoWindow();" onstop="hideModalInfoWindow()"/>
	</a4j:outputPanel>
	<h:form id="entryForm">			
		<rich:panel id="entryPanel" style="height:550px;">
			<f:facet name="header">
				<h:outputText>Entry</h:outputText>
			</f:facet>									  
	       	<h:panelGrid columns="3" width="1500px" cellpadding="5" >	       	
	       		<h:panelGroup id="selectionArea" layout="block">					
					<h:panelGroup>						
						<h:outputLabel for="wsid" styleClass="medium" value="#{workingSetController.activeWorkingSetName}"/>
					</h:panelGroup>
					<h:panelGrid styleClass="wsCore">						
						<h:selectManyListbox id="wsid"
							value="#{noteController.selectedWSUsersList}"
							size="25" converter="#{UserDataConverter}"
							style="width: 200px;" required="true"
							requiredMessage="You must select at least one user from the working set.">
							<f:selectItems
								value="#{workingSetController.activeWSUsersList}"
								var="user" itemLabel="#{user.fullName}" />
							<f:validator validatorId="UserDataValidator" />							
						</h:selectManyListbox>						
					</h:panelGrid>					
					<h:panelGrid columns="2">
						<h:outputLabel styleClass="small" for="saveNote" value="Create Note: "/>			
						<h:selectBooleanCheckbox id="saveNote" value="#{noteController.saveNote}">			
							 <a4j:support event="onclick" ajaxSingle="true" reRender="entryForm:entryPanel"/>							
						</h:selectBooleanCheckbox>
						<h:outputLabel styleClass="small" for="sendEmail" value="Send Email: "/>	
						<h:selectBooleanCheckbox id="sendEmail" value="#{noteController.sendEmail}">
							 <a4j:support event="onclick" ajaxSingle="true" reRender="entryForm:entryPanel"/>							 							
						</h:selectBooleanCheckbox>
					</h:panelGrid>							
					<h:commandButton id="go" value="Go" action="#{noteController.go}">
						<a4j:support event="onchanged" ajaxSingle="true" reRender="displayForm:notesArea" />
					</h:commandButton> 																
	       		</h:panelGroup>	   		
	       		<h:panelGroup id="noteArea" rendered="#{noteController.saveNote}" layout="block">
	       			<rich:panel id="notePanel" style="height:500px; width:400px">
						<f:facet name="header">
							<h:outputText>Create Note</h:outputText>
						</f:facet>	 	    		       		
			       		<h:panelGrid columns="2" cellpadding="5">		       		
				       		<h:outputLabel styleClass="small"  for="category" value="Category: "/>
						    <h:selectOneMenu id="category" value="#{noteController.category}">
						  		<f:selectItem itemValue="" itemLabel="-- Select --" /> 
								<f:selectItem itemValue="Academic Concerns" itemLabel="Academic Concerns" />
								<f:selectItem itemValue="Academic Status" itemLabel="Academic Status" />
								<f:selectItem itemValue="Advising Emergency" itemLabel="Advising Emergency" />
								<f:selectItem itemValue="Advising Updates" itemLabel="Advising Updates" />
								<f:selectItem itemValue="Graduation Application" itemLabel="Graduation Application" />
								<f:selectItem itemValue="Graduation Audit" itemLabel="Graduation Audit" />										   	
							   	<f:selectItem itemValue="Priority Registration" itemLabel="Priority Registration" />
							   	<f:selectItem itemValue="Professional Development" itemLabel="Professional Development" />			   				   	
							   	<f:selectItem itemValue="Student Teaching" itemLabel="Student Teaching" />					   	
							   	<f:selectItem itemValue="TEP Application" itemLabel="TEP Application" />	
							</h:selectOneMenu>															 				
			 				<h:outputLabel styleClass="small" for="hidden" value="Make Note Private: " />
							<h:selectOneMenu id="hidden" value="#{noteController.hideNoteString}" 
							required="true" requiredMessage="Make Note Private: Value is required.">
			 					<f:selectItem itemValue="" itemLabel="-- Select --" /> 
			 					<f:selectItem itemValue="YES" itemLabel="Yes" />
			 					<f:selectItem itemValue="NO" itemLabel="No" />	 						
			 				</h:selectOneMenu>  			 				
			 				<h:outputLabel styleClass="small" for="noteContent" value="Note Content:"/>  
					    	<rich:editor id="noteContent" value="#{noteController.noteContent}" width="250" height="325" 
					    	required="true" requiredMessage="Note Content: Value is Required."/>													
			       		</h:panelGrid>
			       	</rich:panel>
	       		</h:panelGroup>	       		
	       		<h:panelGroup id="emailArea" rendered="#{noteController.sendEmail}" layout="block">
	       			<rich:panel id="emailPanel" style="height:500px; width:800px">
						<f:facet name="header">
							<h:outputText>Send Email</h:outputText>
						</f:facet>	
			       		<h:panelGrid columns="2" cellpadding="5">   
			       			<h:outputLabel styleClass="small" for="from" value="Email From: " />
			 				<h:selectOneMenu id="from" value="#{noteController.emailFrom}">
			 					<f:selectItem itemValue="0" itemLabel="TEB166" /> 
			 					<f:selectItem itemValue="1" itemLabel="My Self" />
			 				</h:selectOneMenu>  			 				
			 				<h:outputLabel styleClass="small" for="subject" value="Email Subject: " />
			 				<h:inputText id="subject" value="#{noteController.emailSubject}" 
			 				required="true" requiredMessage="Email Subject: Value is Required."/>					 				
						    <h:outputLabel styleClass="small" for="emailContent" value="Email Content:"/>  
						    <rich:editor id="emailContent" value="#{noteController.emailContent}" width="450" height="250" 
						    required="true" requiredMessage="Email Content: Value is Required." theme="advanced" 
							plugins = "spellchecker, pagebreak, style, layer, table, save, advhr, advimage, advlink, xhtmlxtras,
							emotions, iespell, inlinepopups, insertdatetime, preview, media, searchreplace, print, template,
							contextmenu, paste, directionality, fullscreen, noneditable, visualchars, nonbreaking">	 
						    	 <f:param name="theme_advanced_buttons1" value="save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,|,styleselect,formatselect,fontselect,fontsizeselect"/>
						    	 <f:param name="theme_advanced_buttons2" value="cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor"/>
						    	 <f:param name="theme_advanced_buttons3" value="tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen"/>
						    	 <f:param name="theme_advanced_buttons4" value="insertlayer,moveforward,movebackward,absolute,|,styleprops,spellchecker,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,blockquote,pagebreak,|,insertfile,insertimage"/>
						    	 <f:param name="theme_advanced_toolbar_location" value="top"/>                               
          						 <f:param name="theme_advanced_toolbar_align" value="left"/>
						    </rich:editor>						    
						    <h:outputLabel styleClass="small" for="noReply" value="No Reply: "/>
						    <h:selectBooleanCheckbox id="noReply" value="#{noteController.noReply}"/>  						    
						    <h:outputLabel styleClass="small" for="ccME" value="CC My Self: "/>
						    <h:selectBooleanCheckbox id="ccME" value="#{noteController.ccEnteredBy}"/>						    
						    <h:outputLabel styleClass="small" for="saveEmail" value="Save For Later: "/>
						    <h:selectBooleanCheckbox id="saveEmail" value="#{noteController.saveEmail}"/>    		
			       		</h:panelGrid>
			       	</rich:panel>
	       		</h:panelGroup>	       										     	
			</h:panelGrid> 	 
		</rich:panel>		 	
	</h:form>		
 	<h:form id="searchForm">
 		<rich:panel style="height:150px;">
			<f:facet name="header">
				<h:outputText>Search</h:outputText>
			</f:facet>	
			<h:panelGrid id="searchPanel" columns="4" width="1000px" cellpadding="5">			
				<h:panelGrid columns="2" cellpadding="5"> 
					<h:outputLabel styleClass="small" for="fromDate" value="From: "/>
					<rich:calendar id="fromDate" value="#{noteController.fromDate}"
					cellWidth="24px" datePattern="MMM d,yyyy"
					cellHeight="22px" style="width:200px" >
					</rich:calendar>					
					<h:outputLabel styleClass="small" for="toDate" value="To:"/>
					<rich:calendar id="toDate" value="#{noteController.toDate}"
					cellWidth="24px" datePattern="MMM d,yyyy"
					cellHeight="22px" style="width:200px"
					todayControlMode="hidden" />															
				</h:panelGrid>				
				<h:panelGrid columns="2" cellpadding="5"> 
					<h:outputLabel styleClass="small" for="enteredBy" value="Entered By: " />
					<h:inputText id="enteredBy" value="#{noteController.enteredBy}"/>					
					<h:outputLabel styleClass="small" for="category" value="Category: " />
					<h:selectOneMenu id="category" value="#{noteController.category}">
						<f:selectItem itemValue="" itemLabel="-- Select --" /> 
						<f:selectItem itemValue="Academic Concerns" itemLabel="Academic Concerns" />
						<f:selectItem itemValue="Academic Status" itemLabel="Academic Status" />
						<f:selectItem itemValue="Advising Emergency" itemLabel="Advising Emergency" />
						<f:selectItem itemValue="Advising Updates" itemLabel="Advising Updates" />
						<f:selectItem itemValue="Graduation Application" itemLabel="Graduation Application" />
						<f:selectItem itemValue="Graduation Audit" itemLabel="Graduation Audit" />										   	
					   	<f:selectItem itemValue="Priority Registration" itemLabel="Priority Registration" />
					   	<f:selectItem itemValue="Professional Development" itemLabel="Professional Development" />			   				   	
					   	<f:selectItem itemValue="Student Teaching" itemLabel="Student Teaching" />					   	
					   	<f:selectItem itemValue="TEP Application" itemLabel="TEP Application" />					   	
					</h:selectOneMenu>																							 				
				</h:panelGrid>				
				<h:panelGrid columns="2" cellpadding="5"> 				
					<h:outputLabel styleClass="small" for="emailSent" value="EmailSent: " />
					<h:selectOneMenu id="emailSent" value="#{noteController.emailSentString}">
	 					<f:selectItem itemValue="NULL" itemLabel="-- Select --" /> 
	 					<f:selectItem itemValue="YES" itemLabel="Yes" />
	 					<f:selectItem itemValue="NO" itemLabel="No" />
	 				</h:selectOneMenu> 	 				
	 				<h:outputLabel styleClass="small" for="notePrivate" value="Note Private: " />
					<h:selectOneMenu id="notePrivate" value="#{noteController.hideNoteString}">
	 					<f:selectItem itemValue="NULL" itemLabel="-- Select --" /> 
	 					<f:selectItem itemValue="YES" itemLabel="Yes" />
	 					<f:selectItem itemValue="NO" itemLabel="No" />
	 				</h:selectOneMenu>  										
				</h:panelGrid>
			</h:panelGrid> 			
			<h:commandButton id="search" value="Search" action="#{noteController.search}">
				<a4j:support event="onchanged" ajaxSingle="true" reRender="notesArea" />
			</h:commandButton>  			
		</rich:panel>
 	</h:form>
	<h:form id="displayForm">		 		 
	 	<h:panelGroup id="notesArea">
		    <rich:extendedDataTable
		       	id="notesTable" styleClass="basicTable"  
		    	rowClasses="oddRow,evenRow" selectedClass="selectedRow"
		    	style="margin-left: 20px;" width="95%" height="300px"
		    	onRowMouseOver="this.style.backgroundColor='#B3C9E0'"
		    	onRowMouseOut="this.style.backgroundColor='#{rowKeyVar}'"
		    	enableContextMenu="false" var="note" 	
 				binding="#{noteController.noteTable}"	 				
 				value="#{noteController.selectedNotesDataModel}"	 							 
 				tableState="#{noteController.tableState}"  				
 				selection="#{noteController.selection}"  					
 				noDataLabel="No notes found.">
 				<a4j:support event="onRowDblClick" 
 					reRender="selectedNoteEditPanel"
 					action="#{noteController.takeSelection}" 
 					oncomplete="Richfaces.showModalPanel('selectedNoteEditPanel')">					
 				</a4j:support> 
 				<rich:column id="noteId_Col" width="10%" label="Note ID"	 
 					sortable="true" sortBy="#{note.id}">				 
 					<f:facet name="header">
 						<h:outputText value="Note ID" /> 
 					</f:facet> 
 					<h:outputText value="#{note.id}" /> 
 				</rich:column>				
 				<rich:column id="category_Col" width="30%" label="Category"	 
 					sortable="true" sortBy="#{note.category}">					 
 					<f:facet name="header"> 
 						<h:outputText value="Category" /> 
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
 				<rich:column id="enteredBy_Col" width="10%" label="Entered By"  
 					sortable="true" sortBy="#{note.enteredBy}">
 					<f:facet name="header"> 
 						<h:outputText value="Entered By"/>
 					</f:facet> 
 					<h:outputText value="#{note.enteredBy}"/> 
 				</rich:column>				
 				<rich:column id="emailSent_Col" width="10%" label="Email Sent"
 					sortable="true" sortBy="#{note.emailSent}"> 
 					<f:facet name="header">
 						<h:outputText value="Email" /> 
 					</f:facet> 
 					<h:outputText value="#{note.emailSentString}"/> 
 				</rich:column>	
 				<rich:column id="noteSaved_Col" width="10%" label="Note Saved" 
 					sortable="true" sortBy="#{note.noteSaved}"> 
 					<f:facet name="header"> 
 						<h:outputText value="Note" /> 
 					</f:facet> 
 					<h:outputText value="#{note.noteSavedString}"/> 
 				</rich:column>	
 				<rich:column id="notePrivate_Col" width="10%" label="Note Private"
 					sortable="true" sortBy="#{note.noteHidden}"> 
 					<f:facet name="header"> 
 						<h:outputText value="Private" />
 					</f:facet> 
 					<h:outputText value="#{note.noteHiddenString}"/>
 				</rich:column>							
 			</rich:extendedDataTable> 
		</h:panelGroup>
	</h:form>		
	<rich:modalPanel id="selectedNoteEditPanel" height="450" width="450" autosized="true" domElementAttachment="parent">
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
			<h:panelGrid rowClasses="row_padding">	
				<h:panelGroup styleClass="row_padding">				
					<h:outputLabel for="view_note_id" styleClass="small" value="Note ID: " />
					<h:outputText id="view_note_id" style="width: 200px" value="#{noteController.selectedNote.id}"/>								
				</h:panelGroup>	
				<h:panelGroup styleClass="row_padding">			
					<h:outputLabel for="view_entered_by" styleClass="small" value="Entered By: " />				
					<h:outputText id="view_entered_by" style="width: 200px"	value="#{noteController.selectedNote.enteredBy}"/>				
				</h:panelGroup>	
				<h:panelGroup styleClass="row_padding">	
					<h:outputLabel for="view_email_saved" styleClass="small" value="Email Saved: " />				
					<h:outputText id="view_email_saved" style="width: 200px" value="#{noteController.selectedNote.emailSavedString}"/>	
				</h:panelGroup>	
			</h:panelGrid>					
			<rich:separator lineType="beveled" height="8" align="center" style="margin: 10px" />	
			<h:panelGrid style="padding-right: 10px; padding-left: 10px">
				<h:panelGrid columns="2">					
					<h:outputLabel for="edit_note_category" value="Category: " />				
					<h:selectOneMenu id="edit_note_category" value="#{noteController.selectedNote.category}">
						<f:selectItem itemLabel="Category1" itemValue="Category1" />
						<f:selectItem itemLabel="Category2" itemValue="Category2" />					
					</h:selectOneMenu>					
					<h:outputLabel for="note_content_edit" value="Note: "/>
					<rich:editor id="note_content_edit" value="#{noteController.selectedNote.noteContent}" 
						width="250" height="200"/>				
				</h:panelGrid>
				<h:panelGrid columns="2">
					<h:outputLabel for="user_list" value="Students: "/>
					<h:selectManyListbox id="user_list" disabled="true" size="10" style="width:250px;" >
						<f:selectItems value="#{noteController.selectedNote.students}"
							var="user" itemLabel="#{user.fullName}" />						
					</h:selectManyListbox>
				</h:panelGrid>								
				<h:panelGroup>
					<h:commandButton id="edit" value="Edit" action="#{noteController.editNote}" style="margin-right:25px"/>  
					<h:commandButton id="clone" value="Clone" action="#{noteController.cloneNote}" style="margin-right:25px"/> 	
					<h:commandButton id="close" value="Close" style="margin-right:25px"/> 
					<rich:componentControl for="selectedNoteEditPanel" attachTo="close" operation="hide" event="onclick" />	
					<h:commandButton id="delete" value="Delete" action="#{noteController.deleteNote}"/>
				</h:panelGroup>
			</h:panelGrid>
		</h:form>
	</rich:modalPanel>	
</f:view>
<%@ include file="/common/footer.jsp"%>