<cf_page title="Completer Students, Demographic Information">
	
	<script language="javascript" type="text/javascript">
	<!--	
		function submitFormTable() {
			if(document.demog_exit.report_year.value != "nil" ) {
				document.demog_exit.action = "demog_exittable_sub1.cfm";
				document.demog_exit.submit();
			} else{
				alert("Please Select the Report Year.");
				document.demog_exit.report_year.focus();
			}
		}	
		function submitFormNum() {
			if(document.demog_exit.report_year.value != "nil" ) {
				document.demog_exit.action = "demog_exittable_sub2.cfm";
				document.demog_exit.submit();
			} else{
				alert("Please Select the Report Year.");
				document.demog_exit.report_year.focus();
			}
		}	
		function submitFormPieG() {
			if(document.demog_exit.report_year.value != "nil" ) {
				document.demog_exit.action = "demog_exittable_sub3.cfm";
				document.demog_exit.submit();
		} else{
				alert("Please Select the Report Year.");
				document.demog_exit.report_year.focus();
			}
		}	
		function submitFormLine() {
			if(document.demog_exit.report_year.value != "nil" ) {
			  document.demog_exit.action = "demog_exittable_sub4.cfm";
			  document.demog_exit.submit();
		} else{
				alert("Please Select the Report Year.");
				document.demog_exit.report_year.focus();
			}
		}	

	//-->
	</script>
	
	<div id="outerbox">
		<cfform name="demog_exit">
			<table>
				<tr>
					<td class="label"><em>*</em>Select the report year :     
						<cfquery name="QTerm" datasource="DataReview">
							select * from lstEPSBReportYear order by short_description asc
						</cfquery>
						<select name="report_year" class="select_dropdown">
							<option value="nil" selected>--Select report year--</option>
							<option value="ALL">--All--</option>
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
					<td><input name= "1" type="button" class= "button" value="Demographics Data Table" onClick="submitFormTable();"/></td><td>&nbsp;&nbsp;&nbsp;</td>
					<td><input name= "2" type="button" class= "button" value="Statistics By Program" onClick="submitFormNum();"/></td><td>&nbsp;&nbsp;&nbsp;</td>					
					<td><input name= "3" type="button" class= "button" value="Gender Pie-Chart" onClick="submitFormPieG();"/></td><td>&nbsp;&nbsp;&nbsp;</td>
										<td><input name= "5" type="button" class= "button" value="GPA Line-Chart" onClick="submitFormLine();"/></td>										
				</tr>
			</table>
		</cfform>		
	</div>
</cf_page>
	