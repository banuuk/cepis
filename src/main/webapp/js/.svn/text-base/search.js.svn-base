
function selectAll(selectBox, selectAll) {
	// have we been passed an ID
	if (typeof selectBox == "string") {
		selectBox = document.getElementById(selectBox);
	}
	// is the select box a multiple select box?
	if (selectBox.type == "select-multiple") {
		for ( var i = 0; i < selectBox.options.length; i++) {
			selectBox.options[i].selected = selectAll;
		}
	}
	return false;
};


function getParam(name) {
	  var regexS = "[\\?&]"+name+"=([^&#]*)";
	  var regex = new RegExp( regexS );
	  var tmpURL = window.location.href;
	  var results = regex.exec( tmpURL );
	  if( results == null )
	    return "";
	  else
	    return results[1];
};
