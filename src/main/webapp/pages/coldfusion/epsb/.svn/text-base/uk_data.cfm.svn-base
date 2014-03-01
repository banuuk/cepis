
<cf_page title="Review Data from the main database prior to submitting data reports to the EPSB">
	<cfoutput>
		<link type="text/css" href="#application.webroot#/css/epsb.css" rel="stylesheet">
	</cfoutput>
	
	<cf_pagehead>
		<script type="text/javascript" src="#application.webroot#/js/epsb.js"></script>
	</cf_pagehead>

	<div id="tabsF">
		<ul>
			<li id="current"><a href="uk_data.cfm"><span>Pre-submission Data Check</span></a></li>
			<li><a href="EPSB_Submission.cfm"><span>EPSB Data Submission</span></a></li>
			<li><a href="view_report.cfm"><span>Post-submission Archive</span></a></li>
		</ul>
	</div>

	<div id="outerbox">
	<cfform name="uk_report"><br/><br/><br/>
		<table>
			<tr>
				<td class="label">
					In this module, the operator can run the EPSB data report queries without actually submitting data to the EPSB. <br/>
					Resulting displays will allow the operator to identify any missing or problem data which can then be corrected for submission.<br/><br/>
				</td>
			</tr>
			<tr>
				<td class="label"><em>*</em>Select the report term :     
					<cfquery name="QTerm" datasource="DataReview">
						select * from lstTerm order by Termcode desc
					</cfquery>
					<select name="report_term" class="select_dropdown" >
						<option value="nil" selected>--Select a Term--</option>
						<cfoutput query="QTerm">
					  		<option value="#Termcode#">#short_description#</option>
						</cfoutput>
					</select><br/><br/>
				</td>
			</tr>
			
		</table>
		<table>
			<tr>
				<td>
					<input name="demogAdm" type="button" value="Admissions Demographic Data" class="button" onClick="submit_(demogAdm)"/>
					<input name="adm" type="button" value="Admissions Report Snapshot" class="button" onClick="submit_(adm)"/>
				</td>
				<td>
					<input name="demogExit" type="button" value="Completion Demographic Data" class="button" onClick="submit_(demogExit)"/>
					<input name="exit" type="button" value="Completion Report Snapshot" class="button" onClick="submit_(exit)"/>
				</td><br/>
			</tr>
		</table>
		<br/><br/><br/>		
	</cfform>
	</div>
</cf_page>


