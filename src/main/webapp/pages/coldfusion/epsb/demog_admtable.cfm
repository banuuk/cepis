<cf_page title="Admission Students, Demographic Information">
	
	<script language="javascript" type="text/javascript">
	<!--	
		function submitFormTable() {
			if(document.demog_adm.report_year.value != "nil" ) {
				document.demog_adm.action = "demog_admtable_sub1.cfm";
				document.demog_adm.submit();
			} else{
				alert("Please Select the Report Year.");
				document.demog_adm.report_year.focus();
			}
		}	
		function submitFormNum() {
			if(document.demog_adm.report_year.value != "nil" ) {
				document.demog_adm.action = "demog_admtable_sub2.cfm";
				document.demog_adm.submit();
			} else{
				alert("Please Select the Report Year.");
				document.demog_adm.report_year.focus();
			}
		}	
		function submitFormPieG() {
			if(document.demog_adm.report_year.value != "nil" ) {
				document.demog_adm.action = "demog_admtable_sub3.cfm";
				document.demog_adm.submit();
		} else{
				alert("Please Select the Report Year.");
				document.demog_adm.report_year.focus();
			}
		}	
		 function submitFormBar() {
			if(document.demog_adm.report_year.value != "nil" ) {
			  document.demog_adm.action = "demog_admtable_sub4.cfm";
			  document.demog_adm.submit();
		} else{
				alert("Please Select the Report Year.");
				document.demog_adm.report_year.focus();
			}
		}		
		 function submitFormLine() {
			if(document.demog_adm.report_year.value != "nil" ) {
			  document.demog_adm.action = "demog_admtable_sub5.cfm";
			  document.demog_adm.submit();
		} else{
				alert("Please Select the Report Year.");
				document.demog_adm.report_year.focus();
			}
		}	

	//-->
	</script>
	
	<div id="outerbox">
			
		<cfform name="demog_adm">
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
					<td><input name= "2" type="button" class= "button" value="Statistics By-Program Data Table" onClick="submitFormNum();"/></td><td>&nbsp;&nbsp;&nbsp;</td>					
					<td><input name= "4" type="button" class= "button" value="Statistics By-Program Bar-Chart" onClick="submitFormBar();"/></td><td>&nbsp;&nbsp;&nbsp;</td>
					<td><input name= "3" type="button" class= "button" value="Gender Pie-Chart" onClick="submitFormPieG();"/></td><td>&nbsp;&nbsp;&nbsp;</td>
					<td><input name= "5" type="button" class= "button" value="GPA Line-Chart" onClick="submitFormLine();"/></td>										
				</tr>
			</table>
						
		</cfform>
		
	</div>
</cf_page>