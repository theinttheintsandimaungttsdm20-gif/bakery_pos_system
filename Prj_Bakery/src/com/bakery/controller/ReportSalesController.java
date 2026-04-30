package com.bakery.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;

import com.bakery.dao.BrSalesViewDao;
import com.bakery.model.BrSalesView;
import com.bakery.view.MyTableModel;
import com.bakery.view.ReportSalesView;

public class ReportSalesController {
	private ReportSalesView myView;
	private boolean monthlyFlag;
	private BrSalesViewDao mySalesViewDao;
	public ReportSalesController(ReportSalesView v){
		this.myView=v;
		this.mySalesViewDao=new BrSalesViewDao();
		processControl(1);
		this.myView.getRadioDuration().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				processDuration();
			}
		});
		this.myView.getRadioMonthly().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				processMonthly();
			}
		});
		this.myView.getBtnSearch().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				processSearch();
			}
		});
	}
	private void processDuration(){
		this.monthlyFlag=false;
		this.myView.getTableShow().setVisible(false);
		processControl(2);
	}
	private void processMonthly(){
		this.monthlyFlag=true;
		this.myView.getTableShow().setVisible(false);
		processControl(3);
	}
	private void processControl(int type){
		if(type==1){
			this.myView.getLblStartDate().setVisible(false);
			this.myView.getDateStart().setVisible(false);
			this.myView.getLblEndDate().setVisible(false);
			this.myView.getDateEnd().setVisible(false);
			this.myView.getLblMonth().setVisible(false);
			this.myView.getDateMonth().setVisible(false);
		}else{
				this.myView.getLblStartDate().setVisible(type==2?true:false);
				this.myView.getDateStart().setVisible(type==2?true:false);
				this.myView.getLblEndDate().setVisible(type==2?true:false);
				this.myView.getDateEnd().setVisible(type==2?true:false);
				this.myView.getLblMonth().setVisible(type==3?true:false);
				this.myView.getDateMonth().setVisible(type==3?true:false);
			
		}
	}
	
	private void processSearch(){
		List<BrSalesView> l=null;
		if(this.monthlyFlag==false){
			Date sdate=this.myView.getDateStart().getDate();
			Date edate=this.myView.getDateEnd().getDate();
			l=this.mySalesViewDao.getRange(sdate, edate);
		}else{
			int month=this.myView.getDateMonth().getMonth();
			l=this.mySalesViewDao.getMonthly(month+1);
		}
		if(l==null){
			JOptionPane.showMessageDialog(this.myView, "NO SALES DATA","NOT FOUND",JOptionPane.ERROR_MESSAGE);
			this.myView.getTableShow().setVisible(false);
		}else{
			MyTableModel tm=new MyTableModel(new String[]{
				"NO","Sales INvoice No","Date","Paid Status","Employee Name","TOTAL"	
			});
			tm.setRowCount(l.size());
			for(int i=0;i<l.size();i++){
				BrSalesView v=l.get(i);
				tm.setValueAt(i+1, i, 0);
				tm.setValueAt(v.getSalesId(), i, 1);
				tm.setValueAt(v.getSalesDate(), i, 2);
				tm.setValueAt(v.getSalesStatus(), i, 3);
				tm.setValueAt(v.getSalesEmpName(), i, 4);
				tm.setValueAt(v.getSalesTotal(), i, 5);
			}
			this.myView.getTableShow().setModel(tm);
			this.myView.getTableShow().setRowHeight(30);
			TableColumnModel columnModel = this.myView.getTableShow().getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(30);
			columnModel.getColumn(1).setPreferredWidth(150);
			columnModel.getColumn(2).setPreferredWidth(200);
			columnModel.getColumn(3).setPreferredWidth(80);
			columnModel.getColumn(4).setPreferredWidth(80);
			columnModel.getColumn(5).setPreferredWidth(80);
			this.myView.getTableShow().setVisible(true);
			
		}
	}
}
