function rset()
{
	var x = document.demopersonal;
x.birth.value = <cfoutput>'#v1#'</cfoutput>;
x.citizen.value = <cfoutput>'#v3#'</cfoutput>;
x.dipstate.value = <cfoutput>'#v5#'</cfoutput>;
x.dipyear.value = <cfoutput>'#v6#'</cfoutput>;
x.highschool.value = <cfoutput>'#v7#'</cfoutput>;
x.hscity.value = <cfoutput>'#v8#'</cfoutput>;
x.hscounty.value = <cfoutput>'#v9#'</cfoutput>;
InitDropDownList1(<cfoutput>'#v2#'</cfoutput>,<cfoutput>'#v4#'</cfoutput>);
}
function InitDropDownList1(val1,val2)
{

  // Get a reference to the drop-down
  var myDropdownList1 = document.demopersonal.select1;


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
 var myDropdownList2 = document.demopersonal.select2;


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
function init(){
 //var f = parent.document.EditCh.uid.value;
 //document.editid.uid.value=f;
 
InitDropDownList1(<cfoutput>'#v2#','#v4#'</cfoutput>);
}
