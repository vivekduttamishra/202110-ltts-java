package in.conceptarchitect.financeapp;

import in.conceptarchitect.finance.BankAccount;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//testInterestRate();
		
		String correctPassword="pass";
		double amount=20000;
		BankAccount account=new BankAccount(1, "Vivek",correctPassword, amount, 12);
		
		testDeposit("deposit should fail for negative amount", account,-1,false);
		testDeposit("deposit should succeed for positive amount", account,10000, true);
		
		testWithdraw("withdraw should fail for negative amount", account,-1, correctPassword,false);
		testWithdraw("withdraw should fail for wrong password", account, 1, "wrong-pass", false);
		testWithdraw("withdraw should fail for access amount", account, amount+1, correctPassword,false);
		testWithdraw("withdraw should succeed for right amount and password", account, amount, correctPassword,true);
		
		
		
	}
	
	static void testWithdraw(String test,BankAccount account,double amount,String password, boolean expectedResult) {
		
		boolean actualResult= account.withdraw(amount,password);
		
		if(actualResult==expectedResult) {
			System.out.println("PASSED:\t"+test);
		} else {
			System.out.printf("Failed:\t%s\n\texpected:%s\tgot:%s\n", test, expectedResult,actualResult);
		}
	}
	
	static void testDeposit(String test,BankAccount account,double amount, boolean expectedResult) {
		
		boolean actualResult= account.deposit(amount);
		
		if(actualResult==expectedResult) {
			System.out.println("PASSED:\t"+test);
		} else {
			System.out.printf("Failed:\t%s\n\texpected:%s\tgot:%s\n", test, expectedResult,actualResult);
		}
	}
	
	
	
	
	
	

	private static void testInterestRate() {
		String password="p@ss";
		
		BankAccount a1=new BankAccount(222, "Vivek",password, 50000, 12);			
		//testAccount(a1, password);				
		
		
		BankAccount a2=new BankAccount(222,"Sanjay",password,100000,14);
		//testAccount(a2,password);
		
		
		System.out.println("Before change");
		System.out.println("a1.interestRate: " + a1.getInterestRate());		
		System.out.println("a2.interestRate: "+a2.getInterestRate());
		
		
		a1.setInterestRate(15);
		System.out.println("\nAfter change");
		System.out.println("a1.interestRate: " + a1.getInterestRate());		
		System.out.println("a2.interestRate: "+a2.getInterestRate());
	}

	private static void testAccount(BankAccount account, String password) {
		account.show();		
		account.deposit(20000);
		account.deposit(-1.0);

		account.show();
		
		account.creditInterest();
		account.show();
		
		
		if(account.withdraw(50000,"wrongp@ss")) {
			System.out.println("withdraw success");	
		} else {
			System.out.println("withdraw failed");
		}
		
		if(account.withdraw(-1, password)) {
			System.out.println("withdraw success");	
		} else {
			System.out.println("withdraw failed");		
		}
		
		
		if(account.withdraw(100000, password)){
			System.out.println("withdraw success");	
		} else {
			System.out.println("withdraw failed");		
		}		

		if(account.withdraw(50000, password)){
			System.out.println("withdraw success");	
		} else {
			System.out.println("withdraw failed");		
		}
	}

	
	
	
	
	
}
