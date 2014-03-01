<cf_page title="Completion data filed with the EPSB">

	<script language="javascript" type="text/javascript">
	<!--	
		function submitFormTable() {
			if(document.exit_table.report_year.value != "nil" ) {
				document.exit_table.action = "exit_table_sub1.cfm";
				document.exit_table.submit();
			} else{
				alert("Please Select the Report Year.");
				document.exit_table.report_year.focus();
			}
		}	
		//-->
	</script>
			
	<div id="outerbox">
		
		<cfform name="exit_table">
		<table>
				<tr>
					<td class="label"><em>*</em>Select the report year :     
						<cfquery name="QTerm" datasource="DataReview">
							select * from lstEPSBReportYear order by short_description asc
						</cfquery>
						<select name="report_year" class="select_dropdown">
							<option value="nil" selected>--Select report year--</option>
							<cfoutput query="QTerm">
								<option value="#reportYear#">#short_description#</option>
							</cfoutput>
						</select><br/><br/>
					</td>
				</tr>
				<tr>
					<td class="label">Sort By :     
						<select name="sort" class="select_dropdown">
							<option value="LastName" selected>Last Name</option>
							<option value="FirstName">First Name</option>
							<option value="ProgramName">Program Name</option>					
						</select><br/><br/>
					</td>
				</tr>
			</table>
				<table>
				<tr><br/></tr>
				<tr>
					<td><input name= "1" type="button" class= "button" value="Generate Report " onClick="submitFormTable();"/></td><td>&nbsp;&nbsp;&nbsp;</td>
									</tr>
			</table>

		</cfform>		
	</div>
</cf_page>

	