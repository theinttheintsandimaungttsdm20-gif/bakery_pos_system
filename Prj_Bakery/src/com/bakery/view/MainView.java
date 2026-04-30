package com.bakery.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;

public class MainView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu menuMaster;
	private JMenuItem itemEmp;
	private JMenuItem itemLogout;
	private JMenuItem itemProdNew;
	private JMenu mnProduct;
	private JMenuItem itemProdSearch;
	private JMenu menuTransaction;
	private JMenuItem itemSales;
	private JMenuItem itemOrders;
	private JMenu menuReport;
	private JMenuItem itemSalesReport;
	private JMenuItem itemOrdersReport;
	private JMenuItem itemOrderReceipt;

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
		setTitle("Brakery Shop Mangement System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,800, 700);
		setJMenuBar(getJMenuBar());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	public JMenuBar getJMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMenuMaster());
			menuBar.add(getMenuTransaction());
			menuBar.add(getMenuReport());
		}
		return menuBar;
	}
	public JMenu getMenuMaster() {
		if (menuMaster == null) {
			menuMaster = new JMenu("Master");
			menuMaster.setFont(new Font("Tahoma", Font.BOLD, 15));
			menuMaster.add(getItemEmp());
			menuMaster.add(getMnProduct());
			menuMaster.add(getItemLogout());
		}
		return menuMaster;
	}
	public JMenuItem getItemEmp() {
		if (itemEmp == null) {
			itemEmp = new JMenuItem("Employee");
			itemEmp.setFont(new Font("Tahoma", Font.ITALIC, 14));
		}
		return itemEmp;
	}
	public JMenuItem getItemLogout() {
		if (itemLogout == null) {
			itemLogout = new JMenuItem("Logout");
			itemLogout.setFont(new Font("Tahoma", Font.ITALIC, 14));
		}
		return itemLogout;
	}
	public JMenuItem getItemProdNew() {
		if (itemProdNew == null) {
			itemProdNew = new JMenuItem("New ");
			itemProdNew.setFont(new Font("Tahoma", Font.ITALIC, 14));
		}
		return itemProdNew;
	}
	public JMenu getMnProduct() {
		if (mnProduct == null) {
			mnProduct = new JMenu("Product");
			mnProduct.setFont(new Font("Tahoma", Font.ITALIC, 14));
			mnProduct.add(getItemProdNew());
			mnProduct.add(getItemProdSearch());
		}
		return mnProduct;
	}
	public JMenuItem getItemProdSearch() {
		if (itemProdSearch == null) {
			itemProdSearch = new JMenuItem("Search");
			itemProdSearch.setFont(new Font("Tahoma", Font.ITALIC, 14));
		}
		return itemProdSearch;
	}
	public JMenu getMenuTransaction() {
		if (menuTransaction == null) {
			menuTransaction = new JMenu("Transaction");
			menuTransaction.setFont(new Font("Tahoma", Font.BOLD, 15));
			menuTransaction.add(getItemSales());
			menuTransaction.add(getItemOrders());
			menuTransaction.add(getItemOrderReceipt());
		}
		return menuTransaction;
	}
	public JMenuItem getItemSales() {
		if (itemSales == null) {
			itemSales = new JMenuItem("Sales");
			itemSales.setFont(new Font("Tahoma", Font.ITALIC, 14));
		}
		return itemSales;
	}
	public JMenuItem getItemOrders() {
		if (itemOrders == null) {
			itemOrders = new JMenuItem("Orders");
			itemOrders.setFont(new Font("Tahoma", Font.ITALIC, 14));
		}
		return itemOrders;
	}
	public JMenu getMenuReport() {
		if (menuReport == null) {
			menuReport = new JMenu("Report");
			menuReport.setFont(new Font("Tahoma", Font.BOLD, 15));
			menuReport.add(getItemSalesReport());
			menuReport.add(getItemOrdersReport());
		}
		return menuReport;
	}
	public JMenuItem getItemSalesReport() {
		if (itemSalesReport == null) {
			itemSalesReport = new JMenuItem("Sales");
			itemSalesReport.setFont(new Font("Tahoma", Font.ITALIC, 14));
		}
		return itemSalesReport;
	}
	public JMenuItem getItemOrdersReport() {
		if (itemOrdersReport == null) {
			itemOrdersReport = new JMenuItem("Orders");
			itemOrdersReport.setFont(new Font("Tahoma", Font.ITALIC, 14));
		}
		return itemOrdersReport;
	}
	public JMenuItem getItemOrderReceipt() {
		if (itemOrderReceipt == null) {
			itemOrderReceipt = new JMenuItem("Order Receipt");
			itemOrderReceipt.setFont(new Font("Tahoma", Font.ITALIC, 14));
		}
		return itemOrderReceipt;
	}
}
