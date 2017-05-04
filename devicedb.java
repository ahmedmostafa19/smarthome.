package com.FCI.SWE.RestRes;
import com.FCI.SWE.RestRes.device;

import java.sql.*;
import java.util.ArrayList;
public class devicedb {
	public Boolean registerdevice(device d){  
		int status=0;  
		
		try{  
			
		Connection con=connection.getCon(); 
    	PreparedStatement ps = con.prepareStatement("INSERT INTO device (name,id,ip,port) VALUES (?,?,?,?)");
		ps.setString(1,d.getdname());
		ps.setString(2,d.getd_id());
		ps.setString(3,d.getdip());
		ps.setString(4,d.getdport());
		
		status=ps.executeUpdate();
		
		 
		}catch(Exception e){}  
		    
		if(status==0)
		return false;
		else 
			return true;
		}  
	public ArrayList viewDevices(board b) {
		//ResultSet rs = null;
		//Statement stmt = null;
		String bid=b.getbid();
		ArrayList d = new ArrayList();
		try {
			Connection con=connection.getCon(); 
			Statement st= con.createStatement(); 
			ResultSet rs=st.executeQuery("select name from device WHERE boardid='"+bid+"'"); 
			ResultSetMetaData rsmd = rs.getMetaData();
			 int columnCount = rsmd.getColumnCount();
			while (rs.next()) {
				
				for (int i = 1; i <= columnCount; i++ ) {
					String columnValue = rs.getString(i);
					d.add(columnValue);
				}
				
				
			}
				
			}
		
		catch (Exception e) {
			
		}
	
return d;
}
	public Boolean devicetoboard(device d ,board b){  
		int status=0;  
		
		String dname=d.getdname();
		String bid=b.getbid();
		try{  
		Connection con=connection.getCon();  
		//PreparedStatement ps=con.prepareStatement(  "INSERT INTO device(boardid)Where name=? VALUES(?)");
		PreparedStatement ps=con.prepareStatement(  "	UPDATE `smart`.`device` SET `boardid`='"+bid+"' WHERE `name`='"+dname+"'");
	
		
		              
		status=ps.executeUpdate();  
		              
		}catch(Exception e){}  
		  
		if(status==0)
			return false;
			else 
				return true;
		  
		}
}