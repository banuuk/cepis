
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:subview id="wss-options">
	<h:form id="switch_ws">
		<br />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
					value="Working Set Options" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<br />
		<h:panelGroup>
			<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
				value="Current Working Set: "></h:outputText></font>
		</h:panelGroup>
		<h:outputText value="#{workingSetController.activeWorkingSetName}"></h:outputText>&nbsp;&nbsp;
		<br />

		<h:panelGrid columns="2">
			<h:panelGrid columns="1"
				style="padding-right: 100px; padding-left: 100px">
				<h:panelGroup style="text-align: center">
					<h:commandLink action="#{workingSetController.enableAllWS}"
						disabled="#{workingSetController.allWS}" id="allws"
						styleClass="style1">
						<h:outputText value="All" styleClass="ws10" />
					</h:commandLink>
						&nbsp;&nbsp;|&nbsp;&nbsp;
						<h:commandLink action="#{workingSetController.enablePublicWS}"
						disabled="#{workingSetController.publicWS}" id="publicws"
						styleClass="style1">
						<h:outputText value="Public" styleClass="ws10" />
					</h:commandLink>
							&nbsp;&nbsp;|&nbsp;&nbsp;
							<h:commandLink id="sharedws"
						action="#{workingSetController.enableSharedWS}" disabled="true"
						styleClass="style1">
						<h:outputText value="Shared" styleClass="ws10" />
					</h:commandLink>
				</h:panelGroup>
				<h:selectOneListbox id="wsswitchid"
					value="#{workingSetController.selectedWS}" size="10"
					converter="#{WorkingSetDataConverter}" style="width:200px">
					<f:selectItems value="#{workingSetController.activeWSList}"
						var="ws" itemLabel="#{ws.name}" />
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{workingSetController.valueChangeEditWS}"
						limitToList="true"
						reRender="name,desc,publicmode,publicSummary,addPublicOperation,removePublicOperation,sharedmode" />
					<f:validator validatorId="WorkingSetDataValidator" />
				</h:selectOneListbox>
				<h:message for="wsswitchid" style="color:RED" />
				<br />
				<h:panelGroup style="text-align: center">

					<h:commandButton value="Open"
						action="#{workingSetController.openWS}"></h:commandButton>
					<h:outputText rendered="#{workingSetController.allWS}">&nbsp;|&nbsp;</h:outputText>
					<h:commandButton value="Delete"
						rendered="#{workingSetController.allWS}"
						action="#{workingSetController.deleteWS}"
						onclick="if (!confirm('Are you sure?')) return false"></h:commandButton>

				</h:panelGroup>
			</h:panelGrid>
			<h:panelGroup>
				<h:panelGrid columns="2">
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
							value="Working Set name:"></h:outputText></font>
					</h:panelGroup>
					<h:inputText id="name" value="#{workingSetController.name}"
						style="width: 180px" disabled="#{!workingSetController.allWS}"></h:inputText>

					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
							value="Working Set description:"></h:outputText></font>
					</h:panelGroup>
					<h:inputTextarea id="desc"
						value="#{workingSetController.description}" rows="3"
						style="width:180px" disabled="#{!workingSetController.allWS}"></h:inputTextarea>
				</h:panelGrid>
				<br />
				<br />
		&nbsp;&nbsp;&nbsp;<b><h:outputText value="More options" /></b>
				<br />
				<h:panelGrid columns="2">
					<h:selectBooleanCheckbox id="publicmode"
						disabled="#{!workingSetController.allWS}"
						title="Global working set which is accesible to all the authorized users in the system"
						value="#{workingSetController.publicmode}">
						<a4j:support event="onchange" reRender="publicSummary"
							ajaxSingle="true"
							oncomplete="if(#{workingSetController.publicmode}) #{rich:component('publicWS')}.show();"></a4j:support>
					</h:selectBooleanCheckbox>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
							value="Public" /> </font>
					</h:panelGroup>
				</h:panelGrid>
				<h:panelGroup id="publicSummary">
					<h:panelGrid rendered="#{workingSetController.publicmode}">
						<h:panelGroup>
							<font class="ws10" color="#424242" face="Tahoma"> <h:outputText
								value="#{workingSetController.publicSummary}"></h:outputText> </font>
						</h:panelGroup>
						<a4j:commandLink value="Update public settings" rendered="#{workingSetController.allWS}"
							oncomplete="#{rich:component('publicWS')}.show();" />
					</h:panelGrid>
				</h:panelGroup>

				<rich:spacer height="10px"></rich:spacer>

				<h:panelGrid columns="2" rendered="false">
					<h:selectBooleanCheckbox id="sharedmode"
						disabled="#{!workingSetController.allWS}"
						title="Allow this working set to be shared with other users"
						value="#{workingSetController.sharedmode}"></h:selectBooleanCheckbox>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
							value="Shared" /> </font>
					</h:panelGroup>
				</h:panelGrid>
				<h:panelGroup id="shareSummary" rendered="false">
					<font class="ws10" color="#424242" face="Tahoma"> <h:outputText
						value="Allow any authorized CEPIS users to add users to this working set."></h:outputText>
					</font>
				</h:panelGroup>

				<br />
				<h:message for="save_button"></h:message>
				<br />
				<h:commandButton id="save_button" value="Save"
					disabled="#{!workingSetController.allWS}"
					action="#{workingSetController.editWS}"></h:commandButton>
			</h:panelGroup>
		</h:panelGrid>
	</h:form>
	<rich:modalPanel id="publicWS" autosized="true" width="450">
		<f:facet name="header">
			<h:outputText value="Public Working Set Settings" />
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="/images/icons/cancel.png" id="publicWSLink"
					styleClass="hidelink" alt="X"/>
				<rich:componentControl for="publicWS" attachTo="publicWSLink"
					operation="hide" event="onclick" />
			</h:panelGroup>
		</f:facet>
		<h:form>
			<rich:messages style="color:red;"></rich:messages>
			<h:panelGrid columns="1">
				<h:panelGrid columns="2">
					<h:selectBooleanCheckbox id="addPublicOperation"
						title="Allow others to add users to this working set."
						value="#{workingSetController.allowPublicToAdd}">
					</h:selectBooleanCheckbox>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
							value="Allow any authorized CEPIS users to add users to this working set."></h:outputText>
						</font>
					</h:panelGroup>
					<h:selectBooleanCheckbox id="removePublicOperation"
						title="Allow others to remove users from this working set."
						value="#{workingSetController.allowPublicToRemove}">
					</h:selectBooleanCheckbox>
					<h:panelGroup>
						<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
							value="Allow any authorized CEPIS users to remove users from this working set."></h:outputText>
						</font>
					</h:panelGroup>
				</h:panelGrid>
				<a4j:commandButton value="OK" reRender="publicSummary"
					oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('publicWS')}.hide();"></a4j:commandButton>
			</h:panelGrid>
		</h:form>
	</rich:modalPanel>
</f:subview>