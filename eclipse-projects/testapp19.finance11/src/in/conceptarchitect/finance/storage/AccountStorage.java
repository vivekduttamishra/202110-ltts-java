package in.conceptarchitect.finance.storage;

import in.conceptarchitect.finance.BankAccount;

//@FunctionalInterface
public interface AccountStorage {

	int addAccount(BankAccount account);

	BankAccount getAccountByNumber(int accountNumber);

	void removeAccount(BankAccount account);

	int size();

	BankAccount[] getAllAccounts();
	
	default void process(Processor<BankAccount> accountProcessor) {
		//if initialization fails do not process
		if(!accountProcessor.initialize())
			return;
		
		for(var account : this.getAllAccounts())
			accountProcessor.process(account);
		
		accountProcessor.close();		
	}
	
	public static AccountStorage getDefaultStorage() {
		return new HashmapAccountStorage();
	}

}