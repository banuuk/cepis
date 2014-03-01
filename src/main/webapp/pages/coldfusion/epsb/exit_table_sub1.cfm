<cf_page title="Completion data filed with the EPSB">

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
	
	<cfquery name="QExitData" datasource="DataReview">SELECT * FROM tblUkEPSBExitData WHERE Reportyear = "#repYear#" order by #order_by#</cfquery>
		
	<div id="outerbox">
		<div id="printDisplay">
			<input type="button" name="print" value="Print Report" class="button" onClick="printpage()"/>
		</div>
		<div>
			<table>
				<tr>
					<td class="label">Record count : <cfoutput>#QExitData.recordcount#</cfoutput> <br/>
					Report year: <cfoutput>#repYear#</cfoutput><br/>
					Sorted By : <cfoutput>#order_by#</cfoutput><br/><br/>
					</td>
				</tr>
			</table>
			<table class="displayData">
				<thead>
					<tr>
						<td width="50">EPSB PersonId</td>
						<td width="50">SSN</td>
						<td width="200">Name</td>
						<td width="50">Praxis ID</td>
						<td width="70">Exit Reason</td>
						<td width="40">Program Exit Date</td>
						<td width="40">Exit GPA</td>
						<td width="60">Program Code</td>
						<td width="60">Program Type</td>
						<td width="100">Program Name</td>
						<td width="40">Cert Codes</td>									
					</tr>
				</thead>
				<tbody>
					<cfif #QExitData.recordcount# EQ 0>
						<cfoutput>
							<tr>
								<td colspan="11" align="center" width="700">There are no records for this report year</td>
							</tr>
						</cfoutput>
					<cfelse>
						<cfloop query="QExitData">
							<cfoutput>
								<tr>
									<td width="80">#QExitData.EPSBPersonIdentifier#</td>
									<td width="80">#QExitData.SocialSecurityNumber#</td>
									<td width="180">#QExitData.LastName#, #QExitData.FirstName# #QExitData.MiddleName#</td>
									<td width="100">#QExitData.PraxisID#</td>
									<td width="80">#QExitData.ExitReason#</td>
									<td width="200">#DateFormat(QExitData.ProgramExitDate, "MM/DD/YYYY")#</td>
									<td width="120">#QExitData.ExitGPA#</td>
									<td width="70">#QExitData.ProgramCode#</td>
									<td width="70">#QExitData.ProgramType#</td>
									<td width="70">#QExitData.ProgramName#</td>
									<td width="70">#QExitData.CredCodes#</td>																																
								</tr>
							</cfoutput>
						</cfloop>
					</cfif>
				</tbody>
			</table><br/><br/>
		</div>
	</div>
</cf_page>