package in.conceptarchitect.finance;

import java.util.Scanner;

public class bank_account {
	
	int accountnumber;
	double balance;
	Scanner scanner=new Scanner(System.in);
	
	void create_account() {
		System.out.print("enter account number?");
		
		accountnumber=scanner.nextInt();
		System.out.print("enter balance?");
		balance=scanner.nextDouble();
	}
	
	void show() {
		System.out.println("account number "+accountnumber);
		System.out.println("balance "+balance);;
	}
	
	public static void main(String []args) {
	
		bank_account a1=new bank_account();		
		a1.create_account();
		a1.show();
		
	}
}
