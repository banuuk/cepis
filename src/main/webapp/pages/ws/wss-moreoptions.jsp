<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a4j"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:subview id="wss-moreoptions">
	<h:form id="list_ws">
		<br />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Working Set Merge" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<h:panelGroup>
			<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
				value="Current Working Set: "></h:outputText></font>
		</h:panelGroup>
		<h:outputText value="#{workingSetController.activeWorkingSetName}"></h:outputText>&nbsp;&nbsp;
		<br />
		<br />
		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Merge To: "></h:outputText></font>
			</h:panelGroup>
			<h:inputText id="mergeTo"
				value="#{workingSetController.activeWorkingSetName}" disabled="true"
				style="width: 200px"></h:inputText>

			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Available Working Sets: "></h:outputText></font>
			</h:panelGroup>
			<h:selectManyListbox id="wslistid"
				value="#{workingSetController.selectedWSList}" size="10"
				style="width:200px" converter="#{WorkingSetDataConverter}">
				<f:selectItems value="#{workingSetController.activeWSList}" var="ws"
					itemLabel="#{ws.name}" />
				<f:validator validatorId="WorkingSetDataValidator" />
			</h:selectManyListbox>
			<br />
			<h:message for="wslistid" style="color:RED" />
			<br />
			<h:commandButton value="Merge" action="#{workingSetController.merge}"></h:commandButton>
			&nbsp; &nbsp; &nbsp;
			<!-- 	<h:commandButton value="Merge & Delete"
			action="#{workingSetController.mergeAndDelete}"
			onclick="if (!confirm('Are you sure, Do you want to merge & delete the selected workingsets?')) return false"></h:commandButton>
			-->
		</h:panelGrid>
	</h:form>
</f:subview>