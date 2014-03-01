<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="authz"%>

<f:subview id="search-cepis" >

	<h:form id="search-area" styleClass="styleish">
	
		<a4j:loadScript src="resource://jquery.js" />
		
		<a4j:status startText="Loading ..." startStyleClass="loadingStatus"/>
		
		<h:panelGroup id="search-options" style="margin-left:37%; padding-bottom:10px;" 
		layout="block" styleClass="radioButtonSpace">
			<h:selectOneRadio value="#{searchEngineController.reportSearch}">
				<f:selectItem itemValue="#{false}" itemLabel="CEPIS Search" />						
				<f:selectItem itemValue="#{true}" itemLabel="Report Search" />				
				<a4j:support event="onclick" ajaxSingle="true" action="#{searchEngineController.toggleReportSearch}"
				reRender="search-area" />
			</h:selectOneRadio>
		</h:panelGroup>
		
		<h:panelGroup id="search-box" style="margin-left:37%; padding-bottom:10px;"  layout="block">		
			<h:inputText id="globalquery" rendered="#{searchEngineController.showSearchBox}"			
			value="#{searchEngineController.globalQuery}"
			style="background-image: url('/cepis/images/cepissearch.jpg');
			background-repeat: no-repeat;
			background-position: center center;			
			width: 400px;
			font-size: 20px;"
			tabindex="0" />
		</h:panelGroup>
		<h:panelGroup id="searchButton-box" style="margin-left:45%; padding-bottom:10px;"  layout="block">
		
			<h:commandButton id="search-button" value="Search" rendered="#{searchEngineController.showSearchButton}"
			action="#{searchEngineController.search}" styleClass="buttonStyle" >
				<a4j:support event="onclick" ajaxSingle="true" reRender="resultSetid,sc1,sc2,search_count,checkList,cepisSearchResults-area"/>
			</h:commandButton>
			
			<a4j:commandButton id="searchOptions" reRender="searchOptionsPanel" 
			value="Options" ajaxSingle="true" limitToList="true" styleClass="buttonStyle"
			oncomplete="Richfaces.showModalPanel('searchOptionsPanel')"/>
			
			<h:commandButton id="clear-button" value="Clear" rendered="#{searchEngineController.showSearchButton}"
			action="#{searchEngineController.clear}" styleClass="buttonStyle" >
				<a4j:support event="onclick" ajaxSingle="true" reRender="resultSetid,sc1,sc2,search_count,checkList"/>
			</h:commandButton>
			
			<h:commandButton id="report-button" value="Generate Report" rendered="#{searchEngineController.showReportButton}"
			action="#{searchEngineController.search}" styleClass="buttonStyle">
				<a4j:support event="onclick" ajaxSingle="true" reRender="cepisSearchResults-area"/>
			</h:commandButton>
			
		</h:panelGroup>
		
		<h:panelGroup id="checkList" layout="block">
			<rich:panel bodyClass="rich-laguna-panel-no-header"
			style="width:100%;align:center;"
			rendered="#{searchEngineController.allowSearchOperation}">
				<h:panelGrid columns="2" style="width:100%"
				columnClasses="savequerycol1,savequerycol2">
					<h:panelGroup style="width:100%">
						<h:panelGroup>
							<h:panelGroup rendered="#{searchEngineController.check_globalQuery}"
							styleClass="savedQueryStyle">								
								&nbsp;													
								<a4j:commandLink id="check_globalQuery" value=" X "
								styleClass="style2" reRender="checkList,globalquery"								
								rendered="#{searchEngineController.check_globalQuery}"
								actionListener="#{searchEngineController.removeGlobalQueryOption}"/>
								
								<h:outputText value="| Query:#{searchEngineController.globalQuery} "								
								rendered="#{searchEngineController.check_globalQuery}"/>								
								&nbsp;								
							</h:panelGroup>							
							<h:panelGroup rendered="#{searchEngineController.check_username}"							
							styleClass="savedQueryStyle">							
								&nbsp;								
								<a4j:commandLink id="check_username" value="X "
								styleClass="style2" reRender="checkList,username"
								rendered="#{searchEngineController.check_username}"
								actionListener="#{searchEngineController.removeUsernameOption}"/>
								
								<h:outputText value="| Username:#{searchEngineController.username} "								
								rendered="#{searchEngineController.check_username}"/>								
								&nbsp;												
							</h:panelGroup>							
							<h:panelGroup rendered="#{searchEngineController.check_lastName}"
							styleClass="savedQueryStyle">													
							&nbsp;							
								<a4j:commandLink id="check_lastName" value="X "
								styleClass="style2" reRender="checkList,lastname"
								actionListener="#{searchEngineController.removeLastNameOption}"
								rendered="#{searchEngineController.check_lastName}"/>
								
								<h:outputText value="| Lastname:#{searchEngineController.lastName} "
								rendered="#{searchEngineController.check_lastName}"/>								
								&nbsp;
							</h:panelGroup>							
							<h:panelGroup rendered="#{searchEngineController.check_firstName}"
							styleClass="savedQueryStyle">																				
								&nbsp;												
								<a4j:commandLink id="check_firstName" value="X "
								styleClass="style2" reRender="checkList,firstname"
								actionListener="#{searchEngineController.removeFirstNameOption}"
								rendered="#{searchEngineController.check_firstName}"/>
								
								<h:outputText value="| Firstname:#{searchEngineController.firstName} "
								rendered="#{searchEngineController.check_firstName}"/>								
								&nbsp;								
							</h:panelGroup>
							<h:panelGroup rendered="#{searchEngineController.check_middleName}"
							styleClass="savedQueryStyle">							
								&nbsp;							
								<a4j:commandLink id="check_middleName" value="X "
								styleClass="style2"
								reRender="checkList,middlename"
								actionListener="#{searchEngineController.removeMiddleNameOption}"
								rendered="#{searchEngineController.check_middleName}"/>
								
								<h:outputText value="| Middlename:#{searchEngineController.middleName} "
								rendered="#{searchEngineController.check_middleName}"/>								
								&nbsp;
							</h:panelGroup>
							<h:panelGroup rendered="#{searchEngineController.check_maidenName}"
							styleClass="savedQueryStyle">								
								&nbsp;									
								<a4j:commandLink id="check_maidenName" value="X "
								styleClass="style2"
								reRender="checkList,maidenname"
								actionListener="#{searchEngineController.removeMaidenNameOption}"
								rendered="#{searchEngineController.check_maidenName}"/>
								
								<h:outputText value="| Maidenname:#{searchEngineController.maidenName} "
								rendered="#{searchEngineController.check_maidenName}"/>								
								&nbsp;								
							</h:panelGroup>							
							<h:panelGroup rendered="#{searchEngineController.check_ukID}"
							styleClass="savedQueryStyle">													
								&nbsp;								
								<a4j:commandLink id="check_ukID" value="X "
								styleClass="style2" reRender="checkList,ukid"
								actionListener="#{searchEngineController.removeUkIDOption}"
								rendered="#{searchEngineController.check_ukID}"/>
								
								<h:outputText value="| UK Student ID:#{searchEngineController.ukID} "
								rendered="#{searchEngineController.check_ukID}"/>								
								&nbsp;								
							</h:panelGroup>
							<authz:authorize ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER">
								<h:panelGroup rendered="#{searchEngineController.check_ssn}"
								styleClass="savedQueryStyle">									
									&nbsp;									
									<a4j:commandLink id="check_ssn" value="X "
									styleClass="style2" reRender="checkList,ssn"
									actionListener="#{searchEngineController.removeSsnOption}"
									rendered="#{searchEngineController.check_ssn}"/>
									
									<h:outputText value="| SSN:#{searchEngineController.ssn} "
									rendered="#{searchEngineController.check_ssn}"/>									
									&nbsp;									
								</h:panelGroup>								
							</authz:authorize>					
							<h:panelGroup rendered="#{searchEngineController.check_gender}"
							styleClass="savedQueryStyle">									
								&nbsp;									
								<a4j:commandLink id="check_gender" value="X "
								styleClass="style2" reRender="checkList,gender"
								actionListener="#{searchEngineController.removeGenderOption}"
								rendered="#{searchEngineController.check_gender}"/>
								
								<h:outputText value="| Gender:#{searchEngineController.gender} "
								rendered="#{searchEngineController.check_gender}"/>									
								&nbsp;									
							</h:panelGroup>							
							<h:panelGroup rendered="#{searchEngineController.check_selectedProgram}"
							styleClass="savedQueryStyle">													
								&nbsp;
								<a4j:commandLink value="X " styleClass="style2"
								reRender="checkList,program"
								actionListener="#{searchEngineController.removeProgramOption}"
								rendered="#{searchEngineController.check_selectedProgram}"/>
								
								<h:outputText value="| Program "
								rendered="#{searchEngineController.check_selectedProgram}"/>							
								&nbsp;								
							</h:panelGroup>							
							<h:panelGroup rendered="#{searchEngineController.check_selectedProgramDomain}"
							styleClass="savedQueryStyle">								
								&nbsp;								
								<a4j:commandLink value="X " styleClass="style2"
								reRender="checkList,programDomain"
								actionListener="#{searchEngineController.removeProgramDomainOption}"
								rendered="#{searchEngineController.check_selectedProgramDomain}"/>
								
								<h:outputText value="| Program Domain "
								rendered="#{searchEngineController.check_selectedProgramDomain}"/>								
								&nbsp;							
							</h:panelGroup>	
							<h:panelGroup rendered="#{searchEngineController.check_selectedProgramGroup}"
							styleClass="savedQueryStyle">								
								&nbsp;								
								<a4j:commandLink value="X " styleClass="style2"
								reRender="checkList,programGroup"
								actionListener="#{searchEngineController.removeProgramGroupOption}"
								rendered="#{searchEngineController.check_selectedProgramGroup}"/>
								
								<h:outputText value="| Program Group "
								rendered="#{searchEngineController.check_selectedProgramGroup}"/>								
								&nbsp;							
							</h:panelGroup>							
							<h:panelGroup rendered="#{searchEngineController.check_selectedUKMajor}"
							styleClass="savedQueryStyle">							
								&nbsp;							
								<a4j:commandLink value="X " styleClass="style2"
								reRender="checkList,ukmajor" limitToList="true"
								actionListener="#{searchEngineController.removeUKMajorOption}"
								rendered="#{searchEngineController.check_selectedUKMajor}"/>
								
								<h:outputText value="| Major "
								rendered="#{searchEngineController.check_selectedUKMajor}"/>								
								&nbsp;								
							</h:panelGroup>							
							<h:panelGroup rendered="#{searchEngineController.check_selectedProgramStatus}"
							styleClass="savedQueryStyle">							
								&nbsp;								
								<a4j:commandLink value="X " styleClass="style2"
								reRender="checkList,programStatus" limitToList="true"
								actionListener="#{searchEngineController.removeProgramStatusOption}"
								rendered="#{searchEngineController.check_selectedProgramStatus}"/>
								
								<h:outputText value="| Program Status "
								rendered="#{searchEngineController.check_selectedProgramStatus}"/>								
								&nbsp;							
							</h:panelGroup>		
							<h:panelGroup rendered="#{searchEngineController.check_selectedAnticipatedCompleteTerm}"
							styleClass="savedQueryStyle">							
								&nbsp;								
								<a4j:commandLink value="X " styleClass="style2"
								reRender="checkList,anticipatedCompleteTerm" limitToList="true"
								actionListener="#{searchEngineController.removeAnticipatedCompleteTermOption}"
								rendered="#{searchEngineController.check_selectedAnticipatedCompleteTerm}"/>
								
								<h:outputText value="| Anticipated Complete Term "
								rendered="#{searchEngineController.check_selectedAnticipatedCompleteTerm}"/>								
								&nbsp;							
							</h:panelGroup>	
							<h:panelGroup rendered="#{searchEngineController.check_selectedProgramStartTerm}"
							styleClass="savedQueryStyle">
								&nbsp;								
								<a4j:commandLink value="X " styleClass="style2"
								reRender="checkList,programStartTerm" limitToList="true"
								actionListener="#{searchEngineController.removeProgramStartTermOption}"
								rendered="#{searchEngineController.check_selectedProgramStartTerm}"/>
								
								<h:outputText value="| Program Start Term "
								rendered="#{searchEngineController.check_selectedProgramStartTerm}"/>								
								&nbsp;							
							</h:panelGroup>				
							<h:panelGroup rendered="#{searchEngineController.check_selectedProgramCompleteTerm}"
							styleClass="savedQueryStyle">							
								&nbsp;								
								<a4j:commandLink value="X " styleClass="style2"
								reRender="checkList,programCompleteTerm" limitToList="true"
								actionListener="#{searchEngineController.removeProgramCompleteTermOption}"
								rendered="#{searchEngineController.check_selectedProgramCompleteTerm}"/>
								
								<h:outputText value="| Program Complete Term "
								rendered="#{searchEngineController.check_selectedProgramCompleteTerm}"/>								
								&nbsp;								
							</h:panelGroup>		
							
							
												
							<h:panelGroup rendered="#{searchEngineController.check_selectedProfessionalAdvisor}"
							styleClass="savedQueryStyle">							
								&nbsp;								
								<a4j:commandLink value="X " styleClass="style2"
								reRender="checkList,professionalAdvisor" limitToList="true"
								actionListener="#{searchEngineController.removeProfessionalAdvisorOption}"
								rendered="#{searchEngineController.check_selectedProfessionalAdvisor}"/>
								
								<h:outputText value="| Professional Advisor"
								rendered="#{searchEngineController.check_selectedProfessionalAdvisor}"/>								
								&nbsp;								
							</h:panelGroup>		
								
							<h:panelGroup rendered="#{searchEngineController.check_selectedFacultyAdvisor}"
							styleClass="savedQueryStyle">							
								&nbsp;								
								<a4j:commandLink value="X " styleClass="style2"
								reRender="checkList,facultyAdvisor" limitToList="true"
								actionListener="#{searchEngineController.removeFacultyAdvisorOption}"
								rendered="#{searchEngineController.check_selectedFacultyAdvisor}"/>
								
								<h:outputText value="| Faculty Advisor"
								rendered="#{searchEngineController.check_selectedFacultyAdvisor}"/>								
								&nbsp;								
							</h:panelGroup>	
							
							
							
							<h:panelGroup rendered="#{searchEngineController.check_selectedUserType}"
							styleClass="savedQueryStyle">							
								&nbsp;								
								<a4j:commandLink value="X " styleClass="style2"
								reRender="checkList,userType" limitToList="true"
								actionListener="#{searchEngineController.removeUserTypeOption}"
								rendered="#{searchEngineController.check_selectedUserType}"/>
								
								<h:outputText value="| User Type "
								rendered="#{searchEngineController.check_selectedUserType}"/>								
								&nbsp;								
							</h:panelGroup>
							<h:panelGroup rendered="#{searchEngineController.check_selectedUserClassification}"
							styleClass="savedQueryStyle">							
								&nbsp;								
								<a4j:commandLink value="X " styleClass="style2"
								reRender="checkList,userClassification" limitToList="true"
								actionListener="#{searchEngineController.removeUserClassificationOption}"
								rendered="#{searchEngineController.check_selectedUserClassification}"/>
								
								<h:outputText value="| User Classification "
								rendered="#{searchEngineController.check_selectedUserClassification}"/>								
								&nbsp;								
							</h:panelGroup>
							<h:panelGroup rendered="#{searchEngineController.check_selectedCollege}"
							styleClass="savedQueryStyle">							
								&nbsp;								
								<a4j:commandLink value="X " styleClass="style2"
								reRender="checkList,ukCollege" limitToList="true"
								actionListener="#{searchEngineController.removeCollegeOption}"
								rendered="#{searchEngineController.check_selectedCollege}"/>
								
								<h:outputText value="| College "
								rendered="#{searchEngineController.check_selectedCollege}"/>								
								&nbsp;								
							</h:panelGroup>
							<h:panelGroup rendered="#{searchEngineController.check_selectedDepartment}"
							styleClass="savedQueryStyle">							
								&nbsp;								
								<a4j:commandLink value="X " styleClass="style2"
								reRender="checkList,ukDepartment" limitToList="true"
								actionListener="#{searchEngineController.removeDepartmentOption}"
								rendered="#{searchEngineController.check_selectedDepartment}"/>
								
								<h:outputText value="| Department "
								rendered="#{searchEngineController.check_selectedDepartment}"/>								
								&nbsp;								
							</h:panelGroup>
							<h:panelGroup rendered="#{searchEngineController.check_selectedCollegeStartTerm}"
							styleClass="savedQueryStyle">							
								&nbsp;								
								<a4j:commandLink value="X " styleClass="style2"
								reRender="checkList,collegeStartTerm" limitToList="true"
								actionListener="#{searchEngineController.removeCollegeStartTermOption}"
								rendered="#{searchEngineController.check_selectedCollegeStartTerm}"/>
								
								<h:outputText value="| College Start Term "
								rendered="#{searchEngineController.check_selectedCollegeStartTerm}"/>								
								&nbsp;								
							</h:panelGroup>
							<h:panelGroup rendered="#{searchEngineController.check_selectedCollegeEndTerm}"
							styleClass="savedQueryStyle">							
								&nbsp;								
								<a4j:commandLink value="X " styleClass="style2"
								reRender="checkList,collegeEndTerm" limitToList="true"
								actionListener="#{searchEngineController.removeCollegeEndTermOption}"
								rendered="#{searchEngineController.check_selectedCollegeEndTerm}"/>
								
								<h:outputText value="| College End Term "
								rendered="#{searchEngineController.check_selectedCollegeEndTerm}"/>								
								&nbsp;								
							</h:panelGroup>
							<h:panelGroup rendered="#{searchEngineController.check_selectedCollegeStatus}"
							styleClass="savedQueryStyle">							
								&nbsp;								
								<a4j:commandLink value="X " styleClass="style2"
								reRender="checkList,collegeStatus" limitToList="true"
								actionListener="#{searchEngineController.removeCollegeStatusOption}"
								rendered="#{searchEngineController.check_selectedCollegeStatus}"/>
								
								<h:outputText value="| College Status "
								rendered="#{searchEngineController.check_selectedCollegeStatus}"/>								
								&nbsp;								
							</h:panelGroup>
							<h:panelGroup rendered="#{searchEngineController.check_selectedCohortType}"
							styleClass="savedQueryStyle">							
								&nbsp;								
								<a4j:commandLink value="X " styleClass="style2"
								reRender="checkList,cohortType" limitToList="true"
								actionListener="#{searchEngineController.removeCohortTypeOption}"
								rendered="#{searchEngineController.check_selectedCohortType}"/>
								
								<h:outputText value="| Cohort Type "
								rendered="#{searchEngineController.check_selectedCohortType}"/>								
								&nbsp;								
							</h:panelGroup>
							<h:panelGroup rendered="#{searchEngineController.check_selectedCohortTerm}"
							styleClass="savedQueryStyle">							
								&nbsp;								
								<a4j:commandLink value="X " styleClass="style2"
								reRender="checkList,cohortTerm" limitToList="true"
								actionListener="#{searchEngineController.removeCohortTermOption}"
								rendered="#{searchEngineController.check_selectedCohortTerm}"/>
								
								<h:outputText value="| Cohort Term "
								rendered="#{searchEngineController.check_selectedCohortTerm}"/>								
								&nbsp;								
							</h:panelGroup>
						</h:panelGroup>
					</h:panelGroup>
					<h:panelGroup style="width:100%">
						<a4j:commandButton id="saveQueryLink" style="float:right;"
							value="Save Query" styleClass="buttonStyle"
							oncomplete="#{rich:component('saveQueryPanel')}.show()"
							reRender="saveQueryPanel">
							<f:setPropertyActionListener value="#{true}"
								target="#{searchEngineController.showSaveQueryModalWindow}" />
							<f:setPropertyActionListener value="#{null}"
								target="#{searchEngineController.queryName}" />
							<f:setPropertyActionListener value="#{null}"
								target="#{searchEngineController.queryDescription}" />
						</a4j:commandButton>
					</h:panelGroup>
				</h:panelGrid>
			</rich:panel>
		</h:panelGroup>		
		
		<h:panelGroup id="options-area" layout="block" style="padding-bottom: 20px">	
		
			<rich:simpleTogglePanel switchType="client" label="Report Column Options" 
			width="100%" rendered="#{searchEngineController.showReportColumnOptions}" >
				<h:panelGrid columns="6" cellpadding="2" width="100%" >				
					<h:panelGroup id="col_1" layout="block">
						<h:panelGrid columns="2" cellpadding="2" width="100%" columnClasses="right-col, left-col">
						
							<h:selectBooleanCheckbox id="showUkId" value="#{searchEngineController.showUkIdCol}" />
							<h:outputLabel for="showUkId" value="UK ID" styleClass="small"/>
							
							<h:selectBooleanCheckbox id="showLastName" value="#{searchEngineController.showLastNameCol}" />				
							<h:outputLabel for="showLastName" value="Last Name" styleClass="small"/>
							
							<h:selectBooleanCheckbox id="showMiddleName" value="#{searchEngineController.showMiddleNameCol}" />
							<h:outputLabel for="showMiddleName" value="Middle Name" styleClass="small"/>
							
							<h:selectBooleanCheckbox id="showFirstName" value="#{searchEngineController.showFirstNameCol}" />
							<h:outputLabel for="showFirstName" value="First Name" styleClass="small"/>
											
						</h:panelGrid>
					</h:panelGroup>
					
					<h:panelGroup id="col_2" layout="block">
						<h:panelGrid columns="2" cellpadding="2" width="100%" columnClasses="right-col, left-col">
						
							<h:selectBooleanCheckbox id="showLinkBlueId" value="#{searchEngineController.showLinkBlueIdCol}" />
							<h:outputLabel for="showLinkBlueId" value="Link Blue Id" styleClass="small"/>
															
							<h:selectBooleanCheckbox id="showUkyEmail" value="#{searchEngineController.showUkyEmailCol}" />
							<h:outputLabel for="showUkyEmail" value="UK Email Address" styleClass="small"/>
							
							<h:selectBooleanCheckbox id="showGender" value="#{searchEngineController.showGenderCol}" />
							<h:outputLabel for="showGender" value="Gender" styleClass="small"/>
							
							<h:selectBooleanCheckbox id="showEthnicity" value="#{searchEngineController.showEthnicityCol}" />
							<h:outputLabel for="showEthnicity" value="Ethnicity" styleClass="small"/>		
																				
						</h:panelGrid>
					</h:panelGroup>
					
					<h:panelGroup id="col_3" layout="block">
						<h:panelGrid columns="2" cellpadding="2" width="100%" columnClasses="right-col, left-col">
						
							<h:selectBooleanCheckbox id="showUkMajor" value="#{searchEngineController.showUkMajorCol}" />
							<h:outputLabel for="showUkMajor" value="UK Major" styleClass="small"/>
							
							<h:selectBooleanCheckbox id="showProgram" value="#{searchEngineController.showProgramCol}" />
							<h:outputLabel for="showProgram" value="Program" styleClass="small"/>
								
							<h:selectBooleanCheckbox id="showProgramStartTerm" value="#{searchEngineController.showProgramStartTermCol}" />
							<h:outputLabel for="showProgramStartTerm" value="Program Start Term" styleClass="small"/>
													
							<h:selectBooleanCheckbox id="showProgramCompleteTerm" value="#{searchEngineController.showProgramCompleteTermCol}" />
							<h:outputLabel for="showProgramCompleteTerm" value="Program Complete Term" styleClass="small"/>
								
						</h:panelGrid>
					</h:panelGroup>	
					
					<h:panelGroup id="col_4" layout="block">
						<h:panelGrid columns="2" cellpadding="2" width="100%" columnClasses="right-col, left-col">
						
							<h:selectBooleanCheckbox id="showAnticipatedCompleteTerm" value="#{searchEngineController.showAnticipatedCompleteTermCol}" />
							<h:outputLabel for="showAnticipatedCompleteTerm" value="Anticipated Complete Term" styleClass="small"/>
								
							<h:selectBooleanCheckbox id="showProgramGroup" value="#{searchEngineController.showProgramGroupCol}" />
							<h:outputLabel for="showProgramGroup" value="Program Group" styleClass="small"/>
							
							<h:selectBooleanCheckbox id="showProgramStatus" value="#{searchEngineController.showProgramStatusCol}" />					
							<h:outputLabel for="showProgramStatus" value="Program Status" styleClass="small"/>
											
							<h:selectBooleanCheckbox id="showProgramDomain" value="#{searchEngineController.showProgramDomainCol}" />					
							<h:outputLabel for="showProgramDomain" value="Program Domain" styleClass="small"/>
														
						</h:panelGrid>
					</h:panelGroup>	
					<h:panelGroup id="col_5" layout="block">
						<h:panelGrid columns="2" cellpadding="2" width="100%" columnClasses="right-col, left-col">
						
							<h:selectBooleanCheckbox id="showCollege" value="#{searchEngineController.showCollegeCol}" />
							<h:outputLabel for="showCollege" value="College" styleClass="small"/>
							
							<h:selectBooleanCheckbox id="showCollegeStartTerm" value="#{searchEngineController.showCollegeStartTermCol}" />
							<h:outputLabel for="showCollegeStartTerm" value="College Start Term" styleClass="small"/>
							
							<h:selectBooleanCheckbox id="showCollegeStatus" value="#{searchEngineController.showCollegeStatusCol}" />					
							<h:outputLabel for="showCollegeStatus" value="College Status" styleClass="small"/>
							
							<h:selectBooleanCheckbox id="showDepartment" value="#{searchEngineController.showDepartmentCol}" />					
							<h:outputLabel for="showDepartment" value="Department" styleClass="small"/>
												
						</h:panelGrid>
					</h:panelGroup>	
					<h:panelGroup id="col_6" layout="block">
						<h:panelGrid columns="2" cellpadding="2" width="100%" columnClasses="right-col, left-col">
						
							<h:selectBooleanCheckbox id="showGPA" value="#{searchEngineController.showGpaCol}" />
							<h:outputLabel for="showGPA" value="GPA" styleClass="small"/>							
								
							<h:selectBooleanCheckbox id="showTotalQualityHours" value="#{searchEngineController.showQualityHoursCol}" />												
							<h:outputLabel for="showTotalQualityHours" value="Quality Hours" styleClass="small"/>							
							
							<h:selectBooleanCheckbox id="showtotalQualityPoints" value="#{searchEngineController.showQualityPointsCol}" />
							<h:outputLabel for="showtotalQualityPoints" value="Quality Points" styleClass="small"/>
							
							<h:selectBooleanCheckbox id="showProfessionalAdvisor" value="#{searchEngineController.showProfessionalAdvisorCol}" />
							<h:outputLabel for="showProfessionalAdvisor" value="Professional Advisor" styleClass="small"/>
							
							<h:selectBooleanCheckbox id="showFacultyAdvisor" value="#{searchEngineController.showFacultyAdvisorCol}" />
							<h:outputLabel for="showFacultyAdvisor" value="Faculty Advisor" styleClass="small"/>				
							
						</h:panelGrid>
					</h:panelGroup>	
				</h:panelGrid>				
			</rich:simpleTogglePanel>
			
			<rich:simpleTogglePanel  switchType="client"  label="Advanced Search Options" width="100%" opened="false">
			
				<h:outputLabel for="userOptions" value="User Options"  styleClass="medium-bold"/>				
				<rich:separator id="userOptions" lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>
			
				<h:panelGrid columns="4" cellpadding="2" width="100%">				
					<h:panelGroup id="userOptions_col_1" layout="block">
						<h:panelGrid columns="2" cellpadding="2" width="100%">							
							<h:outputLabel for="userName" value="Username :" styleClass="small"/>
							<h:inputText id="userName" value="#{searchEngineController.username}"/>
							
							<h:outputLabel for="ukId" value="UK ID :" styleClass="small"/>
							<h:inputText id="ukId" value="#{searchEngineController.ukID}"/>							
						</h:panelGrid>
					</h:panelGroup>
					<h:panelGroup id="userOptions_col_2" layout="block">
						<h:panelGrid columns="2" cellpadding="2" width="100%">							
							<h:outputLabel for="firstName" value="First Name :" styleClass="small"/>
							<h:inputText id="firstName" value="#{searchEngineController.firstName}"/>
							
							<h:outputLabel for="lastName" value="Last Name :" styleClass="small"/>
							<h:inputText id="lastName" value="#{searchEngineController.lastName}"/>							
						</h:panelGrid>
					</h:panelGroup>
					<h:panelGroup id="userOptions_col_3" layout="block">
						<h:panelGrid columns="2" cellpadding="2" width="100%">
							<h:outputLabel for="middleName" value="Middle Name :" styleClass="small"/>
							<h:inputText id="middleName" value="#{searchEngineController.middleName}"/>
							
							<h:outputLabel for="maidenName" value="Maiden Name :" styleClass="small"/>
							<h:inputText id="maidenName" value="#{searchEngineController.maidenName}"/>
						</h:panelGrid>
					</h:panelGroup>
					<h:panelGroup id="userOptions_col_4" layout="block">
						<h:panelGrid columns="2" cellpadding="2" width="100%">
							<h:outputLabel for="ssn" value="SSN :" styleClass="small"/>
							<h:inputText id="ssn" value="#{searchEngineController.ssn}"/>
							
							<h:outputLabel for="gender" value="Gender :" styleClass="small"/>
							<h:selectOneMenu id="gender" value="#{searchEngineController.gender}">
								<f:selectItem itemLabel="Any" itemValue="NA" />
								<f:selectItem itemLabel="Male" itemValue="male" />
								<f:selectItem itemLabel="Female" itemValue="female" />
							</h:selectOneMenu>
						</h:panelGrid>
					</h:panelGroup>
				</h:panelGrid>
			
				<h:outputLabel for="programOptions" value="Program Options"  styleClass="medium-bold"/>				
				<rich:separator id="programOptions" lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>
				
				<h:panelGrid columns="3" cellpadding="2" width="100%" >				
					<h:panelGroup id="programOptions_col_1" layout="block">
						<h:panelGrid columns="2" cellpadding="2" width="100%">
						
							<h:outputLabel for="programDomain" value="Program Domain :" styleClass="small"/>
							<h:selectOneListbox id="programDomain" size="1" style="width:180px;"
							value="#{searchEngineController.selectedProgramDomain}"
							converter="#{ProgramDomainDataConverter}">
								<f:selectItem itemLabel="Any" itemValue="NA" />
								<f:selectItems var="programDomain"
								value="#{cepisGlobalComponentConfigurator.programDomainList}"
								itemLabel="#{programDomain.shortDesc}" />
								<f:validator validatorId="ProgramDomainDataValidator" />
							</h:selectOneListbox>
						
							<h:outputLabel for="program" value="Program :" styleClass="small"/>
							<h:selectOneListbox id="program" size="1"
							value="#{searchEngineController.selectedProgram}"
							converter="#{ProgramDataConverter}" style="width:180px;">						
								<f:selectItem itemLabel="Any" itemValue="NA" />
								<f:selectItems var="program" itemLabel="#{program.shortDesc}"
								value="#{cepisGlobalComponentConfigurator.programList}"/>							
								<f:validator validatorId="ProgramDataValidator" />	
							</h:selectOneListbox>
							
							<h:outputLabel for="programGroup" value="Program Group :" styleClass="small"/>
							<h:selectOneListbox	id="programGroup"
							value="#{searchEngineController.selectedProgramGroup}"
							size="1" style="width:180px;"
							converter="#{ProgramGroupDataConverter}">						
								<f:selectItem itemLabel="Any" itemValue="NA" />
								<f:selectItems var="programGroup" itemLabel="#{programGroup.shortDesc}"
								value="#{cepisGlobalComponentConfigurator.programGroupList}"/>
								<f:validator validatorId="ProgramGroupDataValidator" />
							</h:selectOneListbox>						
						</h:panelGrid>
					</h:panelGroup>
					
					<h:panelGroup id="programOptions_col_2" layout="block">
						<h:panelGrid columns="2" cellpadding="2" width="100%">
							<h:outputLabel for="programStartTerm" value="Program Start Term :" styleClass="small"/>
							<h:selectOneListbox id="programStartTerm"
							value="#{searchEngineController.selectedProgramStartTerm}"
							size="1" converter="#{UKTermDataConverter}"
							style="width:180px;">
								<f:selectItem itemLabel="Any" itemValue="NA" />
								<f:selectItems var="ukTerm"
								value="#{cepisGlobalComponentConfigurator.ukTermList}"
								itemLabel="#{ukTerm.shortDesc}" />
								<f:validator validatorId="UKTermDataValidator" />
							</h:selectOneListbox>
								
							<h:outputLabel for="programCompleteTerm" value="Program Complete Term :" styleClass="small"/>
							<h:selectOneListbox id="programCompleteTerm"
							value="#{searchEngineController.selectedProgramCompleteTerm}"
							size="1" converter="#{UKTermDataConverter}"
							style="width:180px;">
								<f:selectItem itemLabel="Any" itemValue="NA" />
								<f:selectItems var="ukTerm"
								value="#{cepisGlobalComponentConfigurator.ukTermList}"
								itemLabel="#{ukTerm.shortDesc}" />
								<f:validator validatorId="UKTermDataValidator" />
							</h:selectOneListbox>
								
							<h:outputLabel for="anticipatedCompleteTerm" value="Anticipated Complete Term :" styleClass="small"/>	
							<h:selectOneListbox id="anticipatedCompleteTerm"
							value="#{searchEngineController.selectedAnticipatedCompleteTerm}"
							size="1" style="width:180px;"
							converter="#{UKTermDataConverter}">
								<f:selectItem itemLabel="Any" itemValue="NA" />
								<f:selectItems var="ukTerm"
									value="#{cepisGlobalComponentConfigurator.ukTermList}"
									itemLabel="#{ukTerm.shortDesc}" />
									<f:validator validatorId="UKTermDataValidator" />
							</h:selectOneListbox>
						</h:panelGrid>
					</h:panelGroup>
					<h:panelGroup id="programOptions_col_3" layout="block">
						<h:panelGrid columns="2" cellpadding="2" width="100%">
							<h:outputLabel for="ukmajor" value="UK Major :" styleClass="small"/>							
							<h:selectOneListbox	id="ukmajor"
							value="#{searchEngineController.selectedUKMajor}"
							size="1" style="width:180px;"
							converter="#{UKMajorDataConverter}" >
								<f:selectItem itemLabel="Any" itemValue="NA" />
								<f:selectItems var="ukMajor" itemLabel="#{ukMajor.shortDesc}" 
								value="#{cepisGlobalComponentConfigurator.ukMajorList}" />
								<f:validator validatorId="UKMajorDataValidator" />
							</h:selectOneListbox>
							
							<h:outputLabel for="programStatus" value="Program Status :" styleClass="small"/>							
							<h:selectOneListbox id="programStatus"
							value="#{searchEngineController.selectedProgramStatus}"
							size="1" style="width:180px;"
							converter="#{UKStatusDataConverter}">
								<f:selectItem itemLabel="Any" itemValue="NA" />
								<f:selectItems var="ukStatus"
								value="#{cepisGlobalComponentConfigurator.ukStatusList}"
								itemLabel="#{ukStatus.shortDesc}" />
								<f:validator validatorId="UKStatusDataValidator" />
							</h:selectOneListbox>
								
							<h:outputLabel for="professionalAdvisor" value="Professional Advisor :" styleClass="small"/>
							<h:selectOneListbox	id="professionalAdvisor"
							value="#{searchEngineController.selectedProfessionalAdvisor}"
							size="1" style="width: 180px;"
							converter="#{AdvisorDataConverter}">
								<f:selectItem itemLabel="Any" itemValue="NA" />
								<f:selectItems var="professionalAdvisor" itemLabel="#{professionalAdvisor.shortDesc}"
								value="#{cepisGlobalComponentConfigurator.advisorList}" />
								<f:validator validatorId="AdvisorDataValidator" />
							</h:selectOneListbox>
							
							<h:outputLabel for="facultyAdvisor" value="Faculty Advisor :" styleClass="small"/>
							<h:selectOneListbox	id="facultyAdvisor"
							value="#{searchEngineController.selectedFacultyAdvisor}"
							size="1" style="width: 180px;"
							converter="#{FacultyAdvisorDataConverter}">
								<f:selectItem itemLabel="Any" itemValue="NA" />
								<f:selectItems var="facultyAdvisor" itemLabel="#{facultyAdvisor.shortDesc}"
								value="#{cepisGlobalComponentConfigurator.facultyAdvisorList}" />
								<f:validator validatorId="FacultyAdvisorDataValidator" />
							</h:selectOneListbox>
						</h:panelGrid>
					</h:panelGroup>				
				</h:panelGrid>
			
				<h:outputLabel for="collegeOptions" value="College Options"  styleClass="medium-bold"/>				
				<rich:separator id="collegeOptions" lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>
				
				<h:panelGrid columns="3" cellpadding="2" width="100%" >				
					<h:panelGroup id="collegeOptions_col_1" layout="block">
						<h:panelGrid columns="2" cellpadding="2" width="100%">
						
							<h:outputLabel for="userType" value="User Type :" styleClass="small"/>
							<h:selectOneListbox	id="userType"
							value="#{searchEngineController.selectedUserType}"
							size="1" style="width: 180px;"
							converter="#{UserTypeDataConverter}">
								<f:selectItem itemLabel="Any" itemValue="NA" />
								<f:selectItems var="userType" itemLabel="#{userType.shortDesc}"
								value="#{cepisGlobalComponentConfigurator.userTypeList}" />
								<f:validator validatorId="UserTypeDataValidator" />
							</h:selectOneListbox>
							
							<h:outputLabel for="userClassification" value="User Classification :" styleClass="small"/>
							<h:selectOneListbox	id="userClassification"
							value="#{searchEngineController.selectedUserClassification}"
							size="1" style="width: 180px;"
							converter="#{UserClassificationDataConverter}">
								<f:selectItem itemLabel="Any" itemValue="NA" />
								<f:selectItems var="userClassification" itemLabel="#{userClassification.shortDesc}"
								value="#{cepisGlobalComponentConfigurator.userClassificationList}" />
								<f:validator validatorId="UserClassificationDataValidator" />
							</h:selectOneListbox>
							
							<h:outputLabel for="ukCollege" value="College :" styleClass="small"/>
							<h:selectOneListbox	id="ukCollege"
							value="#{searchEngineController.selectedUkCollege}"
							size="1" style="width: 180px;"
							converter="#{UKCollegeDataConverter}">
								<f:selectItem itemLabel="Any" itemValue="NA" />
								<f:selectItems var="ukCollege" itemLabel="#{ukCollege.ukCollegeCode}  #{ukCollege.collegeName}"
								value="#{cepisGlobalComponentConfigurator.ukCollegeList}" />
								<f:validator validatorId="UKCollegeDataValidator" />
							</h:selectOneListbox>
							
						</h:panelGrid>
					</h:panelGroup>
					<h:panelGroup id="collegeOptions_col_2" layout="block">
						<h:panelGrid columns="2" cellpadding="2" width="100%">
						
							<h:outputLabel for="ukDepartment" value="Department :" styleClass="small"/>
							<h:selectOneListbox	id="ukDepartment"
							value="#{searchEngineController.selectedUkDepartment}"
							size="1" style="width: 180px;"
							converter="#{UKDepartmentDataConverter}">
								<f:selectItem itemLabel="Any" itemValue="NA" />
								<f:selectItems var="ukDepartment" 
								itemLabel="#{ukDepartment.departmentCode}  #{ukDepartment.departmentName}"
								value="#{cepisGlobalComponentConfigurator.ukDepartmentList}" />
								<f:validator validatorId="UKDepartmentDataValidator" />
							</h:selectOneListbox>
							
							<h:outputLabel for="collegeStartTerm" value="College Start Term :" styleClass="small"/>
							<h:selectOneListbox	id="collegeStartTerm" size="1" style="width:180px;"
							value="#{searchEngineController.selectedCollegeStartTerm}"							
							converter="#{UKTermDataConverter}">
								<f:selectItem itemLabel="Any" itemValue="NA" />
								<f:selectItems var="ukStartTerm" 
								itemLabel="#{ukStartTerm.shortDesc}"
								value="#{cepisGlobalComponentConfigurator.ukTermList}" />
								<f:validator validatorId="UKTermDataValidator" />
							</h:selectOneListbox>
														
							<h:outputLabel for="collegeEndTerm" value="College End Term :" styleClass="small"/>
							<h:selectOneListbox	id="collegeEndTerm" size="1" style="width:180px;"
							value="#{searchEngineController.selectedCollegeEndTerm}"							
							converter="#{UKTermDataConverter}">
								<f:selectItem itemLabel="Any" itemValue="NA" />
								<f:selectItems var="ukEndTerm" 
								itemLabel="#{ukEndTerm.shortDesc}"
								value="#{cepisGlobalComponentConfigurator.ukTermList}" />
								<f:validator validatorId="UKTermDataValidator" />
							</h:selectOneListbox>
						
						</h:panelGrid>
					</h:panelGroup>
					<h:panelGroup id="collegeOptions_col_3" layout="block">
						<h:panelGrid columns="2" cellpadding="2" width="100%">
							
							<h:outputLabel for="collegeStatus" value="College Status :" styleClass="small"/>
							<h:selectOneListbox	id="collegeStatus" size="1" style="width:180px;"
							value="#{searchEngineController.selectedCollegeStatus}"							
							converter="#{UKStatusDataConverter}">
								<f:selectItem itemLabel="Any" itemValue="NA" />
								<f:selectItems var="ukStatus" 
								itemLabel="#{ukStatus.shortDesc}"
								value="#{cepisGlobalComponentConfigurator.ukStatusList}" />
								<f:validator validatorId="UKStatusDataValidator" />
							</h:selectOneListbox>
							
							<h:outputLabel for="cohortType" value="Cohort Type :" styleClass="small"/>
							<h:selectOneListbox	id="cohortType" size="1" style="width:180px;"
							value="#{searchEngineController.selectedCohortType}"							
							converter="#{CohortTypeDataConverter}">
								<f:selectItem itemLabel="Any" itemValue="NA" />
								<f:selectItems var="cohortType" 
								itemLabel="#{cohortType.shortDesc}"
								value="#{cepisGlobalComponentConfigurator.cohortTypeList}" />
								<f:validator validatorId="CohortTypeDataValidator" />
							</h:selectOneListbox>
							
							<h:outputLabel for="cohortTerm" value="Cohort Term :" styleClass="small"/>
							<h:selectOneListbox	id="cohortTerm" size="1" style="width:180px;"
							value="#{searchEngineController.selectedCohortTerm}"							
							converter="#{CohortTermDataConverter}">
								<f:selectItem itemLabel="Any" itemValue="NA" />
								<f:selectItems var="cohortTerm" 
								itemLabel="#{cohortTerm.shortDesc}"
								value="#{cepisGlobalComponentConfigurator.cohortTermList}" />
								<f:validator validatorId="CohortTermDataValidator" />
							</h:selectOneListbox>
							
						</h:panelGrid>
					</h:panelGroup>
				</h:panelGrid>		
			</rich:simpleTogglePanel>			
		</h:panelGroup>
		<h:panelGroup id="cepisSearchResults-area" layout="block" style="padding-bottom: 20px" >	
		
			<rich:simpleTogglePanel switchType="client"  label="CEPIS Search Results" width="100%"
			rendered="#{searchEngineController.showSearchResults}" >
			
				<h:panelGrid id="cepisSearchResults-grid" columns="2" cellpadding="2" width="100%" >
				
					<h:panelGroup id="results_col_1">
					
						<h:panelGrid columns="2" cellpadding="2" width="100%">		
								
							<a4j:commandButton id="add_user_activeWS"
							value=" Add Selected Users "
							style=" font-weight: bold; width: 50%"
							accesskey="a" >
								<a4j:support reRender="wsid" event="onclick"
								actionListener="#{searchEngineController.addUsersToActiveWorkingSet}"/>
							</a4j:commandButton>
							<a4j:commandButton id="search_result_clear"
							value="Clear Search Result"
							style="font-weight: bold; width: 50%"
							accesskey="l">
								<a4j:support event="onclick"
								reRender="resultSetid,sc1,sc2,search_count"
								actionListener="#{searchEngineController.clearResults}"/>
							</a4j:commandButton>
						
							<h:panelGroup id="searchCount-area" layout="block">
								<h:outputLabel for="searchCount" value="Show : " styleClass="small"/>
								&nbsp; 
								<h:selectOneMenu id="searchCount" style="width:50px"
								value="#{cepisConfigurationManager.searchCount}">
									<f:selectItem itemLabel="All" itemValue="0" />
									<f:selectItem itemLabel="10" itemValue="10" />
									<f:selectItem itemLabel="25" itemValue="25" />
									<f:selectItem itemLabel="50" itemValue="50" />
									<f:selectItem itemLabel="100" itemValue="100" />
									<f:selectItem itemLabel="200" itemValue="200" />							
									<a4j:support event="onchange" ajaxSingle="true" reRender="resultSetid,sc1,sc2"/>							
								</h:selectOneMenu>
							</h:panelGroup>
							<h:panelGroup id="searchResult-area" layout="block">
								<h:outputLabel for="searchResults" value="Found : " styleClass="small" style=""/>
								<h:outputText id="searchResults" value="#{searchEngineController.resultCount}" style=""/>
							</h:panelGroup>
						</h:panelGrid>		
						
						<rich:dataTable id="resultSetid"
						styleClass="basicTable"
						rowClasses="oddRow,evenRow" width="98%"
						reRender="body" sortMode="multi"
						var="user"
						value="#{searchEngineController.resultList}"
						rows="#{cepisConfigurationManager.searchCount}"
						onkeypress="if (event.keyCode == 13) {event.target.blur(); 
						return false;} else {return true;}">
							<f:facet name="header">
								<rich:datascroller for="resultSetid" id="sc2"
								page="#{searchEngineController.pageValue}"
								reRender="sc1" ajaxSingle="false" />
							</f:facet>
							<rich:column>
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{searchEngineController.allUsers}">
										<a4j:support id="selectAllCheckBox"
										actionListener="#{searchEngineController.selectAll}"
										event="onchange" reRender="resultSetid" />
									</h:selectBooleanCheckbox>
								</f:facet>
								<h:selectBooleanCheckbox
								value="#{searchEngineController.selectedUserIds[user.uid]}">
								</h:selectBooleanCheckbox>
							</rich:column>
							<rich:column width="100px">
								<f:facet name="header">
									<h:panelGroup layout="span">
										<h:outputText value="UID" />
									</h:panelGroup>
								</f:facet>
								<h:outputText value="#{user.uid}" />
							</rich:column>
							<rich:column sortBy="#{user.lName}"
							sortOrder="#{searchEngineController.sortOrderLastNameValue}">
								<f:facet name="header">
									<h:panelGroup layout="span">
										<h:outputText value="Last Name" />
										<h:graphicImage style="width:15px;height:15px;"
										url="/images/info.png" alt="i"
										title="Use the up/down arrow to sort the Last Name column ascending/descending. " />
									</h:panelGroup>
								</f:facet>
								<h:outputText value="#{user.lName}" />
							</rich:column>
							<rich:column sortBy="#{user.fName}"
							sortOrder="#{searchEngineController.sortOrderFirstNameValue}">
								<f:facet name="header">
									<h:panelGroup layout="span">
										<h:outputText value="First Name" />
										<h:graphicImage style="width:15px;height:15px;"
										url="/images/info.png" alt="i"
										title="Use the up/down arrow to sort the First Name column ascending/descending." />
									</h:panelGroup>
								</f:facet>
								<h:outputText value="#{user.fName}" />
							</rich:column>
							<rich:column sortBy="#{user.mName}"
							sortOrder="#{searchEngineController.sortOrderMiddleNameValue}">
								<f:facet name="header">
									<h:panelGroup layout="span">
										<h:outputText value="Middle Name" />
										<h:graphicImage style="width:15px;height:15px;"
										url="/images/info.png" alt="i"
										title="Use the up/down arrow to sort the Middle Name column ascending/descending." />
									</h:panelGroup>
								</f:facet>
								<h:outputText value="#{user.mName}" />
							</rich:column>
							<rich:column width="100px">
								<f:facet name="header">
									<h:panelGroup layout="span">
										<h:outputText value="" />
									</h:panelGroup>
								</f:facet>
								<h:panelGrid columns="4">
									<a4j:commandLink id="view_profile"
									ajaxSingle="true"
									action="#{searchEngineController.showProfile}">
										<h:graphicImage id="user_profile_icon"
										value="/images/icons/vcard.png"
										style="padding: 2px 12px 2px 2px;border:0;"
										styleClass="pic" alt="Profile" />
										<f:setPropertyActionListener value="#{user}"
										target="#{searchEngineController.selectedUser}" />
									</a4j:commandLink>
									<rich:toolTip for="view_profile"
									followMouse="true" showDelay="500"
									value="Show the profile of this user."/>
									<a4j:commandLink id="add_ws">
										<h:graphicImage id="user_go_icon"
										value="/images/icons/user_go.png"
										style="padding: 2px 12px 2px 2px;border:0;"
										styleClass="pic" alt="Add2WS" />
										<a4j:support reRender="wsid" event="onclick"
										ajaxSingle="true"
										action="#{searchEngineController.addUserToActiveWorkingSet}">
											<f:setPropertyActionListener
											value="#{user}"
											target="#{searchEngineController.selectedUser}" />
										</a4j:support>
									</a4j:commandLink>
									<rich:toolTip for="add_ws" followMouse="true" showDelay="500"					
									value="Add this user to the workingset (#{workingSetController.activeWorkingSetName})."/>
								</h:panelGrid>
							</rich:column>
							<f:facet name="footer">
								<rich:datascroller id="sc1" ajaxSingle="false"
								page="#{searchEngineController.pageValue}"
								reRender="sc2" />
							</f:facet>
						</rich:dataTable>
					</h:panelGroup>
					
					
					<h:panelGroup id="results_col_2" style="vertical-align: top;">			
						
						<h:panelGroup>
							<h:graphicImage id="wsimg"
							value="/images/icons/cart.png"
							alt="Working Set:" /> 
							
								&nbsp;
							
								<h:outputText id="ws_name" value="#{workingSetController.activeWorkingSetName}"/>	
																
							</h:panelGroup>
							
							<h:panelGrid styleClass="wsCore">
								<h:panelGrid columns="2" width="100%">
									<h:panelGroup style="width:100%;text-align:left;align:left;" layout="block">
										<font color="#062E8A" face="Tahoma">&nbsp;
											<b>
												<a4j:commandLink reRender="wsid,ws_name"
												actionListener="#{workingSetController.newWS}"
												value="New" title="Create new Working Set"/>
												<a4j:commandLink reRender="wsid,ws_name"
												rendered="false"
												actionListener="#{workingSetController.clearWS}"
												onclick="if (!confirm('Clear this Working Set, Are you sure?')) return false"
												title="Clear this Working Set"
												value="Clear"/>
											</b>
										</font>
									</h:panelGroup>
								<h:panelGroup style="width:100%;text-align:right;align:right;" layout="block">
									<font color="#062E8A" face="Tahoma">									
									 	&nbsp;									 
										<b>
											<h:outputLink id="all" onclick="return selectAll('ws:wsid',true);">
												all
											</h:outputLink>											
											&nbsp;|&nbsp;											
											<h:outputLink id="none" onclick="return selectAll('search_manager:ws_show:wsid',false);">
												none
											</h:outputLink>											
											&nbsp;											
										</b>
									</font>										
								</h:panelGroup>
							</h:panelGrid>
							<h:panelGroup id="ws">
								<h:selectManyListbox id="wsid"
								value="#{workingSetController.selectedWSUsersList}"
								size="15" converter="#{UserDataConverter}"
								style="width: 200px;">
									<f:selectItems value="#{workingSetController.activeWSUsersList}"									
									var="user" itemLabel="#{user.fullName}" />
									<f:validator validatorId="UserDataValidator" />
								</h:selectManyListbox>
							</h:panelGroup>
						</h:panelGrid>
						
						<h:panelGroup>						
							&nbsp; &nbsp; &nbsp; 								
							<a4j:commandButton value="Delete"
							onclick="if (!confirm('Are you sure?')) return false"
							reRender="wsid"
							styleClass="buttonStyle"
							actionListener="#{workingSetController.deleteWSUsers}"/>
							&nbsp; &nbsp; &nbsp; 							
							<a4j:commandButton id="saveWSLink" value="Save As"
							styleClass="buttonStyle"
							oncomplete="#{rich:component('saveWSPanel')}.show()"
							reRender="saveWSPanel">
								<f:setPropertyActionListener value="#{true}"
								target="#{workingSetController.showSaveWSModalWindow}" />
								<f:setPropertyActionListener value="#{true}"
								target="#{workingSetController.saveAndOpenNewWS}" />
								<f:setPropertyActionListener value="#{null}"
								target="#{workingSetController.name}" />
								<f:setPropertyActionListener value="#{null}"
								target="#{workingSetController.description}" />
							</a4j:commandButton>							
						</h:panelGroup>							
					</h:panelGroup>
				</h:panelGrid>	
			</rich:simpleTogglePanel>
		</h:panelGroup>
		
		<h:panelGroup id="reportSearchResults-area" layout="block" 
		rendered="#{searchEngineController.showReportResults}">
		
			<h:panelGroup id="reportResult-area" layout="block">
				<h:outputLabel for="reportResults" value="Found : " styleClass="small" style=""/>
				<h:outputText id="reportResults" value="#{searchEngineController.resultCount}" style=""/>
			</h:panelGroup>
		
			<rich:toolBar height="25px" width="100%" itemSeparator="line" style="margin: 20px auto 0px auto">
			
				<rich:toolBarGroup>
				
					<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel" >
					
						<rich:toolTip followMouse="true" direction="top-right" showDelay="500">
							<span style="white-space: nowrap"> Export Data Table to Excel </span>
						</rich:toolTip>
						<a4j:htmlCommandLink id="exportExcel" action="#{searchEngineController.exportHtmlTableToExcel}">				 
							<h:graphicImage id="exportExcelPic" value="/images/excel.png"
							style="border:0" styleClass="pic" alt="O" width="25px" height="25px" />
							<h:outputLabel value="Export" for="exportExcelPic"
							style="cursor: pointer; padding: 2px 10px; color: #000000; text-decoration: underline;" />							
						</a4j:htmlCommandLink>
						
					</rich:panel>
					
				</rich:toolBarGroup>
				
				<rich:toolBarGroup>
				
					<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel">
					
						<rich:toolTip followMouse="true" direction="top-right" showDelay="500">						
							<span style="white-space: nowrap"> View Statistics </span>
						</rich:toolTip>
						
						<a4j:commandLink id="viewStatistics" oncomplete="Richfaces.showModalPanel('reportStatisticsPanel')"
						  ajaxSingle="true" limitToList="true" reRender="reportStatisticsPanel" action="#{searchEngineController.prepStatistics}">				 
							<h:graphicImage id="viewStatisticsPic" value="/images/chart.png"
							style="border:0" styleClass="pic" alt="O" width="25px" height="25px" />
							<h:outputLabel value="View Statistics" for="viewStatisticsPic"
							style="cursor: pointer; padding: 2px 10px; color: #000000; text-decoration: underline;" />	
												
						</a4j:commandLink>
						
					</rich:panel>
					
				</rich:toolBarGroup>
				
			</rich:toolBar>
						
			<rich:extendedDataTable id="report_table" 				
			styleClass="basicTable" rowClasses="oddRow,evenRow"
			width="99.8%" height="500px" 		
			enableContextMenu="false"
			var="record"	
			binding="#{searchEngineController.reportTable}"	
			value="#{searchEngineController.resultList}" 
			noDataLabel="No Records Found.">										
				<rich:column id="ukId_col" rendered="#{searchEngineController.showUkIdCol}" width="75px">
					<f:facet name="header">
						<h:outputText value="UK ID" />
					</f:facet>
					<h:outputText value="#{record.ukID}"/>
				</rich:column>	
				<rich:column id="linkBlueId_col" rendered="#{searchEngineController.showLinkBlueIdCol}" width="100px">
					<f:facet name="header">
						<h:outputText value="Link Blue ID" />
					</f:facet>
					<h:outputText value="#{record.username}"/>
				</rich:column>							
				<rich:column id="lastName_col" rendered="#{searchEngineController.showLastNameCol}" width="100px">
					<f:facet name="header">
						<h:outputText value="Last Name" />
					</f:facet>
					<h:outputText value="#{record.lName}"/>
				</rich:column>				
				<rich:column id="middleName_col" rendered="#{searchEngineController.showMiddleNameCol}" width="100px">
					<f:facet name="header">
						<h:outputText value="Middle Name" />
					</f:facet>
					<h:outputText value="#{record.mName}"/>
				</rich:column>				
				<rich:column id="firstName_col" rendered="#{searchEngineController.showFirstNameCol}" width="100px">
					<f:facet name="header">
						<h:outputText value="First Name" />
					</f:facet>
					<h:outputText value="#{record.fName}"/>
				</rich:column>									
				<rich:column id="ukyEmail_col" rendered="#{searchEngineController.showUkyEmailCol}" width="125px">
					<f:facet name="header">
						<h:outputText value="UK Email Address" />
					</f:facet>
					<h:outputText value="#{record.ukyEmailAddress}"/>
				</rich:column>									
				<rich:column id="gender_col" rendered="#{searchEngineController.showGenderCol}">
					<f:facet name="header">
						<h:outputText value="Gender" />
					</f:facet>
					<h:outputText value="#{record.gender}"/>
				</rich:column>								
				<rich:column id="ethnicity_col" rendered="#{searchEngineController.showEthnicityCol}">
					<f:facet name="header">
						<h:outputText value="Ethnicity" />
					</f:facet>
					<h:outputText value="#{record.userPersonalProfile.ethnic.shortDesc}"/>
				</rich:column>												
				<rich:column id="ukMajor_col" rendered="#{searchEngineController.showUkMajorCol}">
					<f:facet name="header">
						<h:outputText value="UK Major" />
					</f:facet>
					<h:outputText value="#{record.userProgramProfile.ukMajor.shortDesc}"/>
				</rich:column>											
				<rich:column id="program_col" rendered="#{searchEngineController.showProgramCol}">
					<f:facet name="header">
						<h:outputText value="Program" />
					</f:facet>
					<h:outputText value="#{record.userProgramProfile.program.shortDesc}"/>
				</rich:column>																							
				<rich:column id="programStartTerm_col" rendered="#{searchEngineController.showProgramStartTermCol}">
					<f:facet name="header">
						<h:outputText value="Program Start Term" />
					</f:facet>
					<h:outputText value="#{record.userProgramProfile.ukStartTerm.shortDesc}"/>
				</rich:column>												
				<rich:column id="programCompleteTerm_col" rendered="#{searchEngineController.showProgramCompleteTermCol}">
					<f:facet name="header">
						<h:outputText value="Program Complete Term" />
					</f:facet>
					<h:outputText value="#{record.userProgramProfile.ukCompleteTerm.shortDesc}"/>
				</rich:column>
				<rich:column id="programGroup_col" rendered="#{searchEngineController.showProgramGroupCol}">
					<f:facet name="header">
						<h:outputText value="Program Group" />
					</f:facet>
					<h:outputText value="#{record.userProgramProfile.programGroup.shortDesc}"/>
				</rich:column>	
				<rich:column id="anticipatedComplete_col" rendered="#{searchEngineController.showAnticipatedCompleteTermCol}">
					<f:facet name="header">
						<h:outputText value="Anticipated Complete Term" />
					</f:facet>
					<h:outputText value="#{record.userProgramProfile.ukAnticipatedCompleteTerm.shortDesc}"/>
				</rich:column>	
				<rich:column id="programStatus_col" rendered="#{searchEngineController.showProgramStatusCol}">
					<f:facet name="header">
						<h:outputText value="Program Status" />
					</f:facet>
					<h:outputText value="#{record.userProgramProfile.ukStatus.shortDesc}"/>
				</rich:column>		
				<rich:column id="programDomain_col" rendered="#{searchEngineController.showProgramDomainCol}">
					<f:facet name="header">
						<h:outputText value="Program Domain" />
					</f:facet>
					<h:outputText value="#{record.userProgramProfile.programDomain.shortDesc}"/>
				</rich:column>		
				<rich:column id="college_col" rendered="#{searchEngineController.showCollegeCol}">
					<f:facet name="header">
						<h:outputText value="College" />
					</f:facet>
					<h:outputText value="#{record.userCollegeProfile.ukCollege.collegeName}"/>
				</rich:column>							
				<rich:column id="collegeStartTerm_col" rendered="#{searchEngineController.showCollegeStartTermCol}">
					<f:facet name="header">
						<h:outputText value="College Start Term" />
					</f:facet>
					<h:outputText value="#{record.userCollegeProfile.startTerm.shortDesc}"/>
				</rich:column>		
				<rich:column id="collegeStatus_col" rendered="#{searchEngineController.showCollegeStatusCol}">
					<f:facet name="header">
						<h:outputText value="College Status" />
					</f:facet>
					<h:outputText value="#{record.userCollegeProfile.status.shortDesc}"/>
				</rich:column>		
				<rich:column id="department_col" rendered="#{searchEngineController.showDepartmentCol}">
					<f:facet name="header">
						<h:outputText value="Department" />
					</f:facet>
					<h:outputText value="#{record.userCollegeProfile.ukDepartment.shortDescription}"/>
				</rich:column>	
				<rich:column id="cumulativeGpa_Col" rendered="#{searchEngineController.showGpaCol}">
					<f:facet name="header">
						<h:outputText value="Cumulative GPA" />
					</f:facet>
					<h:outputText value="#{record.cumulativeGpa}"/>
				</rich:column>	
				<rich:column id="ukQualityHours_Col" rendered="#{searchEngineController.showQualityHoursCol}">
					<f:facet name="header">
						<h:outputText value="Total UK Quality Hours" />
					</f:facet>
					<h:outputText value="#{record.totalQualityHours}"/>
				</rich:column>	
				<rich:column id="ukQualityPoints_Col" rendered="#{searchEngineController.showQualityPointsCol}">
					<f:facet name="header">
						<h:outputText value="Total UK Quality Points" />
					</f:facet>
					<h:outputText value="#{record.totalQualityPoints}"/>
				</rich:column>	
				<rich:column id="professionalAdvisor_Col" rendered="#{searchEngineController.showProfessionalAdvisorCol}">
					<f:facet name="header">
						<h:outputText value="Professional Advisor" />
					</f:facet>
					<h:outputText value="#{record.userProgramProfile.advisor.shortDesc}"/>
				</rich:column>		
				<rich:column id="facultyAdvisor_Col" rendered="#{searchEngineController.showFacultyAdvisorCol}">
					<f:facet name="header">
						<h:outputText value="Faculty Advisor" />
					</f:facet>
					<h:outputText value="#{record.userProgramProfile.facultyAdvisor.shortDesc}"/>
				</rich:column>	
									
			</rich:extendedDataTable>		
		</h:panelGroup>
		
	</h:form>	
	
	<rich:modalPanel id="searchOptionsPanel" height="300" width="300" autosized="true" domElementAttachment="parent">
		<f:facet name="header">
			<h:outputText value="Search Options" />
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="/images/icons/cancel.png" id="hideViewlink"
				styleClass="hidelink" alt="X" />
				<rich:componentControl for="searchOptionsPanel"
				attachTo="hideViewlink" operation="hide" event="onclick" />
			</h:panelGroup>
		</f:facet>
		<h:form id="searchOptions" styleClass="styleish">			
				
				<h:outputLabel for="searchOrderOption-line" value="Sort By" styleClass="medium"/>
				<rich:separator id="searchOrderOption-line" lineType="dotted" height="2" align="center" style="margin-bottom:5px;"/>
				
				<h:selectManyCheckbox id="searchOrderOption"				
				value="#{searchEngineController.selectedSearchOptions}"
				border="0" styleClass="ws10" layout="pageDirection"
				style="font-color:#062E8A; padding-bottom:10px;">
					<f:selectItem itemLabel="Last name"	itemValue="lName" />					
					<f:selectItem itemLabel="First Name" itemValue="fName" />
					<f:selectItem itemLabel="Middle Name" itemValue="mName" />
					<f:selectItem itemLabel="Username" itemValue="username" />
					<f:selectItem itemLabel="UID" itemValue="uid" />
					<f:selectItem itemLabel="UK Student ID" itemValue="ukID" />
				</h:selectManyCheckbox>
				
				<h:outputLabel for="searchOrderTypeOption-line" value="Sort Order" styleClass="medium" />
				<rich:separator id="searchOrderTypeOption-line" lineType="dotted" height="2" align="center" style="margin-bottom:5px;"/>
				
				<h:selectOneRadio id="searchOrderTypeOption" border="0"					
				value="#{searchEngineController.selectedOrder}"	style="padding-bottom:10px;">
					<f:selectItem itemLabel="ASC" itemValue="0" />
					<f:selectItem itemLabel="DESC" itemValue="1" />
				</h:selectOneRadio>
				
				<h:outputLabel for="savedQueries-line" value="Saved Queries" styleClass="medium" />
				<rich:separator id="savedQueries-line" lineType="dotted" height="2" align="center" style="margin-bottom:5px;"/>
				
				<h:selectOneListbox id="querylistid"				
				value="#{searchEngineController.selectedQuery}"
				size="1" converter="#{QueryDataConverter}">
					<f:selectItem itemLabel="All" itemValue="ALL" />
					<f:selectItems
					value="#{searchEngineController.savedQueryList}"
					var="query" itemLabel="#{query.name}" />
					<f:validator validatorId="QueryDataValidator" />
				</h:selectOneListbox>
				
				<br/>
				<br/>
				
				<h:outputLabel for="searchIn-line" value="Search In Working Set" styleClass="medium" />
				<rich:separator id="searchIn-line" lineType="dotted" height="2" align="center" style="margin-bottom:5px;"/>
				
				<h:selectOneListbox id="wsSwitch"
				value="#{searchEngineController.selectedWS}"
				size="1"
				converter="#{WorkingSetDataConverter}">
					<f:selectItem itemLabel="All" itemValue="ALL" />
					<f:selectItems value="#{workingSetController.activeWSList}"
					var="ws" itemLabel="#{ws.name}" />
					<f:validator validatorId="WorkingSetDataValidator" />					
				</h:selectOneListbox>
				
				<br/>
				<br/>
				
				<h:outputLabel for="searchWithIn-line" value="Search Within Search" styleClass="medium" />
				<rich:separator id="searchWithIn-line" lineType="dotted" height="2" align="center" style="margin-bottom:5px;"/>
				
				<h:outputLabel for="searchWithinOption" value="Yes" styleClass="tiny" />
				<h:selectBooleanCheckbox id="searchWithinOption"				
				value="#{searchEngineController.selectedSearchWithin}"/>
				
				<br/>
				<br/>
			
				<h:commandButton id="ok-button" value="OK" styleClass="buttonStyle">
					<rich:componentControl for="searchOptionsPanel"
					attachTo="hideViewlink" operation="hide" event="onclick" />
					<a4j:support reRender="search-area"/>
				</h:commandButton>
							
		</h:form>
	</rich:modalPanel>
	
	
	<rich:modalPanel id="reportStatisticsPanel" height="500" width="250" autosized="true" domElementAttachment="parent">
		<f:facet name="header">
			<h:outputText value="Report Statistics" />
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="/images/icons/cancel.png" id="hideViewlink2"
				styleClass="hidelink" alt="X" />
				<rich:componentControl for="reportStatisticsPanel"
				attachTo="hideViewlink2" operation="hide" event="onclick" />
			</h:panelGroup>
		</f:facet>
		<h:form id="reportStatistics" styleClass="styleish">	
				
			<h:panelGrid columns="2" cellpadding="2" width="100%">
				<h:panelGroup layout="block" rendered="#{searchEngineController.showGpaCol}">
					<h:outputLabel for="averageGpa" value="Average GPA : " styleClass="small"/>
					<rich:toolTip for="gpaInfo" showEvent="onclick" value="Average GPA does NOT include reported GPA with a value of 0. GPA is rounded up on the third decimal place."  />
					<h:graphicImage id="gpaInfo" url="/images/person.png" alt="i" styleClass="tooltip"/>
				</h:panelGroup>
				<h:outputText id="averageGpa" value="#{searchEngineController.averageGpa}" rendered="#{searchEngineController.showGpaCol}">
					<f:convertNumber pattern="#0.000" />
				</h:outputText>
			</h:panelGrid>	
			
			<h:commandButton id="ok-button" value="Close" styleClass="buttonStyle">
				<rich:componentControl for="searchOptionsPanel"
				attachTo="hideViewlink2" operation="hide" event="onclick" />
			</h:commandButton>
							
		</h:form>
	</rich:modalPanel>
	
	<!-- Modal Panel for Save Working Set -->
	<a4j:outputPanel layout="none">
		<rich:modalPanel id="saveWSPanel" autosized="true" width="450"
			rendered="#{workingSetController.showSaveWSModalWindow}">
			<f:facet name="header">
				<h:outputText value="Save Working Set As ..." />
			</f:facet>
			<f:facet name="controls">
				<h:panelGroup>
					<h:graphicImage value="/images/icons/cancel.png"
						id="hidesaveWSlink" styleClass="hidelink" alt="X" />
					<rich:componentControl for="saveWSPanel" attachTo="hidesaveWSlink"
						operation="hide" event="onclick" />
				</h:panelGroup>
			</f:facet>
			<h:form>
				<rich:messages style="color:red;"/>
				<h:panelGrid columns="1">
					<h:panelGrid columns="2">
						<h:panelGroup>
							<font class="ws10" color="#062E8A" face="Tahoma">
								<h:outputText value="Name: *" />
							</font>
							<br />
							<h:outputText value="Working Set Name" style="color:gray" />
						</h:panelGroup>

						<h:inputText value="#{workingSetController.name}"
							style="width:200px" required="true"
							requiredMessage="Name: Value is required.">
							<f:validateRegex pattern="[A-Za-z .,]+" />
							<f:validateLength maximum="50" />
						</h:inputText>

						<h:panelGroup>
							<font class="ws10" color="#062E8A" face="Tahoma"> 
								<h:outputText value="Short Description :"/>
							</font>
							<br />
							<h:outputText style="color:gray" 
							value="Short description for the drop-down box. Max 255 characters" />
						</h:panelGroup>
						<h:inputTextarea value="#{workingSetController.description}"
							style="width:200px" rows="2">
							<f:validateLength minimum="0" maximum="255" />
						</h:inputTextarea>
					</h:panelGrid>
					<h:panelGroup>
						<h:selectBooleanCheckbox value="#{workingSetController.saveAndOpenNewWS}"/>
						&nbsp;&nbsp;&nbsp;
						<h:outputText value="Open this working set."/>
					</h:panelGroup>
					<h:panelGroup>
						<h:outputLabel style="color:black;font-weight:bold;" value="Note: "/>
						<h:outputText style="color:blue;" value="Use Working Set menu to add advanced options to this working set."/>
					</h:panelGroup>

					<a4j:commandButton value="Save" reRender="wsid,wsswitchid,ws_name"
						action="#{workingSetController.createWorkingSet}"
						oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('saveWSPanel')}.hide();"/>

				</h:panelGrid>
			</h:form>
		</rich:modalPanel>
	</a4j:outputPanel>	
	
	<!-- Modal Panel for Save Query -->
	<a4j:outputPanel layout="none">
		<rich:modalPanel id="saveQueryPanel" autosized="true" width="450"
			rendered="#{searchEngineController.showSaveQueryModalWindow}">
			<f:facet name="header">
				<h:outputText value="Save Query As ..." />
			</f:facet>
			<f:facet name="controls">
				<h:panelGroup>
					<h:graphicImage value="/images/icons/cancel.png"
						id="hidesaveQuerylink" styleClass="hidelink" alt="X" />
					<rich:componentControl for="saveQueryPanel"
						attachTo="hidesaveQuerylink" operation="hide" event="onclick" />
				</h:panelGroup>
			</f:facet>
			<h:form>
				<rich:messages style="color:red;"></rich:messages>
				<h:panelGrid columns="1">
					<h:panelGrid columns="2">
						<h:panelGroup>
							<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
									value="Name: *" /></font>
							<br />
							<h:outputText value="Query Name" style="color:gray" />
						</h:panelGroup>

						<h:inputText value="#{searchEngineController.queryName}"
							style="width:200px" required="true"
							requiredMessage="Name: Value is required.">
							<f:validateLength maximum="50" />
						</h:inputText>

						<h:panelGroup>
							<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
									value="Short Description :"></h:outputText></font>
							<br />
							<h:outputText
								value="Short description for the drop-down box. Max 255 characters"
								style="color:gray"></h:outputText>
						</h:panelGroup>
						<h:inputTextarea
							value="#{searchEngineController.queryDescription}"
							style="width:200px" rows="2">
							<f:validateLength minimum="0" maximum="255" />
						</h:inputTextarea>
					</h:panelGrid>
					<a4j:commandButton value="Save" reRender="querylistid"
						action="#{searchEngineController.saveSearchQuery}"
						oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('saveQueryPanel')}.hide();"></a4j:commandButton>

				</h:panelGrid>
			</h:form>
		</rich:modalPanel>
	</a4j:outputPanel>
</f:subview>