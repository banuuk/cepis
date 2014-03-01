<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
          "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:authz="http://www.springframework.org/security/tags">
	
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="keywords"
	content="cepis,portal,education,research,information,system" />
<meta http-equiv="description" content="CEPIS 2.x Information System." />
<meta name="copyright" content="&copy; 2012 University of Kentucky" />
<meta name="robots" content="NONE" />
<meta name="author" content="Keerthiram Murugesan" />
<meta http-equiv="expires" content="Mon, 16 Jun 2013 12:01:01 GMT" />
<title><ui:insert name="title">CEPIS Portal 2.0</ui:insert></title>
<link rel="shortcut icon"
	href="http://education.uky.edu/sites/all/themes/maincoesite/favicon.ico"
	type="image/x-icon" />
<link
	href="${facesContext.externalContext.requestContextPath}/css/font.css"
	media="screen" rel="stylesheet" type="text/css" />
<link
	href="${facesContext.externalContext.requestContextPath}/css/template.css"
	media="screen" rel="stylesheet" type="text/css" />
</head>

<body
	background="${facesContext.externalContext.requestContextPath}/images/pat2.jpg">
	<h:panelGrid width="100%" columns="1">
		<h:panelGrid width="98%" styleClass="layoutPanel">
			<ui:insert name="header">
				<h:panelGrid id="header" width="100%">
					<h:outputLink styleClass="layoutFooterLink"
						value="/cepis/about.cps" title="About CEPIS Center"
						target="_blank">
						<h:graphicImage alt="CEPIS Header" height="120px" width="100%"
							value="/images/head.png" styleClass="layoutHeaderImage"></h:graphicImage>
					</h:outputLink>
					<h:panelGroup id="headerNavigationSplit" layout="block"
						styleClass="layoutHeaderNavigationSplit"></h:panelGroup>
				</h:panelGrid>
			</ui:insert>
			<h:panelGrid width="100%" bgcolor="white">
				<ui:insert name="navigation">
					<h:panelGrid id="navigation" width="100%">
						<h:panelGroup id="menuObj" layout="block" styleClass="layoutMenu"></h:panelGroup>
						<h:panelGroup id="toolbarObj" layout="block"
							styleClass="layoutToolbar"></h:panelGroup>
					</h:panelGrid>
				</ui:insert>
				<h:panelGroup id="navigationTitleSplit" layout="block"
					styleClass="layoutSplit"></h:panelGroup>
				<ui:insert name="notification">
					<h:panelGrid id="notification" width="100%">
					</h:panelGrid>
				</ui:insert>
				<h:panelGrid id="pageMark" width="100%" columns="3"
					styleClass="layoutPageMark"
					columnClasses="layoutThreeEqualSplit,layoutThreeEqualSplit,layoutThreeEqualSplit">
					<h:panelGrid width="100%"></h:panelGrid>
					<h:panelGrid id="pageTitle" styleClass="layoutTitle1" width="100%">
						<ui:insert name="title">CEPIS PORTAL HOME</ui:insert>
					</h:panelGrid>
					<h:panelGrid id="socialAddOns" width="100%"
						style="text-align:right;">
						<div id="gplus" layout="block" align="right"
							style="width: 60px; display: inline-block;">
							<div class="g-plusone" data-size="medium"
								data-href="https://coesis.coe.uky.edu/cepis/index.cps"></div>
						</div>
						<div id="tweetme" layout="block" align="center"
							style="height: 20px; width: 130px; text-indent: 0pt; margin: 0pt; padding: 0pt; background: none repeat scroll 0% 0% transparent; border-style: none; line-height: normal; font-size: 1px; vertical-align: baseline; display: inline-block;">
							<a href="https://twitter.com/intent/tweet?button_hashtag=CEPISUK"
								class="twitter-hashtag-button"
								data-url="http://coesis.coe.uky.edu/cepis/index.cps">Tweet
								#CEPISUK</a>
						</div>
						<div align="left" class="fb-like"
							data-href="https://www.facebook.com/pages/College-of-Education-Student-Services-University-of-Kentucky/144658132249807"
							data-send="true" data-layout="button_count" data-width="0"
							data-show-faces="true"></div>
					</h:panelGrid>
				</h:panelGrid>
				<hr size="2" width="100%" class="layoutLineSeparator" />
				<ui:insert name="content">
					<h:panelGrid id="content" width="100%">
						<h:outputText>Welcome to CEPIS Web Portal.</h:outputText>
					</h:panelGrid>
				</ui:insert>
				<h:panelGroup id="contentFooterSplit" layout="block"
					styleClass="layoutSplit"></h:panelGroup>
				<hr size="2" width="100%" class="layoutLineSeparator" />
			</h:panelGrid>
			<ui:insert name="footer">
				<h:panelGrid id="footer" width="98%" styleClass="layoutFooter">
					<h:panelGrid id="copyrightInfo"
						columnClasses="layoutFooterDefaultFormat" width="100%">	&#169; 2012 UKY.EDU
					</h:panelGrid>
					<h:panelGrid id="ukyStatement"
						columnClasses="layoutFooterStatement" width="100%">
						<h:panelGroup>
							<h:outputLink styleClass="layoutFooterLink"
								value="http://education.uky.edu" title="College of Education">
								<f:verbatim>COLLEGE OF EDUCATION</f:verbatim>
							</h:outputLink>
							<h:panelGroup styleClass="layoutFooterSpacer" layout="block">|</h:panelGroup>
							<h:outputLink styleClass="layoutFooterLink"
								value="http://www.uky.edu" title="Go Wildcats!">
								<f:verbatim>UNIVERSITY OF KENTUCKY</f:verbatim>
							</h:outputLink>
							<h:panelGroup styleClass="layoutFooterSpacer" layout="block">|</h:panelGroup>
							<h:outputLink styleClass="layoutFooterLink"
								value="http://www.uky.edu/Home/Web/eo/" title="EO">
								<f:verbatim>AN EQUAL OPPURTUNITY UNIVERSITY</f:verbatim>
							</h:outputLink>
						</h:panelGroup>
					</h:panelGrid>
					<h:panelGrid width="100%" styleClass="layoutFooterDefaultFormat">
						<h:panelGroup>
							<h:outputLink styleClass="layoutFooterLink"
								value="/about-cepis.html" title="About CEPIS Center"
								target="_blank">
								<f:verbatim>ABOUT</f:verbatim>
							</h:outputLink>
							<h:panelGroup styleClass="layoutFooterSpacer" layout="block">|</h:panelGroup>

							<h:outputLink styleClass="layoutFooterLink" value="/trac/wiki"
								title="CEPIS TRAC Wiki" target="_blank">
								<f:verbatim>WIKI</f:verbatim>
							</h:outputLink>
							<h:panelGroup styleClass="layoutFooterSpacer" layout="block">|</h:panelGroup>

							<h:outputLink styleClass="layoutFooterLink"
								value="http://education.uky.edu/site/disclaimer"
								title="UKY COE Disclaimer" target="_blank">
								<f:verbatim>DISCLAIMER</f:verbatim>
							</h:outputLink>
							<h:panelGroup styleClass="layoutFooterSpacer" layout="block">|</h:panelGroup>

							<h:outputLink styleClass="layoutFooterLink"
								value="http://www.uky.edu/Graphics/webpolicy.htm"
								title="UKY Web Policy" target="_blank">
								<f:verbatim>WEB POLICY</f:verbatim>
							</h:outputLink>
							<h:panelGroup styleClass="layoutFooterSpacer" layout="block">|</h:panelGroup>

							<h:outputLink styleClass="layoutFooterLink" value="/trac/blog"
								title="CEPIS TRAC Blog" target="_blank">
								<f:verbatim>BLOG</f:verbatim>
							</h:outputLink>
							<h:panelGroup styleClass="layoutFooterSpacer" layout="block">|</h:panelGroup>

							<h:outputLink styleClass="layoutFooterLink"
								value="/trac/discussion" title="Discussion board"
								target="_blank">
								<f:verbatim>DISCUSSION</f:verbatim>
							</h:outputLink>
							<h:panelGroup styleClass="layoutFooterSpacer" layout="block">|</h:panelGroup>

							<h:outputLink styleClass="layoutFooterLink"
								value="http://education.uky.edu/AcadServ/"
								title="Contact TEB166 Office" target="_blank">
								<f:verbatim>CONTACT</f:verbatim>
							</h:outputLink>
							<h:panelGroup styleClass="layoutFooterSpacer" layout="block">|</h:panelGroup>

							<h:outputLink styleClass="layoutFooterLink"
								value="http://www.w3.org/WAI/changedesign.html" title=""
								target="_blank">
								<f:verbatim>ACCESSIBILITY</f:verbatim>
							</h:outputLink>
						</h:panelGroup>
						<h:panelGroup>
							<h:outputLink styleClass="layoutFooterLink"
								value="/trac/newticket"
								title="CEPIS TRAC {Bugs, Comments, Feedback}" target="_blank">
								<f:verbatim>DISSATISFIED? HELP US TO IMPROVE</f:verbatim>
							</h:outputLink>
						</h:panelGroup>
					</h:panelGrid>
				</h:panelGrid>
			</ui:insert>
		</h:panelGrid>
	</h:panelGrid>

	<!-- Social Add-on Scripts -->
	<!-- Google +1 button -->
	<script type="text/javascript">
		(function() {
			var po = document.createElement('script');
			po.type = 'text/javascript';
			po.async = true;
			po.src = 'https://apis.google.com/js/plusone.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(po, s);
		})();
	</script>
	<div id="fb-root"></div>
	<script type="text/javascript">
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/all.js#xfbml=1";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>
	<!-- Twitter Hashtag buuton -->
	<script type="text/javascript">
		!function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (!d.getElementById(id)) {
				js = d.createElement(s);
				js.id = id;
				js.src = "//platform.twitter.com/widgets.js";
				fjs.parentNode.insertBefore(js, fjs);
			}
		}(document, "script", "twitter-wjs");
	</script>
	<!-- Web Traffic Analysis -->
	<!-- Google Analytics -->
	<script type="text/javascript">
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-6429061-3' ]);
		_gaq.push([ '_trackPageview' ]);

		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://ssl'
					: 'http://www')
					+ '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	</script>
</body>

</html>