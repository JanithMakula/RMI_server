package com.xd.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

	public static void main(String[] args) throws Exception{
		Registry reg = LocateRegistry.createRegistry(1888);
		
		System.out.println("Server start ...");
		Clients cl =new Clients();
		reg.rebind("UserEvents", cl);
		
	}

}
