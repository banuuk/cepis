<cf_page title="Completer Students, Demographic Information">

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
				<!---and tp.Anticipatedcompletionterm between #reportyr1# and #reportyr2#---> 
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
						<td width="80">SSN</td>
						<td width="220">Name</td>
						<td width="200">Present Mailing Address</td>
						<td width="200">Permanent Mailing Address</td>
						<td width="50">Birth Date</td>
						<td width="40">Gender</td>
						<td width="40">Ethnicity</td>
						<td width="60">E-Mail</td>						
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
							<cfquery name="QStuAddrPerm" datasource="DataReview">
								select StrLine1, StrLine2, City, State, Zip, Country, Addresstypecode
								from tblIdentity as ti, tblAddress as ta
								where ta.UID = '#QStuIden.UID#' and ti.UID = ta.UID and ta.Addresstypecode = "Permanent"
							</cfquery>
							<cfquery name="QStuAddrMail" datasource="DataReview">
								select StrLine1, StrLine2, City, State, Zip, Country, Addresstypecode
								from tblIdentity as ti, tblAddress as ta
								where ta.UID = '#QStuIden.UID#' and ti.UID = ta.UID and ta.Addresstypecode = "Mailing"
							</cfquery>
							<cfquery name="QStuOtherInfo" datasource="DataReview">
								select birth, ethniccode, Computeraddress
								from tblPersonal as tp, tblComputer as tc
								where tp.UID = '#QStuIden.UID#' and tc.UID = tp.UID and tc.Computertypecode = 'UKY'
							</cfquery>	
							<cfoutput>
								<tr>
									<td width="80">#QStuIden.SID#</td>
									<td width="210">#QStuIden.LName#, #QStuIden.FName# #QStuIden.MName#</td>
									<td width="200">#QStuAddrPerm.StrLine1# #QStuAddrPerm.StrLine2#, #QStuAddrPerm.City# #QStuAddrPerm.State# #QStuAddrPerm.Zip# #QStuAddrPerm.Country#</td>
									<td width="210">#QStuAddrMail.StrLine1# #QStuAddrMail.StrLine2#, #QStuAddrMail.City# #QStuAddrMail.State# #QStuAddrMail.Zip# #QStuAddrMail.Country#</td>
									<td width="50">#DateFormat(QStuOtherInfo.Birth, "MM/DD/YYYY")#</td>
									<td width="40">#QStuIden.Gender#</td>
									<td width="40">#QStuOtherInfo.Ethniccode#</td>
									<td width="60">#QStuOtherInfo.Computeraddress#</td>
								</tr>
							</cfoutput>
						</cfloop>
					</cfif>
				</tbody>
			</table><br/><br/>
		</div>
	</div>
</cf_page>