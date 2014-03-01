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


<table id="mytable" cellspacing="0">

<cfif IsDefined("ATTRIBUTES.members")>
<caption>#ArrayLen(ATTRIBUTES.members)# records</caption>
</cfif>

<cfif IsDefined("ATTRIBUTES.members") EQ true And #ArrayLen(ATTRIBUTES.members)# gt 0>
<tr class="hdr">
    <th scope="col" class="chkbox"><input type="checkbox" value="yes" name="selectallmembers" onClick="checkUncheck()"></th>  
    <th scope="col" class="idcount">No</th>
    <th scope="col">Student ID</th>
	<th scope="col">UID</th>	
	<th scope="col">Last Name</th>
	<th scope="col">First Name</th>
	<th scope="col">Middle Name</th>
</tr>
  

<cfset chkalt = 0>
  <cfloop index="i" from="1" to="#ArrayLen(ATTRIBUTES.members)#" step="1">
   	<cfset member=ATTRIBUTES.members[i]>	  

<cfif chkalt EQ 0>
 <tr class="alt">
 <cfset chkalt = 1>
<cfelse>
 <tr class="noalt">
 <cfset chkalt = 0>
</cfif>
    
	 <cfset stuID = "">
    <td><input type="checkbox" value="#member.uid#" name="uid" id="uid"></td>
	<td>#i#</td>
    <td width="180"><cfscript>stuID = SERVER.groupLogic.MaskSID(ToString(#member.sid#));</cfscript>#stuID#</td>
	<td width="200">#member.uid#</td>
	<td width="180">#member.lastname#</td>
	<td width="180">#member.firstname#</td>
	<td width="180">#member.middlename#</td>
 </tr>
  </cfloop>
<cfelse>
  <tr>No Members Found</tr>
</cfif>
  
</table>
</cfoutput>

