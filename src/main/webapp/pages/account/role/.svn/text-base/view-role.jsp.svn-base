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
<f:subview id="view-role">
	<br/>
	
	<h:outputLabel for="lineSeparator" value="View Roles"  styleClass="medium-bold"/>
	<rich:separator id="lineSeparator" lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>
	
	<h:form id="role_manager">
		<h:panelGroup id="roleList">			
			<rich:dataTable id="scrollList" styleClass="scrollTable"
				headerClass="head1" rowClasses="normalRow,alternateRow"
				width="100%"
				columnClasses="standardTable_Column,standardTable_Column,standardTable_ColumnCentered,standardTable_Column"
				var="role" value="#{accountManagementController.userRoles}"
				rows="#{cepisConfigurationManager.rowCount}">					
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Role Name" />
					</f:facet>
					<h:outputText value="#{role.rolename}"/>
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Role Description" />
					</f:facet>
					<h:outputText value="#{role.roledesc}"/>
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Other Information" />
					</f:facet>
					<h:outputText value="#{role.otherInfo}"/>
				</rich:column>					
			</rich:dataTable>			
		</h:panelGroup>
	</h:form>
</f:subview>