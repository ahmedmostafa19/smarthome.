package com.FCI.SWE.RestRes;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.*;

@Path("/devicetoboard/{name}/{boardid}")
public class devicetoboard {
	
	@GET
	  @Produces(MediaType.TEXT_PLAIN)
	
	public String  adddevicetoboard(@PathParam("name")String name,@PathParam("boardid")String boardid){
		board b=new board();
		b.setbid(boardid);
		device d=new device();
		d.setdname(name);
		DeviceManagement dm=new DeviceManagement();
		JSONObject object = new JSONObject();
		 object.put("devicetoboard", dm.devicetoboard1(d, b));
		
		 return object.toJSONString();
	}
	
}