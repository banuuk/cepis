<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="authz"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<rich:tabPanel switchType="ajax" immediate="true">

	<rich:tab label="Courses Taken">
		<a4j:include viewId="view-academic-profile.jsp" />
	</rich:tab>
	<rich:tab label="Recent Hold Lifts">
		<a4j:include viewId="view-academic-holdlift.jsp" />
	</rich:tab>
	<authz:authorize
		ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_ADVISOR">
		<rich:tab label="UK Transcript">
			<a4j:include viewId="view-academic-transcript.jsp" />
		</rich:tab>
	</authz:authorize>
</rich:tabPanel>