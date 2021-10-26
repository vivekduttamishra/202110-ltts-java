package in.conceptarchitect.finance;

import java.util.Scanner;

public class BankAccount {
	
	int accountNumber;
	double balance;
	
	
	public void createAccount(int accountNumber, double amount) {
		
		balance=amount; //this is optional here as there is a single balance in the context
		
		this.accountNumber=accountNumber;
		
	}
	
	public void show() {
		System.out.println("account number "+accountNumber);
		System.out.println("balance "+balance);;
	}
	
	public static void main(String []args) {
	
		
		
	}
	

}
