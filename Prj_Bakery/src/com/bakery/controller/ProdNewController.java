package com.bakery.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.bakery.dao.BrCategoryDao;
import com.bakery.dao.BrProductDao;
import com.bakery.model.BrCategory;
import com.bakery.model.BrProduct;
import com.bakery.view.ProdNewView;


public class ProdNewController {
	private ProdNewView myView;
	private BrCategoryDao myCatDao;
	private BrProductDao myProdDao;
	private File myProdImage;
	public ProdNewController(ProdNewView v){
		this.myView=v;
		this.myCatDao=new BrCategoryDao();
		this.myProdDao=new BrProductDao();
		prepareCombo();
		processLoad();
		this.myView.getBtnSave().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				processSave();
			}
		});
		this.myView.getCheckProdImage().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				processLoadPhoto();
			}
		});
	}
	private void processSave(){
		String strName=this.myView.getTextName().getText();
		String strDesc=this.myView.getTextDesc().getText();
		String strPrice=this.myView.getTextPrice().getText();
		int price=0;
		String strCatName=(String)this.myView.getComboCat().getSelectedItem();
		
		String error=new String();
		if(strCatName.equals("Select"))
			error+="Please Select Category\n";
		if(strName==null || strName.isEmpty())
			error+="Product Name is required \n";
		if(strPrice==null || strPrice.isEmpty())
			error+="Product Price is required \n";
		else{
			try{
				price=Integer.parseInt(strPrice);
			}catch(Exception e){
				error+="Product Price must be integer \n";
			}
		}
		if(strDesc==null || strDesc.isEmpty())
			error+="Product Description is required \n";
		if(!error.isEmpty()){
			JOptionPane.showMessageDialog(this.myView,
					error,"Required Error",JOptionPane.ERROR_MESSAGE);
		}else{
			BrCategory cat=this.myCatDao.getBrCategoryByName(strCatName);
			BrProduct p=new BrProduct();
			p.setProdId(this.myView.getTextId().getText());
			p.setProdName(strName);
			p.setProdPrice(price);
			p.setProdDesc(strDesc);
			p.setBrCat(cat);
			
			if(this.myProdImage!=null){
				String imageName=this.myProdImage.getName();
				long imageSize=this.myProdImage.length();
				byte imageData[]=new byte[(int)imageSize];
				try{
					FileInputStream fis=new FileInputStream(this.myProdImage);
					fis.read(imageData);
					fis.close();
					
					BrProduct.BrProductPhoto photo=p.new BrProductPhoto();
					photo.setPhotoName(imageName);
					photo.setPhotoSize(imageSize);
					photo.setPhotoData(imageData);
					p.setProdPhoto(photo);					
				}catch(Exception e){}				
			}else{
				p.setProdPhoto(null);
			}
			this.myProdDao.saveProduct(p);
			JOptionPane.showMessageDialog(this.myView,"Save Success",
					"Confirm",JOptionPane.INFORMATION_MESSAGE);
			processLoad();
		}
		
	}
	private void prepareCombo(){
		List<BrCategory> cl=this.myCatDao.getAll();
		this.myView.getComboCat().addItem("Select");
		for(BrCategory c:cl)
			this.myView.getComboCat().addItem(c.getCatName());
		
	}
	private void processLoad(){
		
		this.myView.getTextId().setText(this.myProdDao.getProductId());
		this.myView.getTextName().setText(null);
		this.myView.getTextPrice().setText(null);
		this.myView.getTextDesc().setText(null);
		this.myView.getComboCat().setSelectedIndex(0);
		this.myView.getLblProdImage().setIcon(null);
		this.myView.getLblProdImage().setVisible(false);
		this.myProdImage=null;
		this.myView.getCheckProdImage().setSelected(false);
	}
	private void processLoadPhoto(){
		if(this.myView.getCheckProdImage().isSelected()){
			JFileChooser fc=new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			FileNameExtensionFilter fxf=new FileNameExtensionFilter("images",
				"jpg","jpeg","png");
			fc.setFileFilter(fxf);
			int ret=fc.showOpenDialog(this.myView);
			if(ret==JFileChooser.APPROVE_OPTION){
				File image=fc.getSelectedFile();
				ImageIcon icon = new ImageIcon(image.getAbsolutePath());
				icon = new ImageIcon(icon.getImage().getScaledInstance(250,250,
					BufferedImage.SCALE_SMOOTH));
				this.myView.getLblProdImage().setIcon(icon);	
				this.myView.getLblProdImage().setVisible(true);
				this.myProdImage=image;
			}
		}else{
			this.myView.getLblProdImage().setIcon(null);
			this.myView.getLblProdImage().setVisible(false);
			this.myProdImage=null;
		}
	}
}

