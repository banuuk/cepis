<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<f:subview id="remove-role">
	<h:form id="revoke_role_manager" styleClass="styleish">
	
		<br />
		<h:outputLabel for="lineSeparator" value="Revoke Roles"  styleClass="medium-bold"/>
		<rich:separator id="lineSeparator" lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>		
		<br />

		<h:panelGrid columns="2" style="padding-right: 100px; padding-left: 100px">			
			<h:outputLabel for="roleList" styleClass="small" value="Granted Roles : " />			
			<h:selectManyListbox id="roleList"
			value="#{accountManagementController.selectedRoles}" size="13"
			converter="#{RoleDataConverter}" style="width: 300px;"
			required="true"
			requiredMessage="Role(s): Atleast one role should be selected.">
				<f:selectItems value="#{accountManagementController.userRoles}"
				var="role" itemLabel="#{role.rolename}" />
				<f:validator validatorId="RoleDataValidator" />
			</h:selectManyListbox>
			<h:message for="revoke_role_button"></h:message>
			<h:commandButton id="revoke_role_button" value="Revoke" styleClass="buttonStyle"
			action="#{accountManagementController.revokeRolesFromUser}">
				<a4j:support reRender="roleList"/>
			</h:commandButton>
		</h:panelGrid>
		
	</h:form>
</f:subview>