<cf_page title="Access to archives of admission and completion data submitted to and approved by the EPSB">

	<cfoutput>
		<link type="text/css" href="#application.webroot#/css/epsb.css" rel="stylesheet">
	</cfoutput>
	
	<cf_pagehead>
		<script type="text/javascript" src="/js/epsb.js"></script>
	</cf_pagehead>

	<div id="tabsF">
		<ul>
			<li><a href="uk_data.cfm"><span>Pre-submission Data Check</span></a></li>
			<li><a href="EPSB_Submission.cfm"><span>EPSB Data Submission</span></a></li>
			<li id="current"><a href="view_report.cfm"><span>Post-submission Archive</span></a></li>
		</ul>
	</div>

	<div id="outerbox">
		<br/><br/><br/>
	<cfform name="view_report">
		<table>
			<tr>
				<td class="label">
					This module provides access to "clean" data reports that have been submitted to and accepted by the EPSB, and then added to the Unit database.<br/>
					This "snapshot" archived data in the regular unit database format is useful for a variety of planning and reporting purposes.<br/><br/>
				</td>
			</tr>

			<tr>
				<td>
					<input name="demogA" type="button" value="Admissions Demograhic Data" class="button" onClick="submitform_(demogA)"/>
					<input name="demogE" type="button" value="Completion Demograhic Data" class="button" onClick="submitform_(demogE)"/>						
					<input name="adm" type="button" value="Admissions Data" class="button" onClick="submitform_(adm)"/>
					<input name="exit" type="button" value="Completers Data" class="button" onClick="submitform_(exit)"/>
				</td><br/>
			</tr>
		</table>
		<br/><br/><br/>
		
	</cfform>
	</div>
</cf_page>


