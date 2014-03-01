<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:subview id="attendee">
	<h:form id="checkin">
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
					value="Conference Check-In" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<rich:messages style="color:red;"></rich:messages>
		<h:panelGroup layout="block" style="text-align:center;align:center;">
			<h:panelGrid columns="2">
				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Select a conference: *" /></font>
				</h:panelGroup>
				<h:selectOneListbox id="conferenceid"
					value="#{conferenceManagementController.selectedConference}"
					size="1" converter="#{ConferenceDataConverter}"
					style="width: 200px;" required="true"
					requiredMessage="Conference List is a required field.">
					<f:selectItem itemLabel="Select One" itemValue="NA" />
					<f:selectItems
						value="#{conferenceManagementController.conferenceList}"
						var="conference" itemLabel="#{conference.name}" />
					<a4j:support event="onchange" ajaxSingle="true"
						reRender="attendeeTable" />
				</h:selectOneListbox>
			</h:panelGrid>
		</h:panelGroup>
		<rich:spacer height="20" />
		<h:panelGroup layout="block" style="width:100%;text-align:center;align:center;">
			<h:panelGrid columns="2" columnClasses="conferencecol1,conferencecol2" style="width:100%;text-align:center;align:center;">
				<h:outputText value="Enter CEPIS User ID or Scan the barcode:" />
				<h:panelGroup>
					<font class="ws12" color="#366B96" face="Tahoma"> <h:inputText
						required="true" requiredMessage="Value is required" id="userid"
						value="#{conferenceManagementController.scannedID}"
						style="width:400px" tabindex="0">
					</h:inputText> </font>
				</h:panelGroup>
			</h:panelGrid>
		</h:panelGroup>
		<h:panelGroup layout="block" style="text-align:center;align:center;">
			<h:commandButton
					value="     Check-in    "
					action="#{conferenceManagementController.checkInScannedUser}"></h:commandButton>
		</h:panelGroup>
		<script>
  document.getElementById('barcode:attendee:checkin:userid').focus();
</script>
	</h:form>
</f:subview>
