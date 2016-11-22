<?php

	$xml = new DOMDocument("1.0","UTF-8");
	$xml->load("roomdb.xml");

	 $roomid = $_POST["roomid"];
	 $xcord = $_POST["x"];
	 $ycord = $_POST["y"];
	  
	$roomids = $xml -> getElementsByTagName("roomid");
	
	print_r($roomid);
	print_r($xcord);
	print_r($ycord);
?>
