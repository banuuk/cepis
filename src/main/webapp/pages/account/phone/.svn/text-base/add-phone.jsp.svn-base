<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:subview id="add-phone">
	<h:form>
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Add a new Phone number" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<br />
		<h:panelGrid columns="2" style="padding-right: 100px; padding-left: 100px">
			
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma">
					<h:outputText value="Phone no: *" />
				</font>
				<br />
				<h:outputText value="e.g., (859) 123-4567" style="color:gray" />
			</h:panelGroup>
			
			
			<h:inputText id="phoneno" value="#{accountManagementController.phoneNo}"
			style="width:200px" required="true"
			requiredMessage="Phone No: Value is required."
			validatorMessage="Phone no: Value is invalid.">
				<f:validateRegex pattern="\((\d{3})\) (\d{3})-(\d{4})" />
			</h:inputText>
			
			
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Extension : " /></font>
				<br />
				<h:outputText value="e.g., 1234" style="color:gray" />
			</h:panelGroup>
			<h:inputText value="#{accountManagementController.ext}"
				style="width:200px">
				<f:validateRegex pattern="\d+" />
				<f:validateLength maximum="50" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> 
					<h:outputText value="Phone Type : *"/>
				</font>
			</h:panelGroup>
			<h:selectOneListbox
				value="#{accountManagementController.selectedPhoneType}" size="1"
				converter="#{PhoneTypeDataConverter}" style="width:200px"
				required="true" requiredMessage="Phone Type: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems
					value="#{cepisGlobalComponentConfigurator.phoneTypeList}"
					var="phonetype" itemLabel="#{phonetype.desc}" />
				<f:validator validatorId="PhoneTypeDataValidator" />
			</h:selectOneListbox>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> 
					<h:outputText value="Short Description :"/>
				</font>
				<br>
				<h:outputText value="Short description for the drop-down box. Max 255 characters"
					style="color:gray"/>
			</h:panelGroup>
			<h:inputTextarea value="#{accountManagementController.shortDesc}"
				style="width:200px" rows="2">
				<f:validateLength minimum="0" maximum="255" />
			</h:inputTextarea>
			<h:message for="add_phone_type_button"></h:message>
			<h:commandButton id="add_phone_type_button" value="Add"
				action="#{accountManagementController.addPhoneToUser}"/>
		</h:panelGrid>
		<script type="text/javascript"
			src="${facesContext.externalContext.requestContextPath}/js/account.js"></script>
	</h:form>
</f:subview>
<script type="text/javascript">
	jQuery("input[id$=phoneno]").mask("(999) 999-9999");
</script>