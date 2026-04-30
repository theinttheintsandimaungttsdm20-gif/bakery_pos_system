package com.example.server.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JLabel lblBankConnection;
	private JLabel lblSelectYourBank;
	private JComboBox comboBank;
	private JButton btnOpen;
	private JButton btnClose;
	private JScrollPane scrollPane;
	private JTable tableBank;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblBankConnection());
		contentPane.add(getLblSelectYourBank());
		contentPane.add(getComboBank());
		contentPane.add(getBtnOpen());
		contentPane.add(getBtnClose());
		contentPane.add(getScrollPane());
		contentPane.add(getLblStatus());
	}
	public JLabel getLblBankConnection() {
		if (lblBankConnection == null) {
			lblBankConnection = new JLabel("Bank Connection");
			lblBankConnection.setHorizontalAlignment(SwingConstants.CENTER);
			lblBankConnection.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblBankConnection.setBounds(10, 11, 564, 40);
		}
		return lblBankConnection;
	}
	public JLabel getLblSelectYourBank() {
		if (lblSelectYourBank == null) {
			lblSelectYourBank = new JLabel("Select Your Bank :");
			lblSelectYourBank.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSelectYourBank.setBounds(20, 72, 123, 25);
		}
		return lblSelectYourBank;
	}
	public JComboBox getComboBank() {
		if (comboBank == null) {
			comboBank = new JComboBox();
			comboBank.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboBank.setBounds(153, 72, 204, 25);
		}
		return comboBank;
	}
	public JButton getBtnOpen() {
		if (btnOpen == null) {
			btnOpen = new JButton("OPEN");
			btnOpen.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnOpen.setBounds(364, 72, 89, 25);
		}
		return btnOpen;
	}
	public JButton getBtnClose() {
		if (btnClose == null) {
			btnClose = new JButton("CLOSE");
			btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnClose.setBounds(463, 72, 89, 25);
		}
		return btnClose;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 154, 554, 284);
			scrollPane.setViewportView(getTableBank());
		}
		return scrollPane;
	}
	public JTable getTableBank() {
		if (tableBank == null) {
			tableBank = new JTable();
			tableBank.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return tableBank;
	}
	public JLabel getLblStatus() {
		if (lblStatus == null) {
			lblStatus = new JLabel("Bank Connection");
			lblStatus.setForeground(Color.RED);
			lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
			lblStatus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			lblStatus.setBounds(10, 108, 564, 40);
		}
		return lblStatus;
	}
}
