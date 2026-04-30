package com.bakery.util;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.example.server.rmi.AccountInf;

public class BankRMIUtil {
	public static final String ACCOUNT_BANK1="1111-9999-9999-9999";
	public static final String ACCOUNT_BANK2="2222-9999-9999-9999";
	public static final String ACCOUNT_BANK3="3333-9999-9999-9999";
	public static AccountInf BANK_RMI;
	static{
		try {  
	         Registry registry = LocateRegistry.getRegistry(null); 
	         BANK_RMI= (AccountInf) registry.lookup("BankRMI");
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      } 
	}

}
