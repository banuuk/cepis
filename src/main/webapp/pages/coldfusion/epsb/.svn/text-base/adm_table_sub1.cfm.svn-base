<cf_page title="Admissions data filed with the EPSB">

	<cfif isDefined("Form.report_year")>
		<cfset repYear = #Form.report_year#>
	<cfelse>
		<cfset repYear = 0>
	</cfif>
	<cfif isDefined("Form.sort")>
		<cfset order_by = #Form.sort#>
	<cfelse>
		<cfset order_by = "">
	</cfif>		

	<cfquery name="QAdmData" datasource="DataReview">SELECT * FROM tblUkEPSBAdmData WHERE Reportyear = "#repYear#" order by #order_by#</cfquery>
	
	<div>
	<div id="printDisplay">
			<input type="button" name="print" value="Print Report" class="button" onClick="printpage()"/>
		</div>
			<table>
				<tr>
					<td class="label">Record count : <cfoutput>#QAdmData.recordcount#</cfoutput> <br/>
					Report year: <cfoutput>#repYear#</cfoutput><br/>
					Sorted By : <cfoutput>#order_by#</cfoutput><br/><br/>
					</td>
				</tr>
				
			</table>

			<table class="displayData">
				<thead>
					<tr>
						<td width="60">EPSB PersonId</td>
						<td width="60">SSN</td>
						<td width="200">Name</td>
						<td width="50">Admission Date</td>
						<td width="40">GPA</td>
						<td width="40" align="center">Total Hours Prior To Admission</td>
						<td width="60">Program Code</td>
						<td width="800">Program Type</td>
						<td width="120">Program Name</td>
						<td width="60">Cert Codes</td>
						<td width="200">Assessments</td>												
					</tr>
				</thead>
				<tbody>
					<cfif #QAdmData.recordcount# EQ 0>
						<cfoutput>
							<tr>
								<td colspan="11" align="center" width="700">There are no records for this report year</td>
							</tr>
						</cfoutput>
					<cfelse>
						<cfloop query="QAdmData">
							<cfoutput>
								<tr>
									<td width="80">#QAdmData.EPSBPersonIdentifier#</td>
									<td width="80">#QAdmData.SocialSecurityNumber#</td>
									<td width="180">#QAdmData.LastName#, #QAdmData.FirstName# #QAdmData.MiddleName#</td>
									<td width="100">#DateFormat(QAdmData.AdmissionDate, "MM/DD/YYYY")#</td>
									<td width="80">#QAdmData.GPA#</td>
									<td width="200">#QAdmData.TotalHoursPriorToAdmission#</td>
									<td width="120">#QAdmData.ProgramCode#</td>
									<td width="70">#QAdmData.ProgramType#</td>
									<td width="70">#QAdmData.ProgramName#</td>
									<td width="70">#QAdmData.CredCodes#</td>
									<td width="70">#QAdmData.Assessment#</td>																											
								</tr>
							</cfoutput>
						</cfloop>
					</cfif>
				</tbody>
			</table><br/><br/>
		</div>
</cf_page>