package com.xd.interfaces;

import java.rmi.Remote;

public interface Usersint extends Remote {
	public String login(String user,String pass) throws Exception; 
}
