<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:subview id="view-college-profile">
	<br />
	
	<h:outputLabel for="lineSeparator" value="View College Profile"  styleClass="medium-bold"/>
	<rich:separator id="lineSeparator" lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>		
	
	<h:form id="collegeprofile_manager">
		<h:panelGroup id="collegeprofileList">
			<h:panelGroup id="body">
				<rich:dataTable id="collegeProfile_list" styleClass="basicTable"
					rowClasses="oddRow,evenRow"
					width="100%" var="collegeprofile"
					value="#{accountManagementController.userCollegeProfileList}"
					rows="#{cepisConfigurationManager.rowCount}">
					<rich:column width="5%">
						<f:facet name="header">
							<h:outputText value="User Type" />
						</f:facet>
						<h:outputText value="#{collegeprofile.userType}"/>
					</rich:column>
					<rich:column width="15%">
						<f:facet name="header">
							<h:outputText value="User Classification" />
						</f:facet>
						<h:outputText value="#{collegeprofile.userClassification}"/>
					</rich:column>
					<rich:column width="5%">
						<f:facet name="header">
							<h:outputText value="College" />
						</f:facet>
						<h:outputText value="#{collegeprofile.ukCollege}"/>
					</rich:column>
					<rich:column width="30%">
						<f:facet name="header">
							<h:outputText value="Department" />
						</f:facet>
						<h:outputText value="#{collegeprofile.ukDepartment}"/>
					</rich:column>
					<rich:column width="10%">
						<f:facet name="header">
							<h:outputText value="Status" />
						</f:facet>
						<h:outputText value="#{collegeprofile.status}"/>
					</rich:column>
					<rich:column width="10%">
						<f:facet name="header">
							<h:outputText value="Start Term" />
						</f:facet>
						<h:outputText value="#{collegeprofile.startTerm}"/>
					</rich:column>
					<rich:column width="5%">
						<f:facet name="header">
							<h:outputText value="End Term" />
						</f:facet>
						<h:outputText value="#{collegeprofile.endTerm}"/>
					</rich:column>
					<rich:column width="5%">
						<f:facet name="header">
							<h:outputText value="Cohort Type" />
						</f:facet>
						<h:outputText value="#{collegeprofile.cohortType}"/>
					</rich:column>
					<rich:column width="5%">
						<f:facet name="header">
							<h:outputText value="Cohort Term" />
						</f:facet>
						<h:outputText value="#{collegeprofile.cohortTerm}"/>
					</rich:column>
					<rich:column width="10%">
						<f:facet name="header">
							<h:outputText value="Short Desc" />
						</f:facet>
						<h:outputText value="#{collegeprofile.shortDesc}"/>
					</rich:column>
				</rich:dataTable>
			</h:panelGroup>
		</h:panelGroup>
	</h:form>
</f:subview>