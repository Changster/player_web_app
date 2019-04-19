var msg = "";
function isValidRegister(){
	var b = false;
	var username = document.getElementById("id1").value;
	var password = document.getElementById("id2").value;
	
	if(username != "" && password != "" && username.match(/^[a-zA-Z]{1,20}$/) && password.match(/^[a-zA-Z0-9@.]{5,20}$/)){
		b = true;
	}
	else{
		msg = "Registration Error";
	}
	if(msg != ""){
		document.getElementById("err").innerText = msg;
	}
}