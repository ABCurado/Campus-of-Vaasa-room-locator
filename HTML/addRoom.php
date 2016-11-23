<?php

	$xml = new DOMDocument("1.0","UTF-8");
	$xml->load("roomdb.xml");

	$floor = $xml -> getElementsByTagName("floor")->item(0);
	
	$elem = $xml->createElement("room");
	
	$roomid = $xml->createElement("roomid",$_POST["roomid"]);
	$xcord = $xml->createElement("xcord",$_POST["x"]);
	$ycord = $xml->createElement("ycord",$_POST["y"]);
	
	$elem->appendChild($roomid);
	$elem->appendChild($xcord);
	$elem->appendChild($ycord);
	
	$floor->appendChild($elem);
	
	$xml->save("roomdb.xml");
?>
