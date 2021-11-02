package in.conceptarchitect.finance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.finance.exceptions.InsufficientBalanceException;
import in.conceptarchitect.finance.exceptions.InvalidAccountException;

public class BankInternalImplementationTests {
	Bank bank;
	double interestRate=12;
	String correctPassword="password";
	int a1,a2;
	
	//user defined assertions
	public void assertBalanceEquals(int accountNumber, double balance) {
		assertEquals(balance, bank.getAccountBalance(accountNumber,correctPassword),0.01);
	}
	
	public void assertBalanceUnchanged(int accountNumber) {
		assertBalanceEquals(accountNumber, amount);
	}
	
	public void assertTransactionFailed(boolean result,int account) {
		assertFalse(result);
		assertBalanceUnchanged(account);
	}
	
	public void assertTransactionSuccess(boolean result, int account,double balance) {
		
		assertTrue(result);
		assertBalanceEquals(account, balance);
	}
	
	
	double amount=10000;
	int totalAccounts;
	
	@Before
	public void setup() {
		//ARRANGE
		bank=new Bank("ICICI",interestRate);
		a1=bank.openAccount("a1",correctPassword,amount);
		a2=bank.openAccount("a2",correctPassword,amount);
		totalAccounts=bank.getAccountCount();
	}
	
	@Test
	public void getAccountByNumber_returnsValidAccountForValidAccountNumber() {
		var account=bank.getAccountByNumber(a1);		
		assertNotNull(account);
		
	}
	
	@Test(expected=InvalidAccountException.class)
	public void getAccountByNumber_returnsNullForInvalidAccountNumber() {
		var account=bank.getAccountByNumber(-1);
		
	}
	
	@Test(expected=InvalidAccountException.class)
	public void closeAccount_removesClosedAccount() {
		
		bank.closeAccount(a1, correctPassword);		
		bank.getAccountByNumber(a1);
	}

	@Test(expected=InsufficientBalanceException.class)
	public void closeAccount_failsForAccountWithNegativeBalance() {
		//Arrange
		var account=bank.getAccountByNumber(a1);
		account.balance=-1; //because I am in the same package I can do this logic
		bank.closeAccount(a1, correctPassword);
		
	}
	
	
	@Test
	public void accountNumbersAreAlwaysUnique() {
		
		//Arrange
		bank.closeAccount(a1, correctPassword);
		
		int newAccount= bank.openAccount("new", correctPassword, amount);
		
		
		var a2Account= bank.getAccountByNumber(a2);
		
		
		
		assertEquals("a2", a2Account.getName());
		
		assertNotEquals(a2, newAccount);
		
	}
	
	
	
}
