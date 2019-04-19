var message = "";
function isValidPlayer(){
	b = false;
	var name = document.getElementById("id1").value;
	var dob = document.getElementById("id2").value;
	var email = document.getElementById("id3").value;
	var gender = "";
	var teamname = document.getElementById("id6").value;
	var contact = document.getElementById("id7").value;
	if(document.getElementById('id4').checked){
		gender = "M";
	}
	if(document.getElementById('id5').checked){
		gender = "F";
	}

	
	if(name == "" || dob == "" || email == "" || gender == "" || teamname == 0 || contact == ""){
		message = "fields cannot be empty";
	}
	else{
		if(isValidEmail(email) && isValidContact(contact) && isValidName(name)){
			b = true;
			//document.getElementById("addPlayer").reset();
		}
		
	}
	
	
	document.getElementById("errMsg").innerHTML = message;
	return b;
}

function isValidEmail(email){
	var b1 = false;
	if(email.match(/^[a-zA-Z0-9]{1,}@[a-zA-Z0-9]{1,}\.[a-zA-Z0-9]{1,}$/)){
		b1 = true;
	}
	else{
		message = "invalid email";
	}
	return b1;
}

function isValidContact(contact){
	var b2 = false;
	if(contact.match(/^[0-9]{10}$/)){
		b2 = true;
	}
	else{
		message = "invalid contact";
	}
	return b2;
}

function isValidName(name){
	var b2 = false;
	if(name.match(/^[A-Za-z .-]{1,20}$/)){
		b2 = true;
	}
	else{
		message = "Name should be letters only. Max length 20.";
	}
	return b2;
}