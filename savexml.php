<html>
<head>
<title>
</title>
</head>
<body> 

<?php

if (isset($_REQUEST['ok'])) {
	


	$xml = new DOMDocument("1.0","UTF-8");
	$xml->load("data.xml");
	
	//otetaan käyttäjän valinnat joilla ohjataan sitä mihin nodeen kirjotetaan
	$dTag = $_REQUEST['d'];
	$eTag = $_REQUEST['e'];
	
	//jos on valittu vamk, tehdään skripti, jos ei -> die
	if($eTag == "vamk") {
	
	//seuraava rivi riippuu valituista arvoista
	$rootTag = $xml->getElementsByTagName("data")->item(0);
	
	$dataTag = $xml->createElement("room");
	
	$aTag = $xml->createElement("roomid",$_REQUEST['a']);
	$bTag = $xml->createElement("xcord",$_REQUEST['b']);
	$cTag = $xml->createElement("ycord",$_REQUEST['c']);
		
	
	$dataTag->appendChild($aTag);
	$dataTag->appendChild($bTag);
	$dataTag->appendChild($cTag);
	//$dataTag->appendChild($dTag);
	//$dataTag->appendChild($eTag);
	
	$rootTag->appendChild($dataTag);
	
	$xml->save("data.xml");
}

else {
die("Eipä ollu");
}

} 
?>

<form action="savexml.php" method="post">
<select name="e">
<option value="novia">NOVIA</option>
<option value="vamk">VAMK</option>
</select>
<br>
<br>
Floor: 
<input type="radio" name="d" value="1">1
<input type="radio" name="d" value="2">2
<input type="radio" name="d" value="3">3
<br>

Room ID: <input type="text" name="a" /><br> 
X cord: <input type="text" name="b" /><br> 
Y cord: <input type="text" name="c" /><br>

<input type="submit" name="ok"> 
</form>
</body>
</html>
