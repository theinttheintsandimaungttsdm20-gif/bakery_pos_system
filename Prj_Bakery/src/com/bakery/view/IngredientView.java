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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class IngredientView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textIngCost,textIngQty;
	private JLabel label1,label2;
	private JButton btnSave;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textIngName;
	private JLabel lblEnterIngredientDesc;
	private JScrollPane scrollPane;
	private JTextArea textIngDesc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IngredientView dialog = new IngredientView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public IngredientView() {
		setTitle("Paid");
		setBounds(100, 100, 522, 428);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 506, 353);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblPaidForSales = new JLabel("Ingredient Order Form");
			lblPaidForSales.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblPaidForSales.setHorizontalAlignment(SwingConstants.CENTER);
			lblPaidForSales.setBounds(10, 11, 486, 29);
			contentPanel.add(lblPaidForSales);
		}
		{
			JLabel lblEnterIngredientName = new JLabel("Enter Ingredient Name :");
			lblEnterIngredientName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterIngredientName.setBounds(37, 51, 200, 24);
			contentPanel.add(lblEnterIngredientName);
		}
		contentPanel.add(getLabel1());
		contentPanel.add(getTextIngCost());
		contentPanel.add(getLabel2());
		contentPanel.add(getTextIngQty());
		contentPanel.add(getTextIngName());
		contentPanel.add(getLblEnterIngredientDesc());
		contentPanel.add(getScrollPane_1());
		getContentPane().add(getBtnSave());
	}
	public JLabel getLabel1() {
		if (label1 == null) {
			label1 = new JLabel("Enter Ingredient Cost :");
			label1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label1.setBounds(37, 86, 200, 24);			
		}
		return label1;
	}
	public JTextField getTextIngCost() {
		if (textIngCost == null) {
			textIngCost = new JTextField();
			textIngCost.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			textIngCost.setColumns(10);
			textIngCost.setBounds(243, 86, 173, 24);
		}
		return textIngCost;
	}
	public JLabel getLabel2() {
		if (label2 == null) {
			label2 = new JLabel("Enter Ingredient Qty :");
			label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label2.setBounds(37, 121, 200, 24);
		}
		return label2;
	}
	public JTextField getTextIngQty() {
		if (textIngQty == null) {
			textIngQty = new JTextField();
			textIngQty.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			textIngQty.setColumns(10);
			textIngQty.setBounds(243, 121, 173, 24);
		}
		return textIngQty;
	}
	public JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("SAVE");
			btnSave.setBounds(211, 357, 89, 23);
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		return btnSave;
	}
	public JTextField getTextIngName() {
		if (textIngName == null) {
			textIngName = new JTextField();
			textIngName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			textIngName.setColumns(10);
			textIngName.setBounds(243, 51, 173, 24);
		}
		return textIngName;
	}
	public JLabel getLblEnterIngredientDesc() {
		if (lblEnterIngredientDesc == null) {
			lblEnterIngredientDesc = new JLabel("Enter Ingredient Desc :");
			lblEnterIngredientDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterIngredientDesc.setBounds(37, 156, 200, 24);
		}
		return lblEnterIngredientDesc;
	}
	public JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(243, 160, 261, 182);
			scrollPane.setViewportView(getTextIngDesc());
		}
		return scrollPane;
	}
	public JTextArea getTextIngDesc() {
		if (textIngDesc == null) {
			textIngDesc = new JTextArea();
		}
		return textIngDesc;
	}
}
