<link rel="STYLESHEET" type="text/css"
	href="${facesContext.externalContext.requestContextPath}/js/codebase/dhtmlxtabbar.css"/>
<script src="${facesContext.externalContext.requestContextPath}/js/codebase/dhtmlxcommon.js"></script>
<script src="${facesContext.externalContext.requestContextPath}/js/codebase/dhtmlxtabbar.js"></script>
<%@ include file="/common/header.jsp"%>
<TABLE bgcolor="#FFFFFF" border=0 cellpadding=0 cellspacing=0>
	<TR valign=top>
		<TD width=24></TD>
		<TD width=978>

		<h1 id="init_tabbar_from_script"></h1>
		<div id="a_tabbar" style="width: 978px; height: 640px;"></div>
		<script>
	tabbar = new dhtmlXTabBar("a_tabbar", "top");
	tabbar.setSkin('dhx_blue');
	tabbar.setImagePath("/cepis/js/codebase/imgs/");
	tabbar.addTab("a1", "Personal", "100px");
	tabbar.addTab("a2", "Email", "100px");
	tabbar.addTab("a3", "Address", "100px");
	tabbar.addTab("a4", "Phone", "100px");
	tabbar.addTab("a5", "Advising", "100px");
	tabbar.setHrefMode("iframes-on-demand");
	tabbar.setContentHref("a1", "Admin/optional-ajax-0.jsp");
	tabbar.setContentHref("a2", "Admin/optional-ajax-1.jsp");
	tabbar.setContentHref("a3", "Admin/optional-ajax-2.jsp");
	tabbar.setContentHref("a4", "Admin/optional-ajax-3.jsp");
	tabbar.setContentHref("a5", "Admin/optional-ajax-4.jsp");
	tabbar.setTabActive("a1");
</script></TD>
		<TD width=24></TD>
	</TR>
	<TR valign=top height=20>
		<TD width=24></TD>
		<TD width=978></TD>
		<TD width=24></TD>
	</TR>
</TABLE>
<%@ include file="/common/footer.jsp"%>