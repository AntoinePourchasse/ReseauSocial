<%@page import="fr.epsi.myEpsi.beans.Message"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Messages</title>
<!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="Page.css" rel="stylesheet">
</head>
<body>

<a href="newmessage">Nouveau Message</a>

 <% ArrayList<Message> messages = (ArrayList<Message>) request.getAttribute("messages");
if(messages == null)
	messages = new ArrayList<Message>();
for ( Message message : messages){
		%>
		<h1><% out.println(message.getTitle()); %></h1>
		<% out.println(message.getAuthor().getId()); %> <i><% out.println(message.getUpdateDate()); %></i>
		<%	out.println(message.getStatus()); %>
		<p><% out.println(message.getContent()); %></p>
		<%if(message.getAuthor().getId().equals(request.getSession().getAttribute("idUser"))){ %>
		<%} %>
<% }%>
</body>
</html>