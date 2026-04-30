package com.example.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.example.server.model.Account;
import com.example.server.model.Transaction;

public interface AccountInf extends Remote{
	public boolean checkBalance(String cardNo,int amt) throws RemoteException;
	public boolean withdraw(String cardNo,int amt) throws RemoteException;
	public boolean deposit(String cardNo,int amt) throws RemoteException;
	public Account getBalance(String cardNo) throws RemoteException;
	public List<Transaction> getTransaction(String cardNo) throws RemoteException;
	public List<Account> getAllAccount(String bankName) throws RemoteException;
}
