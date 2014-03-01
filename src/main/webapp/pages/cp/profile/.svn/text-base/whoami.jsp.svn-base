<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<link
	href="${facesContext.externalContext.requestContextPath}/css/datascroller.css"
	media="screen" rel="stylesheet" type="text/css" />
<f:subview id="who_am_i">

	<br />
	<h3>
		<h:outputText value="Who Am I? #{whoamiController.preferredName}"></h:outputText>
	</h3>
	<h:outputText value="Linkblue Username: " />
	<sec:authentication property="principal.username"/>
	<br />
	<h:outputText value="#{whoamiController.clientInfo}" escape="false"/>
	<br />
	<h:outputText value="Current Login on: " />
	<h:outputText value="#{whoamiController.currentLogin}" />
	<br />
	<h:outputText value="Last Login on: " />
	<h:outputText value="#{whoamiController.lastLogin}" />
	<br />
	<br />
	<br />
	<h:form>
		<sec:authentication property="authorities" var="roles" scope="page" />
		<h:panelGroup id="body">
			<rich:dataTable id="scrollList" styleClass="scrollTable"
				align="center" headerClass="head1"
				rowClasses="normalRow,alternateRow" width="60%"
				columnClasses="standardTable_Column,standardTable_Column,standardTable_ColumnCentered,standardTable_Column"
				var="role" value="#{whoamiController.userRoles}" rows="5">
				<f:facet name="header">
					<rich:datascroller for="scrollList" id="sc2" reRender="sc1"
						ajaxSingle="false" />
				</f:facet>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="#Registered Roles" />
					</f:facet>
					<h:outputText value="#{role}"></h:outputText>
				</rich:column>

				<f:facet name="footer">
					<rich:datascroller id="sc1" ajaxSingle="false" reRender="sc2" />
				</f:facet>
			</rich:dataTable>
		</h:panelGroup>
	</h:form>
	<br />
	<hr></hr>
	<h5>
		<h:outputText value="Information from UKY LDAP Server"></h:outputText>
	</h5>
	<rich:panel bodyClass="rich-laguna-panel-no-header"
		style="align:center;">
		<h:outputText value="#{whoamiController.queryLDAPResultForUser}"
			escape="false">
		</h:outputText>
	</rich:panel>
</f:subview>