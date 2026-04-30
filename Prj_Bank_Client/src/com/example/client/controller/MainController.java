package com.example.client.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;

import com.example.client.app.MyApp;
import com.example.client.view.AccountView;
import com.example.client.view.DepositWithdrawView;
import com.example.client.view.MainView;
import com.example.client.view.MyTableModel;
import com.example.client.view.TransactionView;
import com.example.server.rmi.AccountInf;

public class MainController {
	private MainView myView;
	public static AccountInf myAccountRMI;
	public MainController(MainView v){
		this.myView=v;
		processBindRMI();
		MyMenuListener ml=new MyMenuListener();
		this.myView.getItemAccounts().addActionListener(ml);
		this.myView.getItemDW().addActionListener(ml);
		this.myView.getItemTransactions().addActionListener(ml);
	}
	private void processBindRMI(){
		try {  
	         Registry registry = LocateRegistry.getRegistry(null); 
	         myAccountRMI= (AccountInf) registry.lookup("BankRMI");
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      } 
	}
	private class MyMenuListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(myView.getItemAccounts()))
				prepareAccounts();
			if(e.getSource().equals(myView.getItemTransactions()))
				prepareTransactions();
			if(e.getSource().equals(myView.getItemDW()))
				prepareDW();
		}		
	}
	private void clearOldView(){
		for(Component c:this.myView.getContentPane().getComponents()){
			c.setVisible(false);
			this.myView.getContentPane().remove(c);
		}
	}
	private void prepareAccounts(){
		clearOldView();
		AccountView v=new AccountView();
		v.setSize(800, 600);
		v.setVisible(true);
		this.myView.getContentPane().add(v);
		new AccountController(v);
	}
	private void prepareTransactions(){
		clearOldView();
		TransactionView v=new TransactionView();
		v.setSize(800, 600);
		v.setVisible(true);
		this.myView.getContentPane().add(v);
		new TransactionController(v);
	}
	private void prepareDW(){
		clearOldView();
		DepositWithdrawView v=new DepositWithdrawView();
		v.setSize(800, 600);
		v.setVisible(true);
		this.myView.getContentPane().add(v);
		new DepositWithdrawController(v);
	}
}
