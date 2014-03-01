<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a4j"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:view afterPhase="#{userDetailController.initApplicationComponent}">
	<h:message for="edit_emailaddresstype_manager">
	</h:message>
	<h:form id="edit_emailaddresstype_manager">
		<br />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/warning.gif"
				rendered="#{userDetailController.userDetailWarnStatus}" alt="!"
				title="Warning!" />
			<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
				value="#{userDetailController.userDetailStatusMessage}" /></font>
		</h:panelGrid>
		<hr />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Edit existing emailaddress type" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<br />
		<a4j:region selfRendered="true"
			ajaxListener="#{userDetailController.valueChangeEditEmailAddressType}"
			id="emailaddresstypelist_ajaxregion">
			<a4j:status startText="Loading ..." startStyleClass="loadingStatus" />
			<h:panelGrid columns="2"
				style="padding-right: 100px; padding-left: 100px">
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma">Select
					Major</font>
				</h:panelGroup>
				<h:selectOneListbox id="emailaddresstype_list_id"
					value="#{userDetailController.selectedEmailAddressType}" size="1"
					style="width:200px" converter="#{EmailAddressTypeDataConverter}">
					<f:selectItem itemLabel="Select One" itemValue="NA" />
					<f:selectItems
						value="#{cepisGlobalComponentConfigurator.emailAddressTypeList}"
						var="emailaddresstype" itemLabel="#{emailaddresstype.desc}" />
					<f:validator validatorId="EmailAddressTypeDataValidator" />
					<a4j:support event="onchange" reRender="code,shortDesc" />
				</h:selectOneListbox>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="Code:"></h:outputText></font>
					<br />
					<h:outputText value="e.g., ADMS-CA-901" style="color:gray" />
				</h:panelGroup>
				<h:inputText id="code" value="#{userDetailController.code}"
					style="width:200px"></h:inputText>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="Description:"></h:outputText></font>
					<br />
					<h:outputText
						value="Short description for the drop-down box. Max 255 characters"
						style="color:gray"></h:outputText>
				</h:panelGroup>
				<h:inputTextarea id="shortDesc"
					value="#{userDetailController.shortDesc}" style="width:200px"
					rows="2"></h:inputTextarea>
				<h:message for="edit_emailaddresstype_button"></h:message>
				<h:commandButton id="edit_emailaddresstype_button" value="Edit"
					action="#{userDetailController.editEmailAddressType}"></h:commandButton>
			</h:panelGrid>
		</a4j:region>
	</h:form>
</f:view>