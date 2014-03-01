<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<link href="${facesContext.externalContext.requestContextPath}/css/newStyle.css" media="screen" rel="stylesheet" type="text/css"/>
<h:panelGroup id="programProfile_panel" layout="block">	
	<rich:tabPanel switchType="ajax" immediate="true">
		
		<authz:authorize ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_VIEW,ROLE_STUDENT">
					<rich:tab label="View">
				<a4j:include viewId="view-program-profile.jsp" />
			</rich:tab>
		</authz:authorize>
		
		<authz:authorize ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">
			<rich:tab label="Add" onclick="#{accountManagementController.prepProgramProfileTab}">
				<a4j:include viewId="add-program-profile.jsp" />
			</rich:tab>
		</authz:authorize>
		
		<authz:authorize ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">
			<rich:tab label="Update" onclick="#{accountManagementController.prepProgramProfileTab}">
				<a4j:include viewId="edit-program-profile.jsp" />
			</rich:tab>
		</authz:authorize>
		
		<authz:authorize ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_DELETE">
			<rich:tab label="Delete">
				<a4j:include viewId="delete-program-profile.jsp" />
			</rich:tab>
		</authz:authorize>
		
	</rich:tabPanel>
</h:panelGroup>