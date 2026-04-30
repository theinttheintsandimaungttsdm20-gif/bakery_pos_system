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
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class ReportSalesView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblEmployeeForm;
	private JLabel lblMonth;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable tableShow;
	private JLabel lblStartDate;
	private JDateChooser dateStart;
	private JLabel lblEndDate;
	private JDateChooser dateEnd;
	private JMonthChooser dateMonth;
	private JLabel lblSelectSalesReport;
	private JRadioButton radioDuration;
	private JRadioButton radioMonthly;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public ReportSalesView() {
		setLayout(null);
		add(getLblEmployeeForm());
		add(getLblMonth());
		add(getBtnSearch());
		add(getScrollPane());
		add(getLblStartDate());
		add(getDateStart());
		add(getLblEndDate());
		add(getDateEnd());
		add(getDateMonth());
		add(getLblSelectSalesReport());
		add(getRadioDuration());
		add(getRadioMonthly());

	}

	public JLabel getLblEmployeeForm() {
		if (lblEmployeeForm == null) {
			lblEmployeeForm = new JLabel("SALES REPORT");
			lblEmployeeForm.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmployeeForm.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblEmployeeForm.setBounds(22, 21, 746, 30);
		}
		return lblEmployeeForm;
	}
	public JLabel getLblMonth() {
		if (lblMonth == null) {
			lblMonth = new JLabel("Select Month:");
			lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMonth.setBounds(271, 100, 87, 24);
		}
		return lblMonth;
	}
	public JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("SEARCH");
			btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnSearch.setBounds(331, 135, 99, 23);
		}
		return btnSearch;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(22, 169, 740, 435);
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
	public JLabel getLblStartDate() {
		if (lblStartDate == null) {
			lblStartDate = new JLabel("Start Date :");
			lblStartDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblStartDate.setBounds(46, 100, 87, 24);
		}
		return lblStartDate;
	}
	public JDateChooser getDateStart() {
		if (dateStart == null) {
			dateStart = new JDateChooser();
			dateStart.setFont(new Font("Tahoma", Font.PLAIN, 14));
			dateStart.setDateFormatString("dd-MM-yyyy");
			dateStart.setBounds(143, 100, 200, 24);
		}
		return dateStart;
	}
	public JLabel getLblEndDate() {
		if (lblEndDate == null) {
			lblEndDate = new JLabel("End Date:");
			lblEndDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEndDate.setBounds(389, 100, 87, 24);
		}
		return lblEndDate;
	}
	public JDateChooser getDateEnd() {
		if (dateEnd == null) {
			dateEnd = new JDateChooser();
			dateEnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
			dateEnd.setDateFormatString("dd-MM-yyyy");
			dateEnd.setBounds(486, 100, 200, 24);
		}
		return dateEnd;
	}
	public JMonthChooser getDateMonth() {
		if (dateMonth == null) {
			dateMonth = new JMonthChooser();
			dateMonth.setFont(new Font("Tahoma", Font.PLAIN, 14));			
			dateMonth.setBounds(368, 100, 121, 24);
		}
		return dateMonth;
	}
	public JLabel getLblSelectSalesReport() {
		if (lblSelectSalesReport == null) {
			lblSelectSalesReport = new JLabel("Select Sales Report Type:");
			lblSelectSalesReport.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSelectSalesReport.setBounds(103, 62, 200, 24);
		}
		return lblSelectSalesReport;
	}
	public JRadioButton getRadioDuration() {
		if (radioDuration == null) {
			radioDuration = new JRadioButton("Duration");
			buttonGroup.add(radioDuration);
			radioDuration.setFont(new Font("Tahoma", Font.PLAIN, 14));
			radioDuration.setBounds(321, 62, 109, 23);
		}
		return radioDuration;
	}
	public JRadioButton getRadioMonthly() {
		if (radioMonthly == null) {
			radioMonthly = new JRadioButton("Monthly");
			buttonGroup.add(radioMonthly);
			radioMonthly.setFont(new Font("Tahoma", Font.PLAIN, 14));
			radioMonthly.setBounds(461, 62, 109, 23);
		}
		return radioMonthly;
	}
}
