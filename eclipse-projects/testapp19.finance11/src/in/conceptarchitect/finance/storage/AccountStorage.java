package in.conceptarchitect.finance.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
	
	default List<BankAccount> findAll(Predicate<BankAccount> condition){
		
		var result=new ArrayList<BankAccount> ();
		
		this.process(account->{
			
			if(condition.test(account))
				result.add(account);
		});
		
		return result;
	}
	
	
	public static AccountStorage getDefaultStorage() {
		return new HashmapAccountStorage();
	}

}