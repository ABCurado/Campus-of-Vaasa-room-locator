<?php
	$xml = new DOMDocument("1.0","UTF-8");
	$xml->preserveWhiteSpace = false;
	$xml->load("roomdb.xml");
	
	$floorno = $_POST["floor"];
	$roomid = $_POST["roomid"];
	
	$floor = $xml -> getElementsByTagName("floor")->item($floorno);
	$roomids = $xml -> getElementsByTagName("roomid");
	
	print_r("WHAT!");
	// new node
	$elem = $xml->createElement("room");
	
	$child0 = $xml->createElement("roomid",$roomid);
	$child1 = $xml->createElement("xcord",$_POST["x"]);
	$child2 = $xml->createElement("ycord",$_POST["y"]);
	
	$elem->appendChild($child0);
	$elem->appendChild($child1);
	$elem->appendChild($child2);
	
	$i = 0;
	
	for($i=0; $i < $roomids -> length; $i++){
		
		if($roomid == $roomids -> item($i) -> textContent){
			$nodeToReplace = $roomids -> item($i) -> parentNode;
		
			//now remove
			if($nodeToReplace != null){
			$nodeToReplace -> parentNode -> replaceChild($elem, $nodeToReplace);
			print_r("Replaced");
			}
			else{
			$floor->appendChild($elem);
			print_r("Added");
			}
			
			$xml->save("roomdb.xml");
			}
		}
	$xml->formatOutput = true;
	$xml->save("roomdb.xml");
	
?>
