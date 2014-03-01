<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:subview id="advising-feedback">
	<h:form>

		
		<p>Please provide feedback on your experience below. Please wait for confirmation that the message has been sent.</p>

		
		<rich:panel style="width:400px; margin: 40px auto;">
			<f:facet name="header">
				<h:outputText value="Feedback Form" />
			</f:facet>
			<h:panelGrid columns="3"
				style="padding-right: 10px; padding-left: 10px">

				<h:panelGroup>
					<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Message: " /></font>
				</h:panelGroup>
				<rich:spacer width="15" height="10" title="Here is a spacer..." />
				<h:inputTextarea id="message" style="width:200px"
					value="#{advisingManagementController.message}" required="true"
					requiredMessage="Message is required."  rows="5">
				</h:inputTextarea>
			</h:panelGrid>

			<h:commandButton id="feedback_button" value="Send"
				style="display: block; margin: auto;"
				action="#{advisingManagementController.sendFeedbackEmail}">
			</h:commandButton>

		</rich:panel>
	</h:form>
</f:subview>