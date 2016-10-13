 

$("#map1").click(function(e){

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
  
  document.getElementById("xcord1").innerHTML = "X: " + Xperc.toFixed(2);
  document.getElementById("ycord1").innerHTML = "Y: " + Yperc.toFixed(2);
  
  document.getElementById("mark").setAttribute("left", Xperc +"%");
  document.getElementById("mark").setAttribute("top", Yperc +"%");
  document.getElementById("mark").setAttribute("visibility", "show");
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