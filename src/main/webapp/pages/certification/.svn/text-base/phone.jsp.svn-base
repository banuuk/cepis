<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<link href="${facesContext.externalContext.requestContextPath}/css/datascroller.css"
	media="screen" rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:subview id="edit-phone">
	<h:form id="editPhone_form" styleClass="styleish">
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma">
					<h:outputText value="Edit user phone information" />
				</font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<h:panelGrid columns="2" cellpadding="5" style="padding-right: 50px; padding-left: 50px">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma">
					<h:outputText value="Phone Information : " />
				</font>
			</h:panelGroup>
			<h:selectOneListbox
			value="#{certificationController.selectedPhone}" size="1"
			converter="#{PhoneDataConverter}" style="width: 200px;"
			required="true"
			requiredMessage="Phone information: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems value="#{certificationController.phoneList}"
				var="phone" itemLabel="#{phone.phoneNo}" />
				<f:validator validatorId="PhoneDataValidator" />
				<a4j:support event="onchange" ajaxSingle="true"
				actionListener="#{certificationController.valueChangeEditPhone}"
				reRender="edit_phone_no,edit_phone_ext,edit_phone_memo" />
			</h:selectOneListbox>
			
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma">
					<h:outputText value="Phone no : *" />
				</font>
				<br />
				<h:outputText value="e.g., (859) 123-4567" style="color:gray" />
			</h:panelGroup>
			
			<h:inputText id="edit_phone_no"
			requiredMessage="Phone No: Value is required."
			validatorMessage="Phone No: Value is invalid."
			value="#{certificationController.phoneNo}" style="width:200px"
			required="true" >
				<f:validateRegex pattern="\((\d{3})\) (\d{3})-(\d{4})" />
			</h:inputText>
			
			
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma">
					<h:outputText value="Extension : " />
				</font>
				<br />
				<h:outputText value="e.g., 1234" style="color:gray" />
			</h:panelGroup>
			<h:inputText id="edit_phone_ext"
			value="#{certificationController.ext}" style="width:200px">
				<f:validateRegex pattern="\d+" />
				<f:validateLength maximum="50" />
			</h:inputText>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> 
					<h:outputText value="Phone Type : *"/>
				</font>
			</h:panelGroup>
			<h:selectOneMenu id="edit_phone_memo"
			value="#{certificationController.selectedPhoneType}"
			converter="#{PhoneTypeDataConverter}" style="width:200px"
			required="true">
				<f:selectItem itemLabel="Select One" itemValue="" />
				<f:selectItems
				value="#{cepisGlobalComponentConfigurator.phoneTypeList}"
				var="phonetype" itemLabel="#{phonetype.desc}" />
				<f:validator validatorId="PhoneTypeDataValidator" />
			</h:selectOneMenu>
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> 
					<h:outputText value="Short Description :"/>
				</font>
				<br />
				<h:outputText value="Short description for Phone Type" style="color:gray"/>
			</h:panelGroup>
			<h:inputTextarea value="#{certificationController.shortDesc}"
			style="width:200px" rows="2">
				<f:validateLength minimum="0" maximum="255" />
			</h:inputTextarea>
			<h:panelGroup>
				<h:commandButton id="add_phone_type_button" value="Add" styleClass="buttonStyle"
				action="#{accountManagementController.addPhoneToUser}"/>
				<h:commandButton id="edit_phone_button" value="Update" styleClass="buttonStyle"
				action="#{certificationController.editPhoneDetail}">
				</h:commandButton>
				<a4j:commandButton id="delete_phone_button" value="Delete" styleClass="buttonStyle"
				action="#{certificationController.removePhoneFromUser}"
				reRender="editPhone_form" limitToList="true"/>
			</h:panelGroup>
		</h:panelGrid>
		
	</h:form>
	
</f:subview>

<!-- ******************************PHONE NUMBER JQUERY AUTO FILL****************************** -->
<script type="text/javascript"
	src="${facesContext.externalContext.requestContextPath}/js/account.js"></script>
<script type="text/javascript"
	src="${facesContext.externalContext.requestContextPath}/js/jquery.maskedinput-1.2.2.js"></script>
<script type="text/javascript">
	jQuery("input[id$=edit_phone_no]").mask("(999) 999-9999");
</script>
<!-- ****************************************************************************************** -->