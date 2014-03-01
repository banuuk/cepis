<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>


<f:subview id="edit-certification">
	<h:form id="edit_certification_manager" styleClass="styleish">
		<br />
		<h:outputLabel for="lineSeparator" value="Edit Certification "  styleClass="medium-bold"/>
		<rich:separator id="lineSeparator" lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>		
		<br />
		<h:panelGrid columns="2" style="padding-right: 100px; padding-left: 100px">
		
			<h:outputLabel for="certificationListid" styleClass="small" value="Certification Information : " />
			<h:selectOneListbox id="certificationListid" styleClass="largeInput"
			value="#{certificationController.selectedCertification}"
			converter="#{CertificationDataConverter}"
			required="true" immediate="true"
			requiredMessage="Certification Information: Value is required."
			converterMessage="convert error" validatorMessage="invalid" size="1">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems value="#{certificationController.certificationList}"
				var="certification"
				itemLabel="#{certification.programProfile.programDomain} - #{certification.programProfile.program} : #{certification.ranking.title}" />
				<f:validator validatorId="CertificationDataValidator" />
				<a4j:support event="onchange" ajaxSingle="true" limitToList="true"
				actionListener="#{certificationController.valueChangeEditCertification}"
				reRender="programProfileList,rankingList,status,valid_state,idate,cdate,memo" />
			</h:selectOneListbox>
		
			<h:outputLabel for="programProfileList" styleClass="small" value="Select Program Profile : " />			
			<h:panelGroup id="programProfileList">
				<h:selectOneListbox size="1" styleClass="largeInput"
				value="#{certificationController.selectedUserProgramProfile}"
				converter="#{UserProgramProfileDataConverter}"
				required="true"	requiredMessage="User program profile: Value is required.">
					<f:selectItem itemLabel="Select One" itemValue="NA" />
					<f:selectItems value="#{certificationController.userProgramProfileList}"
					var="programprofile"
					itemLabel="#{programprofile.programDomain} - #{programprofile.program}" />
					<f:validator validatorId="UserProgramProfileDataValidator" />
				</h:selectOneListbox>
			</h:panelGroup>

			<h:outputLabel for="rankingList" styleClass="small" value="Select Ranking : " />			
			<h:selectOneListbox id="rankingList" size="1" styleClass="largeInput"
			value="#{certificationController.selectedRanking}"
			converter="#{RankingDataConverter}"
			required="true" requiredMessage="Ranking: Value is required.">
				<f:selectItem itemLabel="Select One" itemValue="NA" />
				<f:selectItems value="#{cepisGlobalComponentConfigurator.rankingList}"
				var="ranking" itemLabel="#{ranking.rankingCode} (#{ranking.title}) - #{ranking.program}" />
				<f:validator validatorId="RankingDataValidator" />
			</h:selectOneListbox>
			
			<h:outputLabel for="status" styleClass="small" value="Status : " />
			<h:selectOneListbox id="status" size="1" styleClass="largeInput"
			value="#{certificationController.status}"
			required="true" requiredMessage="Status: Value is required.">
				<f:selectItem itemLabel="NOT REQUIRED" itemValue="0" />
				<f:selectItem itemLabel="NOT PRESENT" itemValue="1" />
				<f:selectItem itemLabel="COMPLETE" itemValue="2" />
				<f:selectItem itemLabel="INCOMPLETE" itemValue="3" />
				<f:selectItem itemLabel="NEEDS REVIEW" itemValue="4" />
				<f:selectItem itemLabel="COMPLETE INFORMAL" itemValue="5" />
				<f:selectItem itemLabel="NOT CURRENTLY REVIEWABLE" itemValue="6" />
				<a4j:support event="onchange" ajaxSingle="true" limitToList="true"
				actionListener="#{certificationController.valueChangeEditCertificationStatus}"
				reRender="cdate" />
			</h:selectOneListbox>
			
			<h:outputLabel for="valid_state" styleClass="small" value="Valid In : " />
			<rich:pickList id="valid_state" sourceListWidth="40px" immediate="true"
			switchByDblClick="false" targetListWidth="40px" listsHeight="75px"
			showButtonsLabel="false"
			value="#{certificationController.validStates}">
				<f:selectItems value="#{certificationController.states}" />
			</rich:pickList>
			<h:panelGroup>
				<h:outputLabel for="init" styleClass="small" value="Initial Date : " />
				<h:graphicImage id="init" url="/images/info.png" alt="i" title="i" />
				<rich:toolTip for="init" value="First Contact Date."/>			
			</h:panelGroup>
			
			<rich:calendar id="idate" styleClass="mediumInput" enableManualInput="true"
			cellWidth="24px" cellHeight="22px"  firstWeekDay="0"
			value="#{certificationController.initialDate}" />
			
			<h:outputLabel for="cdate" styleClass="small" value="Complete Date : " />
			<rich:calendar id="cdate" styleClass="mediumInput" enableManualInput="true"
			cellHeight="22px" cellWidth="24px"  firstWeekDay="0"
			value="#{certificationController.completeDate}" />
			
			<h:outputLabel for="memo" styleClass="small" value="Memo :"/>
			<h:inputTextarea id="memo" styleClass="mediumInput" rows="5"
			value="#{certificationController.memo}"/>
			
			<h:message for="edit_certification_button"/>
			<h:commandButton id="edit_certification_button" styleClass="buttonStyle" value="Save"
			action="#{certificationController.editCertificationDetail}"/>
		</h:panelGrid>
	</h:form>
</f:subview>