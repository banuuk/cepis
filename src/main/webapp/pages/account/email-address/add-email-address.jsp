<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:subview id="add-email">
	<h:form id="add_email_address_manager">
		<br />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Add a new Email Address" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<br />
		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">

			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Email Address: *" /></font>
				<br />
				<h:outputText value="pat@example.com" style="color:gray" />
			</h:panelGroup>
			<h:inputText id="emailaddress" value="#{accountManagementController.address}"
				style="width:200px" required="true"
				requiredMessage="Email Address: Value is required."
				validatorMessage="Email Address: Value is invalid.">
				<f:validateRegex
					pattern="[_a-zA-Z0-9-]+(\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.(([0-9]{1,3})|([a-zA-Z]{2,3})|(aero|coop|info|museum|name))" />
				<f:validateLength maximum="255" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Email Address Type : *"></h:outputText></font>
			</h:panelGroup>
			<h:selectOneListbox id="email_addresstype_list_id"
				value="#{accountManagementController.selectedEmailAddressType}"
				size="1" converter="#{EmailAddressTypeDataConverter}"
				style="width:200px" required="true"
				requiredMessage="Email Address Type: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.emailAddressTypeList}"
					var="emailaddresstype" itemLabel="#{emailaddresstype.desc}" />
				<f:validator validatorId="EmailAddressTypeDataValidator" />
			</h:selectOneListbox>
			<h:message for="add_emailaddress_type_button"></h:message>
			<h:commandButton id="add_emailaddress_type_button" value="Add"
				action="#{accountManagementController.addEmailAddressToUser}"></h:commandButton>
		</h:panelGrid>
	</h:form>
</f:subview>