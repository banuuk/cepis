
<cfparam name="ATTRIBUTES.members" type="array">

<cfoutput>	
	<script language="javascript">
		function checkUncheck()
		{
			var selectallmemberscbx = document.getElementsByName("selectallmembers");
			var allboxes = document.getElementsByName("uid");
			for(i=0;allboxes!=null && i<allboxes.length;i++)
			{
				if(selectallmemberscbx[0].checked == true)
				{
					allboxes[i].checked=true;
				}
				else
				{
					allboxes[i].checked=false;
				}
			}
		}
	</script>
	
	<table id="tresults">

    <cfif IsDefined("ATTRIBUTES.members")>
	 <tr><td>#ArrayLen(ATTRIBUTES.members)# records</td></tr>
	</cfif>
	
	<tr id="thdr">
	<th><input type="checkbox" value="yes" name="selectallmembers" onClick="checkUncheck()"></th>
	<th >SID</th>
	<th>Last Name</th>
	<th>First Name</th>
	<th>Middle Name</th>
	<th>UID</th>
	</tr>
	
	<cfif IsDefined("ATTRIBUTES.members") EQ true And #ArrayLen(ATTRIBUTES.members)# gt 0>
	  <cfloop index="i" from="1" to="#ArrayLen(ATTRIBUTES.members)#" step="1">
     	<cfset member=ATTRIBUTES.members[i]>				
	<tr id="trow">
   	<td><input type="checkbox" value="#member.uid#" name="uid"></td>		
	<td>#member.sid#</td>
	<td>#member.lastname#</td>
	<td>#member.firstname#</td>
	<td>#member.middlename#</td>
	<td>#member.uid#</td>
	</tr>
	</cfloop>
	<cfelse>
	 <tr id="trow">No Members Found</tr>
    </cfif>
	</table>
</cfoutput>
	
