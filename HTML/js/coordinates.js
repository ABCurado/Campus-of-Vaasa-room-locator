 

$("#mapp").click(function(e){

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
  
  document.getElementById("percent").innerHTML = "X: " + Xperc.toFixed(2) + " Y:" + Yperc.toFixed(2);
});

