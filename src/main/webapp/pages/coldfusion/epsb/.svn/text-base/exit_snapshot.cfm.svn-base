<cf_page title="Completion Report Snapshot">

	<cfif isDefined("Form.report_term")>
		<cfset repTerm = #Form.report_term#>
	<cfelse>
		<cfset repTerm = 0>
	</cfif>
	
	<cfquery name="QStuIden" datasource="DataReview">
			select ti.UID, ti.SID, FName, MName, LName, Suffix, Title, Gender, ta.ProgUID 
			from  tblIdentity as ti, tblTepadmission as ta, tblProgramprofile as tp, lstProgram as lp
			where tp.UID = ti.UID 
					and ta.ProgUID = tp.ProgUID 				   
				   	and tp.Statuscode = "COMPLETE"
				   	and tp.Anticipatedcompletionterm ="#repTerm#"
				   	and (tp.Programcode like '%-DI-%' or tp.Programcode like '%-CI-%')
				   	and lp.Programcode = tp.Programcode 
				   	and lp.Currency = "Current"
				   	and ta.Tepadmissioncode = 'ADMIT'   
				   	and ta.Primaryx <> 0 
			order by LName;	   
	</cfquery> 
		
<div id="outerbox">
		<div id="printDisplay">
			<input type="button" name="print" value="Print Report" class="button" onClick="printpage()"/>
		</div>
		<br/><br/>
		
		<div><tr><td>There are <cfoutput>#QStuIden.recordcount#</cfoutput> records for this report term: <cfoutput>#repTerm#</cfoutput></td></tr><br/><br/>
			<table class="displayData">
				<thead>
					<tr>
						<td width="100">SSN</td>
						<td width="250">Name</td>
						<td width="190">Program Code</td>
						<td width="150">Completion Term</td>
						<td width="100">Cumulative GPA</td>
						<td width="150">Program Status</td>
					</tr>
				</thead>
				<tbody>
					<cfif #QStuIden.recordcount# EQ 0>
						<cfoutput>
							<tr>
								<td colspan="8" align="center" width="700">There are no records for this report term</td>
							</tr>
						</cfoutput>
					<cfelse>
						<cfloop query="QStuIden">
							<cfquery name="QStuProg" datasource="DataReview">
								select tp.Statuscode, tp.Anticipatedcompletionterm, ta.Tepadmissiondate, 
									   ta.Overallgpa, tp.Programcode
								from   tblProgramprofile tp, tblTepadmission ta, lstProgram lp
								where      ta.Primaryx <> 0 
									   and ta.ProgUID = '#QStuIden.ProgUID#' 
									   and ta.ProgUID = tp.ProgUID 
									   and lp.Programcode = tp.Programcode; 
							</cfquery>
							
							<cfoutput>
								<tr>
									<td width="80">#QStuIden.SID#</td>
									<td width="250">#QStuIden.LName#, #QStuIden.FName# #QStuIden.MName#</td>
									<td width="100">#QStuProg.Programcode#</td>
									<td width="70">#QStuProg.Anticipatedcompletionterm#</td>
									<td width="60">#QStuProg.Overallgpa#</td>
									<td width="60">#QStuProg.Statuscode#</td>
								</tr>
							</cfoutput>
						</cfloop>
					</cfif>
				</tbody>
			</table><br/><br/>
		</div>
	</div>

</cf_page>