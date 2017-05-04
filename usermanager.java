package com.FCI.SWE.RestRes;

public class usermanager {
public userr user;
	
	public Boolean signupp(userr u)
	{
		return (new userdb()).register(u);
	} 
public Boolean signin(userr u2)
{
	return (new userdb()).signin(u2);
}
}
