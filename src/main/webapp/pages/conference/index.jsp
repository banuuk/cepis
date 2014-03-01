<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ include file="/common/header.jsp"%>

<script type="text/javascript">
	document.title = "CEPIS Conference Management System";
	var global_title = document.getElementById('global_title');
	global_title.innerHTML = "CEPIS Conference Management System";
</script>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/datascroller.css"
	media="screen" rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/conference.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:view locale="en">
	<a4j:outputPanel ajaxRendered="true">
		<h:panelGrid columns="1">
			<h:messages errorClass="cepiserror" infoClass="cepissuccess"
				warnClass="cepiswarning"></h:messages>
		</h:panelGrid>
		<a4j:status onstart="showModalInfoWindow();"
			onstop="hideModalInfoWindow()"></a4j:status>
	</a4j:outputPanel>
	<rich:tabPanel switchType="ajax" immediate="true">
		<authz:authorize
			ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_CONFERENCE_MANAGER">
			<rich:tab label="Conference">
				<a4j:include viewId="cepis-conference.jsp" />
			</rich:tab>
			<rich:tab label="Attendee">
				<a4j:include viewId="conference-attendee.jsp" />
			</rich:tab>
			<rich:tab label="Check-In #">
				<a4j:include id="barcode" viewId="checkin.jsp" />
			</rich:tab>
			<rich:tab label="Registration #">
				<a4j:include id="add" viewId="add-attendee-barcode.jsp" />
			</rich:tab>
		</authz:authorize>
	</rich:tabPanel>
	<br />
	<h:outputText># - requires a barcode reader and CEPIS ID card.</h:outputText>

	<rich:modalPanel id="createConferencePanel" autosized="true"
		width="200">
		<f:facet name="header">
			<h:outputText value="Create new conference"
				style="padding-right:15px;" />
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="/images/icons/cancel.png"
					styleClass="hidelink" id="hideconferencecreatelink" alt="X"/>
				<rich:componentControl for="createConferencePanel"
					attachTo="hideconferencecreatelink" operation="hide"
					event="onclick" />
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
						<h:outputText value="Conference name" style="color:gray" />
					</h:panelGroup>
					<h:inputText value="#{conferenceManagementController.name}"
						style="width:200px" required="true"
						requiredMessage="Conference name is a required field.">
						<f:validateLength maximum="255" />
					</h:inputText>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
							value="Type: *" /></font>
						<br />
						<h:outputText value="Conference type" style="color:gray" />
					</h:panelGroup>
					<rich:comboBox value="#{conferenceManagementController.type}"
						style="width:200px" required="true"
						requiredMessage="Conference type is a required field."
						defaultLabel="Select conference type">
						<f:selectItem itemValue="Advising Conference" />
						<f:selectItem itemValue="General" />
						<f:selectItem itemValue="Not Applicable" />
						<f:validateLength maximum="255" />
					</rich:comboBox>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
							value="Date: *" /></font>
						<br />
						<h:outputText value="Conference date" style="color:gray" />
					</h:panelGroup>
					<rich:calendar
						value="#{conferenceManagementController.conferenceDate}"
						popup="true" style="width:200px" required="true"
						requiredMessage="Conference date is a required field.">
						<f:validateLength maximum="255" />
					</rich:calendar>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
							value="Short Description :"></h:outputText></font>
						<br>
						<h:outputText
							value="Short description for the drop-down box. Max 1024 characters"
							style="color:gray"></h:outputText>
					</h:panelGroup>
					<h:inputTextarea
						value="#{conferenceManagementController.shortDesc}"
						style="width:200px" rows="2">
						<f:validateLength minimum="0" maximum="1024" />
					</h:inputTextarea>
				</h:panelGrid>
				<a4j:commandButton value="Create"
					reRender="conferenceTable,conferenceid"
					action="#{conferenceManagementController.createConference}"
					oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('createConferencePanel')}.hide();"></a4j:commandButton>
			</h:panelGrid>
		</h:form>
	</rich:modalPanel>
	<rich:modalPanel id="createAttendeePanel" autosized="true" width="200">
		<f:facet name="header">
			<h:outputText
				value="Add a new attendee to the conference #{conferenceManagementController.selectedConference.name}"
				style="padding-right:15px;" />
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="/images/icons/cancel.png"
					styleClass="hidelink" id="hideattendeecreatelink" alt="X"/>
				<rich:componentControl for="createAttendeePanel"
					attachTo="hideattendeecreatelink" operation="hide" event="onclick" />
			</h:panelGroup>
		</f:facet>
		<h:form>
			<rich:messages style="color:red;"></rich:messages>
			<h:panelGrid columns="1">
				<h:panelGrid columns="2">
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
							value="Select a user: *" /></font>
						<br />
						<h:outputText
							value="(#{workingSetController.activeWorkingSetName})"
							style="color:gray" />
					</h:panelGroup>
					<h:selectManyListbox id="wsid" size="25"
						value="#{conferenceManagementController.selectedUsers}"
						converter="#{UserDataConverter}" style="width: 200px;"
						required="true" requiredMessage="User is a required field.">
						<f:selectItems value="#{workingSetController.activeWSUsersList}"
							var="user" itemLabel="#{user.fullName}" />
						<f:validator validatorId="UserDataValidator" />
					</h:selectManyListbox>

				</h:panelGrid>
				<a4j:commandButton value="Add"
					reRender="attendeeTable,deleteAttendeePanel"
					action="#{conferenceManagementController.addAttendees}"
					oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('createConferencePanel')}.hide();"></a4j:commandButton>
			</h:panelGrid>
		</h:form>
	</rich:modalPanel>
	<rich:modalPanel id="ajaxLoadingModalBox" minHeight="50" minWidth="120"
		height="100" width="120" zindex="2000">
		<f:facet name="header">
			<h:outputText value="Sending Request ..."></h:outputText>
		</f:facet>
		<h:outputText value="Please wait ..."></h:outputText>
		<br />
		<br />&nbsp;&nbsp;&nbsp;
				<h:graphicImage value="/images/loader.gif" style="border:0" alt="loading ..."></h:graphicImage>
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