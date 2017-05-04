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

String info=""; 
	try {
		

		ClientConfig config1 = new ClientConfig();

		Client client = ClientBuilder.newClient(config1);

		WebTarget target = client.target(UriBuilder.fromUri(
				"http://localhost:8080/smarthome").build());
		//System.out.println(target.path("rest").path("calculator").path(Integer.toString(value1)).path(Integer.toString(value2)).toString());
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(target.path("rest")
				.path("viewdevice").request()

				.accept(MediaType.TEXT_PLAIN).get(String.class)

				.toString());
		JSONObject jsonObj = (JSONObject) obj;
		info = jsonObj.get("Devices").toString();
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
<body>
	your devices are 
	<%=info%>
	<br>
	
	
</body>
</html>
