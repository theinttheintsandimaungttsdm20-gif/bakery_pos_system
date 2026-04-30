package com.bakery.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import com.bakery.dao.BrEmployeeDao;
import com.bakery.model.BrEmployee;
import com.bakery.view.EmpHomeView;
import com.bakery.view.MyTableModel;

public class EmpHomeController {
	private EmpHomeView myView;
	private BrEmployeeDao myEmpDao;
	
	public EmpHomeController(EmpHomeView v){
		this.myView=v;
		this.myEmpDao=new BrEmployeeDao();
		processLoad();
		this.myView.getBtnSave().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				processSave();
			}
		});
	}
	private void processSave(){
		//prepare from VIew
		String strId=this.myView.getTextId().getText();
		String strName=this.myView.getTextName().getText();
		String strEmail=this.myView.getTextEmail().getText();
		String strPh=this.myView.getTextPh().getText();
		String strPassword=new String(this.myView.getTextPassword().getPassword());
		String strRoles=new String();
		if(this.myView.getRadioAdmin().isSelected()) strRoles="admin";
		if(this.myView.getRadioStaff().isSelected()) strRoles="staff";
		
		//prepare Model
		BrEmployee e=new BrEmployee();
		e.setEmpId(strId);
		e.setEmpName(strName);
		e.setEmpPassword(strPassword);
		e.setEmpEmail(strEmail);
		e.setEmpPh(strPh);
		e.setEmpRoles(strRoles);
		
		//save Model into DB by Dao
		this.myEmpDao.saveEmp(e);
		
		JOptionPane.showMessageDialog(this.myView, "Save Success");
		processLoad();
		
	}
	private void processLoad(){
		this.myView.getTextId().setText(this.myEmpDao.getEmployeeId());
		List<BrEmployee> el=this.myEmpDao.getAll();
		if(el!=null){
			MyTableModel tm=new MyTableModel(new String[]{"No","Id","Name","EMail","Ph","Roles"});
			tm.setRowCount(el.size());
			for(int i=0;i<el.size();i++){
				BrEmployee e=el.get(i);
				tm.setValueAt(i+1, i, 0);
				tm.setValueAt(e.getEmpId(), i, 1);
				tm.setValueAt(e.getEmpName(), i, 2);
				tm.setValueAt(e.getEmpEmail(), i, 3);
				tm.setValueAt(e.getEmpPh(), i, 4);
				tm.setValueAt(e.getEmpRoles(), i, 5);
			}
			this.myView.getTableShow().setModel(tm);
		}
		this.myView.getTextName().setText(null);
		this.myView.getTextEmail().setText(null);
		this.myView.getTextPassword().setText(null);
		this.myView.getTextPh().setText(null);
		this.myView.getRadioAdmin().setSelected(false);
		this.myView.getRadioStaff().setSelected(false);
	}

}

