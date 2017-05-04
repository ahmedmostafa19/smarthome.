package com.FCI.SWE.RestRes;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.*;

@Path("/adddevice/{name}/{id}/{port}/{ip}")
public class deviceservice {
	@GET
	  @Produces(MediaType.TEXT_PLAIN)
	public String signupp(@PathParam("name")String name, @PathParam("id") String id,@PathParam("port") String port,@PathParam("ip") String ip)
	{
		  
		device d=new device();
		
		d.setdname(name);
		d.setd_id(id);
		d.setdport(id);
		d.setdip(ip);
		d.setdport(port);
		
		DeviceManagement dm=new DeviceManagement();
		JSONObject object = new JSONObject();
		 object.put("adddevice", dm.adddevice(d));
		 
		return object.toJSONString();
		
}
	
	
}