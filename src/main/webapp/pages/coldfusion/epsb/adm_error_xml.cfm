<cf_page title="EPSB Admissions Error Report">
<cfif  FileExists("xml/Re-Adm.xml")>
       <cffile action="read" file="xml/Re-Adm.xml" variable="admxmlfile">
	   <cfset admxml = xmlparse(admxmlfile)>
	   
	   <cfscript>
	   	 xpathexpr0 = "Denied";
	     xpathexpr1 = "//Error";
		 xpathexpr2 = "//Error/ancestor::Student_Record/Demographics/SSN";
		 xpathexpr3 = "//Error/ancestor::Student_Record/Demographics/Name/First_Name";
		 xpathexpr4 = "//Error/ancestor::Student_Record/Demographics/Name/Last_Name";
		 xpathexpr5 = "//Error/ancestor::Student_Record/Demographics/Date_of_Birth";
		 
		 err_xml = xmlsearch(admxml,xpathexpr0);
		 err_ssn = xmlsearch(admxml,xpathexpr2);
		 err_fname = xmlsearch(admxml,xpathexpr3);
		 err_lname = xmlsearch(admxml,xpathexpr4);
		 err_dob = xmlsearch(admxml,xpathexpr5);
		 
	  </cfscript>
	  
	<cfsavecontent variable="err_file">
	 
		<cfif arraylen(err_ssn) eq 0 and arraylen(err_xml) eq 0>
		   <cfoutput> <b>NO ERROR MESSAGES</b></cfoutput>

		<cfelseif arraylen(err_xml) neq 0> 
			<center><b><u>The XML file was Denied for the following reason.</u></b></center><br>
			<cfoutput>#admxml.Denied.Reason.XmlText#</cfoutput><br/><br/><br/>
			<cfdump var=#admxml#>
			<br clear="left"/>
			<caption><u>Report generated on <cfoutput>#DateFormat(Now(),"mm-dd-yy")#</cfoutput> at <cfoutput>#TimeFormat(Now())#</cfoutput></u></caption>
		
		<cfelseif arraylen(err_ssn) neq 0> 
			<center><b><u>ERROR MESSAGES REPORT FOR ADMISSION DATA</u></b></center><br><br>
			
			<table  align="left" cellspacing="2" border="2">
				<tr>
					<th>SSN</th>
					<th>ERROR MESSAGE(S)</th>
					<th>FIRST NAME</th>               
					<th>LAST NAME</th>
					<th>DATE OF BIRTH</th>
				</tr>
				<cfset count = 0>
				<cfloop from="1" to="#arraylen(err_ssn)#" index="i">
					<cfset xpathtest = "//Error[ancestor::Student_Record/Demographics[SSN = '#err_ssn[i].XmlText#']]">
					<cfset err_msg = xmlsearch(admxml,xpathtest)>
						<cfloop from="1" to="#arraylen(err_msg)#" index="j">
							<cfscript>count = count+1; </cfscript>
							<cfif err_msg[j].XmlText neq "The student is already admitted to this program at your institution">
								<tr>				       
									<td><cfoutput>#err_ssn[i].XmlText#</cfoutput></td>
									<td><cfoutput>#err_msg[j].XmlText#</cfoutput></td>
									<td><cfoutput>#err_fname[i].XmlText#</cfoutput></td>
									<td><cfoutput>#err_lname[i].XmlText#</cfoutput></td>
									<td><cfoutput>#err_dob[i].XmlText#</cfoutput></td>
								</tr>				
							</cfif> 
						</cfloop>
				</cfloop>
			</table><br/>
			<br clear="left"/>
			<br/><br/>Total number of errors is <cfoutput>#count#</cfoutput><br/>
			<caption><u>Report generated on <cfoutput>#DateFormat(Now(),"mm-dd-yy")#</cfoutput> at <cfoutput>#TimeFormat(Now())#</cfoutput></u></caption>
		</cfif>
		
		</cfsavecontent>
	
		<cffile action="write" file="xml/adm_error_msg.html" output="#err_file#">
		<cfcontent type="text/html">
<cfmail from="#application.user#" to="#application.user#"   cc="myrt@uky.edu" server="uksmtp.uky.edu" mimeattach="xml/adm_error_msg.html" 
				subject="ADMISSION ERROR MESSAGES REPORT" type="html" wraptext="30">
			<br><br>
			This e-mail ia an automatically generated e-mail that gives a report of error messages generated from the XML document returned from EPSB.
			<br><br>
			Please download the attachment and view it in any internet browser.
			<br><br><br>
		 </cfmail>
		 <br><cfoutput><center><strong>Admissions Error Report Successfully Generated</strong></cfoutput><br><br>
		 <a href="xml/adm_error_msg.html">Click here to view the Report</a><br><br>
		 <cfoutput>An e-mail with the error report has been sent to the appropriate staff.</center></cfoutput>

<cfelse>
   <div align="center"><br>
      <cfoutput>Admission xml file not found</cfoutput>
	</div>
</cfif>
 
</cf_page>
