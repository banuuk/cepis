<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
	
<f:subview id="add-role">
	<h:form id="add_role_manager" styleClass="styleish">
		<br />				
		
		<h:outputLabel for="lineSeparator" value="Grant Roles"  styleClass="medium-bold"/>
		<rich:separator id="lineSeparator" lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>		
				
		<h:panelGrid columns="2" width="100%">			
			<h:panelGroup layout="block" style="width:110%">
				<h:panelGrid columns="2" width="110%">
					<h:outputLabel for="roleList" styleClass="small" value="Select Roles : *" />		
					<h:selectManyListbox id="roleList"
					value="#{accountManagementController.selectedRoles}" size="15"
					converter="#{RoleDataConverter}" style="width: 300px;"
					required="true" requiredMessage="Roles: Atleast one role should be selected">			
						<f:selectItems value="#{cepisGlobalComponentConfigurator.roleList}"
						var="role" itemLabel="#{role.rolename}" />
						<f:validator validatorId="RoleDataValidator" />
						<a4j:support event="onchange" reRender="customws,wslistid"
						ajaxSingle="true"
						actionListener="#{accountManagementController.valueChangeAddRole}"
						timeout="3000" />
					</h:selectManyListbox>					
					<h:commandButton id="add_role_button" value="Add" styleClass="buttonStyle"
					action="#{accountManagementController.addRolesToUser}"/>
				</h:panelGrid>			
			</h:panelGroup>
		
			<h:panelGroup layout="block" style="width:85%; float:right">
				<rich:dataTable id="roleTable" styleClass="basicTable"
				rowClasses="oddRow,evenRow"
				width="85%" var="role"
				value="#{cepisGlobalComponentConfigurator.roleList}">				
					<rich:column id="roleName_col" sortable="false">
						<f:facet name="header">
							<h:outputText value="Role Name" />
						</f:facet>
						<h:panelGroup>
							<h:outputText value="#{role.rolename}" />
						</h:panelGroup>
					</rich:column>				
					<rich:column id="roleDescription_col" sortable="false">
						<f:facet name="header">
							<h:outputText value="Description" />
						</f:facet>
						<h:panelGroup>
							<h:outputText value="#{role.roledesc}" />
						</h:panelGroup>
					</rich:column>				
				</rich:dataTable>
			</h:panelGroup>
			
			
			
<%-- 			<a4j:outputPanel ajaxRendered="true"> --%>
<%-- 				<h:panelGroup id="customws" rendered="#{accountManagementController.selectCustomRoleWorkingSet}"> --%>
<%-- 					<h:panelGroup> --%>
<%-- 						<font class="ws10" color="#062E8A" face="Tahoma"> --%>
<%-- 							<h:outputText value="Available Working Sets: *" /> --%>
<%-- 						</font> --%>
<%-- 					</h:panelGroup> --%>
<!-- 					<br /> -->
<%-- 					<h:outputText value="Assign a working set for the Custom role " /> --%>
<%-- 				</h:panelGroup> --%>
<%-- 			</a4j:outputPanel> --%>
						
<%-- 			<a4j:outputPanel ajaxRendered="true"> --%>
<%-- 				<h:selectOneListbox id="wslistid" --%>
<%-- 				rendered="#{accountManagementController.selectCustomRoleWorkingSet}" --%>
<%-- 				value="#{accountManagementController.selectedWorkingSet}" size="1" --%>
<%-- 				converter="#{WorkingSetDataConverter}" style="width:200px" --%>
<%-- 				required="true"	requiredMessage="Working Set: You should assign a working set to the custom role"> --%>
<%-- 					<f:selectItem itemLabel="Select One" itemValue="NA" /> --%>
<%-- 					<f:selectItems value="#{workingSetController.activeWSList}" var="ws" itemLabel="#{ws.name}" /> --%>
<%-- 					<f:validator validatorId="WorkingSetDataValidator" /> --%>
<%-- 				</h:selectOneListbox> --%>
<%-- 			</a4j:outputPanel>			 --%>
			
			
		</h:panelGrid>
	</h:form>
</f:subview>
