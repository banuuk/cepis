<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<link
	href="${facesContext.externalContext.requestContextPath}/css/font.css"
	media="screen" rel="stylesheet" type="text/css" />
<link
	href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css" />
<f:subview id="edit-user">
	<h:form id="edit_user_manager">
		<br />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="Edit this CEPIS user account" /> <h:outputText
						value="#{accountManagementController.userData}"></h:outputText></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<br />
		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="UK ID: *" /></font>
				<br />
				<h:outputText value="Without 9 e.g., 12345678" style="color:gray" />
			</h:panelGroup>
			<h:inputText id="ukid" value="#{accountManagementController.ukID}"
				style="width:200px" required="true"
				requiredMessage="UK ID: Value is required."
				validatorMessage="UK ID: Value is invalid.">
				<f:validateRegex pattern="\d{8}" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="SSN: " /></font>
				<br />
				<h:outputText value="e.g., 111111111" style="color:gray" />
			</h:panelGroup>
			<h:inputSecret id="ssn" redisplay="true"
				value="#{accountManagementController.ssn}" style="width:200px"
				validatorMessage="SSN: Invalid format.">
				<f:validateRegex pattern="\d{9}" />
			</h:inputSecret>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Link Blue Username: *" /></font>
				<br />
				<h:outputText value="Max 15 chars" style="color:gray" />
			</h:panelGroup>
			<h:inputText value="#{accountManagementController.username}"
				style="width:200px" required="true"
				requiredMessage="User name: Value is required.">
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Last Name: *" /></font>
				<br />
				<h:outputText value="Max 50 chars" style="color:gray" />
			</h:panelGroup>
			<h:inputText value="#{accountManagementController.lName}"
				style="width:200px" required="true"
				requiredMessage="Last name: Value is required.">
				<f:validateLength maximum="50" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Last Name #1: " /></font>
				<br />
				<h:outputText value="Max 50 chars" style="color:gray" />
			</h:panelGroup>
			<h:inputText value="#{accountManagementController.lName1}"
				style="width:200px">
				<f:validateLength maximum="50" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Last Name #2: " /></font>
				<br />
				<h:outputText value="Max 50 chars" style="color:gray" />
			</h:panelGroup>
			<h:inputText value="#{accountManagementController.lName2}"
				style="width:200px">
				<f:validateLength maximum="50" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Last Name #3: " /></font>
				<br />
				<h:outputText value="Max 50 chars" style="color:gray" />
			</h:panelGroup>
			<h:inputText value="#{accountManagementController.lName3}"
				style="width:200px">
				<f:validateLength maximum="50" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Last Name #4: " /></font>
				<br />
				<h:outputText value="Max 50 chars" style="color:gray" />
			</h:panelGroup>
			<h:inputText value="#{accountManagementController.lName4}"
				style="width:200px">
				<f:validateLength maximum="50" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="First Name: *" /></font>
				<br />
				<h:outputText value="Max 50 chars" style="color:gray" />
			</h:panelGroup>
			<h:inputText value="#{accountManagementController.fName}"
				style="width:200px" required="true"
				requiredMessage="First name: Value is required.">
				<f:validateLength maximum="50" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Middle Name: " /></font>
				<br />
				<h:outputText value="Max 30 chars" style="color:gray" />
			</h:panelGroup>
			<h:inputText value="#{accountManagementController.mName}"
				style="width:200px"
				validatorMessage="Middle name: Value is invalid.">
				<f:validateLength maximum="30" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Preferred Name: " /></font>
				<br />
				<h:outputText
					value="(Nickname) E.g., An abbreviated form of your <br/> legal first name (e.g. Bob, Tina, Mike, CJ). <br/> Max 50 chars. "
					style="color:gray" escape="false" />
			</h:panelGroup>
			<h:inputText id="preferredName"
				value="#{accountManagementController.preferredName}"
				style="width:200px" >
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Maiden Name: " /></font>
				<br />
				<h:outputText value="Max 50 chars" style="color:gray" />
			</h:panelGroup>
			<h:inputText value="#{accountManagementController.maidenName}"
				style="width:200px"
				validatorMessage="Maiden name: Value is invalid.">
				<f:validateLength maximum="50" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Suffix: " /></font>
				<br />
				<h:outputText value="Max 50 chars" style="color:gray" />
			</h:panelGroup>
			<h:inputText value="#{accountManagementController.suffix}"
				style="width:200px" validatorMessage="Suffix: Value is invalid.">
				<f:validateLength maximum="50" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Gender: " /></font>
				<br />
				<h:outputText value="Max 50 chars" style="color:gray" />
			</h:panelGroup>
			<h:selectOneMenu value="#{accountManagementController.gender}"
				style="width:200px">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItem itemLabel="Male" itemValue="Male" />
				<f:selectItem itemLabel="Female" itemValue="Female" />
			</h:selectOneMenu>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Title: " /></font>
				<br />
				<h:outputText value="Max 50 chars" style="color:gray" />
			</h:panelGroup>
			<h:inputText value="#{accountManagementController.title}"
				style="width:200px" validatorMessage="Title: Value is invalid.">
				<f:validateLength maximum="50" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Date of Birth: " /></font>
				<br />
				<h:outputText value="MM/dd/YYYY" style="color:gray" />
			</h:panelGroup>
			<h:inputText id="birthdate"
				value="#{accountManagementController.dOB}" style="width:200px"
				validatorMessage="Birth date: Invalid format. Use mm/dd/yyyy">
				<f:convertDateTime pattern="MM/dd/yyyy" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Badge Holder: " /></font>
				<br />
				<h:outputText value="UK COE Badge" style="color:gray" />
			</h:panelGroup>
			<h:selectOneMenu value="#{accountManagementController.badgeHolder}"
				style="width:200px">
				<f:selectItem itemLabel="No" itemValue="0" />
				<f:selectItem itemLabel="Yes" itemValue="1" />
			</h:selectOneMenu>
			<h:message for="edit_user_button"></h:message>
			<h:commandButton id="edit_user_button" value="Save"
				action="#{accountManagementController.editUser}"></h:commandButton>
		</h:panelGrid>
	</h:form>
</f:subview>
<script type="text/javascript">
	jQuery("input[id$=ukid]").mask("99999999");
	jQuery("input[id$=birthdate]").mask("99/99/9999");
</script>