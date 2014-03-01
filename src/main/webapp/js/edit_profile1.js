function setSelected(selectElement){
	for( i = 0; i < selectElement.options.length; i++){
		if( selectElement.options[i].value == selectedValue ){
			selectElement.options[i].selected = true
		}
	}
}

function initializeDropDownList(){
	
			

function InitDropDownList(val1,val2,val3,val4,val5,val6,val7)
{
  var myDropdownList1 = document.formName.selectElement1;
  for (iLoop = 0; iLoop< myDropdownList1.options.length; iLoop++)
  {    
    if (myDropdownList1.options[iLoop].value == val1)
    {
      myDropdownList1.options[iLoop].selected = true;
      break;
    }
  }
 
 var myDropdownList2 = document.formName.selectElement2;

for (iLoop = 0; iLoop< myDropdownList2.options.length; iLoop++)
  {    
    if (myDropdownList2.options[iLoop].value == val2)
    {
      // Item is found. Set its selected property, and exit the loop
      myDropdownList2.options[iLoop].selected = true;
      break;
    }
  }

  var myDropdownList3 =  document.formName.selectElement3;
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
  var myDropdownList4 =  document.formName.selectElement2;
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
  