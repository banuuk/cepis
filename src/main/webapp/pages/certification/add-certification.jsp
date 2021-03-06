<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:subview id="add-certification" >
	<h:form id="fee_view" styleClass="styleish">
		<h:outputLabel for="feesInfo" value="Step 1: Fees  "  styleClass="medium-bold"/>		
		<rich:toolTip for="feesInfo" showEvent="onclick" value="Check to make sure all fees are entered. "  />
		<h:graphicImage id="feesInfo" url="/images/person.png" alt="i" styleClass="tooltip"/>		
		<rich:separator lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>
				
		<rich:toolBar height="25px" width="100%" itemSeparator="line"
			style="margin: 20px auto 0px auto">
			<rich:toolBarGroup>
				<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel">
					<rich:toolTip followMouse="true" direction="top-right"
						showDelay="500">
						<span style="white-space: nowrap"> Edit Selected Fee</span>
					</rich:toolTip>
					<a4j:commandLink id="prepEditFee" reRender="selectedFeeEditPanel"
					 ajaxSingle="true" limitToList="true"
					 action="#{certificationController.prepEditFee}"
					 oncomplete="Richfaces.showModalPanel('selectedFeeEditPanel')">
						<h:graphicImage id="editFeePic" value="/images/edit.gif"
						style="border:0" styleClass="pic" alt="O" />
						<h:outputLabel value="Edit" for="editFeePic"
						style="cursor: pointer; padding: 2px 10px; color: #000000; text-decoration: underline;" />							
					</a4j:commandLink>
				</rich:panel>
			</rich:toolBarGroup>					
			<rich:toolBarGroup>
				<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel">
					<rich:toolTip followMouse="true" direction="top-right" showDelay="500">
						<span style="white-space: nowrap"> Delete Selected Fee </span>
					</rich:toolTip>
					<a4j:commandLink id="deleteFee" reRender="fee_view"
					 ajaxSingle="true" limitToList="true"
					 action="#{certificationController.deleteFee}">
						<h:graphicImage id="deleteFeePic" value="/images/delete.png"
							style="border:0" styleClass="pic" alt="O" />
						<h:outputLabel value="Delete" for="deleteFeePic"
							style="cursor: pointer; padding: 2px 10px; color: #000000; text-decoration: underline;" />							
					</a4j:commandLink>
				</rich:panel>
			</rich:toolBarGroup>										
		</rich:toolBar>
			
		<rich:extendedDataTable id="fees_Table"			
		styleClass="basicTable" selectedClass="selectedRow"
		rowClasses="oddRow,evenRow" 
		width="99.75%" height="100px"
		onRowMouseOver="this.style.backgroundColor='#B3C9E0'"				
		onRowMouseOut="this.style.backgroundColor='#{rowKeyVar}'"
		enableContextMenu="false" var="fee"	
		value="#{certificationController.feeList}"			
		binding="#{certificationController.feeTable}"
		noDataLabel="No Fee Payments Found.">	
			
			<a4j:support event="onRowClick" 
			action="#{certificationController.takeFeeSelection}"/>
			<rich:column id="id_Col" width="8%">
				<f:facet name="header">
					<h:outputText value="Check #" />
				</f:facet>
				<h:panelGroup>
					<h:outputText value="#{fee.feePk.checkNumber}" />
				</h:panelGroup>
			</rich:column>						
			<rich:column id="checkDate_Col" width="8%">
				<f:facet name="header">
					<h:outputText value="Check Date" />
				</f:facet>
				<h:panelGroup>
					<h:outputText value="#{fee.checkDateString}" />
				</h:panelGroup>
			</rich:column>
			<rich:column id="checkType_Col" width="8%">
				<f:facet name="header">
					<h:outputText value="Check Type" />
				</f:facet>
				<h:panelGroup>
					<h:outputText value="#{fee.checkType}" />
				</h:panelGroup>
			</rich:column>
			<rich:column id="feeType_Col" width="8%">
				<f:facet name="header">
					<h:outputText value="Fee Type" />
				</f:facet>
				<h:panelGroup>
					<h:outputText value="#{fee.feeType}" />
				</h:panelGroup>
			</rich:column>
			<rich:column id="amountReceived_Col" width="10%">
				<f:facet name="header">
					<h:outputText value="Amount Received" />
				</f:facet>
				<h:panelGroup>
					<h:outputText value="#{fee.amountReceived}">
						<f:convertNumber type="currency" currencySymbol="$" />
					</h:outputText>
				</h:panelGroup>
			</rich:column>
			<rich:column id="dateReceived_col" width="10%">
				<f:facet name="header">
					<h:outputText value="Date Received" />
				</f:facet>
				<h:panelGroup>
					<h:outputText value="#{fee.feePk.dateReceivedString}" />
				</h:panelGroup>
			</rich:column>	
			<rich:column id="memo_Col" width="58%">
				<f:facet name="header">
					<h:outputText value="Memo" />
				</f:facet>
				<h:panelGroup>
					<h:outputText value="#{fee.memo}" />
				</h:panelGroup>
			</rich:column>							
		</rich:extendedDataTable>		
	</h:form>	
	<h:panelGroup id="fee" layout="block" style="padding-bottom:20px">			
		<h:form id="fee_entry" styleClass="styleish">
			<h:panelGrid columns="2" cellpadding="2" width="100%" styleClass="highlightClass">	
				<h:panelGroup id="fee_col_1" layout="block">		
					<h:panelGrid columns="2" cellpadding="2" width="100%">					
						<h:outputLabel for="feeDateReceived" styleClass="small" value="Date Received : * " />						
						<rich:calendar id="feeDateReceived" value="#{certificationController.feeDateReceived}"
						cellWidth="24px" datePattern="MM/dd/yyyy" enableManualInput="true"
						cellHeight="22px" style="width:200px" required="true"
						requiredMessage="Date Received: Value Is Required.">
						</rich:calendar>						
						<h:outputLabel for="feeCheckDate"  styleClass="small" value="Date On Check : * " />
						<rich:calendar id="feeCheckDate" value="#{certificationController.feeCheckDate}"
						cellWidth="24px" datePattern="MM/dd/yyyy" enableManualInput="true"
						cellHeight="22px" style="width:200px" required="true"
						requiredMessage="Date On Check: Value Is Required.">
						</rich:calendar>						
						<h:outputLabel for="checkType" styleClass="small" value="Check Type : * " />
						<h:selectOneMenu id="checkType" value="#{certificationController.feeCheckType}" required="true" 
						requiredMessage="Check Type: Value is required."  >							
							<f:selectItem itemValue="" itemLabel="-- Select --" />
							<f:selectItem itemValue="Personal" itemLabel="Personal" />
							<f:selectItem itemValue="M-O" itemLabel="M-O" />
							<f:selectItem itemValue="Cashier" itemLabel="Cashier" />
						</h:selectOneMenu>							
						<h:outputLabel for="feeType" styleClass="small" value="Fee Type : * " />
						<h:selectOneMenu id="feeType" value="#{certificationController.feeType}" required="true" 
						requiredMessage="Fee Type: Value is required."  >							
							<f:selectItem itemValue="" itemLabel="-- Select --" />
							<f:selectItem itemValue="TEP" itemLabel="TEP" />
							<f:selectItem itemValue="CERT" itemLabel="CERT" />
							<f:selectItem itemValue="ST" itemLabel="ST" />
						</h:selectOneMenu>							
					</h:panelGrid>
				</h:panelGroup>					
				<h:panelGroup id="letter_col_2" layout="block">			
					<h:panelGrid columns="2" cellpadding="2" width="100%">							
						<h:outputLabel for="checkNumber" styleClass="small" value="Check Number : * " />
						<h:inputText id="checkNumber" value="#{certificationController.feeCheckNumber}"
						required="true" requiredMessage="Check Number: Value Is Required."/>						
						<h:outputLabel for="amountReceived" styleClass="small" value="Amount Received : * " />
						<h:inputText id="amountReceived" value="#{certificationController.feeAmountReceived}"
						required="true" requiredMessage="Amount Received: Value Is Required.">
							<f:convertNumber type="currency" currencySymbol="$" />
						</h:inputText>						
						<h:outputLabel for="feeMemo" styleClass="small" value="Memo : *" />
						<h:inputTextarea id="feeMemo" value="#{certificationController.feeMemo}" rows="3"/>					
					</h:panelGrid>
				</h:panelGroup>	
				<h:panelGroup>
					<h:commandButton id="addFee" value="Add" 
					styleClass="buttonStyle"
					action="#{certificationController.addNewFee}" >		
						<a4j:support reRender="fee_view" limitToList="true" />
					</h:commandButton>								
				</h:panelGroup>	
			</h:panelGrid>
		</h:form>		
	</h:panelGroup>		
	
	<h:outputLabel for="praxisIIInfo" value="Step 2: Praxis II"  styleClass="medium-bold"/>		
	<rich:separator id="praxisIIInfo" lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>

	<h:form id="praxisII_manager_form" styleClass="styleish">		
		<h:panelGroup id="praxisII_list" layout="block" style="padding-bottom:20px;">			
			<rich:extendedDataTable id="praxisII_Table" 
				styleClass="basicTable"
				rowClasses="oddRow,evenRow"
				width="99.75%" height="100px"
				enableContextMenu="false" var="praxisIITestScore" 
				value="#{certificationController.praxisIITestScoreList}"			
				noDataLabel="No Praxis II Scores Found.">	
				<rich:column id="praxisIITestCode_Col" width="9%"
				sortable="true" sortBy="#{praxisIITestScore.praxisIICode}">
					<f:facet name="header">
						<h:outputText value="Test Code" />
					</f:facet>
					<h:panelGroup>
						<h:outputText value="#{praxisIITestScore.praxisIICode}"/>
					</h:panelGroup>
				</rich:column>
				<rich:column id="praxisIITestTitle_Col" width="28%"
				sortable="true" sortBy="#{praxisIITestScore.praxisIITest.title}">
					<f:facet name="header">
						<h:outputText value="Test Title" />
					</f:facet>
					<h:outputText value="#{praxisIITestScore.praxisIITest.title}"/>
				</rich:column>
				<rich:column id="praxisIITestDate_Col" width="9%"
				sortable="true" sortBy="#{praxisIITestScore.testDate}">
					<f:facet name="header">
						<h:outputText value="Test Date" />
					</f:facet>
					<h:outputText value="#{praxisIITestScore.testDate}"/>
				</rich:column>
				<rich:column id="praxisIIScore_Col" width="9%"
				sortable="true" sortBy="#{praxisIITestScore.score}">
					<f:facet name="header">
						<h:outputText value="Score" />
					</f:facet>
					<h:panelGroup>
						<h:outputText value="#{praxisIITestScore.scoreInt}"/>							
					</h:panelGroup>
				</rich:column>		
				<rich:column id="praxisIICutoff_Col" width="9%"
				sortable="true" sortBy="#{praxisIITestScore.praxisIITest.cutoffScore}">
					<f:facet name="header">
						<h:outputText value="Cutoff" />
					</f:facet>
					<h:outputText value="#{praxisIITestScore.praxisIITest.cutoffScore}"/>
				</rich:column>			
				<rich:column id="praxisIIMadeCutoff_Col" width="9%"
				sortable="true" sortBy="#{praxisIITestScore.cutoff}">
					<f:facet name="header">
						<h:outputText value="Made Cutoff" />
					</f:facet>
					<h:outputText value="#{praxisIITestScore.cutoff}"/>
				</rich:column>					
				<rich:column id="praxisIIReceivedDate_Col" width="9%"
				sortable="true" sortBy="#{praxisIITestScore.receivedDate}">
					<f:facet name="header">
						<h:outputText value="Received Date" />
					</f:facet>
					<h:panelGroup>
						<h:outputText value="#{praxisIITestScore.receivedDate}"/>							
					</h:panelGroup>
				</rich:column>
				<rich:column id="praxisIIPrimary_Col" width="9%"
				sortable="true" sortBy="#{praxisIITestScore.primaryString}">
					<f:facet name="header">
						<h:outputText value="Primary" />
					</f:facet>
					<h:outputText value="#{praxisIITestScore.primaryString}"/>
				</rich:column>
				<rich:column id="praxisIILastEdit_Col" width="9%"
				sortable="true" sortBy="#{praxisIITestScore.lastEdit}">
					<f:facet name="header">
						<h:outputText value="Last Edit" />
					</f:facet>
					<h:outputText value="#{praxisIITestScore.lastEdit}"/>
				</rich:column>					
			</rich:extendedDataTable>
		</h:panelGroup>			
	</h:form>
	
	<h:outputLabel for="transcriptInfo" value="Step 3: Check UK Transcript  " styleClass="medium-bold"/>		
	<rich:toolTip for="transcriptInfo" showEvent="onclick" value="Click the bar below labled UK Transcript to expand and view."  />
	<h:graphicImage id="transcriptInfo" url="/images/person.png" alt="i" styleClass="tooltip"/>		
	<rich:separator lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>
	
	<h:panelGroup layout="block" style="padding-bottom: 20px">
		<rich:simpleTogglePanel switchType="ajax" 
		label="UK Transcript" opened="false" width="99.5%" >
			<iframe
				src="${certificationController.myUKTranscriptLink}"
				width="100%" height="500px" title="UK Transcript" >
			</iframe>	
		</rich:simpleTogglePanel>
	</h:panelGroup>	
	
	<h:outputLabel for="addCertInfo" value="Step 4: Add New Certification  " styleClass="medium-bold"/>		
	<rich:toolTip for="addCertInfo" showEvent="onclick" value="If all criteria are ."  />
	<h:graphicImage id="addCertInfo" url="/images/person.png" alt="i" styleClass="tooltip"/>		
	<rich:separator lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>
	
	
	<h:outputText value="#{certificationController.initStatesField}"/>	
	<h:panelGrid columns="2" cellpadding="1" width="100%" styleClass="highlightClass">		
		<h:form id="add_certification_manager" styleClass="styleish">			
			<h:panelGroup id="cert_col_1" layout="block">		
				<h:panelGrid columns="2" cellpadding="2" width="100%">		
					<h:outputLabel for="programProfileList" styleClass="small" value="Program profile : *" />
					<h:selectOneListbox id="programProfileList"
					value="#{certificationController.selectedUserProgramProfile}"
					size="1" converter="#{UserProgramProfileDataConverter}"
					style="width: 400px;" required="true"
					requiredMessage="User program profile: Value is required.">
						<f:selectItem itemLabel="Select One" itemValue="" escape="false"/>
						<f:selectItems value="#{certificationController.userProgramProfileList}"
						var="programprofile" itemLabel="#{programprofile.programDomain} - #{programprofile.program} " />
						<f:validator validatorId="UserProgramProfileDataValidator" />
					</h:selectOneListbox>					
					<h:outputLabel for="rankingListId" styleClass="small" value="Ranking : *" />
					<h:selectOneListbox id="rankingListId"
					value="#{certificationController.selectedRanking}" size="1"
					converter="#{RankingDataConverter}" style="width: 400px;"
					required="true" requiredMessage="Ranking: Value is required.">
						<f:selectItem itemLabel="Select One" itemValue="" />
						<f:selectItems value="#{cepisGlobalComponentConfigurator.formattedRankingList}"/>
						<f:validator validatorId="RankingDataValidator" />
					</h:selectOneListbox>
					<h:outputLabel for="statusListId" styleClass="small" value="Status : *" />
					<h:selectOneListbox id="statusListId"
					size="1" required="true" value="#{certificationController.status}"
					requiredMessage="Status: Value is required.">
						<f:selectItem itemLabel="NOT REQUIRED" itemValue="0" />
						<f:selectItem itemLabel="NOT PRESENT" itemValue="1" />
						<f:selectItem itemLabel="COMPLETE" itemValue="2" />
						<f:selectItem itemLabel="INCOMPLETE" itemValue="3" />
						<f:selectItem itemLabel="NEEDS REVIEW" itemValue="4" />
						<f:selectItem itemLabel="COMPLETE INFORMAL" itemValue="5" />
						<f:selectItem itemLabel="NOT CURRENTLY REVIEWABLE" itemValue="6" />
					</h:selectOneListbox>	
					<h:outputLabel for="validStateListId" styleClass="small" value="Valid in : " />
					<rich:pickList id="validStateListId" sourceListWidth="40px" targetListWidth="40px"
					listsHeight="75px" showButtonsLabel="false" value="#{certificationController.validStates}">						
						<f:selectItems value="#{certificationController.states}" />
					</rich:pickList>
					<h:outputLabel for="idate" styleClass="small" value="Initial Date : " />
					<rich:calendar id="idate"
					value="#{certificationController.initialDate}" cellWidth="24px"
					cellHeight="22px" style="width:200px" firstWeekDay="0"
					datePattern="MM/dd/yyyy" enableManualInput="true">
					</rich:calendar>
					<h:outputLabel for="cdate" styleClass="small" value="Complete Date : " />						
					<rich:calendar id="cdate"
						value="#{certificationController.completeDate}" cellWidth="24px"
						cellHeight="22px" style="width:200px" firstWeekDay="0"
						enableManualInput="true">
					</rich:calendar>	
					<h:outputLabel for="memoId" styleClass="small" value="Memo :" />
					<h:inputTextarea id="memoId" value="#{certificationController.memo}"
					style="width:200px" rows="5"/>
					<h:commandButton id="add_certification_type_button" value="Add" styleClass="buttonStyle"
					action="#{certificationController.addCertificationToUser}"/>					
				</h:panelGrid>
			</h:panelGroup>
		</h:form>
		<h:panelGroup id="cert_col_2" layout="block">		
			<h:panelGrid columns="2" cellpadding="2" width="100%">	
				<rich:tabPanel switchType="ajax" immediate="true">
					<rich:tab label="Email Address">
						<a4j:include viewId="email-address.jsp" />
					</rich:tab>
					<rich:tab label="Phone" onclick="#{certificationController.setUpPhoneTab}">
						<a4j:include viewId="phone.jsp" />
					</rich:tab>
					<rich:tab label="Address" onclick="#{certificationController.setUpAddressTab}">
						<a4j:include viewId="address.jsp" />
					</rich:tab>
				</rich:tabPanel>
			</h:panelGrid>
		</h:panelGroup>
	</h:panelGrid>		
	
	<rich:modalPanel id="selectedFeeEditPanel" height="250" width="450" autosized="true" domElementAttachment="parent">
		<f:facet name="header">
			<h:outputText value="Edit Fee: #{certificationController.selectedFee.feePk.checkNumber}" />
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="/images/icons/cancel.png" id="hideViewlink3"
				styleClass="hidelink" alt="X" />
				<rich:componentControl for="selectedFeeEditPanel"
				attachTo="hideViewlink3" operation="hide" event="onclick" />
			</h:panelGroup>
		</f:facet>
		<h:form id="fee_edit" styleClass="styleish">
			<h:panelGrid columns="2" cellpadding="2" width="100%" >						
				<h:outputLabel for="feeDateReceived"  styleClass="small" value="Date Received : * " />						
				<rich:calendar id="feeDateReceived" value="#{certificationController.selectedFee.feePk.dateReceived}"
				cellWidth="24px"  datePattern="MM/dd/yyyy" enableManualInput="true"
				validatorMessage="Invalid Value For: Date Received"
				cellHeight="22px" style="width:200px" required="true"
				requiredMessage="Date Received: Value Is Required.">
				</rich:calendar>						
				<h:outputLabel for="feeCheckDate"  styleClass="small" value="Date On Check : * " />
				<rich:calendar id="feeCheckDate" value="#{certificationController.selectedFee.checkDate}"
					cellWidth="24px"  datePattern="MM/dd/yyyy" enableManualInput="true"
					cellHeight="22px" style="width:200px" required="true"
					requiredMessage="Date On Check: Value Is Required.">
				</rich:calendar>						
				<h:outputLabel for="checkType"  styleClass="small" value="Check Type : * " />
				<h:selectOneMenu id="checkType" value="#{certificationController.selectedFee.checkType}" 
				required="true" requiredMessage="Check Type: Value is required."  >							
					<f:selectItem itemValue="" itemLabel="-- Select --" />
					<f:selectItem itemValue="Personal" itemLabel="Personal" />
					<f:selectItem itemValue="M-O" itemLabel="M-O" />
					<f:selectItem itemValue="Cashier" itemLabel="Cashier" />
				</h:selectOneMenu>							
				<h:outputLabel for="feeType"  styleClass="small" value="Fee Type : * " />
				<h:selectOneMenu id="feeType" value="#{certificationController.selectedFee.feeType}" 
				required="true" requiredMessage="Fee Type: Value is required."  >							
					<f:selectItem itemValue="" itemLabel="-- Select --" />
					<f:selectItem itemValue="TEP" itemLabel="TEP" />
					<f:selectItem itemValue="CERT" itemLabel="CERT" />
					<f:selectItem itemValue="ST" itemLabel="ST" />
				</h:selectOneMenu>							
				<h:outputLabel for="checkNumber"  styleClass="small" value="Check Number : * " />
				<h:inputText id="checkNumber" value="#{certificationController.selectedFee.feePk.checkNumber}"
				required="true" requiredMessage="Check Number: Value Is Required."/>						
				<h:outputLabel for="amountReceived"  styleClass="small" value="Amount Received : * " />
				<h:inputText id="amountReceived" value="#{certificationController.selectedFee.amountReceived}"
				required="true" requiredMessage="Amount Received: Value Is Required.">
					<f:convertNumber type="currency" currencySymbol="$" />
				</h:inputText>						
				<h:outputLabel for="feeMemo"  styleClass="small" value="Memo : * " />
				<h:inputTextarea id="feeMemo" value="#{certificationController.selectedFee.memo}" rows="3"/>
				<h:commandButton id="editFee" value="Edit Fee" 
				styleClass="buttonStyle" 
				action="#{certificationController.editFee}">		
					<a4j:support reRender="fee_view" limitToList="true" />
				</h:commandButton>
			</h:panelGrid>
		</h:form>
	</rich:modalPanel>
</f:subview>