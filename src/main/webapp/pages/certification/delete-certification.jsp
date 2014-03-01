<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a4j"%>
<link href="${facesContext.externalContext.requestContextPath}/css/datascroller.css"
	media="screen" rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:subview id="delete-certification">
	<h:form id="remove_certification_manager">
		<br />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Delete user certification details" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />

		<h:panelGrid columns="2"
			style="padding-right: 100px; padding-left: 100px">
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Certification Details: " /></font>
			</h:panelGroup>
			<h:panelGroup id="certificationList">
				<h:selectOneListbox id="certificationListid"
					value="#{certificationController.selectedCertification}"
					size="1" converter="#{CertificationDataConverter}"
					style="width: 200px;" required="true"
					requiredMessage="Certification: Value is required.">
					<f:selectItem itemLabel="Select One" itemValue="" />
					<f:selectItems
						value="#{certificationController.certificationList}"
						var="certification" itemLabel="#{certification.programProfile.programDomain} - #{certification.programProfile.program} : #{certification.ranking.title}" />
					<f:validator validatorId="CertificationDataValidator" />
				</h:selectOneListbox>
			</h:panelGroup>
			<h:message for="remove_certification_button"></h:message>
			<h:commandButton id="remove_certification_button" value="Remove"
				action="#{certificationController.removeCertificationFromUser}">
			</h:commandButton>
		</h:panelGrid>

	</h:form>
</f:subview>