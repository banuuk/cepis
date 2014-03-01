<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a4j"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:view afterPhase="#{userDetailController.initApplicationComponent}">
	<h:message for="edit_ukterm_manager">
	</h:message>
	<h:form id="edit_ukterm_manager">
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
					value="Edit existing term" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<br />
		<a4j:region selfRendered="true"
			ajaxListener="#{userDetailController.valueChangeEditUKTerm}"
			id="uktermlist_ajaxregion">
			<a4j:status startText="Loading ..." startStyleClass="loadingStatus" />
			<h:panelGrid columns="2"
				style="padding-right: 100px; padding-left: 100px">
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma">Select
					Term:</font>
				</h:panelGroup>
				<h:selectOneListbox id="ukterm_list_id"
					value="#{userDetailController.selectedUKTerm}" size="1"
					style="width:200px" converter="#{UKTermDataConverter}">
					<f:selectItem itemLabel="Select One" itemValue="NA" />
					<f:selectItems
						value="#{cepisGlobalComponentConfigurator.ukTermList}"
						var="ukTerm" itemLabel="#{ukTerm.shortDesc}" />
					<f:validator validatorId="UKTermDataValidator" />
					<a4j:support event="onchange"
						reRender="code,shortDesc,description,status,degreeLevel" />
				</h:selectOneListbox>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="UKTerm Code:"></h:outputText></font>
					<br>
					<h:outputText value="e.g., ADMS-CA-901" style="color:gray"></h:outputText>
				</h:panelGroup>
				<h:inputText id="code" value="#{userDetailController.code}"
					style="width:200px"></h:inputText>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="UKTerm short description:"></h:outputText></font>
					<br />
					<h:outputText
						value="Short description for the drop-down box. Max 255 characters"
						style="color:gray"></h:outputText>
				</h:panelGroup>
				<h:inputTextarea id="shortDesc"
					value="#{userDetailController.shortDesc}" style="width:200px"
					rows="2"></h:inputTextarea>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="UKTerm description:"></h:outputText></font>
					<br />
					<h:outputText
						value="General description about the UKTerm. Max 1000 characters"
						style="color:gray"></h:outputText>
				</h:panelGroup>
				<h:inputTextarea id="description" style="width:200px" rows="3"
					value="#{userDetailController.description}"></h:inputTextarea>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="UKTerm status:"></h:outputText></font>
					<br>
					<h:outputText
						value="Status of the ukterm. possible values - current,old,unknown"
						style="color:gray"></h:outputText>
				</h:panelGroup>
				<h:inputText id="status" value="#{userDetailController.status}"
					style="width:200px"></h:inputText>
				<h:message for="edit_ukterm_button"></h:message>
				<h:commandButton id="edit_ukterm_button" value="Edit"
					action="#{userDetailController.editUKTerm}"></h:commandButton>
			</h:panelGrid>
		</a4j:region>
	</h:form>
</f:view>