<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="authz"%>

<%@ include file="/common/header.jsp"%>


<script type="text/javascript">
	document.title = "CEPIS Account Management";
	var global_title = document.getElementById('global_title');
	global_title.innerHTML = "CEPIS Account Management";
</script>


<link href="${facesContext.externalContext.requestContextPath}/css/account.css"
	media="screen" rel="stylesheet" type="text/css" />
	
<link href="${facesContext.externalContext.requestContextPath}/css/font.css"
	media="screen" rel="stylesheet" type="text/css" />
	
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css" />
	
	
<f:view	beforePhase="#{accountManagementController.initAccountManagement}">
	<br />
	<a4j:outputPanel id="addMessages" ajaxRendered="true" style="align:center">
		<h:panelGrid columns="1" width="98%" id="messageSection">
			<rich:messages errorClass="cepiserror" infoClass="cepissuccess"
				warnClass="cepiswarning" tooltip="true" id="cepisMsgs"></rich:messages>
		</h:panelGrid>
		<a4j:status onstart="showModalInfoWindow();" onstop="hideModalInfoWindow()"/>
	</a4j:outputPanel>

	<h:panelGrid width="100%">
		<h:panelGrid columns="2" columnClasses="indexCol1,indexCol2" width="100%">
			<h:panelGroup>
				<f:subview id="manage_account">
					<h:form>
						<h:panelGrid>
							<authz:authorize
								ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_VIEW">
								<h:panelGroup>
									<font class="ws12" color="#062E8A" face="Tahoma"> 
										<h:outputText value="Manage Accounts" styleClass="boldText" />
									</font>
								</h:panelGroup>
								<h:panelGroup style="width:200px;" layout="block">								
									<h:selectOneListbox id="wsid" 
									value="#{cepisConfigurationManager.selectedUser}"
									size="10" converter="#{UserDataConverter}">
										<f:selectItem itemLabel="#{cepisUserManager.user}"
											itemValue="#{cepisUserManager.user}" />
										<f:selectItems
											value="#{workingSetController.workingSetUsers}"
											var="user" itemLabel="#{user.fullName}" />
										<f:validator validatorId="UserDataValidator" />						
										<a4j:support event="onclick" ajaxSingle="true"
											limitToList="true" reRender="accountsections,accountpanel"
											actionListener="#{accountManagementController.updateSelectedUser}"/>	
									</h:selectOneListbox>		
								</h:panelGroup>
							</authz:authorize>
							<authz:authorize
								ifNotGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_VIEW">
								<authz:authorize ifAnyGranted="ROLE_STUDENT">
									<h:panelGroup>
										<font class="ws12" color="#062E8A" face="Tahoma"> <h:outputText
												value="Manage My Account" styleClass="boldText" />
										</font>
									</h:panelGroup>
									<h:outputText id="test" value="#{cepisUserManager.user}"
										styleClass="boldText" />
								</authz:authorize>
							</authz:authorize>
							<rich:spacer height="25px"></rich:spacer>
							<h:panelGroup>
								<rich:panelMenu style="width:200px" id="accountsections"
									iconExpandedGroup="disc" iconCollapsedGroup="disc"
									label="Manage Account"
									value="#{accountManagementController.currentAccountSection}">
									<rich:panelMenuItem label="General" name="General"
										ajaxSingle="true" limitToList="true" mode="ajax"
										reRender="accountpanel"
										action="#{accountManagementController.changeAccountSection}">
										<f:param name="currentAccountSection" value="General" />
									</rich:panelMenuItem>
									<authz:authorize
										ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER">
										<rich:panelMenuItem label="Role" name="Role" ajaxSingle="true"
											limitToList="true" mode="ajax" reRender="accountpanel"
											action="#{accountManagementController.changeAccountSection}">
											<f:param name="currentAccountSection" value="Role" />
										</rich:panelMenuItem>
									</authz:authorize>
									<rich:panelMenuItem label="Email Address" name="Email"
										ajaxSingle="true" limitToList="true" mode="ajax"
										reRender="accountpanel"
										action="#{accountManagementController.changeAccountSection}">
										<f:param name="currentAccountSection" value="Email" />
									</rich:panelMenuItem>
									<rich:panelMenuItem label="Phone" name="Phone"
										ajaxSingle="true" limitToList="true" mode="ajax"
										reRender="accountpanel"
										action="#{accountManagementController.changeAccountSection}">
										<f:param name="currentAccountSection" value="Phone" />
									</rich:panelMenuItem>
									<rich:panelMenuItem label="Address" name="Address"
										ajaxSingle="true" limitToList="true" mode="ajax"
										reRender="accountpanel"
										action="#{accountManagementController.changeAccountSection}">
										<f:param name="currentAccountSection" value="Address" />
									</rich:panelMenuItem>
									<rich:panelMenuItem label="Academic Profile" name="Academic"
										ajaxSingle="true" limitToList="true" reRender="accountpanel"
										mode="ajax"
										action="#{accountManagementController.changeAccountSection}">
										<f:param name="currentAccountSection" value="Academic" />
									</rich:panelMenuItem>
									<rich:panelMenuItem label="College Profile" name="College"
										ajaxSingle="true" limitToList="true" mode="ajax"
										reRender="accountpanel"
										action="#{accountManagementController.changeAccountSection}">
										<f:param name="currentAccountSection" value="College" />
									</rich:panelMenuItem>
									<rich:panelMenuItem label="Program Profile" name="Program"
										ajaxSingle="true" limitToList="true" mode="ajax"
										reRender="accountpanel"
										action="#{accountManagementController.changeAccountSection}">
										<f:param name="currentAccountSection" value="Program" />
									</rich:panelMenuItem>
									<rich:panelMenuItem label="Personal Profile" name="Personal"
										ajaxSingle="true" limitToList="true" mode="ajax"
										reRender="accountpanel"
										action="#{accountManagementController.changeAccountSection}">
										<f:param name="currentAccountSection" value="Personal" />
									</rich:panelMenuItem>
									<authz:authorize
										ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_VIEW">
										<rich:panelMenuItem label="Test Scores" name="Test"
											ajaxSingle="true" limitToList="true" mode="ajax"
											reRender="accountpanel"
											action="#{accountManagementController.changeAccountSection}">
											<f:param name="currentAccountSection" value="Test" />
										</rich:panelMenuItem>
									</authz:authorize>																																	   
								</rich:panelMenu>
							</h:panelGroup>
						</h:panelGrid>
					</h:form>
				</f:subview>
			</h:panelGroup>
			<h:panelGrid id="accountpanel" width="100%">
				<h:panelGroup>
					<h:panelGroup
						rendered="#{accountManagementController.currentAccountSection=='General'}">
						<a4j:include viewId="identity/index.jsp" />
					</h:panelGroup>
				</h:panelGroup>
				<h:panelGroup>
					<h:panelGroup
						rendered="#{accountManagementController.currentAccountSection=='Role'}">
						<a4j:include viewId="role/index.jsp" />
					</h:panelGroup>
				</h:panelGroup>
				<h:panelGroup>
					<h:panelGroup
						rendered="#{accountManagementController.currentAccountSection=='Email'}">
						<a4j:include viewId="email-address/index.jsp" />
					</h:panelGroup>
				</h:panelGroup>
				<h:panelGroup>
					<h:panelGroup
						rendered="#{accountManagementController.currentAccountSection=='Phone'}">
						<a4j:include viewId="phone/index.jsp" />
					</h:panelGroup>
				</h:panelGroup>
				<h:panelGroup>
					<h:panelGroup
						rendered="#{accountManagementController.currentAccountSection=='Address'}">
						<a4j:include viewId="address/index.jsp" />
					</h:panelGroup>
				</h:panelGroup>
				<h:panelGroup>
					<h:panelGroup
						rendered="#{accountManagementController.currentAccountSection=='Academic'}">
						<a4j:include viewId="academic-profile/index.jsp" />
					</h:panelGroup>
				</h:panelGroup>
				<h:panelGroup>
					<h:panelGroup
						rendered="#{accountManagementController.currentAccountSection=='College'}">
						<a4j:include viewId="college-profile/index.jsp" />
					</h:panelGroup>
				</h:panelGroup>
				<h:panelGroup>
					<h:panelGroup
						rendered="#{accountManagementController.currentAccountSection=='Program'}">
						<a4j:include viewId="program-profile/index.jsp" />
					</h:panelGroup>
				</h:panelGroup>
				<h:panelGroup>
					<h:panelGroup
						rendered="#{accountManagementController.currentAccountSection=='Personal'}">
						<a4j:include viewId="personal-profile/index.jsp" />
					</h:panelGroup>
				</h:panelGroup>
				<h:panelGroup>
					<h:panelGroup
						rendered="#{accountManagementController.currentAccountSection=='Test'}">
						<a4j:include viewId="test-score/index.jsp" />
					</h:panelGroup>
				</h:panelGroup>											
			</h:panelGrid>
		</h:panelGrid>
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
				"if(!infoWindowAMShown){Richfaces.showModalPanel('ajaxLoadingModalBox');infoWindowAMShown=true;}",500);
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

	<a4j:outputPanel ajaxRendered="true" style="align:center">
		<h:panelGrid columns="1">
			<authz:authorize ifAllGranted="ROLE_DEVELOPER">
				<h:panelGroup>
					<a4j:log id="debug" popup="false" title="CEPIS - Ajax Debug Window"
						rendered="true" width="900px" height="100px"></a4j:log>
				</h:panelGroup>
			</authz:authorize>
		</h:panelGrid>
	</a4j:outputPanel>
	<a4j:loadScript src="resource://jquery.js" />
</f:view>

<%@ include file="/common/footer.jsp"%>
<script type="text/javascript"
	src="${facesContext.externalContext.requestContextPath}/js/jquery.maskedinput-1.2.2.js"></script>