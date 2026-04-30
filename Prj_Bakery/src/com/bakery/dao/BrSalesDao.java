package com.bakery.dao;

import java.util.ArrayList;
import java.util.List;

import com.bakery.dao.config.DatabaseOperation;
import com.bakery.model.BrCreditCard;
import com.bakery.model.BrSales;
import com.bakery.model.BrSalesDetail;

public class BrSalesDao extends DatabaseOperation {
	public String  getInvoiceNo() {
		String sql = "select substr(max(sales_id),5)+1 from br_sales;";
		return super.getId(sql, "INV_", 11);		
	}
	public void saveSales(BrSales s){
		int count=1+s.getSalesDetails().size()+
				(s.getCreditCard()==null?0:1);		
		String sql[]=new String[count];
		List<Object[]> values=new ArrayList<Object[]>();
		sql[0]="insert into br_sales values(?,now(),?,?)";
		values.add(0,new Object[]{s.getSalesId(),s.getPaidStatus(),s.getEmpId()});
		int j=1;
		for(int i=0;i<s.getSalesDetails().size();i++){
			BrSalesDetail d=s.getSalesDetails().get(i);
			sql[j]="insert into br_sales_detail "
					+ "values(null,?,?,?,?)";
			values.add(j,new Object[]{d.getProdId(),d.getQty(),d.getPrice(),d.getSalesId()});	
			j++;
		}
		if(s.getCreditCard()!=null){
			BrCreditCard c=s.getCreditCard();
			sql[j]="insert into br_credit_card values(null,?,?,?,?)";
			values.add(j,new Object[]{c.getCardNo(),c.getCardPaid(),
					c.getCardStatus(),c.getCardPaidId()});
		}
		super.operateGroupQuery(sql, values);
	}
	
}
