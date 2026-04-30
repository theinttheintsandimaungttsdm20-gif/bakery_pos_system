package com.bakery.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class OrderReceiptView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblEmployeeForm;
	private JLabel lblEmployeeId;
	private JTextField textNo;
	private JLabel lblEnterEmployeeName;
	private JTextField textReceiveDate;
	private JLabel lblEnterEmployeePassword;
	private JLabel lblEnterEmployeeEmail;
	private JLabel lblEnterEmployeePh;
	private JButton btnSearch;
	private JTextField textOrderDate;
	private JTextField textCustName;
	private JTextField textCustPh;
	private JScrollPane scrollPane;
	private JTable tableShow;
	private JButton btnClear;
	private JLabel lblEmployeeNo;
	private JTextField textEmpNo;

	/**
	 * Create the panel.
	 */
	public OrderReceiptView() {
		setLayout(null);
		add(getLblEmployeeForm());
		add(getLblEmployeeId());
		add(getTextNo());
		add(getLblEnterEmployeeName());
		add(getTextReceiveDate());
		add(getLblEnterEmployeePassword());
		add(getLblEnterEmployeeEmail());
		add(getLblEnterEmployeePh());
		add(getBtnSearch());
		add(getTextOrderDate());
		add(getTextCustName());
		add(getTextCustPh());
		add(getScrollPane());
		add(getBtnClear());
		add(getLblEmployeeNo());
		add(getTextEmpNo());

	}

	public JLabel getLblEmployeeForm() {
		if (lblEmployeeForm == null) {
			lblEmployeeForm = new JLabel("Order Receipt Form");
			lblEmployeeForm.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmployeeForm.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblEmployeeForm.setBounds(22, 21, 746, 30);
		}
		return lblEmployeeForm;
	}
	public JLabel getLblEmployeeId() {
		if (lblEmployeeId == null) {
			lblEmployeeId = new JLabel("Enter Order Invoice No :");
			lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEmployeeId.setBounds(22, 76, 161, 24);
		}
		return lblEmployeeId;
	}
	public JTextField getTextNo() {
		if (textNo == null) {
			textNo = new JTextField();
			textNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textNo.setBounds(198, 77, 252, 24);
			textNo.setColumns(10);
		}
		return textNo;
	}
	public JLabel getLblEnterEmployeeName() {
		if (lblEnterEmployeeName == null) {
			lblEnterEmployeeName = new JLabel("Order Date :");
			lblEnterEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterEmployeeName.setBounds(22, 111, 173, 24);
		}
		return lblEnterEmployeeName;
	}
	public JTextField getTextReceiveDate() {
		if (textReceiveDate == null) {
			textReceiveDate = new JTextField();
			textReceiveDate.setEditable(false);
			textReceiveDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textReceiveDate.setColumns(10);
			textReceiveDate.setBounds(198, 144, 252, 24);
		}
		return textReceiveDate;
	}
	public JLabel getLblEnterEmployeePassword() {
		if (lblEnterEmployeePassword == null) {
			lblEnterEmployeePassword = new JLabel("Receive Date :");
			lblEnterEmployeePassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterEmployeePassword.setBounds(22, 144, 173, 24);
		}
		return lblEnterEmployeePassword;
	}
	public JLabel getLblEnterEmployeeEmail() {
		if (lblEnterEmployeeEmail == null) {
			lblEnterEmployeeEmail = new JLabel("Customer Name :");
			lblEnterEmployeeEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterEmployeeEmail.setBounds(22, 177, 173, 24);
		}
		return lblEnterEmployeeEmail;
	}
	public JLabel getLblEnterEmployeePh() {
		if (lblEnterEmployeePh == null) {
			lblEnterEmployeePh = new JLabel("Customer Ph:");
			lblEnterEmployeePh.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterEmployeePh.setBounds(22, 212, 173, 24);
		}
		return lblEnterEmployeePh;
	}
	public JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("TAKE ORDER");
			btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnSearch.setBounds(460, 76, 182, 24);
		}
		return btnSearch;
	}
	public JTextField getTextOrderDate() {
		if (textOrderDate == null) {
			textOrderDate = new JTextField();
			textOrderDate.setEditable(false);
			textOrderDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textOrderDate.setColumns(10);
			textOrderDate.setBounds(198, 111, 252, 24);
		}
		return textOrderDate;
	}
	public JTextField getTextCustName() {
		if (textCustName == null) {
			textCustName = new JTextField();
			textCustName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textCustName.setEditable(false);
			textCustName.setColumns(10);
			textCustName.setBounds(198, 179, 252, 24);
		}
		return textCustName;
	}
	public JTextField getTextCustPh() {
		if (textCustPh == null) {
			textCustPh = new JTextField();
			textCustPh.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textCustPh.setEditable(false);
			textCustPh.setColumns(10);
			textCustPh.setBounds(198, 212, 252, 24);
		}
		return textCustPh;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(22, 247, 735, 372);
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
	public JButton getBtnClear() {
		if (btnClear == null) {
			btnClear = new JButton("CLEAR");
			btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnClear.setBounds(460, 111, 93, 24);
		}
		return btnClear;
	}
	public JLabel getLblEmployeeNo() {
		if (lblEmployeeNo == null) {
			lblEmployeeNo = new JLabel("Employee No:");
			lblEmployeeNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEmployeeNo.setBounds(460, 212, 98, 24);
		}
		return lblEmployeeNo;
	}
	public JTextField getTextEmpNo() {
		if (textEmpNo == null) {
			textEmpNo = new JTextField();
			textEmpNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textEmpNo.setEditable(false);
			textEmpNo.setColumns(10);
			textEmpNo.setBounds(568, 213, 200, 24);
		}
		return textEmpNo;
	}
}
