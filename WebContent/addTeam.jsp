<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Team</title>
<link rel="stylesheet" href="styles/styles.css">
</head>
<body id="body">
<% if(session.getAttribute("username") != null){ %>
	<div class="topnav" id="myTopnav">
	<a href="index.jsp">Home</a>
 	<a href="addPlayer.jsp">Add Player</a>
  	<a href="addTeam.jsp" class="active">Add Team</a>
  	<a href="viewPlayers.jsp">View Players</a>
  	<a href="viewTeams.jsp">View Teams</a>
  	<a href="searchPlayer.jsp">Search Player</a>
  	<a href="updatePlayer.jsp">Update Player</a>
  	<a href="deletePlayer.jsp">Delete Player</a>
	</div>

	<h1 id="h1">Add a Team</h1>
	<form action ="" id ="addTeam" method="post" onsubmit="return isValidTeam()">
		<p id = "form">
			Enter team ID<br/>
			<input type="number" id="id10" name="team_id" style="width:140px"><br /><br/>
			
			Enter Team Name<br/>
			<input type="text" id="id20" name="teamname" style="width:140px"><br /><br/>
			
			 Enter Coach Name<br/>
			<input type="text" id="id30" name="coachname" style="width:140px"><br /><br/>
			<span id="errMsg" style="color:red;"> </span>
			
			<%if(request.getAttribute("message") != null){ %>
				<span style="color: green;"> <%= request.getAttribute("message") %> </span>
			<%request.removeAttribute("message");}%>
			
			
			<%if(request.getAttribute("errorMessage") != null){ %>
				<span style="color: red;"> <%= request.getAttribute("errorMessage") %> </span>
			<%request.removeAttribute("errorMessage");}%>
			
			
			<br />
			
			<input type="submit" value="Add Team" name="registerteam">
		</p>
	</form>
	
	<% if(request.getParameter("registerteam") != null){ %>
		<jsp:useBean id="team" class="com.model.Team" scope="session"></jsp:useBean>
		<jsp:setProperty property="*" name="team"/>
	<% 	response.sendRedirect("registerteam"); } %>
	
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
	
	<div class="footer" id="footer">
  		Matthew Miles <br/>
  		&copy; 2019
	</div>
	
<% } else { %>	
	<div style="color: red; text-align: center;">Please Log In: <a href="login.html">Click Here</a></div>
<% } %>

	<script type="text/javascript" src="scripts/teamValidate.js"></script>
</body>
</html>