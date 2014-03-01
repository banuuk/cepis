<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<link href="${facesContext.externalContext.requestContextPath}/css/newStyle.css" 
	rel="stylesheet" type="text/css"/>

<rich:tabPanel switchType="ajax" immediate="true">
	<authz:authorize
		ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER">
		<rich:tab label="View Roles">
			<a4j:include viewId="view-role.jsp" />
		</rich:tab>
	</authz:authorize>
	<authz:authorize
		ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER">
		<rich:tab label="Grant Roles">
			<a4j:include viewId="role-add-user.jsp" />
		</rich:tab>
	</authz:authorize>
	<authz:authorize
		ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER">
		<rich:tab label="Revoke Roles">
			<a4j:include viewId="role-remove-user.jsp" />
		</rich:tab>
	</authz:authorize>
</rich:tabPanel>