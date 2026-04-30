package com.bakery.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class ProdSearchView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblEmployeeForm;
	private JLabel lblEnterEmployeeName;
	private JTextField textName;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable tableShow;
	private JLabel label;
	private JComboBox<String> comboCat;
	private JLabel lblOr;

	/**
	 * Create the panel.
	 */
	public ProdSearchView() {
		setLayout(null);
		add(getLblEmployeeForm());
		add(getLblEnterEmployeeName());
		add(getTextName());
		add(getBtnSearch());
		add(getScrollPane());
		add(getLabel());
		add(getComboCat());
		add(getLblOr());

	}

	public JLabel getLblEmployeeForm() {
		if (lblEmployeeForm == null) {
			lblEmployeeForm = new JLabel("Product Search Form");
			lblEmployeeForm.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmployeeForm.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblEmployeeForm.setBounds(22, 21, 746, 30);
		}
		return lblEmployeeForm;
	}
	public JLabel getLblEnterEmployeeName() {
		if (lblEnterEmployeeName == null) {
			lblEnterEmployeeName = new JLabel("Enter Employee Name:");
			lblEnterEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterEmployeeName.setBounds(134, 135, 173, 24);
		}
		return lblEnterEmployeeName;
	}
	public JTextField getTextName() {
		if (textName == null) {
			textName = new JTextField();
			textName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textName.setColumns(10);
			textName.setBounds(310, 135, 252, 24);
		}
		return textName;
	}
	public JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("SEARCH");
			btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnSearch.setBounds(331, 166, 99, 23);
		}
		return btnSearch;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(22, 200, 735, 404);
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
	public JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Select Category :");
			label.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label.setBounds(134, 74, 173, 24);
		}
		return label;
	}
	public JComboBox<String> getComboCat() {
		if (comboCat == null) {
			comboCat = new JComboBox<String>();
			comboCat.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboCat.setBounds(310, 74, 252, 24);
		}
		return comboCat;
	}
	public JLabel getLblOr() {
		if (lblOr == null) {
			lblOr = new JLabel("( OR )");
			lblOr.setHorizontalAlignment(SwingConstants.CENTER);
			lblOr.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblOr.setBounds(134, 105, 428, 24);
		}
		return lblOr;
	}
}
