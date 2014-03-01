<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<link href="${facesContext.externalContext.requestContextPath}/css/datascroller.css"
	media="screen" rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:subview id="edit-personal-profile">

	<h:form id="edit_userpersonalprofile_manager" styleClass="styleish">
	
		<h:outputLabel value="Update Personal Profile"  styleClass="medium-bold"/>
		<rich:separator lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>		
		
		<h:panelGrid columns="2" style="padding-right: 100px; padding-left: 100px" cellpadding="2">
		
			<h:outputLabel for="ethnicList" value="Ethnicity : *" styleClass="small"/>						
			<h:selectOneListbox id="ethnicList" immediate="true"
			value="#{accountManagementController.userPersonalProfile.ethnic}" size="1"
			converter="#{EthnicDataConverter}" style="width:200px"
			required="true" requiredMessage="Ethnicity: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems value="#{cepisGlobalComponentConfigurator.ethnicList}" 
				var="ethnic" itemLabel="#{ethnic}" />
				<f:validator validatorId="EthnicDataValidator" />
			</h:selectOneListbox>
			
			<h:outputLabel for="citizen" value="Citizenship : *" styleClass="small"/>				
			<h:selectOneListbox id="citizen" size="1" style="width:200px"
			value="#{accountManagementController.userPersonalProfile.citizen}" 
			required="true" requiredMessage="Citizen: Value is required.">
				<f:selectItems value="#{cepisGlobalComponentConfigurator.countries}"					
				var="country" itemLabel="#{country}" />
			</h:selectOneListbox>
						
			<h:outputLabel for="diplomaType" value="Diploma Type : " styleClass="small"/>					
			<h:selectOneListbox id="diplomaType" immediate="true" style="width:200px" size="1"
			value="#{accountManagementController.userPersonalProfile.diplomaType}" >
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItem itemLabel="High School" itemValue="High School" />
				<f:selectItem itemLabel="GED" itemValue="GED" />
				<f:selectItem itemLabel="Foreign" itemValue="Foreign" />
			</h:selectOneListbox>
			
			<h:outputLabel for="diplomaState" value="Diploma State : " styleClass="small"/>				
			<h:inputText id="diplomaState" style="width:200px"
			value="#{accountManagementController.userPersonalProfile.diplomaState}" 
			validatorMessage="Test Validation Message">
				<f:validateRegex pattern="[A-Za-z .,]+" />
				<f:validateLength maximum="50" />
			</h:inputText>

			<h:panelGroup>
				<h:outputLabel value="Diploma Year : " styleClass="small"/>	
				<br/>		
				<h:outputText value="e.g., 2010" style="color:gray" />
			</h:panelGroup>
			<h:inputText id="diplomaYear" style="width:200px"
			value="#{accountManagementController.userPersonalProfile.diplomaYear}">
				<f:validateRegex pattern="\d{4}" />
				<f:validateLength maximum="50" />
			</h:inputText>
			
			<h:outputLabel for="highSchool" value="High School : " styleClass="small"/>
			<h:inputText id="highSchool" style="width:200px"
			value="#{accountManagementController.userPersonalProfile.highSchool}">
				<f:validateRegex pattern="[A-Za-z .,]+" />
				<f:validateLength maximum="50" />
			</h:inputText>
			
			<h:outputLabel for="highSchoolCity" value="High School City : " styleClass="small"/>			
			<h:inputText id="highSchoolCity" style="width:200px"
			value="#{accountManagementController.userPersonalProfile.highSchoolCity}">
				<f:validateRegex pattern="[A-Za-z .,]+" />
				<f:validateLength maximum="50" />
			</h:inputText>
		
			<h:outputLabel for="highSchoolCounty" value="High School County : " styleClass="small"/>				
			<h:inputText id="highSchoolCounty" style="width:200px"
			value="#{accountManagementController.userPersonalProfile.highSchoolCounty}">
				<f:validateRegex pattern="[A-Za-z .,]+" />
				<f:validateLength maximum="50" />
			</h:inputText>
			<h:panelGroup>
				<h:commandButton id="edit_userpersonalprofile_button" value="Update"
				styleClass="buttonStyle" action="#{accountManagementController.editUserPersonalProfile}"/>
				
				<h:commandButton id="delete_userpersonalprofile_button" value="Delete"
				styleClass="buttonStyle" action="#{accountManagementController.removeUserPersonalProfileFromUser}">
					<a4j:support reRender="edit_userpersonalprofile_manager" limitToList="true"/>
				</h:commandButton>
				
			</h:panelGroup>
		</h:panelGrid>

	</h:form>
</f:subview>