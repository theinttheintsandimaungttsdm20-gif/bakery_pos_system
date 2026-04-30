package com.example.server.rmi.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.server.controller.MainController;
import com.example.server.dao.config.DatabaseOperation;
import com.example.server.model.Account;
import com.example.server.model.Transaction;
import com.example.server.rmi.AccountInf;

public class AccountImpl implements AccountInf {

	public String prepareUrl(String cardNo) {
		int bankNo = -1;
		if (cardNo.startsWith("1111"))
			bankNo = 1;
		if (cardNo.startsWith("2222"))
			bankNo = 2;
		if (cardNo.startsWith("3333"))
			bankNo = 3;
		boolean okFlag = MainController.myUrlList.containsKey(bankNo);
		if (okFlag)
			return MainController.myUrlList.get(bankNo);
		return null;
	}

	public String prepareUrlByBankName(String bname) {
		int bankNo = -1;
		if (bname.equals("bank1"))
			bankNo = 1;
		if (bname.equals("bank2"))
			bankNo = 2;
		if (bname.equals("bank3"))
			bankNo = 3;
		boolean okFlag = MainController.myUrlList.containsKey(bankNo);
		if (okFlag)
			return MainController.myUrlList.get(bankNo);
		return null;
	}

	@Override
	public boolean checkBalance(String cardNo, int amt) {
		DatabaseOperation db = new DatabaseOperation(prepareUrl(cardNo));
		String sql = "select account_balance from bk_account where card_no=?";
		List<Object[]> ol = db.operateSelect(sql,cardNo);
		if (ol == null || ol.isEmpty())
			return false;
		else {
			int balance = (Integer) ol.get(0)[0];
			return balance > amt ? true : false;
		}
	}

	@Override
	public boolean withdraw(String cardNo, int amt) {
		if (checkBalance(cardNo, amt)) {
			DatabaseOperation db = new DatabaseOperation(prepareUrl(cardNo));
			String sql[] = new String[2];
			List<Object[]> values = new ArrayList<Object[]>();

			sql[0] = "update bk_account "
					+ "set account_balance=account_balance-? "
					+ "where card_no=?";
			values.add(0, new Object[] { amt, cardNo });

			sql[1] = "insert into bk_transaction " 
					+ "values(null,?,current_date(),current_time(),'withdraw',"
					+ "(select account_id from bk_account where card_no=?))";
			values.add(1, new Object[] { amt, cardNo });

			db.operateGroupQuery(sql, values);

			return true;
		} else
			return false;
	}

	@Override
	public boolean deposit(String cardNo, int amt){			
			DatabaseOperation db = new DatabaseOperation(prepareUrl(cardNo));
			String sql[] = new String[2];
			List<Object[]> values = new ArrayList<Object[]>();

			sql[0] = "update bk_account "
					+ "set account_balance=account_balance+? "
					+ "where card_no=?";
			values.add(0, new Object[] { amt, cardNo });

			sql[1] = "insert into bk_transaction " 
					+ "values(null,?,current_date(),current_time(),'deposit',"
					+ "(select account_id from bk_account where card_no=?))";
			values.add(1, new Object[] { amt, cardNo });

			db.operateGroupQuery(sql, values);

			return true;
		
	}

	@Override
	public Account getBalance(String cardNo) {
		DatabaseOperation db = new DatabaseOperation(prepareUrl(cardNo));
		String sql = "select * from bk_account where card_no=?";
		List<Object[]> ol = db.operateSelect(sql, cardNo);
		List<Account> l = new ArrayList<Account>();
		if (ol != null) {
			for (Object[] o : ol) {
				Account a = new Account();
				a.setAccountId((Integer) o[0]);
				a.setHolderName((String) o[1]);
				a.setCardNo((String) o[2]);
				a.setAccountBalance((Integer) o[3]);
				l.add(a);
			}
		}
		return l == null || l.isEmpty() ? null : l.get(0);
	}

	@Override
	public List<Transaction> getTransaction(String cardNo) {
		DatabaseOperation db = new DatabaseOperation(prepareUrl(cardNo));
		String sql = "select t.*,a.* from bk_transaction t,bk_account a where "
				+ " a.card_no=? and t.account_id=a.account_id ";
		List<Object[]> ol = db.operateSelect(sql, cardNo);
		List<Transaction> l = new ArrayList<Transaction>();
		if (ol != null) {
			for (Object[] o : ol) {
				Transaction t = new Transaction();
				t.setTrandId((Integer) o[0]);
				t.setTranAmt((Integer) o[1]);
				t.setTranDate((Date) o[2]);
				t.setTranTime((Date) o[3]);
				t.setTranStatus((String) o[4]);
				t.setAccountId((Integer) o[5]);

				Account a = new Account();
				a.setAccountId((Integer) o[6]);
				a.setHolderName((String) o[7]);
				a.setCardNo((String) o[8]);
				a.setAccountBalance((int) o[9]);
				t.setAccount(a);
				l.add(t);
			}
		}
		return l == null || l.isEmpty() ? null : l;
	}

	@Override
	public List<Account> getAllAccount(String bankName) {
		System.out.println("GET ACCOUNTS " + bankName);
		System.out.println(MainController.myUrlList);
		DatabaseOperation db = new DatabaseOperation(prepareUrlByBankName(bankName));
		String sql = "select * from bk_account";
		List<Object[]> ol = db.operateSelect(sql);
		List<Account> l = new ArrayList<Account>();
		if (ol != null) {
			for (Object[] o : ol) {
				Account a = new Account();
				a.setAccountId((Integer) o[0]);
				a.setHolderName((String) o[1]);
				a.setCardNo((String) o[2]);
				a.setAccountBalance((Integer) o[3]);
				l.add(a);
			}
			System.out.println("GET ACCOUNTS " + l.size());
		}
		return l == null || l.isEmpty() ? null : l;
	}

}
