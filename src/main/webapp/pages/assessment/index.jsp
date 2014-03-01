<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>


<%@ include file="/common/header.jsp"%>
<script type="text/javascript">
	document.title = "CEPIS Assessment Data Manager";
	var global_title = document.getElementById('global_title');
	global_title.innerHTML = "CEPIS Assessment Data Manager";
</script>
<link
	href="${facesContext.externalContext.requestContextPath}/css/datascroller.css"
	media="screen" rel="stylesheet" type="text/css" />
<link
	href="${facesContext.externalContext.requestContextPath}/css/ws.css"
	media="screen" rel="stylesheet" type="text/css" />
<link
	href="${facesContext.externalContext.requestContextPath}/css/assessment.css"
	media="screen" rel="stylesheet" type="text/css" />
<link
	href="${facesContext.externalContext.requestContextPath}/css/font.css"
	media="screen" rel="stylesheet" type="text/css" />
<link
	href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css" />
<f:view>
	<br />
	<a4j:outputPanel ajaxRendered="true" style="align:center">
		<h:panelGrid columns="1">
			<h:messages errorClass="cepiserror" infoClass="cepissuccess"
				warnClass="cepiswarning"></h:messages>
		</h:panelGrid>
		<h:panelGroup layout="block" style="height:25px;">
			<a4j:status startText="Loading ..." startStyleClass="loadingStatus"></a4j:status>
		</h:panelGroup>
	</a4j:outputPanel>
	<a4j:loadScript src="resource://jquery.js" />
	<br />
	<br />
	<h:form>
		<h:panelGrid columns="2"
			columnClasses="indexAssessmentCol1,indexAssessmentCol2" width="100%"
			id="assessmentBlock">
			<h:panelGrid width="100%">
				<h:panelGrid id="start_msg" width="100%" columns="2"
					columnClasses="startMsgCol1,startMsgCol2">
					<h:graphicImage value="/images/icons/table_row_insert.png"
						rendered="#{!accountManagementController.userSelected}"
						style="border:0" styleClass="pic" alt="" />
					<h:outputText
						rendered="#{!accountManagementController.userSelected}"
						value="Select one or more students from the current working set (#{workingSetController.activeWorkingSetName})." />
				</h:panelGrid>
				<!-- Show Assessment information for the selected user -->
				<h:panelGroup id="assessment_datatable">
					<h:panelGrid width="100%"
						rendered="#{accountManagementController.singleUserSelected}">
						<rich:dataTable id="assessmentTable" styleClass="scrollTable"
							headerClass="header" rowClasses="normalRow,alternateRow"
							width="100%"
							columnClasses="standardTable_Column,standardTable_Column,standardTable_ColumnCentered,standardTable_Column"
							var="assessment"
							value="#{accountManagementController.userAssessmentProfileList}"
							rows="#{cepisConfigurationManager.rowCount}">
							<f:facet name="header">
								<rich:datascroller for="assessmentTable" id="sc2"
									page="#{searchEngineController.pageValue}" reRender="sc1"
									ajaxSingle="false" />
							</f:facet>
							<rich:column sortable="true"
								sortBy="#{assessment.ukTerm.ukTermCode}" id="col_2"
								filterBy="#{assessment.ukTerm.shortDesc}" width="75px"
								label="Term" sortOrder="DESCENDING" filterEvent="onchange">
								<f:facet name="header">
									<h:outputText value="Term" id="term_code" />
								</f:facet>
								<h:outputText value="#{assessment.ukTerm.shortDesc}"
									id="assessment_term" />
							</rich:column>
							<rich:column sortable="true"
								sortBy="#{assessment.programDomain.shortDesc}"
								filterBy="#{assessment.programDomain.shortDesc}" id="col_3"
								sortOrder="ASCENDING" filterEvent="onchange"
								label="Program Domain">
								<f:facet name="header">
									<h:outputText value="Program Domain" />
								</f:facet>
								<h:outputText value="#{assessment.programDomain}" />
							</rich:column>
							<rich:column id="col_4" sortable="true"
								sortBy="#{assessment.assessmentType}" width="100px"
								sortOrder="UNSORTED" label="Type">
								<f:facet name="header">
									<h:outputText value="Type" />
								</f:facet>
								<h:outputText rendered="#{assessment.assessmentType ==0}"
									value="Admission" />
								<h:outputText rendered="#{assessment.assessmentType ==1}"
									value="Retention" />
								<h:outputText rendered="#{assessment.assessmentType ==2}"
									value="Completion" />
							</rich:column>
							<rich:column id="col_5" width="100px" label="Final Score">
								<f:facet name="header">
									<h:outputText value="Final Score" />
								</f:facet>
								<h:outputText value="#{assessment.score}" />
							</rich:column>
							<rich:column id="col_6" width="100px" label="Decision">
								<f:facet name="header">
									<h:outputText value="Decision" />
								</f:facet>
								<h:outputText value="#{assessment.decision}" />
							</rich:column>
							<rich:column id="col_7" width="200px" label="Memo">
								<f:facet name="header">
									<h:outputText value="Memo" />
								</f:facet>
								<h:outputText
									value="#{fn:substring(assessment.shortDesc,0,20)} ..." />
							</rich:column>
							<rich:column label="Actions">
								<f:facet name="header">
									<h:outputText value="Actions" />
								</f:facet>
								<h:panelGroup styleClass="highlightClass">	&nbsp;
									<a4j:commandLink id="edit_button"
										title="Update the selected Assessment profiles."
										style="width:50px;" ajaxSingle="true"
										reRender="assessment_panel"
										action="#{accountManagementController.updateButtonInvoked}">
										<h:graphicImage value="/images/icons/vcard_edit.png"
											style="border:0" styleClass="pic" alt="" />
										<h:outputText id="enable_edit_button" value="Update"></h:outputText>
										<f:setPropertyActionListener value="#{assessment}"
											target="#{accountManagementController.selectedUserAssessmentProfile}" />
									</a4j:commandLink>
												&nbsp;&nbsp;
									<a4j:commandLink id="delete_button"
										title="Delete the selected Assessment profile."
										style="width:50px;" value="Delete"
										onclick="if (!confirm('The selected profile will be deleted permanently. This action cannot be reversed, Are you sure?')) return false">
										<h:graphicImage value="/images/icons/vcard_delete.png"
											style="border:0" styleClass="pic" alt="" />
										<a4j:support reRender="assessmentTable" event="onclick"
											ajaxSingle="true"
											action="#{accountManagementController.deleteSelectedUserAssessmentProfile}">
											<f:setPropertyActionListener value="#{assessment}"
												target="#{accountManagementController.selectedUserAssessmentProfile}" />
										</a4j:support>

									</a4j:commandLink>
												&nbsp;</h:panelGroup>
							</rich:column>

							<f:facet name="footer">
								<rich:datascroller id="sc1" ajaxSingle="false"
									page="#{searchEngineController.pageValue}" reRender="sc2" />
							</f:facet>
						</rich:dataTable>
					</h:panelGrid>
				</h:panelGroup>
				<h:panelGrid width="100%" id="action_control"
					style="align:right;text-align:right;">
					<h:panelGroup id="datatable_footer"
						rendered="#{accountManagementController.singleUserSelected}"
						style="align:right;text-align:right;">
											&nbsp;
						<a4j:commandLink id="add_button"
							title="Add a new Assessment profile." style="width:50px;"
							ajaxSingle="true"
							reRender="assessment_datatable,assessment_panel,action_control"
							action="#{accountManagementController.addButtonInvoked}">
							<h:graphicImage value="/images/icons/vcard_add.png"
								style="border:0" styleClass="pic" alt="" />
							<h:outputText id="enable_add_button" value="Add new"></h:outputText>
						</a4j:commandLink>
												&nbsp;
					</h:panelGroup>
				</h:panelGrid>
				<h:panelGroup id="assessment_panel">
					<rich:spacer height="15px"
						rendered="#{accountManagementController.singleUserSelected}"></rich:spacer>
					<rich:panel id="panel" style="align:right"
						rendered="#{accountManagementController.showAssessmentDataEntryPanel}">
						<f:facet name="header">
							<h:panelGrid width="100%" columns="2"
								columnClasses="addPanelCol1,addPanelCol2">
								<h:outputText value="Add New Assessment Data"
									style="font-weight:bold"
									rendered="#{accountManagementController.userAction==0}"></h:outputText>
								<h:outputText value="Update the Selected Assessment Data"
									style="font-weight:bold"
									rendered="#{accountManagementController.userAction==1}"></h:outputText>
								<h:outputText>
									<h:panelGroup layout="block"
										style="text-align:right;align:right;"
										rendered="#{accountManagementController.singleUserSelected}">
										<a4j:commandLink id="hide_assessment_panel_link"
											reRender="assessment_panel" ajaxSingle="true">
											<h:graphicImage value="/images/icons/table_sort.png"
												style="border:0" styleClass="pic" alt="" />
											<h:outputText value="Hide" />
											<f:setPropertyActionListener value="#{false}"
												target="#{accountManagementController.showAssessmentDataEntryPanel}" />
										</a4j:commandLink>
										<rich:toolTip for="hide_assessment_panel_link"
											value="Discard all the stale data and hide this assessment panel." />&nbsp;
							</h:panelGroup>
								</h:outputText>
							</h:panelGrid>
						</f:facet>
						<h:panelGroup id="assessment_dataentry">
							<h:panelGrid width="100%" id="command_post_top"
								style="align:center;text-align:center;">
								<h:panelGroup style="align:center;text-align:center;"
									styleClass="highlightClass"
									rendered="#{accountManagementController.userAssessmentProfileAvailable}">
									&nbsp;
									<a4j:commandButton value="Add All"
										reRender="assessmentTable,assessment_datatable,assessment_panel"
										title="Add all these Assessment profiles."
										style="width:100px;"
										rendered="#{accountManagementController.userAction==0}"
										action="#{accountManagementController.addAllUserAssessmentProfiles}"></a4j:commandButton>

									<a4j:commandButton value="Update"
										reRender="assessmentTable,assessment_datatable,assessment_panel"
										title="Update the selected Assessment profile."
										style="width:100px;"
										rendered="#{accountManagementController.userAction==1}"
										action="#{accountManagementController.updateSelectedUserAssessmentProfile}"></a4j:commandButton>
										&nbsp;&nbsp;
									<a4j:commandButton value="Cancel"
										title="Discard all these Assessment profiles."
										onclick="if (!confirm('All the unsaved data will be discarded. This action cannot be reversed, Are you sure?')) return false"
										style="width:100px;" reRender="assessment_panel"
										ajaxSingle="true"
										action="#{accountManagementController.discardAllUserAssessmentProfiles}"></a4j:commandButton>
											&nbsp;
									
								</h:panelGroup>
							</h:panelGrid>
							<rich:spacer height="10px"></rich:spacer>
							<h:panelGroup>
								<h:panelGrid columns="6" width="100%" id="primaryComponent">
									<h:panelGroup>
										<h:graphicImage value="/images/icons/one.gif" style="border:0"
											styleClass="pic" alt="1" />&nbsp;
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
												value="Term: *" /></font>
									</h:panelGroup>
									<h:selectOneListbox id="ukterm_list_id" style="width:100px"
										value="#{accountManagementController.selectedUKTerm}" size="1"
										converter="#{UKTermDataConverter}" required="true"
										requiredMessage="Term: Value is required.">
										<f:selectItem itemLabel="Select One" itemValue="NA" />
										<f:selectItems
											value="#{cepisGlobalComponentConfigurator.ukTermList}"
											var="ukTerm" itemLabel="#{ukTerm.shortDesc}" />
										<f:validator validatorId="UKTermDataValidator" />
									</h:selectOneListbox>
									<h:panelGroup>
										<h:graphicImage value="/images/icons/two.gif" style="border:0"
											styleClass="pic" alt="2" />&nbsp;
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
												value="Type: " /></font>
									</h:panelGroup>
									<h:selectOneMenu id="type"
										value="#{accountManagementController.assessmentType}"
										style="width:100px" required="true">
										<f:selectItem itemLabel="Admission" itemValue="0" />
										<f:selectItem itemLabel="Retention" itemValue="1" />
										<f:selectItem itemLabel="Completion" itemValue="2" />
									</h:selectOneMenu>
									<h:panelGroup>
										<h:graphicImage value="/images/icons/three.gif"
											style="border:0" styleClass="pic" alt="3" />&nbsp;
									<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
												value="Program Domain: *" /></font>
									</h:panelGroup>
									<h:selectOneListbox id="program_domain_list_id"
										style="width:200px"
										value="#{accountManagementController.selectedProgramDomain}"
										size="1" converter="#{ProgramDomainDataConverter}"
										required="true"
										disabled="#{accountManagementController.userAction==1}"
										requiredMessage="Program Domain: Value is required.">
										<f:selectItem itemLabel="Select One" itemValue="" />
										<f:selectItems
											value="#{cepisGlobalComponentConfigurator.programDomainList}"
											var="programDomain"
											itemLabel="#{programDomain.shortDesc} (#{programDomain.status})" />
										<f:validator validatorId="ProgramDomainDataValidator" />
										<a4j:support event="onchange" limitToList="true"
											ajaxSingle="true" process="ukterm_list_id"
											actionListener="#{accountManagementController.valueChangePrimaryAssessmentComponent}"
											reRender="assessment_panel" eventsQueue="primCompQueue" />
									</h:selectOneListbox>
								</h:panelGrid>
							</h:panelGroup>
							<rich:spacer height="10px"></rich:spacer>
							<a4j:outputPanel id="table">
								<h:dataTable id="addNew"
									value="#{accountManagementController.userAssessmentProfiles}"
									var="assessment" width="100%">
									<h:column>
										<rich:panel bodyClass="rich-laguna-panel-no-header"
											style="align:center;" id="assessmentPanel">
											<h:panelGroup styleClass="highlightClass">
												<h:outputText value="#{assessment.user}"></h:outputText>
											</h:panelGroup>
											<rich:togglePanel id="assess_artifact_panel"
												switchType="client" stateOrder="assess,artifact"
												label="Switch">
												<f:facet name="assess">
													<h:panelGrid id="assess_content" width="100%">
														<h:panelGroup id="stdSetsSection">
															<h:dataTable id="stdSetsTable"
																value="#{assessment.standardSets}" var="standardSet"
																width="100%" styleClass="scrollTable"
																footerClass="footer" headerClass="header"
																rowClasses="normalRow,alternateRow" cellpadding="0"
																cellspacing="0">
																<h:column>
																	<f:facet name="header">
																		<h:outputText value="StdSet" />
																	</f:facet>
																	<h:outputText value="#{standardSet}: " />
																</h:column>
																<h:column id="stdsCol">
																	<f:facet name="header">
																		<h:outputText value="Standards" />
																	</f:facet>
																	<h:panelGroup>
																		<a4j:outputPanel id="stdsPanel">
																			<a4j:repeat id="stdRepeat"
																				value="#{standardSet.standards}" var="standard">
																				<h:panelGroup id="stdComp">
																					<h:selectOneMenu id="stdScore"
																						styleClass="stdSource" value="#{standard.score}"
																						title="#{standard}" label="#{standard}">
																						<f:selectItem itemLabel="-" itemValue="0" />
																						<f:selectItem itemLabel="1" itemValue="1" />
																						<f:selectItem itemLabel="2" itemValue="2" />
																						<f:selectItem itemLabel="3" itemValue="3" />
																						<f:selectItem itemLabel="4" itemValue="4" />

																					</h:selectOneMenu>
																				</h:panelGroup>
																			</a4j:repeat>
																		</a4j:outputPanel>
																	</h:panelGroup>
																</h:column>
																<h:column>
																	<f:facet name="header">
																		<h:outputText value="StdSet Score" />
																	</f:facet>
																	<h:panelGroup id="finalStdSetScore">
																		<h:selectOneMenu id="stdSetFinalScore"
																			styleClass="stdSetTarget"
																			value="#{standardSet.finalScore}" required="true"
																			requiredMessage="#{assessment.user}: StandardSet scores cannot be empty.">
																			<f:selectItem itemLabel="-" itemValue="0" />
																			<f:selectItem itemLabel="1" itemValue="1" />
																			<f:selectItem itemLabel="2" itemValue="2" />
																			<f:selectItem itemLabel="3" itemValue="3" />
																			<f:selectItem itemLabel="4" itemValue="4" />
																		</h:selectOneMenu>
																	</h:panelGroup>
																</h:column>

																<f:facet name="footer">
																	<h:panelGrid width="100%" columns="2"
																		style="align:right;text-align:right;">
																		<h:outputText value="Computed Score:" />
																		<h:panelGroup id="computedAssessmentScore"
																			styleClass="compScoreTarget">
																			<h:outputText value="#{assessment.computedScore}" />
																		</h:panelGroup>
																	</h:panelGrid>
																</f:facet>
															</h:dataTable>
														</h:panelGroup>
														<h:panelGrid columns="2" width="100%">
															<h:panelGrid columns="2" width="100%">
																<h:panelGroup>
																	<font class="ws10" color="#062E8A" face="Tahoma">
																		<h:outputText value="Final Score : *"></h:outputText>
																	</font>
																</h:panelGroup>
																<h:selectOneMenu id="finalAssessmentScore"
																	value="#{assessment.score}" style="width:200px"
																	required="true"
																	requiredMessage="#{assessment.user}: Final score cannot be empty.">
																	<f:selectItem itemLabel="Select One" />
																	<f:selectItem itemLabel="Novice" itemValue="1" />
																	<f:selectItem itemLabel="Progressing" itemValue="2" />
																	<f:selectItem itemLabel="Proficient" itemValue="3" />
																	<f:selectItem itemLabel="Advanced" itemValue="4" />
																</h:selectOneMenu>
																<h:panelGroup>
																	<font class="ws10" color="#062E8A" face="Tahoma">
																		<h:outputText value="Decision : *"></h:outputText>
																	</font>
																</h:panelGroup>
																<h:selectOneMenu id="finalAssessmentDecision"
																	value="#{assessment.decision}" style="width:200px"
																	required="true"
																	requiredMessage="#{assessment.user}: Assessment decision cannot be empty.">
																	<f:selectItem itemLabel="Select One" />
																	<f:selectItem itemLabel="Good Standing" itemValue="1" />
																	<f:selectItem itemLabel="Progressing" itemValue="2" />
																	<f:selectItem itemLabel="Proficient" itemValue="3" />
																	<f:selectItem itemLabel="Experienced" itemValue="4" />
																</h:selectOneMenu>
																<h:panelGroup>
																	<font class="ws10" color="#062E8A" face="Tahoma">
																		<h:outputText value="Memo : "></h:outputText>
																	</font>
																</h:panelGroup>
																<h:inputTextarea value="#{assessment.shortDesc}"
																	style="width:200px" rows="2">
																	<f:validateLength minimum="0" maximum="255" />
																</h:inputTextarea>
															</h:panelGrid>
															<h:panelGrid width="100%">
																<a4j:commandButton id="reset_this"
																	styleClass="resetAssessment" value="Reset This"
																	title="Reset the values of this Assessment profile."
																	style="width:100px;" ajaxSingle="true">
																</a4j:commandButton>
																<a4j:commandButton id="copy_this" disabled="true"
																	rendered="#{accountManagementController.mutipleUserAssessmentProfileAvailable}"
																	styleClass="copyAssessment" value="Copy This"
																	title="Copy the values of this Assessment profile to other profiles."
																	style="width:100px;" ajaxSingle="true">
																</a4j:commandButton>
																<rich:toggleControl switchToState="artifact">
																	<a4j:commandButton id="show_artifact" value="Artifacts"
																		title="Add/remove artifacts associated with this assessment profile. Artifacts are fetched from the OTIS Data System."
																		style="width:100px;" ajaxSingle="true"
																		limitToList="true">
																	</a4j:commandButton>
																</rich:toggleControl>
															</h:panelGrid>
														</h:panelGrid>
													</h:panelGrid>
												</f:facet>
												<f:facet name="artifact">
													<h:panelGrid width="100%" id="artifact_panel"
														style="align:center;">

														<rich:panel bodyClass="rich-laguna-panel-no-header"
															style="align:center;">
															<h:outputText
																binding="#{accountManagementController.artifactText}"
																value="Select Artifacts (All Completed Artifacts (from OTIS) -> Artifacts for this Assessment Data)"
																styleClass="boldText">
																<f:attribute name="currentAssessment"
																	value="#{assessment}" />
															</h:outputText>
															<br />
															<rich:pickList id="artifactsPickList" immediate="true"
																sourceListWidth="200px" targetListWidth="200px"
																value="#{accountManagementController.assessmentArtifacts}"
																converter="#{ArtifactDataConverter}"
																converterMessage="Convert Error">
																<f:selectItems
																	value="#{accountManagementController.allCompletedArtifacts}" />
																<f:validator validatorId="ArtifactDataValidator" />
															</rich:pickList>
														</rich:panel>
														<rich:toggleControl switchToState="assess">
															<h:panelGrid columns="2">
																<a4j:commandButton id="add_artifacts"
																	value="Add Artifacts" title="Add Artifacts."
																	style="width:100px;"
																	action="#{accountManagementController.addArtifacts}"
																	ajaxSingle="true" reRender="assessment_panel">
																	<f:setPropertyActionListener value="#{assessment}"
																		target="#{accountManagementController.selectedUserAssessmentProfile}" />
																</a4j:commandButton>
																<a4j:commandButton id="show_assess" value="Cancel"
																	title="Back To Assessment Data." limitToList="true"
																	reRender="assessment_panel" ajaxSingle="true">
																</a4j:commandButton>
															</h:panelGrid>
														</rich:toggleControl>
													</h:panelGrid>
												</f:facet>
											</rich:togglePanel>
										</rich:panel>
									</h:column>
								</h:dataTable>
								<script type="text/javascript">
									jQuery('.stdSource')
											.change(
													function() {
														var stdId = jQuery(this)
																.attr('id');
														var stdSearchStr = 'select[id^="'
																+ stdId
																		.substring(
																				0,
																				(stdId.length - 12))
																+ '"]';
														var stdSetFinalScoreId = 'select[id="'
																+ stdId
																		.substring(
																				0,
																				(stdId.length - 22))
																+ 'stdSetFinalScore"]';
														var sum = 0;
														var count = 0;
														var finalScore = 0;
														// Show animated change
														jQuery(
																stdSetFinalScoreId)
																.fadeTo("slow",
																		0.33);
														jQuery(stdSearchStr)
																.each(
																		function() {
																			var stdSetValue = parseInt(jQuery(
																					this)
																					.val());
																			if (stdSetValue > 0) {
																				count = count + 1;
																				sum = sum
																						+ stdSetValue;
																			}
																		});

														if (count != 0) {
															finalScore = (sum / count);
														}
														jQuery(
																stdSetFinalScoreId)
																.val(
																		Math
																				.round(finalScore));
														jQuery(
																stdSetFinalScoreId)
																.fadeTo("slow",
																		1);
														jQuery(
																stdSetFinalScoreId)
																.change();
													});
									jQuery('.stdSetTarget')
											.change(
													function() {
														var stdSetFinalScoreId = jQuery(
																this)
																.attr('id');
														var stdSetFinalScoreStr = 'select[id^="'
																+ stdSetFinalScoreId
																		.substring(
																				0,
																				(stdSetFinalScoreId.length - 20))
																+ '"][id$="stdSetFinalScore"]';
														var stdSetComputedScoreId = 'span[id="'
																+ stdSetFinalScoreId
																		.substring(
																				0,
																				(stdSetFinalScoreId.length - 20))
																+ 'computedAssessmentScore"]';
														var sum = 0;
														var count = 0;
														var finalScore = 0;
														jQuery(
																stdSetComputedScoreId)
																.fadeTo("slow",
																		0.33);
														jQuery(
																stdSetFinalScoreStr)
																.each(
																		function() {
																			var stdSetFinalScoreValue = parseInt(jQuery(
																					this)
																					.val());
																			if (stdSetFinalScoreValue > 0) {
																				count = count + 1;
																				sum = sum
																						+ stdSetFinalScoreValue;
																			}
																		});

														if (count != 0) {
															finalScore = (sum / count);
														}
														jQuery(
																stdSetComputedScoreId)
																.html(
																		Math
																				.round(finalScore));
														jQuery(
																stdSetComputedScoreId)
																.fadeTo("slow",
																		1);
													});
									jQuery('.resetAssessment')
											.click(
													function() {
														var resetButtonId = jQuery(
																this)
																.attr('id');
														var assessmentCompSearchStr = '[id^="'
																+ resetButtonId
																		.substring(
																				0,
																				(resetButtonId.length - 10))
																+ '"]';
														jQuery(
																'div'
																		+ assessmentCompSearchStr)
																.fadeTo("slow",
																		0.33);
														jQuery(
																'select'
																		+ assessmentCompSearchStr)
																.each(
																		function() {
																			jQuery(
																					this)
																					.val(
																							0);
																		});
														jQuery(
																'span'
																		+ assessmentCompSearchStr
																		+ 'id$="computedAssessmentScore"')
																.html('0');
														jQuery(
																'div'
																		+ assessmentCompSearchStr)
																.fadeTo("slow",
																		1);

													});
									jQuery('.copyAssessment')
											.click(
													function() {
														var copyButtonId = jQuery(
																this)
																.attr('id');
														var currentAssessProfileStr = '[id^="'
																+ copyButtonId
																		.substring(
																				0,
																				(copyButtonId.length - 10))
																+ '"]';

													});
								</script>
							</a4j:outputPanel>

							<h:panelGrid width="100%" id="command_post_bottom"
								style="align:center;text-align:center;">
								<h:panelGroup style="align:center;text-align:center;"
									styleClass="highlightClass"
									rendered="#{accountManagementController.userAssessmentProfileAvailable}">
									&nbsp;
									<a4j:commandButton value="Add All"
										reRender="assessmentTable,assessment_datatable,assessment_panel"
										title="Add all these Assessment profiles."
										style="width:100px;"
										rendered="#{accountManagementController.userAction==0}"
										action="#{accountManagementController.addAllUserAssessmentProfiles}"></a4j:commandButton>

									<a4j:commandButton value="Update"
										reRender="assessmentTable,assessment_datatable,assessment_panel"
										title="Update the selected Assessment profile."
										style="width:100px;"
										rendered="#{accountManagementController.userAction==1}"
										action="#{accountManagementController.updateSelectedUserAssessmentProfile}"></a4j:commandButton>
										&nbsp;&nbsp;
									<a4j:commandButton value="Cancel"
										title="Discard all these Assessment profiles."
										onclick="if (!confirm('All the unsaved data will be discarded. This action cannot be reversed, Are you sure?')) return false"
										style="width:100px;" reRender="assessment_panel"
										ajaxSingle="true"
										action="#{accountManagementController.discardAllUserAssessmentProfiles}"></a4j:commandButton>
											&nbsp;
									
								</h:panelGroup>
							</h:panelGrid>
						</h:panelGroup>
					</rich:panel>
				</h:panelGroup>
			</h:panelGrid>
			<h:panelGrid columns="2" columnClasses="wsToggle,wsBox">
				<rich:toggleControl id="ws_toggle" for="ws_panel" ajaxSingle="true">
					<h:graphicImage id="wsimgclosed"
						style="border-width:0;width:46px;height:235px;"
						value="/images/ws11grey.jpg" alt="&lt;&gt;" />
				</rich:toggleControl>
				<rich:togglePanel id="ws_panel" switchType="client"
					stateOrder="open,close" label="Slider"
					value="#{workingSetController.wsPanelStatus}">
					<f:facet name="open">
						<f:subview id="ws_show">

							<h:panelGrid styleClass="wsContainer">
								<h:panelGrid columns="1" styleClass="workingSet">
									<h:panelGroup>
										<h:graphicImage id="wsimg" value="/images/icons/cart.png"
											alt="Working Set:" />&nbsp;
											<font color="#062E8A" face="Tahoma"><b><h:outputText
													id="ws_name"
													value="#{workingSetController.activeWorkingSetName}"></h:outputText></b></font>
									</h:panelGroup>
									<h:panelGrid styleClass="wsCore">
										<h:panelGroup>
											<h:selectManyListbox id="wsid"
												value="#{accountManagementController.selectedUsers}"
												size="25" converter="#{UserDataConverter}"
												style="width: 200px;" required="true"
												requiredMessage="Select atleast one user from the working set.">
												<f:selectItems
													value="#{workingSetController.activeWSUsersList}"
													var="user" itemLabel="#{user.fullName}" />
												<f:validator validatorId="UserDataValidator" />
												<a4j:support event="onchange" ajaxSingle="true"
													limitToList="true" ignoreDupResponses="true"
													actionListener="#{accountManagementController.valueChangeSelectedUsers}"
													eventsQueue="primCompQueue"
													reRender="start_msg,assessment_datatable,action_control,assessment_panel" />
											</h:selectManyListbox>
										</h:panelGroup>
									</h:panelGrid>

									<h:panelGroup style="width:100%;text-align:right;align:right;"
										layout="block">
										<font class="ws8" color="#062E8A" face="Tahoma"><a
											href="/cepis/pages/ws/index.cps" title="Working Set"><span>More
													options &gt;&gt;</span></a> &nbsp;&nbsp;&nbsp;&nbsp;</font>
									</h:panelGroup>
								</h:panelGrid>
							</h:panelGrid>

						</f:subview>
					</f:facet>
					<f:facet name="close">
						<f:subview id="ws_hide">
							<h:outputText value=" "></h:outputText>
						</f:subview>
					</f:facet>
				</rich:togglePanel>
			</h:panelGrid>
		</h:panelGrid>
		<a4j:outputPanel ajaxRendered="true" style="align:center">
			<h:panelGrid columns="1">
				<authz:authorize ifAllGranted="ROLE_DEVELOPER">
					<h:panelGroup>
						<a4j:log id="debug" popup="false"
							title="CEPIS - Ajax Debug Window" rendered="true" width="900px"
							height="100px"></a4j:log>
					</h:panelGroup>
				</authz:authorize>
			</h:panelGrid>
		</a4j:outputPanel>
	</h:form>
</f:view>
<%@ include file="/common/footer.jsp"%>