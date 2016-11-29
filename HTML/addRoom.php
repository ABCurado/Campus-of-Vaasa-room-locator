<?php
	$xml = new DOMDocument("1.0","UTF-8");
	$xml->preserveWhiteSpace = false;
	$xml->load("roomdb.xml");
	
	$floorno = $_POST["floor"];
	$roomid = $_POST["roomid"];
	
	$floor = $xml -> getElementsByTagName("floor")->item($floorno);
	$roomids = $xml -> getElementsByTagName("roomid") ->item(0);
	print_r($roomids);
	
	
	//$university = $_POST["university"];
	
	
	
	
	$elem = $xml->createElement("room");
	
	$child0 = $xml->createElement("roomid",$roomid);
	$child1 = $xml->createElement("xcord",$_POST["x"]);
	$child2 = $xml->createElement("ycord",$_POST["y"]);
	
	$elem->appendChild($child0);
	$elem->appendChild($child1);
	$elem->appendChild($child2);
	
	//$unipath = $xml -> getElementById("novia") -> textContent;
	//$floorpath = $unipath -> getElementsByTagName("floor")->item($floorno);
	
	$floor->appendChild($elem);
	$xml->formatOutput = true;
	$xml->save("roomdb.xml");
	
?>
