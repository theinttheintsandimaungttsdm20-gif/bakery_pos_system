package com.bakery.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class HomeView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblEmployeeForm;
	private JLabel lblLoginName;

	/**
	 * Create the panel.
	 */
	public HomeView() {
		setLayout(null);
		add(getLblEmployeeForm());
		add(getLblLoginName());

	}

	public JLabel getLblEmployeeForm() {
		if (lblEmployeeForm == null) {
			lblEmployeeForm = new JLabel("Bakery Shop Home");
			lblEmployeeForm.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmployeeForm.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblEmployeeForm.setBounds(22, 21, 746, 30);
		}
		return lblEmployeeForm;
	}
	public JLabel getLblLoginName() {
		if (lblLoginName == null) {
			lblLoginName = new JLabel("Bakery Shop Home");
			lblLoginName.setForeground(Color.BLUE);
			lblLoginName.setHorizontalAlignment(SwingConstants.RIGHT);
			lblLoginName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
			lblLoginName.setBounds(22, 62, 746, 15);
		}
		return lblLoginName;
	}
}
