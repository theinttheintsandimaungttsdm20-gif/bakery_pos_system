package com.bakery.dao;

import java.util.ArrayList;
import java.util.List;
import com.bakery.dao.config.DatabaseOperation;
import com.bakery.model.BrCategory;
import com.bakery.model.BrProduct;

public class BrProductDao extends DatabaseOperation {
	public String  getProductId() {
		String sql = "select substr(max(prod_id),5)+1 from br_product;";
		return super.getId(sql, "pid_", 4);		
	}
	public void saveProduct(BrProduct p) {
		String sql = "insert into br_product values(?,?,?,?,?)";
		super.operateQuery(sql,
				p.getProdId(),p.getProdName(),p.getProdPrice(),
				p.getProdDesc(),p.getBrCat().getCatId());
		if(p.getProdPhoto()!=null){
			sql = "insert into br_product_photo values(?,?,?,?)";
			super.operateQuery(sql,
					p.getProdId(),
					p.getProdPhoto().getPhotoName(),
					p.getProdPhoto().getPhotoData(),
					p.getProdPhoto().getPhotoSize());
		}
			
	}
	public BrProduct getPordById(String pid) {
		String sql = "select p.*,c.cat_name "
				+ "from br_product p,br_category c "
				+ "where p.prod_id=? "
				+ "and c.cat_id=p.cat_id ";
		List<Object[]> ol = super.operateSelect(sql,pid);
		List<BrProduct> l=mapResultObject(ol);
		return l==null || l.isEmpty() ? null : l.get(0);
	}
	public List<BrProduct> getAll() {
		String sql = "select p.*,c.cat_name "
				+ "from br_product p,br_category c "
				+ "where c.cat_id=p.cat_id";
		List<Object[]> ol = super.operateSelect(sql);
		return mapResultObject(ol);
	}
	public List<BrProduct> getByProdName(String pname) {
		String sql = "select p.*,c.cat_name "
				+ "from br_product p,br_category c "
				+ "where prod_name like ? "
				+ "and c.cat_id=p.cat_id";
		List<Object[]> ol = super.operateSelect(sql,"%"+pname+"%");
		return mapResultObject(ol);
	}
	public List<BrProduct> getByCatName(String cname) {
		String sql = "select p.*,c.cat_name "
				+ "from br_product p,br_category c "
				+ "where c.cat_name=? "
				+ "and c.cat_id=p.cat_id";
		List<Object[]> ol = super.operateSelect(sql,cname);
		return mapResultObject(ol);
	}
	public List<BrProduct> getByPordNameCatName(String pname,String cname) {
		String sql = "select p.*,c.cat_name "
				+ "from br_product p,br_category c "
				+ "where c.cat_name=? "
				+ "and c.cat_id=p.cat_id "
				+ "and p.prod_name like ?";
		List<Object[]> ol = super.operateSelect(sql,cname,"%"+pname+"%");
		return mapResultObject(ol);
	}
	private List<BrProduct> mapResultObject(List<Object[]> ol){
		List<BrProduct> l = new ArrayList<BrProduct>();
		if (ol != null) {
			for (Object[] oarray : ol) {
				BrProduct p = new BrProduct();
				p.setProdId((String) oarray[0]);
				p.setProdName((String) oarray[1]);
				p.setProdPrice((Integer) oarray[2]);
				p.setProdDesc((String) oarray[3]);
				p.setCatId(((Long) oarray[4]).intValue());
				
				BrCategory c=new BrCategory();
				c.setCatId(((Long) oarray[4]).intValue());
				c.setCatName((String)oarray[5]);
				p.setBrCat(c);
				l.add(p);
			}
		}
		return l == null || l.isEmpty() ? null : l;
	}
}
