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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class DepositWithdrawView extends JPanel {
	private JLabel lblBankAccountInformation;
	private JLabel lblEnterYourCard;
	private JButton btnProcess;
	private JTextField textNo;
	private JLabel lblEnterAmount;
	private JTextField textAmt;
	private JLabel lblSelectType;
	private JRadioButton radioD;
	private JRadioButton radioW;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public DepositWithdrawView() {
		setLayout(null);
		add(getLblBankAccountInformation());
		add(getLblEnterYourCard());
		add(getBtnProcess());
		add(getTextNo());
		add(getLblEnterAmount());
		add(getTextAmt());
		add(getLblSelectType());
		add(getRadioD());
		add(getRadioW());

	}
	public JLabel getLblBankAccountInformation() {
		if (lblBankAccountInformation == null) {
			lblBankAccountInformation = new JLabel("Bank Account Deposit (or) Withdraw  Information\r\n");
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
			lblEnterYourCard.setBounds(128, 62, 163, 31);
		}
		return lblEnterYourCard;
	}
	public JButton getBtnProcess() {
		if (btnProcess == null) {
			btnProcess = new JButton("PROCESS");
			btnProcess.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnProcess.setBounds(278, 206, 155, 31);
		}
		return btnProcess;
	}
	public JTextField getTextNo() {
		if (textNo == null) {
			textNo = new JTextField();
			textNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textNo.setBounds(305, 62, 211, 31);
			textNo.setColumns(10);
		}
		return textNo;
	}
	public JLabel getLblEnterAmount() {
		if (lblEnterAmount == null) {
			lblEnterAmount = new JLabel("Enter Amount:");
			lblEnterAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterAmount.setBounds(128, 104, 163, 31);
		}
		return lblEnterAmount;
	}
	public JTextField getTextAmt() {
		if (textAmt == null) {
			textAmt = new JTextField();
			textAmt.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textAmt.setColumns(10);
			textAmt.setBounds(305, 104, 211, 31);
		}
		return textAmt;
	}
	public JLabel getLblSelectType() {
		if (lblSelectType == null) {
			lblSelectType = new JLabel("Select Type :");
			lblSelectType.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSelectType.setBounds(128, 147, 163, 31);
		}
		return lblSelectType;
	}
	public JRadioButton getRadioD() {
		if (radioD == null) {
			radioD = new JRadioButton("Deposit");
			buttonGroup.add(radioD);
			radioD.setFont(new Font("Tahoma", Font.PLAIN, 14));
			radioD.setBounds(305, 147, 109, 31);
		}
		return radioD;
	}
	public JRadioButton getRadioW() {
		if (radioW == null) {
			radioW = new JRadioButton("Withdraw");
			buttonGroup.add(radioW);
			radioW.setFont(new Font("Tahoma", Font.PLAIN, 14));
			radioW.setBounds(429, 147, 109, 31);
		}
		return radioW;
	}
}
