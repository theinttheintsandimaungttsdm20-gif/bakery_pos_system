package com.bakery.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.bakery.dao.config.DatabaseOperation;
import com.bakery.model.BrCategory;
import com.bakery.model.BrOrdersView;

public class BrOrdersViewDao extends DatabaseOperation {
	public List<BrOrdersView> getRangeByOrderDate(Date startDate,Date endDate) {
		String sql = "select * from br_orders_view where odate between ? and ?";
		List<Object[]> ol = super.operateSelect(sql,startDate,endDate);
		return mapResultObject(ol);
	}
	public List<BrOrdersView> getRangeByReceiveDate(Date startDate,Date endDate) {
		String sql = "select * from br_orders_view where rdate between ? and ?";
		List<Object[]> ol = super.operateSelect(sql,startDate,endDate);
		return mapResultObject(ol);
	}
	public List<BrOrdersView> getMonthly(int month) {
		String sql = "select * from br_orders_view where month(odate)=?";
		List<Object[]> ol = super.operateSelect(sql,month);
		return mapResultObject(ol);
	}
	private List<BrOrdersView> mapResultObject(List<Object[]> ol){
		List<BrOrdersView> l = new ArrayList<BrOrdersView>();
		if (ol != null) {
			for (Object[] oarray : ol) {
				BrOrdersView o=new BrOrdersView();
				o.setOrderNo((String)oarray[0]);
				o.setOrderDate((String)oarray[1]);
				o.setReceiveDate((String)oarray[2]);
				o.setOrderStatus((String)oarray[5]);
				o.setPaidStatus((String)oarray[6]);
				o.setCustName((String)oarray[7]);
				o.setDetailTotal(((BigDecimal)oarray[8])==null?"0":((BigDecimal)oarray[8]).toString());
				o.setIngTotal(((BigDecimal)oarray[9])==null?"0":((BigDecimal)oarray[9]).toString());
				l.add(o);
			}
		}
		return l == null || l.isEmpty() ? null : l;
	}
}
