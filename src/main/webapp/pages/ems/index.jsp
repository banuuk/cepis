<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ include file="/common/header.jsp"%>

<script type="text/javascript">
	document.title = "CEPIS Enrollment Management System";
	var global_title = document.getElementById('global_title');
	global_title.innerHTML = "CEPIS Enrollment Management System";
</script>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/datascroller.css"
	media="screen" rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/ems.css" media="screen"
	rel="stylesheet" type="text/css"/>
<f:view locale="en"
	beforePhase="#{accountManagementController.initAccountManagement}">
	<h:panelGroup layout="block" styleClass="contentStyle" id="bodyContent">
		<h:panelGroup layout="block">
			<h:outputText value="#{accountManagementController.onEMSPageLoaded}"/>
			<rich:layout id="cepis_body">
				<rich:layoutPanel position="center" width="100%;">
					<h:panelGroup style="width:100%;">
						<h:panelGrid columns="3" width="100%">
							<h:panelGroup>
								<rich:panel style="height:450px;" id="lay">
									<f:facet name="header">
										<h:outputText>General Information</h:outputText>
									</f:facet>
									<h:panelGrid columns="2">
										<h:panelGroup>
											<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
												value="CEPIS UID: " /></font>
										</h:panelGroup>
										<h:outputText
											value="#{accountManagementController.identityUid}"
											style="width:200px"></h:outputText>
										<h:panelGroup>
											<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
												value="UK ID: " /></font>
										</h:panelGroup>
										<h:outputText
											value="#{accountManagementController.identityUkID}"
											style="width:200px"></h:outputText>
										<h:panelGroup>
											<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
												value="SSN: " /></font>
										</h:panelGroup>
										<h:outputText
											value="#{accountManagementController.identitySsn}"
											style="width:200px"></h:outputText>
										<h:panelGroup>
											<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
												value="Link Blue Username: " /></font>
										</h:panelGroup>
										<h:outputText
											value="#{accountManagementController.identityUsername}"
											style="width:200px"></h:outputText>
										<h:panelGroup>
											<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
												value="Last Name: " /></font>
										</h:panelGroup>
										<h:outputText
											value="#{accountManagementController.identitylName}"
											style="width:200px"></h:outputText>
										<h:panelGroup>
											<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
												value="First Name: " /></font>
										</h:panelGroup>
										<h:outputText
											value="#{accountManagementController.identityfName}"
											style="width:200px"></h:outputText>
										<h:panelGroup>
											<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
												value="Middle Name: " /></font>
										</h:panelGroup>
										<h:outputText
											value="#{accountManagementController.identitymName}"
											style="width:200px"></h:outputText>
										<h:panelGroup>
											<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
												value="Full Name: " /></font>
										</h:panelGroup>
										<h:outputText
											value="#{accountManagementController.identityFullName}"
											style="width:200px"></h:outputText>
										<h:panelGroup>
											<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
												value="Maiden Name: " /></font>
										</h:panelGroup>
										<h:outputText
											value="#{accountManagementController.identityMaidenName}"
											style="width:200px"></h:outputText>
										<h:panelGroup>
											<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
												value="Suffix: " /></font>
										</h:panelGroup>
										<h:outputText
											value="#{accountManagementController.identitySuffix}"
											style="width:200px"></h:outputText>
										<h:panelGroup>
											<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
												value="Gender: " /></font>
										</h:panelGroup>
										<h:outputText
											value="#{accountManagementController.identityGender}"
											style="width:200px"></h:outputText>
										<h:panelGroup>
											<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
												value="Title: " /></font>
										</h:panelGroup>
										<h:outputText
											value="#{accountManagementController.identityTitle}"
											style="width:200px"></h:outputText>
										<h:panelGroup>
											<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
												value="Date of Birth: " /></font>
										</h:panelGroup>
										<h:outputText
											value="#{accountManagementController.identityDOB}"
											style="width:200px"></h:outputText>
										<h:panelGroup>
											<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
												value="Created on: " /></font>
										</h:panelGroup>
										<h:outputText
											value="#{accountManagementController.identityCreatedOn}"
											style="width:200px"></h:outputText>
										<h:panelGroup>
											<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
												value="Locale: " /></font>
										</h:panelGroup>
										<h:outputText
											value="#{accountManagementController.identityLocale}"
											style="width:200px"></h:outputText>
										<h:panelGroup>
											<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
												value="Timezone: " /></font>
										</h:panelGroup>
										<h:outputText
											value="#{accountManagementController.identityTimeZone}"
											style="width:200px"></h:outputText>
										<h:panelGroup>
											<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
												value="Cumulative GPA: " /></font>
										</h:panelGroup>
										<h:outputText
											value="#{accountManagementController.cumulativeGpa}"
											style="width:200px"></h:outputText>
									</h:panelGrid>
								</rich:panel>
							</h:panelGroup>
							<h:panelGroup>
								<rich:panel bodyClass="rich-laguna-panel-no-header"
									style="height:450px;align:center;">

									<br />
									<h:panelGrid columnClasses="profilehold" width="100%">
										<h:graphicImage value="/images/hold.jpg" styleClass="hold"
											rendered="false" alt="ON HOLD"></h:graphicImage>
										<a4j:mediaOutput element="img" id="profile"
											session="true"
											createContent="#{accountManagementController.getProfilePicture}"
											value="#{profilePicture}" mimeType="image/png"
											styleClass="profile" />
									</h:panelGrid>
									<br />
									<h:panelGroup style="text-align:center;align:center"
										layout="block">
										<rich:separator lineType="beveled" height="8" align="center" />
										<h:outputText>Primary Contact Information</h:outputText>
										<rich:separator height="4" lineType="double" align="center" />
									</h:panelGroup>
									<h:form>
										<h:panelGrid columns="2" id="contact">
											<h:panelGroup>
												<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
													value="Email Address: " /></font>
											</h:panelGroup>
											<h:outputText
												value="#{accountManagementController.primaryEmailAddress}"
												style="width:200px"></h:outputText>
											<h:panelGroup>
												<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
													value="Phone  Number: " /></font>
											</h:panelGroup>
											<h:outputText
												value="#{accountManagementController.primaryPhone}"
												style="width:200px"></h:outputText>
											<h:panelGroup>
												<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
													value="Badge holder?: " /></font>
											</h:panelGroup>
											<h:outputText
												rendered="#{cepisConfigurationManager.selectedUser.badgeHolder==0}"
												value="No" style="width:200px"></h:outputText>
											<h:outputText
												rendered="#{cepisConfigurationManager.selectedUser.badgeHolder==1}"
												value="Yes" style="width:200px"></h:outputText>

										</h:panelGrid>
										<br />
										<h:panelGroup style="text-align:right;align:right;"
											layout="block">
											<a4j:commandLink ajaxSingle="true" id="userconflink"
												oncomplete="#{rich:component('userconf')}.show()"
												value="Update Contact Info" reRender="contact">
											</a4j:commandLink>
										</h:panelGroup>
										<rich:contextMenu event="oncontextmenu" attachTo="profile"
											submitMode="none">
											<rich:menuItem value="No Profile Picture?"
												onclick="alert('If you are not a CEPIS Identification card holder (not the University of Kentucky identification card), please visit TEB 166 to get your badge and profile picture updated.');"
												id="change"></rich:menuItem>
										</rich:contextMenu>
									</h:form>
								</rich:panel>
							</h:panelGroup>
							<h:panelGroup id="workingSet">
								<authz:authorize
									ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT,ROLE_STUDENT_ACCOUNT_MANAGER_VIEW">
									<rich:panel style="height:450px;">
										<f:facet name="header">
											<h:panelGroup>
												<h:outputText>Working Set:  </h:outputText>
												<font color="#062E8A" face="Tahoma"><B><h:outputText
													id="ws_name"
													value=" #{workingSetController.activeWorkingSetName}"></h:outputText></B></font>&nbsp;&nbsp;<h:graphicImage
													url="/images/info.png" alt="i"
													title="#{workingSetController.activeWorkingSetDescription}" />
											</h:panelGroup>
										</f:facet>
										<h:panelGrid columns="1">
											<h:form>
												<a4j:outputPanel ajaxRendered="true">

													<a4j:status onstart="showModalInfoWindow();"
														onstop="hideModalInfoWindow()"></a4j:status>

												</a4j:outputPanel>
												<h:panelGroup style="vertical-align:center;" layout="block">
													<h:selectOneListbox id="wsid"
														value="#{cepisConfigurationManager.selectedUser}"
														size="25" onchange="submit();"
														converter="#{UserDataConverter}" style="width: 200px;">
														<f:selectItem itemLabel="#{cepisUserManager.user}"
															itemValue="#{cepisUserManager.user}" />
														<f:selectItems
															value="#{workingSetController.activeWSUsersList}"
															var="user" itemLabel="#{user.fullName}" />
														<f:validator validatorId="UserDataValidator" />
														<a4j:support event="onchange"
															actionListener="#{accountManagementController.updateSelectedUser}"></a4j:support>
													</h:selectOneListbox>

												</h:panelGroup>
												<div class="wpmd">
												<div align=right><font class="ws8" color="#062E8A"
													face="Tahoma"><a
													href="${facesContext.externalContext.requestContextPath}/pages/ws/index.cps"
													title="Working Set"><span>More options &gt;&gt;</span></a>
												&nbsp;&nbsp;&nbsp;&nbsp;</font></div>
												</div>
											</h:form>
										</h:panelGrid>
									</rich:panel>

								</authz:authorize>
							</h:panelGroup>
						</h:panelGrid>
						<rich:separator lineType="beveled" height="8" align="center" />
						<br />
						<h:panelGrid columns="3" style="align:right;width:100%">
							<rich:simpleTogglePanel switchType="client"
								label="User College Profile" width="100%" height="450px"
								style="vertical-align:center;">
								<h:form>
									<h:panelGroup id="cpAddStatus">

										<h:panelGroup
											rendered="#{accountManagementController.collegeProfileListEmpty}">
											<h:outputText
												value="No College Profile available for this user."></h:outputText>
											<authz:authorize
												ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">
												<a4j:commandLink id="addlink"
													oncomplete="#{rich:component('addPanel')}.show()"
													reRender="addPanel">
													<h:outputText>Add</h:outputText>
													<h:graphicImage value="/images/icons/add.png"
														style="border:0" styleClass="pic" alt="Add"/>
													<f:setPropertyActionListener value="#{true}"
														target="#{accountManagementController.showCollegeProfileAddModalWindow}" />
													<f:setPropertyActionListener value="#{collegeprofile}"
														target="#{accountManagementController.selectedUserCollegeProfile}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.selectedUserType}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.selectedUserClassification}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.selectedUkCollege}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.selectedUkDepartment}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.cpSelectedUKStatus}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.cpSelectedUKStartTerm}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.cpSelectedUKEndTerm}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.selectedCohortType}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.selectedCohortTerm}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.cpShortDesc}" />
												</a4j:commandLink>
												<h:outputText>a new College Profile.</h:outputText>
											</authz:authorize>
										</h:panelGroup>
									</h:panelGroup>
									<h:panelGroup layout="block"
										style="width:100%;vertical-align:100%">
										<rich:dataGrid id="cp_datagrid"
											value="#{accountManagementController.userCollegeProfileList}"
											var="collegeprofile" columns="1" elements="1">
											<rich:panel bodyClass="pbody">
												<f:facet name="header">
													<h:panelGroup layout="block"
														style="text-align:right;align:right;">
														<authz:authorize
															ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">
															<a4j:commandLink id="addlink"
																oncomplete="#{rich:component('addPanel')}.show()"
																reRender="addPanel">
																<h:graphicImage value="/images/icons/add.png"
																	style="border:0" styleClass="pic" alt="Add"/>
																<f:setPropertyActionListener value="#{true}"
																	target="#{accountManagementController.showCollegeProfileAddModalWindow}" />
																<f:setPropertyActionListener value="#{collegeprofile}"
																	target="#{accountManagementController.selectedUserCollegeProfile}" />
																<f:setPropertyActionListener value="#{null}"
																	target="#{accountManagementController.selectedUserType}" />
																<f:setPropertyActionListener value="#{null}"
																	target="#{accountManagementController.selectedUserClassification}" />
																<f:setPropertyActionListener value="#{null}"
																	target="#{accountManagementController.selectedUkCollege}" />
																<f:setPropertyActionListener value="#{null}"
																	target="#{accountManagementController.selectedUkDepartment}" />
																<f:setPropertyActionListener value="#{null}"
																	target="#{accountManagementController.cpSelectedUKStatus}" />
																<f:setPropertyActionListener value="#{null}"
																	target="#{accountManagementController.cpSelectedUKStartTerm}" />
																<f:setPropertyActionListener value="#{null}"
																	target="#{accountManagementController.cpSelectedUKEndTerm}" />
																<f:setPropertyActionListener value="#{null}"
																	target="#{accountManagementController.selectedCohortType}" />
																<f:setPropertyActionListener value="#{null}"
																	target="#{accountManagementController.selectedCohortTerm}" />
																<f:setPropertyActionListener value="#{null}"
																	target="#{accountManagementController.cpShortDesc}" />
															</a4j:commandLink>
															<rich:toolTip for="addlink"
																value="Add new College Profile" />
														</authz:authorize>
														<authz:authorize
															ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">
															<a4j:commandLink id="editlink"
																oncomplete="#{rich:component('editPanel')}.show()"
																reRender="editPanel">
																<h:graphicImage
																	value="/images/icons/page_white_edit.png"
																	style="border:0" styleClass="pic" alt="Edit"/>
																<f:setPropertyActionListener value="#{true}"
																	target="#{accountManagementController.showCollegeProfileEditModalWindow}" />
																<f:setPropertyActionListener value="#{collegeprofile}"
																	target="#{accountManagementController.selectedUserCollegeProfile}" />
																<f:setPropertyActionListener
																	value="#{collegeprofile.userType}"
																	target="#{accountManagementController.selectedUserType}" />
																<f:setPropertyActionListener
																	value="#{collegeprofile.userClassification}"
																	target="#{accountManagementController.selectedUserClassification}" />
																<f:setPropertyActionListener
																	value="#{collegeprofile.ukCollege}"
																	target="#{accountManagementController.selectedUkCollege}" />
																<f:setPropertyActionListener
																	value="#{collegeprofile.ukDepartment}"
																	target="#{accountManagementController.selectedUkDepartment}" />
																<f:setPropertyActionListener
																	value="#{collegeprofile.status}"
																	target="#{accountManagementController.cpSelectedUKStatus}" />
																<f:setPropertyActionListener
																	value="#{collegeprofile.startTerm}"
																	target="#{accountManagementController.cpSelectedUKStartTerm}" />
																<f:setPropertyActionListener
																	value="#{collegeprofile.endTerm}"
																	target="#{accountManagementController.cpSelectedUKEndTerm}" />
																<f:setPropertyActionListener
																	value="#{collegeprofile.cohortType}"
																	target="#{accountManagementController.selectedCohortType}" />
																<f:setPropertyActionListener
																	value="#{collegeprofile.cohortTerm}"
																	target="#{accountManagementController.selectedCohortTerm}" />
																<f:setPropertyActionListener
																	value="#{collegeprofile.shortDesc}"
																	target="#{accountManagementController.cpShortDesc}" />
															</a4j:commandLink>
															<rich:toolTip for="editlink"
																value="Edit this College Profile" />
														</authz:authorize>
														<authz:authorize
															ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_DELETE">
															<a4j:commandLink ajaxSingle="true" id="deletelink"
																oncomplete="#{rich:component('deletePanel')}.show()">
																<h:graphicImage value="/images/icons/delete.png"
																	style="border:0" styleClass="pic" alt="Delete"/>
																<f:setPropertyActionListener value="#{collegeprofile}"
																	target="#{accountManagementController.selectedUserCollegeProfile}" />
															</a4j:commandLink>
															<rich:toolTip for="deletelink"
																value="Delete this College Profile" />
														</authz:authorize>
													</h:panelGroup>
												</f:facet>
												<h:panelGrid columns="2">
													<h:outputText value="User Type:" styleClass="label"></h:outputText>
													<h:outputText value="#{collegeprofile.userType}" />
													<h:outputText value="User Classification:"
														styleClass="label"></h:outputText>
													<h:outputText value="#{collegeprofile.userClassification}" />
													<h:outputText value="College:" styleClass="label"></h:outputText>
													<h:outputText value="#{collegeprofile.ukCollege}" />
													<h:outputText value="Department:" styleClass="label"></h:outputText>
													<h:outputText value="#{collegeprofile.ukDepartment}" />
													<h:outputText value="Status:" styleClass="label"></h:outputText>
													<h:outputText value="#{collegeprofile.status}" />
													<h:outputText value="Start Term:" styleClass="label" />
													<h:outputText value="#{collegeprofile.startTerm}"></h:outputText>
													<h:outputText value="End Term:" styleClass="label" />
													<h:outputText value="#{collegeprofile.endTerm}"></h:outputText>
													<h:outputText value="Cohort Type:" styleClass="label" />
													<h:outputText value="#{collegeprofile.cohortType}"></h:outputText>
													<h:outputText value="Cohort Term:" styleClass="label" />
													<h:outputText value="#{collegeprofile.cohortTerm}"></h:outputText>
													<h:outputText value="Short Desc:" styleClass="label" />
													<h:outputText value="#{collegeprofile.shortDesc}"></h:outputText>

												</h:panelGrid>
											</rich:panel>
											<f:facet name="footer">
												<rich:datascroller></rich:datascroller>
											</f:facet>
										</rich:dataGrid>
									</h:panelGroup>
								</h:form>
							</rich:simpleTogglePanel>
							<rich:simpleTogglePanel switchType="client" label="User Program Profile" width="100%" height="450px">

								<h:form>
									<h:panelGroup id="ppAddStatus">
										<h:panelGroup
											rendered="#{accountManagementController.programProfileListEmpty}">
											<h:outputText
												value="No Program Profile available for this user."></h:outputText>
											<authz:authorize
												ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">

												<a4j:commandLink id="addPPlink"
													oncomplete="#{rich:component('addPPPanel')}.show()"
													reRender="addPPPanel">
													<h:outputText>Add</h:outputText>
													<h:graphicImage value="/images/icons/add.png"
														style="border:0" styleClass="pic" alt="Add"/>
													<f:setPropertyActionListener value="#{true}"
														target="#{accountManagementController.showProgramProfileAddModalWindow}" />
													<f:setPropertyActionListener value="#{programprofile}"
														target="#{accountManagementController.selectedUserProgramProfile}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.selectedProgram}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.selectedProgramDomain}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.selectedProgramGroup}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.selectedProgramTrack}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.selectedUKMajor}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.ppSelectedUKStatus}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.ppSelectedUKStartTerm}" />													
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.selectedUKCompleteTerm}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.selectedAdvisor}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.selectedFacultyAdvisor}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.degreeAwarded}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.ppShortDesc}" />
												</a4j:commandLink>
												<h:outputText>a new Program Profile.</h:outputText>
											</authz:authorize>
										</h:panelGroup>
									</h:panelGroup>
									<rich:dataGrid id="pp_datagrid"
										value="#{accountManagementController.userProgramProfileList}"
										var="programprofile" columns="1" elements="1">
										<rich:panel bodyClass="pbody">
											<f:facet name="header">
												<h:panelGroup layout="block" style="text-align:right;align:right;">
													<authz:authorize ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">

														<a4j:commandLink id="addPPlink"
															oncomplete="#{rich:component('addPPPanel')}.show()"
															reRender="addPPPanel">
															<h:graphicImage value="/images/icons/add.png"
																style="border:0" styleClass="pic" alt="Add"/>
															<f:setPropertyActionListener value="#{true}"
																target="#{accountManagementController.showProgramProfileAddModalWindow}" />
															<f:setPropertyActionListener value="#{programprofile}"
																target="#{accountManagementController.selectedUserProgramProfile}" />
															<f:setPropertyActionListener value="#{null}"
																target="#{accountManagementController.selectedProgram}" />
															<f:setPropertyActionListener value="#{null}"
																target="#{accountManagementController.selectedProgramDomain}" />
															<f:setPropertyActionListener value="#{null}"
																target="#{accountManagementController.selectedProgramGroup}" />
															<f:setPropertyActionListener value="#{null}"
																target="#{accountManagementController.selectedProgramTrack}" />
															<f:setPropertyActionListener value="#{null}"
																target="#{accountManagementController.selectedUKMajor}" />
															<f:setPropertyActionListener value="#{null}"
																target="#{accountManagementController.ppSelectedUKStatus}" />
															<f:setPropertyActionListener value="#{null}"
																target="#{accountManagementController.ppSelectedUKStartTerm}" />															
															<f:setPropertyActionListener value="#{null}"
																target="#{accountManagementController.selectedUKCompleteTerm}" />
															<f:setPropertyActionListener value="#{null}"
																target="#{accountManagementController.selectedAdvisor}" />
															<f:setPropertyActionListener value="#{null}"
																target="#{accountManagementController.selectedFacultyAdvisor}" />
															<f:setPropertyActionListener value="#{null}"
																target="#{accountManagementController.degreeAwarded}" />
															<f:setPropertyActionListener value="#{null}"
																target="#{accountManagementController.ppShortDesc}" />
														</a4j:commandLink>
														<rich:toolTip for="addPPlink" value="Add new Program Profile" />
													</authz:authorize>
													<authz:authorize
														ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">

														<a4j:commandLink id="editPPlink"
															oncomplete="#{rich:component('editPPPanel')}.show()"
															reRender="editPPPanel">
															<h:graphicImage value="/images/icons/page_white_edit.png"
																style="border:0" styleClass="pic" alt="Edit"/>
															<f:setPropertyActionListener value="#{true}"
																target="#{accountManagementController.showProgramProfileEditModalWindow}" />
															<f:setPropertyActionListener value="#{programprofile}"
																target="#{accountManagementController.selectedUserProgramProfile}" />
															<f:setPropertyActionListener
																value="#{programprofile.program}"
																target="#{accountManagementController.selectedProgram}" />
															<f:setPropertyActionListener
																value="#{programprofile.programDomain}"
																target="#{accountManagementController.selectedProgramDomain}" />
															<f:setPropertyActionListener
																value="#{programprofile.programGroup}"
																target="#{accountManagementController.selectedProgramGroup}" />
															<f:setPropertyActionListener
																value="#{programprofile.programTrack}"
																target="#{accountManagementController.selectedProgramTrack}" />
															<f:setPropertyActionListener
																value="#{programprofile.ukMajor}"
																target="#{accountManagementController.selectedUKMajor}" />
															<f:setPropertyActionListener
																value="#{programprofile.ukStatus}"
																target="#{accountManagementController.ppSelectedUKStatus}" />
															<f:setPropertyActionListener
																value="#{programprofile.ukStartTerm}"
																target="#{accountManagementController.ppSelectedUKStartTerm}" />															
															<f:setPropertyActionListener
																value="#{programprofile.ukCompleteTerm}"
																target="#{accountManagementController.selectedUKCompleteTerm}" />
															<f:setPropertyActionListener
																value="#{programprofile.advisor}"
																target="#{accountManagementController.selectedAdvisor}" />
															<f:setPropertyActionListener
																value="#{programprofile.facultyAdvisor}"
																target="#{accountManagementController.selectedFacultyAdvisor}" />
															<f:setPropertyActionListener
																value="#{programprofile.degreeAwarded}"
																target="#{accountManagementController.degreeAwarded}" />
															<f:setPropertyActionListener
																value="#{programprofile.shortDesc}"
																target="#{accountManagementController.ppShortDesc}" />
														</a4j:commandLink>
														<rich:toolTip for="editPPlink"
															value="Edit this Program Profile" />
													</authz:authorize>
													<authz:authorize
														ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_DELETE">

														<a4j:commandLink ajaxSingle="true" id="deletePPlink"
															oncomplete="#{rich:component('deletePPPanel')}.show()">
															<h:graphicImage value="/images/icons/delete.png"
																style="border:0" styleClass="pic" alt="Delete"/>
															<f:setPropertyActionListener value="#{programprofile}"
																target="#{accountManagementController.selectedUserProgramProfile}" />
														</a4j:commandLink>
														<rich:toolTip for="deletePPlink"
															value="Delete this Program Profile" />
													</authz:authorize>
												</h:panelGroup>
											</f:facet>
											<h:panelGrid columns="2">
												<h:outputText value="Program:" styleClass="label"/>
												<h:outputText value="#{programprofile.program}" />
												<h:outputText value="Program Domain:" styleClass="label"/>
												<h:outputText value="#{programprofile.programDomain}" />
												<h:outputText value="Program Track:" styleClass="label"/>
												<h:outputText value="#{programprofile.programTrack}" />
												<h:outputText value="Program Group:" styleClass="label"/>
												<h:outputText value="#{programprofile.programGroup}" />
												<h:outputText value="Major:" styleClass="label"/>
												<h:outputText value="#{programprofile.ukMajor}" />
												<h:outputText value="Status:" styleClass="label" />
												<h:outputText value="#{programprofile.ukStatus}"/>
												<h:outputText value="Start Term:" styleClass="label" />
												<h:outputText value="#{programprofile.ukStartTerm}"/>												
												<h:outputText value="End Term:" styleClass="label" />
												<h:outputText value="#{programprofile.ukCompleteTerm}"/>
												<h:outputText value="Professional Advisor:" styleClass="label" />
												<h:outputText value="#{programprofile.advisor}"/>												
												<h:outputText value="Faculty Advisor:" styleClass="label" />
												<h:outputText value="#{programprofile.facultyAdvisor}"/>
												<h:outputText value="Degree Awarded?:" styleClass="label" />
												<h:outputText value="#{programprofile.degreeAwarded}"/>
												<h:outputText value="Short Desc:" styleClass="label" />
												<h:outputText value="#{programprofile.shortDesc}"/>
											</h:panelGrid>
										</rich:panel>
										<f:facet name="footer">
											<rich:datascroller/>
										</f:facet>
									</rich:dataGrid>
								</h:form>
							</rich:simpleTogglePanel>

							<rich:simpleTogglePanel switchType="client"
								label="User Personal Profile" width="100%" height="450px">
								<h:form>
									<h:panelGroup id="pepAddStatus">
										<h:panelGroup
											rendered="#{accountManagementController.personalProfileListEmpty}">
											<h:outputText
												value="No Personal Profile available for this user."></h:outputText>
											<authz:authorize
												ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">

												<a4j:commandLink id="addPEPlink"
													oncomplete="#{rich:component('addPEPPanel')}.show()"
													reRender="addPEPPanel">
													<h:outputText>Add</h:outputText>
													<h:graphicImage value="/images/icons/add.png"
														style="border:0" styleClass="pic" alt="Add"/>
													<f:setPropertyActionListener value="#{true}"
														target="#{accountManagementController.showPersonalProfileAddModalWindow}" />
													<f:setPropertyActionListener value="#{personalprofile}"
														target="#{accountManagementController.selectedUserPersonalProfile}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.selectedEthnic}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.citizen}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.diplomaType}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.diplomaState}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.diplomaYear}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.highSchool}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.highSchoolCity}" />
													<f:setPropertyActionListener value="#{null}"
														target="#{accountManagementController.highSchoolCounty}" />
												</a4j:commandLink>
												<h:outputText>a new Personal Profile.</h:outputText>
											</authz:authorize>
										</h:panelGroup>
									</h:panelGroup>
									<rich:dataGrid id="pep_datagrid"
										value="#{accountManagementController.userPersonalProfile}"
										var="personalprofile" columns="1" elements="1">
										<rich:panel bodyClass="pbody">
											<f:facet name="header">
												<h:panelGroup layout="block"
													style="text-align:right;align:right;">
													<authz:authorize
														ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">
														<a4j:commandLink id="addPEPlink"
															oncomplete="#{rich:component('addPEPPanel')}.show()"
															reRender="addPEPPanel">
															<h:graphicImage value="/images/icons/add.png"
																style="border:0" styleClass="pic" alt="Add"/>
															<f:setPropertyActionListener value="#{true}"
																target="#{accountManagementController.showPersonalProfileAddModalWindow}" />
															<f:setPropertyActionListener value="#{personalprofile}"
																target="#{accountManagementController.selectedUserPersonalProfile}" />
															<f:setPropertyActionListener value="#{null}"
																target="#{accountManagementController.selectedEthnic}" />
															<f:setPropertyActionListener value="#{null}"
																target="#{accountManagementController.citizen}" />
															<f:setPropertyActionListener value="#{null}"
																target="#{accountManagementController.diplomaType}" />
															<f:setPropertyActionListener value="#{null}"
																target="#{accountManagementController.diplomaState}" />
															<f:setPropertyActionListener value="#{null}"
																target="#{accountManagementController.diplomaYear}" />
															<f:setPropertyActionListener value="#{null}"
																target="#{accountManagementController.highSchool}" />
															<f:setPropertyActionListener value="#{null}"
																target="#{accountManagementController.highSchoolCity}" />
															<f:setPropertyActionListener value="#{null}"
																target="#{accountManagementController.highSchoolCounty}" />
														</a4j:commandLink>
														<rich:toolTip for="addPEPlink"
															value="Add new Personal Profile" />
													</authz:authorize>
													<authz:authorize
														ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">

														<a4j:commandLink id="editPEPlink"
															oncomplete="#{rich:component('editPEPPanel')}.show()"
															reRender="editPEPPanel">
															<h:graphicImage value="/images/icons/page_white_edit.png"
																style="border:0" styleClass="pic" alt="Edit"/>
															<f:setPropertyActionListener value="#{true}"
																target="#{accountManagementController.showPersonalProfileEditModalWindow}" />
															<f:setPropertyActionListener value="#{personalprofile}"
																target="#{accountManagementController.selectedUserPersonalProfile}" />
															<f:setPropertyActionListener
																value="#{personalprofile.ethnic}"
																target="#{accountManagementController.selectedEthnic}" />
															<f:setPropertyActionListener
																value="#{personalprofile.citizen}"
																target="#{accountManagementController.citizen}" />
															<f:setPropertyActionListener
																value="#{personalprofile.diplomaType}"
																target="#{accountManagementController.diplomaType}" />
															<f:setPropertyActionListener
																value="#{personalprofile.diplomaState}"
																target="#{accountManagementController.diplomaState}" />
															<f:setPropertyActionListener
																value="#{personalprofile.diplomaYear}"
																target="#{accountManagementController.diplomaYear}" />
															<f:setPropertyActionListener
																value="#{personalprofile.highSchool}"
																target="#{accountManagementController.highSchool}" />
															<f:setPropertyActionListener
																value="#{personalprofile.highSchoolCity}"
																target="#{accountManagementController.highSchoolCity}" />
															<f:setPropertyActionListener
																value="#{personalprofile.highSchoolCounty}"
																target="#{accountManagementController.highSchoolCounty}" />
														</a4j:commandLink>
														<rich:toolTip for="editPEPlink"
															value="Edit this Personal Profile" />
													</authz:authorize>
													<authz:authorize
														ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_DELETE">

														<a4j:commandLink ajaxSingle="true" id="deletePEPlink"
															oncomplete="#{rich:component('deletePEPPanel')}.show()">
															<h:graphicImage value="/images/icons/delete.png"
																style="border:0" styleClass="pic" alt="Delete"/>
															<f:setPropertyActionListener value="#{personalprofile}"
																target="#{accountManagementController.selectedUserPersonalProfile}" />
														</a4j:commandLink>
														<rich:toolTip for="deletePEPlink"
															value="Delete this Personal Profile" />
													</authz:authorize>
												</h:panelGroup>
											</f:facet>
											<h:panelGrid columns="2">
												<h:outputText value="Ethnic:" styleClass="label"></h:outputText>
												<h:outputText value="#{personalprofile.ethnic}" />
												<h:outputText value="Citizenship:" styleClass="label"></h:outputText>
												<h:outputText value="#{personalprofile.citizen}" />
												<h:outputText value="Diploma Type:" styleClass="label"></h:outputText>
												<h:outputText value="#{personalprofile.diplomaType}" />
												<h:outputText value="Diploma State:" styleClass="label"></h:outputText>
												<h:outputText value="#{personalprofile.diplomaState}" />
												<h:outputText value="Diploma Year:" styleClass="label"></h:outputText>
												<h:outputText value="#{personalprofile.diplomaYear}" />
												<h:outputText value="High School:" styleClass="label" />
												<h:outputText value="#{personalprofile.highSchool}"></h:outputText>
												<h:outputText value="High School City:" styleClass="label" />
												<h:outputText value="#{personalprofile.highSchoolCity}"></h:outputText>
												<h:outputText value="High School County:" styleClass="label" />
												<h:outputText value="#{personalprofile.highSchoolCounty}"></h:outputText>

											</h:panelGrid>
										</rich:panel>
										<f:facet name="footer">
											<rich:datascroller></rich:datascroller>
										</f:facet>
									</rich:dataGrid>
								</h:form>
							</rich:simpleTogglePanel>
						</h:panelGrid>
						<h:panelGrid columns="1" style="width:100%;">
							<authz:authorize
								ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_ADVISOR,ROLE_STUDENT">
								<rich:separator lineType="beveled" height="8" align="center" />
								<br />
								<h:outputText value="User Academic Profile: "
									styleClass="boldText"></h:outputText>
								<rich:separator lineType="dotted" height="4" align="center" />
								<br />
								<h:panelGroup layout="block" style="width:100%">
									<jsp:include page="/pages/account/academic-profile/index.jsp"></jsp:include>
								</h:panelGroup>
							</authz:authorize>
							<authz:authorize
								ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_ADVISOR,ROLE_ADVISING_MANAGER,ROLE_STUDENT">
								<rich:separator lineType="beveled" height="8" align="center" />
								<br />
								<h:outputText value="Recent Activities: " styleClass="boldText"></h:outputText>
								<rich:separator lineType="dotted" height="4" align="center" />
								<br />
								<h:panelGroup layout="block" style="width:100%">
									<h:panelGroup styleClass="centerBlock" layout="block">
										<rich:tabPanel switchType="ajax" immediate="true" width="100%">
											<rich:tab label="Appointments">
												<a4j:include
													viewId="/pages/advising/ems-view-advisingsession.jsp"
													layout="block" />
											</rich:tab>
											<rich:tab label="Conferences">
												<a4j:include viewId="/pages/conference/user-conference.jsp" />
											</rich:tab>
											<authz:authorize ifNotGranted="ROLE_STUDENT">
												<rich:tab label="Notes">
													<a4j:include viewId="/pages/notes/ems-view-notes.jsp" />
												</rich:tab>
											</authz:authorize>
										</rich:tabPanel>
									</h:panelGroup>
								</h:panelGroup>
							</authz:authorize>
							<rich:separator lineType="beveled" height="8" align="center" />
							<br />
							<h:panelGroup layout="block" style="width:100%">
								<rich:simpleTogglePanel switchType="ajax"
									label="Other Information" opened="false" width="99.5%">
									<h:panelGroup styleClass="centerBlock" layout="block">
										<rich:tabPanel switchType="ajax" immediate="true" width="100%">
											<authz:authorize
												ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT,ROLE_STUDENT_ACCOUNT_MANAGER_VIEW">
												<rich:tab label="Role">
													<a4j:include viewId="/pages/account/role/index.jsp" />
												</rich:tab>
											</authz:authorize>
											<rich:tab label="Email Address">
												<a4j:include viewId="/pages/account/email-address/index.jsp" />
											</rich:tab>
											<rich:tab label="Phone">
												<a4j:include viewId="/pages/account/phone/index.jsp" />
											</rich:tab>
											<rich:tab label="Address">
												<a4j:include viewId="/pages/account/address/index.jsp" />
											</rich:tab>
										</rich:tabPanel>
									</h:panelGroup>
								</rich:simpleTogglePanel>

							</h:panelGroup>
							<a4j:outputPanel ajaxRendered="true" style="align:center">
								<h:panelGrid columns="1" width="975px">
									<authz:authorize ifAllGranted="ROLE_DEVELOPER">
										<h:panelGroup>
											<a4j:log id="debug" popup="false"
												title="CEPIS - Ajax Debug Window" rendered="true"
												width="900px" height="100px"></a4j:log>
										</h:panelGroup>
									</authz:authorize>
								</h:panelGrid>
							</a4j:outputPanel>
						</h:panelGrid>
					</h:panelGroup>
				</rich:layoutPanel>
			</rich:layout>
		</h:panelGroup>
		<!-- Modal Panels -->
		<!-- Modal Panels for College Profile -->
		<a4j:outputPanel layout="none">
			<authz:authorize
				ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">
				<rich:modalPanel id="addPanel" autosized="true" width="450"
					rendered="#{accountManagementController.showCollegeProfileAddModalWindow}">
					<f:facet name="header">
						<h:outputText value="Add New College Profile" />
					</f:facet>
					<f:facet name="controls">
						<h:panelGroup>
							<h:graphicImage value="/images/icons/cancel.png" id="hideaddlink"
								styleClass="hidelink" alt="X"/>
							<rich:componentControl for="addPanel" attachTo="hideaddlink"
								operation="hide" event="onclick" />
						</h:panelGroup>
					</f:facet>
					<h:form>
						<rich:messages style="color:red;"></rich:messages>
						<h:panelGrid columns="1">
							<h:panelGrid columns="2">
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="User Type: *" /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" onchange="sumbit()"
									value="#{accountManagementController.selectedUserType}"
									size="1" converter="#{UserTypeDataConverter}"
									style="width:200px" required="true"
									requiredMessage="User Type: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.userTypeList}"
										var="usertype" itemLabel="#{usertype.shortDesc}" />
									<f:validator validatorId="UserTypeDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="User Classification: *" /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" onchange="sumbit()"
									value="#{accountManagementController.selectedUserClassification}"
									size="1" converter="#{UserClassificationDataConverter}"
									style="width:200px" required="true"
									requiredMessage="User classification: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.userClassificationList}"
										var="userclassification"
										itemLabel="#{userclassification.shortDesc}" />
									<f:validator validatorId="UserClassificationDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="College: *" /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" onchange="sumbit()"
									value="#{accountManagementController.selectedUkCollege}"
									size="1" converter="#{UKCollegeDataConverter}"
									style="width:200px" required="true"
									requiredMessage="College: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.ukCollegeList}"
										var="ukcollege" itemLabel="#{ukcollege.collegeName}" />
									<f:validator validatorId="UKCollegeDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Department: *" /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" onchange="sumbit()"
									value="#{accountManagementController.selectedUkDepartment}"
									size="1" converter="#{UKDepartmentDataConverter}"
									style="width:200px" required="true"
									requiredMessage="Department: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.ukDepartmentList}"
										var="ukdepartment" itemLabel="#{ukdepartment.departmentName}" />
									<f:validator validatorId="UKDepartmentDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Status: " /></font>
								</h:panelGroup>
								<h:selectOneListbox style="width:200px" onchange="sumbit()"
									immediate="true"
									value="#{accountManagementController.cpSelectedUKStatus}"
									size="1" converter="#{UKStatusDataConverter}">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.ukStatusList}"
										var="ukStatus" itemLabel="#{ukStatus.shortDesc}" />
									<f:validator validatorId="UKStatusDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Start Term: " /></font>
								</h:panelGroup>
								<h:selectOneListbox style="width:200px" onchange="sumbit()"
									immediate="true"
									value="#{accountManagementController.cpSelectedUKStartTerm}"
									size="1" converter="#{UKTermDataConverter}">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.ukTermList}"
										var="ukTerm" itemLabel="#{ukTerm.ukTermCode} | #{ukTerm.description}" />
									<f:validator validatorId="UKTermDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="End Term: " /></font>
								</h:panelGroup>
								<h:selectOneListbox style="width:200px" onchange="sumbit()"
									immediate="true"
									value="#{accountManagementController.cpSelectedUKEndTerm}"
									size="1" converter="#{UKTermDataConverter}">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.ukTermList}"
										var="ukTerm" itemLabel="#{ukTerm.shortDesc}" />
									<f:validator validatorId="UKTermDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Cohort Type: " /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" onchange="sumbit()"
									value="#{accountManagementController.selectedCohortType}"
									size="1" converter="#{CohortTypeDataConverter}"
									style="width:200px">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.cohortTypeList}"
										var="cohorttype" itemLabel="#{cohorttype.shortDesc}" />
									<f:validator validatorId="CohortTypeDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Cohort Term: " /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" onchange="sumbit()"
									value="#{accountManagementController.selectedCohortTerm}"
									size="1" converter="#{CohortTermDataConverter}"
									style="width:200px">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.cohortTermList}"
										var="cohortterm" itemLabel="#{cohortterm.shortDesc}" />
									<f:validator validatorId="CohortTermDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
										value="Short Description :"></h:outputText></font>
									<br>
									<h:outputText
										value="Short description for the drop-down box. Max 255 characters"
										style="color:gray"></h:outputText>
								</h:panelGroup>
								<h:inputTextarea
									value="#{accountManagementController.cpShortDesc}"
									style="width:200px" rows="2">
									<f:validateLength minimum="0" maximum="255" />
								</h:inputTextarea>
							</h:panelGrid>
							<a4j:commandButton value="Add" reRender="cpAddStatus,cp_datagrid"
								action="#{accountManagementController.addUserCollegeProfileToUser}"
								oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('addPanel')}.hide();"></a4j:commandButton>

						</h:panelGrid>
					</h:form>
				</rich:modalPanel>
			</authz:authorize>
		</a4j:outputPanel>
		<a4j:outputPanel layout="none">
			<authz:authorize
				ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">
				<rich:modalPanel id="editPanel" autosized="true" width="450"
					rendered="#{accountManagementController.showCollegeProfileEditModalWindow}">
					<f:facet name="header">
						<h:outputText value="Edit Current College Profile" />
					</f:facet>
					<f:facet name="controls">
						<h:panelGroup>
							<h:graphicImage value="/images/icons/cancel.png"
								id="hideeditlink" styleClass="hidelink" alt="X"/>
							<rich:componentControl for="editPanel" attachTo="hideeditlink"
								operation="hide" event="onclick" />
						</h:panelGroup>
					</f:facet>
					<h:form>
						<rich:messages style="color:red;"></rich:messages>

						<h:panelGrid columns="1">

							<h:panelGrid columns="2">
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="User Type: *" /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" onchange="sumbit()"
									value="#{accountManagementController.selectedUserType}"
									size="1" converter="#{UserTypeDataConverter}"
									style="width:200px" required="true"
									requiredMessage="User Type: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.userTypeList}"
										var="usertype" itemLabel="#{usertype.shortDesc}" />
									<f:validator validatorId="UserTypeDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="User Classification: *" /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" onchange="sumbit()"
									value="#{accountManagementController.selectedUserClassification}"
									size="1" converter="#{UserClassificationDataConverter}"
									style="width:200px" required="true"
									requiredMessage="User classification: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.userClassificationList}"
										var="userclassification"
										itemLabel="#{userclassification.shortDesc}" />
									<f:validator validatorId="UserClassificationDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="College: *" /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" onchange="sumbit()"
									value="#{accountManagementController.selectedUkCollege}"
									size="1" converter="#{UKCollegeDataConverter}"
									style="width:200px" required="true"
									requiredMessage="College: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.ukCollegeList}"
										var="ukcollege" itemLabel="#{ukcollege.collegeName}" />
									<f:validator validatorId="UKCollegeDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Department: *" /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" onchange="sumbit()"
									value="#{accountManagementController.selectedUkDepartment}"
									size="1" converter="#{UKDepartmentDataConverter}"
									style="width:200px" required="true"
									requiredMessage="Department: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.ukDepartmentList}"
										var="ukdepartment" itemLabel="#{ukdepartment.departmentName}" />
									<f:validator validatorId="UKDepartmentDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Status: " /></font>
								</h:panelGroup>
								<h:selectOneListbox style="width:200px" onchange="sumbit()"
									immediate="true"
									value="#{accountManagementController.cpSelectedUKStatus}"
									size="1" converter="#{UKStatusDataConverter}">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.ukStatusList}"
										var="ukStatus" itemLabel="#{ukStatus.shortDesc}" />
									<f:validator validatorId="UKStatusDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Start Term: " /></font>
								</h:panelGroup>
								<h:selectOneListbox style="width:200px" onchange="sumbit()"
									immediate="true"
									value="#{accountManagementController.cpSelectedUKStartTerm}"
									size="1" converter="#{UKTermDataConverter}">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.ukTermList}"
										var="ukTerm" itemLabel="#{ukTerm.ukTermCode} | #{ukTerm.description}" />
									<f:validator validatorId="UKTermDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="End Term: " /></font>
								</h:panelGroup>
								<h:selectOneListbox style="width:200px" onchange="sumbit()"
									immediate="true"
									value="#{accountManagementController.cpSelectedUKEndTerm}"
									size="1" converter="#{UKTermDataConverter}">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.ukTermList}"
										var="ukTerm" itemLabel="#{ukTerm.shortDesc}" />
									<f:validator validatorId="UKTermDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Cohort Type: " /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" onchange="sumbit()"
									value="#{accountManagementController.selectedCohortType}"
									size="1" converter="#{CohortTypeDataConverter}"
									style="width:200px">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.cohortTypeList}"
										var="cohorttype" itemLabel="#{cohorttype.shortDesc}" />
									<f:validator validatorId="CohortTypeDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Cohort Term: " /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" onchange="sumbit()"
									value="#{accountManagementController.selectedCohortTerm}"
									size="1" converter="#{CohortTermDataConverter}"
									style="width:200px">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.cohortTermList}"
										var="cohortterm" itemLabel="#{cohortterm.shortDesc}" />
									<f:validator validatorId="CohortTermDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
										value="Short Description :"></h:outputText></font>
									<br>
									<h:outputText
										value="Short description for the drop-down box. Max 255 characters"
										style="color:gray"></h:outputText>
								</h:panelGroup>
								<h:inputTextarea
									value="#{accountManagementController.cpShortDesc}"
									style="width:200px" rows="2">
									<f:validateLength minimum="0" maximum="255" />
								</h:inputTextarea>
							</h:panelGrid>

							<a4j:commandButton value="Save" reRender="cp_datagrid"
								action="#{accountManagementController.editUserCollegeProfile}"
								oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('editPanel')}.hide();"></a4j:commandButton>

						</h:panelGrid>
					</h:form>
				</rich:modalPanel>
			</authz:authorize>
		</a4j:outputPanel>

		<authz:authorize
			ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_DELETE">
			<rich:modalPanel id="deletePanel" autosized="true" width="200">
				<f:facet name="header">
					<h:outputText value="Delete this College Profile?"
						style="padding-right:15px;" />
				</f:facet>
				<f:facet name="controls">
					<h:panelGroup>
						<h:graphicImage value="/images/icons/cancel.png"
							styleClass="hidelink" id="hidedeletelink" alt="X"/>
						<rich:componentControl for="deletePanel" attachTo="hidedeletelink"
							operation="hide" event="onclick" />
					</h:panelGroup>
				</f:facet>
				<h:form>
					<table width="100%">
						<tbody>
							<tr>
								<td align="center" width="50%"><a4j:commandButton
									value="Yes" ajaxSingle="true"
									reRender="cpAddStatus,cp_datagrid"
									action="#{accountManagementController.removeUserCollegeProfileFromUser}"
									oncomplete="#{rich:component('deletePanel')}.hide();" /></td>
								<td align="center" width="50%"><a4j:commandButton
									value="Cancel"
									onclick="#{rich:component('deletePanel')}.hide();return false;" />
								</td>
							</tr>
						</tbody>
					</table>
				</h:form>
			</rich:modalPanel>
		</authz:authorize>
		<!-- Modal Panels for College Profile -->
		<a4j:outputPanel layout="none">
			<authz:authorize
				ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">
				<rich:modalPanel id="addPPPanel" autosized="true" width="450"
					rendered="#{accountManagementController.showProgramProfileAddModalWindow}">
					<f:facet name="header">
						<h:outputText value="Add New Program Profile" />
					</f:facet>
					<f:facet name="controls">
						<h:panelGroup>
							<h:graphicImage value="/images/icons/cancel.png"
								id="hidePPaddlink" styleClass="hidelink" alt="X"/>
							<rich:componentControl for="addPPPanel" attachTo="hidePPaddlink"
								operation="hide" event="onclick" />
						</h:panelGroup>
					</f:facet>
					<h:form>
						<rich:messages style="color:red;"></rich:messages>
						<h:panelGrid columns="1">
							<h:panelGrid columns="2">
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Program Domain: *" /></font>
								</h:panelGroup>
								<h:selectOneListbox id="program_domain_list_id"
									style="width:200px"
									value="#{accountManagementController.selectedProgramDomain}"
									size="1" converter="#{ProgramDomainDataConverter}"
									required="true"
									requiredMessage="Program Domain: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.programDomainList}"
										var="programDomain"
										itemLabel="#{programDomain.shortDesc} (#{programDomain.status})" />
									<f:validator validatorId="ProgramDomainDataValidator" />
									<a4j:support event="onchange" ajaxSingle="true"
										limitToList="true"
										actionListener="#{accountManagementController.valueChangeProgramDomain}"
										reRender="program_list_id" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Program: *" /></font>
								</h:panelGroup>
								<h:selectOneListbox id="program_list_id" style="width:200px"
									value="#{accountManagementController.selectedProgram}" size="1"
									converter="#{ProgramDataConverter}" required="true"
									requiredMessage="Program: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.programListInProgramDomain}"
										var="program"
										itemLabel="#{program.shortDesc} (#{program.status})" />
									<f:validator validatorId="ProgramDataValidator" />

								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Program Group: *" /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" style="width:200px"
									value="#{accountManagementController.selectedProgramGroup}"
									onchange="sumbit()" size="1"
									converter="#{ProgramGroupDataConverter}" required="true"
									requiredMessage="Program Group: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.programGroupList}"
										var="programGroup"
										itemLabel="#{programGroup.shortDesc} (#{programGroup.status})" />
									<f:validator validatorId="ProgramGroupDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Program Track: *" /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" style="width:200px"
									value="#{accountManagementController.selectedProgramTrack}"
									onchange="sumbit()" size="1"
									converter="#{ProgramTrackDataConverter}" required="true"
									requiredMessage="Program Track: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.programTrackList}"
										var="programTrack"
										itemLabel="#{programTrack.shortDesc} (#{programTrack.status})" />
									<f:validator validatorId="ProgramTrackDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Major: *" /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" style="width:200px"
									value="#{accountManagementController.selectedUKMajor}" size="1"
									onchange="sumbit()" converter="#{UKMajorDataConverter}"
									required="true" requiredMessage="Major: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.ukMajorList}"
										var="ukMajor"
										itemLabel="#{ukMajor.shortDesc} (#{ukMajor.status})" />
									<f:validator validatorId="UKMajorDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Status: " /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" style="width:200px"
									value="#{accountManagementController.ppSelectedUKStatus}"
									size="1" onchange="sumbit()"
									converter="#{UKStatusDataConverter}">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.ukStatusList}"
										var="ukStatus" itemLabel="#{ukStatus.shortDesc}" />
									<f:validator validatorId="UKStatusDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Start Term: *" /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" style="width:200px"
									value="#{accountManagementController.ppSelectedUKStartTerm}"
									size="1" onchange="sumbit()" converter="#{UKTermDataConverter}"
									required="true"
									requiredMessage="Start Term: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.ukTermList}"
										var="ukTerm" itemLabel="#{ukTerm.ukTermCode} | #{ukTerm.description}" />
									<f:validator validatorId="UKTermDataValidator" />
								</h:selectOneListbox>								
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma">
										<h:outputText value="End Term:" />
									</font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" style="width:200px"
								value="#{accountManagementController.selectedUKCompleteTerm}"
								onchange="sumbit()" size="1" converter="#{UKTermDataConverter}">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItems value="#{cepisGlobalComponentConfigurator.ukTermList}"
									var="ukTerm" itemLabel="#{ukTerm.shortDesc}" />
									<f:validator validatorId="UKTermDataValidator" />
								</h:selectOneListbox>
								
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma">
										<h:outputText value="Anticipated Complete Term:" />
									</font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" style="width:200px"
								value="#{accountManagementController.selectedUKAnticipatedCompleteTerm}"
								onchange="sumbit()" size="1" converter="#{UKTermDataConverter}">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItems value="#{cepisGlobalComponentConfigurator.ukTermList}"
									var="ukTerm" itemLabel="#{ukTerm.shortDesc}" />
									<f:validator validatorId="UKTermDataValidator" />
								</h:selectOneListbox>
								
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Professional Advisor: *" /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" style="width:200px"
									value="#{accountManagementController.selectedAdvisor}" size="1"
									onchange="sumbit()" converter="#{AdvisorDataConverter}"
									required="true" requiredMessage="Advisor: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.advisorList}"
										var="advisor" itemLabel="#{advisor.shortDesc}" />
									<f:validator validatorId="AdvisorDataValidator" />
								</h:selectOneListbox>
								
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Faculty Advisor:" /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" style="width:200px"
									value="#{accountManagementController.selectedFacultyAdvisor}" size="1"
									onchange="sumbit()" converter="#{FacultyAdvisorDataConverter}">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.facultyAdvisorList}"
										var="facultyAdvisor" itemLabel="#{facultyAdvisor.shortDesc}" />
									<f:validator validatorId="FacultyAdvisorDataValidator" />
								</h:selectOneListbox>
								
								
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Degree Awarded: " /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" style="width:200px"
									value="#{accountManagementController.degreeAwarded}" size="1"
									onchange="sumbit()">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItem itemLabel="NO" itemValue="0" />
									<f:selectItem itemLabel="YES" itemValue="1" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
										value="Short Description :"></h:outputText></font>
									<br>
									<h:outputText
										value="Short description for the drop-down box. Max 255 characters"
										style="color:gray"></h:outputText>
								</h:panelGroup>
								<h:inputTextarea
									value="#{accountManagementController.ppShortDesc}"
									style="width:200px" rows="2">
									<f:validateLength minimum="0" maximum="255" />
								</h:inputTextarea>
							</h:panelGrid>
							<a4j:commandButton value="Add" reRender="ppAddStatus,pp_datagrid"
								action="#{accountManagementController.addUserProgramProfileToUser}"
								oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('addPPPanel')}.hide();"></a4j:commandButton>

						</h:panelGrid>
					</h:form>
				</rich:modalPanel>
			</authz:authorize>
		</a4j:outputPanel>
		<a4j:outputPanel layout="none">
			<authz:authorize
				ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">
				<rich:modalPanel id="editPPPanel" autosized="true" width="450"
					rendered="#{accountManagementController.showProgramProfileEditModalWindow}">
					<f:facet name="header">
						<h:outputText value="Edit Current Program Profile" />
					</f:facet>
					<f:facet name="controls">
						<h:panelGroup>
							<h:graphicImage value="/images/icons/cancel.png"
								id="hidePPeditlink" styleClass="hidelink" alt="X"/>
							<rich:componentControl for="editPPPanel"
								attachTo="hidePPeditlink" operation="hide" event="onclick" />
						</h:panelGroup>
					</f:facet>
					<h:form>
						<rich:messages style="color:red;"></rich:messages>

						<h:panelGrid columns="1">

							<h:panelGrid columns="2">
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Program Domain: *" /></font>
								</h:panelGroup>
								<h:selectOneListbox id="program_domain_list_id"
									style="width:200px"
									value="#{accountManagementController.selectedProgramDomain}"
									size="1" converter="#{ProgramDomainDataConverter}"
									required="true"
									requiredMessage="Program Domain: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.programDomainList}"
										var="programDomain"
										itemLabel="#{programDomain.shortDesc} (#{programDomain.status})" />
									<f:validator validatorId="ProgramDomainDataValidator" />
									<a4j:support event="onchange" ajaxSingle="true"
										limitToList="true"
										actionListener="#{accountManagementController.valueChangeProgramDomain}"
										reRender="program_list_id" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Program: *" /></font>
								</h:panelGroup>
								<h:selectOneListbox id="program_list_id" style="width:200px"
									value="#{accountManagementController.selectedProgram}" size="1"
									converter="#{ProgramDataConverter}" required="true"
									requiredMessage="Program: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.programListInProgramDomain}"
										var="program"
										itemLabel="#{program.shortDesc} (#{program.status})" />
									<f:validator validatorId="ProgramDataValidator" />

								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Program Group: *" /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" style="width:200px"
									value="#{accountManagementController.selectedProgramGroup}"
									onchange="sumbit()" size="1"
									converter="#{ProgramGroupDataConverter}" required="true"
									requiredMessage="Program Group: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.programGroupList}"
										var="programGroup"
										itemLabel="#{programGroup.shortDesc} (#{programGroup.status})" />
									<f:validator validatorId="ProgramGroupDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Program Track: *" /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" style="width:200px"
									value="#{accountManagementController.selectedProgramTrack}"
									onchange="sumbit()" size="1"
									converter="#{ProgramTrackDataConverter}" required="true"
									requiredMessage="Program Track: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.programTrackList}"
										var="programTrack"
										itemLabel="#{programTrack.shortDesc} (#{programTrack.status})" />
									<f:validator validatorId="ProgramTrackDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Major: *" /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" style="width:200px"
									value="#{accountManagementController.selectedUKMajor}" size="1"
									onchange="sumbit()" converter="#{UKMajorDataConverter}"
									required="true" requiredMessage="Major: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.ukMajorList}"
										var="ukMajor"
										itemLabel="#{ukMajor.shortDesc} (#{ukMajor.status})" />
									<f:validator validatorId="UKMajorDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Status: " /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" style="width:200px"
									value="#{accountManagementController.ppSelectedUKStatus}"
									size="1" onchange="sumbit()"
									converter="#{UKStatusDataConverter}">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.ukStatusList}"
										var="ukStatus" itemLabel="#{ukStatus.shortDesc}" />
									<f:validator validatorId="UKStatusDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Start Term: *" /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" style="width:200px"
									value="#{accountManagementController.ppSelectedUKStartTerm}"
									size="1" onchange="sumbit()" converter="#{UKTermDataConverter}"
									required="true"
									requiredMessage="Start Term: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.ukTermList}"
										var="ukTerm" itemLabel="#{ukTerm.ukTermCode} | #{ukTerm.description}" />
									<f:validator validatorId="UKTermDataValidator" />
								</h:selectOneListbox>								
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="End Term:" /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" style="width:200px"
									value="#{accountManagementController.selectedUKCompleteTerm}"
									onchange="sumbit()" size="1" converter="#{UKTermDataConverter}">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.ukTermList}"
										var="ukTerm" itemLabel="#{ukTerm.shortDesc}" />
									<f:validator validatorId="UKTermDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Anticipated Complete Term:" /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" style="width:200px"
									value="#{accountManagementController.selectedUKAnticipatedCompleteTerm}"
									onchange="sumbit()" size="1" converter="#{UKTermDataConverter}">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.ukTermList}"
										var="ukTerm" itemLabel="#{ukTerm.shortDesc}" />
									<f:validator validatorId="UKTermDataValidator" />
								</h:selectOneListbox>								
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Professional Advisor: *" /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" style="width:200px"
									value="#{accountManagementController.selectedAdvisor}" size="1"
									onchange="sumbit()" converter="#{AdvisorDataConverter}"
									required="true" requiredMessage="Advisor: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.advisorList}"
										var="advisor" itemLabel="#{advisor.shortDesc}" />
									<f:validator validatorId="AdvisorDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Faculty Advisor:" /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" style="width:200px"
									value="#{accountManagementController.selectedFacultyAdvisor}" size="1"
									onchange="sumbit()" converter="#{FacultyAdvisorDataConverter}">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.facultyAdvisorList}"
										var="facultyAdvisor" itemLabel="#{facultyAdvisor.shortDesc}" />
									<f:validator validatorId="FacultyAdvisorDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Degree Awarded: " /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" style="width:200px"
									value="#{accountManagementController.degreeAwarded}" size="1"
									onchange="sumbit()">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItem itemLabel="NO" itemValue="0" />
									<f:selectItem itemLabel="YES" itemValue="1" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
										value="Short Description :"></h:outputText></font>
									<br>
									<h:outputText
										value="Short description for the drop-down box. Max 255 characters"
										style="color:gray"></h:outputText>
								</h:panelGroup>
								<h:inputTextarea
									value="#{accountManagementController.ppShortDesc}"
									style="width:200px" rows="2">
									<f:validateLength minimum="0" maximum="255" />
								</h:inputTextarea>
							</h:panelGrid>

							<a4j:commandButton value="Save" reRender="pp_datagrid"
								action="#{accountManagementController.editUserProgramProfile}"
								oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('editPPPanel')}.hide();"></a4j:commandButton>

						</h:panelGrid>
					</h:form>
				</rich:modalPanel>
			</authz:authorize>
		</a4j:outputPanel>

		<authz:authorize
			ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_DELETE">
			<rich:modalPanel id="deletePPPanel" autosized="true" width="200">
				<f:facet name="header">
					<h:outputText value="Delete this Program Profile?"
						style="padding-right:15px;" />
				</f:facet>
				<f:facet name="controls">
					<h:panelGroup>
						<h:graphicImage value="/images/icons/cancel.png"
							styleClass="hidelink" id="hidePPdeletelink" alt="X"/>
						<rich:componentControl for="deletePPPanel"
							attachTo="hidePPdeletelink" operation="hide" event="onclick" />
					</h:panelGroup>
				</f:facet>
				<h:form>
					<table width="100%">
						<tbody>
							<tr>
								<td align="center" width="50%"><a4j:commandButton
									value="Yes" ajaxSingle="true"
									reRender="ppAddStatus,pp_datagrid"
									action="#{accountManagementController.removeUserProgramProfileFromUser}"
									oncomplete="#{rich:component('deletePPPanel')}.hide();" /></td>
								<td align="center" width="50%"><a4j:commandButton
									value="Cancel"
									onclick="#{rich:component('deletePPPanel')}.hide();return false;" />
								</td>
							</tr>
						</tbody>
					</table>
				</h:form>
			</rich:modalPanel>
		</authz:authorize>
		<!-- Modal Panels for Personal Profile -->
		<a4j:outputPanel layout="none">
			<authz:authorize
				ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPERROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">
				<rich:modalPanel id="addPEPPanel" autosized="true" width="450"
					rendered="#{accountManagementController.showPersonalProfileAddModalWindow}">
					<f:facet name="header">
						<h:outputText value="Add New Personal Profile" />
					</f:facet>
					<f:facet name="controls">
						<h:panelGroup>
							<h:graphicImage value="/images/icons/cancel.png"
								id="hidePEPaddlink" styleClass="hidelink" alt="X"/>
							<rich:componentControl for="addPEPPanel"
								attachTo="hidePEPaddlink" operation="hide" event="onclick" />
						</h:panelGroup>
					</f:facet>
					<h:form>
						<rich:messages style="color:red;"></rich:messages>
						<h:panelGrid columns="1">
							<h:panelGrid columns="2">
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Ethnicity: *" /></font>
									<br />
									<h:outputText value="Ethnic information" style="color:gray" />
								</h:panelGroup>
								<h:selectOneListbox
									value="#{accountManagementController.selectedEthnic}" size="1"
									converter="#{EthnicDataConverter}" style="width:200px"
									required="true" requiredMessage="Ethnicity: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.ethnicList}"
										var="ethnic" itemLabel="#{ethnic}" />
									<f:validator validatorId="EthnicDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Citizenship: *" /></font>
									<br />
									<h:outputText value="e.g., USA" style="color:gray" />
								</h:panelGroup>
								<h:inputText value="#{accountManagementController.citizen}"
									style="width:200px" required="true"
									requiredMessage="Citizen: Value is required.">
									<f:validateRegex pattern="[A-Za-z .,]+" />
									<f:validateLength maximum="50" />
								</h:inputText>

								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Diploma Type: " /></font>
								</h:panelGroup>
								<h:selectOneListbox style="width:200px"
									value="#{accountManagementController.diplomaType}" size="1">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItem itemLabel="High School" itemValue="High School" />
									<f:selectItem itemLabel="GED" itemValue="GED" />
									<f:selectItem itemLabel="Foreign" itemValue="Foreign" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Diploma State: " /></font>
									<br />
									<h:outputText value="e.g., KY" style="color:gray" />
								</h:panelGroup>
								<h:inputText value="#{accountManagementController.diplomaState}"
									style="width:200px">
									<f:validateRegex pattern="[A-Za-z .,]+" />
								</h:inputText>

								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Diploma Year: " /></font>
									<br />
									<h:outputText value="e.g., 2010" style="color:gray" />
								</h:panelGroup>
								<h:inputText value="#{accountManagementController.diplomaYear}"
									style="width:200px">
									<f:validateRegex pattern="\d{4}" />
								</h:inputText>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="High School: " /></font>
									<br />
									<h:outputText value="Max 50 chars" style="color:gray" />
								</h:panelGroup>
								<h:inputText value="#{accountManagementController.highSchool}"
									style="width:200px">
									<f:validateRegex pattern="[A-Za-z .,]+" />
									<f:validateLength maximum="50" />
								</h:inputText>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="High School City: " /></font>
									<br />
									<h:outputText value="Max 50 chars" style="color:gray" />
								</h:panelGroup>
								<h:inputText
									value="#{accountManagementController.highSchoolCity}"
									style="width:200px">
									<f:validateRegex pattern="[A-Za-z .,]+" />
									<f:validateLength maximum="50" />
								</h:inputText>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="High School County: " /></font>
									<br />
									<h:outputText value="Max 50 chars" style="color:gray" />
								</h:panelGroup>
								<h:inputText
									value="#{accountManagementController.highSchoolCounty}"
									style="width:200px">
									<f:validateRegex pattern="[A-Za-z .,]+" />
									<f:validateLength maximum="50" />
								</h:inputText>
							</h:panelGrid>
							<a4j:commandButton value="Add"
								reRender="pepAddStatus,pep_datagrid"
								action="#{accountManagementController.addUserPersonalProfileToUser}"
								oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('addPEPPanel')}.hide();"></a4j:commandButton>
						</h:panelGrid>
					</h:form>
				</rich:modalPanel>
			</authz:authorize>
		</a4j:outputPanel>
		<a4j:outputPanel layout="none">
			<authz:authorize
				ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD_EDIT">
				<rich:modalPanel id="editPEPPanel" autosized="true" width="450"
					rendered="#{accountManagementController.showPersonalProfileEditModalWindow}">
					<f:facet name="header">
						<h:outputText value="Edit Current Personal Profile" />
					</f:facet>
					<f:facet name="controls">
						<h:panelGroup>
							<h:graphicImage value="/images/icons/cancel.png"
								id="hidePEPeditlink" styleClass="hidelink" alt="X"/>
							<rich:componentControl for="editPEPPanel"
								attachTo="hidePEPeditlink" operation="hide" event="onclick" />
						</h:panelGroup>
					</f:facet>
					<h:form>
						<rich:messages style="color:red;"></rich:messages>

						<h:panelGrid columns="1">

							<h:panelGrid columns="2">

								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Ethnicity: *" /></font>
									<br />
									<h:outputText value="Ethnic information" style="color:gray" />
								</h:panelGroup>
								<h:selectOneListbox immediate="true"
									value="#{accountManagementController.selectedEthnic}" size="1"
									converter="#{EthnicDataConverter}" style="width:200px"
									required="true" requiredMessage="Ethnicity: Value is required.">
									<f:selectItem itemLabel="Select One" itemValue="" />
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.ethnicList}"
										var="ethnic" itemLabel="#{ethnic}" />
									<f:validator validatorId="EthnicDataValidator" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Citizenship: *" /></font>
									<br />
									<h:outputText value="Max 50 chars" style="color:gray" />
								</h:panelGroup>
								<h:selectOneListbox
									value="#{accountManagementController.citizen}" size="1"
									style="width:200px" required="true"
									requiredMessage="Citizen: Value is required.">
									<f:selectItems
										value="#{cepisGlobalComponentConfigurator.countries}"
										var="country" itemLabel="#{country}" />
								</h:selectOneListbox>

								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Diploma Type: " /></font>
								</h:panelGroup>
								<h:selectOneListbox immediate="true" style="width:200px"
									value="#{accountManagementController.diplomaType}" size="1">
									<f:selectItem itemLabel="Select One" itemValue="NA" />
									<f:selectItem itemLabel="High School" itemValue="High School" />
									<f:selectItem itemLabel="GED" itemValue="GED" />
									<f:selectItem itemLabel="Foreign" itemValue="Foreign" />
								</h:selectOneListbox>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Diploma State: " /></font>
									<br />
									<h:outputText value="Max 50 chars" style="color:gray" />
								</h:panelGroup>
								<h:inputText value="#{accountManagementController.diplomaState}"
									style="width:200px">
									<f:validateRegex pattern="[A-Za-z .,]+" />
									<f:validateLength maximum="50" />
								</h:inputText>

								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="Diploma Year: " /></font>
									<br />
									<h:outputText value="e.g., 2010" style="color:gray" />
								</h:panelGroup>
								<h:inputText value="#{accountManagementController.diplomaYear}"
									style="width:200px">
									<f:validateRegex pattern="\d{4}" />
									<f:validateLength maximum="50" />
								</h:inputText>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="High School: " /></font>
									<br />
									<h:outputText value="Max 50 chars" style="color:gray" />
								</h:panelGroup>
								<h:inputText value="#{accountManagementController.highSchool}"
									style="width:200px">
									<f:validateRegex pattern="[A-Za-z .,]+" />
									<f:validateLength maximum="50" />
								</h:inputText>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="High School City: " /></font>
									<br />
									<h:outputText value="Max 50 chars" style="color:gray" />
								</h:panelGroup>
								<h:inputText
									value="#{accountManagementController.highSchoolCity}"
									style="width:200px">
									<f:validateRegex pattern="[A-Za-z .,]+" />
									<f:validateLength maximum="50" />
								</h:inputText>
								<h:panelGroup>
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
										value="High School County: " /></font>
									<br />
									<h:outputText value="Max 50 chars" style="color:gray" />
								</h:panelGroup>
								<h:inputText
									value="#{accountManagementController.highSchoolCounty}"
									style="width:200px">
									<f:validateRegex pattern="[A-Za-z .,]+" />
									<f:validateLength maximum="50" />
								</h:inputText>
							</h:panelGrid>

							<a4j:commandButton value="Save" reRender="pep_datagrid"
								action="#{accountManagementController.editUserPersonalProfile}"
								oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('editPEPPanel')}.hide();"></a4j:commandButton>

						</h:panelGrid>
					</h:form>
				</rich:modalPanel>
			</authz:authorize>
		</a4j:outputPanel>

		<authz:authorize
			ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_DELETE">
			<rich:modalPanel id="deletePEPPanel" autosized="true" width="200">
				<f:facet name="header">
					<h:outputText value="Delete this Personal Profile?"
						style="padding-right:15px;" />
				</f:facet>
				<f:facet name="controls">
					<h:panelGroup>
						<h:graphicImage value="/images/icons/cancel.png"
							styleClass="hidelink" id="hidePEPdeletelink" alt="X"/>
						<rich:componentControl for="deletePEPPanel"
							attachTo="hidePEPdeletelink" operation="hide" event="onclick" />
					</h:panelGroup>
				</f:facet>
				<h:form>
					<table width="100%">
						<tbody>
							<tr>
								<td align="center" width="50%"><a4j:commandButton
									value="Yes" ajaxSingle="true"
									reRender="pepAddStatus,pep_datagrid"
									action="#{accountManagementController.removeUserPersonalProfileFromUser}"
									oncomplete="#{rich:component('deletePEPPanel')}.hide();" /></td>
								<td align="center" width="50%"><a4j:commandButton
									value="Cancel"
									onclick="#{rich:component('deletePEPPanel')}.hide();return false;" />
								</td>
							</tr>
						</tbody>
					</table>
				</h:form>
			</rich:modalPanel>
		</authz:authorize>
		<rich:modalPanel id="userconf" autosized="true" width="300">
			<f:facet name="header">
				<h:outputText value="Primary Contact Information"
					style="padding-right:15px;" />
			</f:facet>
			<f:facet name="controls">
				<h:panelGroup>
					<h:graphicImage value="/images/icons/cancel.png"
						styleClass="hidelink" id="hideuserconflink" alt="X"/>
					<rich:componentControl for="userconf" attachTo="hideuserconflink"
						operation="hide" event="onclick" />
				</h:panelGroup>
			</f:facet>
			<a4j:include viewId="/pages/cp/userconfiguration.jsp"></a4j:include>
		</rich:modalPanel>

		<rich:modalPanel id="ajaxLoadingModalBox" minHeight="50"
			minWidth="120" height="100" width="120" zindex="2000">
			<f:facet name="header">
				<h:outputText value="Sending Request ..."></h:outputText>
			</f:facet>
			<h:outputText value="Please wait ..."></h:outputText>
			<br />
			<br />&nbsp;&nbsp;&nbsp;
				<h:graphicImage value="/images/loader.gif" style="border:0" alt="loading ..."></h:graphicImage>
		</rich:modalPanel>
	</h:panelGroup>
	<script type="text/javascript">
     var infoWindowAMShown = false;
     var infoWindowAMTimer;
     function showModalInfoWindow()
     {
          infoWindowAMTimer = setTimeout("if(!infoWindowAMShown){Richfaces.showModalPanel('ajaxLoadingModalBox');infoWindowAMShown=true;}", 500);
     }
     function hideModalInfoWindow()
     {
          if (infoWindowAMShown){Richfaces.hideModalPanel('ajaxLoadingModalBox');infoWindowAMShown=false;}else{if(infoWindowAMTimer)clearTimeout(infoWindowAMTimer);}
     }
</script>

</f:view>
<%@ include file="/common/footer.jsp"%>


