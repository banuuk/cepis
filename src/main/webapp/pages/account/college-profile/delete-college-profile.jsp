<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<f:subview id="delete-college-profile">
	<h:form id="remove_collegeprofile_manager" styleClass="styleish">
	
		<h:outputLabel for="collegeProfileDelete-separator" value="Delete User College Profile" styleClass="medium-bold"/>	
		<rich:separator id="collegeProfileDelete-separator" lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>
		
		<h:panelGrid columns="2" style="padding-right: 100px; padding-left: 100px">
		
			<h:outputLabel for="collegeProfile_List" styleClass="small" value="User College Profile Information : " />
			<h:selectOneListbox id="collegeProfile_List"
			value="#{accountManagementController.selectedUserCollegeProfile}"
			size="1" converter="#{UserCollegeProfileDataConverter}"
			style="width: 400px;" required="true"
			requiredMessage="User College Profile: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems value="#{accountManagementController.userCollegeProfileList}"
				var="collegeprofile" itemLabel="#{collegeprofile.ukCollege} - #{collegeprofile.ukDepartment} - #{collegeprofile.userClassification}" />
				<f:validator validatorId="UserCollegeProfileDataValidator" />
			</h:selectOneListbox>
			
			<h:message for="remove_collegeprofile_button"/>
			<h:commandButton id="remove_collegeprofile_button" value="Delete" styleClass="buttonStyle"
			action="#{accountManagementController.removeUserCollegeProfileFromUser}"/>
		</h:panelGrid>

	</h:form>
</f:subview>