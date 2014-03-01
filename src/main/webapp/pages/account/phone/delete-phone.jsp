<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<link href="${facesContext.externalContext.requestContextPath}/css/datascroller.css"
	media="screen" rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:subview id="delete-phone">
	<h:form>
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Delete user phone information" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />

		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Phone Information: " /></font>
			</h:panelGroup>
			<h:panelGroup>
				<h:selectOneListbox
					value="#{accountManagementController.selectedPhone}" size="1"
					converter="#{PhoneDataConverter}" style="width: 200px;"
					required="true"
					requiredMessage="Phone information: Value is required.">
					<f:selectItem itemLabel="Select One" itemValue="" />
					<f:selectItems value="#{accountManagementController.phoneList}"
						var="phone" itemLabel="#{phone.phoneNo}" />
					<f:validator validatorId="PhoneDataValidator" />
				</h:selectOneListbox>
			</h:panelGroup>
			<h:message for="remove_phone_button"></h:message>
			<h:commandButton id="remove_phone_button" value="Remove"
				action="#{accountManagementController.removePhoneFromUser}">
			</h:commandButton>
		</h:panelGrid>

	</h:form>
</f:subview>