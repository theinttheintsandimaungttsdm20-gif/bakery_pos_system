package com.bakery.dao.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOperation {
	protected String  getId(String sql,String startCode,int codeLength) {
		List<Object[]> ol = this.operateSelect(sql);
		Double id=(double)1;
		if(ol!=null && !ol.isEmpty()) id=(Double)ol.get(0)[0];
		if(id==null) id=(double)1;
		String strId=""+id.intValue();
		if(strId.length()!=codeLength){
			int len=strId.length();
			for(int i=0;i<codeLength-len;i++)
				strId="0"+strId;
		}
		return startCode+strId;		
	}	
	//insert,update,delete
	//sql =insert into category values(?,?,?);
	//values=?:1,?:2,?:3
	protected void operateQuery(String sql,Object ...values){
		Connection c=DatabaseConnection.openConnection();
		try{
			PreparedStatement stmt=c.prepareStatement(sql);
				int colIndex=1;
				for(Object v:values){
					stmt.setObject(colIndex,v);
					colIndex++;
				}				
				stmt.execute();
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}		
		DatabaseConnection.closeConnection(c);		
	}
	protected void operateGroupQuery(String sql[],List<Object[]> values){
		Connection c=DatabaseConnection.openConnection();
		try{
			c.setAutoCommit(false);
			for(int i=0;i<sql.length;i++){
				PreparedStatement stmt=c.prepareStatement(sql[i]);
				int colIndex=1;
				if(values.get(i)!=null && values.get(i).length>0){
					for(Object v:values.get(i)){
						stmt.setObject(colIndex,v);
						colIndex++;
					}
				}
				stmt.execute();
				stmt.close();
			}
			c.commit();
		}catch(Exception e){
			e.printStackTrace();
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}		
		DatabaseConnection.closeConnection(c);		
	}
	//select
	protected List<Object[]> operateSelect(String sql,Object ...whereArgs){
			//System.out.println("Operation Trace :"+sql);
			List<Object[]> result=new ArrayList<Object[]>();
			Connection c=DatabaseConnection.openConnection();
			try{
				PreparedStatement stmt=c.prepareStatement(sql);
				int index=1;
				for(Object whereVal:whereArgs){
					//System.out.println("Operation Trace :"+whereVal);
					stmt.setObject(index,whereVal);
					index++;
				}
				//System.out.println("Operation Trace :"+stmt.toString());
				ResultSet rs=stmt.executeQuery();
				int colSize=rs.getMetaData().getColumnCount();
				//System.out.println("Operation Trace :"+colSize);
				while(rs.next()){//each record by record
					//System.out.println("Operation Trace :");
					Object[] record=new Object[colSize];
					for(int i=0;i<colSize;i++){//each col by col
						record[i]=rs.getObject(i+1);
					}
					//one record
					result.add(record);
				}		
				//System.out.println("Operation Trace :"+result.size());
			}catch(Exception e){e.printStackTrace();}
			DatabaseConnection.closeConnection(c);
			return result==null || result.isEmpty() ? null : result;
		}

}
