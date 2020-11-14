package com.xd.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.xd.DbConnection.DataBaseConnection;
import com.xd.interfaces.Usersint;

public class Clients extends UnicastRemoteObject implements Usersint {

	/**
	 * 
	 */
	private Connection conn;
	private static final long serialVersionUID = 8707960334036665616L;

	protected Clients() throws RemoteException {
		super();
		conn = DataBaseConnection.getConnection();
	}

	@Override
	public String login(String user, String pass) throws Exception {
		String role=null;
		try {
			String sql="SELECT * FROM users WHERE user='"+user+"' AND password='"+pass+"'";
			PreparedStatement pstate= conn.prepareStatement(sql);
			ResultSet res = pstate.executeQuery();
			
			boolean nxt=res.next();
			
			if(nxt) {
				role = res.getString("uRole");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return role;
	}

}
