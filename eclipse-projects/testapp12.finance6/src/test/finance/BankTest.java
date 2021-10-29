package test.finance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import in.conceptarchitect.finance.Bank;

public class BankTest {
	
	//Object under Test
	Bank bank;
	double interestRate=12;
	String correctPassword="password";
	int a1,a2;
	
	double amount=10000;
	int totalAccounts;
	
	@Before
	public void setup() {
		//ARRANGE
		bank=new Bank("ICICI",interestRate);
		a1=bank.openAccount("one",correctPassword,amount);
		a2=bank.openAccount("one",correctPassword,amount);
		totalAccounts=bank.getAccountCount();
	}
	

	//@Ignore
	@Test
	public void openAccountShouldGenerateUniqueAccountNumberInAscendingSequence() {
		
		//ACT
		
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
		
		boolean result = bank.deposit(a1, 1);
		
		assertEquals(true,result);
		assertEquals(amount+1, bank.getAccountBalance(a1),0.01);
		
	}
	
	//@Ignore
	@Test
	public void deposit_shouldFailForInvalidAmount() {
		boolean result= bank.deposit(a1, -1);
		assertFalse(result);
		assertEquals(amount, bank.getAccountBalance(a1),0.01);
	}
	
	//@Ignore
	@Test
	public void deposit_shouldFailForInvalidAccountNumber() {
		boolean result=bank.deposit(1000, 1);
		assertFalse(result);		
	}
	
	@Test
	public void getBalance_returnsNaNForInvalidAccountNumber() {
		assertEquals(Double.NaN, bank.getAccountBalance(-1),0.0001);
	}
	

	//@Ignore
	@Test
	public void creditInterest_shouldGiveInterestToAllAccounts() {
		
		//ACT 
		bank.creditInterst();
		
		double expectedNewBalance= amount+amount*interestRate/1200;
		
		assertEquals(expectedNewBalance,bank.getAccountBalance(a1), 0.01);
		assertEquals(expectedNewBalance,bank.getAccountBalance(a2),0.01);
		
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
	
	@Ignore
	@Test
	public void withdraw_shouldWorkWithValidDetails() {
		
	}
	
	
	@Ignore
	@Test
	public void transfer_shouldFailForInvalidAmount() {
		
	}
	
	@Ignore
	@Test
	public void transfer_shouldFailForInvalidSourceAccountNumber() {
		
	}
	
	@Ignore
	@Test
	public void transfer_shouldFailForInvalidTargetAccountNumber() {
		
	}
	
	
	@Ignore
	@Test
	public void transfer_shouldFailForInvalidPassword() {
		
	}
	
	@Ignore
	@Test
	public void transfer_shouldFailForExcessAmount() {
		
	}
	
	@Ignore
	@Test
	public void transfer_shouldWorkWithValidDetails() {
		
	}
	

	
	@Ignore
	@Test
	public void closeAccount_shouldFailForInvalidPassword() {
		
	}
	
	@Ignore
	@Test
	public void closeAccount_shouldFailForNegativeBalance() {
		
	}
	
	@Ignore
	@Test
	public void closeAccount_shouldFailForInvalidAccountNumber() {
		
	}
	
	@Ignore
	@Test
	public void closeAccount_cantCloseSameAccountTwice() {
		
	}
	
	@Ignore
	@Test
	public void closeAccount_shouldWorkdInValidCase() {
		
	}
	
	@Ignore
	@Test
	public void closeAccount_shouldDecreaseTheAccountCount() {
		
	}

	
}
