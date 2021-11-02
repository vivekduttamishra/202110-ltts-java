package in.conceptarchitect.finance;

import in.conceptarchitect.finance.exceptions.InsufficientBalanceException;
import in.conceptarchitect.finance.exceptions.InvalidAccountException;
import in.conceptarchitect.finance.exceptions.InvalidAccountTypeException;
import in.conceptarchitect.finance.storage.AccountStorage;

public class Bank {
	
	String name; //name of the bank
	double interestRate;
	
	AccountStorage storage= new AccountStorage();
	
	
	public Bank(String name, double interestRate) {
		super();
		setInterestRate(interestRate);
		setName(name);
	}
	
	
	public int openAccount(String accountType,String name, String password, double amount) {
		
		BankAccount account= null;
		
		switch(accountType.toLowerCase()) {
			case "savings": account=new SavingsAccount(0,name,password,amount); break;
			case "current": account=new CurrentAccount(0,name,password,amount); break;
			case "od": account=new OverdraftAccount(0, name, password, amount); break;
			default: throw new InvalidAccountTypeException(accountType);
		}
		
		return storage.addAccount(account);
	}


	public void closeAccount(int accountNumber, String password) {
		// TODO Auto-generated method stub
		var account=storage.getAccountByNumber(accountNumber);
		
		account.authenticate(password);
			
		if(account.getBalance()<0)
			throw new InsufficientBalanceException(accountNumber, - account.getBalance());
		
		storage.removeAccount(account);
		
	}
	
	public void deposit(int accountNumber, double amount) {
		
		BankAccount account = storage.getAccountByNumber(accountNumber);
		
		account.deposit(amount);
	}

	public void withdraw(int accountNumber, double amount, String password) {
		// TODO Auto-generated method stub
		var account=storage.getAccountByNumber(accountNumber);
		
		account.withdraw(amount, password);
		
	}		
	
	public double getAccountBalance(int accountNumber,String password) {
		// TODO Auto-generated method stub
		BankAccount account=storage.getAccountByNumber(accountNumber);
		account.authenticate(password);
		
		//return balance only after validation
		return account.getBalance();
	}

	public void transfer(int source, double amount, String password, int target) {
		// TODO Auto-generated method stub
		BankAccount t= storage.getAccountByNumber(target);
		BankAccount s= storage.getAccountByNumber(source);
		
		
		s.withdraw(amount,password);
		t.deposit(amount);

		
	}
		
	
	
	public void creditInterst() {
//		//credit interest to all accounts
//		for(int i=1;i<=lastId;i++) {
//			if(accounts[i]!=null)
//				accounts[i].creditInterest(interestRate);
//		}
	}
	
	public int getAccountCount() {
		// TODO Auto-generated method stub
		return storage.size();
	}
	
	
	


	public double getInterestRate() {
		return interestRate;
	}


	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
