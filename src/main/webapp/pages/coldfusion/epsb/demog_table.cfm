<cf_page title="Student demographic Information">
	
	<cfif isDefined("Form.report_year")>
		<cfset repYear = #Form.report_year#>
	<cfelse>
		<cfset repYear = 0>
	</cfif>
	
	<cfquery name="QAdmData" datasource="DataReview">SELECT * FROM tblUkEPSBAdmData WHERE Reportyear = "#repYear#"</cfquery>
	
	<div id="outerbox">
		<div id="printDisplay">
			<input type="button" name="print" value="Print Report" class="button" onClick="printpage()"/>
		</div>
		<br/><br/>
		
		<div><tr><td>There are <cfoutput>#QAdmData.recordcount#</cfoutput> records for this report term: <cfoutput>#repYear#</cfoutput></td></tr><br/><br/>
			<table class="displayData">
				<thead>
					<tr>
						<td width="80">EPSB Person Identifier</td>
						<td width="80">SSN</td>
						<td width="200">Name</td>
						<td width="80">E-Mail</td>
						<td width="80">Birth Date</td>
						<td width="200">Present Mailing Address</td>
						<td width="120">Permanent Mailing Address</td>
						<td width="70">Phone Number</td>
					</tr>
				</thead>
				<tbody>
					<cfif #QAdmData.recordcount# EQ 0>
						<cfoutput>
							<tr>
								<td colspan="8" align="center" width="700">There are no records for this report year</td>
							</tr>
						</cfoutput>
					<cfelse>
						<cfloop query="QAdmData">
							<cfoutput>
								<tr>
									<td width="80">#QAdmData.EPSBPersonIdentifier#</td>
									<td width="80">#QAdmData.SocialSecurityNumber#</td>
									<td width="180">#QAdmData.LastName#, #QAdmData.FirstName# #QAdmData.MiddleName#</td>
									<td width="100">#QAdmData.EMailAddress#</td>
									<td width="80">#DateFormat(QAdmData.BirthDate, "MM/DD/YYYY")#</td>
									<td width="200">#QAdmData.PresentHomeMailing#</td>
									<td width="120">#QAdmData.PermanentHomeMailing#</td>
									<td width="70">#QAdmData.PhoneNumber#</td>
								</tr>
							</cfoutput>
						</cfloop>
					</cfif>
				</tbody>
			</table><br/><br/>
		</div>
	</div>
</cf_page>