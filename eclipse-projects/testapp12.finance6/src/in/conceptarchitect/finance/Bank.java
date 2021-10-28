package in.conceptarchitect.finance;

public class Bank {
	
	String name; //name of the bank
	double interestRate;
	int lastId=0;
		
	public void creditInterst() {
		//credit interest to all accounts
		for(int i=1;i<=lastId;i++) {
			
			accounts[i].creditInterest(interestRate);
		}
	}
	
	public Bank(String name, double interestRate) {
		super();
		this.name = name;
		this.interestRate = interestRate;
	}
	
	BankAccount [] accounts= new BankAccount[100]; //MAX 100. May not be great for large banks
	
	public int openAccount(String name, String password, double amount) {
		int accountNumber= ++ lastId;
		BankAccount account= new BankAccount(accountNumber, name, password,amount);
		accounts[accountNumber] = account; //store this account in the array.
		return accountNumber;
	}
	
	private BankAccount getAccountByNumber(int accountNumber) {
		// TODO Auto-generated method stub
		if(accountNumber>0 && accountNumber<=lastId)
			return accounts[accountNumber];
		else
			return null;
	}
	
	public boolean deposit(int accountNumber, double amount) {
		
		BankAccount account = getAccountByNumber(accountNumber);
		
		return account.deposit(amount);
	}

	
	
	
	

}
