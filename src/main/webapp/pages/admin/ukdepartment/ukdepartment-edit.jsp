<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a4j"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:view afterPhase="#{appComponentController.initApplicationComponent}">
	<h:message for="edit_ukdepartment_manager">
	</h:message>
	<h:form id="edit_ukdepartment_manager">
		<br />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/warning.gif"
				rendered="#{appComponentController.appComponentWarnStatus}" alt="!"
				title="Warning!" />
			<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
				value="#{appComponentController.appComponentStatusMessage}" /></font>
		</h:panelGrid>
		<hr />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Edit existing ukdepartment" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<br />
		<a4j:region selfRendered="true"
			ajaxListener="#{appComponentController.valueChangeEditUKDepartment}"
			id="ukdepartmentlist_ajaxregion">
			<a4j:status startText="Loading ..." startStyleClass="loadingStatus" />
			<h:panelGrid columns="2"
				style="padding-right: 100px; padding-left: 100px">
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma">Select
					UKDepartment:</font>
				</h:panelGroup>
				<h:selectOneListbox id="ukdepartment_list_id"
					value="#{appComponentController.selectedUKDepartment}" size="1"
					converter="#{UKDepartmentDataConverter}" style="width:200px">
					<f:selectItem itemLabel="Select One" itemValue="NA" />
					<f:selectItems
						value="#{cepisGlobalComponentConfigurator.ukDepartmentList}"
						var="ukdepartment" itemLabel="#{ukdepartment.departmentName}" />
					<f:validator validatorId="UKDepartmentDataValidator" />
					<a4j:support event="onchange"
						reRender="code,name,address,phone,chair,shortDesc,status,speedSort" />
				</h:selectOneListbox>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="Dept. Code:"></h:outputText></font>
					<br />
					<h:outputText value="e.g., ADMS-CA-901" style="color:gray"></h:outputText>
				</h:panelGroup>
				<h:inputText id="code" disabled="true" value="#{appComponentController.code}"
					style='width:200px'></h:inputText>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="Dept. Name:"></h:outputText></font>
					<br />
					<h:outputText value="Max 255 characters" style="color:gray"></h:outputText>
					<br />
				</h:panelGroup>
				<h:inputText id="name"
					value="#{appComponentController.departmentName}"
					style='width:200px'></h:inputText>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="Dept. Address:"></h:outputText></font>
					<br />
					<h:outputText value="Max 255 characters" style="color:gray"></h:outputText>
					<br />
				</h:panelGroup>
				<h:inputText id="address"
					value="#{appComponentController.departmentAddress}"
					style='width:200px'></h:inputText>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="Dept. Phone:"></h:outputText></font>
					<br />
					<h:outputText value="Max 255 characters" style="color:gray"></h:outputText>
					<br />
				</h:panelGroup>
				<h:inputText id="phone" value="#{appComponentController.phone}"
					style='width:200px'></h:inputText>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="Dept. Chair Name:"></h:outputText></font>
					<br />
					<h:outputText value="Max 255 characters" style="color:gray"></h:outputText>
					<br />
				</h:panelGroup>
				<h:inputText id="chair"
					value="#{appComponentController.departmentChairName}"
					style='width:200px'></h:inputText>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="Short description:"></h:outputText></font>
					<br />
					<h:outputText
						value="Short description for the drop-down box. Max 255 characters"
						style="color:gray"></h:outputText>
					<br />
				</h:panelGroup>
				<h:inputTextarea id="shortDesc"
					value="#{appComponentController.shortDesc}" style='width:200px'
					rows="2"></h:inputTextarea>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="Status:"></h:outputText></font>
					<br />
					<h:outputText value="Max 30 characters" style="color:gray"></h:outputText>
					<br />
				</h:panelGroup>
				<h:inputText id="status" value="#{appComponentController.status}"
					style='width:200px'></h:inputText>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="Sort Info:"></h:outputText></font>
					<br />
					<h:outputText value="Max 255 characters" style="color:gray"></h:outputText>
					<br />
				</h:panelGroup>
				<h:inputText id="speedSort"
					value="#{appComponentController.speedSort}" style='width:200px'></h:inputText>
				<h:message for="edit_ukdepartment_button"></h:message>
				<h:commandButton id="edit_ukdepartment_button" value="Edit"
					action="#{appComponentController.editUKDepartment}"></h:commandButton>
			</h:panelGrid>
		</a4j:region>
	</h:form>
</f:view>