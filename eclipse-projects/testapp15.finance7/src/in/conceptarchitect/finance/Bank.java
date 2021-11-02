package in.conceptarchitect.finance;

import in.conceptarchitect.finance.exceptions.InsufficientBalanceException;
import in.conceptarchitect.finance.exceptions.InvalidAccountException;

public class Bank {
	
	String name; //name of the bank
	int lastId=0;
	int accountCount=0;
	
	double interestRate;
	
	

	BankAccount [] accounts= new BankAccount[100]; //MAX 100. May not be great for large banks
	
	
	public int getAccountCount() {
		// TODO Auto-generated method stub
		return accountCount;
	}
	
	public void creditInterst() {
		//credit interest to all accounts
		for(int i=1;i<=lastId;i++) {
			
			accounts[i].creditInterest(interestRate);
		}
	}
	
	public  double getInterestRate() {
		return interestRate;
	}

	public  void setInterestRate(double interestRate) {
		
		this.interestRate = interestRate;
	}
	
	
	
	public Bank(String name, double interestRate) {
		super();
		this.name = name;
		this.interestRate = interestRate;
	}
	
	
	public int openAccount(String name, String password, double amount) {
		
		BankAccount account= new BankAccount(0, name, password,amount);
		return addAccount(account);
	}

	private int addAccount(BankAccount account) {
		int accountNumber= ++ lastId;
		account.accountNumber=accountNumber;
		accounts[accountNumber] = account; //store this account in the array.
		accountCount++;
		return accountNumber;
	}
	
	 BankAccount getAccountByNumber(int accountNumber) {
		// TODO Auto-generated method stub
		 
		if(accountNumber<0 || accountNumber>lastId || accounts[accountNumber]==null)
			 throw new InvalidAccountException(accountNumber);
		
		return accounts[accountNumber];
		
			
	}
	
	public void deposit(int accountNumber, double amount) {
		
		BankAccount account = getAccountByNumber(accountNumber);
		
		account.deposit(amount);
	}

	public double getAccountBalance(int accountNumber,String password) {
		// TODO Auto-generated method stub
		BankAccount account=getAccountByNumber(accountNumber);
		account.authenticate(password);
		
		//return balance only after validation
		return account.getBalance();
	}

	public void transfer(int source, double amount, String password, int target) {
		// TODO Auto-generated method stub
		BankAccount t= getAccountByNumber(target);
		BankAccount s= getAccountByNumber(source);
		
		
		s.withdraw(amount,password);
		t.deposit(amount);

		
	}

	public void closeAccount(int accountNumber, String password) {
		// TODO Auto-generated method stub
		var account=getAccountByNumber(accountNumber);
		
		account.authenticate(password);
			
		if(account.getBalance()<0)
			throw new InsufficientBalanceException(accountNumber, - account.getBalance());
		
		accounts[accountNumber]=null; //account is actually closed.
		
		accountCount--;
		
	}

	public void withdraw(int accountNumber, int amount, String password) {
		// TODO Auto-generated method stub
		var account=getAccountByNumber(accountNumber);
		
		account.withdraw(amount, password);
		
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
