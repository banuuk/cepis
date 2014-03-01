<cf_page title="Admission Students, Demographic Information - Data Table">
	
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
				
	<cfif #repYear# NEQ "ALL">
		<cfquery name="QAdmData" datasource="DataReview">SELECT * FROM tblUkEPSBAdmData WHERE Reportyear = "#repYear#" order by "#order_by#"</cfquery>
	<cfelseif #repYear# EQ "ALL">
		<cfquery name="QAdmData" datasource="DataReview">SELECT * FROM tblUkEPSBAdmData order by "#order_by#"</cfquery>
	</cfif>
	
		<div>
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
						<td width="60">EPSB Person Identifier</td>
						<td width="60">SSN</td>
						<td width="220">Name</td>
						<td width="70">Birth Date</td>
						<td width="150">Present Mailing Address</td>
						<td width="150">Permanent Mailing Address</td>
						<td width="70">EMail</td>
						<td width="70">Program Name</td>
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
									<td width="60">#QAdmData.EPSBPersonIdentifier#</td>
									<td width="60">#QAdmData.SocialSecurityNumber#</td>
									<td width="220">#QAdmData.LastName#, #QAdmData.FirstName# #QAdmData.MiddleName#</td>
									<td width="70">#DateFormat(QAdmData.BirthDate, "MM/DD/YYYY")#</td>
									<td width="150">#QAdmData.PresentHomeMailing#</td>
									<td width="150">#QAdmData.PermanentHomeMailing#</td>
									<td width="60">#QAdmData.EMailAddress#</td>
									<td width="70">#QAdmData.ProgramName#</td>
								</tr>
							</cfoutput>
						</cfloop>
					</cfif>
				</tbody>
			</table><br/><br/>
		</div>
		
		</cf_page>