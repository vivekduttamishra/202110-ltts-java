package in.conceptarchitect.financeapp;

import java.util.Scanner;

import in.conceptarchitect.finance.BankAccount;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount a1=new BankAccount();
		
		Scanner scanner=new Scanner(System.in);
		System.out.print("enter account number?");
		int accountNumber=scanner.nextInt();
		System.out.print("enter balance?");
		double amount=scanner.nextDouble();
		
		
		a1.createAccount(accountNumber, amount);
		
		
		
		a1.show();
		
		scanner.close();

	}

}
