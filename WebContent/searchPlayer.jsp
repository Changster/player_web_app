<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Player</title>
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
  	<a href="searchPlayer.jsp" class="active">Search Player</a>
  	<a href="updatePlayer.jsp">Update Player</a>
  	<a href="deletePlayer.jsp">Delete Player</a>
	</div>

	<h1>Search for a Player</h1>
	
	<form action="search" method="post">
		<p>
			Search Criteria: <br/>
			<select id ="id150" name="criteria" onclick="myFunction()" style="width:140px;">
				<option value="0">Select</option>
				<option value="1">By Player ID</option>
				<option value="2">By Player Name</option>
				<option value="3">By Player DOB</option>
				<option value="4">By Player Email</option>
				<option value="5">By Player Gender</option>
				<option value="6">By Player Team</option>
				<option value="7">By Player Contact</option>
			</select>
			<br/><br/>
			
			
			<sql:setDataSource var="db" driver="oracle.jdbc.OracleDriver"
         	url="jdbc:oracle:thin:@localhost:1521:xe"
         	user="mmiles"  password="mmiles"/>
         	
         	<sql:query dataSource="${db}" var="result">
            	SELECT teamname from teams
         	</sql:query>
			
			
			Enter Value for Criteria: <br/>
			
			<select name="dropd" id="sel" style="display: none; width:140px">
			<option value="0">Select</option>
				<c:forEach var="row" items="${result.rows}">
				<option><c:out value="${row.teamname}"></c:out></option>
				</c:forEach>
			</select>
			
			<input id="textIn" type="text" name="searchValue" />
			<br/><br/>
			<input type="submit" value="Search" />
		</p>
	</form>
	<%if(request.getAttribute("errorMessage") != null) {%>
		<span style="color: red;"><%=request.getAttribute("errorMessage") %></span>
	<% 
	request.removeAttribute("errorMessage");
	} %>
	
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

<script>
function myFunction(){
	var dropdown = document.getElementById("sel");
	var textInput = document.getElementById("textIn");
	var x2 = document.getElementById("id150");
	
	if (x2.selectedIndex == "6" ) {
	    dropdown.style.display = "block";
	    textInput.style.display = "none";
	  } 
	else {
		dropdown.style.display = "none";
		textInput.style.display = "block";
	  }
}
</script>
	
</body>
</html>