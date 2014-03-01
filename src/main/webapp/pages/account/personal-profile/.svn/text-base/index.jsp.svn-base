<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<link href="${facesContext.externalContext.requestContextPath}/css/newStyle.css" media="screen"
	rel="stylesheet" type="text/css"/>

<rich:tabPanel switchType="ajax" immediate="true">
	<authz:authorize
		ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_VIEW,ROLE_STUDENT">
		<rich:tab label="View">
			<a4j:include viewId="view-personal-profile.jsp" />
		</rich:tab>
	</authz:authorize>	
	<authz:authorize
		ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">
		<rich:tab label="Update">
			<a4j:include viewId="edit-personal-profile.jsp" />
		</rich:tab>
	</authz:authorize>	
</rich:tabPanel>