<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:subview id="view-certification">
	<h:outputText value="#{certificationController.setUpViewTab}"/>
	<br />
	<h:message for="certification_manager">
	</h:message>
	<h:form id="certification_manager">
		<h:panelGroup id="certificationList">
			<h:panelGroup id="newCert" layout="block" style="padding-bottom:30px">
				<rich:dataTable id="certification_table" 
					styleClass="basicTable"
					width="99%"	
					rowClasses="oddRow,evenRow"									
					var="certification"
					value="#{certificationController.certificationList}"
					rows="#{cepisConfigurationManager.rowCount}">					
					<rich:column>
						<f:facet name="header">
							<h:outputText value="Program Profile" />
						</f:facet>
						<h:outputText
							value="#{certification.programProfile.programDomain} - #{certification.programProfile.program}"></h:outputText>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="Ranking" />
						</f:facet>
						<h:outputText value="#{certification.ranking.title}"/>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="Status" />
						</f:facet>
						<h:outputText value="#{certification.statusDescription}"/>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="Valid in" />
						</f:facet>
						<h:outputText value="#{certification.state}"/>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="Initial Date" />
						</f:facet>
						<h:outputText value="#{certification.initialDate}"/>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="Complete Date" />
						</f:facet>
						<h:outputText value="#{certification.completeDate}"/>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="Memo" />
						</f:facet>
						<h:outputText value="#{certification.memo}"/>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="Last Edit" />
						</f:facet>
						<h:outputText value="#{certification.lastEdit}"/>
					</rich:column>
					
				</rich:dataTable>
			</h:panelGroup>


			<h:outputLabel for="feesInfo" value="Archived Certifications"  styleClass="medium-bold"/>			
			<rich:separator lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>
		
			<h:panelGroup id="archivedCert">
				
				<rich:dataTable id="oldCertification" styleClass="basicTable"
					headerClass="head1" rowClasses="oddRow,evenRow"	
					width="99%"					
					var="certification"
					value="#{certificationController.oldCerticationList}"
					rows="#{cepisConfigurationManager.rowCount}">					
					<rich:column>
						<f:facet name="header">
							<h:outputText value="Cert. Code" />
						</f:facet>
						<h:outputText value="#{certification[0]}"/>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="Cert. Title" />
						</f:facet>
						<h:outputText value="#{certification[1]}"/>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="Endorsement Code" />
						</f:facet>
						<h:outputText value="#{certification[2]}"/>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="Endrse. Title" />
						</f:facet>
						<h:outputText value="#{certification[3]}"/>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="Ranking Code" />
						</f:facet>
						<h:outputText value="#{certification[4]}"/>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="Rank. Title" />
						</f:facet>
						<h:outputText value="#{certification[5]}"/>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="Status" />
						</f:facet>
						<h:outputText value="#{certification[6]}"/>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="Status Chg. Term" />
						</f:facet>
						<h:outputText value="#{certification[7]}"/>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="Report Yr." />
						</f:facet>
						<h:outputText value="#{certification[8]}"/>
					</rich:column>					
				</rich:dataTable>
			</h:panelGroup>
		</h:panelGroup>
	</h:form>
</f:subview>