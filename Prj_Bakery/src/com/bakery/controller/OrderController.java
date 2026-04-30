package com.bakery.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.bakery.dao.BrOrderDao;
import com.bakery.dao.BrProductDao;
import com.bakery.dao.BrSalesDao;
import com.bakery.model.BrCreditCard;
import com.bakery.model.BrCustomer;
import com.bakery.model.BrIngredient;
import com.bakery.model.BrOrder;
import com.bakery.model.BrOrderDetail;
import com.bakery.model.BrProduct;
import com.bakery.model.BrSales;
import com.bakery.model.BrSalesDetail;
import com.bakery.model.StableModel;
import com.bakery.util.BankRMIUtil;
import com.bakery.view.IngredientView;
import com.bakery.view.MyTableModel;
import com.bakery.view.OrderPaidView;
import com.bakery.view.OrderView;
import com.bakery.view.PaidView;
import com.bakery.view.SalesView;

public class OrderController {
	private OrderView myView;
	private BrOrderDao myOrderDao;
	private BrProductDao myProdDao;
	private BrProduct myProd;
	private List<BrProduct> myOrderProds;
	private List<BrIngredient> myOrdersIngs;
	private OrderPaidView myPaidView;
	private IngredientView myIngView;
	public OrderController(OrderView v){
		this.myView=v;		
		this.myOrderDao=new BrOrderDao();
		this.myProdDao=new BrProductDao();
		processLoad();
		
		this.myView.getTextId().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				processLoadProd();
			}
		});
		this.myView.getBtnAdd().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				processAdd();
			}
		});
		this.myView.getBtnAddIngeridents().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				processAddIngeridents();
			}
		});
		this.myView.getBtnPaid().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				processPaid();
			}
		});
	}	
	private void processShowTable(){
		int grandTotal=0;
		MyTableModel tm=new MyTableModel(new String[]{
				"No","Pid","ProductName","Price","Qty","Sub Total"});
		tm.setRowCount(this.myOrderProds.size()+this.myOrdersIngs.size());
		int row=0;
		for(int i=0;i<this.myOrderProds.size();i++){
			BrProduct p=this.myOrderProds.get(i);			
			tm.setValueAt(row+1,row, 0);
			tm.setValueAt(p.getProdId(), row, 1);
			tm.setValueAt(p.getProdName(), row, 2);
			tm.setValueAt(p.getProdPrice(), row, 3);
			tm.setValueAt(p.getQty(), row, 4);
			int subTotal=p.getQty()*p.getProdPrice();
			tm.setValueAt(subTotal,row, 5);
			grandTotal+=subTotal;
			row++;
		}
		for(int i=0;i<this.myOrdersIngs.size();i++){
			BrIngredient ing=this.myOrdersIngs.get(i);			
			tm.setValueAt(row+1, row, 0);
			tm.setValueAt("Ingredient", row, 1);
			tm.setValueAt(ing.getIngName(), row, 2);
			tm.setValueAt(ing.getIngPrice(), row, 3);
			tm.setValueAt(ing.getIngQty(), row, 4);
			int subTotal=ing.getIngPrice()*ing.getIngQty();
			tm.setValueAt(subTotal, row, 5);
			grandTotal+=subTotal;
			row++;
		}
		this.myView.getTableInvoice().setModel(tm);
		this.myView.getTableInvoice().setVisible(true);
		this.myView.getTableInvoice().setRowHeight(25);
		this.myView.getTextGrandTotal().setText(""+grandTotal);
		this.myView.getBtnPaid().setVisible(true);
	}
	private void processAddIngeridents(){
		if(this.myIngView==null) this.myIngView=new IngredientView();
		this.myIngView.getTextIngName().setText(null);
		this.myIngView.getTextIngCost().setText(null);
		this.myIngView.getTextIngQty().setText(null);
		this.myIngView.getTextIngDesc().setText(null);
		this.myIngView.setVisible(true);
		this.myIngView.getBtnSave().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				processSaveIngeridents();
			}
		});
	}
	private void processSaveIngeridents(){
		String strName=this.myIngView.getTextIngName().getText();
		String strQty=this.myIngView.getTextIngQty().getText();
		String strCost=this.myIngView.getTextIngCost().getText();
		String strDesc=this.myIngView.getTextIngDesc().getText();
		int qty=0;
		int cost=0;
		String error=new String();
		if(strName==null || strName.isEmpty())
			error+="Ingredient Name is required \n";
		if(strCost==null || strCost.isEmpty())
			error+="Ingredient Cost is required \n";
		else{
			try{
				cost=Integer.parseInt(strCost);
			}catch(Exception e){
				error+="Ingredient Cost must be integer\n";
			}
		}
		if(strQty==null || strQty.isEmpty())
			error+="Ingredient Qutantity is required \n";
		else{
			try{
				qty=Integer.parseInt(strQty);
			}catch(Exception e){
				error+="Ingredient Quantity must be integer\n";
			}
		}
		if(strDesc==null || strDesc.isEmpty())
			error+="Ingredient Description is required \n";
		if(!error.isEmpty()){
			JOptionPane.showMessageDialog(this.myView,error,
					"Required Error",JOptionPane.ERROR_MESSAGE);
		}else{
			BrIngredient ing=new BrIngredient();
			ing.setIngName(strName);
			ing.setIngQty(qty);
			ing.setIngPrice(cost);
			ing.setIngDesc(strDesc);
			ing.setOrderNo(this.myView.getTextInv().getText());
			this.myOrdersIngs.add(ing);				
			this.myIngView.setVisible(false);
			processShowTable();	
		}			
		
	}
	private void processLoad(){
		this.myOrderProds=new ArrayList<BrProduct>();
		this.myOrdersIngs=new ArrayList<BrIngredient>();
		this.myView.getTextInv().setText(this.myOrderDao.getInvoiceNo());
		this.myView.getBtnPaid().setVisible(false);
		this.myView.getTextGrandTotal().setText(null);
		this.myView.getTableInvoice().setVisible(false);
	}
	private void processLoadProd(){
		String strId=this.myView.getTextId().getText();
		BrProduct p=this.myProdDao.getPordById(strId);
		if(p!=null){
			this.myView.getTextName().setText(p.getProdName());
			this.myView.getTextPrice().setText(""+p.getProdPrice());
			this.myProd=p;
		}else{
			this.myProd=null;
		}
	}
	private void processAdd(){
		String strQty=this.myView.getTextQty().getText();
		int qty=0;
		String error=new String();
		if(this.myProd==null)
			error+="Product is required \n";
		if(strQty==null || strQty.isEmpty())
			error+="Qutantity is required \n";
		else{
			try{
				qty=Integer.parseInt(strQty);
			}catch(Exception e){
				error+="Quantity must be integer\n";
			}
		}
		if(!error.isEmpty()){
			JOptionPane.showMessageDialog(this.myView,error,
					"Required Error",JOptionPane.ERROR_MESSAGE);
		}else{
			this.myProd.setQty(qty);
			this.myOrderProds.add(this.myProd);
			processShowTable();		
		}			
		this.myView.getTextId().setText(null);
		this.myView.getTextName().setText(null);
		this.myView.getTextPrice().setText(null);
		this.myView.getTextQty().setText(null);
	}
	private void processPaid(){
		if(this.myView.getTextGrandTotal().getText()!=null){
			if(this.myPaidView==null)
				this.myPaidView=new OrderPaidView();
			this.myPaidView.getLabel1().setVisible(false);
			this.myPaidView.getLabel2().setVisible(false);
			this.myPaidView.getText1().setVisible(false);
			this.myPaidView.getText2().setVisible(false);
			this.myPaidView.getRadioCard().addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent arg0) {
					processCard();
				}
			});
			this.myPaidView.getRadioCash().addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent arg0) {
					processCash();
				}
			});
			this.myPaidView.getBtnSave().addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent arg0) {
					processSave();
				}
			});
			this.myPaidView.getText1().addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(myPaidView.getRadioCard().isSelected())
						processCardPay();
					if(myPaidView.getRadioCash().isSelected())
						processCashPay();
				}
			});;
			this.myPaidView.setVisible(true);			
		}
	}
	private void processCashPay(){
		int paid=Integer.parseInt(this.myPaidView.getText1().getText());
		int grandTotal=Integer.parseInt(this.myView.getTextGrandTotal().getText());
		this.myPaidView.getText2().setText(""+(paid-grandTotal));
		
	}
	private void processCardPay(){		
		int grandTotal=Integer.parseInt(this.myView.getTextGrandTotal().getText());
		this.myPaidView.getText2().setText(""+grandTotal);
		
	}
	private void processCash(){
		this.myPaidView.getLabel1().setText("Enter Paid Amount:");
		this.myPaidView.getLabel2().setText("Return Amount:");
		processChange();
	}
	private void processCard(){
		this.myPaidView.getLabel1().setText("Enter Credit Card No:");
		this.myPaidView.getLabel2().setText("Paid Amount:");
		this.myPaidView.getText2().setText(this.myView.getTextGrandTotal().getText());
		processChange();
	}
	private void processChange(){
		this.myPaidView.getLabel1().setVisible(true);
		this.myPaidView.getLabel2().setVisible(true);
		this.myPaidView.getText1().setVisible(true);
		this.myPaidView.getText2().setVisible(true);
	}
	private void processSave(){
		boolean saveFlag=true;
		BrOrder o=new BrOrder();
		o.setOrderId(this.myView.getTextInv().getText());
		o.setEmpId(StableModel.loginEmp.getEmpId());
		o.setReceiveDate(this.myPaidView.getDateReceive().getDate());
		
		List<BrOrderDetail> d=new ArrayList<BrOrderDetail>();
		for(BrProduct p:this.myOrderProds){
			BrOrderDetail od=new BrOrderDetail();
			od.setPrice(p.getProdPrice());
			od.setQty(p.getQty());
			od.setProdId(p.getProdId());
			od.setOrderId(this.myView.getTextInv().getText());
			d.add(od);
		}
		o.setOrderDetails(d);
		
		o.setOrderIngs(this.myOrdersIngs);
		
		BrCustomer cur=new BrCustomer();
		cur.setCustName(this.myPaidView.getTextName().getText());
		cur.setCustPh(this.myPaidView.getTextPh().getText());
		o.setCustomer(cur);		
		
		BrCreditCard c=null;
		if(this.myPaidView.getRadioCard().isSelected()){
			c=new BrCreditCard();			
			c.setCardNo(this.myPaidView.getText1().getText());
			c.setCardPaid(Integer.parseInt(
					this.myPaidView.getText2().getText()));
			c.setCardPaidId(this.myView.getTextInv().getText());
			c.setCardStatus("order"); 	
			o.setPaidStatus("card");
			if(!c.getCardNo().startsWith("1111") && !c.getCardNo().startsWith("2222") &&
					!c.getCardNo().startsWith("3333")){
				saveFlag=false;
				JOptionPane.showMessageDialog(this.myView,
						"Your card is not valid","NOT VALID",
						JOptionPane.ERROR_MESSAGE
						);
			}else{
			try{
				boolean okFlag=
					BankRMIUtil.BANK_RMI.checkBalance(c.getCardNo(), c.getCardPaid());
				if(okFlag){
					BankRMIUtil.BANK_RMI.withdraw(c.getCardNo(), c.getCardPaid());
					System.out.println(c.getCardNo());
					if(c.getCardNo().startsWith("1111"))
						BankRMIUtil.BANK_RMI.deposit(BankRMIUtil.ACCOUNT_BANK1, c.getCardPaid());
					if(c.getCardNo().startsWith("2222"))
						BankRMIUtil.BANK_RMI.deposit(BankRMIUtil.ACCOUNT_BANK2, c.getCardPaid());
					if(c.getCardNo().startsWith("3333"))
						BankRMIUtil.BANK_RMI.deposit(BankRMIUtil.ACCOUNT_BANK3, c.getCardPaid());
				}else{
					JOptionPane.showMessageDialog(this.myView,
							"Your amount is not enough at Bank","NOT ENOUGH",
							JOptionPane.ERROR_MESSAGE
							);
					saveFlag=false;
				}
			}catch(Exception e){
				saveFlag=false;
			}
			}
		}		
		if(this.myPaidView.getRadioCash().isSelected()){
			c=null;
			o.setPaidStatus("cash");
		}
		o.setCreditCard(c);
		if(saveFlag){
			this.myOrderDao.saveOrder(o);
			this.myPaidView.setVisible(false);
			processLoad();
		}
	}
}

