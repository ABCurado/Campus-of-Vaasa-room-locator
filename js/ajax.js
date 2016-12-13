$(document).ready(function(){
	$("#submit").click(function(e){
		e.preventDefault();
		
		var university = $("#uselect").val();
		var building = $("#bselect").val();
		var floor = $("#fselect").val();
		var roomid = $("#roomid").val();
		var xcord = $("#xcord").val();
		var ycord  = $("#ycord").val();
		
		// Returns successful data submission message when the entered information is stored in database.
		var dataString = 'university='+ university
						+ '&building='+ building 
						+ '&floor='+ floor 
						+ '&roomid='+ roomid
						+ '&xcord='+ xcord
						+ '&ycord='+ ycord;
						
		console.log(dataString);
						
		if(roomid==''||xcord==''||ycord==''||floor=='')
		{
		alert("Please Fill All Fields");
		}
		else
		{
		// AJAX Code To Submit Form.
		$.ajax({
			type: "POST",
			url: "addRoom.php",
			data: dataString,
			cache: false,
			success: function(result){
				alert(result);
			}
		});
		}
		return false;
	});
});