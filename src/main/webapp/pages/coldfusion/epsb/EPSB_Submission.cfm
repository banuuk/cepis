<cf_page title="Procedures for submitting admission and completion data reports to the EPSB via XML / Web Services.">

	<cfoutput>
		<link type="text/css" href="#application.webroot#/css/epsb.css" rel="stylesheet">
	</cfoutput>
	
	<cf_pagehead>
		<script type="text/javascript" src="#application.webroot#/js/epsb.js"></script>
	</cf_pagehead>
	
	<div id="tabsF">
		<ul>
			<li><a href="uk_data.cfm"><span>Pre-submission Data Check</span></a></li>
			<li id="current"><a href="EPSB_Submission.cfm"><span>EPSB Data Submission</span></a></li>
			<li><a href="view_report.cfm"><span>Post-submission Archive</span></a></li>
		</ul>
	</div>

	<div id="outerbox">
	<br/><br/><br/>
	<cfform name="EPSBreport">
		<table>
			<tr>
				<td class="label">
					With this module an operator will submit required data reports to the EPSB about UK students who have been admitted to or completed UK programs. <br/>
					These iterative procedures will result in "clean" data reports that have been both submitted to and accepted by the EPSB.<br/><br/>
				</td>
			</tr>		
			<tr>
				<td class="label">Select the term for which the report has to be generated and submitted to the EPSB : <em>*</em>
					<cfquery name="QTerm" datasource="DataReview">
						select * from lstTerm order by Termcode desc
					</cfquery>
					<!-- 	 
							This is the query used to limit only current 
							select * from lstTerm where Currency = 'Current' order by short_description desc
					-->
					<select name="term" class="select_dropdown" >
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
				
					<input name="adm_exit1" type="button" value="Generate & Submit (Completed)" class="button" onClick="submitEPSBCompleted()"/>
&nbsp;|&nbsp;<input name="adm_exit2" type="button" value="Generate & Submit (Lapsed)" class="button" onClick="submitEPSBLapsed()"/>
&nbsp;|&nbsp;<input name="adm_exit3" type="button" value="Generate & Submit (Depart)" class="button" onClick="submitEPSBDepart()"/>
&nbsp;|&nbsp;<input name="adm_exit4" type="button" value="Generate & Submit (Exclude)" class="button" onClick="submitEPSBExclude()"/>

				</td><br/>
			</tr>
		</table>
      </cfform>
	</div>
</cf_page>

