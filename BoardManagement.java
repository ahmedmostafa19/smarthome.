package com.FCI.SWE.RestRes;
import javax.ws.rs.*;

import java.sql.*;
import java.util.ArrayList;

import org.json.simple.*;

import javax.ws.rs.core.MediaType;

public class BoardManagement {
public board b;
	
	public Boolean addboard(board b,userr u)
	{
		return (new board_db()).registerboard(b,u);
	} 
	
	public ArrayList viewboards(userr u)
	{
		return (new board_db()).viewboards(u);
	}

}



