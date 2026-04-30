package com.bakery.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.bakery.dao.BrOrderDao;
import com.bakery.model.BrIngredient;
import com.bakery.model.BrOrder;
import com.bakery.model.BrOrderDetail;
import com.bakery.util.DateUtil;
import com.bakery.view.MyTableModel;
import com.bakery.view.OrderReceiptView;

public class OrderReceiptController {
	private OrderReceiptView myView;
	private BrOrderDao myOrderDao;
	public OrderReceiptController(OrderReceiptView v){
		this.myView=v;
		this.myView.getTableShow().setVisible(false);
		this.myView.getBtnSearch().setText("SEARCH");
		this.myOrderDao=new BrOrderDao();
		this.myView.getBtnSearch().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				processSearch();
			}
		});
		this.myView.getBtnClear().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				processClear();
			}
		});
	}
	private void processSearch(){
		if(this.myView.getBtnSearch().getText().toUpperCase().equals("SEARCH")){
			String ono=this.myView.getTextNo().getText();
			BrOrder or=this.myOrderDao.getOrderByNo(ono);
			if(or!=null){
				this.myView.getTextCustName().setText(or.getCustomer().getCustName());
				this.myView.getTextCustPh().setText(or.getCustomer().getCustPh());
				this.myView.getTextEmpNo().setText(or.getEmpId());
				this.myView.getTextOrderDate().setText(DateUtil.converD2S(or.getOrderDate()));
				this.myView.getTextReceiveDate().setText(DateUtil.converD2S(or.getReceiveDate()));
				
				MyTableModel tm=new MyTableModel(new String[]{
						"No","Pid","ProductName","Price","Qty","Sub Total"});
				tm.setRowCount(
						(or.getOrderDetails()==null?0:or.getOrderDetails().size())
						+(or.getOrderIngs()==null?0:or.getOrderIngs().size()));
				int row=0;				
				if(or.getOrderDetails()!=null){
					for(int i=0;i<or.getOrderDetails().size();i++){
						BrOrderDetail d=or.getOrderDetails().get(i);
						tm.setValueAt(row+1, row, 0);
						tm.setValueAt(d.getProdId(), row, 1);
						tm.setValueAt(d.getProd().getProdName(), row, 2);
						tm.setValueAt(d.getPrice(), row, 3);
						tm.setValueAt(d.getQty(), row, 4);
						int subTotal=d.getQty()*d.getPrice();
						tm.setValueAt(subTotal, row, 5);
						row++;
					}
				}
				if(or.getOrderIngs()!=null){
					for(int i=0;i<or.getOrderIngs().size();i++){
						BrIngredient ing=or.getOrderIngs().get(i);			
						tm.setValueAt(row+1, row, 0);
						tm.setValueAt("Ingredient", row, 1);
						tm.setValueAt(ing.getIngName(), row, 2);
						tm.setValueAt(ing.getIngPrice(), row, 3);
						tm.setValueAt(ing.getIngQty(), row, 4);
						int subTotal=ing.getIngPrice()*ing.getIngQty();
						tm.setValueAt(subTotal, row, 5);
						row++;
					}
				}
				this.myView.getTableShow().setModel(tm);
				this.myView.getTableShow().setVisible(true);
				this.myView.getTableShow().setRowHeight(25);
				this.myView.getBtnSearch().setText("TAKE ORDER");
			}else{
				this.myView.getTableShow().setVisible(false);
				JOptionPane.showMessageDialog(this.myView,
						"NO order for "+ono,
						"NOT FOUND",
						JOptionPane.ERROR_MESSAGE
						);
			}
		}else if(this.myView.getBtnSearch().getText().toUpperCase().equals("TAKE ORDER")){
			int accept=JOptionPane.showConfirmDialog(
					this.myView,
					"Does the Customer take the order?",
					"Take Order",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if(accept==JOptionPane.YES_OPTION){
				this.myOrderDao.updateOrderStatus(this.myView.getTextNo().getText());
				this.myView.getTableShow().setVisible(false);
				processClear();
			}
			
		}
	}
	private void processClear(){
		this.myView.getTextCustPh().setText(null);
		this.myView.getTextCustName().setText(null);
		this.myView.getTextNo().setText(null);
		this.myView.getTextOrderDate().setText(null);
		this.myView.getTextReceiveDate().setText(null);
		this.myView.getTableShow().setVisible(false);
		this.myView.getTextEmpNo().setText(null);
		this.myView.getBtnSearch().setText("SEARCH");
	}
}
