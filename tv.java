package devices;
import org.json.simple.JSONObject;

import org.json.simple.parser.ParseException;

//import com.FCI.SWE.RestRes.deviceservice;
import com.FCI.SWE.RestRes.device;
import com.FCI.SWE.RestRes.DeviceManagement;
import com.FCI.SWE.RestRes.userr;
public class tv {
	
	
	
public String excecute(String state)
{
	
	
	if (state=="on")
			{
		state="on";
		
			}
	if (state=="off")
	{
	state ="off";

	}
	return state;
}

	public static void main(String[] args)throws ParseException{
		String name="tv";
		String id="80";
		String port="5000";
		String ip="127.0.0.1";
		
	
		serviceconnector s=new serviceconnector();
		System.out.println(s.add(name, ip, port, id));
		
	
	}
	
}
