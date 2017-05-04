package com.FCI.SWE.RestRes;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.*;

@Path("/signup/{username}/{password}/{userid}")
public class signup {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String signupp(@PathParam("username")String username, @PathParam("password") String password,@PathParam("userid") String userid)
	{
		  
		userr u=new userr();
		u.setUname(username);
		u.setUpass(password);
		u.setuid(userid);
		usermanager m=new usermanager();
		JSONObject object = new JSONObject();
		 object.put("signup", m.signupp(u));
		 
		return object.toJSONString();
		
		
		
		
		
	}
}