<?php
ini_set('display_errors', 1);

$xml = new DOMDocument();

$xml -> load("roomdb.xml");
$roomtoremove = $_POST["roomid"];

if ($xml === false) {
    echo "Failed loading XML: ";
    foreach(libxml_get_errors() as $error) {
        echo "<br>", $error->message;
    }
} else {
   print_r("xml loaded.");
}

$roomids = $xml -> getElementsByTagName("roomid");
$i = 0;

while($roomtoremove != $roomids -> item($i) -> textContent){
$i++;
}
$nodeToRemove = $roomids -> item($i) -> parentNode;

//now remove
if($nodeToRemove != null)
$nodeToRemove -> parentNode -> removeChild($nodeToRemove);

print_r("Removed");

$xml -> save("roomdb.xml");

?>
 
