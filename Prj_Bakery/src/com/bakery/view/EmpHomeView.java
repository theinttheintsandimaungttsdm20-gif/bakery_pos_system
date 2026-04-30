package com.bakery.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EmpHomeView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblEmployeeForm;
	private JLabel lblEmployeeId;
	private JTextField textId;
	private JLabel lblEnterEmployeeName;
	private JTextField textName;
	private JLabel lblEnterEmployeePassword;
	private JLabel lblEnterEmployeeEmail;
	private JTextField textEmail;
	private JLabel lblEnterEmployeePh;
	private JTextField textPh;
	private JPasswordField textPassword;
	private JLabel lblSelectRoles;
	private JRadioButton radioAdmin;
	private JRadioButton radioStaff;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnSave;
	private JScrollPane scrollPane;
	private JTable tableShow;

	/**
	 * Create the panel.
	 */
	public EmpHomeView() {
		setLayout(null);
		add(getLblEmployeeForm());
		add(getLblEmployeeId());
		add(getTextId());
		add(getLblEnterEmployeeName());
		add(getTextName());
		add(getLblEnterEmployeePassword());
		add(getLblEnterEmployeeEmail());
		add(getTextEmail());
		add(getLblEnterEmployeePh());
		add(getTextPh());
		add(getTextPassword());
		add(getLblSelectRoles());
		add(getRadioAdmin());
		add(getRadioStaff());
		add(getBtnSave());
		add(getScrollPane());

	}

	public JLabel getLblEmployeeForm() {
		if (lblEmployeeForm == null) {
			lblEmployeeForm = new JLabel("Employee Form");
			lblEmployeeForm.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmployeeForm.setFont(new Font("Tahoma", Font.BOLD, 15));
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
			textId.setEditable(false);
			textId.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textId.setBounds(375, 74, 173, 24);
			textId.setColumns(10);
		}
		return textId;
	}
	public JLabel getLblEnterEmployeeName() {
		if (lblEnterEmployeeName == null) {
			lblEnterEmployeeName = new JLabel("Enter Employee Name:");
			lblEnterEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterEmployeeName.setBounds(134, 109, 173, 24);
		}
		return lblEnterEmployeeName;
	}
	public JTextField getTextName() {
		if (textName == null) {
			textName = new JTextField();
			textName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textName.setColumns(10);
			textName.setBounds(375, 109, 173, 24);
		}
		return textName;
	}
	public JLabel getLblEnterEmployeePassword() {
		if (lblEnterEmployeePassword == null) {
			lblEnterEmployeePassword = new JLabel("Enter Employee Password:");
			lblEnterEmployeePassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterEmployeePassword.setBounds(134, 142, 173, 24);
		}
		return lblEnterEmployeePassword;
	}
	public JLabel getLblEnterEmployeeEmail() {
		if (lblEnterEmployeeEmail == null) {
			lblEnterEmployeeEmail = new JLabel("Enter Employee Email:");
			lblEnterEmployeeEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterEmployeeEmail.setBounds(134, 175, 173, 24);
		}
		return lblEnterEmployeeEmail;
	}
	public JTextField getTextEmail() {
		if (textEmail == null) {
			textEmail = new JTextField();
			textEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textEmail.setColumns(10);
			textEmail.setBounds(375, 175, 173, 24);
		}
		return textEmail;
	}
	public JLabel getLblEnterEmployeePh() {
		if (lblEnterEmployeePh == null) {
			lblEnterEmployeePh = new JLabel("Enter Employee Ph:");
			lblEnterEmployeePh.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterEmployeePh.setBounds(134, 210, 173, 24);
		}
		return lblEnterEmployeePh;
	}
	public JTextField getTextPh() {
		if (textPh == null) {
			textPh = new JTextField();
			textPh.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textPh.setColumns(10);
			textPh.setBounds(375, 210, 173, 24);
		}
		return textPh;
	}
	public JPasswordField getTextPassword() {
		if (textPassword == null) {
			textPassword = new JPasswordField();
			textPassword.setBounds(375, 142, 173, 24);
		}
		return textPassword;
	}
	public JLabel getLblSelectRoles() {
		if (lblSelectRoles == null) {
			lblSelectRoles = new JLabel("Select Roles:");
			lblSelectRoles.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSelectRoles.setBounds(134, 245, 173, 24);
		}
		return lblSelectRoles;
	}
	public JRadioButton getRadioAdmin() {
		if (radioAdmin == null) {
			radioAdmin = new JRadioButton("Admin");
			buttonGroup.add(radioAdmin);
			radioAdmin.setFont(new Font("Tahoma", Font.PLAIN, 14));
			radioAdmin.setBounds(375, 248, 109, 23);
		}
		return radioAdmin;
	}
	public JRadioButton getRadioStaff() {
		if (radioStaff == null) {
			radioStaff = new JRadioButton("Staff");
			buttonGroup.add(radioStaff);
			radioStaff.setFont(new Font("Tahoma", Font.PLAIN, 14));
			radioStaff.setBounds(496, 248, 109, 23);
		}
		return radioStaff;
	}
	public JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("SAVE");
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnSave.setBounds(334, 278, 89, 23);
		}
		return btnSave;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(22, 312, 735, 292);
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
