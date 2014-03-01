<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<link href="${facesContext.externalContext.requestContextPath}/css/datascroller.css"
	media="screen" rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:subview id="delete-program-profile">
	<h:form id="remove_programprofile_manager">
		<br />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Delete user program profile information" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />

		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="User Program Profile Information: " /></font>
			</h:panelGroup>
			<h:panelGroup id="programProfileList">
				<h:selectOneListbox id="programProfileListid"
					value="#{accountManagementController.selectedUserProgramProfile}"
					size="1" converter="#{UserProgramProfileDataConverter}"
					style="width: 400px;" required="true"
					requiredMessage="User program profile: Value is required.">
					<f:selectItem itemLabel="Select One" itemValue="" />
					<f:selectItems
						value="#{accountManagementController.userProgramProfileList}"
						var="programprofile" itemLabel="#{programprofile.program} - #{programprofile.programDomain}" />
					<f:validator validatorId="UserProgramProfileDataValidator" />
				</h:selectOneListbox>
			</h:panelGroup>
			<h:message for="remove_programprofile_button"></h:message>
			<h:commandButton id="remove_programprofile_button" value="Remove"
				action="#{accountManagementController.removeUserProgramProfileFromUser}">
			</h:commandButton>
		</h:panelGrid>
	</h:form>
</f:subview>