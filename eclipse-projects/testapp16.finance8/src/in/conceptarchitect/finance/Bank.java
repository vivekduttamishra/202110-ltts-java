package in.conceptarchitect.finance;

import in.conceptarchitect.finance.exceptions.InsufficientBalanceException;
import in.conceptarchitect.finance.exceptions.InvalidAccountException;
import in.conceptarchitect.finance.exceptions.InvalidAccountTypeException;

public class Bank {
	
	String name; //name of the bank		
	double interestRate;	
	

	int lastId=0;
	int accountCount=0;
	BankAccount [] accounts= new BankAccount[100]; //MAX 100. May not be great for large banks
	
	private int addAccount(BankAccount account) {
		int accountNumber= ++ lastId;
		account.accountNumber=accountNumber;
		accounts[accountNumber] = account; //store this account in the array.
		accountCount++;
		return accountNumber;
	}
	
	private void removeAccount(int accountNumber) {
		//account is actually closed.
		accounts[accountNumber]=null;
	}

	BankAccount getAccountByNumber(int accountNumber) {
		// TODO Auto-generated method stub
		 
		if(accountNumber<0 || accountNumber>lastId || accounts[accountNumber]==null)
			 throw new InvalidAccountException(accountNumber);
		
		return accounts[accountNumber];
		
			
	}
	

	
	public int openAccount(String accountType,String name, String password, double amount) {
		
		BankAccount account= null;
		
		switch(accountType.toLowerCase()) {
			case "savings": account=new SavingsAccount(0,name,password,amount); break;
			case "current": account=new CurrentAccount(0,name,password,amount); break;
			case "od": account=new OverdraftAccount(0, name, password, amount); break;
			default: throw new InvalidAccountTypeException(accountType);
		}
		
		return addAccount(account);
	}

	public void closeAccount(int accountNumber, String password) {
		// TODO Auto-generated method stub
		var account=getAccountByNumber(accountNumber);
		
		account.authenticate(password);
			
		if(account.getBalance()<0)
			throw new InsufficientBalanceException(accountNumber, - account.getBalance());
		
		removeAccount(accountNumber); 		
		accountCount--;
		
	}

	
		
	public void deposit(int accountNumber, double amount) {
		
		BankAccount account = getAccountByNumber(accountNumber);
		
		account.deposit(amount);
	}

	public void withdraw(int accountNumber, double amount, String password) {
		// TODO Auto-generated method stub
		var account=getAccountByNumber(accountNumber);
		
		account.withdraw(amount, password);
		
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

	
	public int getAccountCount() {
		// TODO Auto-generated method stub
		return accountCount;
	}
	
	public void creditInterst() {
		//credit interest to all accounts
		for(int i=1;i<=lastId;i++) {
			if(accounts[i]!=null)
				accounts[i].creditInterest(interestRate);
		}
	}
	
		
	
	


	public Bank(String name, double interestRate) {
		super();
		this.name = name;
		this.interestRate = interestRate;
	}
	
	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	
	public  double getInterestRate() {
		return interestRate;
	}

	public  void setInterestRate(double interestRate) {
		
		this.interestRate = interestRate;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
