package com.example.server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import com.example.server.app.MyApp;
import com.example.server.dao.config.DatabaseUtil;
import com.example.server.rmi.AccountInf;
import com.example.server.rmi.impl.AccountImpl;
import com.example.server.view.MainView;
import com.example.server.view.MyTableModel;

public class MainController {
	private MainView myView;
	public static HashMap<Integer,String> myUrlList;
	private String[] myBankList={"Bank ONE","Bank TWO","Bank THREE"};
	public MainController(MainView v){
		this.myView=v;
		this.myUrlList=new HashMap<>();
		processRMIBind();
		processLoad();
		processTable();
		this.myView.getBtnOpen().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				processOpen();
			}
		});
		this.myView.getBtnClose().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				processClose();
			}
		});
	}
	private void processRMIBind(){
		try {
			AccountImpl obj = new AccountImpl();
			AccountInf stub = (AccountInf) UnicastRemoteObject.exportObject(obj, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("BankRMI", stub);
			this.myView.getLblStatus().setText("BANK SERVER IS READY");
			System.err.println("Server ready for BANK");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
	private void processLoad(){
		this.myView.getComboBank().addItem("SELECT");
		this.myView.getComboBank().addItem(this.myBankList[0]);
		this.myView.getComboBank().addItem(this.myBankList[1]);
		this.myView.getComboBank().addItem(this.myBankList[2]);
	}
	private void processTable(){
		MyTableModel tm=new MyTableModel(new String[]{"NO","BANK NAME","STATUS"});
		tm.setRowCount(3);
		for(int i=0;i<3;i++){
			tm.setValueAt(i+1, i, 0);
			tm.setValueAt(this.myBankList[i], i, 1);
			tm.setValueAt(
					this.myUrlList.containsKey(i+1)?"OPEN":"CLOSE", i, 2);
		}		
		this.myView.getTableBank().setModel(tm);
		this.myView.getTableBank().setRowHeight(50);
	}
	private void processOpen(){
		String selectName=(String)this.myView.getComboBank().getSelectedItem();
		if(!selectName.toUpperCase().equals("SELECT")){
			for(int i=0;i<this.myBankList.length;i++){
				if(this.myBankList[i].equals(selectName)){
					String url=new String();
					switch(i){
						case 0:url=DatabaseUtil.BANK1_URL;break;
						case 1:url=DatabaseUtil.BANK2_URL;break;
						case 2:url=DatabaseUtil.BANK3_URL;break;
					}
					this.myUrlList.put(i+1,url);
					break;
				}
			}
		}
		processTable();
	}
	private void processClose(){
		String selectName=(String)this.myView.getComboBank().getSelectedItem();
		if(!selectName.toUpperCase().equals("SELECT")){
			for(int i=0;i<this.myBankList.length;i++){
				if(this.myBankList[i].equals(selectName)){
					this.myUrlList.remove(i+1);
					break;
				}
			}
		}
		processTable();
	}
}
