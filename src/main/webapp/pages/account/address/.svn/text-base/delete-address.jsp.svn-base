<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<link href="${facesContext.externalContext.requestContextPath}/css/datascroller.css"
	media="screen" rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:subview id="delete-address">
	<h:form>
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Delete user address details" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />

		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Address Details: *" /></font>
			</h:panelGroup>
			<h:panelGroup>
				<h:selectOneListbox
					value="#{accountManagementController.selectedAddress}" size="1"
					converter="#{AddressDataConverter}" style="width: 200px;"
					required="true" requiredMessage="Address: Value is required">
					<f:selectItem itemLabel="Select One" itemValue="" />
					<f:selectItems value="#{accountManagementController.addressList}"
						var="address"
						itemLabel="#{address.street1} #{address.street2}, #{address.city}, #{address.state} - #{address.zip}, #{address.country}" />
					<f:validator validatorId="AddressDataValidator" />
				</h:selectOneListbox>
			</h:panelGroup>
			<h:message for="remove_address_button"></h:message>
			<h:commandButton id="remove_address_button" value="Remove"
				action="#{accountManagementController.removeAddressFromUser}">
			</h:commandButton>
		</h:panelGrid>
	</h:form>
</f:subview>