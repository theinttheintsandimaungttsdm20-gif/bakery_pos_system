package com.example.client.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JOptionPane;

import com.example.client.app.MyApp;
import com.example.client.view.AccountView;
import com.example.client.view.DepositWithdrawView;
import com.example.client.view.MainView;
import com.example.client.view.MyTableModel;
import com.example.client.view.TransactionView;
import com.example.server.rmi.AccountInf;

public class DepositWithdrawController {
	private DepositWithdrawView myView;

	public DepositWithdrawController(DepositWithdrawView v) {
		this.myView = v;
		this.myView.getBtnProcess().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				process();
			}
		});
	}

	private void process() {
		try {
			int type = 0;
			if (this.myView.getRadioD().isSelected())
				type = 1;
			if (this.myView.getRadioW().isSelected())
				type = 2;

			String cno = this.myView.getTextNo().getText();
			int amt = Integer.parseInt(this.myView.getTextAmt().getText());
			boolean flag=false;
			if (type == 1)
				flag = MainController.myAccountRMI.deposit(cno, amt);
			else if (type == 2)
				flag = MainController.myAccountRMI.withdraw(cno, amt);
			JOptionPane.showMessageDialog(this.myView,
					((type==1?"Deposit":"Withdraw")+(flag?"is SUCCESS":"is FAIL")),
					"STATUS",JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {	}
	}
}
