<cf_page title="EPSB Admissions & Exit Reports">

	<cfif isDefined("Form.term")>
		<cfset reportTerm = #Form.term#>
	<cfelse>
		<cfset reportTerm = 0>
	</cfif>
			
		<cfsetting enablecfoutputonly="yes">
		<cfif FileExists("/usr/local/apache2/htdocs/coesis/webservice/xml/Adm.xml")>
			<cffile action="delete" file="/usr/local/apache2/htdocs/coesis/webservice/xml/Adm.xml">
		</cfif>
		<cfif FileExists("/usr/local/apache2/htdocs/coesis/webservice/xml/Re-Adm.xml")>	
			<cffile action="delete" file="/usr/local/apache2/htdocs/coesis/webservice/xml/Re-Adm.xml">
		</cfif>		
		<cfif FileExists("/usr/local/apache2/htdocs/coesis/webservice/xml/Exit.xml")>
			<cffile action="delete" file="/usr/local/apache2/htdocs/coesis/webservice/xml/Exit.xml">
		</cfif>
		<cfif FileExists("/usr/local/apache2/htdocs/coesis/webservice/xml/Re-Exit.xml")>
			<cffile action="delete" file="/usr/local/apache2/htdocs/coesis/webservice/xml/Re-Exit.xml">
		</cfif>
		
		<!---<cfset reportyr1 = mid(form.report_year,1,4)>
		<cfset reportyr2 = mid(form.report_year,5,6)>
		<cfscript>
			reportyr1 = reportyr1&5;
			reportyr2 = 20&reportyr2&3;
		</cfscript>--->

<cfloop from="1" to="2" index="mainLoop">
	<cfsavecontent variable="StudentRecord">
		<cfoutput><?xml version="1.0" encoding="UTF-8"?>
				<ns1:Tep_Submission xmlns:ns1="Tep_Submission"
				 xmlns:core="http://schemas.pescxml.org/0002/xsd/Core"
				 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
				 xsi:schemaLocation="Tep_Submission https://wd.kyepsb.net/EPSB.WebApps/AdmissionsExit/Schemas/TEP_Submission.xsd"
				 Sending_University="2814">
				
				<IHE_Report Sending_College="6520">
		</cfoutput>
	 <cfif mainLoop EQ 2>
		<cfquery name="stuiden" datasource="DataReview">
			select ti.UID, ti.SID, FName, MName, LName, Suffix, Title, Gender, ta.ProgUID 
				from  tblIdentity as ti, tblTepadmission as ta, tblProgramprofile as tp, lstProgram as lp
			    where tp.UID = ti.UID 
					and ta.ProgUID = tp.ProgUID 				   
				   	and tp.Statuscode = "LAPSED"
				   	<!---and tp.Anticipatedcompletionterm between #reportyr1# and #reportyr2#---> 
				 	and tp.StatusChangeTerm ="#reportTerm#"
				   	and (tp.Programcode like '%-DI-%' or tp.Programcode like '%-CI-%')
				   	and lp.Programcode = tp.Programcode 
				   	and lp.Currency = "Current"
				   	and ta.Tepadmissioncode = 'ADMIT'   
				   	and ta.Primaryx <> 0 
				order by LName;	   
		</cfquery> 
		<cfif #stuiden.RecordCount# gt 0><cfset exitflag=1><cfelse><cfset exitflag=0> </cfif>
	 <cfelseif mainLoop EQ 1>
		<cfquery name="stuiden" datasource="DataReview">	
			SELECT tblIdentity.SID, tblIdentity.UID, tblIdentity.LName, tblIdentity.FName, tblIdentity.MName, tblIdentity.Title, 
				   tblIdentity.Suffix, tblTepadmission.Termcode, tblTepadmission.Tepadmissioncode, tblIdentity.Gender, lstEthnic.KYethniccode, tblPersonal.Birth, tblTepadmission.Writtencommunication, 
				   tblProgramprofile.Ukmajorcode, tblProgramprofile.ProgUID, tblTepadmission.Testtype, tblTepadmission.Overallgpa, tblTepadmission.Totalhours
			FROM   (((
					 (tblIdentity INNER JOIN tblProgramprofile ON tblIdentity.UID = tblProgramprofile.UID) 
					 INNER JOIN tblPersonal ON tblIdentity.UID = tblPersonal.UID) 
					 INNER JOIN lstEthnic ON tblPersonal.Ethniccode = lstEthnic.Ethniccode) 
					 INNER JOIN lstUkmajor ON tblProgramprofile.Ukmajorcode = lstUkmajor.Ukmajorcode) 
					 INNER JOIN tblTepadmission ON tblProgramprofile.ProgUID = tblTepadmission.ProgUID
					 INNER JOIN lstProgram ON lstProgram.programcode = tblProgramprofile.programcode
			WHERE (     ((tblTepadmission.Tepadmissioncode)="ADMIT") 
				    AND ((tblTepadmission.Termcode)="#reportTerm#") 
			        AND ((tblTepadmission.Primaryx)=-1 Or (tblTepadmission.Primaryx)=1)
					AND lstProgram.currency = "CURRENT"
					AND tblTepadmission.Primaryx <> 0
				  );
		</cfquery> 
		<cfif #stuiden.RecordCount# gt 0><cfset admflag=1><cfelse><cfset admflag=0> </cfif>
	</cfif>
	<cfloop from="1" to="#stuiden.RecordCount#" index="ctr">
		<cfscript>
			UID = stuiden.UID[ctr];
			SID = stuiden.SID[ctr];
			FName = stuiden.FName[ctr];
			MName = mid(stuiden.MName[ctr],1,15);
			LName = stuiden.LName[ctr];
			Suffix = stuiden.Suffix[ctr];
			Title = stuiden.Title[ctr];
			Gender = stuiden.Gender[ctr];			
			PUID = stuiden.ProgUID[ctr];
		</cfscript>
		
		<cfoutput>
			
			<Student_Record>
				<Demographics>
					<SSN>#SID#</SSN>
					<Name>
					<First_Name>#FName#</First_Name>
		</cfoutput>
				
				<cfif #MName# NEQ "">
					<cfoutput>
						<Middle_Name>#MName#</Middle_Name>
					</cfoutput>
				</cfif>
				
				<cfoutput>
					<Last_Name>#LName#</Last_Name>
				</cfoutput>
				<cfif #Suffix# NEQ "">
					<cfoutput>
						<Suffix>#Suffix#</Suffix>
					</cfoutput>
				</cfif>
				<cfif #Title# NEQ "">
					<cfoutput>
					<Title>#Title#</Title>
					</cfoutput>
				</cfif>
				<cfoutput>
					</Name>
				</cfoutput>
					<cfquery name="stuaddr" datasource="DataReview">
						select StrLine1, StrLine2, City, State, Zip, Country, Addresstypecode
						from tblIdentity as ti, tblAddress as ta
						where ta.UID = '#UID#' and ti.UID = ta.UID
					</cfquery>
					
					<cfset BreakCounter = 0>
					<cfloop from="1" to="#stuaddr.RecordCount#" index="ctr2">
						<cfscript>
							Addr1 = stuaddr.StrLine1[ctr2];
							Addr2 = stuaddr.StrLine2[ctr2];
							City = stuaddr.City[ctr2];
							State = Trim(UCase(stuaddr.State[ctr2]));
							Zip = mid(stuaddr.Zip[ctr2],1,5);
							Country = stuaddr.Country[ctr2];		
							ATC = stuaddr.Addresstypecode[ctr2];
							Permnt = 0;
							Mailng = 0;
						</cfscript>
						<cfif (Compare(ATC, "Permanent") EQ 0) OR (Compare(ATC, "permanent") EQ 0)>
							<cfscript>
								ATC = replace(ATC, "Permanent", "1738");
								Permnt = -1; 
							</cfscript>
						<cfelseif Compare(ATC, "Mailing") EQ 0 OR Compare(ATC, "mailing") EQ 0>
							<cfscript>
								ATC = replace(ATC, "Mailing", "1740");
								Mailng = -1; 
							</cfscript>
						</cfif>
						<cfif (Permnt EQ -1) OR (Mailng EQ -1)>
							<cfoutput>
								<cfif Country EQ "USA">
									<Address>
										<Address_Type>#ATC#</Address_Type>
											<cfscript>Address = Left(Addr1 & Addr2, 30);</cfscript>
										<Street>#Address#</Street>
										<City>#City#</City>
										<State>#State#</State>
										<Zip>#Zip#</Zip>
									</Address>
								</cfif>
							</cfoutput>
						</cfif>
								
						<cfset BreakCounter = BreakCounter + 1 >
						<cfif BreakCounter EQ 2 > <cfbreak> </cfif>
					</cfloop>	
							
					<cfif (Permnt NEQ -1) AND (Mailng NEQ -1)>
						<cfset ATC = 1738>
							<cfoutput>
								<cfif Country EQ "USA">
									<Address>
									<Address_Type>#ATC#</Address_Type>
											<cfscript>Address = Left(Addr1 & Addr2, 30);</cfscript>
										<Street>#Address#</Street>							
									<City>#City#</City>
									<State>#State#</State>
									<Zip>#Zip#</Zip>
									</Address>
								</cfif>					
							</cfoutput>
					</cfif>
					
					<cfquery name="stuph" datasource="DataReview">
						select Phone, Extension, Phonetypecode 
						from tblIdentity as ti, tblPhone as tp
						where tp.UID = '#UID#' and (Phonetypecode = 'Local' or Phonetypecode = 'Permanent') and ti.UID = tp.UID order by Phonetypecode desc;
					</cfquery>
					<cfscript>
						area_code=""; 
						number = "";
						PTC="";
						Ext="";
					</cfscript>
							
					<cfloop from="1" to="#stuph.RecordCount#" index="ctr3">
						<cfscript>
							Phone = stuph.Phone[ctr3];
							Ext = stuph.Extension[ctr3];
							//PTC = replaceList(stuph.Phonetypecode[ctr3], "Local", "2133");
							if(stuph.phonetypecode[ctr3] eq "Permanent")
							{
							 PTC = "1736";
							}
							else if(stuph.phonetypecode[ctr3] eq "Local")
							{
							 PTC = "2133";
							}
							else { PTC = ""; }
						</cfscript>
						<cfscript>
							v = GetToken(Phone, 1, ")") & GetToken(Phone, 2, "-");
							x = Mid(Phone, 2, 3);
							Check = Mid(Phone, 1, 1);
						</cfscript>	
						<cfif Check EQ "(">
							<cfscript>
								area_code = Mid(Phone, 2, 3);
								number =  GetToken(Phone, 2, ")");
								number =  Trim(GetToken(number, 1, "-") & GetToken(number, 2, "-"));
							</cfscript>
						<cfelse>
							<cfscript>
								area_code = Mid(Phone, 1, 3);
								number   = Trim(Mid(Phone, 4, Len(Phone)-3));
							</cfscript> 
						</cfif>
					</cfloop>
							
					<cfquery name="sturem" datasource="DataReview">
						select birth, ethniccode, Computeraddress
						from tblPersonal as tp, tblComputer as tc
						where tp.UID = '#UID#' and tc.UID = tp.UID and tc.Computertypecode = 'UKY'
					</cfquery>		
					
					<cfloop from="1" to="#sturem.RecordCount#" index="ctr4">
						<cfscript>
							DOB = DateFormat(sturem.birth[ctr4], "yyyy-mm-dd"); 
							Eth = sturem.ethniccode[ctr4];
							Email = sturem.Computeraddress[ctr4];
						</cfscript>		
					</cfloop>
							
					<cfswitch expression="#Eth#">
						<cfcase value="I">
							<cfset Eth = 01>
						</cfcase>
						<cfcase value="O">
							<cfset Eth = 02>
						</cfcase>
						<cfcase value="B">
							<cfset Eth = 03>
						</cfcase>
						<cfcase value="H">
							<cfset Eth = 04>
						</cfcase>
						<cfcase value="W">
							<cfset Eth = 05>
						</cfcase>
						<cfdefaultcase>
							<cfset Eth = 98>
						</cfdefaultcase>															
					</cfswitch>
					
					<cfif DOB EQ "">
						<cfset DOB = "0000-00-00">   <!--- added --->
					</cfif>
					
					<cfif CompareNoCase(Gender, "female") EQ 0>
							<!---<cfset GenderCode ="0093">--->
						<cfset Gender = Replace(Gender, "female", "Female")> 
					<cfelseif CompareNoCase(Gender, "male") EQ 0>
							<!---<cfset GenderCode ="0094">--->
						 <cfset Gender = Replace(Gender, "male", "Male")>	
					<!---<cfelse>
							<cfset GenderCode ="2177">	--->
					</cfif>
					 
					<cfif #PTC# NEQ "">
						<cfif #area_code# NEQ "" AND #number# NEQ "">
								<cfoutput>
									<Phone>
										<Phone_Type>#PTC#</Phone_Type>
										<AreaCityCode>#area_code#</AreaCityCode>
										<PhoneNumber>#number#</PhoneNumber>
										<cfif #Ext# NEQ "">
											<PhoneNumberExtension>#Ext#</PhoneNumberExtension>
										</cfif>
									</Phone>
								</cfoutput>
						</cfif>
					</cfif>	
								
					<cfoutput>
						<Date_of_Birth>#DOB#</Date_of_Birth>						
						<!---<Gender_Code>#GenderCode#</Gender_Code>--->
						<Gender_Code>#Gender#</Gender_Code> 
						<Ethnicity_Code>#Eth#</Ethnicity_Code>
						<Student_ID>#SID#</Student_ID>
						
						<cfif #EMail# NEQ "">
							<EMail_Address>#Email#</EMail_Address>
						</cfif>
			</Demographics>
						</cfoutput>
			
					<cfquery name="stuprax" datasource="DataReview">
						select Praxis1ID from tblPraxisI as tpr
						where tpr.UID = '#UID#' and Primaryx <> 0;
					</cfquery>	
					<cfquery name="stuprog" datasource="DataReview">
						select lp.EPSBProgramcode1, lp.EPSBProgramcode2, lp.Certificate1, lp.Certificate2, tp.Anticipatedcompletionterm, ta.Tepadmissiondate, 
							   lp.Routetype, ta.Totalhours, ta.Overallgpa, ta.testtype, ta.testid 
						from   tblProgramprofile tp, tblTepadmission ta, lstProgram lp
						where      ta.Primaryx <> 0 
							   and ta.ProgUID = '#PUID#' 
							   and ta.ProgUID = tp.ProgUID 
							   and lp.Programcode = tp.Programcode; 
					</cfquery>
					<cfloop from="1" to="#stuprog.RecordCount#" index="ctr6">
						<cfscript>
							Ecode[1] = stuprog.EPSBProgramcode1[ctr6];
							Ecode[2] = stuprog.EPSBProgramcode2[ctr6];
							Admitdate = DateFormat(stuprog.Tepadmissiondate[ctr6],"yyyy-mm-dd");
							Tothrs = stuprog.Totalhours[ctr6];
							CGPA = LSNumberFormat(stuprog.Overallgpa[ctr6], "9.999");							
							Ttype = Trim(stuprog.testtype[ctr6]);
							Tid = stuprog.testid[ctr6];		
							AnticptdCompTerm = stuprog.Anticipatedcompletionterm[ctr6];
							Completedate = "";
							Cert[1] = stuprog.Certificate1;
							Cert[2]= stuprog.Certificate2;
							Routetype = stuprog.Routetype;
						</cfscript>
						
						<cfif CGPA GT 4><cfset CGPA = 4></cfif>
						
						<cfif AnticptdCompTerm NEQ "">
							<cfset Completedate = #AnticptdCompTerm# MOD 10>			
							<cfif Completedate EQ 1>					
									<cfset CompYr = #AnticptdCompTerm#/10>
									<cfset CompYr = ToString(Int(CompYr)) & "-06-15"> <!--- Floor(year value) converted to string and appended to the rest of the date --->
									<cfset Completedate = CompYr>			 	      <!--- Ex: 20037/10 = 2003.7; Int(2003.7) = 2003; 
																								ToString(2003) & -06-15 = 2003-06-15 ---> 
							<cfelseif Completedate EQ 3>					
									<cfset CompYr = #AnticptdCompTerm#/10>
									<cfset CompYr = ToString(Int(CompYr)) & "-08-15">
									<cfset Completedate = CompYr>				
							<cfelseif Completedate EQ 5>					
									<cfset CompYr = #AnticptdCompTerm#/10>
									<cfset CompYr = ToString(Int(CompYr)) & "-12-15">
									<cfset Completedate = CompYr>				
							<cfelseif Completedate EQ 7>					
									<cfset CompYr = #AnticptdCompTerm#/10+1>
									<cfset CompYr = ToString(Int(CompYr)) & "-05-15">
									<cfset Completedate = CompYr>				
							</cfif>
						<cfelse>
							<cfset Completedate = "0000-00-00">  <!---  added --->
						</cfif>		
						
					</cfloop>
			
					<cfoutput>
			<Academics>
					</cfoutput>

					<cfif Ecode[1] EQ "" AND Ecode[2] EQ "">
						<cfset Numcodes = 1>
						
					<cfelseif Ecode[1] NEQ "" AND Ecode[2] EQ "">										
						<cfset Numcodes = 1>
						<cfif Cert[1] NEQ "" AND Cert[2] NEQ "">
							<cfset NumCerts = 2>
						<cfelseif Cert[1] NEQ "" AND Cert[2] EQ "">
							<cfset NumCerts = 1>
						</cfif>						
					<cfelseif Ecode[1] NEQ "" AND Ecode[2] NEQ "">
						<cfset NumCerts = 1>
						<cfset Numcodes = 2>
					</cfif>
								
					<cfoutput>
				<Programs>
					</cfoutput>
							<cfif mainLoop EQ 1>
							<cfset Startindex = 0>
							<cfloop from="1" to="#Numcodes#" index="rctr1">
								<cfset Startindex = Startindex + 1>										
							<cfoutput>
			<Program_Admission>
							<cfif #ECode[rctr1]# NEQ "">
			<Program_Code>#ECode[rctr1]#</Program_Code>
			<Date_of_Admission>#Admitdate#</Date_of_Admission>
			<Estimated_Graduation_Date>#Completedate#</Estimated_Graduation_Date>
							</cfif>
							</cfoutput>
							<cfif Cert[1] NEQ "">
								<cfloop from="#Startindex#" to="#NumCerts#" index = "CertNum">
									<cfif Startindex EQ 1 >
										<cfoutput>
			<Certification_Code>#Cert[CertNum]#</Certification_Code>
										</cfoutput>
									</cfif>				
								</cfloop>				
								<cfif Startindex EQ 2>
									<cfoutput>
			<Certification_Code>#Cert[Startindex]#</Certification_Code>
									</cfoutput>
								</cfif>					
							</cfif>
							<cfoutput>
			<Routes>
								<cfif #Routetype# EQ 0>
			<Regular_Route>
								<cfelseif #Routetype# EQ 1>	
			<Alternative_Route>
								</cfif>		
			<Hours_Completed>#Tothrs#</Hours_Completed>
			<Cumulative_GPA>#CGPA#</Cumulative_GPA>
			<Assessment>
									</cfoutput>
									
										<cfswitch expression="#Ttype#">
											<cfcase value="ACTE">
												<cfset AssessmentCode =  52>
												<cfquery name="stuacte" datasource="DataReview">
													select composite, testdate from tblActe tac, tblTepadmission ta
													where ta.testid = "#Tid#" and tac.Primaryx <> 0 and tac.Acteid = ta.testid
													and ta.primaryx <> 0;
												</cfquery>							
												<cfscript>
													Composite = stuacte.composite;
													Tdate = DateFormat(stuacte.testdate, "yyyy-mm-dd");
												</cfscript>
											<cfif #Assessmentcode# NEQ "">
												<cfoutput>
			<Assessment_Code>#Assessmentcode#</Assessment_Code>
												</cfoutput>
											</cfif>
											<cfif #Composite# NEQ "">
												<cfoutput>
			<Assessment_Score>#Composite#</Assessment_Score>
												</cfoutput>
											<cfelse>
												<cfoutput>
			<Assessment_Score>0</Assessment_Score>
												</cfoutput>
											</cfif>
											<cfif #TDate# NEQ "">
												<cfoutput>
			<Assessment_Date>#TDate#</Assessment_Date>
													</cfoutput>
												</cfif>						
											</cfcase>
											
											<cfcase value="SAT">
											<cfset AssessmentCode =  53>
												<cfquery name="stusat" datasource="DataReview">
													select composite, date from tblSat ts, tblTepadmission ta
													where ta.testid = "#Tid#" and ts.Primaryx <> 0 and ts.Satid = ta.testid
													and ta.primaryx <> 0;
												</cfquery>
													<cfscript>
														Composite = stusat.composite;
														Tdate = DateFormat(stusat.date, "yyyy-mm-dd");
													</cfscript>
													<cfoutput>
			<Assessment_Code>#Assessmentcode#</Assessment_Code>
			<Assessment_Score>#Composite#</Assessment_Score>								
			<Assessment_Date>#TDate#</Assessment_Date>
													</cfoutput>						
											</cfcase>
											
											<cfcase value="GRE">
											<cfset AssessmentCode =  360>
												<cfquery name="stugre" datasource="DataReview">
													select verbal, quantitative, analytic, date from tblGre tg, tblTepadmission ta
													where ta.testid = "#Tid#" and tg.Primaryx <> 0 and tg.Greid = ta.testid
													and ta.primaryx <> 0;
												</cfquery>
													<cfscript>
														Verbal = stugre.Verbal;
														Analytical = stugre.Analytic;
														Quantitative = stugre.Quantitative;					
														Tdate = DateFormat(stugre.date,"yyyy-mm-dd");
														Composite = "";
													</cfscript>
													<cfif Tdate NEQ "">  
														<cfif Tdate LESS THAN '10-01-2002'>
															<cfscript> Composite = Round((Verbal + Analytical + Quantitative)/3); </cfscript> 
														<cfelse>
															<cfscript> Composite = Round((Verbal + Quantitative)/2); </cfscript>
														</cfif>
													</cfif>
													<cfoutput>
			<Assessment_Code>#Assessmentcode#</Assessment_Code>
			<Assessment_Score>#Composite#</Assessment_Score>
			<Assessment_Date>#TDate#</Assessment_Date>
													</cfoutput>						
											</cfcase>	
											<cfcase value="Praxis 1">							
												<cfquery name="stuprax" datasource="DataReview">
													select PraxisStudentID, 
														   Testdate,  
														   score,
														   Praxis1code,
														   UID
														  <!---  ta.ProgUID  --->
													from   tblPraxisI 
													where  UID =  '#stuiden.UID[ctr]#'
													   and Primaryx <> 0;
												</cfquery>									
												<cfscript> PraxisStudentID = stuprax.PraxisStudentID[1]; </cfscript>
												<cfif PraxisStudentID EQ "" OR NOT(IsNumeric(PraxisStudentID)) >
														<cfscript>
															Assessmentcode = 63;
															Composite = 0;
														</cfscript>
														<cfoutput>
			<Assessment_Code>#Assessmentcode#</Assessment_Code>
			<Assessment_Score>#Composite#</Assessment_Score>
														</cfoutput>
												<cfelse>		
			
																					
													<cfscript>
														R = 0;
														W = 0;
														M = 0;
													</cfscript>									
												<cfloop from="1" to="#stuprax.RecordCount#" index="i">
													<cfscript>
														Praxiscode = stuprax.Praxis1code[i];
													</cfscript>
													
													<cfif Praxiscode EQ 10710 or Praxiscode EQ  0710 or Praxiscode EQ 5710 or Praxiscode EQ 0711>
														<cfset R = 1>
														<cfscript>
															rScore = stuprax.score[i];
															rDate = DateFormat(stuprax.Testdate[i], "yyyy-mm-dd");										
														</cfscript>
													<cfelseif Praxiscode EQ 20720 or Praxiscode EQ 0720 or Praxiscode EQ 5720 or Praxiscode EQ 0721>	
														<cfset W = 1>
													<cfscript>
														wScore = stuprax.score[i];
														wDate = DateFormat(stuprax.Testdate[i], "yyyy-mm-dd");										
													</cfscript>											
													<cfelseif Praxiscode EQ 10730 or Praxiscode EQ 0730 or Praxiscode EQ 5730 or Praxiscode EQ 0731>
														<cfset M = 1>				
														<cfscript>
															mScore = stuprax.score[i];
															mDate = DateFormat(stuprax.Testdate[i], "yyyy-mm-dd");										
														</cfscript>											
													</cfif>									
												</cfloop>
													<cfif R eq 1 or W EQ 1 or M eq 1>
														<cfoutput>
			<PRAXIS_I_ID>#PraxisStudentID#</PRAXIS_I_ID>
														</cfoutput>
													</cfif>
							
													<cfif R EQ 1>
														<cfoutput>
			<PPST_Reading>#rScore#</PPST_Reading>
			<PPST_Reading_Date>#rDate#</PPST_Reading_Date>
														</cfoutput>
													</cfif>	
													
													<cfif W EQ 1>
														<cfoutput>
			<PPST_Writing>#wScore#</PPST_Writing>
			<PPST_Writing_Date>#wDate#</PPST_Writing_Date>
														</cfoutput>
													</cfif>	
													
													<cfif M EQ 1>
														<cfoutput>								
			<PPST_Mathematics>#mScore#</PPST_Mathematics>
			<PPST_Math_Date>#mDate#</PPST_Math_Date>
														</cfoutput>	
													</cfif>	
													
													<cfif R NEQ 1 and W NEQ 1 and M NEQ 1>	
														<cfoutput>
			<Assessment_Code>#Assessmentcode#</Assessment_Code>
			<Assessment_Score>#Composite#</Assessment_Score>
														</cfoutput>
													</cfif>		
																	
												</cfif>																		
											</cfcase>
											<cfdefaultcase>
												<cfscript>
													Assessmentcode = 63;
													Composite = 0;
												</cfscript>
												<cfoutput>
			<Assessment_Code>#Assessmentcode#</Assessment_Code>
			<Assessment_Score>#Composite#</Assessment_Score>
												</cfoutput>				
											</cfdefaultcase>														
										</cfswitch>
								<cfoutput>
			</Assessment>
								</cfoutput>
								
							<cfif #Routetype# EQ 0>
								<cfoutput>
			</Regular_Route>
								</cfoutput>
							<cfelseif #Routetype# EQ 1>	
								<cfoutput>
			</Alternative_Route>
								</cfoutput>
							</cfif>
							<cfoutput>
			</Routes>
			</Program_Admission>
							</cfoutput>				
							</cfloop>
							
							<cfelse>								
							<cfloop from="1" to="#NumCodes#" index="ctr_PE">
							<cfoutput>
			<Program_Exit>
			<Program_Code>#ECode[ctr_PE]#</Program_Code>
			<Cumulative_GPA>#CGPA#</Cumulative_GPA>
			<Exit_Code>1826</Exit_Code>
			<Date_of_Program_Completion>#Completedate#</Date_of_Program_Completion>
			</Program_Exit>					
			</cfoutput>
							</cfloop>
							</cfif>
						<cfoutput>
				</Programs>
				</Academics>
				</Student_Record>
						</cfoutput>
					
				</cfloop>		
				<cfoutput>
				</IHE_Report>
			</ns1:Tep_Submission>
				</cfoutput>
			
				</cfsavecontent>
				
				<cfif (mainLoop EQ 1 and admflag EQ 1) or (mainLoop EQ 2 and exitflag EQ 1) >
				
				 <cfinvoke webservice="https://wd.kyepsb.net/EPSB.WebApps/AdmissionsExit/TepXmlWebService/TEPXmlSubmission.asmx?wsdl" method = "SubmitXml" returnvariable="returndXML">
				   <cfinvokeargument name="theXML" value = "#StudentRecord#">
				   <cfinvokeargument name="userID" value = "XMLUK">
				   <cfinvokeargument name="password" value = "PH03T7X0">
				</cfinvoke>  
				</cfif>

				<!---
				 <cfinvoke webservice="https://wd.kyepsb.net/epsb.webapps/admissionsexit/tepxmlwebservice/TEPXmlSubmission.asmx?wsdl" method = "SubmitXml" returnvariable="rreturndXML">
				   <cfinvokeargument name="theXML" value = "#StudentRecord#">
				   <cfinvokeargument name="userID" value = "RGURUMO1">
				   <cfinvokeargument name="password" value = "vellore">
				</cfinvoke>	  --->
			
				<cfif mainLoop EQ 1 and admflag EQ 1 >
					<cffile action="write" file="/usr/local/apache2/htdocs/coesis/webservice/xml/Re-Adm.xml" output="#returndXML#" mode="777"> 
					<cffile action="write" file="/usr/local/apache2/htdocs/coesis/webservice/xml/Adm.xml" output="#StudentRecord#" mode="777">
					
				<cfelseif mainLoop EQ 2 and exitflag EQ 1>
					<cffile action="write" file="/usr/local/apache2/htdocs/coesis/webservice/xml/Re-Exit.xml" output="#returndXML#" mode="777"> 
					<cffile action="write" file="/usr/local/apache2/htdocs/coesis/webservice/xml/Exit.xml" output="#StudentRecord#" mode="777">	 
				</cfif>
			</cfloop>

			<cfsetting enablecfoutputonly="no">
			<td class="label">To view the XML files in a new browser, <br/> Click on the below hyperlinks : </td><br/>
				<cfif admflag EQ 1>
				<td width="400"> <a href="xml/Adm.xml" target="_blank">View Submitted Admission Report</a></td><br/>
				<td width="400"><a href="xml/Re-Adm.xml" target="_blank">View Reply_For_Admission Report</a></td><br/><br/><br/>
				</cfif>
				<cfif exitflag EQ 1>
				<td width="400"><a href="xml/Exit.xml" target="_blank">View Submitted Exit Report</a></td><br/>
				<td width="400"><a href="xml/Re-Exit.xml" target="_blank">View Reply_For_Exit Report</a></td><br/><br/><br/><br/>
				</cfif>
			 	<td class="label">To view the error report and send a copy to your mail box, <br/> Click on the below hyperlinks : </td><br/>
					<cfif admflag EQ 1>
			 		<a href="adm_error_xml.cfm">Generate Admission Error Report</a><br><br>
					</cfif>
					<cfif exitflag EQ 1>
			 		<a href="exit_error_xml.cfm">Generate Exit Error Report</a>
					</cfif>
			
			
			<!---<cffile action="read" file="/usr/local/apache2/htdocs/coesis/webservice/xml/Adm.xml" variable="XMLFileText">
			<cfset myXMLDocument=XmlParse(XMLFileText)>
			<cfdump var="myXMLDocument">
			 
			<cfif FileExists("/usr/local/apache2/htdocs/coesis/webservice/xml/Re-Adm.xml") AND FileExists("/usr/local/apache2/htdocs/coesis/webservice/xml/Re-Exit.xml")>
				<cflocation url="http://localhost/cfide/develop_xml/errorsXml.cfm" addtoken="no">
			<cfelse>
				<cflocation url="http://localhost/cfide/develop_xml/invalidXml.html">
			</cfif>---> 
			
</cf_page>
