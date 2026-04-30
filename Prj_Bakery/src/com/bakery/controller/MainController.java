package com.bakery.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.bakery.dao.BrEmpLogDao;
import com.bakery.model.StableModel;
import com.bakery.view.EmpHomeView;
import com.bakery.view.HomeView;
import com.bakery.view.LoginView;
import com.bakery.view.MainView;
import com.bakery.view.OrderReceiptView;
import com.bakery.view.OrderView;
import com.bakery.view.ProdNewView;
import com.bakery.view.ProdSearchView;
import com.bakery.view.ReportOrdersView;
import com.bakery.view.ReportSalesView;
import com.bakery.view.SalesView;

public class MainController {
	private MainView myView;
	private BrEmpLogDao myEmpLogDao;
	public MainController(MainView v){
		this.myView=v;
		this.myEmpLogDao=new BrEmpLogDao();
		this.prepareLogin();
		MyMenuListener ml=new MyMenuListener();
		this.myView.getItemEmp().addActionListener(ml);
		this.myView.getItemProdNew().addActionListener(ml);
		this.myView.getItemProdSearch().addActionListener(ml);
		this.myView.getItemSales().addActionListener(ml);
		this.myView.getItemOrders().addActionListener(ml);
		this.myView.getItemLogout().addActionListener(ml);
		this.myView.getItemOrderReceipt().addActionListener(ml);
		this.myView.getItemSalesReport().addActionListener(ml);
		this.myView.getItemOrdersReport().addActionListener(ml);

	}
	private void processStaff(){
		this.myView.getItemEmp().setVisible(false);
		this.myView.getMenuReport().setVisible(false);
	}
	private void processAdmin(){
		this.myView.getItemEmp().setVisible(true);
		this.myView.getMenuReport().setVisible(true);
	}
	private void clearOld(){
		for(Component c:this.myView.getContentPane().getComponents()){
			c.setVisible(false);
			this.myView.getContentPane().remove(c);
		}
	}
	private void prepareLogin(){
		clearOld();
		LoginView v=new LoginView();
		v.setVisible(true);
		this.myView.getJMenuBar().setVisible(false);
		this.myView.getContentPane().add(v);		
		new LoginController(v,this);
	}
	private void prepareLogout(){
		this.myEmpLogDao.logout(StableModel.loginEmp.getEmpId());
		StableModel.loginEmp=null;
		this.myView.setTitle("Brakery Shop Mangement System");
		prepareLogin();		
	}
	public void prepareHome(){
		clearOld();
		HomeView v=new HomeView();
		v.setVisible(true);
		this.myView.getContentPane().add(v);		
		this.myView.getJMenuBar().setVisible(true);
		if(StableModel.loginEmp.getEmpRoles().toUpperCase().equals("STAFF"))
				processStaff();
		else
			processAdmin();
		String login=StableModel.loginEmp.getEmpName()+" ( "+
				StableModel.loginEmp.getEmpEmail()+" ) ";
		v.getLblLoginName().setText(login);
		this.myView.setTitle(this.myView.getTitle()+"          "+login);
	}
	private void prepareEmpHome(){
		clearOld();
		EmpHomeView v=new EmpHomeView();
		v.setVisible(true);
		this.myView.getContentPane().add(v);		
		new EmpHomeController(v);
	}
	private void prepareProdHome(){
		clearOld();
		ProdNewView v=new ProdNewView();
		v.setVisible(true);
		this.myView.getContentPane().add(v);		
		new ProdNewController(v);
	}
	private void prepareProdSearch(){
		clearOld();
		ProdSearchView v=new ProdSearchView();
		v.setVisible(true);
		this.myView.getContentPane().add(v);		
		new ProdSearchController(v);
	}
	private void prepareSales(){
		clearOld();
		SalesView v=new SalesView();
		v.setVisible(true);
		this.myView.getContentPane().add(v);		
		new SalesController(v);
	}
	private void prepareOrders(){
		clearOld();
		OrderView v=new OrderView();
		v.setVisible(true);
		this.myView.getContentPane().add(v);		
		new OrderController(v);
	}
	private void prepareOrderReceipt(){
		clearOld();
		OrderReceiptView v=new OrderReceiptView();
		v.setVisible(true);
		this.myView.getContentPane().add(v);		
		new OrderReceiptController(v);
	}
	private void prepareReportSales(){
		clearOld();
		ReportSalesView v=new ReportSalesView();
		v.setVisible(true);
		this.myView.getContentPane().add(v);		
		new ReportSalesController(v);
	}
	private void prepareReportOrders(){
		clearOld();
		ReportOrdersView v=new ReportOrdersView();
		v.setVisible(true);
		this.myView.getContentPane().add(v);		
		new ReportOrdersController(v);
	}
	private class MyMenuListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(myView.getItemEmp().equals(e.getSource()))
				prepareEmpHome();
			if(myView.getItemLogout().equals(e.getSource()))
				prepareLogout();
			if(myView.getItemProdNew().equals(e.getSource()))
				prepareProdHome();
			if(myView.getItemProdSearch().equals(e.getSource()))
				prepareProdSearch();
			if(myView.getItemSales().equals(e.getSource()))
				prepareSales();
			if(myView.getItemOrders().equals(e.getSource()))
				prepareOrders();
			if(myView.getItemOrderReceipt().equals(e.getSource()))
				prepareOrderReceipt();
			if(myView.getItemSalesReport().equals(e.getSource()))
				prepareReportSales();
			if(myView.getItemOrdersReport().equals(e.getSource()))
				prepareReportOrders();
		}		
	}
	
}
