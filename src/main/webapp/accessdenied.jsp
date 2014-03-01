<script type="text/javascript">
	document.title = "Access Denied";
</script>
<%@ include file="/common/header.jsp"%>
&nbsp;&nbsp;&nbsp;&nbsp;
<font class="ws12" color="#062E8A" face="Tahoma"> Access to this
resource/page is restricted to <b>authorized</b> users only. Try login
again or contact TEB 166. </font>
<br />
<br />
<br />
<hr />

<font class="ws10" face="Tahoma"><a href="/cepis/pages/index.cps"
	title="My Home" target="_self" class="style1"> Home </a></font>
&nbsp;&nbsp;|&nbsp;&nbsp;
<font class="ws10" face="Tahoma"><a
	href="/cepis/pages/cp/index.cps" title="My Profile" target="_self"
	class="style1"> Control Panel </a></font>
|&nbsp;&nbsp;
<font class="ws10" face="Tahoma"><a
	href="${facesContext.externalContext.requestContextPath}/j_spring_security_logout" title="Log me out"
	target="_self" class="style1"> Log out </a></font>

<%@ include file="/common/footer.jsp"%>