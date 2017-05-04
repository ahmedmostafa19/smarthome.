package com.FCI.SWE.RestRes;
import java.net.URI;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

@Path("/viewboard/{userid}")
public class viewboardservice {
	@GET
	  @Produces(MediaType.TEXT_PLAIN)
	
	public String view(@PathParam("userid")String userid)
	{
		BoardManagement bm=new BoardManagement();
		ArrayList d = new ArrayList();
		userr u=new userr();
		u.setuid(userid);
		d=bm.viewboards(u);
		JSONObject obj = new JSONObject();
		JSONArray arr = new JSONArray();
		for(int i = 0; i < d.size(); i++)
		{
			arr.add(d.get(i).toString());
		}
		obj.put("Boards", (Object)arr);
		
		return obj.toJSONString();
}
}