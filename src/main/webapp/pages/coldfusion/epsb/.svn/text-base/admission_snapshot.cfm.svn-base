<cf_page title="Admissions Report Snapshot">

	<cfif isDefined("Form.report_term")>
		<cfset repTerm = #Form.report_term#>
	<cfelse>
		<cfset repTerm = 0>
	</cfif>
	
	<cfquery name="QStuIden" datasource="DataReview">
			SELECT 	tblIdentity.SID, tblIdentity.UID, tblIdentity.LName, tblIdentity.FName, tblIdentity.MName, 
					tblTepadmission.Termcode, tblTepadmission.Tepadmissioncode, lstEthnic.KYethniccode, 
					tblTepadmission.Writtencommunication, tblProgramprofile.Ukmajorcode, tblProgramprofile.ProgUID, 
					tblTepadmission.Testtype, tblTepadmission.Overallgpa, tblTepadmission.Totalhours
			FROM   (((
					 (tblIdentity INNER JOIN tblProgramprofile ON tblIdentity.UID = tblProgramprofile.UID) 
					 INNER JOIN tblPersonal ON tblIdentity.UID = tblPersonal.UID) 
					 INNER JOIN lstEthnic ON tblPersonal.Ethniccode = lstEthnic.Ethniccode) 
					 INNER JOIN lstUkmajor ON tblProgramprofile.Ukmajorcode = lstUkmajor.Ukmajorcode) 
					 INNER JOIN tblTepadmission ON tblProgramprofile.ProgUID = tblTepadmission.ProgUID
					 INNER JOIN lstProgram ON lstProgram.programcode = tblProgramprofile.programcode
			WHERE (     ((tblTepadmission.Tepadmissioncode)="ADMIT") 
				    AND ((tblTepadmission.Termcode)="#repTerm#") 
			        AND ((tblTepadmission.Primaryx)=-1 Or (tblTepadmission.Primaryx)=1)
					AND lstProgram.currency = "CURRENT"
					AND tblTepadmission.Primaryx <> 0
				  )
			order by LName
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
						<td width="120">Program Code</td>
						<td width="120">Date of Admission</td>
						<td width="100">Estimated Graduation Date</td>
						<!---<td width="40">Certification_Code</td>--->
						<td width="100">Hours Completed</td>
						<td width="100">Cumulative GPA</td>
						<td width="60">TEP Admission Status</td>
						<td width="60">Program Status</td>
						<!---<td width="60">Assessment_Code</td>
						<td width="60">Assessment_Score</td>
						<td width="60">Assessment_Date</td>--->
					</tr>
				</thead>
				<tbody>
					<cfif #QStuIden.recordcount# EQ 0>
						<cfoutput>
							<tr>
								<td colspan="9" align="center" width="700">There are no records for this report term</td>
							</tr>
						</cfoutput>
					<cfelse>
						<cfloop query="QStuIden">
							<cfquery name="QStuProg" datasource="DataReview">
								select lp.EPSBProgramcode1, lp.EPSBProgramcode2, lp.Certificate1, lp.Certificate2, 
										tp.Anticipatedcompletionterm, ta.Tepadmissiondate, 
									   lp.Routetype, ta.Totalhours, ta.Overallgpa, tp.Statuscode, ta.Tepadmissioncode, tp.Programcode
								from   tblProgramprofile tp, tblTepadmission ta, lstProgram lp
								where      ta.Primaryx <> 0 
									   and ta.ProgUID = '#QStuIden.ProgUID#' 
									   and ta.ProgUID = tp.ProgUID 
									   and lp.Programcode = tp.Programcode
							</cfquery>
							
							<cfoutput>
								<tr>
									<td width="80">#QStuIden.SID#</td>
									<td width="250">#QStuIden.LName#, #QStuIden.FName# #QStuIden.MName#</td>
									<td width="100">#QStuProg.Programcode#</td>
									<td width="70">#DateFormat(QStuProg.Tepadmissiondate, "MM/DD/YYYY")#</td>
									<td width="70">#QStuProg.Anticipatedcompletionterm#</td>
									<!---<td width="40">Certification_Code</td>--->
									<td width="70">#QStuProg.Totalhours#</td>
									<td width="60">#QStuProg.Overallgpa#</td>
									<td width="60">#QStuProg.Tepadmissioncode#</td>
									<td width="60">#QStuProg.Statuscode#</td>
									<!---td width="60">Assessment_Code</td><td width="60">Assessment_Score</td><td width="60">Assessment_Date</td>--->
								</tr>
							</cfoutput>
						</cfloop>
					</cfif>
				</tbody>
			</table><br/><br/>
		</div>
	</div>

</cf_page>