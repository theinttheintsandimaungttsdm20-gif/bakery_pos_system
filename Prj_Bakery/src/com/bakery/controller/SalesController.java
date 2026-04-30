package com.bakery.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import com.bakery.dao.BrProductDao;
import com.bakery.dao.BrSalesDao;
import com.bakery.model.BrCreditCard;
import com.bakery.model.BrProduct;
import com.bakery.model.BrSales;
import com.bakery.model.BrSalesDetail;
import com.bakery.model.StableModel;
import com.bakery.util.BankRMIUtil;
import com.bakery.view.MyTableModel;
import com.bakery.view.PaidView;
import com.bakery.view.SalesView;

public class SalesController {
	private SalesView myView;
	private BrSalesDao mySalesDao;
	private BrProductDao myProdDao;
	private BrProduct myProd;
	private List<BrProduct> mySalesProds;
	private PaidView myPaidView;
	public SalesController(SalesView v){
		this.myView=v;		
		this.mySalesDao=new BrSalesDao();
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
		this.myView.getBtnPaid().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				processPaid();
			}
		});
	}
	private void processLoad(){
		this.mySalesProds=new ArrayList<BrProduct>();
		this.myView.getTextInv().setText(this.mySalesDao.getInvoiceNo());
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
			this.mySalesProds.add(this.myProd);
			int grandTotal=0;
			MyTableModel tm=new MyTableModel(new String[]{
					"No","Pid","ProductName","Price","Qty","Sub Total"});
			tm.setRowCount(this.mySalesProds.size());
			for(int i=0;i<this.mySalesProds.size();i++){
				BrProduct p=this.mySalesProds.get(i);
				
				tm.setValueAt(i+1, i, 0);
				tm.setValueAt(p.getProdId(), i, 1);
				tm.setValueAt(p.getProdName(), i, 2);
				tm.setValueAt(p.getProdPrice(), i, 3);
				tm.setValueAt(p.getQty(), i, 4);
				int subTotal=p.getQty()*p.getProdPrice();
				tm.setValueAt(subTotal, i, 5);
				grandTotal+=subTotal;
			}
			this.myView.getTableInvoice().setModel(tm);
			this.myView.getTableInvoice().setVisible(true);
			this.myView.getTableInvoice().setRowHeight(25);
			this.myView.getTextGrandTotal().setText(""+grandTotal);
			this.myView.getBtnPaid().setVisible(true);		
		}			
		this.myView.getTextId().setText(null);
		this.myView.getTextName().setText(null);
		this.myView.getTextPrice().setText(null);
		this.myView.getTextQty().setText(null);
	}
	private void processPaid(){
		if(this.myView.getTextGrandTotal().getText()!=null){
			if(this.myPaidView==null)
				this.myPaidView=new PaidView();
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
		BrSales s=new BrSales();
		s.setSalesId(this.myView.getTextInv().getText());
		s.setEmpId(StableModel.loginEmp.getEmpId());		
		
		List<BrSalesDetail> d=new ArrayList<BrSalesDetail>();
		for(BrProduct p:this.mySalesProds){
			BrSalesDetail sd=new BrSalesDetail();
			sd.setPrice(p.getProdPrice());
			sd.setQty(p.getQty());
			sd.setProdId(p.getProdId());
			sd.setSalesId(this.myView.getTextInv().getText());
			d.add(sd);
		}
		BrCreditCard c=null;
		if(this.myPaidView.getRadioCard().isSelected()){
			c=new BrCreditCard();			
			c.setCardNo(this.myPaidView.getText1().getText());
			c.setCardPaid(Integer.parseInt(
					this.myPaidView.getText2().getText()));
			c.setCardPaidId(this.myView.getTextInv().getText());
			c.setCardStatus("sales"); 	
			s.setPaidStatus("card");
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
			s.setPaidStatus("cash");
		}
		s.setSalesDetails(d);
		s.setCreditCard(c);
		if(saveFlag){
			this.mySalesDao.saveSales(s);
			this.myPaidView.setVisible(false);
			processLoad();
		}
	}
}

