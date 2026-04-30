package com.example.client.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import com.example.client.app.MyApp;
import com.example.client.view.AccountView;
import com.example.client.view.DepositWithdrawView;
import com.example.client.view.MainView;
import com.example.client.view.MyTableModel;
import com.example.client.view.TransactionView;
import com.example.server.model.Account;
import com.example.server.model.Transaction;
import com.example.server.rmi.AccountInf;

public class TransactionController {
	private TransactionView myView;
	public TransactionController(TransactionView v){
		this.myView=v;
		this.myView.getBtnGet().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				processTransaction();
			}
		});
	}

	private void processTransaction() {
		try {
			String cno = this.myView.getTextNo().getText();
			List<Transaction> l=MainController.myAccountRMI.getTransaction(cno);
			if(l!=null && !l.isEmpty()){
				this.myView.getLblHolderName().setText(l.get(0).getAccount().getHolderName());
				MyTableModel tm=new MyTableModel(
						new String[]{"No","Amount","Date","Time","Status"});
				tm.setRowCount(l.size());
				for(int i=0;i<l.size();i++){
					Transaction a=l.get(i);
					tm.setValueAt(i+1, i, 0);
					tm.setValueAt(a.getTranAmt(), i, 1);
					tm.setValueAt(a.getTranDate(), i, 2);
					tm.setValueAt(a.getTranTime(), i, 3);
					tm.setValueAt(a.getTranStatus(), i, 4);
				}
				this.myView.getTableShow().setModel(tm);
				this.myView.getTableShow().setRowHeight(25);
				this.myView.getTableShow().setVisible(true);
				this.myView.getLblHolderName().setVisible(true);
			}else{
				this.myView.getTableShow().setVisible(false);
				this.myView.getLblHolderName().setVisible(false);
			}
		} catch (Exception e) {	}
	}
}
