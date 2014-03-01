<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ include file="/common/header.jsp"%>
<script type="text/javascript">
	document.title = "CEPIS Working Set";
	var global_title = document.getElementById('global_title');
	global_title.innerHTML = "CEPIS Working Set";
</script>
<f:view>
	<a4j:outputPanel ajaxRendered="true">
		<h:panelGrid columns="1">
			<h:messages errorClass="cepiserror" infoClass="cepissuccess"
				warnClass="cepiswarning"></h:messages>
		</h:panelGrid>
		<a4j:status onstart="showModalInfoWindow();"
			onstop="hideModalInfoWindow()"></a4j:status>
	</a4j:outputPanel>
	<br />
	<rich:tabPanel switchType="ajax" immediate="true">
		<rich:tab id="tab_wss_options" label="Options">
			<a4j:include viewId="wss-options.jsp" />
		</rich:tab>
		<rich:tab id="tab_ws" label="Current Working Set">
			<a4j:include id="include_ws" viewId="ws.jsp" />
		</rich:tab>
		<rich:tab id="tab_wss_moreoptions" label="Merge">
			<a4j:include viewId="wss-moreoptions.jsp" />
		</rich:tab>
	</rich:tabPanel>

	<rich:modalPanel id="ajaxLoadingModalBox" minHeight="50" minWidth="120"
		height="100" width="120" zindex="2000">
		<f:facet name="header">
			<h:outputText value="Sending Request ..."></h:outputText>
		</f:facet>
		<h:outputText value="Please wait ..."></h:outputText>
		<br />
		<br />&nbsp;&nbsp;&nbsp;
				<h:graphicImage value="/images/loader.gif" style="border:0" alt="loading ..."></h:graphicImage>
	</rich:modalPanel>
	<script type="text/javascript">
	var infoWindowAMShown = false;
	var infoWindowAMTimer;
	function showModalInfoWindow() {
		infoWindowAMTimer = setTimeout(
				"if(!infoWindowAMShown){Richfaces.showModalPanel('ajaxLoadingModalBox');infoWindowAMShown=true;}",
				500);
	}
	function hideModalInfoWindow() {
		if (infoWindowAMShown) {
			Richfaces.hideModalPanel('ajaxLoadingModalBox');
			infoWindowAMShown = false;
		} else {
			if (infoWindowAMTimer)
				clearTimeout(infoWindowAMTimer);
		}
	}
</script>
</f:view>
<%@ include file="/common/footer.jsp"%>