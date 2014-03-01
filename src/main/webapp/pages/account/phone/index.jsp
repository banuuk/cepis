<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<rich:tabPanel switchType="ajax" immediate="true" >
	<authz:authorize
		ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_VIEW,ROLE_STUDENT">
		<rich:tab label="View">
			<jsp:include page="view-phone.jsp" />
		</rich:tab>
	</authz:authorize>
	<authz:authorize
		ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT,ROLE_STUDENT">
		<rich:tab label="Add">
			<jsp:include page="add-phone.jsp" />
		</rich:tab>
	</authz:authorize>
	<authz:authorize
		ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">
		<rich:tab label="Update">
			<jsp:include page="edit-phone.jsp" />
		</rich:tab>
	</authz:authorize>
	<authz:authorize
		ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_DELETE">
		<rich:tab label="Delete">
			<jsp:include page="delete-phone.jsp" />
		</rich:tab>
	</authz:authorize>
</rich:tabPanel>