package in.conceptarchitect.finance;

import java.util.Scanner;

import in.conceptarchitect.finance.exceptions.InsufficientBalanceException;
import in.conceptarchitect.finance.exceptions.InvalidCredentialsException;
import in.conceptarchitect.finance.exceptions.InvalidDenominationException;

public class BankAccount {
	
	int accountNumber;
	String name;
	String password;
	double balance;
	static double interestRate = 10;
	
	public static double getInterestRate() {
		return interestRate;
	}

	public static void setInterestRate(double interestRate) {
		
		BankAccount.interestRate = interestRate;
	}
	
	
	public BankAccount(int accountNumber, String name, String password, double amount) {
		
		balance=amount; //this is optional here as there is a single balance in the context	
		this.name=name;
		setPassword(password);		
		this.accountNumber=accountNumber;
		
	}
	
	
	
	public int getAccountNumber() {
		return accountNumber;
	}

	//account number can't be changed
	//public void setAccountNumber(int accountNumber) {this.accountNumber = accountNumber;}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public double getBalance() {
		return balance;
	}

	
	
	

	//should there be a getPassword and setPassword
	
//	public String getPassword() {
//		return password;
//	}
	
	
	void setPassword(String password) {
		
		this.password = salt(password);
	}
	
	
	public void changePassword(String oldPassword, String newPassword) {
		authenticate(oldPassword);
		setPassword(newPassword);
	}
	

	

	private String salt(String password) {
		
		String salted="";
		
		for(int i=0;i<password.length();i++) {
			int ch= (int) password.charAt(i);
			salted+=Integer.toHexString(ch);
		}
		return salted;
	}


	
	public void show() {
		System.out.println("account number\t"+accountNumber);
		System.out.println("name         \t"+name);
		System.out.println("password     \t"+password);
		System.out.println("balance      \t"+balance);
		//System.out.println("interest rate\t"+Bank.getInterestRate());
		System.out.println();
		
	}

	public void deposit(double amount) {
		// TODO Auto-generated method stub
		validateDenomination(amount);
		balance+=amount;
		
	}
	
	
	public void authenticate(String password) {
		if( !this.password.equals(salt(password)))
			throw new InvalidCredentialsException(accountNumber);
		
		//No error here
	}

	private void validateDenomination(double amount) {
		if(amount<=0)
			throw new InvalidDenominationException(accountNumber, "Amount Must be a Positive Value");
	}
	
	private void ensureFunds(double amount) {
		if (amount>balance) {
			throw new InsufficientBalanceException(accountNumber, amount-balance);
		}
	}
	
	
	public void withdraw(double amount, String password) {
		
		validateDenomination(amount);
		
		ensureFunds(amount); 
		

		authenticate(password);
			
		
			
		balance-=amount;
		
		
	}

	

	
	public void creditInterest(double interestRate) {
		balance+=(balance*interestRate/1200);
	}


}






