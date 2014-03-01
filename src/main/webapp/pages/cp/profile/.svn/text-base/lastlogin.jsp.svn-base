<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<link href="${facesContext.externalContext.requestContextPath}/css/datascroller.css"
	media="screen" rel="stylesheet" type="text/css" />
<f:subview id="last_login">
	<h5>Login Information</h5>
	<hr></hr>
	<h:panelGrid columns="2">
		<rich:dataTable id="scrollList1" styleClass="scrollTable"
			headerClass="head1" rowClasses="normalRow,alternateRow"
			columnClasses="standardTable_Column,standardTable_Column,standardTable_ColumnCentered,standardTable_Column"
			var="lastLogin" value="#{lastLoginController.userLastLogins}"
			rows="10">

			<rich:column>
				<f:facet name="header">
					<h:outputText value="Login Time" />
				</f:facet>
				<h:outputText value="#{lastLogin.lastLogin}">
					<f:convertDateTime pattern="MMM dd, yyyy HH:mm" />
				</h:outputText>
			</rich:column>
		</rich:dataTable>
		<rich:dataTable id="scrollList2" styleClass="scrollTable"
			headerClass="head1" rowClasses="normalRow,alternateRow"
			columnClasses="standardTable_Column,standardTable_Column,standardTable_ColumnCentered,standardTable_Column"
			var="ip" value="#{lastLoginController.userIpAddresses}"
			rows="#{cepisConfigurationManager.rowCount}">


			<rich:column>
				<f:facet name="header">
					<h:outputText value="IP Address" />
				</f:facet>
				<h:outputText value="#{ip.ipAddr}"></h:outputText>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="Client Information" />
				</f:facet>
				<h:outputText value="#{ip.clientInfo}"></h:outputText>
			</rich:column>

		</rich:dataTable>
	</h:panelGrid>
</f:subview>