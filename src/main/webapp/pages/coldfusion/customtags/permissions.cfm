<cfif Session.Security.account EQ true>
<cfif Session.Security.add_identity EQ true OR
      Session.Security.add_college_profile EQ true OR
	  Session.Security.add_program_profile EQ true OR
	  Session.Security.add_personal EQ true OR
	  Session.Security.add_computer EQ true OR
	  Session.Security.add_phone EQ true OR
	  Session.Security.add_address EQ true>
	  
<cfset Session.Security.account_add  = true>
</cfif>

<cfif Session.Security.edit_identity EQ true OR
      Session.Security.edit_college_profile EQ true OR
	  Session.Security.edit_program_profile EQ true OR
	  Session.Security.edit_personal EQ true OR
	  Session.Security.edit_computer EQ true OR
	  Session.Security.edit_phone EQ true OR
	  Session.Security.edit_address EQ true>
	  
<cfset Session.Security.account_edit  = true>
</cfif>

<cfif Session.Security.view_identity EQ true OR
      Session.Security.view_college_profile EQ true OR
	  Session.Security.view_program_profile EQ true OR
	  Session.Security.view_personal EQ true OR
	  Session.Security.view_computer EQ true OR
	  Session.Security.view_phone EQ true OR
	  Session.Security.view_address EQ true>
	  
<cfset Session.Security.account_view  = true>
</cfif>

<cfif Session.Security.delete_identity EQ true OR
      Session.Security.delete_college_profile EQ true OR
	  Session.Security.delete_program_profile EQ true OR
	  Session.Security.delete_personal EQ true OR
	  Session.Security.delete_computer EQ true OR
	  Session.Security.delete_phone EQ true OR
	  Session.Security.delete_address EQ true>
	  
<cfset Session.Security.account_delete  = true>
</cfif>

</cfif>