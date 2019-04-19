var message = "";
function isValidTeam(){
	var b = false;
	
	var teamid = document.getElementById("id10").value;
	var teamname = document.getElementById("id20").value;
	var coachname = document.getElementById("id30").value;
	
	//alert(teamid + " " + teamname + " " + coachname);
	
	if(teamid == "" || teamname == "" || coachname == ""){
		message = "fields must not be empty";
	}
	else{
		if(isValidID(teamid)){
			b = true;
		}
	}
	
	document.getElementById("errMsg").innerHTML = message;
	return b;
}

function isValidID(teamid){
	var b1 = false;
	if(teamid.match(/^[0-9]{1,}$/)){
		b1 = true;
	}
	else{
		message = "team id should be a number";
	}
	
	return b1;
}

