function validateFormOnSubmit(theForm) {
	var reason = "";
	  reason += validateSSN(theForm.SID);
	  reason += validateSID(theForm.UKID);
		
	  if (theForm.lastName.value.length == 0) {
	          theForm.lastName.style.background = '#C6D1F1';
	        reason += "Please enter a valid last name.\n";
	  }
	  else{
	          theForm.lastName.style.background = 'White';
	      }
	  
	  if (theForm.firstName.value.length == 0) {
	            theForm.firstName.style.background = '#C6D1F1';
	          reason += "Please enter a valid first name.\n";
	  }
	  else{
	          theForm.firstName.style.background = 'White';
	      }
	  
	  if (theForm.ADUID.value.length == 0) {
	          theForm.ADUID.style.background = '#C6D1F1';
	        reason += "Please enter a valid AD User ID.\n";
	  }
	  else{
	          theForm.ADUID.style.background = 'White';
	      }
	  
	  if (theForm.dob.value.length == 0) {
	            theForm.dob.style.background = '#C6D1F1';
	          reason += "Please enter a valid Date of Birth.\n";
	  }
	  else{
	            theForm.dob.style.background = 'White';
	      }
	      
	  if(!(theForm.dob.value.match(/^([0-9]){2}(\/){1}([0-9]){2}(\/)([0-9]){4}$/)))
	  {
	            theForm.dob.style.background = '#C6D1F1';
	          reason += "Date of Birth should be in mm/dd/yyyy format.\n";
	  }
	  else{
	            theForm.dob.style.background = 'White';
	      }
	  if (theForm.type.value.length == 0) {
	            theForm.type.style.background = '#C6D1F1';
	          reason += "Please enter a valid Type (College Profile).\n";
	  }
	  else{
	            theForm.type.style.background = 'White';
	      }

	  if (theForm.classification.value.length == 0) {
	            theForm.classification.style.background = '#C6D1F1';
	          reason += "Please enter a valid Classification (College Profile).\n";
	  }
	  else{
	            theForm.classification.style.background = 'White';
	      }

	  if (theForm.college.value.length == 0) {
	            theForm.college.style.background = '#C6D1F1';
	          reason += "Please enter a valid College (College Profile).\n";
	  }
	  else{
	            theForm.college.style.background = 'White';
	      }

	  if (theForm.department.value.length == 0) {
	            theForm.department.style.background = '#C6D1F1';
	          reason += "Please enter a valid Department (College Profile).\n";
	  }
	  else{
	            theForm.department.style.background = 'White';
	      }

	if((theForm.type.value.length == 0) || (theForm.type.value == "STU")){

	  if (theForm.progDomainCode.value.length == 0) {
	            theForm.progDomainCode.style.background = '#C6D1F1';
	          reason += "Please enter a valid Program Domain Code (Program Profile).\n";
	  }
	  else{
	            theForm.progDomainCode.style.background = 'White';
	      }

	  if (theForm.progCode.value.length == 0) {
	            theForm.progCode.style.background = '#C6D1F1';
	          reason += "Please enter a valid Program Code (Program Profile).\n";
	  }
	  else{
	            theForm.progCode.style.background = 'White';
	      }

	  if (theForm.progTrackingCode.value.length == 0) {
	            theForm.progTrackingCode.style.background = '#C6D1F1';
	          reason += "Please enter a valid Program Tracking Code (Program Profile).\n";
	  }
	  else{
	            theForm.progTrackingCode.style.background = 'White';
	      }

	  if (theForm.progGroupingCode.value.length == 0) {
	            theForm.progGroupingCode.style.background = '#C6D1F1';
	          reason += "Please enter a valid Program Grouping Code (Program Profile).\n";
	  }
	  else{
	            theForm.progGroupingCode.style.background = 'White';
	      }

	  if (theForm.ukMajorCode.value.length == 0) {
	            theForm.ukMajorCode.style.background = '#C6D1F1';
	          reason += "Please enter a valid UK Major Code (Program Profile).\n";
	  }
	  else{
	            theForm.ukMajorCode.style.background = 'White';
	      }

	  if (theForm.advisor.value.length == 0) {
	            theForm.advisor.style.background = '#C6D1F1';
	          reason += "Please enter a valid Advisor (Program Profile).\n";
	  }
	  else{
	            theForm.advisor.style.background = 'White';
	      }

	}


	 if ((theForm.ethnicGroup.value.length == 0) && (theForm.citizenshipCountry.value.length == 0) && (theForm.diplomaType.value.length == 0) && (theForm.diplomaState.value.length == 0) && (theForm.diplomaYear.value.length == 0) && (theForm.highSchool.value.length == 0) && (theForm.highSchoolCity.value.length == 0) && (theForm.highSchoolCounty.value.length == 0))  {
	            theForm.personalFlag.value = '0';
	  }
	  else{
	            theForm.personalFlag.value = '1';
	                if (theForm.ethnicGroup.value.length == 0) {
		                  theForm.ethnicGroup.style.background = '#C6D1F1';
		                reason += "Please enter a valid Ethnic Group (Add Personal).\n";
		        }
		        else{
		                  theForm.ethnicGroup.style.background = 'White';
	      		}
	      		
	      		if (theForm.citizenshipCountry.value.length == 0) {
				  theForm.citizenshipCountry.style.background = '#C6D1F1';
				  reason += "Please enter a valid Citizenship Country (Add Personal).\n";
			}
			else{
				  theForm.citizenshipCountry.style.background = 'White';
	      		}
	}



	if ((theForm.computerName.value.length == 0) && (theForm.computerType.value.length == 0))  {
	            theForm.computerFlag.value = '0';
	  }
	  else{
	            theForm.computerFlag.value = '1';
	                if (theForm.computerName.value.length == 0) {
		                  theForm.computerName.style.background = '#C6D1F1';
		                reason += "Please enter a valid Email Address (Add Email).\n";
		        }
		        else{
		                  theForm.computerName.style.background = 'White';
	      		}
	      		
	      		var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
			   var address = theForm.computerName.value;
			   if(reg.test(address) == false) {
		                  theForm.computerName.style.background = '#C6D1F1';
		                reason += "Invalid Email Address format(Add Email).\n";
			   }
		        else{
		                  theForm.computerName.style.background = 'White';
	      		}
	      		
			if (theForm.computerType.value.length == 0) {
				  theForm.computerType.style.background = '#C6D1F1';
				  reason += "Please enter a valid Email Type (Add Email).\n";
			}
			else{
				  theForm.computerType.style.background = 'White';
	      		}
	}


	  if ((theForm.streetLn1.value.length == 0) && (theForm.streetLn2.value.length == 0) && (theForm.city.value.length == 0) && (theForm.state.value.length == 0) && (theForm.zipCode.value.length == 0) && (theForm.country.value.length == 0) && (theForm.addressType.value.length == 0))  {
	            theForm.addressFlag.value = '0';
	  }
	  else{
	            theForm.addressFlag.value = '1';
	                if (theForm.streetLn1.value.length == 0) {
		                  theForm.streetLn1.style.background = '#C6D1F1';
		                reason += "Please enter a valid Street Line 1 (Add Address).\n";
		        }
		        else{
		                  theForm.streetLn1.style.background = 'White';
	      		}
	      		
	      		if (theForm.city.value.length == 0) {
				  theForm.city.style.background = '#C6D1F1';
				  reason += "Please enter a valid City (Add Address).\n";
			}
			else{
				  theForm.city.style.background = 'White';
	      		}
	      		
	      		if (theForm.state.value.length == 0) {
				  theForm.state.style.background = '#C6D1F1';
				  reason += "Please enter a valid State (Add Address).\n";
			}
			else{
				  theForm.state.style.background = 'White';
	      		}
	      		
	      		if (theForm.zipCode.value.length == 0) {
				  theForm.zipCode.style.background = '#C6D1F1';
				  reason += "Please enter a valid Zip Code (Add Address).\n";
			}
			else{
				  theForm.zipCode.style.background = 'White';
	      		}
	      		
	      		if (theForm.country.value.length == 0) {
				  theForm.country.style.background = '#C6D1F1';
				  reason += "Please enter a valid Country (Add Address).\n";
			}
			else{
				  theForm.country.style.background = 'White';
	      		}
	      		
	      		if (theForm.addressType.value.length == 0) {
				  theForm.addressType.style.background = '#C6D1F1';
				  reason += "Please enter a valid Address Type (Add Address).\n";
			}
			else{
				  theForm.addressType.style.background = 'White';
	      		}
	      		
	}


	  if ((theForm.phoneNo.value.length == 0) && (theForm.extension.value.length == 0) && (theForm.phoneType.value.length == 0) && (theForm.memo.value.length == 0))  {
	            theForm.phoneFlag.value = '0';
	  }
	  else{
	            theForm.phoneFlag.value = '1';
	                if (theForm.phoneNo.value.length == 0) {
		                  theForm.phoneNo.style.background = '#C6D1F1';
		                reason += "Please enter a valid Phone Number (Add Phone).\n";
		        }
		        else{
		                  theForm.phoneNo.style.background = 'White';
	      		}
	      		
	      		
	var stripped1 = theForm.phoneNo.value.replace(/[\(\)\.\-\ ]/g, '');
	//strip out acceptable non-numeric characters
	if (!(isNaN(parseInt(stripped1)))) {

	if (stripped1.length == 10) {

	var temp;
	temp = "(";
	temp += stripped1.substring(0,3);
	temp += ") ";
	temp += stripped1.substring(3,6);
	temp += "-";
	temp += stripped1.substring(6,10);

	theForm.phoneNo.value = temp;

	}
	else{
	theForm.phoneNo.style.background = '#C6D1F1';
	reason += "Error in the length of the phone number (Add Phone).\n";
	}  
	}else {
	reason += "The phone number contains illegal characters (Add Phone).\n";
	}


	      		
	      		
	      		if (theForm.phoneType.value.length == 0) {
				  theForm.phoneType.style.background = '#C6D1F1';
				  reason += "Please enter a valid Phone Type (Add Phone).\n";
			}
			else{
				  theForm.phoneType.style.background = 'White';
	      		}
	}


	  if ((theForm.Admissiontypecode.value.length == 0) && (theForm.Ukclassification.value.length == 0) && (theForm.advUkmajorcode.value.length == 0) && (theForm.ConDate.value.length == 0) && (theForm.Letter.value.length == 0) && (theForm.Memo1.value.length == 0))  {
	            theForm.advisingFlag.value = '0';
	  }
	  else{
	            theForm.advisingFlag.value = '1';
	                if (theForm.Ukclassification.value.length == 0) {
		                  theForm.Ukclassification.style.background = '#C6D1F1';
		                reason += "Please enter a valid Advising Classification (Add Advising Conference).\n";
		        }
		        else{
		                  theForm.Ukclassification.style.background = 'White';
	      		}
	      		
	      		if (theForm.advUkmajorcode.value.length == 0) {
				  theForm.advUkmajorcode.style.background = '#C6D1F1';
				  reason += "Please enter a valid Advising UK Major (Add Advising Conference).\n";
			}
			else{
				  theForm.advUkmajorcode.style.background = 'White';
	      		}
	      		
	      		if (theForm.ConDate.value.length == 0) {
				  theForm.ConDate.style.background = '#C6D1F1';
				  reason += "Please enter a valid Conference Date (Add Advising Conference).\n";
			}
			else{
				  theForm.ConDate.style.background = 'White';
	      		}
	}


	    var myOption1 = -1;
	    for (var iw=0; iw < 2; iw++) {
	    if (theForm.degreeAwarded[iw].checked) {
	    myOption1 = 5;
	    }
	    }
	    if(myOption1 == -1){
	    theForm.degreeAwarded.value = '-1';
	    }


	  reason += validateRadio(theForm.gender);
	  if (reason != "") {
	    alert("Some fields need correction:\n" + reason);
	    return false;
	  }
	  else{
	    return true;
	  }
	}

	function validateRadio(fld) {
	    var error = "";
	    var myOption = -1;
	    for (var i=0; i < 2; i++) {
	    if (fld[i].checked) {
	    myOption = 5;
	    }
	    }
	    if(myOption == -1){
	    error = "Gender has not been checked.\n";
	    }
	    return error;
	}  


	function validateEmpty(fld) {
	    var error = "";

	    if (fld.value.length == 0) {
	        fld.style.background = '#C6D1F1';
	        error = "The required field has not been filled in.\n";
	    } else {
	        fld.style.background = 'White';
	    }
	    return error;
	}


	function validateSSN(fld) {
	    var error = "";
	    var stripped = fld.value.replace(/[\-\ ]/g, '');  

	    if ((isNaN(parseInt(stripped))) && (fld.value.length != 0)) {
	        error = "The SSN number contains illegal characters.\n";
	        fld.style.background = '#C6D1F1';
	    } else if (!((stripped.length == 9) || (stripped.length == 0))) {
	        error = "The SSN number is of wrong length.\n";
	        fld.style.background = '#C6D1F1';
	    }
	    return error;
	}

	function validateSID(fld) {
	    var error = "";
	    var stripped = fld.value;  

	    if ((isNaN(parseInt(stripped))) && (fld.value.length != 0)) {
	        error = "The Student ID contains illegal characters.\n";
	        fld.style.background = '#C6D1F1';
	    } else if (!((stripped.length == 9) || (stripped.length == 8))) {
	        error = "The Student ID is of wrong length.\n";
	        fld.style.background = '#C6D1F1';
	    }
	    return error;
	}

	function trim(s)
	{
	  return s.replace(/^\s+|\s+$/, '');
	}