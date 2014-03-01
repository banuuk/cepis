<cfparam name="ATTRIBUTES.formname" type="string">
<cfparam name="ATTRIBUTES.formactionurl" type="string">
<cfparam name="ATTRIBUTES.linktext" type="string">
<!--cfparam name="ATTRIBUTES.hiddenvariables" type="array"-->

<cfoutput>
	<cfif StructKeyExists(ATTRIBUTES,"javascriptcode")>
		#ATTRIBUTES.javascriptcode#
	</cfif>
	
	<form name="#ATTRIBUTES.formname#" action="#ATTRIBUTES.formactionurl#" method="post">

		<cfif StructKeyExists(ATTRIBUTES,"hiddenvariables")>
			<cfloop index="i" from="1" to="#ArrayLen(ATTRIBUTES.hiddenvariables)#" step="1">
				<cfset hiddenvar = ATTRIBUTES.hiddenvariables[i]>
				
				<cfif StructKeyExists(hiddenvar,"value")>
					<input type="hidden" name="#hiddenvar.name#" value="#hiddenvar.value#">
					<cfelse>
					<input type="hidden" name="#hiddenvar.name#">
				</cfif>			
			</cfloop>		
		</cfif>
		
		<cfif StructKeyExists(ATTRIBUTES,"javascriptfunc")>
			<a href="javascript:#ATTRIBUTES.javascriptfunc#(#ATTRIBUTES.javascriptfuncparamcsv#)">
				#ATTRIBUTES.linktext#
			</a>
			<cfelse>
			<a href="javascript:#ATTRIBUTES.formname#.submit()">
				#ATTRIBUTES.linktext#
			</a>
		</cfif>
		
	</form>
	
</cfoutput>


