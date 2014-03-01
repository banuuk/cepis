<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<link href="${facesContext.externalContext.requestContextPath}/css/datascroller.css"
	media="screen" rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/font.css" media="screen"
	rel="stylesheet" type="text/css"/>
<link href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css"/>
<f:view>
	<br />
	<h:message for="program_manager">
	</h:message>
	<h:form id="program_manager">
		<div align=left><font class="ws10" color="#062E8A" face="Tahoma"><h:outputText
			value="Show" />&nbsp; <h:inputText
			value="#{cepisConfigurationManager.rowCount}" size="4" /> &nbsp;<h:commandButton
			value="programs">
		</h:commandButton> </font></div>
		<h:panelGroup id="body">
			<t:dataTable id="scrollList" styleClass="scrollTable"
				headerClass="head1" rowClasses="normalRow,alternateRow" width="100%"
				columnClasses="standardTable_Column,standardTable_Column,standardTable_ColumnCentered,standardTable_Column"
				var="program"
				value="#{cepisGlobalComponentConfigurator.programList}"
				preserveDataModel="false" rows="#{cepisConfigurationManager.rowCount}">
				<h:column>
					<f:facet name="header">
						<h:outputText value="#CODE" />
					</f:facet>
					<h:outputText value="#{program.programCode}"></h:outputText>
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Program name" />
					</f:facet>
					<h:outputText value="#{program.shortDesc}"></h:outputText>
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Program Description" />
					</f:facet>
					<h:outputText value="#{program.description}"></h:outputText>
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Status" />
					</f:facet>
					<h:outputText value="#{program.status}"></h:outputText>
				</h:column>
			</t:dataTable>
		</h:panelGroup>
		<h:panelGrid id="scrollers" columns="1" styleClass="scrollerTable2"
			columnClasses="standardTable_ColumnCentered">
			<t:dataScroller id="scroll_0" for="scrollList"
				rowsCountVar="rowsCount"
				displayedRowsCountVar="displayedRowsCountVar"
				firstRowIndexVar="firstRowIndex" lastRowIndexVar="lastRowIndex"
				pageCountVar="pageCount" immediate="true" pageIndexVar="pageIndex">
				<h:outputFormat
					value="{0} programs available, displaying {1} programs, from {2} to {3}. Page {4} / {5}"
					styleClass="standard">
					<f:param value="#{rowsCount}" />
					<f:param value="#{displayedRowsCountVar}" />
					<f:param value="#{firstRowIndex}" />
					<f:param value="#{lastRowIndex}" />
					<f:param value="#{pageIndex}" />
					<f:param value="#{pageCount}" />
				</h:outputFormat>
			</t:dataScroller>
			<t:dataScroller id="scroll_1" for="scrollList" fastStep="10"
				pageCountVar="pageCount" pageIndexVar="pageIndex"
				styleClass="scroller" paginator="true" paginatorMaxPages="9"
				paginatorTableClass="paginator"
				paginatorActiveColumnStyle="font-weight:bold;" immediate="true">
				<f:facet name="first">
					<t:graphicImage url="/images/arrow-first.gif" border="1" />
				</f:facet>
				<f:facet name="last">
					<t:graphicImage url="/images/arrow-last.gif" border="1" />
				</f:facet>
				<f:facet name="previous">
					<t:graphicImage url="/images/arrow-previous.gif" border="1" />
				</f:facet>
				<f:facet name="next">
					<t:graphicImage url="/images/arrow-next.gif" border="1" />
				</f:facet>
				<f:facet name="fastforward">
					<t:graphicImage url="/images/arrow-ff.gif" border="1" />
				</f:facet>
				<f:facet name="fastrewind">
					<t:graphicImage url="/images/arrow-fr.gif" border="1" />
				</f:facet>
			</t:dataScroller>
		</h:panelGrid>
	</h:form>
</f:view>