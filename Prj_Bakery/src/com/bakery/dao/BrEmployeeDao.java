package com.bakery.dao;

import java.util.ArrayList;
import java.util.List;

import com.bakery.dao.config.DatabaseOperation;
import com.bakery.model.BrEmployee;

public class BrEmployeeDao extends DatabaseOperation {
	public String  getEmployeeId() {
		String sql = "select substr(max(emp_id),5)+1 from br_employee;";
		return super.getId(sql, "eid_", 4);		
	}
	public void saveEmp(BrEmployee e) {
		String sql = "insert into br_employee values(?,?,md5(?),?,?,?)";

		super.operateQuery(sql, e.getEmpId(), e.getEmpName(), e.getEmpPassword(), e.getEmpEmail(), e.getEmpPh(),
				e.getEmpRoles());
	}

	public List<BrEmployee> getAll() {
		String sql = "select * from br_employee";
		List<Object[]> ol = super.operateSelect(sql);
		return mapResultObject(ol);
	}
	
	public BrEmployee getEmployee(String Id) {
		String sql = "select * from br_employee where emp_id=?";
		List<Object[]> ol = super.operateSelect(sql,Id);
		List<BrEmployee> el = mapResultObject(ol);
		return el == null || el.isEmpty() ? null : el.get(0);
	}
	public BrEmployee getEmployee(String Id,String password) {
		String sql = "select * from br_employee where emp_id=? and emp_password=md5(?)";
		List<Object[]> ol = super.operateSelect(sql,Id,password);
		List<BrEmployee> el = mapResultObject(ol);
		return el == null || el.isEmpty() ? null : el.get(0);
	}
	private List<BrEmployee> mapResultObject(List<Object[]> ol){
		List<BrEmployee> el = new ArrayList<BrEmployee>();
		if (ol != null) {
			for (Object[] oarray : ol) {
				BrEmployee e = new BrEmployee();
				e.setEmpId((String) oarray[0]);
				e.setEmpName((String) oarray[1]);
				e.setEmpPassword((String) oarray[2]);
				e.setEmpEmail((String) oarray[3]);
				e.setEmpPh((String) oarray[4]);
				e.setEmpRoles((String) oarray[5]);

				el.add(e);
			}
		}
		return el == null || el.isEmpty() ? null : el;
	}
}
