package com.FCI.SWE.RestRes;
import java.sql.*;
public class userdb {
	
	public  Boolean register(userr u){  
		int status=0;  
		try{  
			
		Connection con=connection.getCon(); 
    	PreparedStatement ps = con.prepareStatement("INSERT INTO user (name,password,userid) VALUES (?, ?,?)");
	    ps.setString(1,u.getUname());
		ps.setString(2,u.getUpass());
		ps.setString(3,u.getuid());
	
		 
		status=ps.executeUpdate();
		
		
		}catch(Exception e){}  
		   
		if(status==0)
			return false;
		
		else			
		return true;  
		}
	
	public Boolean signin(userr u2){  
		boolean status=false;  
		try{  
		Connection con=connection.getCon();  
		             
		PreparedStatement ps=con.prepareStatement(  
		    "select * from user where  name=? and password=?");  

		  
		ps.setString(1,u2.getUname());  
		ps.setString(2, u2.getUpass());  
		              
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		              
		}catch(Exception e){}  
		  
		return status;  
		  
		}
}  
