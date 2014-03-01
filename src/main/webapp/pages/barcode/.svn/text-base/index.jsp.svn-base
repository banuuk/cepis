<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ include file="/common/header.jsp"%>
<script type="text/javascript">
	document.title = "CEPIS Barcode App";
	var global_title = document.getElementById('global_title');
	global_title.innerHTML = "CEPIS Barcode App";
</script>
<script type="text/javascript"
	src="${facesContext.externalContext.requestContextPath}/js/search.js"></script>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/search.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/datascroller.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:view>
	<h:form id="barcode_manager">
		<!-- Overwrite Session Timeout -->
		<%
			session.setMaxInactiveInterval(-1);
		%>
		<br />
		<a4j:outputPanel ajaxRendered="true" style="align:center">
			<h:panelGrid columns="1">
				<h:messages errorClass="cepiserror" infoClass="cepisinfo"
					warnClass="cepiswarning"></h:messages>
				<a4j:status startText="Loading ..." startStyleClass="loadingStatus"></a4j:status>
			</h:panelGrid>
		</a4j:outputPanel>
		<rich:simpleTogglePanel switchType="ajax" label="Available Actions">
			<h:panelGrid columns="1" width="100%">
				<h:panelGroup>
					<h:selectBooleanCheckbox title="checkin"
						value="#{advisingManagementController.enableCheckinAction}">
					</h:selectBooleanCheckbox>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value=" Check-in." /></font>
				</h:panelGroup>
				<h:panelGroup>
					<font class="ws10" face="Tahoma"><h:outputText
						value="Today's scheduled appointment of this user will be checked-in. The barcode app assumes that each user has only one appointment per day."
						style="color:gray"></h:outputText></font>
			</h:panelGroup>
				<rich:separator align="center" width="100%" lineType="solid"></rich:separator>
				<h:panelGroup>
				<h:selectBooleanCheckbox title="addtows"
						value="#{advisingManagementController.enableAddToWorkingSetAction}">
					</h:selectBooleanCheckbox>
					<font class="ws10" color="#062E8A" face="Tahoma"> <h:outputText
						value="Add to the Current Working Set." /></font>
				</h:panelGroup>
				<h:panelGroup>
					<font class="ws10" face="Tahoma"><h:outputText
						value="The scanned user will be added to the Current Working Set "
						style="color:gray"></h:outputText></font>
					<h:outputText
						value="(#{workingSetController.activeWorkingSetName})."></h:outputText>&nbsp;&nbsp;
			</h:panelGroup>
			</h:panelGrid>
		</rich:simpleTogglePanel>
	
		<br />
		<br />
		<TABLE bgcolor="#FFFFFF" border=0 cellpadding=0 cellspacing=0
			align="center">
			<TR align="center" valign=middle>
				<TD align="center" valign=middle width="35%"><h:outputText>Enter CEPIS User ID/Username or Scan the barcode: </h:outputText>
				</TD>
				<TD align="center" valign=middle>
				<div class="wpmd">
				<div align=center><font class="ws12" color="#366B96"
					face="Tahoma"> <h:inputText required="true"
					requiredMessage="Value is required" id="userid"
					value="#{advisingManagementController.scannedID}"
					style="width:400px" tabindex="0">
				</h:inputText> </font></div>
				</div>
				</TD>
			</TR>
			<TR align="center" valign=middle>
				<TD align="center" valign=middle colspan="2"><h:commandButton
					value="     Add    "
					action="#{advisingManagementController.addScannedUser}"></h:commandButton>
				</TD>
			</TR>
		</TABLE>
		<script>
	document.getElementById('barcode_manager:userid').focus();
</script>
	</h:form>
</f:view>
<%@ include file="/common/footer.jsp"%>