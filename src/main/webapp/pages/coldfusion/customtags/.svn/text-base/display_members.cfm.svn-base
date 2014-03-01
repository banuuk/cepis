<cfparam name="ATTRIBUTES.persons" type="query">
<cfparam name="ATTRIBUTES.action" type="string" default="#application.webroot#/customtags/display_members.cfm">

<cfparam name="session.searchResultsCurrentUID" default="">
<cfif Session.Security.search EQ true>

<cfquery name="getSelectedItem" dbtype="query">
	select uid
	from session.searchresults
	where uid = <cfqueryparam value="#session.searchResultsCurrentUID#">
</cfquery>
<cfquery name="getSrchName" datasource="DataReview">
	SELECT SEARCH_NAME FROM tblUserSearches2
	WHERE SEARCH_ID = <cfqueryparam value="#SESSION.name_srch#">
</cfquery>

<cfif getSelectedItem.RecordCount LTE 0>
	<cfset session.searchResultsCurrentUID = "">
</cfif>

<cfif session.searchResultsCurrentUID EQ "" AND session.searchResults.RecordCount GT 0>
	<cfset session.searchResultsCurrentUID = session.searchResults.UID>
</cfif>

<cfif isDefined("Form.personIndex")>
	<cfset SESSION.searchResultsCurrentUID = Form.personIndex>
</cfif>

<cfoutput>
<link type="text/css" href="#application.webroot#/scripts/css/common.css" rel="stylesheet">
<script type="text/javascript" src="#application.webroot#/scripts/js/add_profile.js"></script>
<script type="text/javascript">
function changeMember(){
	members = document.display_members.add_results;
  	select_value = members.options[members.selectedIndex].value;
	document.display_members.personIndex.value = select_value;
<!--	frames['Computer'].location.href = "add_computer_name.cfm"; -->
	document.display_members.submit();
}
</script>

<cfform name="display_members" action="#ATTRIBUTES.action#">
	<label for="members" class="label">WORKING SET : #getSrchName.SEARCH_NAME#</label>
	<table>
		<tr>
		 <td>
		 <cfinput type="hidden" name="personIndex">
		 <select name="add_results" class="select_dropdown" size="#Max(2,Min(20, session.searchResults.RecordCount))#" onchange="changeMember()">
		  	<cfloop query="session.searchresults">
				<cfif session.searchResultsCurrentUID eq uid>
					<option value="#uid#" selected>#lname#, #fname# #mname#</option>
				<cfelse>
					<option value="#uid#">#lname#, #fname# #mname#</option>
				</cfif> 
			</cfloop>
		  </select>
		 </td>
	   </tr>
 </table>
</cfform>
</cfoutput>
</cfif>