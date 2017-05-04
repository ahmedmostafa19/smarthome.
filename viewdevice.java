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

@Path("/viewdevice/{boardid}")
public class viewdevice {
	@GET
	  @Produces(MediaType.TEXT_PLAIN)
	
	public String view(@PathParam("boardid")String boardid)
	{
		DeviceManagement dm = new DeviceManagement();
		ArrayList d = new ArrayList();
		board b=new board();
		b.setbid(boardid);
		d=dm.viewdevice(b);
		JSONObject obj = new JSONObject();
		JSONArray arr = new JSONArray();
		for(int i = 0; i < d.size(); i++)
		{
			arr.add(d.get(i).toString());
		}
		obj.put("Devices", (Object)arr);
		
		return obj.toJSONString();
}
}