<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<link
	href="${facesContext.externalContext.requestContextPath}/css/font.css"
	media="screen" rel="stylesheet" type="text/css" />
<link
	href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css" />
<link
	href="${facesContext.externalContext.requestContextPath}/css/datascroller.css"
	media="screen" rel="stylesheet" type="text/css" />
<f:subview id="ws">
	<h:form id="view_ws">
		<br />
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/info.png" alt="i" title="Info" />
			<h:panelGroup>
				<font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
						value="Current Working Set" /></font>
			</h:panelGroup>
		</h:panelGrid>
		<h:panelGrid columns="1"
			style="padding-right: 100px; padding-left: 100px">

			<table style="valign: top;" width=230 height=500 border=0
				cellpadding=0 cellspacing=0>
				<tr valign=top>
					<td width=210 height=15>
						<div class="wpmd">
							<div align=center></div>
						</div>
					</td>
				</tr>
				<tr valign=top>
					<td width=210 height=15>
						<div class="wpmd">
							<a4j:status startText="Loading ..."
								startStyleClass="loadingStatus"></a4j:status>
						</div>
					</td>
				</tr>
				<tr valign=top>
					<td width=210 height=24>
						<div class="wpmd">
							<div align=center>
								<img border=0 hspace=1 vspace=1
									src="${facesContext.externalContext.requestContextPath}/images/current_ws.jpg"/>
							</div>
						</div>
					</td>
				</tr>
				<tr valign=top>
					<td width=210><h:panelGroup>
							<table border=0>
								<tr>
									<td width=80% align=left><font color="#062E8A"
										face="Tahoma">&nbsp;<b>&nbsp;&nbsp;&nbsp;&nbsp;<h:outputText
													id="ws_name"
													value="#{workingSetController.activeWorkingSetName}"></h:outputText></b></font></td>
									<td width=20% align=right><font color="#062E8A"
										face="Tahoma">&nbsp;<b><h:graphicImage id="ws_info"
													url="/images/info.png" alt="i"
													title="#{workingSetController.activeWorkingSetDescription}" />&nbsp;&nbsp;&nbsp;&nbsp;</b></font></td>
								</tr>
							</table>
						</h:panelGroup></td>
				</tr>
				<tr valign=top>
					<td><h:panelGroup>
							<table border=0>
								<tr>
									<td width=50% align="left"><font color="#062E8A"
										face="Tahoma">&nbsp;<b>&nbsp;&nbsp;&nbsp;&nbsp;<a4j:commandLink
													reRender="wsid,ws_name,ws_info"
													actionListener="#{workingSetController.newWS}" value="New"
													title="Create new Working Set"></a4j:commandLink> <a4j:commandLink
													reRender="wsid" rendered="false"
													actionListener="#{workingSetController.clearWS}"
													onclick="if (!confirm('Clear this Working Set, Are you sure?')) return false"
													title="Clear this Working Set" value="Clear"></a4j:commandLink></b></font></td>
									<td width=50% align="right"><font color="#062E8A"
										face="Tahoma">&nbsp;<b><a4j:commandLink id="all"
													onclick="return selectAll('include_ws:ws:view_ws:wsid',true);"
													title="all" value="all"></a4j:commandLink>&nbsp;|&nbsp; <a4j:commandLink
													id="none"
													onclick="return selectAll('include_ws:ws:view_ws:wsid',false);"
													title="none" value="none"></a4j:commandLink></b></font></td>
								</tr>
							</table>
						</h:panelGroup></td>
				</tr>
				<tr valign=top>
					<td width=210 align=center><br/> <h:selectManyListbox
								id="wsid" value="#{workingSetController.selectedWSUsersList}"
								size="15" converter="#{UserDataConverter}" style="width: 200px;">
								<f:selectItems value="#{workingSetController.activeWSUsersList}"
									var="user" itemLabel="#{user.fullName}" />
								<f:validator validatorId="UserDataValidator" />
							</h:selectManyListbox></td>
				</tr>
				<tr valign=top>
					<td width=210 height=20>
						<div class="wpmd">
							&nbsp; &nbsp; &nbsp;
							<a4j:commandButton value="Delete"
								onclick="if (!confirm('Are you sure?')) return false"
								reRender="wsid"
								actionListener="#{workingSetController.deleteWSUsers}">
							</a4j:commandButton>
						</div>
					</td>
				</tr>
				<tr valign=top>
					<td width=210 height=20>
						<div class="wpmd"></div>
					</td>
				</tr>
			</table>
		</h:panelGrid>
		<script type="text/javascript"
			src="${facesContext.externalContext.requestContextPath}/js/search.js"></script>
	</h:form>
</f:subview>