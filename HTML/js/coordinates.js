 $("#map").click(function(e){

// Get bounding rectangle, bounding rectangle gets top left corner of the img element
  var rect = this.getBoundingClientRect();

	//page scroll offset. If page is not scrolled value is 0
  var scrollTop = window.pageYOffset;
  var scrollLeft = window.pageXOffset;
  
  /*
  * Position where pointer is clicked in map, 
  *	Bounding rectangle and page scroll offset are substracted from it to position marker correct on map
  */
  var posX = e.pageX - Math.round(rect.left) - scrollLeft;
  var posY = e.pageY - Math.round(rect.top) - scrollTop;
 
	// Get element height and width
  var mapWidth = $(this).width();
  var mapHeight = $(this).height();

  // convert position in img to percents
  var Xperc = (posX / mapWidth);
  var Yperc = (posY / mapHeight);
  
  
  // display coordinates
  document.getElementById("xcord").value = "X: " + Xperc.toFixed(2);
  document.getElementById("ycord").value = "Y: " + Yperc.toFixed(2);
  
  // convert from 0-1 to 0-100
  Xperc = Xperc * 100;
  Yperc = Yperc * 100;
  
  // make mark visible and give position
  document.getElementById("mark").style.left = Xperc +"%";
  document.getElementById("mark").style.top = Yperc +"%";
  document.getElementById("mark").style.visibility = "visible";
});
