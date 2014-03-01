function printpage()
{
window.print()
}

function submitEPSB() {
	if(document.EPSBreport.term.value != "nil" ) {
		document.EPSBreport.action = "submit_report.cfm";
		document.EPSBreport.submit();
	}else{
		alert("Please Select a Term.");
		document.EPSBreport.term.focus();
	}
}

function submitEPSBCompleted() {
        if(document.EPSBreport.term.value != "nil" ) {
                document.EPSBreport.action = "submit_report_completed.cfm";
                document.EPSBreport.submit();
        }else{
                alert("Please Select a Term.");
                document.EPSBreport.term.focus();
        }
}

function submitEPSBLapsed() {
        if(document.EPSBreport.term.value != "nil" ) {
                document.EPSBreport.action = "submit_report_lapsed.cfm";
                document.EPSBreport.submit();
        }else{
                alert("Please Select a Term.");
                document.EPSBreport.term.focus();
        }
}


function submitEPSBDepart() {
        if(document.EPSBreport.term.value != "nil" ) {
                document.EPSBreport.action = "submit_report_depart.cfm";
                document.EPSBreport.submit();
        }else{
                alert("Please Select a Term.");
                document.EPSBreport.term.focus();
        }
}

function submitEPSBExclude() {
        if(document.EPSBreport.term.value != "nil" ) {
                document.EPSBreport.action = "submit_report_exclude.cfm";
                document.EPSBreport.submit();
        }else{
                alert("Please Select a Term.");
                document.EPSBreport.term.focus();
        }
}


//used in EPSB data reports
function submitform_(value) {
	//if(document.view_report.report_year.value != "nil" ) {
		if(value.name=='adm') {
			document.view_report.action = "adm_table.cfm";
			document.view_report.submit();
		}
		if(value.name=='demogE') {
			document.view_report.action = "demog_exittable.cfm";
			document.view_report.submit();
		}
		if(value.name=='demogA') {
			document.view_report.action = "demog_admtable.cfm";
			document.view_report.submit();
		}
		if(value.name=='exit') {
			document.view_report.action = "exit_table.cfm";
			document.view_report.submit();			
		}
	//}
	//else{
		//alert("Please Select the Report Year.");
		//document.view_report.report_year.focus();
	//}
}

//used in UK data reports
function submit_(value) {
	if(document.uk_report.report_term.value != "nil" ) {
		if(value.name=='adm') {
			document.uk_report.action = "admission_snapshot.cfm";
			document.uk_report.submit();
		}
		if(value.name=='demogAdm') {
			document.uk_report.action = "demogAdm_snapshot.cfm";
			document.uk_report.submit();
		}
		if(value.name=='demogExit') {
			document.uk_report.action = "demogExit_snapshot.cfm";
			document.uk_report.submit();
		}
		if(value.name=='exit') {
			document.uk_report.action = "exit_snapshot.cfm";
			document.uk_report.submit();			
		}
	}else{
		alert("Please Select a Term.");
		document.uk_report.report_term.focus();
	}
}
