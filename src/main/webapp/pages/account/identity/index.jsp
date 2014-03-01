<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<rich:tabPanel switchType="ajax" immediate="true">
	<authz:authorize
		ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT,ROLE_STUDENT_ACCOUNT_MANAGER_VIEW,ROLE_STUDENT">
		<rich:tab label="View">
			<a4j:include viewId="view-identity.jsp" />
		</rich:tab>
	</authz:authorize>
	<authz:authorize
		ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER">
		<rich:tab label="Create">
			<a4j:include viewId="add-identity.jsp" />
		</rich:tab>
	</authz:authorize>
	<authz:authorize
		ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">
		<rich:tab label="Update">
			<a4j:include viewId="edit-identity.jsp" />
		</rich:tab>
	</authz:authorize>
	<authz:authorize ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER">
		<rich:tab label="Delete">
			<a4j:include viewId="delete-identity.jsp" />
		</rich:tab>
	</authz:authorize>
	<authz:authorize
		ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,">
		<rich:tab label="Deactivate">
			<a4j:include viewId="account-action.jsp" />
		</rich:tab>
	</authz:authorize>
	<authz:authorize
		ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT,ROLE_NONUK">
		<rich:tab label="Change Password">
			<a4j:include viewId="change-password.jsp" />
		</rich:tab>
	</authz:authorize>
</rich:tabPanel>