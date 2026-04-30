package com.bakery.dao;

import com.bakery.dao.config.DatabaseOperation;
public class BrEmpLogDao extends DatabaseOperation {
	
	public void login(String eid) {
		String sql = "insert into br_employee_log values(null,?,now(),null)";
		super.operateQuery(sql,eid);
	}
	public void logout(String eid) {
		String sql = "update br_employee_log "
				+ "set logout_time=now() "
				+ "where emp_id=? and logout_time is null";
		super.operateQuery(sql,eid);
	}
}
