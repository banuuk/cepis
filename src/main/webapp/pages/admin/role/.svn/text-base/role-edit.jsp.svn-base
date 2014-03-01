<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a4j"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:view afterPhase="#{userDetailController.initApplicationComponent}">
	<h:message for="edit_role_manager">
	</h:message>
	<h:form id="edit_role_manager">
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
					value="Edit existing role" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<br />
		<a4j:region selfRendered="true"
			ajaxListener="#{userDetailController.valueChangeEditRole}"
			id="rolelist_ajaxregion">
			<a4j:status startText="Loading ..." startStyleClass="loadingStatus" />
			<h:panelGrid columns="2"
				style="padding-right: 100px; padding-left: 100px">
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma">Select
					Role:</font>
				</h:panelGroup>
				<h:selectOneListbox id="role_list_id"
					value="#{userDetailController.selectedRole}" size="1"
					style="width:200px" converter="#{RoleDataConverter}">
					<f:selectItem itemLabel="Select One" itemValue="NA" />
					<f:selectItems value="#{cepisGlobalComponentConfigurator.roleList}"
						var="role" itemLabel="#{role.rolename}" />
					<f:validator validatorId="RoleDataValidator" />
					<a4j:support event="onchange"
						reRender="rolename,roledesc,otherInfo" />
				</h:selectOneListbox>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="Role Name:"></h:outputText></font>
					<br />
					<h:outputText value="e.g., ROLE_" style="color:gray"></h:outputText>
				</h:panelGroup>
				<h:inputText id="rolename" value="#{userDetailController.rolename}"
					style="width:200px"></h:inputText>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="Role description:"></h:outputText><br />
					<h:outputText
						value="Short description for the Role. Max 255 characters"
						style="color:gray"></h:outputText></font>
				</h:panelGroup>
				<h:inputTextarea id="roledesc"
					value="#{userDetailController.roledesc}" style="width:200px"
					rows="2"></h:inputTextarea>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="Other information:"></h:outputText></font>
					<br />
					<h:outputText
						value="other information about the Role. Max 1000 characters"
						style="color:gray"></h:outputText>
				</h:panelGroup>
				<h:inputTextarea id="otherInfo"
					value="#{userDetailController.otherInfo}" style="width:200px"
					rows="3"></h:inputTextarea>&nbsp;&nbsp;&nbsp;&nbsp;
				<h:message for="edit_role_button"></h:message>
				<h:commandButton id="edit_role_button" value="Edit"
					action="#{userDetailController.editRole}"></h:commandButton>
			</h:panelGrid>
		</a4j:region>
	</h:form>
</f:view>