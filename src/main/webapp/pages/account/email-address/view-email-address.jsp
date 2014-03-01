
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<link
	href="${facesContext.externalContext.requestContextPath}/css/datascroller.css"
	media="screen" rel="stylesheet" type="text/css" />
<link
	href="${facesContext.externalContext.requestContextPath}/css/font.css"
	media="screen" rel="stylesheet" type="text/css" />
<link
	href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css" />
<f:subview id="view-email">
	<br />
	<h:message for="email_address_manager">
	</h:message>
	<h:form id="email_address_manager">
		<h:panelGroup id="emailAddressList">
			<h:panelGroup id="body">
				<rich:dataTable id="scrollList" styleClass="scrollTable"
					headerClass="head1" rowClasses="normalRow,alternateRow"
					width="100%"
					columnClasses="standardTable_Column,standardTable_Column,standardTable_ColumnCentered,standardTable_Column"
					var="emailAddress"
					value="#{accountManagementController.emailAddressList}"
					rows="#{cepisConfigurationManager.rowCount}">
					<f:facet name="header">
						<rich:datascroller for="scrollList" id="sc2"
							page="#{searchEngineController.pageValue}" reRender="sc1"
							ajaxSingle="false" />
					</f:facet>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#Email Address" />
						</f:facet>
						<h:outputText value="#{emailAddress.address}"></h:outputText>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#Email Address Type" />
						</f:facet>
						<h:outputText value="#{emailAddress.type}"></h:outputText>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#Last Edit" />
						</f:facet>
						<h:outputText value="#{emailAddress.lastEdit}"></h:outputText>
					</rich:column>
					<f:facet name="footer">
						<rich:datascroller id="sc1" ajaxSingle="false"
							page="#{searchEngineController.pageValue}" reRender="sc2" />
					</f:facet>
				</rich:dataTable>
			</h:panelGroup>

		</h:panelGroup>
	</h:form>
</f:subview>