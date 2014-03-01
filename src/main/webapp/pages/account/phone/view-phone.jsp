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
<f:subview id="view-phone">
	<h:form>
		<h:panelGroup>
			<h:panelGroup>
				<rich:dataTable id="phoneScrollList" styleClass="scrollTable"
					headerClass="head1" rowClasses="normalRow,alternateRow"
					width="100%"
					columnClasses="standardTable_Column,standardTable_Column,standardTable_ColumnCentered,standardTable_Column"
					var="phone" value="#{accountManagementController.phoneList}"
					rows="#{cepisConfigurationManager.rowCount}">
					<f:facet name="header">
					<rich:datascroller for="phoneScrollList" id="sc2"
						page="#{searchEngineController.pageValue}" reRender="sc1"
						ajaxSingle="false" />
				</f:facet>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#Phone Number" />
						</f:facet>
						<h:outputText value="#{phone.phoneNo}"></h:outputText>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#Ext" />
						</f:facet>
						<h:outputText value="#{phone.ext}"></h:outputText>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#Short Desc" />
						</f:facet>
						<h:outputText value="#{phone.memo}"></h:outputText>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#Phone Type" />
						</f:facet>
						<h:outputText value="#{phone.phoneType}"></h:outputText>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#Last Edit" />
						</f:facet>
						<h:outputText value="#{phone.lastEdit}"></h:outputText>
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