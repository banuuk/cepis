<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a4j"%>
<link href="${facesContext.externalContext.requestContextPath}/css/datascroller.css"
	media="screen" rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:subview id="delete-email">
	<h:form id="remove_email_address_manager">
		<br />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Delete user email address details" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />

		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Email Address Details: " /></font>
			</h:panelGroup>
			<h:panelGroup id="emailAddressList">
				<h:selectOneListbox id="emailAddressListid"
					value="#{accountManagementController.selectedEmailAddress}"
					size="1" converter="#{EmailAddressDataConverter}"
					style="width: 200px;" required="true"
					requiredMessage="Email Address: Value is required.">
					<f:selectItem itemLabel="Select One" itemValue="" />
					<f:selectItems
						value="#{accountManagementController.emailAddressList}"
						var="emailAddress" itemLabel="#{emailAddress.address}" />
					<f:validator validatorId="EmailAddressDataValidator" />
				</h:selectOneListbox>
			</h:panelGroup>
			<h:message for="remove_email_address_button"></h:message>
			<h:commandButton id="remove_email_address_button" value="Remove"
				action="#{accountManagementController.removeEmailAddressFromUser}">
			</h:commandButton>
		</h:panelGrid>

	</h:form>
</f:subview>