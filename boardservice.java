package com.FCI.SWE.RestRes;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.*;

@Path("/addboard/{name}/{boardid}/{userid}")
public class boardservice {
	@GET
	  @Produces(MediaType.TEXT_PLAIN)
	public String addboard(@PathParam("name")String name, @PathParam("boardid") String boardid,@PathParam("userid") String userid)
	{
		  
	board b=new board();
	userr u=new userr();
		b.setbname(name);
		b.setbid(boardid);
		u.setuid(userid);
		BoardManagement bm=new BoardManagement();
		JSONObject object = new JSONObject();
		 object.put("addboard", bm.addboard(b,u));
		 
		return object.toJSONString();
		
		
		
		
		
	}
}