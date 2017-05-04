package com.FCI.SWE.RestRes;
import javax.ws.rs.*;

import java.sql.*;

import org.json.simple.*;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
public class DeviceManagement {
public device d;
	
	public Boolean adddevice(device d)
	{
		return (new devicedb()).registerdevice(d);
	} 
	public ArrayList viewdevice(board b)
	{
		return (new devicedb()).viewDevices(b);
	}
	public Boolean devicetoboard1(device d,board b)
	{
		return (new devicedb()).devicetoboard(d,b);
	} 
}



