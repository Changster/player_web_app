<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Player</title>
<link rel="stylesheet" href="styles/styles.css">
</head>
<body id="body">


	<h1 id="h1">Add a Player</h1>	
	
	<form action="" id ="addPlayer" method="post" onsubmit="return isValidPlayer()" >
		<p id="form">
		
			Player Name:<br/>
			<input type="text" id="id1" name="name" style="width:140px"> <br /><br/>
			 
			Date of Birth:<br/>
			 <input type="date" id="id2" name="t_dob" style="width:140px"> <br /> <br/>
				 
			Email:<br/>
			<input type="email" id="id3"  name="email" style="width:140px"> <br /><br/>
				
			Gender:<br /> 
			<input type="radio" id="id4" name ="gender" value="M">Male
			<input type="radio" id="id5" name ="gender" value="F">Female
			<label for="gender" class="error"></label>
			<br /> <br/>
				
				
			<sql:setDataSource var="db" driver="oracle.jdbc.OracleDriver"
         	url="jdbc:oracle:thin:@localhost:1521:xe"
         	user="mmiles"  password="mmiles"/>
         	
         	<sql:query dataSource="${db}" var="result">
            	SELECT teamname from teams
         	</sql:query>
			
				
			Team Name:<br/>
			<select name="teamname" id="id6" style="width:140px">
				<option value="0">Select</option>
				<c:forEach var="row" items="${result.rows}">
				<option><c:out value="${row.teamname}"></c:out></option>
				</c:forEach>
			</select>
			
			<br /> <br/>
				
			Contact:<br/>
			<input type="number" id="id7" name="contact" style="width:140px"> <br /><br/>
			
			Password:<br/>
			<input type="password" id="id8" name="password" style="width:140px"> <br /><br/>
			
			
			<span id="errMsg" style="color:red;"> </span>
			
			
			<%if(request.getAttribute("message") != null){ %>
				<span style="color: green;"> <%= request.getAttribute("message") %> </span>
			<%request.removeAttribute("message");}%>
			
			
			<%if(request.getAttribute("errorMessage") != null){ %>
				<span style="color: red;"> <%= request.getAttribute("errorMessage") %> </span>
			<%request.removeAttribute("errorMessage");}%>
			
			<br />
				
			<input type="submit" value="Register Player" name="registerplayer">
		</p>
	</form>
	
	
	<% if(request.getParameter("registerplayer") != null){ %>
		<jsp:useBean id="player" class="com.model.Player" scope="session"></jsp:useBean>
		<jsp:setProperty property="*" name="player"/>
	<% 	response.sendRedirect("regplayer"); } %>
	
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	
	<div class="footer" id="footer">
  		Matthew Miles <br/>
  		&copy; 2019
	</div>

	<script type="text/javascript" src="scripts/playerValidate.js"></script>
</body>
</html>