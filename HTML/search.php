<?php
$xmlDoc=new DOMDocument();
$xmlDoc->load("roomdb.xml");

$x=$xmlDoc->getElementsByTagName('room');

//get the q parameter from URL
$q=$_GET["q"];

//lookup all links from the xml file if length of q>0
if (strlen($q)>0) {
  $hint="";
  for($i=0; $i<$x -> length; $i++) {
	$y=$x->item($i)->getElementsByTagName('roomid');
	//$z=$x->item($i)->getElementsByTagName('organization');
    if ($y->item(0)->nodeType==1) {
      //find a link matching the search text
      if (stristr($y->item(0)->childNodes->item(0)->nodeValue,$q)) {
        if ($hint=="") {
          $hint="<a href='map.html?roomid=" .$y->item(0)->childNodes->item(0)->nodeValue . "'>" . $y->item(0)->childNodes->item(0)->nodeValue . "</a>";
        } 
		
		
		else {
          $hint=$hint . "<br /><a href='map.html?roomid=" .
          $y->item(0)->childNodes->item(0)->nodeValue .
          "'>" .
          $y->item(0)->childNodes->item(0)->nodeValue . "</a>";
        }
      }
    }
  }
}

// Set output to "no suggestion" if no hint was found
// or to the correct values
if ($hint=="") {
  $response="No room found. Please check your room ID!";
} else {
  $response=$hint;
}

//output the response
echo $response;
?> 
