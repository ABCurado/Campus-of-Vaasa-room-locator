<?php
	$xml = new DOMDocument("1.0","UTF-8");
	$xml->preserveWhiteSpace = false;
	$xml->load("roomdb.xml");
	
	$floorno = $_POST["floor"];
	$roomid = $_POST["roomid"];
	
	$floor = $xml -> getElementsByTagName("floor")->item($floorno);
	$roomids = $xml -> getElementsByTagName("roomid");
	
	// new node
	$elem = $xml->createElement("room");
	
	$child0 = $xml->createElement("roomid",$roomid);
	$child1 = $xml->createElement("xcord",$_POST["x"]);
	$child2 = $xml->createElement("ycord",$_POST["y"]);
	
	$elem->appendChild($child0);
	$elem->appendChild($child1);
	$elem->appendChild($child2);
	
	$i = 0;
	$flag = false;
	for($i=0; $i < $roomids -> length; $i++){
		
		if($roomid == $roomids -> item($i) -> textContent){
			$flag=true;
			
			$nodeToReplace = $roomids -> item($i) -> parentNode;
		
			//now remove
			
			$nodeToReplace -> parentNode -> replaceChild($elem, $nodeToReplace);
			print_r("Replaced");
			
			$xml->save("roomdb.xml");
		}
		
	}
	
	if($flag == false){
		$floor -> appendChild($elem);
		print_r("Added");
	}
	
	$xml->formatOutput = true;
	$xml->save("roomdb.xml");
	
?>
