package com.xd.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.xd.interfaces.UsersI;

public class Clients extends UnicastRemoteObject implements UsersI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8707960334036665616L;

	protected Clients() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String login(String user, String pass) throws Exception {
		System.out.println("user : "+user+" pass : "+pass);
		String results;
		if(user.equals("admin") && pass.equals("jani")) {
			results = "admin";
		}else if(user.equals("users") && pass.equals("pass")) {
			results = "users";
		}else {
			results = null;
		}
		
		return results;
	}

}
