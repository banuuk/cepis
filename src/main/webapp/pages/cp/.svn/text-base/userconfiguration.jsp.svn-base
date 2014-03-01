<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:subview id="userconfiguration">
	<h:form>
	<rich:messages style="color:red;"></rich:messages>
	<br/>
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Primary Contact Information" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<br />
		<h:panelGrid columns="2">

			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value=" Email Address: *" /></font>
			</h:panelGroup>
			<h:selectOneListbox
				value="#{accountManagementController.primaryEmailAddress}" size="1"
				converter="#{EmailAddressDataConverter}" style="width:200px"
				required="true" requiredMessage="Email Address: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems
					value="#{accountManagementController.emailAddressList}"
					var="emailaddress"
					itemLabel="#{emailaddress.address} (#{emailaddress.type})" />
				<f:validator validatorId="EmailAddressDataValidator" />
			</h:selectOneListbox>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value=" Phone Number: " /></font>
			</h:panelGroup>
			<h:selectOneListbox
				value="#{accountManagementController.primaryPhone}" size="1"
				converter="#{PhoneDataConverter}" style="width:200px"
				required="true" requiredMessage="Phone: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems value="#{accountManagementController.phoneList}"
					var="phone" itemLabel="#{phone.phoneNo} (#{phone.phoneType})" />
				<f:validator validatorId="EmailAddressDataValidator" />
			</h:selectOneListbox>
			<a4j:commandButton value="Save" reRender="contact"
				action="#{accountManagementController.updateUserConfiguration}"
				oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('userconf')}.hide();"></a4j:commandButton>
		</h:panelGrid>
	</h:form>
</f:subview>