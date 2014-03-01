<cfparam name="ATTRIBUTES.sid" type="string" default="">
<cfparam name="ATTRIBUTES.uid" type="string" default="">
<cfparam name="ATTRIBUTES.lastname" type="string" default="">
<cfparam name="ATTRIBUTES.firstname" type="string" default="">
<cfparam name="ATTRIBUTES.gender" type="string" default="">
<cfparam name="ATTRIBUTES.ethnicgroup" type="string" default="">
<cfparam name="ATTRIBUTES.type" type="string" default="">
<cfparam name="ATTRIBUTES.classification" type="string" default="">
<cfparam name="ATTRIBUTES.college" type="string" default="">
<cfparam name="ATTRIBUTES.department" type="string" default="">
<cfparam name="ATTRIBUTES.savedsearchname" type="string" default="">
<cfparam name="ATTRIBUTES.newsearchname" type="string" default="">
<cfparam name="ATTRIBUTES.savesearch_yesno" type="string" default="">
<cfoutput>
<table width="853" border="0" cellpadding="5" cellspacing="5" bgcolor="lightyellow">
  <tr>
    <td width="27" align="right">SID</td>
    <td width="147" align="left"><input name="sid" type="text" id="sid" value="#ATTRIBUTES.sid#"></td>
    <td width="98" align="right">Last Name </td>
    <td width="159" align="left"><input name="lastname" type="text" id="lastname" value="#ATTRIBUTES.lastname#"></td>
    <td width="98" align="right">First Name </td>
    <td width="148" align="left"><input name="firstname" type="text" id="firstname" value="#ATTRIBUTES.firstname#"></td>
    <td width="66" align="left"><input name="search" type="submit" id="search" value="Search"></td>
  </tr>
  <tr>
    <td align="right">UID</td>
    <td align="left"><input name="uid" type="text" id="uid" value="#ATTRIBUTES.uid#"></td>
    <td align="right">Gender</td>
    <td align="left"><select name="gender" id="gender">
	
		<cfloop index="i" from="1" to="#ArrayLen(APPLICATION.lookups.genderlookups)#" step="1">
			<cfset lookup = #APPLICATION.lookups.genderlookups[i]#>
			<cfif "#ATTRIBUTES.gender#" EQ "#lookup.id#">
				<option value="#lookup.id#" selected>
					#lookup.text#
				</option>
				<cfelse>
				<option value="#lookup.id#">
					#lookup.text#
				</option>
			</cfif>
		</cfloop>
	
    </select></td>
    <td align="right">Type</td>
    <td align="left"><select name="type" id="type">
	
		<cfloop index="i" from="1" to="#ArrayLen(APPLICATION.lookups.typelookups)#" step="1">
			<cfset lookup = #APPLICATION.lookups.typelookups[i]#>
			<cfif "#ATTRIBUTES.type#" EQ "#lookup.id#">
				<option value="#lookup.id#" selected>
					#lookup.text#
				</option>
				<cfelse>
				<option value="#lookup.id#">
					#lookup.text#
				</option>
			</cfif>
		</cfloop>	
	
    </select></td>
    <td align="right"><input name="add" type="submit" id="add" value="Add"></td>
  </tr>
</table>
<table width="854" border="0" cellpadding="5" cellspacing="5" bgcolor="lightyellow">
  <tr>
    <td width="187" align="right" valign="middle">Ethnic Group </td>
    <td width="271"><select name="ethnicgroup" id="ethnicgroup">
	
		<cfloop index="i" from="1" to="#ArrayLen(APPLICATION.lookups.ethnicgrouplookups)#" step="1">
			<cfset lookup = #APPLICATION.lookups.ethnicgrouplookups[i]#>
			<cfif "#ATTRIBUTES.ethnicgroup#" EQ "#lookup.id#">
				<option selected value="#lookup.id#">
					#lookup.text#
				</option>
				<cfelse>
				<option value="#lookup.id#">
					#lookup.text#
				</option>
			</cfif>
		</cfloop>		
	
    </select></td>
    <td width="340" align="right"><input name="savesearch_yesno" type="checkbox" id="savesearch_yesno" value="checkbox">
      Save This Search</td>
  </tr>
  <tr>
    <td align="right" valign="middle">Classification</td>
    <td><select name="classification" id="classification">
	
		<cfloop index="i" from="1" to="#ArrayLen(APPLICATION.lookups.classificationlookups)#" step="1">
			<cfset lookup = #APPLICATION.lookups.classificationlookups[i]#>
			<cfif "#ATTRIBUTES.classification#" EQ "#lookup.id#">
				<option selected value="#lookup.id#">
					#lookup.text#
				</option>
				<cfelse>
				<option value="#lookup.id#">
					#lookup.text#
				</option>
			</cfif>
		</cfloop>			
	
    </select></td>
    <td align="right">Name Your Search
      <input name="newsearchname" type="text" id="newsearchname"></td>
  </tr>
  <tr>
    <td align="right" valign="middle">College</td>
    <td align="left" valign="middle"><select name="college" id="college">
	
		<cfloop index="i" from="1" to="#ArrayLen(APPLICATION.lookups.collegelookups)#" step="1">
			<cfset lookup = #APPLICATION.lookups.collegelookups[i]#>
			<cfif "#ATTRIBUTES.college#" EQ "#lookup.id#">
				<option selected value="#lookup.id#">
					#lookup.text#
				</option>
				<cfelse>
				<option value="#lookup.id#">
					#lookup.text#
				</option>
			</cfif>
		</cfloop>		
	
	
    </select></td>
    <td align="right" valign="middle">Saved Searches
      <select name="savedsearchname" id="savedsearchname">
      </select></td>
  </tr>
  <tr>
    <td align="right" valign="middle">Department</td>
    <td><select name="department" id="department">
	
	
		<cfloop index="i" from="1" to="#ArrayLen(APPLICATION.lookups.departmentlookups)#" step="1">
			<cfset lookup = #APPLICATION.lookups.departmentlookups[i]#>
			<cfif "#ATTRIBUTES.department#" EQ "#lookup.id#">
				<option selected value="#lookup.id#">
					#lookup.text#
				</option>
				<cfelse>
				<option value="#lookup.id#">
					#lookup.text#
				</option>
			</cfif>
		</cfloop>		
	
    </select></td>
    <td align="right"><input name="deletesearch" type="submit" id="deletesearch" value="Delete this search"></td>
  </tr>
</table>
</cfoutput>