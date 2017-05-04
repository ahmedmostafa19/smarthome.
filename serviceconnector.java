package devices;
import javax.ws.rs.client.Client ;
import org.json.simple.JSONObject;
import javax.ws.rs.client.ClientBuilder ;
import javax.ws.rs.client.WebTarget ;
import javax.ws.rs.core.MediaType ;
import javax.ws.rs.core.UriBuilder ;
import org.glassfish.jersey.client.ClientConfig ;
import org.json.simple.parser.*;

public class serviceconnector  {
	public String add (String name,String ip,String port,String id) throws ParseException
	{
	ClientConfig config = new ClientConfig();

	Client client= ClientBuilder.newClient(config);

	WebTarget target = client.target(UriBuilder.fromUri(
			"http://localhost:8080/smarthome").build());
	JSONParser parser = new JSONParser();
	Object obj = parser.parse(target.path("rest")
			.path("adddevice").path(name).path(id).path(port)
			.path(ip).request()

			.accept(MediaType.TEXT_PLAIN).get(String.class)

			.toString());
	JSONObject jsonObj = (JSONObject) obj;
	String s= jsonObj.get("adddevice").toString();
	 return s;
}



	}
