<cf_page title="Admission Students, Demographic Information">

	<cfif isDefined("Form.report_term")>
		<cfset repTerm = #Form.report_term#>
	<cfelse>
		<cfset repTerm = 0>
	</cfif>
	
	<cfquery name="QStuIden" datasource="DataReview">
			SELECT tblIdentity.SID, tblIdentity.UID, tblIdentity.LName, tblIdentity.FName, tblIdentity.MName, tblIdentity.Title, 
				   tblTepadmission.Termcode, tblIdentity.Gender, lstEthnic.KYethniccode, tblPersonal.Birth				   
			FROM   (((
					 (tblIdentity INNER JOIN tblProgramprofile ON tblIdentity.UID = tblProgramprofile.UID) 
					 INNER JOIN tblPersonal ON tblIdentity.UID = tblPersonal.UID) 
					 INNER JOIN lstEthnic ON tblPersonal.Ethniccode = lstEthnic.Ethniccode) 
					 INNER JOIN lstUkmajor ON tblProgramprofile.Ukmajorcode = lstUkmajor.Ukmajorcode) 
					 INNER JOIN tblTepadmission ON tblProgramprofile.ProgUID = tblTepadmission.ProgUID
					 INNER JOIN lstProgram ON lstProgram.programcode = tblProgramprofile.programcode
			WHERE (     ((tblTepadmission.Tepadmissioncode)="ADMIT" or (tblTepadmission.Tepadmissioncode)="DENIED") 
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
							<cfquery name="QStuOtherInfo" datasource="DataReview">
								select birth, ethniccode, Computeraddress
								from tblPersonal as tp, tblComputer as tc
								where tp.UID = '#QStuIden.UID#' and tc.UID = tp.UID and tc.Computertypecode = 'UKY'
							</cfquery>	
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
							<!---</cfloop>--->
						</cfloop>
					</cfif>
				</tbody>
			</table><br/><br/>
		</div>
	</div>

</cf_page>