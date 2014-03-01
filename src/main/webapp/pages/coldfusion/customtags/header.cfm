<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Drop down</title>
<link rel="stylesheet" media="all" type="text/css" href="dropdown.css" />
<!--[if lte IE 6]>
<link rel="stylesheet" media="all" type="text/css" href="dropdown_ie.css" />
<![endif]-->
</head>
<body>
<cfinclude template="banner_coe.cfm">
<div class="menu">
<ul>
<li><a class="hide" href="MainPage.cfm">MAIN PAGE</a>
<!--[if lte IE 6]>
<a href="#">Main Page
<table><tr><td>
</td></tr></table>
</a>
<![endif]-->
</li>
</ul>

<ul>
<li><a class="hide" href="#">SEARCH</a>
<!--[if lte IE 6]>
<a href="#">Search
<table><tr><td> -->
	<ul>
	<li><a href="search/IndividualSearch.cfm">Individual Search</a></li>
	<li><a href="#">Student Group Search</a></li>
	<li><a href="#">Faculty Group Search</a></li>
	</ul>
<!--[if lte IE 6]>
</td></tr></table>
</a>
<![endif]-->

</li>
</ul>

<ul>
<li><a class="hide" href="#">APPLICATION</a>
<!--[if lte IE 6]>
<a href="#">Application
<table><tr><td>
<![endif]-->
	<ul>
	<li><a class="hide" href="#">Account Maintenance &gt;&gt;</a>
	<!--[if lte IE 6]>
    <a class="sub" href="#">Account Maintenance &gt;&gt;
    <table><tr><td>
    <![endif]-->
		<ul>
			<li><a href="account/add/AddIdentity.cfm">Add</a></li>
			<li><a href="account/view/ViewIdentity.cfm">View</a></li>
			<li><a href="account/edit/EditIdentity.cfm">Edit</a></li>
		</ul>
	<!--[if lte IE 6]>
	</td></tr></table>
    </a>
    <![endif]-->
	</li>

   <li><a class="hide" href="#">Advising Application &gt;&gt;</a>
	<!--[if lte IE 6]>
    <a class="sub" href="#">Advising Application &gt;&gt;
    <table><tr><td>
    <![endif]-->
		<ul>
			<li><a href="#">Create Note</a></li>
			<li><a href="#">Review Note</a></li>
			<li><a href="#">Send Email</a></li>
		</ul>
	<!--[if lte IE 6]>
	</td></tr></table>
    </a>
    <![endif]-->
	</li>
	<li><a href="#">UK Daily Data</a></li>
	<li><a href="#">Continous Assessment</a></li>
	
	</ul>
	<!--[if lte IE 6]>
</td></tr></table>
</a>
<![endif]-->
</li>
</ul>

<ul>
<li><a class="hide" href="#">REPORTS</a>
<!--[if lte IE 6]>
<a href="#">Reports
<table><tr><td>
<![endif]-->
	<ul>
	<li><a class="hide" href="#">Standard Reports &gt;&gt;</a>
	<!--[if lte IE 6]>
    <a class="sub" href="#">Account Maintenance &gt;&gt;
    <table><tr><td>
    <![endif]-->
		<ul>
			<li><a href="#">Tabular</a></li>
			<li><a href="#">Graphical</a></li>
			<li><a href="#">Regular</a></li>
		</ul>
	<!--[if lte IE 6]>
	</td></tr></table>
    </a>
    <![endif]-->
	</li>

   <li><a class="hide" href="#">Session Reports &gt;&gt;</a>
	<!--[if lte IE 6]>
    <a class="sub" href="#">Advising Application &gt;&gt;
    <table><tr><td>
    <![endif]-->
		<ul>
			<li><a href="#">Report 1</a></li>
			<li><a href="#">Report 2</a></li>
			<li><a href="#">Report 3</a></li>
		</ul>
	<!--[if lte IE 6]>
	</td></tr></table>
    </a>
    <![endif]-->
	</li>
		
	</ul>
	<!--[if lte IE 6]>
</td></tr></table>
</a>
<![endif]-->
</li>
</ul>

<ul>
<li><a class="hide" href="Logout.cfm">LOGOUT</a>
<!--[if lte IE 6]>
<a href="#">Logout
<table><tr><td>
</td></tr></table>
</a>
<![endif]-->
</li>
</ul>


</div>
</body>
</html>
