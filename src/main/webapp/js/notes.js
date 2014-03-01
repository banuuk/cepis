function SubmitForm(args,idvalue)
{
		if( args == "edit"){
			document.notes_form.action="edit_note_confirm.cfm";
		} else if( args =="delete"){
			document.notes_form.action="delete_note_confirm.cfm";
		} else if( args == "email"){
			document.notes_form.action="email_note_confirm.cfm";
		} else {
		}
		document.notes_form.id.value = idvalue;
		document.notes_form.submit();
}

function Submit_Del(value)
{	
		document.delete_form.response.value = value;
		document.delete_form.submit();
}

function Submit_Email(value)
{	
		document.email_form.response.value = value;
		document.email_form.submit();
}