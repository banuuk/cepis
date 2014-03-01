<cfparam name="ATTRIBUTES.persons" type="query">
<cfparam name="ATTRIBUTES.action" type="string" default="">
<cfparam name="ATTRIBUTES.type" type="string" default="">

<cfparam name="session.searchResultsCurrentUID" default="">

<cfquery name="getSelectedItem" dbtype="query">
	select uid
	from session.searchresults
	where uid = <cfqueryparam value="#session.searchResultsCurrentUID#">
</cfquery>

<cfif getSelectedItem.RecordCount LTE 0>
	<cfset session.searchResultsCurrentUID = "">
</cfif>

<cfif session.searchResultsCurrentUID EQ "" AND session.searchResults.RecordCount GT 0>
	<cfset session.searchResultsCurrentUID = session.searchResults.UID>
</cfif>

<cfif session.name_srch NEQ "">
<cfquery name="getSrchName" datasource="DataReview">
	SELECT SEARCH_NAME FROM tblUserSearches2
	WHERE SEARCH_ID = <cfqueryparam value="#SESSION.name_srch#">
</cfquery>
</cfif>

<cfoutput>
<link type="text/css" href="#application.webroot#/scripts/css/common.css" rel="stylesheet">
<script type="text/javascript" src="#application.webroot#/scripts/js/search.js"></script>
<script type="text/javascript">
function setLocation(){
window.location.href="WORKING SET";
}
</script>
<span class="ftype">Number of Records in Working Set: <cfoutput>#session.searchResults.RecordCount#</cfoutput></span><br/><br/>
<label for="members" class="label"><cfif session.name_srch NEQ "">WORKING SET : #getSrchName.SEARCH_NAME#</cfif></label>
	<table>
		<tr>
		 <td>
		 <a href="WORKING SET"></a>
		  <select name="currentUID"  size="#Max(2,Min(20, session.searchResults.RecordCount))#" class="ws_dropdown">
		  	<cfloop query="session.searchresults">
			<cfif ATTRIBUTES.type NEQ "ALL">
				<cfif session.searchResultsCurrentUID eq uid>
					<option value="#uid#" selected>#lname#, #fname# #mname#</option>
				<cfelse>
					<option value="#uid#">#lname#, #fname# #mname#</option>
				</cfif> 
			<cfelse>
				<cfset stuID = SERVER.groupLogic.MaskSID(#ToString(sid)#)>
				<cfif session.searchResultsCurrentUID eq uid>
					<option value="#uid#" selected>#uid# | #stuID# | #lname#, #fname# #mname#</option>
				<cfelse>
					<option value="#uid#">#uid# | #stuID# | #lname#, #fname# #mname#</option>
				</cfif>   
			</cfif>
			</cfloop>
			<option value=""></option>
		  </select>
		 </td>
	   </tr>
 </table>

</cfoutput>