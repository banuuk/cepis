function setNext(args)
{
	if(args == "program"){
		document.edit_form.action="edit_program_data.cfm";
	} else if( args == "college"){
		document.edit_form.action="edit_college_data.cfm";	
	} else if( args == "personal"){
		document.edit_form.action="edit_personal_data.cfm";	
	} else if( args == "computer"){
		document.edit_form.action="edit_computer_data.cfm";	
	} else if( args == "phone"){
		document.edit_form.action="edit_phone_data.cfm";	
	} else if( args == "address"){
		document.edit_form.action="edit_address_data.cfm";	
	}
	document.edit_form.prev.value="0";
	document.edit_form.next.value="1";
	document.edit_form.submit();

}

function setPrev(args)
{
	if(args == "program")
		document.edit_form.action="edit_program_data.cfm";
	else if( args == "college")
		document.edit_form.action="edit_college_data.cfm";	
	else if( args == "personal")
		document.edit_form.action="edit_personal_data.cfm";	
	else if( args == "computer")
		document.edit_form.action="edit_computer_data.cfm";	
	else if( args == "phone")
		document.edit_form.action="edit_phone_data.cfm";	
	else if( args == "address")
		document.edit_form.action="edit_address_data.cfm";	

	document.edit_form.prev.value="1";
	document.edit_form.next.value="0";
	document.edit_form.submit();
}

