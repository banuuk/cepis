<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:subview id="userconference">
	<h:form>
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Conferences attended by this user" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<rich:datascroller align="center" for="userconferenceTable"
			maxPages="20" />
		<rich:spacer height="20" />
		<rich:dataTable id="userconferenceTable"
			value="#{conferenceManagementController.userConferenceList}"
			var="conference" rows="25" width="100%" sortMode="single">
			<rich:column sortBy="#{conference.name}">
				<f:facet name="header">
					<h:outputText value="Name" />
				</f:facet>
				<h:outputText value="#{conference.name}" />
			</rich:column>
			<rich:column sortBy="#{conference.type}">
				<f:facet name="header">
					<h:outputText value="Type" />
				</f:facet>
				<h:outputText value="#{conference.type}" />
			</rich:column>
			<rich:column sortBy="#{conference.conferenceDate}">
				<f:facet name="header">
					<h:outputText value="Date" />
				</f:facet>
				<h:outputText value="#{conference.conferenceDate}" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="Description" />
				</f:facet>
				<h:outputText value="#{conference.shortDesc}" />
			</rich:column>
		</rich:dataTable>
	</h:form>
</f:subview>
