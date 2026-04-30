package com.bakery.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.bakery.dao.BrEmpLogDao;
import com.bakery.dao.BrEmployeeDao;
import com.bakery.model.BrEmployee;
import com.bakery.model.StableModel;
import com.bakery.view.LoginView;


public class LoginController {
	private MainController myMainController;
	private LoginView myView;
	private BrEmployeeDao myEmpDao;
	private BrEmpLogDao myEmpLogDao;
	public LoginController(LoginView v,MainController mc){
		this.myMainController=mc;
		this.myView=v;
		this.myEmpDao=new BrEmployeeDao();
		this.myEmpLogDao=new BrEmpLogDao();
		this.myView.getBtnLogin().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				processLogin();				
			}
		});		
	}
	private void processLogin(){
		String strId=this.myView.getTextId().getText();
		String strPassword=new String(this.myView.getTextPassword().getPassword());
		String error=new String();
		if(strId==null || strId.isEmpty())
			error+="Id is required \n";
		if(strId==null || strId.isEmpty())
			error+="Password is required \n";
		if(!error.isEmpty()){
			JOptionPane.showMessageDialog(this.myView,error,"Required Error",JOptionPane.ERROR_MESSAGE);
		}else{
			BrEmployee e=this.myEmpDao.getEmployee(strId);
			if(e==null)
				JOptionPane.showMessageDialog(this.myView,
						"Employee does not exist","User Error",JOptionPane.ERROR_MESSAGE);
			else{
				e=this.myEmpDao.getEmployee(strId, strPassword);
				if(e==null)
					JOptionPane.showMessageDialog(this.myView,
							"Employee must not match password","User Error",JOptionPane.ERROR_MESSAGE);
				else{
					StableModel.loginEmp=e;
					this.myMainController.prepareHome();
					this.myEmpLogDao.login(e.getEmpId());
				}
			}
		}
	}
}

