package com.FCI.SWE.RestRes;

import java.sql.*;  

import static com.FCI.SWE.RestRes.provider.*;
  
public class connection {  
private static Connection con=null;  
static{  
try{  
Class.forName(DRIVER);  
con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);  
}catch(Exception e){}  
}  
  
public static Connection getCon(){  
    return con;  
}  
  
}  