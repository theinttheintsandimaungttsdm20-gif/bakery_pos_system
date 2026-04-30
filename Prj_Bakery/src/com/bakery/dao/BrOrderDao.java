package com.bakery.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bakery.dao.config.DatabaseOperation;
import com.bakery.model.BrCreditCard;
import com.bakery.model.BrCustomer;
import com.bakery.model.BrEmployee;
import com.bakery.model.BrIngredient;
import com.bakery.model.BrOrder;
import com.bakery.model.BrOrderDetail;
import com.bakery.model.BrProduct;
import com.bakery.model.BrSales;
import com.bakery.model.BrSalesDetail;

public class BrOrderDao extends DatabaseOperation {
	public String  getInvoiceNo() {
		String sql = "select substr(max(order_no),5)+1 from br_order;";
		return super.getId(sql, "ORD_", 11);		
	}
	public void saveOrder(BrOrder o){
		int count=2+
				o.getOrderDetails().size()+
				(o.getCreditCard()==null?0:1)+o.getOrderIngs().size();
		
		String sql[]=new String[count];		
		List<Object[]> values=new ArrayList<Object[]>();
		
		sql[0]="insert into br_customer values(null,?,?)";
		values.add(0,new Object[]{o.getCustomer().getCustName(),o.getCustomer().getCustPh()});
		
		sql[1]="insert into br_order values"
				+ "(?,now(),?,0,?,(select last_insert_id()),?)";
		values.add(1,new Object[]{
				o.getOrderId(),o.getReceiveDate(),
				o.getPaidStatus(),o.getEmpId()});
		
		int j=2;
		for(int i=0;i<o.getOrderDetails().size();i++){
			BrOrderDetail d=o.getOrderDetails().get(i);
			sql[j]="insert into br_order_detail "
					+ "values(null,?,?,?,?)";
			values.add(j,new Object[]{
					d.getQty(),d.getPrice(),
					d.getOrderId(),d.getProdId()});	
			j++;
		}
		
		if(o.getCreditCard()!=null){
			BrCreditCard c=o.getCreditCard();
			sql[j]="insert into br_credit_card "
					+ "values(null,?,?,?,?)";
			values.add(j,new Object[]{
					c.getCardNo(),c.getCardPaid(),
					c.getCardStatus(),o.getOrderId()});
			j++;
		}
		
		for(int i=0;i<o.getOrderIngs().size();i++){
			BrIngredient ing=o.getOrderIngs().get(i);
			sql[j]="insert into br_ingredient "
					+ "values(null,?,?,?,?,?)";
			values.add(j,new Object[]{
					ing.getIngName(),ing.getIngDesc(),
					ing.getIngPrice(),ing.getIngQty(),
					o.getOrderId()});	
			j++;
		}
		super.operateGroupQuery(sql, values);
	}
	public void updateOrderStatus(String ono) {
		String sql = "update br_order set order_status=1 where order_no=?";
		super.operateQuery(sql, ono);
	}
	public BrOrder getOrderByNo(String ono) {
		
		String sql = "select o.*,c.*,e.* "
				+ "from br_order o,br_customer c,br_employee e "
				+ "where o.order_no=? and "
				+ "o.cust_id=c.cust_id and "
				+ "o.emp_id=e.emp_id";
		List<Object[]> ol = super.operateSelect(sql,ono);
		BrOrder or=null;
		if(ol!=null && !ol.isEmpty()){
			or=new BrOrder();
			System.out.println("SIZE ="+ol.size());
			for(Object[] obj:ol){
				or.setOrderId((String)obj[0]); 
				or.setOrderDate((Date)obj[1]);
				or.setReceiveDate((Date)obj[2]);
				or.setOrderStatus(((Integer)obj[3])==0?false:true);
				or.setPaidStatus((String)obj[4]);
				or.setCustId((Integer)obj[5]);
				or.setEmpId((String)obj[6]);
				
				BrCustomer c=new BrCustomer();
				c.setCustId((Integer)obj[7]);
				c.setCustName((String)obj[8]);
				c.setCustPh((String)obj[9]);
				or.setCustomer(c);
				
				BrEmployee e=new BrEmployee();
				e.setEmpId((String)obj[10]);
				e.setEmpName((String)obj[11]);
				e.setEmpPassword((String)obj[12]);
				e.setEmpPh((String)obj[13]);
				e.setEmpRoles((String)obj[14]);
				or.setEmp(e);				
				
				String sql1 = "select d.*,p.prod_name "
						+ "from br_order_detail d,br_product p "
						+ "where d.order_no=? and "
						+ "d.prod_id=p.prod_id";
				List<Object[]> ol1 = super.operateSelect(sql1,ono);
				List<BrOrderDetail> dl=new ArrayList<BrOrderDetail>();
				if(ol1!=null){
					for(Object[] ob:ol1){
						BrOrderDetail d=new BrOrderDetail();
						d.setDeteailId((Integer)ob[0]);
						d.setQty((Integer)ob[1]);
						d.setPrice((Integer)ob[2]);
						d.setOrderId((String)ob[3]);
						d.setProdId((String)ob[4]);
						BrProduct p=new BrProduct();
						p.setProdName((String)ob[5]);
						d.setProd(p);
						dl.add(d);
					}
					or.setOrderDetails(dl);
				}else{
					or.setOrderDetails(null);
				}
				
				sql1 = "select * "
						+ "from br_ingredient "
						+ "where order_no=? ";
				ol1 = super.operateSelect(sql1,ono);
				List<BrIngredient> il=new ArrayList<BrIngredient>();
				if(ol1!=null){
					for(Object[] ob:ol1){
						BrIngredient ing=new BrIngredient();
						ing.setIngId((Integer)ob[0]);
						ing.setIngName((String)ob[1]);
						ing.setIngDesc((String)ob[5]);
						ing.setIngPrice((Integer)ob[3]);
						ing.setIngQty((Integer)ob[4]);
						ing.setOrderNo((String)ob[5]);
						il.add(ing);
					}
					or.setOrderIngs(il);
				}else{
					or.setOrderIngs(null);
				}
				
			}
		}		
		return or;
	}
}
