<?php
$xml=loadXml("roomdb.xml") or die ("Error");
//$huone = $xml ->xpath("//room" as $huone);
//echo $huone->roomid <br>
echo $_POST["roomid"];
$roomid = $_POST["roomid"];
$huone = getElementsByTagName($roomid);

echo $huone;

$nodeToRemove = null;

?>


 
