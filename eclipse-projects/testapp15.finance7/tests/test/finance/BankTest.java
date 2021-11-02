package test.finance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import in.conceptarchitect.finance.Bank;
import in.conceptarchitect.finance.exceptions.InsufficientBalanceException;
import in.conceptarchitect.finance.exceptions.InvalidAccountException;
import in.conceptarchitect.finance.exceptions.InvalidCredentialsException;

public class BankTest {
	
	//Object under Test
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
	
	public void assertTransactionFailed(int account) {
		
		assertBalanceUnchanged(account);
	}
	
	public void assertTransactionSuccess(int account,double balance) {
		assertBalanceEquals(account, balance);
	}
	
	
	double amount=10000;
	int totalAccounts;
	
	@Before
	public void setup() {
		//ARRANGE
		bank=new Bank("ICICI",interestRate);
		a1=bank.openAccount("one",correctPassword,amount);
		a2=bank.openAccount("two",correctPassword,amount);
		totalAccounts=bank.getAccountCount();
	}
	

	//
	@Test
	public void openAccountShouldGenerateUniqueAccountNumberInAscendingSequence() {
		int newAccount=bank.openAccount("new", correctPassword, amount);
		
		assertEquals(totalAccounts+1, newAccount);
	}
	
	//@Ignore 
	@Test
	public void openAccountShouldIncreaseTheAccountCount() {
		
		int newAccount=bank.openAccount("new", correctPassword, amount);
		int accountCount=bank.getAccountCount();
		assertEquals(totalAccounts+1, accountCount);
		
	}
	
	
	//@Ignore
	@Test
	public void deposit_shouldWorkForValidAmountAndAccountNumber() {
		
//		boolean result = bank.deposit(a1, 1);
		
//		assertEquals(true,result);
//		assertEquals(amount+1, bank.getAccountBalance(a1),0.01);
		
		bank.deposit(a1, 1);
		assertTransactionSuccess(a1, amount+1);
		
	}
	
	@Ignore
	@Test
	public void deposit_shouldFailForInvalidAmount() {
		
		//bank.deposit(a1, -1)
	//	assertTransactionFailed a1);
	}
	
	@Ignore
	@Test
	public void deposit_shouldFailForInvalidAccountNumber() {
		bank.deposit(1000, 1);
				
	}
	
	@Ignore
	@Test
	public void getBalance_failsForInvalidAccountNumber() {
		//assertEquals(Double.NaN, bank.getAccountBalance(-1),0.0001);
	}
	

	@Ignore
	@Test
	public void creditInterest_shouldGiveInterestToAllAccounts() {
		
		//ACT 
		bank.creditInterst();
		
		double expectedNewBalance= amount+amount*interestRate/1200;
		
	//	assertEquals(expectedNewBalance,bank.getAccountBalance(a1), 0.01);
	//	assertEquals(expectedNewBalance,bank.getAccountBalance(a2),0.01);
		
	}
	
	
	
	@Ignore
	@Test
	public void withdraw_shouldFailForInvalidAmount() {
		
	}
	
	@Ignore
	@Test
	public void withdraw_shouldFailForInvalidAccountNumber() {
		
	}
	
	@Ignore
	@Test
	public void withdraw_shouldFailForInvalidPassword() {
		
	}
	
	@Ignore
	@Test
	public void withdraw_shouldFailForExcessAmount() {
		
	}
	
	//@Ignore
	@Test
	public void transfer_shouldWorkWithValidDetails() {
		
		bank.transfer(a1,1,correctPassword,a2);
		
		assertTransactionSuccess( a1, amount-1);		
		assertTransactionSuccess( a2, amount+1);
	}
	
	
	@Ignore
	@Test
	public void transfer_shouldFailForInvalidAmount() {
		bank.transfer(a1, -1, correctPassword, a2);
		assertTransactionFailed( a1);
		assertTransactionFailed( a2);
	}
	
	@Ignore
	@Test
	public void transfer_shouldFailForInvalidSourceAccountNumber() {
		bank.transfer(-1, 1, correctPassword, a2);
		
		assertTransactionFailed( a2);
	}
	
	@Ignore
	@Test
	public void transfer_shouldFailForInvalidTargetAccountNumber() {
		bank.transfer(a1, 1, correctPassword, -1);
		assertTransactionFailed( a1);
	}
	
	
	@Ignore
	@Test
	public void transfer_shouldFailForInvalidPassword() {
		bank.transfer(a1, 1, "invalid-password", a2);
		assertTransactionFailed( a1);
		assertTransactionFailed( a2);
		
	}
	
	@Ignore
	@Test
	public void transfer_shouldFailForExcessAmount() {
		bank.transfer(a1, amount+1, correctPassword, a2);
		assertTransactionFailed(a1);
		assertTransactionFailed(a2);
	}
	

	
	//@Ignore
	@Test(expected = InvalidAccountException.class)
	public void closeAccount_shouldWorkdInHappyPath() {
		bank.closeAccount(a1,correctPassword);		
		//assertTrue(result);
		//assertEquals(Double.NaN, bank.getAccountBalance(a1),0,0);
		bank.getAccountBalance(a1, correctPassword);
	}
	
	//@Ignore
	@Test
	public void closeAccount_shouldDecreaseTheAccountCount() {
		bank.closeAccount(a1,correctPassword);		
		assertEquals(totalAccounts-1, bank.getAccountCount());
	}
	
	
	//@Ignore
	@Test(expected = InvalidCredentialsException.class)
	public void closeAccount_shouldFailForInvalidPassword() {
		 bank.closeAccount(a1, "incorrect-password");
		
	}
	
	//@Ignore
	@Test(expected=InsufficientBalanceException.class)
	public void closeAccount_shouldFailForNegativeBalance() {
		assumeTrue(bank.getAccountBalance(a1,correctPassword)<0);
		
		bank.closeAccount(a1, correctPassword);
		
	}
	
	//@Ignore
	@Test(expected=InvalidAccountException.class)
	public void closeAccount_shouldFailForInvalidAccountNumber() {
		bank.closeAccount(-1, correctPassword);
		
	}
	
	//@Ignore
	@Test(expected=InvalidAccountException.class)
	public void closeAccount_cantCloseSameAccountTwice() {
	
		bank.closeAccount(a1, correctPassword);
		assumeTrue(true); //it is closed the first time
		
		//proceed if the first result is true		
		bank.closeAccount(a1, correctPassword);
		
	}
	
	

	
}
