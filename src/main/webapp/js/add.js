<script type="text/javascript">
function init() {
var now = new Date();

var nowyear = now.getYear();
document.index_frm.year.value = nowyear;
}

 // Removes leading and trailing spaces from the passed string. Also removes
 // consecutive spaces and replaces it with one space. If something besides
 // a string is passed in (null, custom object, etc.) then return the input.


function trim(inputString) {
  if (typeof inputString != "string") { return inputString; }
  var retValue = inputString;
  var ch = retValue.substring(0, 1);
  
  while (ch == " ") { // Check for spaces at the beginning of the string
  retValue = retValue.substring(1, retValue.length);
  ch = retValue.substring(0, 1);
  }
  
  ch = retValue.substring(retValue.length-1, retValue.length);
		   while (ch == " ") { // Check for spaces at the end of the string
		      retValue = retValue.substring(0, retValue.length-1);
		      ch = retValue.substring(retValue.length-1, retValue.length);
		   }
		   while (retValue.indexOf("  ") != -1) { 
			// Note that there are two spaces in the string - look for multiple spaces within the string
			retValue = retValue.substring(0, retValue.indexOf("  "))
				 + retValue.substring(retValue.indexOf("  ")+1, retValue.length);
			 // Again, there are two spaces in each of the strings
		   }
		   return retValue; // Return the trimmed string back to the user
		} // Ends the "trim" function

function two_digit_year(year)
{
		if(year < 1000)
                year += 1900
                           
        year = (year+"").substring(2,4);
	
		return year;
}

// CHANGES MADE IN GENERATE_UID FUNCTION ..IF POSSIBLE REPLACE THE ENTIRE CODE OF THIS FUNCTION WITH THE FUNCTION CODE IN THIS PAGE 
function generate_uid()
{
			var x = document.index_frm;
			var l_n = trim(x.lname.value.toUpperCase());
			var f_n = trim(x.fname.value.toUpperCase());
			var m_n = trim(x.mname.value.toUpperCase());
	                var new_uid = l_n.substr(0,3) + f_n.substr(0,1);
			//var d = new Date();   <!--- CHANGE MADE ..LINE COMMENTED --->
			//var yy = d.getYear();  <!--- CHANGE MADE ..LINE COMMENTED --->
			var yy = x.year.value;  //<!--- CHANGE MADE HERE --->
			var count = parseInt("09",0);
         

				if((l_check= check_null(l_n,x.lname.name))){
				if((f_check=check_null(f_n,x.fname.name)))
					sid_check=check_null(x.ssn.value,x.ssn.name);
			}

			if(l_check && f_check && sid_check)
			{
			if(checkssn(x.ssn.value)){
			if(checkyear(x.year.value)){
				yy = two_digit_year(yy);

				(++count < 10)?num='0'+ count:num= count; 
			

				if(m_n.length == 0)
				{
					new_uid = new_uid + "X-" +  yy ;
					}
				else {
					new_uid = new_uid + m_n.substr(0,1) + '-' + yy ;
				}
			
				
				x.uid.value = new_uid;
		        x.submit(); //<!--- CHANGE MADE --->
				}
				else{
				alert("Error in year.");
				}
				}
				else
				{
				alert("Error in SSN.");
				}
			}
			else
			{
			alert("Error!! Values missing. First Name, Last Name and SSN are Required. ");
			}
}

function check_null(value,label)
{
	label=label.toUpperCase();
	value=trim(value);
	if(value.length == 0){
		//alert(label + " cannot be empty")
		return 0;
	}
	return 1;
	
}
//<!--- CHANGE MADE ..ADD THE FUNCTION CHECKYEAR --->
function checkyear(value)
{
	if(value.length != 4){
		//alert(label + " cannot be empty")
		return 0;
	}
	var test = "0123456789";
	  for (i=0; i <= 4; i++) {
	  
       if (test.indexOf(value.charAt(i)) == -1) return 0;
   }
  
	return 1;
	
}
//<!--- CHANGE MADE ..ADD THE FUNCTION CHECKSSN --->
function checkssn(value)
{
	if(value.length != 11){
		//alert(label + " cannot be empty")
		return 0;
	}
	/*
	var test = "0123456789";
	  for (i=0; i <= 9; i++) {
	  
       if (test.indexOf(value.charAt(i)) == -1) return 0;
   }
  */
	return 1;
	
}



function rset()
{
	var x = document.index_frm;
x.lname.value = "";
x.fname.value = "";
x.mname.value = "";
x.maname.value = "";
x.nsuffix.value = "";
x.ssn.value = "";
x.uid.value = "";
InitDropDownList("Female","Ms.");
//<!--- CHANGE MADE ..ADD THESE LINES OF CODE --->
var now = new Date();
var nowyear = now.getYear();
document.index_frm.year.value = nowyear;
}
function sav()
{  generate_uid();

}

function InitDropDownList(val1,val2)
{

  // Get a reference to the drop-down
  var myDropdownList1 = document.index_frm.gender;


  // Loop through all the items
  for (iLoop = 0; iLoop< myDropdownList1.options.length; iLoop++)
  {    
    if (myDropdownList1.options[iLoop].value == val1)
    {
      // Item is found. Set its selected property, and exit the loop
      myDropdownList1.options[iLoop].selected = true;
      break;
    }
  }
 var myDropdownList2 = document.index_frm.title;


  // Loop through all the items
  for (iLoop = 0; iLoop< myDropdownList2.options.length; iLoop++)
  {    
    if (myDropdownList2.options[iLoop].value == val2)
    {
      // Item is found. Set its selected property, and exit the loop
      myDropdownList2.options[iLoop].selected = true;
      break;
    }
  }
}

</script>// JavaScript Document