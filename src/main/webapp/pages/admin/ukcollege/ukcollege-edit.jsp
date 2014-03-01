<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a4j"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:view afterPhase="#{appComponentController.initApplicationComponent}">
	<h:message for="edit_ukcollege_manager">
	</h:message>
	<h:form id="edit_ukcollege_manager">
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
					value="Edit existing ukcollege" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<br />
		<a4j:region selfRendered="true"
			ajaxListener="#{appComponentController.valueChangeEditUKCollege}"
			id="ukcollegelist_ajaxregion">
			<a4j:status startText="Loading ..." startStyleClass="loadingStatus" />
			<h:panelGrid columns="2"
				style="padding-right: 100px; padding-left: 100px">
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma">Select
					UKCollege:</font>
				</h:panelGroup>
				<h:selectOneListbox id="ukcollege_list_id"
					value="#{appComponentController.selectedUKCollege}" size="1"
					converter="#{UKCollegeDataConverter}" style="width:200px">
					<f:selectItem itemLabel="Select One" itemValue="NA" />
					<f:selectItems
						value="#{cepisGlobalComponentConfigurator.ukCollegeList}"
						var="ukcollege" itemLabel="#{ukcollege.collegeName}" />
					<f:validator validatorId="UKCollegeDataValidator" />
					<a4j:support event="onchange"
						reRender="code,name,address,phone,dean,speedSort" />
				</h:selectOneListbox>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="College Code:"></h:outputText></font>
					<br />
					<h:outputText value="e.g., ADMS-CA-901" style="color:gray"></h:outputText>
				</h:panelGroup>
				<h:inputText id="code" disabled="true" value="#{appComponentController.code}"
					style='width:200px'></h:inputText>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="College Name:"></h:outputText></font>
					<br />
					<h:outputText value="Max 255 characters" style="color:gray"></h:outputText>
					<br />
				</h:panelGroup>
				<h:inputText id="name" value="#{appComponentController.collegeName}"
					style='width:200px'></h:inputText>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="College Address:"></h:outputText></font>
					<br />
					<h:outputText value="Max 255 characters" style="color:gray"></h:outputText>
					<br />
				</h:panelGroup>
				<h:inputText id="address" value="#{appComponentController.collegeAddress}"
					style='width:200px'></h:inputText>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="College Phone:"></h:outputText></font>
					<br />
					<h:outputText value="Max 255 characters" style="color:gray"></h:outputText>
					<br />
				</h:panelGroup>
				<h:inputText id="phone" value="#{appComponentController.phone}"
					style='width:200px'></h:inputText>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="College Dean Name:"></h:outputText></font>
					<br />
					<h:outputText value="Max 255 characters" style="color:gray"></h:outputText>
					<br />
				</h:panelGroup>
				<h:inputText id="dean" value="#{appComponentController.collegeDeanName}"
					style='width:200px'></h:inputText>
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="Sort Info:"></h:outputText></font>
					<br />
					<h:outputText value="Max 255 characters" style="color:gray"></h:outputText>
					<br />
				</h:panelGroup>
				<h:inputText id="speedSort" value="#{appComponentController.speedSort}"
					style='width:200px'></h:inputText>
				<h:message for="edit_ukcollege_button"></h:message>
				<h:commandButton id="edit_ukcollege_button" value="Edit"
					action="#{appComponentController.editUKCollege}"></h:commandButton>
			</h:panelGrid>
		</a4j:region>
	</h:form>
</f:view>