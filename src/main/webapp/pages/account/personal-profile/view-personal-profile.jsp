<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:subview id="view-personal-profile">
	<br/>
	
	<h:outputLabel for="lineSeparator" value="View Personal Profile"  styleClass="medium-bold"/>
	<rich:separator id="lineSeparator" lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>		
		
	<h:form id="personalprofile_manager">
	
		<h:panelGrid columns="2" cellpadding="3" width="70%" style="padding-right: 100px; padding-left: 100px"
		columnClasses="label-col,output-col">	
		
			<h:outputLabel for="ethnicity" value="Ethnicity : " styleClass="small"/>
			<h:outputText id="ethnicity" value="#{accountManagementController.userPersonalProfile.ethnic.shortDesc}"/>
			
			<h:outputLabel for="citizenship" value="Citizenship :" styleClass="small"/>
			<h:outputText id="citizenship" value="#{accountManagementController.userPersonalProfile.citizen}"/>
			
			<h:outputLabel for="diplomaType" value="Diploma Type :" styleClass="small"/>
			<h:outputText id="diplomaType" value="#{accountManagementController.userPersonalProfile.diplomaType}"/>
			
			<h:outputLabel for="diplomaState" value="Diploma State :" styleClass="small"/>
			<h:outputText id="diplomaState" value="#{accountManagementController.userPersonalProfile.diplomaState}"/>
			
			<h:outputLabel for="diplomaYear" value="Diploma Year :" styleClass="small"/>
			<h:outputText id="diplomaYear" value="#{accountManagementController.userPersonalProfile.diplomaYear}"/>
			
			<h:outputLabel for="highSchool" value="High School :" styleClass="small"/>
			<h:outputText id="highSchool" value="#{accountManagementController.userPersonalProfile.highSchool}"/>
		
			<h:outputLabel for="highSchoolCity" value="High School City :" styleClass="small"/>
			<h:outputText id="highSchoolCity" value="#{accountManagementController.userPersonalProfile.highSchoolCity}"/>
		
			<h:outputLabel for="highSchoolCounty" value="High School County :" styleClass="small"/>
			<h:outputText id="highSchoolCounty" value="#{accountManagementController.userPersonalProfile.highSchoolCounty}"/>
		
		</h:panelGrid>
		
	</h:form>
</f:subview>