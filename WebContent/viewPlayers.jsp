<%@page import="com.bo.CrudBO"%>
<%@page import="com.bo.CrudBOImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.Player"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Players</title>
<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
<% if(session.getAttribute("username") != null){ %>
	<div class="topnav" id="myTopnav">
		<a href="index.jsp">Home</a>
		<a href="addPlayer.jsp">Add Player</a>
		<a href="addTeam.jsp">Add Team</a>
		<a href="viewPlayers.jsp" class="active">View Players</a>
		<a href="viewTeams.jsp">View Teams</a>
		<a href="searchPlayer.jsp">Search Player</a>
		<a href="updatePlayer.jsp">Update Player</a>
		<a href="deletePlayer.jsp">Delete Player</a>
	</div>
		<h1>All Players:</h1>
		<br/>
		<br/>
		<table border="1px">
			<tr>
				<th>Player ID</th>
				<th>Player Name</th>
				<th>Player DOB</th>
				<th>Player Email</th>
				<th>Player Gender</th>
				<th>Team Name</th>
				<th>Player Contact</th>
			</tr>
			<tr>
		<% 
		CrudBO crudBO = new CrudBOImpl();
		List<Player> playerList = new ArrayList();
		playerList = crudBO.viewPlayers();
		for(int i = 0; i < playerList.size(); i++){ %>
			<td><%=playerList.get(i).getId() %></td>
			<td><%=playerList.get(i).getName() %></td>
			<td><%=playerList.get(i).getDob() %></td>
			<td><%=playerList.get(i).getEmail() %></td>
			<td><%=playerList.get(i).getGender() %></td>
			<td><%=playerList.get(i).getTeamname() %></td>
			<td><%=playerList.get(i).getContact() %></td>
			</tr>
		<% }
		%>
		</table>
		
		<% } else { %>	
		<div style="color: red; text-align: center;">Please Log In: <a href="login.html">Click Here</a></div>
	<% } %>
</body>
</html>