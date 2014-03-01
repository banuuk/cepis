<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ include file="/common/header.jsp"%>

<script type="text/javascript">
	document.title = "CEPIS Certification";
	var global_title = document.getElementById('global_title');
	global_title.innerHTML = "CEPIS Certification";
</script>

<link href="${facesContext.externalContext.requestContextPath}/css/newStyle.css" media="screen"
	rel="stylesheet" type="text/css"/>

<f:view locale="en">	
	<br />
	<a4j:outputPanel id="addMessages" ajaxRendered="true" style="align:center">
		<h:panelGrid columns="1" width="100%" id="messageSection">
			<rich:messages errorClass="cepiserror" infoClass="cepissuccess"
				warnClass="cepiswarning" tooltip="true" id="cepisMsgs"/>
		</h:panelGrid>
		<a4j:status onstart="showModalInfoWindow();"
			onstop="hideModalInfoWindow()"/>
	</a4j:outputPanel>
	
	<h:panelGrid columns="2" cellpadding="5" columnClasses="skinny-col, fat-col">
		<h:panelGroup id="ws_panel" layout="block">						
			<h:form>	
				<h:panelGroup styleClass="wsCore" layout="block">	
					<h:selectOneListbox id="wsid"
						value="#{cepisConfigurationManager.selectedUser}"
						size="25" converter="#{UserDataConverter}"
						style="width: 200px;">
						<f:selectItem itemLabel="#{cepisUserManager.user}"
						itemValue="#{cepisUserManager.user}" />
						<f:selectItems
						value="#{workingSetController.workingSetUsers}"
						var="user" itemLabel="#{user.fullName}" />
						<f:validator validatorId="UserDataValidator" />	
						<a4j:support event="onclick" ajaxSingle="true"
						limitToList="true" reRender="certification_panel"/>							
					</h:selectOneListbox>										
				</h:panelGroup>	
			</h:form>
		</h:panelGroup>	
		<h:panelGroup id="certification_panel" layout="block">	
			<rich:tabPanel switchType="ajax" immediate="true">
			
				<authz:authorize
					ifAnyGranted="ROLE_DEVELOPER,ROLE_ADMINISTRATOR,ROLE_STUDENT_ACCOUNT_MANAGER_VIEW">
					<rich:tab label="View" >
						<a4j:include viewId="view-certification.jsp" />
					</rich:tab>
				</authz:authorize>
				
				<authz:authorize
					ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">
					<rich:tab label="Add" onclick="#{certificationController.setUpAddTab}">
						<a4j:include viewId="add-certification.jsp" />
					</rich:tab>
				</authz:authorize>
				
				<authz:authorize
					ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">
					<rich:tab label="Update" onclick="#{certificationController.setUpEditTab}">
						<a4j:include viewId="edit-certification.jsp" />
					</rich:tab>
				</authz:authorize>
				
				<authz:authorize
					ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_DELETE">
					<rich:tab label="Delete" onclick="#{certificationController.setUpDeleteTab}">
						<a4j:include viewId="delete-certification.jsp" />
					</rich:tab>
				</authz:authorize>
				
			</rich:tabPanel>
		</h:panelGroup>
	</h:panelGrid>
	<rich:modalPanel id="ajaxLoadingModalBox" minHeight="50" minWidth="120"
		height="100" width="120" zindex="2000">
		<f:facet name="header">
			<h:outputText value="Sending Request ..."/>
		</f:facet>
		<h:outputText value="Please wait ..."/>
		<br />
		<br />&nbsp;&nbsp;&nbsp;
				<h:graphicImage value="/images/loader.gif" style="border:0"
			alt="loading ..."/>
	</rich:modalPanel>
	<script type="text/javascript">
		var infoWindowAMShown = false;
		var infoWindowAMTimer;
		function showModalInfoWindow() {
			infoWindowAMTimer = setTimeout(
					"if(!infoWindowAMShown){Richfaces.showModalPanel('ajaxLoadingModalBox');infoWindowAMShown=true;}",
					500);
		}
		function hideModalInfoWindow() {
			if (infoWindowAMShown) {
				Richfaces.hideModalPanel('ajaxLoadingModalBox');
				infoWindowAMShown = false;
			} else {
				if (infoWindowAMTimer)
					clearTimeout(infoWindowAMTimer);
			}
		}
	</script>
</f:view>
<%@ include file="/common/footer.jsp"%>