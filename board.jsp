<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page
	import="java.net.URI , 
javax.ws.rs.client.Client , 
javax.ws.rs.client.ClientBuilder , 
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
String boardname = "";
String boardid = "";
String userid="";
String info=""; 
	try {
		boardname = request.getParameter("boardname");
		boardid = request.getParameter("boardid");
		userid = request.getParameter("userid");

		ClientConfig config1 = new ClientConfig();

		Client client = ClientBuilder.newClient(config1);

		WebTarget target = client.target(UriBuilder.fromUri(
				"http://localhost:8080/smarthome").build());
		//System.out.println(target.path("rest").path("calculator").path(Integer.toString(value1)).path(Integer.toString(value2)).toString());
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(target.path("rest")
				.path("addboard").path(boardname)
				.path(boardid).path(userid).request()

				.accept(MediaType.TEXT_PLAIN).get(String.class)

				.toString());
		JSONObject jsonObj = (JSONObject) obj;
		
		info = jsonObj.get("addboard").toString();
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
<body>
	your adding process is:
	<%=info%>
	<br>
	<a href="boardadd.jsp">Back</a>
	
	<a href="retrievedevices.jsp">showdevices</a>
	
</body>
</html>
