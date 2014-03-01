<cf_page title="Completer Students - Statistics By Program">
	
	<cfif isDefined("Form.report_year")>
		<cfset repYear = #Form.report_year#>
	<cfelse>
		<cfset repYear = 0>
	</cfif>

	<cfif #repYear# NEQ "ALL">
		<cfquery name="QExitData" datasource="DataReview">
		select count(*) as C, avg(ExitGPA) as Avg, max(ExitGPA) as Max, Min(ExitGPA) as Min, ProgramName, Reportyear, ProgramCode, ProgramType 
		from tblUkEPSBExitData 
		WHERE Reportyear = "#repYear#" 
		Group By ProgramName 
		order by ProgramName
		</cfquery>
	<cfelseif #repYear# EQ "ALL">
		<cfquery name="QExitData" datasource="DataReview">
			select count(*) as C, avg(ExitGPA) as Avg, max(ExitGPA) as Max, Min(ExitGPA) as Min, ProgramName, Reportyear, ProgramCode, ProgramType 
			from tblUkEPSBExitData 
			Group By ProgramName 
			order by ProgramName
		</cfquery>
	</cfif>	
	
	
		<div>
		<div id="printDisplay">
			<input type="button" name="print" value="Print Report" class="button" onClick="printpage()"/>
		</div>
			<tr><td class="label">Total Number of Programs : <cfoutput>#QExitData.recordcount#</cfoutput> <br/>
					Report year: <cfoutput>#repYear#</cfoutput><br/><br/><br/>
					</td>
			</tr>
			<table class="displayData">
				<thead>
					<tr>
						<td width="90">Program Code</td>
						<td width="200">Program Type</td>
						<td width="200">Program Name</td>
						<td width="100">Number of Students</td>
						<td width="90">Average GPA</td>
						<td width="90">Highest GPA</td>
						<td width="90">Lowest GPA</td>
					</tr>
				</thead>
				<tbody>
					<cfif #QExitData.recordcount# EQ 0>
						<cfoutput>
							<tr>
								<td colspan="8" align="center" width="700">There are no records for this report year</td>
							</tr>
						</cfoutput>
					<cfelse>
						<cfloop query="QExitData">
							<cfoutput>
								<tr>
									<td>#QExitData.ProgramCode#</td>
									<td>#QExitData.ProgramType#</td>
									<td>#QExitData.ProgramName#</td>
									<td>#QExitData.C#</td>
									<td>#NumberFormat(QExitData.Avg, '___.__')#</td>
									<td>#QExitData.Max#</td>
									<td>#QExitData.Min#</td>
								</tr>
							</cfoutput>
						</cfloop>
					</cfif>
				</tbody>
			</table><br/><br/>
		</div>
		
		</cf_page>