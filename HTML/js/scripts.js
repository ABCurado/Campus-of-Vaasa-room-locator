/* ADMIN PAGE INIT */

function initAdmin(){
	
	var xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			
			getPlans(this);
			}
		}
	
	xhttp.open("GET", "roomdb.xml", true);
	xhttp.send();
	
	function getPlans(xml) {
				
				var xmlDoc = xml.responseXML;
				var imgs = [];
				
				var floors = xmlDoc.getElementsByTagName("floor");
				console.log(floors);
				
				for(var i = 0; i<=floors.length-1; i++){
					imgs[i] = floors[i].attributes[1].nodeValue;
					console.log(imgs[i]);
				}
				
				
				
	}
		
}	
	

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
	
	
	
	/*	Search for right room and get is as HTMLCollection
	*	Get right coordinates and return them in the end
	*	Coordinates are ready after this
	*/
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
	
	// Get all floors and use floor number to choose right floor
	var floorno = rooms[i].parentElement.attributes[0].nodeValue;
	
	// set return variable
	var returnFloorno = floorno;
	floors = xmlDoc.getElementsByTagName("floor");
	//console.log(floors[floorno-1]);
	
	/*
	*	In for loop floor plan images are set and added in imgs[] array
	*
	*/
	var h = floorno;
	
	for(var b=0; b<=floorno-1; b++){
		
		imgs[b] = floors[h-1].attributes[1].nodeValue;
		console.log(b);
		console.log(imgs[b]);
		h--;
	}
	
	
	floor = rooms[i].parentElement.parentElementSibling;
	var x = rooms[i].parentElement.attributes[0].nodeValue;
		//console.log(floor);

	for(var i=0; i<x; i++){
		//imgs.push(floor.previousElementSibling.attributes[1].nodeValue);
	}
	
	
	
	uni="Novia";
	
	
	return {
	xcord: xcord,
	ycord: ycord,
	floor: returnFloorno,
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
	
	// Get all elements with class="pagination" and hide them
    var pagination = document.getElementsByClassName("floorpag");
    for (i = 0; i < pagination.length; i++) {
        pagination[i].style.display = "none";
    }
	
	
	
	// Get all elements with class="plans" and hide them
    var plans = document.getElementsByClassName("plans");
    for (i = 0; i < plans.length; i++) {
        plans[i].style.display = "none";
    }
	
	document.getElementById("f1").className += " active";
	document.getElementById("f1").style.display = "block";
	
	// get roomid from URL and put it in header
	var roomid = GetURLParameter("roomid");
	document.getElementById("roomid").innerHTML = roomid;

	//initialise variables
	var values, Xperc, Yperc, floors, imgs;	
		
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
		values = getRoom(this, roomid);
		
		console.log(values);
		/* xcord, ycord, floor, img [array], building, uni */
		
		var uni = values.uni;
		
		//get x and y coordinates
		Xperc = values.xcord;
		Yperc = values.ycord;
		
		var floor = values.floor;
		floors = floor-1;
		
		// get imgs array to variable and ge tpictures
		imgs = values.imgs;
		
		for(var i=1; i<imgs.length+1; i++){
			//console.log(i);
			console.log(document.getElementById("f"+i).children);
			document.getElementById("f"+i).children[0].setAttribute("src", imgs[floors]);
			pagination[i].style.display = "block";
			//console.log("img:" + imgs[floors] + " initialized");
			floors--;
		}
		
		var elem = document.createElement("img");
		
		elem.setAttribute("src", "img/mark.PNG");
		elem.setAttribute("id", "mark");
		
		document.getElementById("f"+floor).appendChild(elem);
		
		//set mark on spot
		document.getElementById("mark").style.left = Xperc +"%";
		document.getElementById("mark").style.top = Yperc +"%";
		//set university name
		document.getElementById("schoolname").innerHTML = uni;
		}
		
				

	};
	xhttp.open("GET", "roomdb.xml", true);
	xhttp.send();

		/*
				Set images
		*/
	for(var i = 1; i<floors+1; i++){
		var floor = "f" + i;
		var imgsrc = "img/"+ floor + ".JPG";
		
		
		document.getElementById(floor).setAttribute("src", imgsrc);
		
	}
	
	
}

function redirect(){
	var value=document.getElementById("input1").value;
	console.log(value);
	
	location.href='map.html?roomid='+value;
	
	
}
