<cf_page title="Completer Students - GPA Line Chart">
	
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
		<cfquery name="QExitData" datasource="DataReview">
		select distinct ProgramName
		from tblUkEPSBExitData order by ProgramName
		</cfquery>
		
		<div id="pieChartDisplay_GS">
			<table>
			<cfloop query="QExitData">
				<cfif #repYear# NEQ "ALL">
					<cfquery name="QData" datasource="DataReview">
						select count(*) as Total , avg(ExitGPA) as Avg, max(ExitGPA) as Max, Min(ExitGPA) as Min, ProgramName, Reportyear 
						from tblUkEPSBExitData 
						WHERE Reportyear = "#repYear#"  AND ProgramName = "#QExitData.ProgramName#"
						Group By ProgramName
					</cfquery>
				<cfelseif #repYear# EQ "ALL">
					<cfquery name="QData" datasource="DataReview">
						select count(*) as Total , avg(ExitGPA) as Avg, max(ExitGPA) as Max, Min(ExitGPA) as Min, ProgramName, Reportyear 
						from tblUkEPSBExitData 
						WHERE ProgramName = "#QExitData.ProgramName#"
						Group By ProgramName
					</cfquery>
				</cfif>
				
				<cfif #repYear# NEQ "ALL">
					<cfquery name="QGPA" datasource="Datareview">
						Select ExitGPA as Xaxis, count(*) as Yaxis from tblUkEPSBExitData
						WHERE Reportyear = "#repYear#"  AND ProgramName = "#QExitData.ProgramName#"
						Group By ExitGPA
					</cfquery>
				<cfelseif #repYear# EQ "ALL">
					<cfquery name="QGPA" datasource="Datareview">
						Select ExitGPA as Xaxis, count(*) as Yaxis from tblUkEPSBExitData
						WHERE ProgramName = "#QExitData.ProgramName#"
						Group By ExitGPA
					</cfquery>
				</cfif>
				
				<cfif #QData.recordcount# GT 0>
					<tr><td>
						<cfoutput><b><i>Program Name : </i></b>#ProgramName#</cfoutput><br/><br/>
						<u>Total Records for this Program : <cfoutput>#QData.Total#</cfoutput>,</u> &nbsp;&nbsp;&nbsp; 
						<u>Average</u> : <cfoutput>#NumberFormat(QData.Avg,'___.__')#</cfoutput>&nbsp;&nbsp;&nbsp;
						<u>Minimum Score</u> : <cfoutput>#QData.Min#</cfoutput>&nbsp;&nbsp;&nbsp;
						<u>Maximum Score</u> : <cfoutput>#QData.Max#</cfoutput>&nbsp;&nbsp;&nbsp;<br/><br/>
														
						<cfchart format="jpg" font="arial" backgroundcolor="##FFFFCC" databackgroundcolor="##CCCCCC" foregroundcolor="##3366FF" fontSize="14" fontitalic="yes" chartheight="250" chartwidth="800">
							<cfchartseries type="line"  paintstyle="shade" seriescolor="##3366FF" query="QGPA" itemcolumn="Xaxis" valuecolumn="Yaxis"></cfchartseries>
						</cfchart>
					</td></tr>
				</cfif>
				</cfloop>
			</table>
		</div>
	</cf_page>