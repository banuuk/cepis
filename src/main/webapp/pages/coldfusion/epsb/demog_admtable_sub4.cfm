<cf_page title="Admission Students - Bar Chart Statistics By Program">
	
	<cfif isDefined("Form.report_year")>
		<cfset repYear = #Form.report_year#>
	<cfelse>
		<cfset repYear = 0>
	</cfif>
				
	<cfif #repYear# NEQ "ALL">
		<cfquery name="QAdmData" datasource="DataReview">select count(*) as C, avg(GPA) as Avg, max(GPA) as Max, Min(GPA) as Min, ProgramName, Reportyear, ProgramCode, ProgramType from tblUkEPSBAdmData WHERE Reportyear = "#repYear#" Group By ProgramName order by ProgramName</cfquery>
	<cfelseif #repYear# EQ "ALL">
		<cfquery name="QAdmData" datasource="DataReview">select count(*) as C, avg(GPA) as Avg, max(GPA) as Max, Min(GPA) as Min, ProgramName, Reportyear, ProgramCode, ProgramType from tblUkEPSBAdmData Group By ProgramName order by ProgramName</cfquery>
	</cfif>	
	
	<div>
		<div id="printDisplay">
			<input type="button" name="print" value="Print Report" class="button" onClick="printpage()"/>
		</div>
			<tr><td class="label">Total Number of Programs : <cfoutput>#QAdmData.recordcount#</cfoutput> <br/>
					Report year: <cfoutput>#repYear#</cfoutput><br/><br/><br/>
					</td>
			</tr>
			<div id="pieChartDisplay_GS">
		  		<table>
					<cfchart show3D = "yes" format="jpg" tipstyle="mouseover" xaxistitle="Program Name" yaxistitle="Number of Students" 
						 font="arial" backgroundcolor="##FFFFCC"  showygridlines="yes" showxgridlines="yes" databackgroundcolor="##CCCCCC" 
						 sortxaxis="yes" foregroundcolor="##3366FF" fontSize="10"  showmarkers="yes"  showlegend="yes"  labelformat="number" 
						 chartheight="800" chartwidth="650" seriesplacement="cluster">
						
						<cfchartseries  type="horizontalbar"  itemcolumn="Program Name"  valuecolumn="Count" 
							colorlist="blue, red, white, Gray, black, green, purple, olive, yellow, Fuchsia, lime, maroon, silver, ##0099FF, ##FF9966, ##CC3366, ##009999,  ##FF6600, navy, teal"
							 paintstyle="raise">
							
							<cfloop query="QAdmData">
							  <cfchartdata item="#QAdmData.ProgramName#" value="#QAdmData.C#">
							</cfloop>
							
						</cfchartseries>
					</cfchart>
			</table>
		</div>
    </div>		

</cf_page>