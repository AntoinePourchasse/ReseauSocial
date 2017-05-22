<%@page import="java.util.List"%>
<%@page import="fr.epsi.myEpsi.beans.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="Page.css" rel="stylesheet">
</head>
<body>
	Liste des utilisateurs
	
	<%
		List<User> users = (List<User>) request.getAttribute("users");
		for(User user : users){
			out.println(user.getId());
		}
	%>
</body>
</html>