package com.bakery.view;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;

public class OrderPaidView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField text1,text2;
	private JLabel label1,label2;
	private JButton btnSave;
	private JRadioButton radioCash,radioCard; 
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblEnterCustomerName;
	private JTextField textName;
	private JLabel lblEnterCustomerPh;
	private JTextField textPh;
	private JLabel lblSelectReceiveDate;
	private JDateChooser dateReceive;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OrderPaidView dialog = new OrderPaidView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public OrderPaidView() {
		setTitle("Paid");
		setBounds(100, 100, 526, 341);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 506, 301);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblPaidForSales = new JLabel("Paid for Orders");
			lblPaidForSales.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblPaidForSales.setHorizontalAlignment(SwingConstants.CENTER);
			lblPaidForSales.setBounds(10, 11, 486, 29);
			contentPanel.add(lblPaidForSales);
		}
		{
			JLabel label = new JLabel("Paid Status :");
			label.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label.setBounds(41, 151, 200, 24);
			contentPanel.add(label);
		}
		contentPanel.add(getRadioCash());
		contentPanel.add(getRadioCard());
		contentPanel.add(getLabel1());
		contentPanel.add(getText1());
		contentPanel.add(getLabel2());
		contentPanel.add(getText2());		
		contentPanel.add(getBtnSave());
		contentPanel.add(getLblEnterCustomerName());
		contentPanel.add(getTextName());
		contentPanel.add(getLblEnterCustomerPh());
		contentPanel.add(getTextPh());
		contentPanel.add(getLblSelectReceiveDate());
		contentPanel.add(getDateReceive());
	}
	public JRadioButton getRadioCash() {
		if (radioCash == null) {
			radioCash = new JRadioButton("Cash");
			buttonGroup.add(radioCash);
			radioCash.setFont(new Font("Tahoma", Font.PLAIN, 14));
			radioCash.setBounds(247, 151, 63, 23);		
		}
		return radioCash;
	}
	public JRadioButton getRadioCard() {
		if (radioCard == null) {
			radioCard = new JRadioButton("Credit Card");
			buttonGroup.add(radioCard);
			radioCard.setFont(new Font("Tahoma", Font.PLAIN, 14));
			radioCard.setBounds(326, 151, 103, 23);		
		}
		return radioCard;
	}
	public JLabel getLabel1() {
		if (label1 == null) {
			label1 = new JLabel("Paid Amount :");
			label1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label1.setBounds(41, 186, 200, 24);			
		}
		return label1;
	}
	public JTextField getText1() {
		if (text1 == null) {
			text1 = new JTextField();
			text1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			text1.setColumns(10);
			text1.setBounds(247, 186, 173, 24);
		}
		return text1;
	}
	public JLabel getLabel2() {
		if (label2 == null) {
			label2 = new JLabel("Return Amount :");
			label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label2.setBounds(41, 221, 200, 24);
		}
		return label2;
	}
	public JTextField getText2() {
		if (text2 == null) {
			text2 = new JTextField();
			text2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			text2.setEditable(false);
			text2.setColumns(10);
			text2.setBounds(247, 221, 173, 24);
		}
		return text2;
	}
	public JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("SAVE");
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnSave.setBounds(221, 267, 89, 23);
		}
		return btnSave;
	}
	public JLabel getLblEnterCustomerName() {
		if (lblEnterCustomerName == null) {
			lblEnterCustomerName = new JLabel("Enter Customer Name :");
			lblEnterCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterCustomerName.setBounds(36, 51, 200, 24);
		}
		return lblEnterCustomerName;
	}
	public JTextField getTextName() {
		if (textName == null) {
			textName = new JTextField();
			textName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			textName.setColumns(10);
			textName.setBounds(242, 51, 173, 24);
		}
		return textName;
	}
	public JLabel getLblEnterCustomerPh() {
		if (lblEnterCustomerPh == null) {
			lblEnterCustomerPh = new JLabel("Enter Customer Ph:");
			lblEnterCustomerPh.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterCustomerPh.setBounds(36, 86, 200, 24);
		}
		return lblEnterCustomerPh;
	}
	public JTextField getTextPh() {
		if (textPh == null) {
			textPh = new JTextField();
			textPh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			textPh.setColumns(10);
			textPh.setBounds(242, 86, 173, 24);
		}
		return textPh;
	}
	public JLabel getLblSelectReceiveDate() {
		if (lblSelectReceiveDate == null) {
			lblSelectReceiveDate = new JLabel("Select Receive Date :");
			lblSelectReceiveDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSelectReceiveDate.setBounds(41, 121, 200, 24);
		}
		return lblSelectReceiveDate;
	}

	public JDateChooser getDateReceive() {
		if (dateReceive == null) {
			dateReceive = new JDateChooser();
			dateReceive.setFont(new Font("Tahoma", Font.PLAIN, 14));
			dateReceive.setBounds(242, 121, 200, 24);
			dateReceive.setDateFormatString("dd-MM-yyyy");
		}
		return dateReceive;
	}
}
