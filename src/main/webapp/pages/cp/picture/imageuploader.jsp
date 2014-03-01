<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<style>
.top {
	vertical-align: top;
}

.info {
	height: 202px;
	overflow: auto;
}
</style>
<f:subview id="profile_picture">
	<br />
	<h3>CEPIS Profile Picture Uploader</h3>
	<h:form>
		<h:panelGrid columns="2" columnClasses="top,top">
			<rich:fileUpload fileUploadListener="#{fileUploadBean.listener}"
				maxFilesQuantity="#{fileUploadBean.uploadsAvailable}" id="upload"
				immediateUpload="#{fileUploadBean.autoUpload}" acceptedTypes="jpg"
				noDuplicate="true" allowFlash="#{fileUploadBean.useFlash}">
				<f:facet name="label">
					<h:outputText value="{_KB}KB from {KB}KB uploaded --- {mm}:{ss}" />
				</f:facet>
				<a4j:support event="onuploadcomplete" reRender="info" />
			</rich:fileUpload>
			<h:panelGroup id="info">
				<rich:panel bodyClass="info">
					<f:facet name="header">
						<h:outputText value="Uploaded Files Info" />
					</f:facet>
					<h:outputText value="No files currently uploaded"
						rendered="#{fileUploadBean.size==0}" />
					<rich:dataGrid columns="1" value="#{fileUploadBean.files}"
						var="file" rowKeyVar="row">
						<rich:panel bodyClass="rich-laguna-panel-no-header">
							<h:panelGrid columns="2">
								<a4j:mediaOutput element="img" mimeType="#{file.mime}"
									createContent="#{fileUploadBean.paint}" value="#{row}"
									style="width:100px; height:100px;" cacheable="false">
									<f:param value="#{fileUploadBean.timeStamp}" name="time" />
								</a4j:mediaOutput>
								<h:panelGrid columns="2">
									<h:outputText value="File Name:" />
									<h:outputText value="#{file.name}" />
									<h:outputText value="File Length(bytes):" />
									<h:outputText value="#{file.length}" />
								</h:panelGrid>
							</h:panelGrid>
						</rich:panel>
					</rich:dataGrid>
				</rich:panel>
				<rich:spacer height="3" />
				<br />
				<a4j:commandButton action="#{fileUploadBean.clearUploadData}"
					reRender="info, upload" value="Clear Uploaded Data"
					rendered="#{fileUploadBean.size>0}" />
			</h:panelGroup>
		</h:panelGrid>
	</h:form>
</f:subview>