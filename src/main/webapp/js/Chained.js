function printStateMenu(Type) {
//	var selectClass = '';
//	var selectRole = '';
	if (Type == 'DBA') {
	//	selectClass = '<select name="classification" id="classification" style="width:160px"><option value="">--Select One--</option></select>';
	//	selectRole = '<select name="Role" id="Role" style="width:160px"><option value="view">VIEW</option><option value="edit">VIEW / EDIT</option><option value="add">VIEW / EDIT / ADD / DELETE</option></select>';
		animatedcollapse.hide('table3');
}
	else if (Type == 'FAC') {
	//	selectClass = '<select name="classification" id="classification" style="width:160px"><option value="">--Select One--</option></select>';
	//	selectRole = '<select name="Role" id="Role" disabled="disabled"  style="width:160px"><option value="view">VIEW</option></select>';
		animatedcollapse.hide('table3');	
}
	else if (Type == 'FIELD') {
	//	selectClass = '<select name="classification" id="classification" style="width:160px"><option value="">--Select One--</option></select>';
	//	selectRole = '<select name="Role" id="Role" disabled="disabled"  style="width:160px"><option value="view">VIEW</option></select>';
		animatedcollapse.hide('table3');	
}
	else if (Type == 'NUK') {
	//	selectClass = '<select name="classification" id="classification" style="width:160px"><option value="">--Select One--</option></select>';
	//	selectRole = '<select name="Role" id="Role" disabled="disabled"  style="width:160px"><option value="view">VIEW</option></select>';
		animatedcollapse.hide('table3');	
}
	else if (Type == 'STA') {
	//	selectClass = '<select name="classification" id="classification" style="width:160px"><option value="">--Select One--</option></select>';
//		selectRole = '<select name="Role" id="Role" disabled="disabled"  style="width:160px"><option value="view">VIEW</option></select>';
		animatedcollapse.hide('table3');	
}
	else if (Type == 'STU') {
	//	selectClass = '<select name="classification" id="classification" style="width:160px"><option value="">--Select One--</option></select>';
	//	selectRole = '<select name="Role" id="Role" disabled="disabled"  style="width:160px"><option value="view">VIEW</option></select>';
		animatedcollapse.show('table3');	
}
	else {
	//	selectClass = '<select name="classification"  id="classification"  style="width:160px" disabled><option value="">Select a classification</option></select>';
	//	selectRole = '<select name="Role" id="Role" disabled="disabled"  style="width:160px"><option value="view">VIEW</option></select>';
		animatedcollapse.show('table3');
}
//	document.getElementById('selectClass').innerHTML = selectClass;
//	document.getElementById('selectRole').innerHTML = selectRole;
}


