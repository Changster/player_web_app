<%@page import="com.model.Player"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="st" uri="WEB-INF/playertags.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Results</title>
<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
	<div class="topnav" id="myTopnav">
		<a href="index.jsp">Home</a>
	 	<a href="addPlayer.jsp">Add Player</a>
	  	<a href="addTeam.jsp">Add Team</a>
	  	<a href="viewPlayers.jsp">View Players</a>
	  	<a href="viewTeams.jsp">View Teams</a>
	  	<a href="searchPlayer.jsp" class="active">Search Player</a>
	  	<a href="updatePlayer.jsp">Update Player</a>
	  	<a href="deletePlayer.jsp">Delete Player</a>
	</div>
	<h1>Your Search Results:</h1>
	<br/>
	<br/>
	<%if(session != null && session.getAttribute("playerList") != null){ 
	String headers[] = (String[]) session.getAttribute("headers");
	List<Player> playerList = (List<Player>) session.getAttribute("playerList");
	%>
		<st:playerResults playerList="<%=playerList %>" headers="<%=headers %>"/>
	<% } %>
	
</body>
</html>