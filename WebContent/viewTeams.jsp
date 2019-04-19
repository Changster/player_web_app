<%@page import="com.model.Team"%>
<%@page import="com.bo.CrudBO"%>
<%@page import="com.bo.CrudBOImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Teams</title>
<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
<% if(session.getAttribute("username") != null){ %>
	<div class="topnav" id="myTopnav">
		<a href="index.jsp">Home</a>
		<a href="addPlayer.jsp">Add Player</a>
		<a href="addTeam.jsp">Add Team</a>
		<a href="viewPlayers.jsp">View Players</a>
		<a href="viewTeams.jsp" class="active">View Teams</a>
		<a href="searchPlayer.jsp">Search Player</a>
		<a href="updatePlayer.jsp">Update Player</a>
		<a href="deletePlayer.jsp">Delete Player</a>
	</div>
		<h1>All Teams:</h1>
		<br/>
		<br/>
		<table border="1px">
			<tr>
				<th>Team ID</th>
				<th>Team Name</th>
				<th>Coach Name</th>
			</tr>
			<tr>
		<% 
		CrudBO crudBO = new CrudBOImpl();
		List<Team> teamList = new ArrayList();
		teamList = crudBO.viewTeams();
		for(int i = 0; i < teamList.size(); i++){ %>
			<td><%=teamList.get(i).getTeam_id() %></td>
			<td><%=teamList.get(i).getTeamname() %></td>
			<td><%=teamList.get(i).getCoachname() %></td>
			</tr>
		<% }
		%>
		</table>
		
		<% } else { %>	
		<div style="color: red; text-align: center;">Please Log In: <a href="login.html">Click Here</a></div>
	<% } %>
</body>
</html>