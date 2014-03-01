<cfparam name="ATTRIBUTES.id" type="string" default="Identity">
<cfparam name="ATTRIBUTES.category" type="string" default="view">

<cfset category = #ATTRIBUTES.category#>
<cfset ID = #ATTRIBUTES.id#>

<cfset id1 = "dummy1">
<cfset id2 = "dummy2">	
<cfset id3 = "dummy3">
<cfset id4 = "dummy4">
<cfset id5 = "dummy5">
<cfset id6 = "dummy6">
<cfset id7 = "dummy7">
<cfset id8 = "dummy8">

<cfif ID EQ "Identity">
	<cfset id1 = "current">
<cfelseif ID EQ "College">
	<cfset id2 = "current">
<cfelseif ID EQ "Program">
	<cfset id3 = "current">
<cfelseif ID EQ "Personal">
	<cfset id4 = "current">
<cfelseif ID EQ "Computer">
	<cfset id5 = "current">
<cfelseif ID EQ "Phone">
	<cfset id6 = "current">
<cfelseif ID EQ "Address">
	<cfset id7 = "current">
<cfelseif ID EQ  "AccountMainPage">
	<cfset id8 = "current">
</cfif>
<cfoutput>
<cfif category EQ "add">
<div id="tabsF">
		<ul>
		<cfif Session.Security.account EQ true>
			<li id="#id8#"><a href="AddMain.cfm"><span>Account MainPage</span></a></li>
		</cfif>
		<cfif Session.Security.add_identity EQ true>
			<li id="#id1#"><a href="AddIdentity.cfm"><span>Add Identity</span></a></li>
		</cfif>
		<cfif Session.Security.add_college_profile EQ true>
			<li id="#id2#"><a href="AddCollegeProfile.cfm"><span>Add College Profile</span></a></li>
		</cfif>
		<cfif Session.Security.add_program_profile EQ true>
			<li id="#id3#"><a href="AddProgramProfile.cfm"><span>Add Program Profile</span></a></li>
		</cfif>
		<cfif Session.Security.add_personal EQ true>
			<li id="#id4#"><a href="AddPersonal.cfm"><span>Add Personal</span></a></li>
		</cfif>
		<cfif Session.Security.add_computer EQ true>
			<li id="#id5#"><a href="AddComputer.cfm"><span>Add Computer</span></a></li>
		</cfif>
		<cfif Session.Security.add_phone EQ true>
			<li id="#id6#"><a href="AddPhone.cfm"><span>Add Phone</span></a></li>
		</cfif>
		<cfif Session.Security.add_address EQ true>
			<li id="#id7#"><a href="AddAddress.cfm"><span>Add Address</span></a></li>
		</cfif>
		</ul>
</div>
</cfif>

<cfif category EQ "edit">
<div id="tabsF">
		<ul>
		<cfif Session.Security.account EQ true>
			<li id="#id8#"><a href="EditMain.cfm"><span>Account MainPage</span></a></li>
		</cfif>
		<cfif Session.Security.edit_identity EQ true>
			<li id="#id1#"><a href="EditIdentity.cfm"><span>Edit Identity</span></a></li></cfif>
		<cfif Session.Security.edit_college_profile EQ true>
			<li id="#id2#"><a href="EditCollegeProfile.cfm"><span>Edit College Profile</span></a></li></cfif>
		<cfif Session.Security.edit_program_profile EQ true>
			<li id="#id3#"><a href="EditProgramProfile.cfm"><span>Edit Program Profile</span></a></li></cfif>
		<cfif Session.Security.edit_personal EQ true>
			<li id="#id4#"><a href="EditPersonal.cfm"><span>Edit Personal</span></a></li></cfif>
		<cfif Session.Security.edit_computer EQ true>
			<li id="#id5#"><a href="EditComputer.cfm"><span>Edit Computer</span></a></li></cfif>
		<cfif Session.Security.edit_phone EQ true>
			<li id="#id6#"><a href="EditPhone.cfm"><span>Edit Phone</span></a></li></cfif>
		<cfif Session.Security.edit_address EQ true>			
			<li id="#id7#"><a href="EditAddress.cfm"><span>Edit Address</span></a></li></cfif>
		</ul>
	</div>
</cfif>

<cfif category EQ "view">
<div id="tabsF">
		<ul>
		<cfif Session.Security.account EQ true>
			<li id="#id8#"><a href="ViewMain.cfm"><span>Account MainPage</span></a></li>
		</cfif>
		<cfif Session.Security.view_identity EQ true>
			<li id="#id1#"><a href="ViewIdentity.cfm"><span>View Identity</span></a></li></cfif>
		<cfif Session.Security.view_college_profile EQ true>
			<li id="#id2#"><a href="ViewCollegeProfile.cfm"><span>View College Profile</span></a></li></cfif>
		<cfif Session.Security.view_program_profile EQ true>
			<li id="#id3#"><a href="ViewProgramProfile.cfm"><span>View Program Profile</span></a></li></cfif>
		<cfif Session.Security.view_personal EQ true>
			<li id="#id4#"><a href="ViewPersonal.cfm"><span>View Personal</span></a></li></cfif>
		<cfif Session.Security.view_computer EQ true>
			<li id="#id5#"><a href="ViewComputer.cfm"><span>View Computer</span></a></li></cfif>
		<cfif Session.Security.view_phone EQ true>
			<li id="#id6#"><a href="ViewPhone.cfm"><span>View Phone</span></a></li></cfif>
		<cfif Session.Security.view_address EQ true>
			<li id="#id7#"><a href="ViewAddress.cfm"><span>View Address</span></a></li></cfif>
		</ul>
	</div>
</cfif>

<cfif category EQ "delete">
<div id="tabsF">
		<ul>
		<cfif Session.Security.account EQ true>
			<li id="#id8#"><a href="DeleteMain.cfm"><span>Account MainPage</span></a></li>
		</cfif>
		<cfif Session.Security.delete_identity EQ true>		
			<li id="#id1#"><a href="DeleteIdentity.cfm"><span>Delete Identity</span></a></li></cfif>
		<cfif Session.Security.delete_college_profile EQ true>
			<li id="#id2#"><a href="DeleteCollegeProfile.cfm"><span>Delete College Profile</span></a></li></cfif>
		<cfif Session.Security.delete_program_profile EQ true>
			<li id="#id3#"><a href="DeleteProgramProfile.cfm"><span>Delete Program Profile</span></a></li></cfif>
		<cfif Session.Security.delete_personal EQ true>
			<li id="#id4#"><a href="DeletePersonal.cfm"><span>Delete Personal</span></a></li></cfif>
		<cfif Session.Security.delete_computer EQ true>
			<li id="#id5#"><a href="DeleteComputer.cfm"><span>Delete Computer</span></a></li></cfif>
		<cfif Session.Security.delete_phone EQ true>
			<li id="#id6#"><a href="DeletePhone.cfm"><span>Delete Phone</span></a></li></cfif>
		<cfif Session.Security.delete_address EQ true>
			<li id="#id7#"><a href="DeleteAddress.cfm"><span>Delete Address</span></a></li></cfif>
		</ul>
</div>
</cfif>
</cfoutput>

