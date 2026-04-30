package com.bakery.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SalesView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblEmployeeForm;
	private JLabel lblEmployeeId;
	private JTextField textInv;
	private JLabel lblEnterEmployeeName;
	private JTextField textId;
	private JLabel lblEnterEmployeePassword;
	private JLabel lblEnterEmployeeEmail;
	private JTextField textPrice;
	private JLabel lblEnterEmployeePh;
	private JTextField textQty;
	private JButton btnAdd;
	private JScrollPane scrollPane;
	private JTable tableInvoice;
	private JButton btnPaid;
	private JTextField textName;
	private JLabel lblGrandTotal;
	private JTextField textGrandTotal;

	/**
	 * Create the panel.
	 */
	public SalesView() {
		setLayout(null);
		add(getLblEmployeeForm());
		add(getLblEmployeeId());
		add(getTextInv());
		add(getLblEnterEmployeeName());
		add(getTextId());
		add(getLblEnterEmployeePassword());
		add(getLblEnterEmployeeEmail());
		add(getTextPrice());
		add(getLblEnterEmployeePh());
		add(getTextQty());
		add(getBtnAdd());
		add(getScrollPane());
		add(getBtnPaid());
		add(getTextName());
		add(getLblGrandTotal());
		add(getTextGrandTotal());

	}

	public JLabel getLblEmployeeForm() {
		if (lblEmployeeForm == null) {
			lblEmployeeForm = new JLabel("Sales Form\r\n");
			lblEmployeeForm.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmployeeForm.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblEmployeeForm.setBounds(22, 7, 746, 30);
		}
		return lblEmployeeForm;
	}
	public JLabel getLblEmployeeId() {
		if (lblEmployeeId == null) {
			lblEmployeeId = new JLabel("INVOICE NO :");
			lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEmployeeId.setBounds(34, 211, 89, 24);
		}
		return lblEmployeeId;
	}
	public JTextField getTextInv() {
		if (textInv == null) {
			textInv = new JTextField();
			textInv.setEditable(false);
			textInv.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			textInv.setBounds(133, 211, 173, 24);
			textInv.setColumns(10);
		}
		return textInv;
	}
	public JLabel getLblEnterEmployeeName() {
		if (lblEnterEmployeeName == null) {
			lblEnterEmployeeName = new JLabel("Enter Product Id:");
			lblEnterEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterEmployeeName.setBounds(137, 45, 173, 24);
		}
		return lblEnterEmployeeName;
	}
	public JTextField getTextId() {
		if (textId == null) {
			textId = new JTextField();
			textId.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textId.setColumns(10);
			textId.setBounds(378, 45, 173, 24);
		}
		return textId;
	}
	public JLabel getLblEnterEmployeePassword() {
		if (lblEnterEmployeePassword == null) {
			lblEnterEmployeePassword = new JLabel("Product Name :");
			lblEnterEmployeePassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterEmployeePassword.setBounds(137, 78, 173, 24);
		}
		return lblEnterEmployeePassword;
	}
	public JLabel getLblEnterEmployeeEmail() {
		if (lblEnterEmployeeEmail == null) {
			lblEnterEmployeeEmail = new JLabel("Product Price :");
			lblEnterEmployeeEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterEmployeeEmail.setBounds(137, 111, 173, 24);
		}
		return lblEnterEmployeeEmail;
	}
	public JTextField getTextPrice() {
		if (textPrice == null) {
			textPrice = new JTextField();
			textPrice.setEditable(false);
			textPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textPrice.setColumns(10);
			textPrice.setBounds(378, 111, 173, 24);
		}
		return textPrice;
	}
	public JLabel getLblEnterEmployeePh() {
		if (lblEnterEmployeePh == null) {
			lblEnterEmployeePh = new JLabel("Enter Qty :");
			lblEnterEmployeePh.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterEmployeePh.setBounds(137, 146, 173, 24);
		}
		return lblEnterEmployeePh;
	}
	public JTextField getTextQty() {
		if (textQty == null) {
			textQty = new JTextField();
			textQty.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textQty.setColumns(10);
			textQty.setBounds(378, 146, 173, 24);
		}
		return textQty;
	}
	public JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("ADD");
			btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnAdd.setBounds(354, 181, 89, 23);
		}
		return btnAdd;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(33, 246, 735, 328);
			scrollPane.setViewportView(getTableInvoice());
		}
		return scrollPane;
	}
	public JTable getTableInvoice() {
		if (tableInvoice == null) {
			tableInvoice = new JTable();
			tableInvoice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return tableInvoice;
	}
	public JButton getBtnPaid() {
		if (btnPaid == null) {
			btnPaid = new JButton("PAID");
			btnPaid.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnPaid.setBounds(269, 582, 118, 30);
		}
		return btnPaid;
	}
	public JTextField getTextName() {
		if (textName == null) {
			textName = new JTextField();
			textName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textName.setEditable(false);
			textName.setColumns(10);
			textName.setBounds(378, 78, 173, 24);
		}
		return textName;
	}
	public JLabel getLblGrandTotal() {
		if (lblGrandTotal == null) {
			lblGrandTotal = new JLabel("GRAND TOTAL:");
			lblGrandTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblGrandTotal.setBounds(482, 585, 103, 24);
		}
		return lblGrandTotal;
	}
	public JTextField getTextGrandTotal() {
		if (textGrandTotal == null) {
			textGrandTotal = new JTextField();
			textGrandTotal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			textGrandTotal.setEditable(false);
			textGrandTotal.setColumns(10);
			textGrandTotal.setBounds(595, 585, 173, 24);
		}
		return textGrandTotal;
	}
}
