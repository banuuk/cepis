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
<f:subview id="edit-address">
	<h:form id="editAddress_form" styleClass="styleish">
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Edit user address information" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<h:panelGrid columns="2" cellpadding="5" style="padding-right: 50px; padding-left: 50px">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Address Information : " /></font>
			</h:panelGroup>
				<h:selectOneListbox
					value="#{certificationController.selectedAddress}" size="1"
					converter="#{AddressDataConverter}" style="width: 200px;"
					required="true" requiredMessage="Address: Value is required.">
					<f:selectItem itemLabel="Select One" itemValue="NA" />
					<f:selectItems value="#{certificationController.addressList}"
						var="address"
						itemLabel="#{address.street1} #{address.street2}, #{address.city}, #{address.state} - #{address.zip}, #{address.country}" />
					<f:validator validatorId="AddressDataValidator" />
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{certificationController.valueChangeEditAddress}"
						reRender="edit_address_street1,edit_address_street2,edit_address_city,edit_address_state,edit_address_zip,edit_address_country,edit_address_addresstypelist" />
				</h:selectOneListbox>

			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Street Address 1 : *" /></font>
				<br />
				<h:outputText value="Max 150 chars" style="color:gray" />
			</h:panelGroup>
			<h:inputText id="edit_address_street1"
				value="#{certificationController.street1}" style="width:200px"
				required="true" requiredMessage="Street1: Value is required.">
				<f:validateLength maximum="150" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Street Address 2 : " /></font>
				<br />
				<h:outputText value="Max 150 chars" style="color:gray" />
			</h:panelGroup>
			<h:inputText id="edit_address_street2"
				value="#{certificationController.street2}" style="width:200px">
				<f:validateLength minimum="0" maximum="150" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="City : *" /></font>
				<br />
				<h:outputText value="Max 50 chars" style="color:gray" />
			</h:panelGroup>
			<h:inputText id="edit_address_city"
				value="#{certificationController.city}" style="width:200px"
				required="true" requiredMessage="City: Value is required.">
				<f:validateLength maximum="50" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="State : *" /></font>
				<br />
				<h:outputText value="Max 20 chars" style="color:gray" />
			</h:panelGroup>
			<rich:comboBox id="edit_address_state" value="#{certificationController.state}"
				style="width:200px" required="true"
				requiredMessage="State: Value is required."
				suggestionValues="#{cepisGlobalComponentConfigurator.states}"
				directInputSuggestions="true" selectFirstOnUpdate="true">
			</rich:comboBox>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Zip : *" /></font>
				<br />
				<h:outputText value="Max 10 chars" style="color:gray" />
			</h:panelGroup>
			<h:inputText id="edit_address_zip"
				value="#{certificationController.zip}" style="width:200px"
				required="true" requiredMessage="Zip code: : Value is required.">
				<f:validateLength minimum="5" maximum="10" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Country : *" /></font>
				<br />
				<h:outputText value="Max 50 chars" style="color:gray" />
			</h:panelGroup>
			<h:selectOneListbox id="edit_address_country"
				value="#{certificationController.country}" size="1" style="width:200px"
				required="true" requiredMessage="Country: Value is required.">
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.countries}"
					var="country" itemLabel="#{country}" />
			</h:selectOneListbox>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Address Type : *"></h:outputText></font>
				<br />
				<h:outputText value="Address Type" style="color:gray"></h:outputText>
			</h:panelGroup>
			<h:selectOneMenu id="edit_address_addresstypelist"
				value="#{certificationController.selectedAddressType}"
				converter="#{AddressTypeDataConverter}" style="width:200px"
				required="true" requiredMessage="Address Type: : Value is required." >
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.addressTypeList}"
					var="addresstype" itemLabel="#{addresstype.desc}" />
				<f:validator validatorId="AddressTypeDataValidator" />
			</h:selectOneMenu>
			<h:panelGroup>
			<h:commandButton id="add_address_type_button" value="Add" styleClass="buttonStyle"
			action="#{accountManagementController.addAddressToUser}"/>
			<h:commandButton id="edit_address_button" value="Update" styleClass="buttonStyle"
			action="#{certificationController.editAddressDetail}"/>
			<a4j:commandButton id="remove_address_button" value="Remove" styleClass="buttonStyle"
			action="#{accountManagementController.removeAddressFromUser}"
			reRender="editAddress_form" limitToList="true"/>
			</h:panelGroup>
		</h:panelGrid>
	</h:form>
</f:subview>