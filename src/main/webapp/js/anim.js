animatedcollapse.addDiv('myDiv1', 'fade=1,speed=400,persist=1,hide=1')
animatedcollapse.addDiv('myDiv2', 'fade=1,speed=400,persist=1,hide=1')
animatedcollapse.addDiv('myDiv3', 'fade=1,speed=400,persist=1,hide=1')
animatedcollapse.addDiv('myDiv4', 'fade=1,speed=400,persist=1,hide=1')
animatedcollapse.addDiv('myDiv5', 'fade=1,speed=400,persist=1,hide=1')
animatedcollapse.addDiv('table3', 'fade=1,speed=400,persist=1,hide=0')

animatedcollapse.ontoggle=function($, divobj, state){ //fires each time a DIV is expanded/contracted
	//$: Access to jQuery
	//divobj: DOM reference to DIV being expanded/ collapsed. Use "divobj.id" to get its ID
	//state: "block" or "none", depending on state
}
animatedcollapse.init()