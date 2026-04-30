package com.bakery.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblEmployeeForm;
	private JLabel lblEmployeeId;
	private JTextField textId;
	private JLabel lblEnterEmployeePassword;
	private JPasswordField textPassword;
	private JButton btnLogin;

	/**
	 * Create the panel.
	 */
	public LoginView() {
		setLayout(null);
		add(getLblEmployeeForm());
		add(getLblEmployeeId());
		add(getTextId());
		add(getLblEnterEmployeePassword());
		add(getTextPassword());
		add(getBtnLogin());

	}

	public JLabel getLblEmployeeForm() {
		if (lblEmployeeForm == null) {
			lblEmployeeForm = new JLabel("Bakery Shop Login");
			lblEmployeeForm.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmployeeForm.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblEmployeeForm.setBounds(22, 21, 746, 30);
		}
		return lblEmployeeForm;
	}
	public JLabel getLblEmployeeId() {
		if (lblEmployeeId == null) {
			lblEmployeeId = new JLabel("Employee Id:");
			lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEmployeeId.setBounds(134, 74, 173, 24);
		}
		return lblEmployeeId;
	}
	public JTextField getTextId() {
		if (textId == null) {
			textId = new JTextField();
			textId.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textId.setBounds(375, 74, 173, 24);
			textId.setColumns(10);
		}
		return textId;
	}
	public JLabel getLblEnterEmployeePassword() {
		if (lblEnterEmployeePassword == null) {
			lblEnterEmployeePassword = new JLabel("Enter Employee Password:");
			lblEnterEmployeePassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterEmployeePassword.setBounds(134, 109, 173, 24);
		}
		return lblEnterEmployeePassword;
	}
	public JPasswordField getTextPassword() {
		if (textPassword == null) {
			textPassword = new JPasswordField();
			textPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textPassword.setBounds(375, 109, 173, 24);
		}
		return textPassword;
	}
	public JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnLogin.setBounds(325, 164, 89, 23);
		}
		return btnLogin;
	}
}
