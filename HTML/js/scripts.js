function openMainTab(evt, tabName) {
    // Declare all variables
    var i, tabcontent, tablinks;

    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("maintabs");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("mainlinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    // Show the current tab, and add an "active" class to the link that opened the tab
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}

function openTab(evt, tabName) {
    // Declare all variables
    var i, tabcontent, tablinks;

    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    // Show the current tab, and add an "active" class to the link that opened the tab
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}


function searchRoom(){

	var roomid = "A3010";
	document.getElementById("searchfield").setAttribute("value", roomid);

}


// GETS PARAMETER FROM URL
// USE var roomid = GetURLParameter("roomid");
// example.com?roomid=1234
// returns "1234"
function GetURLParameter(sParam)
{
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++)
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam)
        {
            return sParameterName[1];
        }
    }
}

// SECOND PAGE INITIALIZING
// SECOND PAGE INITIALIZING

function init(){
	var roomid = GetURLParameter("roomid");
	document.getElementById("roomid").innerHTML = roomid;
	
	var Xperc = 50;
	var Yperc = 50;
	
	document.getElementById("mark").style.left = Xperc +"%";
	document.getElementById("mark").style.top = Yperc +"%";
	
	// Get all elements with class="plans" and hide them
    var plans = document.getElementsByClassName("plans");
    for (i = 0; i < plans.length; i++) {
        plans[i].style.display = "none";
    }
	
	// Get all elements with class="pagination" and hide them
    var pagination = document.getElementsByClassName("floorpag");
    for (i = 0; i < pagination.length; i++) {
        pagination[i].style.display = "none";
    }
	
	document.getElementById("f1").className += " active";
	document.getElementById("f1").style.display = "block";
	var floors = 2;
	
	if(floors == 0){
		// set basement active
	}
	for(var i = 1; i<floors+1; i++){
		var floor = "f" + i;
		var imgsrc = "img/"+ floor + ".JPG";
		
		pagination[i].style.display = "block";
		document.getElementById(floor).setAttribute("src", imgsrc);
		console.log("img:" + imgsrc + " initialized");
	}
	
	
		
}

// plans pagiantion
function switchPlans(evt, floor){
	
	// Get all elements with class="plans" and hide them
    var plans = document.getElementsByClassName("plans");
    for (i = 0; i < plans.length; i++) {
        plans[i].style.display = "none";
    }
	
	// Get all elements with class="floorlinks" and remove the class "active"
    var floorlinks = document.getElementsByClassName("floorlinks");
    for (i = 0; i < floorlinks.length; i++) {
        floorlinks[i].className = floorlinks[i].className.replace(" active", "");
    }
	
	// Show the current tab, and add an "active" class to the link that opened the tab
    document.getElementById(floor).style.display = "block";
    evt.currentTarget.className += " active";
}

// get room from xml
function getRoom(roomid){
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
	roomValues(this, roomid);
    }
};
xhttp.open("GET", "roomdb.xml", true);
xhttp.send();

function roomValues(xml, roomid) {
    var xmlDoc = xml.responseXML;
    var room = "";

	var i = 0;
	var rooms = xmlDoc.getElementsByTagName("room");
	
	console.log(rooms);
	
	var room = rooms.childNodes;
	/*
	while(room != roomid){
		room = rooms.textContent;
		console.log(rooms);
		i++;
	}
	*/
}

}
