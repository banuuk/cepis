<cfassociate 
   baseTag = "CF_PAGE"
   dataCollection = "headerData">

<cfif thisTag.HasEndTag is 'False'>
   <cfabort showError="An end tag is required.">
</cfif>

<cfif thisTag.ExecutionMode is 'end'>
	<cfset attributes.generatedContent = thisTag.GeneratedContent>
	<cfset thisTag.GeneratedContent = "">
</cfif>