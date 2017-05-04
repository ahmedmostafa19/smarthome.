package com.FCI.SWE.RestRes;


import java.sql.*;
import java.util.ArrayList;

public class board_db {
	public  Boolean registerboard(board b,userr u){  
		int status=0;  
		try{  
			
		Connection con=connection.getCon(); 
    	PreparedStatement ps = con.prepareStatement("INSERT INTO board (name,boardid,userid) VALUES (?, ?,?)");
		ps.setString(1,b.getbname());
		ps.setString(2,b.getbid());
		ps.setString(3,u.getuid());
				
		
		 
		status=ps.executeUpdate();
		
		
		
		
		
		
		 
		}catch(Exception e){}  
		      if (status==0)
		    	  return false;
		      else 
		    	  return true;
		      
		}  
	
	
	public ArrayList viewboards(userr u) {
		//ResultSet rs = null;
		//Statement stmt = null;
		ArrayList d = new ArrayList();
		String uid =u.getuid();
		
		try {
			Connection con=connection.getCon(); 
			Statement st= con.createStatement(); 
			ResultSet rs=st.executeQuery("select name from board WHERE userid='"+uid+"'"); 
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

}
