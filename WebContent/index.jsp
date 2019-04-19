<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Player App</title>
<link rel="stylesheet" href="styles/styles.css">
</head>
<body id="body">
<% if(session.getAttribute("username") != null){ %>
	<div class="center">
		<h1 id="h1">Welcome to Player App</h1>
		
	
		<div class="link" onclick="location.href='addPlayer.jsp';">
			Add Player
		</div>
		
		<div class="link" onclick="location.href='addTeam.jsp';">
			Add Team
		</div>
		
		<div class="link" onclick="location.href='viewPlayers.jsp';">
			View Players
		</div>
		
		<div class="link" onclick="location.href='viewTeams.jsp';">
			View Teams
		</div>
		
		<div class="link" onclick="location.href='searchPlayer.jsp';">
			Search Player
		</div>
		
		<div class="link" onclick="location.href='updatePlayer.jsp';">
			Update Player
		</div>
		
		<div class="link" onclick="location.href='deletePlayer.jsp';">
			Delete Player
		</div>
		
	</div>
	
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
	
<% } else { %>	
	<div style="color: red; text-align: center;">Please Log In: <a href="login.html">Click Here</a></div>
<% } %>

</body>
</html>