<cfparam name="ATTRIBUTES.lookupname" type="string">
<cfparam name="ATTRIBUTES.lookups" type="array">
<cfparam name="ATTRIBUTES.defaultid" type="string" default="">
<cfparam name="ATTRIBUTES.jsfuncname" type="string" default="">
<cfparam name="ATTRIBUTES.jsparamcsv" type="string" default="">

<cfoutput>
	<cfset lookupvalues=#ATTRIBUTES.lookups#>
	
	<cfif "#ATTRIBUTES.jsfuncname#" eq "">
		<select name="#ATTRIBUTES.lookupname#" id="#ATTRIBUTES.lookupname#" class="select_dropdown">
	<cfelse>
		<cfset jsclause="#ATTRIBUTES.jsfuncname#(#ATTRIBUTES.jsparamcsv#)">			
		<select name="#ATTRIBUTES.lookupname#" id="#ATTRIBUTES.lookupname#" onChange="#jsclause#" class="select_dropdown" >
	</cfif>
	
	<cfloop index="i" from="1" to="#ArrayLen(lookupvalues)#" step="1">
		<cfset lookup = #lookupvalues[i]#>
			<cfif "#ATTRIBUTES.defaultid#" EQ "#lookup.id#">
				<option value="#lookup.id#" selected>
					#lookup.text#
				</option>
				<cfelse>
				<option value="#lookup.id#">
					#lookup.text#
				</option>
			</cfif>
	</cfloop>
	
    </select>
</cfoutput>