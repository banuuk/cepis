<cfparam name="ATTRIBUTES.college" type="string" default="">
<cfparam name="ATTRIBUTES.department" type="string" default="">
<cfparam name="ATTRIBUTES.type" type="string" default="">
<cfparam name="ATTRIBUTES.gender" type="string" default="">
<cfparam name="ATTRIBUTES.ethnicgroup" type="string" default="">
<cfoutput>
<table>
  <tr>
    <td align="right" valign="middle">&nbsp;</td>
    <td  align="right">&nbsp;</td>
    <td  align="right">Basic Criteria</td>
    <td  align="right" valign="middle">College</td>
    <td  align="left" valign="middle">
	<cf_lookup lookupname="college" lookups=#APPLICATION.lookups.collegelookups# defaultid="ATTRIBUTES.college">
	</td>
    <td >&nbsp;</td>
    <td  align="right">&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
  </tr>
  <tr>
    <td  align="right" valign="middle">&nbsp;</td>
    <td align="right">&nbsp;</td>
    <td>&nbsp;</td>
    <td align="right" valign="middle">Department</td>
    <td>
	<cf_lookup lookupname="department" lookups=#APPLICATION.lookups.departmentlookups# defaultid="ATTRIBUTES.department">
	</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td  align="right" valign="middle">&nbsp;</td>
    <td align="right">&nbsp;</td>
    <td align="right">&nbsp;</td>
    <td align="right" valign="middle">Person type </td>
    <td>
	<cf_lookup lookupname="type" lookups=#APPLICATION.lookups.typelookups# defaultid="ATTRIBUTES.type">
	</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td  align="right" valign="middle">&nbsp;</td>
    <td align="right">&nbsp;</td>
    <td>&nbsp;</td>
    <td align="right" valign="middle">Gender</td>
    <td>
	
	<cf_lookup lookupname="gender" lookups=#APPLICATION.lookups.genderlookups# defaultid="ATTRIBUTES.gender">	
	</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td  align="right" valign="middle">&nbsp;</td>
    <td align="right">&nbsp;</td>
    <td>&nbsp;</td>
    <td align="right" valign="middle">Ethnicity</td>
    <td>
	
	<cf_lookup lookupname="ethnicgroup" lookups=#APPLICATION.lookups.ethnicgrouplookups# defaultid="ATTRIBUTES.ethnicgroup">	
	</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
</cfoutput>