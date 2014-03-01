<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<link href="${facesContext.externalContext.requestContextPath}/css/datascroller.css"
	media="screen" rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:subview id="view-program-profile">
	<br/>
	
	<h:outputLabel for="lineSeparator" value="View Program Profile"  styleClass="medium-bold"/>
	<rich:separator id="lineSeparator" lineType="dotted" height="4" align="center" style="margin-bottom:20px;"/>
			
	<h:form id="programprofile_manager">
		<authz:authorize
			ifAnyGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD,ROLE_STUDENT_ACCOUNT_MANAGER_EDIT,ROLE_STUDENT_ACCOUNT_MANAGER_VIEW">

			
			<rich:dataTable id="programProfileTable" styleClass="scrollTable"
				headerClass="head1" rowClasses="normalRow,alternateRow" width="100%"
				sortMode="single"
				columnClasses="standardTable_Column,standardTable_Column,standardTable_ColumnCentered,standardTable_Column"
				var="programprofile"
				value="#{accountManagementController.userProgramProfileList}"
				rows="10">
				
				<rich:column width="8%">
					<f:facet name="header">
						<h:outputText value="Program" />
					</f:facet>
					<h:outputText value="#{programprofile.program}"/>
				</rich:column>
				<rich:column width="7%">
					<f:facet name="header">
						<h:outputText value="Program Domain" />
					</f:facet>
					<h:outputText value="#{programprofile.programDomain}"/>
				</rich:column>
				<rich:column width="7%">
					<f:facet name="header">
						<h:outputText value="Program Track" />
					</f:facet>
					<h:outputText value="#{programprofile.programTrack}"/>
				</rich:column>
				<rich:column width="7%">
					<f:facet name="header">
						<h:outputText value="Program Group" />
					</f:facet>
					<h:outputText value="#{programprofile.programGroup}"/>
				</rich:column>
				<rich:column width="7%">
					<f:facet name="header">
						<h:outputText value="Major" />
					</f:facet>
					<h:outputText value="#{programprofile.ukMajor}"/>
				</rich:column>
				<rich:column width="6%">
					<f:facet name="header">
						<h:outputText value="Status" />
					</f:facet>
					<h:outputText value="#{programprofile.ukStatus}"/>
				</rich:column>
				<rich:column width="7%">
					<f:facet name="header">
						<h:outputText value="Start Term" />
					</f:facet>
					<h:outputText value="#{programprofile.ukStartTerm}"/>
				</rich:column>				
				<rich:column width="7%">
					<f:facet name="header">
						<h:outputText value="End Term" />
					</f:facet>
					<h:outputText value="#{programprofile.ukCompleteTerm}"/>
				</rich:column>
				<rich:column width="15%">
					<f:facet name="header">
						<h:outputText value="Anticipated Complete Term" />
					</f:facet>
					<h:outputText value="#{programprofile.ukAnticipatedCompleteTerm}"/>
				</rich:column> 
				<rich:column width="10%">
					<f:facet name="header">
						<h:outputText value="Prof. Advisor" />
					</f:facet>
					<h:outputText value="#{programprofile.advisor}"/>
				</rich:column>
				<rich:column width="15%">
					<f:facet name="header">
						<h:outputText value="Faculty Advisor" />
					</f:facet>
					<h:outputText value="#{programprofile.facultyAdvisor}"/>
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Degree" />
					</f:facet>
					<h:outputText value="#{programprofile.degreeAwarded}"/>
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Hidden" />
					</f:facet>
					<h:outputText rendered="#{programprofile.hiddenToStudent}"
						value="Yes"></h:outputText>
					<h:outputText rendered="#{!programprofile.hiddenToStudent}"
						value="No"></h:outputText>
				</rich:column>			
			</rich:dataTable>

		</authz:authorize>

		<authz:authorize ifAnyGranted="ROLE_STUDENT">
		<authz:authorize ifNotGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD,ROLE_STUDENT_ACCOUNT_MANAGER_EDIT,ROLE_STUDENT_ACCOUNT_MANAGER_VIEW">
		
			
			<rich:dataTable id="studentProgramProfileTable"
			styleClass="scrollTable" headerClass="head1"
			rowClasses="normalRow,alternateRow" width="100%" sortMode="single"
			columnClasses="standardTable_Column,standardTable_Column,standardTable_ColumnCentered,standardTable_Column"
			var="programprofile"
			value="#{accountManagementController.studentUserProgramProfileList}"
			rows="10">
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Program" />
					</f:facet>
					<h:outputText value="#{programprofile.program}"></h:outputText>

				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Program Domain" />
					</f:facet>
					<h:outputText value="#{programprofile.programDomain}"></h:outputText>
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Program Track" />
					</f:facet>
					<h:outputText value="#{programprofile.programTrack}"></h:outputText>
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Program Group" />
					</f:facet>
					<h:outputText value="#{programprofile.programGroup}"></h:outputText>
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Major" />
					</f:facet>
					<h:outputText value="#{programprofile.ukMajor}"></h:outputText>
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Status" />
					</f:facet>
					<h:outputText value="#{programprofile.ukStatus}"></h:outputText>
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Start Term" />
					</f:facet>
					<h:outputText value="#{programprofile.ukStartTerm}"></h:outputText>
				</rich:column>				
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Complete Term" />
					</f:facet>
					<h:outputText value="#{programprofile.ukCompleteTerm}"></h:outputText>
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Advisor" />
					</f:facet>
					<h:outputText value="#{programprofile.advisor}"></h:outputText>
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Degree" />
					</f:facet>
					<h:outputText value="#{programprofile.degreeAwarded}"></h:outputText>
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Short Desc" />
					</f:facet>
					<h:outputText value="#{programprofile.shortDesc}"></h:outputText>
				</rich:column>
			</rich:dataTable>
		</authz:authorize>
		</authz:authorize>



	</h:form>
</f:subview>