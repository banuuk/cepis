function setnext()
{
	document.addpro.prev.value="0";
	document.addpro.next.value="1";
	document.addpro.action="add_cf_frame.cfm";
	document.addpro.submit();

}
function setprev()
{  
 document.addpro.prev.value="1";
	document.addpro.next.value="0";
  
	document.addpro.action="add_cf_frame.cfm";
	document.addpro.submit();

}

function InitDropDownList(val1,val2,val3,val5,val6,val7)
{
  // Get a reference to the drop-down
  var myDropdownList1 = document.first.select1;
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
 
 var myDropdownList2 = document.first.select2;
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

  var myDropdownList3 = document.first.select3;
  // Loop through all the items
  for (iLoop = 0; iLoop< myDropdownList3.options.length; iLoop++)
  {    
    if (myDropdownList3.options[iLoop].value == val3)
    {
      // Item is found. Set its selected property, and exit the loop
      myDropdownList3.options[iLoop].selected = true;
      break;
    }
  }
  
  var myDropdownList5 = document.first.select5;
  // Loop through all the items
  for (iLoop = 0; iLoop< myDropdownList5.options.length; iLoop++)
  {    
    if (myDropdownList5.options[iLoop].value == val5)
    {
      // Item is found. Set its selected property, and exit the loop
      myDropdownList5.options[iLoop].selected = true;
      break;
    }
  }
  
  var myDropdownList6 = document.first.select6;
  // Loop through all the items
  for (iLoop = 0; iLoop< myDropdownList6.options.length; iLoop++)
  {    
    if (myDropdownList6.options[iLoop].value == val6)
    {
      // Item is found. Set its selected property, and exit the loop
      myDropdownList6.options[iLoop].selected = true;
      break;
    }
  }
  
  var myDropdownList7 = document.first.select7;
  // Loop through all the items
  for (iLoop = 0; iLoop< myDropdownList7.options.length; iLoop++)
  {    
    if (myDropdownList7.options[iLoop].value == val7)
    {
      // Item is found. Set its selected property, and exit the loop
      myDropdownList7.options[iLoop].selected = true;
      break;
    }
  }
  
  
  }
  
  
  
function populate()
{
document.first.submit();
}

function add_college_profile()
{
if((document.first.select1.value == "")||(document.first.select2.value == "")||(document.first.select3.value == ""))
{
alert(" Make sure you have selected College Profile type, Classification and College ");

}
else
{
document.first.action="save_college_profile.cfm";
document.first.submit();
}
}

// JavaScript Document