package com.example.client.view;

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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JLabel lblBankConnection;
	private JMenuBar menuBar;
	private JMenu mnBank;
	private JMenuItem itemAccounts;
	private JMenuItem itemTransactions;
	private JMenuItem itemDW;

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
		setTitle("BANK CLIENT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblBankConnection());
	}
	public JLabel getLblBankConnection() {
		if (lblBankConnection == null) {
			lblBankConnection = new JLabel("BANK System from CLIENT SIDE");
			lblBankConnection.setHorizontalAlignment(SwingConstants.CENTER);
			lblBankConnection.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblBankConnection.setBounds(10, 11, 764, 40);
		}
		return lblBankConnection;
	}
	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnBank());
		}
		return menuBar;
	}
	public JMenu getMnBank() {
		if (mnBank == null) {
			mnBank = new JMenu("Bank");
			mnBank.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			mnBank.add(getItemAccounts());
			mnBank.add(getItemTransactions());
			mnBank.add(getItemDW());
		}
		return mnBank;
	}
	public JMenuItem getItemAccounts() {
		if (itemAccounts == null) {
			itemAccounts = new JMenuItem("Accounts");
			itemAccounts.setFont(new Font("Tahoma", Font.ITALIC, 15));
		}
		return itemAccounts;
	}
	public JMenuItem getItemTransactions() {
		if (itemTransactions == null) {
			itemTransactions = new JMenuItem("Transactions");
			itemTransactions.setFont(new Font("Tahoma", Font.ITALIC, 15));
		}
		return itemTransactions;
	}
	public JMenuItem getItemDW() {
		if (itemDW == null) {
			itemDW = new JMenuItem("Deposit/Withdraw");
			itemDW.setFont(new Font("Tahoma", Font.ITALIC, 15));
		}
		return itemDW;
	}
}
