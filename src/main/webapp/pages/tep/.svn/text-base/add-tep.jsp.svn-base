<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:subview id="add-tep" >
	<h:form id="referenceLetter_view" styleClass="styleish">
		<h:outputLabel for="referenceLettersInfo" value="Step 1: Reference Letters  "  styleClass="medium-bold"/>	
		<rich:toolTip for="referenceLettersInfo" showEvent="onclick" value="A minimum of three reference are letters required."  />
		<h:graphicImage id="referenceLettersInfo" url="/images/person.png" alt="i" styleClass="tooltip"/>
		<rich:separator lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>
		<rich:toolBar height="25px" width="100%" itemSeparator="line" style="margin: 20px auto 0px auto">
			<rich:toolBarGroup>
				<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel">
					<rich:toolTip followMouse="true" direction="top-right"
						showDelay="500">
						<span style="white-space: nowrap"> Edit Selected Reference Letter</span>
					</rich:toolTip>
					<a4j:commandLink id="prepEditReferenceLetter" reRender="selectedReferenceLetterEditPanel" 
					 ajaxSingle="true" limitToList="true" action="#{tepController.prepEditLetter}"
					 oncomplete="Richfaces.showModalPanel('selectedReferenceLetterEditPanel')">
						<h:graphicImage id="editReferenceLetterPic" value="/images/edit.gif"
						style="border:0" styleClass="pic" alt="O" />
						<h:outputLabel value="Edit" for="editReferenceLetterPic"
						style="cursor: pointer; padding: 2px 10px; color: #000000; text-decoration: underline;" />							
					</a4j:commandLink>
				</rich:panel>				
			</rich:toolBarGroup>	
			<rich:toolBarGroup>
				<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel">
					<rich:toolTip followMouse="true" direction="top-right" showDelay="500">
						<span style="white-space: nowrap"> Delete Selected Reference Letter </span>
					</rich:toolTip>	
					<a4j:commandLink id="deleteReferenceLetter" reRender="referenceLetter_view"
					 ajaxSingle="true" limitToList="true" action="#{tepController.deleteLetter}">
						<h:graphicImage id="deleteReferenceLetterPic" value="/images/delete.png"
							style="border:0" styleClass="pic" alt="O" />
						<h:outputLabel value="Delete" for="deleteReferenceLetterPic"
							style="cursor: pointer; padding: 2px 10px; color: #000000; text-decoration: underline;" />							
					</a4j:commandLink>
				</rich:panel>
			</rich:toolBarGroup>										
		</rich:toolBar>
		<rich:extendedDataTable id="referenceLetter_Table" 
		styleClass="basicTable" selectedClass="selectedRow"
		rowClasses="oddRow,evenRow" 
		width="99.75%" height="100px"
		onRowMouseOver="this.style.backgroundColor='#B3C9E0'"				
 		onRowMouseOut="this.style.backgroundColor='#{rowKeyVar}'"
		enableContextMenu="false" var="letter"
		value="#{tepController.letterList}"
		binding="#{tepController.letterTable}"
		noDataLabel="No Reference Letters Found.">	
			<a4j:support event="onRowClick" 
				action="#{tepController.takeReferenceLetterSelection}">
			</a4j:support>	
			<rich:column id="id_Col" width="6%">
				<f:facet name="header">
					<h:outputText value="ID" />
				</f:facet>
				<h:panelGroup>
					<h:outputText value="#{letter.id}" />
				</h:panelGroup>
			</rich:column>						
			<rich:column id="name_Col" width="16%">
				<f:facet name="header">
					<h:outputText value="Name" />
				</f:facet>
				<h:panelGroup>
					<h:outputText value="#{letter.name}" />
				</h:panelGroup>
			</rich:column>
			<rich:column id="organization_Col" width="21%">
				<f:facet name="header">
					<h:outputText value="Organization" />
				</f:facet>
				<h:panelGroup>
					<h:outputText value="#{letter.organization}" />
				</h:panelGroup>
			</rich:column>
			<rich:column id="relation_Col" width="21%">
				<f:facet name="header">
					<h:outputText value="Relation" />
				</f:facet>
				<h:panelGroup>
					<h:outputText value="#{letter.relation}" />
				</h:panelGroup>
			</rich:column>
			<rich:column id="phone_Col" width="12%">
				<f:facet name="header">
					<h:outputText value="Phone" />
				</f:facet>
				<h:panelGroup>
					<h:outputText value="#{letter.phone}" />
				</h:panelGroup>
			</rich:column>		
			<rich:column id="signatureDate_col" width="12%">
				<f:facet name="header">
					<h:outputText value="Signature Date" />
				</f:facet>
				<h:panelGroup>
					<h:outputText value="#{letter.signatureDateString}" />
				</h:panelGroup>
			</rich:column>	
			<rich:column id="dateReceived_Col" width="12%">
				<f:facet name="header">
					<h:outputText value="Date Received" />
				</f:facet>
				<h:panelGroup>
					<h:outputText value="#{letter.dateReceivedString}" />
				</h:panelGroup>
			</rich:column>							
		</rich:extendedDataTable>		
	</h:form>			
	<h:panelGroup id="referenceLetter" layout="block" style="padding-bottom:20px">			
		<h:form id="referenceLetter_entry" styleClass="styleish">
			<h:panelGrid columns="2" cellpadding="2" width="100%" styleClass="highlightClass">	
				<h:panelGroup id="letter_col_1" layout="block">		
					<h:panelGrid columns="2" cellpadding="2" width="100%">
						<h:outputLabel for="letterName" styleClass="small" value="Name : "/>
						<h:inputText id="letterName" value="#{tepController.letterName}"/>	
						<h:outputLabel for="letterSignatureDate" styleClass="small" value="Signature Date : *"/>
						<rich:calendar id="letterSignatureDate" value="#{tepController.letterSignatureDate}"
						cellWidth="24px" datePattern="MM/dd/yyyy" enableManualInput="true"
						cellHeight="22px" style="width:200px" required="true"
						requiredMessage="Signature Date: Value Is Required."/>
						<h:outputLabel for="letterDateReceived" styleClass="small" value="Date Received : *"/>
						<rich:calendar id="letterDateReceived" value="#{tepController.letterDateReceived}"
						cellWidth="24px" datePattern="MM/dd/yyyy" enableManualInput="true"
						cellHeight="22px" style="width:200px" required="true" 
						requiredMessage="Date Received: Value Is Required."/>
					</h:panelGrid>
				</h:panelGroup>				
				<h:panelGroup id="letter_col_2" layout="block">			
					<h:panelGrid columns="2" cellpadding="2" width="100%">					
						<h:outputLabel for="letterOrganization" styleClass="small" value="Organization : "/>
						<h:inputText id="letterOrganization" value="#{tepController.letterOrganization}"/>	
						<h:outputLabel for="letterRelation" styleClass="small" value="Relation : " />
						<h:inputText id="letterRelation" value="#{tepController.letterRelation}"/>
						<h:outputLabel for="letterPhone" styleClass="small"  value="Phone Number : "/>
						<h:inputText id="letterPhone" value="#{tepController.letterPhone}"
						validatorMessage="Phone No: Value is invalid.">
							<f:validateRegex pattern="\((\d{3})\) (\d{3})-(\d{4})" />
						</h:inputText>							
					</h:panelGrid>
				</h:panelGroup>					
				<h:commandButton id="addReferenceLetter" value="Add" 
				style="margin: 0 0 20 0; padding: 2px 2px 2px 2px" 
				action="#{tepController.addNewLetter}" >		
					<a4j:support reRender="referenceLetter_view" limitToList="true" />
				</h:commandButton>									
			</h:panelGrid>
		</h:form>		
	</h:panelGroup>	
	<h:form id="fee_view" styleClass="styleish">
		<h:outputLabel for="feesInfo" value="Step 2: Fees  "  styleClass="medium-bold"/>		
		<rich:toolTip for="feesInfo" showEvent="onclick" value="Check to make sure all fees are entered."  />
		<h:graphicImage id="feesInfo" url="/images/person.png" alt="i" styleClass="tooltip"/>
		<rich:separator lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>
		<rich:toolBar height="25px" width="100%" itemSeparator="line" style="margin: 20px auto 0px auto">
			<rich:toolBarGroup>
				<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel">
					<rich:toolTip followMouse="true" direction="top-right"
						showDelay="500">
						<span style="white-space: nowrap"> Edit Selected Fee </span>
					</rich:toolTip>					
					<a4j:commandLink id="prepEditFee" reRender="selectedFeeEditPanel" 
					 ajaxSingle="true" limitToList="true" action="#{tepController.prepEditFee}"
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
					 ajaxSingle="true" limitToList="true" action="#{tepController.deleteFee}">
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
		value="#{tepController.feeList}"			
		binding="#{tepController.feeTable}"
		noDataLabel="No Fees / Payments Found.">	
			<a4j:support event="onRowClick" 
				action="#{tepController.takeFeeSelection}">
			</a4j:support>	
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
						<h:outputLabel for="feeDateReceived" styleClass="small" value="Date Received : *" />						
						<rich:calendar id="feeDateReceived" value="#{tepController.feeDateReceived}"
						cellWidth="24px" datePattern="MM/dd/yyyy" enableManualInput="true"
						cellHeight="22px" style="width:200px" required="true"
						requiredMessage="Date Received: Value Is Required."/>			
						<h:outputLabel for="feeCheckDate"  styleClass="small" value="Date On Check : *" />
						<rich:calendar id="feeCheckDate" value="#{tepController.feeCheckDate}"
						cellWidth="24px" datePattern="MM/dd/yyyy" enableManualInput="true"
						cellHeight="22px" style="width:200px" required="true"
						requiredMessage="Date On Check: Value Is Required."/>
						<h:outputLabel for="checkType" styleClass="small" value="Check Type : *" />
						<h:selectOneMenu id="checkType" value="#{tepController.feeCheckType}" required="true" 
							requiredMessage="Check Type: Value is required."  >							
							<f:selectItem itemValue="" itemLabel="-- Select --" />
							<f:selectItem itemValue="Personal" itemLabel="Personal" />
							<f:selectItem itemValue="M-O" itemLabel="M-O" />
							<f:selectItem itemValue="Cashier" itemLabel="Cashier" />
						</h:selectOneMenu>							
						<h:outputLabel for="feeType" styleClass="small" value="Fee Type : *" />
						<h:selectOneMenu id="feeType" value="#{tepController.feeType}" required="true" 
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
						<h:outputLabel for="checkNumber" styleClass="small" value="Check Number : *" />
						<h:inputText id="checkNumber" value="#{tepController.feeCheckNumber}"
						required="true" requiredMessage="Check Number: Value Is Required."/>						
						<h:outputLabel for="amountReceived" styleClass="small" value="Amount Received : *" />
						<h:inputText id="amountReceived" value="#{tepController.feeAmountReceived}"
						required="true" requiredMessage="Amount Received: Value Is Required.">
							<f:convertNumber type="currency" currencySymbol="$" />
						</h:inputText>						
						<h:outputLabel for="feeMemo" styleClass="small" value="Memo : *" />
						<h:inputTextarea id="feeMemo" value="#{tepController.feeMemo}" rows="3"/>					
					</h:panelGrid>
				</h:panelGroup>					
				<h:commandButton id="addFee" styleClass="buttonStyle" value="Add"
				 action="#{tepController.addNewFee}" >		
					<a4j:support reRender="fee_view" limitToList="true" />
				</h:commandButton>
			</h:panelGrid>
		</h:form>		
	</h:panelGroup>			
	<h:form id="characterAndFitness_View" styleClass="styleish">
		<h:outputLabel for="characterAndFitnessInfo" value="Step 3: Character And Fitness  "  styleClass="medium-bold"/>		
		<rich:toolTip for="characterAndFitnessInfo" showEvent="onclick" value="Student must have character and fitness submitted."  />
		<h:graphicImage id="characterAndFitnessInfo" url="/images/person.png" alt="i" styleClass="tooltip"/>	
		<rich:separator lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>	
		<rich:toolBar height="25px" width="100%" itemSeparator="line" style="margin: 20px auto 0px auto">
			<rich:toolBarGroup>
				<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel">
					<rich:toolTip followMouse="true" direction="top-right" showDelay="500">
						<span style="white-space: nowrap"> Edit Selected Character And Fitness </span>
					</rich:toolTip>		
					<a4j:commandLink id="prepEditCharacterAndFitness" reRender="selectedCharacterAndFitnessEditPanel" 
					 ajaxSingle="true" limitToList="true" action="#{tepController.prepEditCharacterAndFitness}"
					 oncomplete="Richfaces.showModalPanel('selectedCharacterAndFitnessEditPanel')" >
						<h:graphicImage id="editCharacterAndFitnessPic" value="/images/edit.gif"
						style="border:0" styleClass="pic" alt="O" />
						<h:outputLabel value="Edit" for="editCharacterAndFitnessPic"
						style="cursor: pointer; padding: 2px 10px; color: #000000; text-decoration: underline;" />							
					</a4j:commandLink>
				</rich:panel>				
			</rich:toolBarGroup>	
			<rich:toolBarGroup>
				<rich:panel bodyClass="toolBox" styleClass="toolBoxPanel">
					<rich:toolTip followMouse="true" direction="top-right" showDelay="500">
						<span style="white-space: nowrap"> Delete Selected Character And Fitness </span>
					</rich:toolTip>
					<a4j:commandLink id="deleteCharacterAndFitness" reRender="characterAndFitness_Table"
					 ajaxSingle="true" limitToList="true" action="#{tepController.deleteCharacterAndFitness}">
						<h:graphicImage id="deleteCharacterAndFitnessPic" value="/images/delete.png"
						style="border:0" styleClass="pic" alt="O" />
						<h:outputLabel value="Delete" for="deleteCharacterAndFitnessPic"
						style="cursor: pointer; padding: 2px 10px; color: #000000; text-decoration: underline;" />							
					</a4j:commandLink>
				</rich:panel>
			</rich:toolBarGroup>										
		</rich:toolBar>
		<rich:extendedDataTable id="characterAndFitness_Table" 
		styleClass="basicTable" selectedClass="selectedRow"
		rowClasses="oddRow,evenRow" 
		width="99.75%" height="100px"
		onRowMouseOver="this.style.backgroundColor='#B3C9E0'"				
 		onRowMouseOut="this.style.backgroundColor='#{rowKeyVar}'"
		enableContextMenu="false" var="characterAndFitness"			
		binding="#{tepController.characterAndFitnessTable}"
		value="#{tepController.characterAndFitnessList}"
		noDataLabel="No Character And Fitness Records Found.">	
			<a4j:support event="onRowClick" 
				action="#{tepController.takeCharacterAndfitnessSelection}">
			</a4j:support>
			<rich:column id="id_Col" width="5%">
				<f:facet name="header">
					<h:outputText value="ID" />
				</f:facet>
				<h:panelGroup>
					<h:outputText value="#{characterAndFitness.id}" />
				</h:panelGroup>
			</rich:column>
			<rich:column id="characterAndFitnessSignatureDate_Col" width="10%">
				<f:facet name="header">
					<h:outputText value="Signature Date" />
				</f:facet>
				<h:panelGroup>
					<h:outputText value="#{characterAndFitness.signatureDate}" />
				</h:panelGroup>
			</rich:column>		
			<rich:column id="characterAndFitnessDateReceived_Col" width="10%">
				<f:facet name="header">
					<h:outputText value="Date Received" />
				</f:facet>
				<h:panelGroup>
					<h:outputText value="#{characterAndFitness.dateReceived}" />
				</h:panelGroup>
			</rich:column>		
			<rich:column id="characterAndFitnessMemo_Col" width="75%">
				<f:facet name="header">
					<h:outputText value="Memo" />
				</f:facet>
				<h:panelGroup>
					<h:outputText value="#{characterAndFitness.memo}" />
				</h:panelGroup>
			</rich:column>
		</rich:extendedDataTable>	
	</h:form>
	<h:panelGroup id="characterAndFitness" layout="block" style="padding-bottom:20px">			
		<h:form id="characterAndFitness_entry" styleClass="styleish">
			<h:panelGrid columns="2" cellpadding="2" width="100%" styleClass="highlightClass">	
				<h:panelGroup id="characterAndFitness_col_1" layout="block">		
					<h:panelGrid columns="2" cellpadding="2" width="100%" >						
						<h:outputLabel for="characterAndFitnessSignatureDate" styleClass="small" value="Signature Date : *" />
						<rich:calendar id="characterAndFitnessSignatureDate" value="#{tepController.characterAndFitnessSignatureDate}"
						cellWidth="24px" datePattern="MM/dd/yyyy" enableManualInput="true"
						cellHeight="22px" style="width:200px" required="true"
						requiredMessage="Signature Date: Value Is Required."/>
						<h:outputLabel for="characterAndFitnessDateReceived" styleClass="small" value="Date Received : *" />
						<rich:calendar id="characterAndFitnessDateReceived" value="#{tepController.characterAndFitnessDateReceived}"
						cellWidth="24px" datePattern="MMM d,yyyy" enableManualInput="true"
						cellHeight="22px" style="width:200px" required="true"
						requiredMessage="Date Received: Value Is Required."/>
					</h:panelGrid>
				</h:panelGroup>
				<h:panelGroup id="characterAndFitness_col_2" layout="block">
					<h:panelGrid columns="2" cellpadding="2" width="100%" >
						<h:outputLabel for="characterAndFitnessMemo" styleClass="small" value="Memo : " />
						<h:inputTextarea id="characterAndFitnessMemo" value="#{tepController.characterAndFitnessMemo}"
						rows="4" cols="50"/>	
					</h:panelGrid>
				</h:panelGroup>				
				<h:commandButton id="addCharacterAndFitness" styleClass="buttonStyle" value="Add" 
				action="#{tepController.addNewCharacterAndFitness}">				
					<a4j:support reRender="characterAndFitness_View" limitToList="true" /> 				
				</h:commandButton> 	
			</h:panelGrid>			
		</h:form>		
	</h:panelGroup>		
	<h:outputLabel for="testInfo" value="Step 4: Test Scores"  styleClass="medium-bold"/>
	<h:outputLabel for="testInfo" value="(select one)  "  styleClass="tiny"/>		
	<rich:toolTip for="testInfo" showEvent="onclick" 
	value="Select appropriate test score from the list. This will populate Test Type and Test ID fields for TEP Admission"  />
	<h:graphicImage id="testInfo" url="/images/person.png" alt="i" styleClass="tooltip"/>
	<rich:separator lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>	
	<rich:tabPanel switchType="ajax" immediate="true" style="padding-bottom:20px">
		<rich:tab label="PraxisI">
			<a4j:include viewId="praxisI.jsp" />
		</rich:tab>
		<rich:tab label="PraxisII" onclick="#{tepController.setUpPraxisIITab}">
			<a4j:include viewId="praxisII.jsp" />
		</rich:tab>
		<rich:tab label="GRE" onclick="#{tepController.setUpGreTab}">
			<a4j:include viewId="gre.jsp" />
		</rich:tab>
	</rich:tabPanel>
	<h:outputLabel for="tepAdmissionInfo" value="Step 5: TEP Admission  "  styleClass="medium-bold"/>
	<rich:toolTip for="tepAdmissionInfo" showEvent="onclick" value="Will be submitted with TEP Application."  />
	<h:graphicImage id="tepAdmissionInfo" url="/images/person.png" alt="i" styleClass="tooltip"/>
	<rich:separator lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>
	<h:form id="tep_entry" styleClass="styleish">
		<h:panelGroup id="tepAdmission" layout="block" style="padding-bottom:20px">
			<h:panelGrid columns="2" cellpadding="5" styleClass="highlightClass" width="100%" >	
				<h:panelGroup id="tepAdmission_col_1" layout="block">
					<h:panelGrid columns="2" cellpadding="5" width="95%">
						<h:outputLabel for="admissionDate" styleClass="small" value="Admission Date : " />
						<rich:calendar id="admissionDate" value="#{tepController.admissionDate}"
						cellWidth="24px" datePattern="MM/dd/yyyy" enableManualInput="true"
						cellHeight="22px" style="width:200px"/>
						
						<h:outputLabel for="primary" styleClass="small" rendered="#{tepController.manualPrimary}" value="Primary : *"/>
						<h:selectOneMenu id="primary" value="#{tepController.primary}" rendered="#{tepController.manualPrimary}"
						required="true"	requiredMessage="Primary : Value is required.">
							<f:selectItem itemValue="" itemLabel="-- Select --" />
							<f:selectItem itemValue="No" itemLabel="No" />
							<f:selectItem itemValue="Yes" itemLabel="Yes" />
						</h:selectOneMenu>	
						
						<h:outputLabel for="testType" styleClass="small" value="Test Type : *" />
						<h:inputText id="testType" value="#{tepController.testType}" disabled="true"
						required="true" requiredMessage="Test Type Required: PLEASE SELECT A TEST SCORE."/>
						<h:outputLabel for="testId" styleClass="small" value="Test ID : *" />
						<h:inputText id="testId" value="#{tepController.testId}" disabled="true"
						required="true" requiredMessage="Test ID Required: PLEASE SELECT A TEST SCORE."/>
						<h:outputLabel for="overallGPA" styleClass="small" value="Overall GPA : *" />
						<h:inputText id="overallGPA" value="#{tepController.overallGpa}"
						required="true" requiredMessage="Overall GPA: Value Is Required."/>
						<h:outputLabel for="totalHours" styleClass="small" value="Total Hours : *" />
						<h:inputText id="totalHours" value="#{tepController.totalHours}"
						required="true" requiredMessage="Total Hours: Value Is Required."/>
						<h:outputLabel for="admissionMemo" styleClass="small" value="Admission Memo : " />
						<h:inputTextarea id="admissionMemo" value="#{tepController.tepAdmissionMemo}"/>
					</h:panelGrid>					
				</h:panelGroup>		
				<h:panelGroup id="tepAdmission_col_2" layout="block">
					<h:panelGrid columns="2" cellpadding="5" width="95%">
						<h:outputLabel for="characterAndFitnessId" styleClass="small" value="Character And Fitness ID : *" />
						<h:inputText id="characterAndFitnessId" value="#{tepController.characterAndFitnessId}" 
						required="true" requiredMessage="Character And Fitness ID: Value Is Required"/>
						<h:outputLabel for="reportYear" styleClass="small" value="Report Year Code : *" />												
						<h:selectOneMenu id="reportYear" styleClass="smallInput"
						value="#{tepController.selectedReportYear}"
						converter="#{ReportYearDataConverter}" required="true"	
						requiredMessage="Report Year Code: Value is required.">
							<f:selectItem itemValue="" itemLabel="-- Select --" />
							<f:selectItems var="reportYear"
							value="#{tepController.reportYearList}"
							itemValue="#{reportYear}"
							itemLabel="#{reportYear.reportYearCode}  |  #{reportYear.description}" />
						</h:selectOneMenu>
						<h:outputLabel for="cohortTerm" styleClass="small" value="Term / Cohort : *" />
						<h:selectOneMenu id="cohortTerm" styleClass="smallInput"
						value="#{tepController.selectedCohortTerm}"
						converter="#{UKTermDataConverter}"	
						required="true" requiredMessage="Cohort / Term: Value is required.">
							<f:selectItem itemValue="" itemLabel="-- Select --" />
							<f:selectItems var="cohortTerm"
							value="#{cepisGlobalComponentConfigurator.ukTermList}"
							itemValue="#{cohortTerm}"
							itemLabel="#{cohortTerm.ukTermCode}  |  #{cohortTerm.shortDesc}" />
						</h:selectOneMenu>
						<h:outputLabel for="applicationLevel" styleClass="small" value="Application Level : *" />
						<h:selectOneMenu id="applicationLevel" styleClass="smallInput"
						value="#{tepController.selectedApplicationLevel}" 
						required="true" requiredMessage="Application Level: Value is required."  >							
							<f:selectItem itemValue="" itemLabel="-- Select --" />
							<f:selectItem itemValue="Graduate" itemLabel="Graduate" />
							<f:selectItem itemValue="Undergraduate" itemLabel="Undergraduate" />
							<f:selectItem itemValue="Certification Only" itemLabel="Certification Only" />
						</h:selectOneMenu>	
						<h:outputLabel for="programProfile" styleClass="small" value="Program Profile : *" />
						<h:selectOneMenu id="programProfile" styleClass="smallInput"
						value="#{tepController.selectedProgramProfile}"
						converter="#{UserProgramProfileDataConverter}"	
						required="true" requiredMessage="Program Profile: Value is required.">
							<f:selectItem itemValue="" itemLabel="-- Select --" />
							<f:selectItems var="programProfile"
							value="#{tepController.programProfileList}"
							itemValue="#{programProfile}"
							itemLabel="#{programProfile.program}" />
						</h:selectOneMenu>					
						<h:outputLabel for="admissionStatus" styleClass="small" value="Admission Status : *" />
						<h:selectOneMenu id="admissionStatus" styleClass="smallInput"
						value="#{tepController.selectedAdmissionStatus}">
							<f:selectItem itemValue="" itemLabel="-- Select --" />
							<f:selectItem itemValue="APPLY" itemLabel="Applied | Applied for TEP" />
							<f:selectItem itemValue="ADMIT" itemLabel="Admit | Admitted into TEP" />
							<f:selectItem itemValue="DENIED" itemLabel="Denied | Denied admission into TEP" />
							<f:selectItem itemValue="WDRWN" itemLabel="Withdrawn | Application Withdrawn" />	
						</h:selectOneMenu>
						<h:outputLabel for="portfolioReview" styleClass="small" value="Portfolio Review : " />
						<h:selectOneMenu id="portfolioReview" styleClass="smallInput"
						value="#{tepController.portfolioReview}">
							<f:selectItem itemValue="" itemLabel="-- Select --" />
							<f:selectItem itemValue="COMPLETE" itemLabel="Complete" />	
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGroup>
			</h:panelGrid>
		</h:panelGroup>
		<h:outputLabel for="tepApplicationInfo" value="Step 6: TEP Application  "  styleClass="medium-bold"/>
		<rich:toolTip for="tepApplicationInfo" showEvent="onclick" value="Will be submitted with TEP Admission."  />
		<h:graphicImage id="tepApplicationInfo" url="/images/person.png" alt="i" styleClass="tooltip"/>
		<rich:separator lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>
		<h:panelGrid columns="2" cellpadding="5" width="100%" styleClass="highlightClass">
			<h:panelGroup id="tepApplication_col_1" layout="block">
				<h:panelGrid columns="2" cellpadding="5" width="100%">
					<h:outputLabel for="applicationDate" styleClass="small" value="Application Date : *" />
					<rich:calendar id="applicationDate" value="#{tepController.applicationDate}"
					cellWidth="24px" datePattern="MMM d,yyyy" enableManualInput="true"
					cellHeight="22px" style="width:200px" required="true"
					requiredMessage="Application Date: Value is required."/>		
					<h:outputLabel for="facultyRecommendation" styleClass="small" value="Faculty Recommendation : *" />
					<h:selectOneMenu id="facultyRecommendation"
						value="#{tepController.selectedFacultyRecommendationCode}"
						converter="#{ApplicationStatusDataConverter}"	
						required="true" requiredMessage="Faculty Recommendation: Value is required.">
						<f:selectItem itemValue="" itemLabel="-- Select --" />
						<f:selectItems
							value="#{tepController.applicationStatusList}"
							var="facultyRecommendationCode" itemValue="#{facultyRecommendationCode}"
							itemLabel="#{facultyRecommendationCode.applicationStatusCode} | 
							#{facultyRecommendationCode.applicationStatusDescription}" />
					</h:selectOneMenu>					
					<h:outputLabel for="facultyRecommendationDate" styleClass="small" value="Faculty Recommendation Date : " />
					<rich:calendar id="facultyRecommendationDate" value="#{tepController.facultyRecommendationDate}"
						cellWidth="24px" datePattern="MM/dd/yyyy" enableManualInput="true"
						cellHeight="22px" style="width:200px">
					</rich:calendar>											
					<h:outputLabel for="applicationStatus" styleClass="small" value="Application Status : *" />
					<h:selectOneMenu id="applicationStatus"
					value="#{tepController.selectedApplicationStatus}"
					converter="#{ApplicationStatusDataConverter}"	
					required="true" requiredMessage="Application Status: Value is required.">
						<f:selectItem itemValue="" itemLabel="-- Select --" />
						<f:selectItems var="applicationStatus"
						value="#{tepController.applicationStatusList}"
						itemValue="#{applicationStatus}"
						itemLabel="#{applicationStatus.applicationStatusCode} | 
						#{applicationStatus.applicationStatusDescription}" />
					</h:selectOneMenu>
					
					<h:outputLabel for="followUpDate" styleClass="small" value="Follow Up Date : " />
					<rich:calendar id="followUpDate" value="#{tepController.followUpDate}"
					cellWidth="24px" datePattern="MMM d,yyyy" enableManualInput="true"
					cellHeight="22px" style="width:200px">
					</rich:calendar>
					
					<h:outputLabel for="changeStatusDate" styleClass="small" value="Change Status Date : " />
					<rich:calendar id="changeStatusDate" value="#{tepController.changeStatusDate}"
					cellWidth="24px" datePattern="MMM d,yyyy" enableManualInput="true"
					cellHeight="22px" style="width:200px">
					</rich:calendar>
				</h:panelGrid>
			</h:panelGroup>
			<h:panelGroup id="tepApplication_col_2" layout="block">
				<h:panelGrid columns="2" cellpadding="5" width="100%">	
					<h:outputLabel for="processMemo" styleClass="small" value="Process Memo : " />
					<h:inputTextarea id="processMemo" value="#{tepController.processMemo}" cols="50" rows="3"/>
					<h:outputLabel for="facultyMemo" styleClass="small" value="Faculty Memo : " />
					<h:inputTextarea id="facultyMemo" value="#{tepController.facultyMemo}" cols="50" rows="3"/>
					<h:outputLabel for="studentMemo" styleClass="small" value="Student Memo : " />
					<h:inputTextarea id="studentMemo" value="#{tepController.studentMemo}" cols="50" rows="3"/>
				</h:panelGrid>
			</h:panelGroup>
		</h:panelGrid>		
				
		
		<h:commandButton id="submit" styleClass="buttonStyle" value="Submit" 
		action="#{tepController.addNewTepAdmissionAndApplication}">
			<a4j:support reRender="tep_manager" limitToList="true"  /> 
		</h:commandButton> 	
	</h:form>	
	<rich:modalPanel id="selectedReferenceLetterEditPanel" height="350" width="450" autosized="true" domElementAttachment="parent">
		<f:facet name="header">
			<h:outputText value="Edit Reference Letter:  #{tepController.selectedLetter.id}" />
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="/images/icons/cancel.png" id="hideViewlink1"
				styleClass="hidelink" alt="X" />
				<rich:componentControl for="selectedReferenceLetterEditPanel"
				attachTo="hideViewlink1" operation="hide" event="onclick" />
			</h:panelGroup>
		</f:facet>
		<h:form id="referenceLetter_edit" styleClass="styleish">
			<h:panelGrid columns="2" cellpadding="2" width="100%">
				<h:outputLabel for="letterName" styleClass="small" value="Name : " />
				<h:inputText id="letterName" value="#{tepController.selectedLetter.name}"/>	
				<h:outputLabel for="letterSignatureDate" styleClass="small" value="Signature Date : *" />
				<rich:calendar id="letterSignatureDate" value="#{tepController.selectedLetter.signatureDate}"
					cellWidth="24px" datePattern="MM/dd/yyyy" enableManualInput="true"
					cellHeight="22px" style="width:200px" required="true" requiredMessage="Signature Date: Value is required.">
				</rich:calendar>
				<h:outputLabel for="letterDateReceived" styleClass="small" value="Date Received : *" />
				<rich:calendar id="letterDateReceived" value="#{tepController.selectedLetter.dateReceived}"
				cellWidth="24px" datePattern="MM/dd/yyyy" enableManualInput="true"
				cellHeight="22px" style="width:200px" required="true" requiredMessage="Date Received: Value is required."/>		
				<h:outputLabel for="letterOrganization" styleClass="small" value="Organization : *" />
				<h:inputText id="letterOrganization" value="#{tepController.selectedLetter.organization}"
				required="true" requiredMessage="Organization: Value is required." />
				<h:outputLabel for="letterRelation" styleClass="small" value="Relation : *" />
				<h:inputText id="letterRelation" value="#{tepController.selectedLetter.relation}"
				required="true" requiredMessage="Relation: Value is required." />	
				<h:outputLabel for="letterPhone" styleClass="small" value="Phone Number : *" />
				<h:inputText id="letterPhone" value="#{tepController.selectedLetter.phone}"
				required="true" requiredMessage="Phone Number: Value is required." />	
				<h:commandButton id="editReferenceLetter" value="Edit Letter" 
				style="display: inline; margin: 0 0 10 0; padding: 2px 2px 2px 2px" 
				action="#{tepController.editLetter}">		
					<a4j:support reRender="referenceLetter_view" limitToList="true" />
				</h:commandButton>
			</h:panelGrid>
		</h:form>
	</rich:modalPanel>	
	<rich:modalPanel id="selectedCharacterAndFitnessEditPanel" height="250" width="450" autosized="true" domElementAttachment="parent">
		<f:facet name="header">
			<h:outputText value="Edit Character And Fitness: #{tepController.selectedCharacterAndFitness.id}" />
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="/images/icons/cancel.png" id="hideViewlink2"
				styleClass="hidelink" alt="X" />
				<rich:componentControl for="selectedCharacterAndFitnessEditPanel"
				attachTo="hideViewlink2" operation="hide" event="onclick" />
			</h:panelGroup>
		</f:facet>
		<h:form id="characterAndFitness_edit" styleClass="styleish">
			<h:panelGrid columns="2" cellpadding="2" width="100%" >						
				<h:outputLabel for="characterAndFitnessSignatureDate" styleClass="small" value="Signature Date : " />
				<rich:calendar id="characterAndFitnessSignatureDate" value="#{tepController.selectedCharacterAndFitness.signatureDate}"
				cellWidth="24px" datePattern="MM/dd/yyyy" enableManualInput="true"
				cellHeight="22px" style="width:200px" required="true" requiredMessage="Signature Date: Value is required.">
				</rich:calendar>				
				<h:outputLabel for="characterAndFitnessDateReceived" styleClass="small" value="Date Received : " />
				<rich:calendar id="characterAndFitnessDateReceived" value="#{tepController.selectedCharacterAndFitness.dateReceived}"
				cellWidth="24px" datePattern="MM/dd/yyyy" enableManualInput="true"
				cellHeight="22px" style="width:200px" required="true" requiredMessage="Date Received: Value is required.">
				</rich:calendar>				
				<h:outputLabel for="characterAndFitnessMemo" styleClass="small" value="Memo : " />
				<h:inputTextarea id="characterAndFitnessMemo" value="#{tepController.selectedCharacterAndFitness.memo}"
				rows="4" cols="30"/>					
				<h:commandButton id="editCharacterAndFitness" styleClass="buttonStyle" 
				value="Edit Character And Fitness" 		
				action="#{tepController.editCharacterAndFitness}">		
					<a4j:support reRender="characterAndFitness_View" limitToList="true" />
				</h:commandButton>
			</h:panelGrid>
		</h:form>
	</rich:modalPanel>	
	<rich:modalPanel id="selectedFeeEditPanel" height="250" width="450" autosized="true" domElementAttachment="parent">
		<f:facet name="header">
			<h:outputText value="Edit Fee: #{tepController.selectedFee.feePk.checkNumber}" />
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
				<h:outputLabel for="feeDateReceived"  styleClass="small" value="Date Received : *" />						
				<rich:calendar id="feeDateReceived" value="#{tepController.selectedFee.feePk.dateReceived}"
				cellWidth="24px" datePattern="MMM d,yyyy" enableManualInput="true"
				cellHeight="22px" style="width:200px" required="true"
				requiredMessage="Date Received: Value Is Required.">
				</rich:calendar>						
				<h:outputLabel for="feeCheckDate"  styleClass="small" value="Date On Check : *" />
				<rich:calendar id="feeCheckDate" value="#{tepController.selectedFee.checkDate}"
				cellWidth="24px" datePattern="MMM d,yyyy" enableManualInput="true"
				cellHeight="22px" style="width:200px" required="true"
				requiredMessage="Date On Check: Value Is Required.">
				</rich:calendar>						
				<h:outputLabel for="checkType"  styleClass="small" value="Check Type : *" />
				<h:selectOneMenu id="checkType" value="#{tepController.selectedFee.checkType}" 
				required="true" requiredMessage="Check Type: Value is required."  >							
					<f:selectItem itemValue="" itemLabel="-- Select --" />
					<f:selectItem itemValue="Personal" itemLabel="Personal" />
					<f:selectItem itemValue="M-O" itemLabel="M-O" />
					<f:selectItem itemValue="Cashier" itemLabel="Cashier" />
				</h:selectOneMenu>							
				<h:outputLabel for="feeType"  styleClass="small" value="Fee Type : *" />
				<h:selectOneMenu id="feeType" value="#{tepController.selectedFee.feeType}" 
				required="true" requiredMessage="Fee Type: Value is required."  >							
					<f:selectItem itemValue="" itemLabel="-- Select --" />
					<f:selectItem itemValue="TEP" itemLabel="TEP" />
					<f:selectItem itemValue="CERT" itemLabel="CERT" />
					<f:selectItem itemValue="ST" itemLabel="ST" />
				</h:selectOneMenu>							
				<h:outputLabel for="checkNumber"  styleClass="small" value="Check Number : *" />
				<h:inputText id="checkNumber" value="#{tepController.selectedFee.feePk.checkNumber}"
				required="true" requiredMessage="Check Number: Value Is Required."/>						
				<h:outputLabel for="amountReceived"  styleClass="small" value="Amount Received *: " />
				<h:inputText id="amountReceived" value="#{tepController.selectedFee.amountReceived}"
				required="true" requiredMessage="Amount Received: Value Is Required.">
					<f:convertNumber type="currency" currencySymbol="$" />
				</h:inputText>						
				<h:outputLabel for="feeMemo"  styleClass="small" value="Memo : *" />
				<h:inputTextarea id="feeMemo" value="#{tepController.selectedFee.memo}" rows="3"/>				
				<h:commandButton id="editFee" styleClass="buttonStyle" value="Edit Fee" 
				action="#{tepController.editFee}">		
					<a4j:support reRender="fee_view" limitToList="true" />
				</h:commandButton>
			</h:panelGrid>			
		</h:form>
	</rich:modalPanel>
</f:subview>

<!-- ******************************PHONE NUMBER JQUERY AUTO FILL****************************** -->
<script type="text/javascript"
	src="${facesContext.externalContext.requestContextPath}/js/account.js"></script>			
<script type="text/javascript"
	src="${facesContext.externalContext.requestContextPath}/js/jquery.maskedinput-1.2.2.js"></script>
<script type="text/javascript">
	jQuery("input[id$=letterPhone]").mask("(999) 999-9999");
</script>
<!-- ****************************************************************************************** -->