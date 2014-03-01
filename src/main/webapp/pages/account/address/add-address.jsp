<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:subview id="add-address">
	<h:form>
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Add a new Address" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<br />
		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">

			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Street Address 1: *" /></font>
				<br />
				<h:outputText value="Max 150 chars" style="color:gray" />
			</h:panelGroup>
			<h:inputText value="#{accountManagementController.street1}"
				style="width:200px" required="true"
				requiredMessage="Street1: Value is required.">
				<f:validateLength maximum="150" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Street Address 2: " /></font>
				<br />
				<h:outputText value="Max 150 chars" style="color:gray" />
			</h:panelGroup>
			<h:inputText value="#{accountManagementController.street2}"
				style="width:200px">
				<f:validateLength minimum="0" maximum="150" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="City : *" /></font>
				<br />
				<h:outputText value="Max 50 chars" style="color:gray" />
			</h:panelGroup>
			<h:inputText value="#{accountManagementController.city}"
				style="width:200px" required="true"
				requiredMessage="City: Value is required.">
				<f:validateLength maximum="50" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="State : *" /></font>
				<br />
				<h:outputText value="Max 20 chars" style="color:gray" />
			</h:panelGroup>
			<rich:comboBox value="#{accountManagementController.state}"
				style="width:200px" required="true"
				requiredMessage="State: Value is required."
				suggestionValues="#{cepisGlobalComponentConfigurator.states}"
				directInputSuggestions="true" selectFirstOnUpdate="true"
				defaultLabel="Select One">
			</rich:comboBox>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Zip Code: *" /></font>
				<br />
				<h:outputText value="e.g., 12345" style="color:gray" />
			</h:panelGroup>
			<h:inputText value="#{accountManagementController.zip}"
				style="width:200px" required="true"
				requiredMessage="Zip code: Value is required.">
				<f:validateLength minimum="5" maximum="10" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Country : *" /></font>
				<br />
				<h:outputText value="Max 50 chars" style="color:gray" />
			</h:panelGroup>
			<h:selectOneListbox id="country_list_id"
				value="#{accountManagementController.country}" size="1"
				style="width:200px" required="true"
				requiredMessage="Country: Value is required.">
				<f:selectItems value="#{cepisGlobalComponentConfigurator.countries}"
					var="country" itemLabel="#{country}" />
			</h:selectOneListbox>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Address Type : *"></h:outputText></font>
				<br>
				<h:outputText value="Type of Address" style="color:gray"></h:outputText>
			</h:panelGroup>
			<h:selectOneListbox
				value="#{accountManagementController.selectedAddressType}" size="1"
				converter="#{AddressTypeDataConverter}" style="width:200px"
				required="true" requiredMessage="Address Type: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.addressTypeList}"
					var="addresstype" itemLabel="#{addresstype.desc}" />
				<f:validator validatorId="AddressTypeDataValidator" />
			</h:selectOneListbox>
			<h:message for="add_address_type_button"></h:message>
			<h:commandButton id="add_address_type_button" value="Add"
				action="#{accountManagementController.addAddressToUser}"></h:commandButton>
		</h:panelGrid>
	</h:form>
</f:subview>