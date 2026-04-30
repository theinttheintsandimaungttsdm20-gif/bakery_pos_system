package com.example.client.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AccountView extends JPanel {
	private JLabel lblBankAccountInformation;
	private JLabel label_1;
	private JComboBox comboBank;
	private JButton btnGet;
	private JScrollPane scrollPane;
	private JTable tableShow;

	/**
	 * Create the panel.
	 */
	public AccountView() {
		setLayout(null);
		add(getLblBankAccountInformation());
		add(getLabel_1());
		add(getComboBank());
		add(getBtnGet());
		add(getScrollPane());

	}
	public JLabel getLblBankAccountInformation() {
		if (lblBankAccountInformation == null) {
			lblBankAccountInformation = new JLabel("Bank Account Information\r\n");
			lblBankAccountInformation.setHorizontalAlignment(SwingConstants.CENTER);
			lblBankAccountInformation.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblBankAccountInformation.setBounds(10, 11, 780, 40);
		}
		return lblBankAccountInformation;
	}
	public JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Select Your Bank :");
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_1.setBounds(161, 62, 130, 31);
		}
		return label_1;
	}
	public JComboBox getComboBank() {
		if (comboBank == null) {
			comboBank = new JComboBox();
			comboBank.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboBank.setBounds(301, 62, 204, 31);
		}
		return comboBank;
	}
	public JButton getBtnGet() {
		if (btnGet == null) {
			btnGet = new JButton("GET ACCOUNTS");
			btnGet.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnGet.setBounds(526, 62, 155, 31);
		}
		return btnGet;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 117, 739, 402);
			scrollPane.setViewportView(getTableShow());
		}
		return scrollPane;
	}
	public JTable getTableShow() {
		if (tableShow == null) {
			tableShow = new JTable();
			tableShow.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return tableShow;
	}
}
