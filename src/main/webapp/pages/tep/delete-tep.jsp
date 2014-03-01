<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<h:form id="deleteTep_form" styleClass="styleish">

	<h:panelGrid columns="2">
		<h:graphicImage url="/images/info.png" alt="i" title="Info" />			
		<h:outputLabel value="Delete TEP Admission AND/OR Application for selected user" styleClass="small"/>			
	</h:panelGrid>		
		
	<br />

	<h:panelGrid columns="2" cellpadding="2" width="50%">		
	
		<h:outputLabel for="tepAdmissionId" value="TEP Admission ID:" styleClass="small"/>
		
		<h:selectOneListbox id="tepAdmissionId" size="1"
			converter="#{TepAdmissionDataConverter}" style="width: 200px;"
			value="#{tepController.selectedTepAdmission}" >					
			<f:selectItem itemLabel="-- Select One --" itemValue="" />
			<f:selectItems value="#{tepController.tepAdmissionList}"
			var="tepAdmission" itemLabel="TEP Admission ID: #{tepAdmission.id}" />
			<a4j:support event="onchange" reRender="tepAdmission_area"
			ajaxSingle="true" limitToList="true"
			actionListener="#{tepController.prepTepAdmissionEdit}"/>
		</h:selectOneListbox>
				
		<h:outputLabel for="tepApplicationId" value="TEP Application ID:" styleClass="small"/>
		
		<h:selectOneListbox id="tepApplicationId" size="1"
		converter="#{TepApplicationDataConverter}" style="width: 200px;"
		value="#{tepController.selectedTepApplication}" >					
			<f:selectItem itemLabel="-- Select One --" itemValue="" />
			<f:selectItems value="#{tepController.tepApplicationList}"
			var="tepApplication" itemLabel="TEP Application ID: #{tepApplication.id}" />
			<a4j:support event="onchange" reRender="tepApplication_area"
			ajaxSingle="true" limitToList="true"
			actionListener="#{tepController.prepTepApplicationEdit}"/>
		</h:selectOneListbox>
				
		<h:commandButton styleClass="buttonStyle" value="Delete"
		action="#{tepController.deleteSelectedTep}"/>		
	</h:panelGrid>
	
	
	
</h:form>