function printStateMenuadd2(Type, k) {
	eval("var add2selectClass" + k + "='';");
	var selectClass = '';
	if (Type == 'DBA') {
		selectClass = '<select name="Classification" id="Classification" style="width:160px"><option value="">--Select One--</option><option value="Developer">DBA Developer</option><option value="Administrator">DBA Administrator</option><option value="College Manager">DBA College Manager</option><option value="Account Manager">DBA Account Manager</option><option value="Custom">DBA Custom Role</option></select>';
}
	else if (Type == 'FAC') {
		selectClass = '<select name="Classification" id="Classification" style="width:160px"><option value="">--Select One--</option><option value="Adjunct Faculty">FAC Adjunct Faculty</option><option value="Administrative Assign">FAC Administrative Assign</option><option value="Assistant Professor">FAC Assistant Professor</option><option value="Associate Professor">FAC Associate Professor</option><option value="Emeritus Faculty">FAC Emeritus Faculty</option><option value="Full Professor - Changed">FAC Full Professor - Changed</option><option value="Instructors">FAC Instructors</option></select>';
}
	else if (Type == 'FIELD') {
		selectClass = '<select name="Classification" id="Classification" style="width:160px"><option value="">--Select One--</option><option value="Experience Supervisor">FIELD Experience Supervisor</option><option value="Student Teaching">FIELD Student Teaching</option></select>';
}
	else if (Type == 'NUK') {
		selectClass = '<select name="Classification" id="Classification" style="width:160px"><option value="">--Select One--</option><option value="Non-UK Colleague">NUK Non-UK Colleague</option></select>';
}
	else if (Type == 'STA') {
		selectClass = '<select name="Classification" id="Classification" style="width:160px"><option value="">--Select One--</option><option value="Field Experience Speciatist">Field Experience Speciatist</option><option value="Staff Administrative">Staff Administrative</option><option value="Staff Assistant">Staff Assistant</option><option value="Staff Professional">Staff Professional</option><option value="Staff Project">Staff Project</option><option value="Staff Temporary">Staff Temporary</option><option value="Student Affairs Officer">Student Affairs Officer</option><option value="Student Affairs Specialist">Student Affairs Specialist</option></select>';
}
	else if (Type == 'STU') {
		selectClass = '<select name="Classification" id="Classification" style="width:160px"><option value="">--Select One--</option><option value="Graduate Assistant">STU Graduate Assistant</option><option value="Research Assistant">STU Research Assistant</option><option value="Teaching Assistant">STU Teaching Assistant</option><option value="Undergrad Advisor">STU Undergrad Advisor</option><option value="Graduate Student">STU Graduate Student</option></select>';
}
	else {
		selectClass = '<select name="Classification"  id="Classification"  style="width:160px" disabled><option value="">Select a Classification--</option></select>';
}
	
	eval("document.getElementById('add2selectClass" +k+"').innerHTML = selectClass;");
}
