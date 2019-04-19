<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Player</title>
<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
<% if(session.getAttribute("username") != null){ %>
	<div class="topnav" id="myTopnav">
	<a href="index.jsp">Home</a>
 	<a href="addPlayer.jsp">Add Player</a>
  	<a href="addTeam.jsp">Add Team</a>
  	<a href="viewPlayers.jsp">View Players</a>
  	<a href="viewTeams.jsp">View Teams</a>
  	<a href="searchPlayer.jsp">Search Player</a>
  	<a href="updatePlayer.jsp" class="active">Update Player</a>
  	<a href="deletePlayer.jsp">Delete Player</a>
	</div>

	<h1>
		Update a Player
	</h1>
	<form action="updateplayer" method="post" onsubmit="return isValidUpdate()">
		<p>
			Enter Player ID:<br />
			<input type="text" id="id1" name="playId" style="width:140px">
			<br />
			<br />
			
			Enter New Contact:<br />
			<input type="number" id="id2" name="contact" style="width:140px">
			<br />
			<br />
			
		
			<input type="submit" value="Update">
		</p>
	</form>
	
	<%if(request.getAttribute("message") != null){ %>
		<span style="color: green;"> <%= request.getAttribute("message") %> </span>
	<%request.removeAttribute("message");}%>
	
	
	<%if(request.getAttribute("errorMessage") != null){ %>
		<span style="color: red;"> <%= request.getAttribute("errorMessage") %> </span>
	<%request.removeAttribute("errorMessage");}%>
	
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	Current User: <%= session.getAttribute("username") %>
	<form action="LogoutServlet">
		<input type="submit" value="Logout">
	</form>
	
	<div class="footer">
  		Matthew Miles <br/>
  		&copy; 2019
	</div>
	
<% } else { %>	
	<div style="color: red; text-align: center;">Please Log In: <a href="login.html">Click Here</a></div>
<% } %>
	

</body>
</html>