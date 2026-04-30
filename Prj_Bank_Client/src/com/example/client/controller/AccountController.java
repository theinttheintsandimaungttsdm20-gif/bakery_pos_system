package com.example.client.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import com.example.client.app.MyApp;
import com.example.client.view.AccountView;
import com.example.client.view.DepositWithdrawView;
import com.example.client.view.MainView;
import com.example.client.view.MyTableModel;
import com.example.client.view.TransactionView;
import com.example.server.model.Account;
import com.example.server.rmi.AccountInf;

public class AccountController {
	private AccountView myView;
	private String[] myBankList={"Bank ONE","Bank TWO","Bank THREE"};
	public AccountController(AccountView v){
		this.myView=v;
		processLoad();
		this.myView.getBtnGet().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				processGetAccounts();
			}
		});
	}
	private void processGetAccounts(){
		try{
			System.out.println("Get Accounts At CLIENT");
			String bankName=(String)this.myView.getComboBank().getSelectedItem();
			String bankdb=new String();
			for(int i=0;i<myBankList.length;i++){
				if(bankName.equals(myBankList[i])){
					bankdb="bank"+(i+1);
					break;
				}
			}
			List<Account> l=MainController.myAccountRMI.getAllAccount(bankdb);
			if(l!=null && !l.isEmpty()){
				MyTableModel tm=new MyTableModel(
						new String[]{"No","Card No","HolderName","Balance"});
				tm.setRowCount(l.size());
				for(int i=0;i<l.size();i++){
					Account a=l.get(i);
					tm.setValueAt(i+1, i, 0);
					tm.setValueAt(a.getCardNo(), i, 1);
					tm.setValueAt(a.getHolderName(), i, 2);
					tm.setValueAt(a.getAccountBalance(), i, 3);
				}
				this.myView.getTableShow().setModel(tm);
				this.myView.getTableShow().setRowHeight(25);
				this.myView.getTableShow().setVisible(true);
			}else{
				this.myView.getTableShow().setVisible(false);
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	private void processLoad(){
		this.myView.getComboBank().addItem("SELECT");
		this.myView.getComboBank().addItem(this.myBankList[0]);
		this.myView.getComboBank().addItem(this.myBankList[1]);
		this.myView.getComboBank().addItem(this.myBankList[2]);
	}
}
