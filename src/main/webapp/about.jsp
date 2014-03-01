<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/datascroller.css"
	media="screen" rel="stylesheet" type="text/css"/>
<%@ include file="/common/header.jsp"%>
<script type="text/javascript">
	document.title = "About CEPIS";
	var global_title = document.getElementById('global_title');
	global_title.innerHTML = "CEPIS System Information";
</script>
<f:view>
	<rich:tabPanel switchType="client">
		<rich:tab label="_about">
			<h:panelGrid columns="1">
					<h:form>
						<div class="heading">
							<b>
								<big>
									<font color="#062E8A" face="Tahoma">
										About the College of Education Information System Web Portal
									</font>
								</big>
							</b>
						</div>
						<br />
						<div id="wspace"
							style="border-left: 1px solid rgb(0, 0, 102); border-right: 1px solid rgb(0, 0, 102);">
						<div id="outerbox">
						<table>
							<tbody>
								<tr>
									<td>
									<div id="descbox">
									<table>
										<tbody>
											<tr>
												<td>
												<div class="head"><b><font class="ws10"
													color="gray" face="Tahoma">SEARCH MODULE</font></b></div>
												</td>
											</tr>
											<tr>
												<td>
												<div class="label"><font class="ws10" face="Tahoma">Search
												Module permits searching by individual, by student group,
												and by faculty group. Search results are maintained as an
												active "session" which can be used for a variety of
												purposes.<br>
												The View Working Set can be used to view this active session
												at any point of time. Results of searches can be saved for
												reuse.</font></div>
												<br>
												</td>
											</tr>

											<tr>
												<td>
													<div class="head">
														<b>
															<font class="ws10" color="gray" face="Tahoma">
																EPSB WEB SERVICES
															</font>
														</b>
													</div>
												</td>
											</tr>
											<tr>
												<td>
												<div class="label"><font class="ws10" face="Tahoma">EPSB
												Web Services Module is utilized to request data from the
												databases of the Education Professional Standards Board
												(EPSB), to submit data from UK to the EPSB, and to review
												any errors and inconsistencies between data at UK and the
												EPSB.</font></div>
												</td>
											</tr>
										</tbody>
									</table>
									</div>
									</td>

									<td>
									<div id="desclowbox">
									<table>
										<tbody>
											<tr>
												<td>
												<div class="head"><b><font class="ws10"
													color="gray" face="Tahoma">ACCOUNT MAINTENANCE
												MODULE</font></b></div>
												</td>
											</tr>
											<tr>
												<td>
												<div class="label"><font class="ws10" face="Tahoma">The
												Account Maintenance Module is used to add new students to
												the database, and to edit an individual's college profile,
												program profile, and core demographic information.</font></div>
												<br>
												</td>
											</tr>

											<tr>
												<td>
												<div class="head"><b><font class="ws10"
													color="gray" face="Tahoma">ADVISING MODULE</font></b></div>
												</td>
											</tr>
											<tr>
												<td>
												<div class="label"><font class="ws10" face="Tahoma">The
												Advising Module is designed to permit advisors to review
												student data, send student email, insert an advisor note for
												the student, and write/save a letter for a student. It
												displays all the academic information of the student.</font></div>
												<br>
												</td>
											</tr>

											<tr>
												<td>
												<div class="head"><b><font class="ws10"
													color="gray" face="Tahoma">REPORTS MODULE</font></b></div>
												</td>
											</tr>
											<tr>
												<td>
												<div class="label"><font class="ws10" face="Tahoma">The
												Session Reports represents the data about the students in
												the active session in various forms. These reports aid the
												management in decision making analysis.</font></div>
												</td>
											</tr>
										</tbody>
									</table>
									</div>
									</td>

								</tr>
							</tbody>
						</table>
						</div>
						</div>
				</h:form>
			</h:panelGrid>
		</rich:tab>
		<rich:tab label="_sysinfo">
			<h:panelGrid style="padding-right: 100px; padding-left: 100px">
				<h:form id="about">
					<h:panelGrid columns="2">
						<h:graphicImage url="/images/info.png" alt="i" title="Info" />
						<h:panelGroup>
							<font class="ws14" color="#062E8A" face="Tahoma"> <h:outputText
								value="CEPIS Current System Information"></h:outputText> </font>
						</h:panelGroup>
					</h:panelGrid>
					<br />
					<h:panelGrid columns="2">
						<h:outputText value="Version: "></h:outputText>
						<h:outputText value="#{cepisConfigurator.version}"></h:outputText>
						<h:outputText value="Release Date: "></h:outputText>
						<h:outputText value="#{cepisConfigurator.releaseDate}"></h:outputText>
					</h:panelGrid>
					<br />
					<font class="ws12" color="#062E8A" face="Tahoma"><b> <h:outputText
						value="Authors"></h:outputText> </b></font>
					<br />
					<h:panelGrid columns="2">
						<t:dataTable id="scrollList_author" styleClass="scrollTable"
							headerClass="head1" rowClasses="normalRow,alternateRow"
							width="100%"
							columnClasses="standardTable_Column,standardTable_Column,standardTable_ColumnCentered,standardTable_Column"
							var="author" value="#{cepisConfigurator.authorNames}"
							preserveDataModel="false"
							rows="#{cepisConfigurationManager.rowCount}">
							<h:column>
								<f:facet name="header">
									<font class="ws12" color="#062E8A" face="Tahoma"><b>
									<h:outputText value="Name" /></b></font>
								</f:facet>
								<h:outputText value="#{author}" />
							</h:column>
						</t:dataTable>
						<t:dataTable id="scrollList_email" styleClass="scrollTable"
							headerClass="head1" rowClasses="normalRow,alternateRow"
							width="100%"
							columnClasses="standardTable_Column,standardTable_Column,standardTable_ColumnCentered,standardTable_Column"
							var="email" value="#{cepisConfigurator.authorEmails}"
							preserveDataModel="false"
							rows="#{cepisConfigurationManager.rowCount}">
							<h:column>
								<f:facet name="header">
									<h:outputText value="Email" />
								</f:facet>
								<h:outputText value="#{email.address}  (type:#{email.type})" />
							</h:column>
						</t:dataTable>
					</h:panelGrid>
					<br />
					<h:panelGrid columns="2">
						<h:outputText value="Application Name: "></h:outputText>
						<h:outputText value="#{cepisConfigurator.applicationName}"></h:outputText>
						<h:outputText value="Report Bug: "></h:outputText>
						<h:panelGroup>
							<font class="ws8" face="Tahoma"> <h:outputLink
								styleClass="style1" value="#{cepisConfigurator.bugReportLink}">CEPIS TRAC SCM</h:outputLink>
							</font>
						</h:panelGroup>
					</h:panelGrid>
					<hr />
					<h:panelGrid columns="2">
						<h:panelGroup>
		&copy;&nbsp;<h:outputText value="#{cepisConfigurator.year}"></h:outputText>&nbsp;</h:panelGroup>
						<h:outputText value="#{cepisConfigurator.copyRightTo}"></h:outputText>
					</h:panelGrid>
				</h:form>
			</h:panelGrid>
		</rich:tab>
	</rich:tabPanel>

</f:view>
<%@ include file="/common/footer.jsp"%>