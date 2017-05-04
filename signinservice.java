package com.FCI.SWE.RestRes;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.*;
@Path("/signin/{username}/{password}")
public class signinservice {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String signin(@PathParam("username")String username, @PathParam("password") String password)
	{
		userr u=new userr();
		u.setUname(username);
		u.setUpass(password);
		usermanager m=new usermanager();
		JSONObject object = new JSONObject();
		 object.put("signin", m.signin(u));
		 
		return object.toJSONString();
		
	}
	
	
	
	
	
	

}

