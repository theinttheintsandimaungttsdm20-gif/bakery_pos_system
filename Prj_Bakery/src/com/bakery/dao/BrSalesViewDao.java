package com.bakery.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.bakery.dao.config.DatabaseOperation;
import com.bakery.model.BrCategory;
import com.bakery.model.BrSalesView;

public class BrSalesViewDao extends DatabaseOperation {
	public List<BrSalesView> getRange(Date startDate,Date endDate) {
		String sql = "select * from br_sales_view where sdate between ? and ?";
		List<Object[]> ol = super.operateSelect(sql,startDate,endDate);
		return mapResultObject(ol);
	}
	public List<BrSalesView> getMonthly(int month) {
		String sql = "select * from br_sales_view where month(sdate)=?";
		List<Object[]> ol = super.operateSelect(sql,month);
		return mapResultObject(ol);
	}
	private List<BrSalesView> mapResultObject(List<Object[]> ol){
		List<BrSalesView> l = new ArrayList<BrSalesView>();
		if (ol != null) {
			for (Object[] oarray : ol) {
				BrSalesView s=new BrSalesView();
				s.setSalesId((String)oarray[0]);
				s.setSalesDate((String)oarray[1]);
				s.setSalesStatus((String)oarray[3]);
				s.setSalesEmpId((String)oarray[4]);
				s.setSalesEmpName((String)oarray[5]);
				s.setSalesTotal(((BigDecimal)oarray[6]).toString());
				l.add(s);
			}
		}
		return l == null || l.isEmpty() ? null : l;
	}
}
