package test.finance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.finance.BankAccount;
import in.conceptarchitect.finance.exceptions.InsufficientBalanceException;
import in.conceptarchitect.finance.exceptions.InvalidCredentialsException;
import in.conceptarchitect.finance.exceptions.InvalidDenominationException;

public class BankAccountTests {
	
	

	String password="password";
	double amount=20000;
	
	BankAccount account;
	
	@Before
	public void init() {
		account =new BankAccount(1, "Vivek", password, amount);
		System.out.println("@Before called");
	}

	@Test(expected = InvalidDenominationException.class)
	public void withdrawShouldFailForNegativeAmount() {
	
		account.withdraw(-1, password);		
		
	}
	

	@Test(expected = InvalidCredentialsException.class)
	public void withdrawShouldFailForInvalidPassword() {
		
		account.withdraw(1, "wrong-password");
		
		
	}
	
	
	@Test public void withdrawShouldFailForExcessAmount() {
		try {
			account.withdraw(amount+1, password);
			fail("InsufficientBalanceException was expected but not thrown");
			
		}catch(InsufficientBalanceException ex) {
			assertEquals(1, ex.getDeficit(),0);
		}
		
	}
	
	@Test public void withdrawShouldPassForValidAmountAndPassword() {
		String password="password";
		double amount=20000;
		BankAccount account=new BankAccount(1,"Vivek",password, amount);
		account.withdraw(amount, password);
		assertEquals(0, account.getBalance(),0.001);
	}
	
	
	
}
