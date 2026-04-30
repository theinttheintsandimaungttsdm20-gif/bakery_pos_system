package com.example.server.view;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {
	private String[] cols;
	private Object[][] rows;
	private int rowCount;
	
	public MyTableModel(String[] cols){
		this.cols=cols;
	}
	@Override
	public int getColumnCount() {
		return this.cols.length;
	}
	@Override
	public String getColumnName(int column) {
		return this.cols[column];
	}
	@Override
	public void setRowCount(int rowCount) {
		this.rowCount=rowCount;
		this.rows=new Object[this.rowCount][this.cols.length];
	}
	@Override
	public int getRowCount() {
		return this.rowCount;
	}
	@Override
	public Object getValueAt(int row, int column) {
		return this.rows[row][column];
	}
	@Override
	public void setValueAt(Object aValue, int row, int column) {
		this.rows[row][column]=aValue;
	}
	

}
