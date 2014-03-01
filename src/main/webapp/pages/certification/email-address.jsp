<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<link href="${facesContext.externalContext.requestContextPath}/css/datascroller.css"
	media="screen" rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:subview id="edit-email">
	<h:form id="edit_email_address_manager" styleClass="styleish">
		<br />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Edit user email address information" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />

		<h:panelGrid columns="2" cellpadding="5" style="padding-right: 50px; padding-left: 50px">

			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Email Address Information: " /></font>
			</h:panelGroup>

			<h:selectOneMenu id="emailAddressListid"
				value="#{certificationController.selectedEmailAddress}"
				converter="#{EmailAddressDataConverter}" style="width: 200px;"
				required="true"
				requiredMessage="Email Address Information: Value is required."
				converterMessage="convert error" validatorMessage="invalid">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems
					value="#{certificationController.emailAddressList}"
					var="emailAddress" itemLabel="#{emailAddress.address}" />
				<f:validator validatorId="EmailAddressDataValidator" />
				<a4j:support event="onchange" ajaxSingle="true"
					actionListener="#{certificationController.valueChangeEditEmailAddress}"
					reRender="address,emailtypelistid" />
			</h:selectOneMenu>

			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Email Address : *" /></font>
				<br />
				<h:outputText value="mail@example.com" style="color:gray" />
			</h:panelGroup>

				<h:inputText id="address"
					value="#{certificationController.emailAddress}" style="width:200px"
					required="true" requiredMessage="Address: Value is required."
					validatorMessage="Address: Value is invalid.">
					<f:validateRegex
						pattern="[_a-zA-Z0-9-]+(\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.(([0-9]{1,3})|([a-zA-Z]{2,3})|(aero|coop|info|museum|name))" />
					<f:validateLength maximum="255" />
				</h:inputText>

			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Email Address Type : *"></h:outputText></font>
				<br>
				<h:outputText value="Type of Email Address Information"
					style="color:gray"></h:outputText>
			</h:panelGroup>
			<h:selectOneMenu id="emailtypelistid" onclick="sumbit()"
				immediate="true"
				value="#{certificationController.selectedEmailAddressType}"
				converter="#{EmailAddressTypeDataConverter}" style="width:200px"
				required="true" requiredMessage="Email Address Type is required"
				converterMessage="convert error" validatorMessage="invalid">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.emailAddressTypeList}"
					var="emailAddresstype" itemLabel="#{emailAddresstype.desc}" />
				<f:validator validatorId="EmailAddressTypeDataValidator" />
			</h:selectOneMenu>
			<h:panelGroup>
				<h:commandButton id="add_email_address_button" value="Add" styleClass="buttonStyle"
				action="#{certificationController.addEmailAddressToUser}">
				</h:commandButton>
				<h:commandButton id="edit_email_address_button" value="Update" styleClass="buttonStyle"
				action="#{certificationController.editEmailAddressDetail}">
				</h:commandButton>			
				<a4j:commandButton id="remove_email_address_button" value="Delete" styleClass="buttonStyle"
				action="#{certificationController.removeEmailAddressFromUser}"
				reRender="edit_email_address_manager" limitToList="true"/>
			</h:panelGroup>
		</h:panelGrid>
	</h:form>
</f:subview>