function SubStr(buf, start) {
    // third argument (optional)
    var length = 0;
    var sz = 0;
		
    sz = len(buf);
    
    if (arrayLen(arguments) EQ 2) {

		if (start GT 0) {
		    length = sz;
		} else if (start LT 0) {
		    length = sz + start;
		    start = 1;
		}
	
    } else {
    
		length = Arguments[3];
		if (start GT 0) {
		    if (length LT 0)   length = 1+sz+length-start;
		} else if (start LT 0) {
		    if (length LT 0) length = length-start;
		    start = 1+sz+start;
		    
		}
    } 
    
    if (isNumeric(start) AND isNumeric(length) AND start GT 0 AND length GT 0) return mid(buf, start, length);
    else return "";
}

function InitDropDownList(val1,val3,val4,val5,val6,val7,val8,val9,val10,val11)
{
//alert(<cfoutput>'#val1#'</cfoutput>);


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
   
   var myDropdownList4 = document.first.select4;


  // Loop through all the items
  for (iLoop = 0; iLoop< myDropdownList4.options.length; iLoop++)
  {    
    if (myDropdownList4.options[iLoop].value == val4)
    {
      // Item is found. Set its selected property, and exit the loop
      myDropdownList4.options[iLoop].selected = true;
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
  
  
  
   var myDropdownList8 = document.first.select8;


  // Loop through all the items
  for (iLoop = 0; iLoop< myDropdownList8.options.length; iLoop++)
  {    
    if (myDropdownList8.options[iLoop].value == val8)
    {
      // Item is found. Set its selected property, and exit the loop
      myDropdownList8.options[iLoop].selected = true;
      break;
    }
  }
  
   var myDropdownList9 = document.first.select9;


  // Loop through all the items
  for (iLoop = 0; iLoop< myDropdownList9.options.length; iLoop++)
  {    
    if (myDropdownList9.options[iLoop].value == val9)
    {
      // Item is found. Set its selected property, and exit the loop
      myDropdownList9.options[iLoop].selected = true;
      break;
    }
  }
  
   var myDropdownList10 = document.first.select10;


  // Loop through all the items
  for (iLoop = 0; iLoop< myDropdownList10.options.length; iLoop++)
  {    
    if (myDropdownList10.options[iLoop].value == val10)
    {
      // Item is found. Set its selected property, and exit the loop
      myDropdownList10.options[iLoop].selected = true;
      break;
    }
  }
  
  
   var myDropdownList11 = document.first.select11;
 // Loop through all the items
  for (iLoop = 0; iLoop< myDropdownList11.options.length; iLoop++)
  {    
    if (myDropdownList11.options[iLoop].value == val11)
    {
      // Item is found. Set its selected property, and exit the loop
      myDropdownList11.options[iLoop].selected = true;
      break;
    }
  }
  
  }
  
  
  
function populate()
{
document.first.submit();
}

function addpro()
{
if((document.first.select1.value == "")||(document.first.select3.value == "")||(document.first.select4.value == "")||(document.first.select5.value == "")||(document.first.select6.value == ""))  <!--- CHANGE MADE HERE select11.value not required --->
{
alert(" Make sure you selected all the fields which says select one ");

}
else
{
document.first.action="addprogprocontrol.cfm";
document.first.submit();
}
}

