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
	document.form.focus();
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
	document.form.focus();
	document.edit_form.submit();
}

function populate()
{
	document.edit_form.submit();
}

function SubmitAction(type)
{
	if( type == "program"){
		document.edit_form.action = "edit_program_action.cfm";
	}
	document.edit_form.submit();
}

function filterEditProfileClassification(classify_codes){
		var index = document.forms.edit_form.college_type.selectedIndex;
		var person_type_value = document.forms.edit_form.college_type.options[index].value;
		var class_code_len = document.forms.edit_form.classification;
		var i, loop, length, noteIndex = 0;
		
		length = classify_codes.length;
		deleteOption("classification","edit_form");
		for(i=1; i < length ; i++){
			var code = classify_codes[i];
			if( person_type_value == code.id ) {
				addOption(document.forms.edit_form.classification, code.short, code.text);
			}
		}
}

function filterDropdown( totalSubList, form, mainSelect, subSelect ){
		var index = mainSelect.selectedIndex;
		var main_value = mainSelect.options[index].value;
		var i, loop, length, noteIndex = 0;
		
		length = totalSubList.length;
		deleteSelectOption(subSelect, form);
		for(i=1; i < length ; i++){
			var code = totalSubList[i];
			if( main_value == code.id ) {
					addSelectOption(subSelect, code.short, code.text);
			}
		}
}

function addSelectOption(selectbox,text,value )
{
	var optn = document.createElement("OPTION");
	optn.text = text;
	optn.value = value;
	selectbox.options.add(optn);
}
			
function deleteSelectOption(selectbox, form)
{
	while(selectbox.childNodes.length>0) {
		selectbox.removeChild(selectbox.childNodes[0]);
	}
}