package com.example.client.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TransactionView extends JPanel {
	private JLabel lblBankAccountInformation;
	private JLabel lblEnterYourCard;
	private JButton btnGet;
	private JScrollPane scrollPane;
	private JTable tableShow;
	private JTextField textNo;
	private JLabel lblHolderName;

	/**
	 * Create the panel.
	 */
	public TransactionView() {
		setLayout(null);
		add(getLblBankAccountInformation());
		add(getLblEnterYourCard());
		add(getBtnGet());
		add(getScrollPane());
		add(getTextNo());
		add(getLblHolderName());

	}
	public JLabel getLblBankAccountInformation() {
		if (lblBankAccountInformation == null) {
			lblBankAccountInformation = new JLabel("Bank Account Transaction  Information\r\n");
			lblBankAccountInformation.setHorizontalAlignment(SwingConstants.CENTER);
			lblBankAccountInformation.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblBankAccountInformation.setBounds(10, 11, 780, 40);
		}
		return lblBankAccountInformation;
	}
	public JLabel getLblEnterYourCard() {
		if (lblEnterYourCard == null) {
			lblEnterYourCard = new JLabel("Enter Your Card No:\r\n");
			lblEnterYourCard.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterYourCard.setBounds(50, 62, 163, 31);
		}
		return lblEnterYourCard;
	}
	public JButton getBtnGet() {
		if (btnGet == null) {
			btnGet = new JButton("GET TRANSACTIONS");
			btnGet.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnGet.setBounds(448, 62, 235, 31);
		}
		return btnGet;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 136, 739, 383);
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
	public JTextField getTextNo() {
		if (textNo == null) {
			textNo = new JTextField();
			textNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textNo.setBounds(227, 62, 211, 31);
			textNo.setColumns(10);
		}
		return textNo;
	}
	public JLabel getLblHolderName() {
		if (lblHolderName == null) {
			lblHolderName = new JLabel("Enter Your Card No:\r\n");
			lblHolderName.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblHolderName.setBounds(20, 104, 235, 31);
		}
		return lblHolderName;
	}
}
