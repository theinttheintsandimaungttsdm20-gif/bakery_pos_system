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

public class ProdNewView extends JPanel {
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
	private JTextField textPrice;
	private JLabel lblEnterEmployeePh;
	private JButton btnSave;
	private JScrollPane scrollPane_1;
	private JTextArea textDesc;
	private JComboBox<String> comboCat;
	private JCheckBox checkProdImage;
	private JLabel lblProdImage;

	/**
	 * Create the panel.
	 */
	public ProdNewView() {
		setLayout(null);
		add(getLblEmployeeForm());
		add(getLblEmployeeId());
		add(getTextId());
		add(getLblEnterEmployeeName());
		add(getTextName());
		add(getLblEnterEmployeePassword());
		add(getLblEnterEmployeeEmail());
		add(getTextPrice());
		add(getLblEnterEmployeePh());
		add(getBtnSave());
		add(getScrollPane_1());
		add(getComboCat());
		add(getCheckProdImage());
		add(getLblProdImage());

	}

	public JLabel getLblEmployeeForm() {
		if (lblEmployeeForm == null) {
			lblEmployeeForm = new JLabel("New Product Form");
			lblEmployeeForm.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmployeeForm.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblEmployeeForm.setBounds(22, 21, 746, 30);
		}
		return lblEmployeeForm;
	}
	public JLabel getLblEmployeeId() {
		if (lblEmployeeId == null) {
			lblEmployeeId = new JLabel("Product Id:");
			lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEmployeeId.setBounds(22, 76, 161, 24);
		}
		return lblEmployeeId;
	}
	public JTextField getTextId() {
		if (textId == null) {
			textId = new JTextField();
			textId.setEditable(false);
			textId.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textId.setBounds(198, 77, 252, 24);
			textId.setColumns(10);
		}
		return textId;
	}
	public JLabel getLblEnterEmployeeName() {
		if (lblEnterEmployeeName == null) {
			lblEnterEmployeeName = new JLabel("Select Category :");
			lblEnterEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterEmployeeName.setBounds(22, 111, 173, 24);
		}
		return lblEnterEmployeeName;
	}
	public JTextField getTextName() {
		if (textName == null) {
			textName = new JTextField();
			textName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textName.setColumns(10);
			textName.setBounds(198, 144, 252, 24);
		}
		return textName;
	}
	public JLabel getLblEnterEmployeePassword() {
		if (lblEnterEmployeePassword == null) {
			lblEnterEmployeePassword = new JLabel("Enter Product Name :");
			lblEnterEmployeePassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterEmployeePassword.setBounds(22, 144, 173, 24);
		}
		return lblEnterEmployeePassword;
	}
	public JLabel getLblEnterEmployeeEmail() {
		if (lblEnterEmployeeEmail == null) {
			lblEnterEmployeeEmail = new JLabel("Enter Product Price :");
			lblEnterEmployeeEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterEmployeeEmail.setBounds(22, 177, 173, 24);
		}
		return lblEnterEmployeeEmail;
	}
	public JTextField getTextPrice() {
		if (textPrice == null) {
			textPrice = new JTextField();
			textPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textPrice.setColumns(10);
			textPrice.setBounds(198, 177, 252, 24);
		}
		return textPrice;
	}
	public JLabel getLblEnterEmployeePh() {
		if (lblEnterEmployeePh == null) {
			lblEnterEmployeePh = new JLabel("Enter Product Description :");
			lblEnterEmployeePh.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterEmployeePh.setBounds(22, 212, 173, 24);
		}
		return lblEnterEmployeePh;
	}
	public JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("SAVE");
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnSave.setBounds(415, 397, 93, 24);
		}
		return btnSave;
	}
	public JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(198, 221, 252, 165);
			scrollPane_1.setViewportView(getTextDesc());
		}
		return scrollPane_1;
	}
	public JTextArea getTextDesc() {
		if (textDesc == null) {
			textDesc = new JTextArea();
			textDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return textDesc;
	}
	public JComboBox<String> getComboCat() {
		if (comboCat == null) {
			comboCat = new JComboBox<String>();
			comboCat.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboCat.setBounds(198, 111, 252, 24);
		}
		return comboCat;
	}
	public JCheckBox getCheckProdImage() {
		if (checkProdImage == null) {
			checkProdImage = new JCheckBox("Product Image Exist");
			checkProdImage.setFont(new Font("Tahoma", Font.PLAIN, 14));
			checkProdImage.setBounds(470, 77, 162, 23);
		}
		return checkProdImage;
	}
	public JLabel getLblProdImage() {
		if (lblProdImage == null) {
			lblProdImage = new JLabel("");
			lblProdImage.setBounds(480, 108, 252, 252);
		}
		return lblProdImage;
	}
}
