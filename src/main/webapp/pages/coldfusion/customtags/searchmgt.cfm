<!-- id of the saved search-->
<cfparam name="ATTRIBUTES.savedsearch" type="numeric" default=-1>
<!-- memo field associated with it. Deprecated; not used-->
<cfparam name="ATTRIBUTES.memo" type="string" default="">
<!-- type of seaches to show (i.e., Individual Searches =1, Student Group Searches =2, Faculty Group Searches =3, Custom Administrator Searches = 4-->
<cfparam name="ATTRIBUTES.searchtype" type="numeric">
<style type="text/css">
<!--
.style1 {
	font-family: Verdana;
	font-size: 12px;
}
-->
</style>



<table width="316" height="176" border="0" cellpadding="3" cellspacing="2" bgcolor="#FFFFCC">
<cfoutput>
  <tr>
    <td width="149" height="21" align="left" valign="middle">
	
	
	<input name="savesearch_yesno" type="checkbox" id="savesearch_yesno" value="yes">
    <span class="style1">Save search</span> </td>
    <td width="149" rowspan="2" align="right" valign="middle">
	  <textarea name="memo" cols="20" rows="5" id="memo">#ATTRIBUTES.memo#</textarea>	
	</td>
  </tr>
  <tr>
    <td height="52" align="left" valign="top" ><p>
	
	<cfswitch expression="#ATTRIBUTES.searchtype#">
		<cfcase value="1">
			<cfset lookups=#APPLICATION.lookups.individualusersearches#>
		</cfcase>
		<cfcase value="2">
			<cfset lookups=#APPLICATION.lookups.studentgroupusersearches#>
		</cfcase>
		<cfcase value="3">
			<cfset lookups=#APPLICATION.lookups.facultygroupusersearches#>
		</cfcase>
		<cfcase value="4">
			<cfset lookups=#APPLICATION.lookups.customadminsearches#>
		</cfcase>
	</cfswitch>
	

	<cfif "#ATTRIBUTES.savedsearch#" NEQ "-1">		
		<cfloop index="i" from="1" to="#ArrayLen(lookups)#">
			<cfset lookup=lookups[i]>			
			<cfif Trim("#ATTRIBUTES.savedsearch#") EQ Trim("#lookup.id#")>
				<input name="searchname" type="text" id="searchname" size="20" value="#lookup.text#">
				<cfbreak>
			</cfif>
		</cfloop>
		<cfelse>
		<input name="searchname" type="text" id="searchname" size="20" value="">
	</cfif>	


	
    <span class="style1">Name Your Search</span> </p>
    </td>
  </tr>
  <tr>
    <td height="21" align="left" valign="top" >&nbsp;</td>
    <td width="149" align="center" valign="middle"><span class="style1">Search Notes</span></td>
  </tr>
  <tr>
    <td height="30" colspan="2" align="left" valign="top">
	

		<cf_lookup lookupname="searches" 
		lookups=#lookups# 
		defaultid="#ATTRIBUTES.savedsearch#"
		jsfuncname="submitform"
		jsparamcsv="'7'"
		>	

	
	
     <span class="style1">Saved Searches </span></td>
  </tr>
  <tr>
    <td height="32" align="left" valign="top">
      <input name="deletesearch" type="button" id="deletesearch" value="Delete Search" onClick="submitform('6')">	</td>
    <td align="right" valign="top">&nbsp;</td>
  </tr>
  </cfoutput>
</table>
