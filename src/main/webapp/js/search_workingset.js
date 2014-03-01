function move(fbox, tbox) {
			var arrFbox = new Array();
			var arrTbox = new Array();
			var arrLookup = new Array();
			var i;
			for (i = 0; i < tbox.options.length; i++) {
				arrLookup[tbox.options[i].text] = tbox.options[i].value;
				arrTbox[i] = tbox.options[i].text;
			}
			var fLength = 0;
			var tLength = arrTbox.length;
			var j = 0;
			for(i = 0; i < fbox.options.length; i++) {
				arrLookup[fbox.options[i].text] = fbox.options[i].value;

				for(j = 0; j < tbox.options.length && fbox.options[i].selected; j++){
					if( fbox.options[i].value == tbox.options[j].value){
						var isExists  = true;
					}
				}
				
				if (fbox.options[i].selected && fbox.options[i].value != "") {
					if(!isExists){
						arrTbox[tLength] = fbox.options[i].text;
						tLength++;
					}
				}
				else {
					arrFbox[fLength] = fbox.options[i].text;
					fLength++;
				}
			}
			arrFbox.sort();
			arrTbox.sort();
			fbox.length = 0;
			tbox.length = 0;
			var c;
			for(c = 0; c < arrFbox.length; c++) {
				var no = new Option();
				no.value = arrLookup[arrFbox[c]];
				no.text = arrFbox[c];
				fbox[c] = no;
			}
			for(c = 0; c < arrTbox.length; c++) {
				var no = new Option();
				no.value = arrLookup[arrTbox[c]];
				no.text = arrTbox[c];
				tbox[c] = no;
			}
}
		
function done()
{
			for(var i = 0;i < document.WorkingSet.search_set.length;i++) {
				document.WorkingSet.search_set.options[i].selected = true;
			}
			for(var i = 0;i < document.WorkingSet.working_set.length;i++) {
				document.WorkingSet.working_set.options[i].selected = true;
			}
			return true;
}

function searchAgain()
{
	document.WorkingSet.action = "index.cfm";
	documennt.WorkingSet.submit();
}
