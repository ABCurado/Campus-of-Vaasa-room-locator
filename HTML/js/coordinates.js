 

$("#map1").click(function(e){

  var rect = this.getBoundingClientRect();

  
  
  var scrollTop = window.pageYOffset;
  var scrollLeft = window.pageXOffset;
  
  console.log("TOP:" + scrollTop + "LEFT:" +scrollLeft);
  
  var posX = e.pageX - Math.round(rect.left) - scrollLeft;
  var posY = e.pageY - Math.round(rect.top) - scrollTop;
  
  console.log("TOpp:" + posY + "LEFtt:" +	posX);
  
  
  
  
  var mapWidth = $(this).width();
  var mapHeight = $(this).height();

  
  var Xperc = (posX / mapWidth);
  var Yperc = (posY / mapHeight);
  
  
  document.getElementById("xcord1").innerHTML = "X: " + Xperc.toFixed(2);
  document.getElementById("ycord1").innerHTML = "Y: " + Yperc.toFixed(2);
  
  Xperc = Xperc * 100;
  Yperc = Yperc * 100;
  
  document.getElementById("mark").style.left = Xperc +"%";
  document.getElementById("mark").style.top = Yperc +"%";
  document.getElementById("mark").style.visibility = "visible";
});

$("#map2").click(function(e){

  var rect = this.getBoundingClientRect();
  console.log(rect.top, rect.left);
  
  var posX = e.pageX - Math.round(rect.left);
  var posY = e.pageY - Math.round(rect.top);
  
  console.log(posX, posY);
  
  
  
  var mapWidth = $(this).width();
  var mapHeight = $(this).height();
  console.log(mapWidth, mapHeight);
  
  var Xperc = (posX / mapWidth);
  var Yperc = (posY / mapHeight);
  
  console.log(Xperc, Yperc);
  
  document.getElementById("xcord2").innerHTML = "X: " + Xperc.toFixed(2);
  document.getElementById("ycord2").innerHTML = "Y: " + Yperc.toFixed(2);
});