<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:subview id="ping_ldap">
	<br />
	<h3>Ping UKY LDAP (LinkBlue) Authentication Server for a user</h3>
	<h:form>
		<h:panelGrid width="50%" style="align:center;">
			<h:panelGrid columns="3">
				<h:outputLabel value="Enter a username:" for="username"></h:outputLabel>
				<h:inputText id="username" value="#{whoamiController.username}"
					style="width:180px" required="true"
					requiredMessage="User name: Value is required."
					validatorMessage="Link Blue Username: Value is invalid.">
					<f:validateRegex pattern="[A-Za-z0-9]+" />
				</h:inputText>
				<a4j:commandButton value="Ping" reRender="logPanel"
					ajaxSingle="true" limitToList="true" process="username"></a4j:commandButton>
			</h:panelGrid>

			<rich:separator lineType="beveled" height="8" align="center"></rich:separator>
			<br />
			<rich:panel bodyClass="rich-laguna-panel-no-header"
				style="align:center;" id="logPanel">
				<h:outputText value="#{whoamiController.queryLDAPResultForUser}" escape="false"></h:outputText>
			</rich:panel>
		</h:panelGrid>
	</h:form>
</f:subview>