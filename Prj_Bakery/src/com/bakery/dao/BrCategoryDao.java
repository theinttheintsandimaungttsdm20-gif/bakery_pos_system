package com.bakery.dao;

import java.util.ArrayList;
import java.util.List;

import com.bakery.dao.config.DatabaseOperation;
import com.bakery.model.BrCategory;

public class BrCategoryDao extends DatabaseOperation {
	public List<BrCategory> getAll() {
		String sql = "select * from br_category order by cat_name asc";
		List<Object[]> ol = super.operateSelect(sql);
		return mapResultObject(ol);
	}
	public BrCategory getBrCategoryByName(String catName) {
		String sql = "select * from br_category where cat_name=?";
		List<Object[]> ol = super.operateSelect(sql,catName);
		List<BrCategory> l=mapResultObject(ol);
		return l==null ? null : l.get(0);
	}
	private List<BrCategory> mapResultObject(List<Object[]> ol){
		List<BrCategory> l = new ArrayList<BrCategory>();
		if (ol != null) {
			for (Object[] oarray : ol) {
				BrCategory c = new BrCategory();
				c.setCatId(((Long)oarray[0]).intValue());
				c.setCatName((String) oarray[1]);

				l.add(c);
			}
		}
		return l == null || l.isEmpty() ? null : l;
	}
}
