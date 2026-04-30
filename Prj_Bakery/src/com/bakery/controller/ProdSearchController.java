package com.bakery.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import com.bakery.dao.BrCategoryDao;
import com.bakery.dao.BrProductDao;
import com.bakery.model.BrCategory;
import com.bakery.model.BrProduct;
import com.bakery.view.MyTableModel;
import com.bakery.view.ProdSearchView;


public class ProdSearchController {
	private ProdSearchView myView;
	private BrCategoryDao myCatDao;
	private BrProductDao myProdDao;
	public ProdSearchController(ProdSearchView v){
		this.myView=v;
		this.myCatDao=new BrCategoryDao();
		this.myProdDao=new BrProductDao();
		processLoad();
		this.myView.getBtnSearch().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				processSearch();
			}
		});		
	}
	private void processSearch(){
		String strName=this.myView.getTextName().getText();
		String strCatName=(String)this.myView.getComboCat().getSelectedItem();
		List<BrProduct> l=null;
		if(strName.isEmpty() && strCatName.equals("All"))
			l=this.myProdDao.getAll();
		else if(!strName.isEmpty() && !strCatName.equals("All"))
			l=this.myProdDao.getByPordNameCatName(strName,strCatName);
		else if(!strName.isEmpty() && strCatName.equals("All"))
			l=this.myProdDao.getByProdName(strName);
		else if(strName.isEmpty() && !strCatName.equals("All"))
			l=this.myProdDao.getByCatName(strName);
		if(l!=null){
			MyTableModel tm=new MyTableModel(new String[]{"No","Id","Name","Price","Category Name"});
			tm.setRowCount(l.size());
			for(int i=0;i<l.size();i++){
				BrProduct p=l.get(i);
				
				tm.setValueAt(i+1, i, 0);
				tm.setValueAt(p.getProdId(), i, 1);
				tm.setValueAt(p.getProdName(), i, 2);
				tm.setValueAt(p.getProdPrice(), i, 3);
				tm.setValueAt(p.getBrCat().getCatName(), i, 4);
			}
			this.myView.getTableShow().setModel(tm);
			this.myView.getTableShow().setVisible(true);
		}else{
			this.myView.getTableShow().setVisible(false);
			JOptionPane.showMessageDialog(this.myView,"No Product in Search Criteria",
					"NOT FOUND",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private void processLoad(){
		List<BrCategory> cl=this.myCatDao.getAll();
		this.myView.getComboCat().addItem("All");
		for(BrCategory c:cl)
			this.myView.getComboCat().addItem(c.getCatName());		
		
		this.myView.getTextName().setText(null);
	}
	
}

