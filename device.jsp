<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page
	import="java.net.URI , 
javax.ws.rs.client.Client , 
javax.ws.rs.client.ClientBuilder , 
java.sql.*, 
com.FCI.SWE.RestRes.connection,
com.FCI.SWE.RestRes.board,
javax.ws.rs.client.WebTarget , 
javax.ws.rs.core.MediaType , 
javax.ws.rs.core.Response ,
javax.ws.rs.core.UriBuilder , 
org.glassfish.jersey.client.ClientConfig ,
com.FCI.SWE.RestRes.signup , org.json.simple.parser.*"%>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Lab1</title>
</head>
<%
String boardid = request.getParameter("boardid");
String deviceid = request.getParameter("deviceid");
Connection con=connection.getCon(); 
PreparedStatement ps = con.prepareStatement("INSERT INTO device (boardid) where id=deviceid VALUES (boardid)");

ps.executeUpdate();
%>
<body>
	
	<br>
	<a href="deviceadd.jsp">Back</a>
</body>
</html>
