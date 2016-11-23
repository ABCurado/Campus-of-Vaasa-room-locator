<?php

	$xml = new DOMDocument("1.0","UTF-8");
	$xml->load("roomdb.xml");
	
	$floorno = $_POST["floor"]-1;
	
	$floor = $xml -> getElementsByTagName("floor")->item($floorno);
	
	
	
	//$university = $_POST["university"];
	
	
	
	
	$elem = $xml->createElement("room");
	
	$roomid = $xml->createElement("roomid",$_POST["roomid"]);
	$xcord = $xml->createElement("xcord",$_POST["x"]);
	$ycord = $xml->createElement("ycord",$_POST["y"]);
	
	$elem->appendChild($roomid);
	$elem->appendChild($xcord);
	$elem->appendChild($ycord);
	
	//$unipath = $xml -> getElementById("novia") -> textContent;
	//$floorpath = $unipath -> getElementsByTagName("floor")->item($floorno);
	
	$floor->appendChild($elem);
	
	$xml->save("roomdb.xml");
?>
