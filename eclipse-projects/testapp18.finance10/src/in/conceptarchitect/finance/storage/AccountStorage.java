package in.conceptarchitect.finance.storage;

import in.conceptarchitect.finance.BankAccount;

public interface AccountStorage {

	int addAccount(BankAccount account);

	BankAccount getAccountByNumber(int accountNumber);

	void removeAccount(BankAccount account);

	int size();

	BankAccount[] getAllAccounts();

}