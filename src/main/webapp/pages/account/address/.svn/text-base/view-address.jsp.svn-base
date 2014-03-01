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
<f:subview id="view-address">
	<h:form>
		<h:panelGroup>
			<h:panelGroup>
				<rich:dataTable id="addressScrollList" styleClass="scrollTable"
					headerClass="head1" rowClasses="normalRow,alternateRow"
					width="100%"
					columnClasses="standardTable_Column,standardTable_Column,standardTable_ColumnCentered,standardTable_Column"
					var="address" value="#{accountManagementController.addressList}"
					rows="#{cepisConfigurationManager.rowCount}">
					<f:facet name="header">
					<rich:datascroller for="addressScrollList" id="sc2"
						page="#{searchEngineController.pageValue}" reRender="sc1"
						ajaxSingle="false" />
				</f:facet>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#Street Address" />
						</f:facet>
						<h:outputText value="#{address.street1} #{address.street2 }"/>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#City" />
						</f:facet>
						<h:outputText value="#{address.city}"/>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#State" />
						</f:facet>
						<h:outputText value="#{address.state}"/>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#Zip Code" />
						</f:facet>
						<h:outputText value="#{address.zip}"/>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#Country" />
						</f:facet>
						<h:outputText value="#{address.country}"/>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#Address Type" />
						</f:facet>
						<h:outputText value="#{address.addressType}"/>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#Last Edit" />
						</f:facet>
						<h:outputText value="#{address.lastEdit}"/>
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