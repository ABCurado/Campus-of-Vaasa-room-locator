	
	

/*
* function takes xml file and roomid, looks for the room and returns:
	xcord, ycord, floor, img, building and uni in this order from 0 to 5.
	
	var room = roomValues(xml, "roomid");
	
	var x = room.xcord;
*/

function getRoom(xml, roomid) {
    // ROOT DOCUMENT
	var xmlDoc = xml.responseXML;
	
	//Define variables
	var xcord, ycord, floor, room, rooms, building, uni;
	//img as an array
	var imgs = [];
	
	// get all the rooms as HTMLCollection
	rooms = xmlDoc.getElementsByTagName("room");
	console.log(rooms);
	//Search for right room and get is as HTMLCollection
	for(var i=0; i<rooms.length; i++){
		
		var breaker = rooms[i].firstElementChild.innerHTML;
		//break the loop and give coordinates and room as HTMLCollection
		if(roomid == breaker){
			room = rooms[i].children;
			console.log(room);
			xcord = room[1].innerHTML;
			ycord = room[2].innerHTML;
			break;
		}
	}
	
	
	//console.log(room);
	uni = rooms["0"].parentElement.parentElement.parentElement.attributes[1].nodeValue
	//console.log(rooms);
	
	floor = rooms[i].parentElement.parentElementSibling;
	var x = rooms[i].parentElement.attributes[0].nodeValue;
		//console.log(floor);

	for(var i=0; i<x; i++){
		//imgs.push(floor.previousElementSibling.attributes[1].nodeValue);
	}
	
	//console.log(rooms[i].parentElement.previousSibling);
	
	
	
	
	return {
	xcord: xcord,
	ycord: ycord,
	floor: floor,
	imgs: imgs,
	building: building = rooms["0"].parentElement.parentElement.attributes["0"].nodeValue,
	uni: uni
	};
	
	
}




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
function init(){
	
	// Get all elements with class="plans" and hide them
    var plans = document.getElementsByClassName("plans");
    for (i = 0; i < plans.length; i++) {
        plans[i].style.display = "none";
    }
	// get roomid from URL and put it in header
	var roomid = GetURLParameter("roomid");
	document.getElementById("roomid").innerHTML = roomid;

	//initialise variables
	var values, Xperc, Yperc, floors;	
		
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
		values = getRoom(this, roomid);
		console.log("test");
		/* xcord, ycord, floor, img [array], building, uni */
		
		//get x and y coordinates
		Xperc = values.xcord;
		Yperc = values.ycord;
		//set mark on spot
		document.getElementById("mark").style.left = Xperc +"%";
		document.getElementById("mark").style.top = Yperc +"%";

		floors = values.floor;
		
		}
	};
	xhttp.open("GET", "roomdb.xml", true);
	xhttp.send();






	
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