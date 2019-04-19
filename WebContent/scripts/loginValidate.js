var message = "";
function isValidUserCredentials(){
	var userid = document.getElementById("userid").value;
	var password = document.getElementById("password").value;
	var b = false;
	//username and password should not be empty
	if(userid == "" || password == ""){
		message = "Username and password is required"
	}
	else{
		message = "";
		b = true;
	}
	if(b == true){
		b = isValidUserid(userid);
		if(b == true){
			b = isValidPassword(password);
		}
	}
	document.getElementById("errMsg").innerText = message;
	return b;
}

function isValidUserid(userid){
	var b1 = false;
	//username should be letters of length 1 to 20
	if(message.length == 0 && userid.match(/^[a-zA-Z]{1,20}$/)){
		b1 = true;
	}
	else{
		message="Invalid Username/password";
	}
	return b1;
}

function isValidPassword(password){
	var b2 = false;
	//password should be letter/number or special chars @ or . and have length 5 to 20
	if(message.length == 0 && password.match(/^[a-zA-Z0-9@.]{5,20}$/)){
		b2 = true;
	}
	else{
		message="Invalid Username/password";
	}
	return b2;
}