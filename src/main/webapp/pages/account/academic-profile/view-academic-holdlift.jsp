<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:subview id="view-academic-holdlift">
	<h:form id="form">
		<h:panelGrid id="holdLiftList" width="100%" style="align:center;">
			<rich:extendedDataTable
				binding="#{accountManagementController.holdLiftDataTable}"
				id="holdLiftsTable"
				noDataLabel="No Hold lifts found."
				value="#{accountManagementController.holdLiftsDataModel}"
				var="holdLift" height="200px" groupingColumn="hold_col2"
				sortMode="single" selectionMode="single"
				tableState="#{accountManagementController.holdLiftTableState}"
				selection="#{accountManagementController.holdLiftSelection}">
				<rich:column sortable="true" sortBy="#{holdLift.term.ukTermCode}"
					id="hold_col2" width="100px" label="Term" sortOrder="DESCENDING">
					<f:facet name="header">
						<h:outputText value="Term" />
					</f:facet>
					<h:outputText value="#{holdLift.term}" />
				</rich:column>
				<rich:column id="hold_col3" width="100px" label="Lifted By">
					<f:facet name="header">
						<h:outputText value="Lifted By" />
					</f:facet>
					<h:outputText value="#{holdLift.liftedBy}" />
				</rich:column>
				<rich:column id="hold_col4" width="100px" label="Lifted On">
					<f:facet name="header">
						<h:outputText value="Lifted On" />
					</f:facet>
					<h:outputText value="#{holdLift.addedOn}" />
				</rich:column>
			</rich:extendedDataTable>
		</h:panelGrid>
	</h:form>
</f:subview>