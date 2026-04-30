package com.bakery.view;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;

public class PaidView extends JDialog {

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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PaidView dialog = new PaidView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public PaidView() {
		setTitle("Paid");
		setBounds(100, 100, 522, 243);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 506, 206);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblPaidForSales = new JLabel("Paid for Sales\r\n");
			lblPaidForSales.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblPaidForSales.setHorizontalAlignment(SwingConstants.CENTER);
			lblPaidForSales.setBounds(10, 11, 486, 29);
			contentPanel.add(lblPaidForSales);
		}
		{
			JLabel label = new JLabel("Paid Status :");
			label.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label.setBounds(37, 51, 200, 24);
			contentPanel.add(label);
		}
		contentPanel.add(getRadioCash());
		contentPanel.add(getRadioCard());
		contentPanel.add(getLabel1());
		contentPanel.add(getText1());
		contentPanel.add(getLabel2());
		contentPanel.add(getText2());		
		contentPanel.add(getBtnSave());
	}
	public JRadioButton getRadioCash() {
		if (radioCash == null) {
			radioCash = new JRadioButton("Cash");
			buttonGroup.add(radioCash);
			radioCash.setFont(new Font("Tahoma", Font.PLAIN, 14));
			radioCash.setBounds(243, 51, 63, 23);		
		}
		return radioCash;
	}
	public JRadioButton getRadioCard() {
		if (radioCard == null) {
			radioCard = new JRadioButton("Credit Card");
			buttonGroup.add(radioCard);
			radioCard.setFont(new Font("Tahoma", Font.PLAIN, 14));
			radioCard.setBounds(322, 51, 103, 23);		
		}
		return radioCard;
	}
	public JLabel getLabel1() {
		if (label1 == null) {
			label1 = new JLabel("Paid Amount :");
			label1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label1.setBounds(37, 86, 200, 24);			
		}
		return label1;
	}
	public JTextField getText1() {
		if (text1 == null) {
			text1 = new JTextField();
			text1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			text1.setColumns(10);
			text1.setBounds(243, 86, 173, 24);
		}
		return text1;
	}
	public JLabel getLabel2() {
		if (label2 == null) {
			label2 = new JLabel("Return Amount :");
			label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label2.setBounds(37, 121, 200, 24);
		}
		return label2;
	}
	public JTextField getText2() {
		if (text2 == null) {
			text2 = new JTextField();
			text2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			text2.setEditable(false);
			text2.setColumns(10);
			text2.setBounds(243, 121, 173, 24);
		}
		return text2;
	}
	public JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("SAVE");
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnSave.setBounds(222, 156, 89, 23);
		}
		return btnSave;
	}
}
