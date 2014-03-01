<cf_page title="Admission Students -Gender Pie Chart">
	
	<cfif isDefined("Form.report_year")>
		<cfset repYear = #Form.report_year#>
	<cfelse>
		<cfset repYear = 0>
	</cfif>

	<div>
		<div id="printDisplay">
			<input type="button" name="print" value="Print Report" class="button" onClick="printpage()"/>
		</div>
		<table>
			<tr>
				<td class="label">
					Report year: <cfoutput>#repYear#</cfoutput><br/>
				</td>
			</tr>
		</table>
		
		<cfquery name="QAdmData" datasource="DataReview">
			select distinct ProgramName from tblUkEPSBAdmData order by ProgramName
		</cfquery>
		
		<cfset loopCount=0>
	
		<div id="pieChartDisplay_GS">
			<table>
			
			<cfloop query="QAdmData">
				
				<cfif #repYear# NEQ "ALL">
					<cfquery name="QTot" datasource="DataReview">
						SELECT count(*) as T, ProgramName, Reportyear FROM tblUkEPSBAdmData
						WHERE Reportyear = "#repYear#" AND ProgramName = "#QAdmData.ProgramName#"
						GROUP BY ProgramName
					</cfquery>
				<cfelseif #repYear# EQ "ALL">
					<cfquery name="QTot" datasource="DataReview">
						SELECT count(*) as T, ProgramName, Reportyear FROM tblUkEPSBAdmData
						WHERE ProgramName = "#QAdmData.ProgramName#"
						GROUP BY ProgramName
					</cfquery>
				</cfif>
			
				<cfif #repYear# NEQ "ALL">			
					<cfquery name="QMale" datasource="DataReview">
						SELECT count(*) as M FROM tblUkEPSBAdmData
						WHERE Reportyear = "#repYear#" AND ProgramName = "#QAdmData.ProgramName#" AND Gender = "M"
						GROUP BY ProgramName
					</cfquery>
				<cfelseif #repYear# EQ "ALL">
					<cfquery name="QMale" datasource="DataReview">
						SELECT count(*) as M FROM tblUkEPSBAdmData
						WHERE ProgramName = "#QAdmData.ProgramName#" AND Gender = "M"
						GROUP BY ProgramName
					</cfquery>
				</cfif>
									
				<cfif #repYear# NEQ "ALL">
					<cfquery name="QFemale" datasource="DataReview">
						SELECT count(*) as F FROM tblUkEPSBAdmData
						WHERE Reportyear = "#repYear#" AND ProgramName = "#QAdmData.ProgramName#"  AND Gender = "F"
						GROUP BY ProgramName			
					</cfquery>
				<cfelseif #repYear# EQ "ALL">
					<cfquery name="QFemale" datasource="DataReview">
						SELECT count(*) as F FROM tblUkEPSBAdmData
						WHERE ProgramName = "#QAdmData.ProgramName#"  AND Gender = "F"
						GROUP BY ProgramName			
					</cfquery>
				</cfif>
								
				<cfif #QTot.recordcount# GT 0>
					<cfif loopCount MOD 2 EQ 0>
						<tr>
					</cfif>
					<cfset Males = #QMale.M#>
					<cfset Females = #QFemale.F#>
	
					<cfif #QFemale.recordcount# EQ 0>
						<cfset Females = 0>
					</cfif>
					<cfif #QMale.recordcount# EQ 0>
						<cfset Males = 0>
					</cfif>	
				
					<td>
						<cfoutput><b><i>Program Name : </i></b>#ProgramName#</cfoutput><br/><br/>
						<u>Total Records for this Program : <cfoutput>#QTot.T#</cfoutput>,</u> &nbsp;&nbsp;&nbsp; Male -
						<cfoutput>#Males#</cfoutput>, Female - <cfoutput>#Females#</cfoutput><br/>
							
						<cfchart fontBold="yes" fontSize="16" fontitalic="yes" chartheight="250" chartwidth="250">
						   <cfchartseries type="pie">
							  <cfchartdata item="Male" value="#Males#">
							  <cfchartdata item="Female" value="#Females#">
						   </cfchartseries>
						</cfchart>
					</td>
		  
					<cfif loopCount MOD 2 EQ 1>
					</tr>
				</cfif>
				
				<cfset loopCount=loopCount+1>
			</cfif>
				</cfloop>
			</table>
		</div>
	</cf_page>