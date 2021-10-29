package testapp13.exceptions;

import java.util.Scanner;

public class FortuneMachine {

	Scanner scanner=new Scanner(System.in);
	
	public void printFortune() {
		try {
			System.out.print("Your Lucky Number?");
			String value=scanner.nextLine();
			FortuneTeller fortuneTeller=new FortuneTeller();
			String luck=fortuneTeller.predict(value);
			System.out.println("Your Luck: "+luck);
			
		}
		catch(NegativeLuckException ex) {
			System.out.println("Prediction: Your luck will remain negative for "+(-1*ex.getValue())+" months");
		}
		
		catch(LuckException ex) {
			
			System.out.println("Prediction: "+ex.getMessage());
			
		} 
	}
	
	
	public void printFortuneV1() {
		try {
			System.out.print("Your Lucky Number?");
			String value=scanner.nextLine();
			FortuneTeller fortuneTeller=new FortuneTeller();
			String luck=fortuneTeller.predict(value);
			System.out.println("Your Luck: "+luck);
			
		} catch(LuckException ex) {
			
			System.out.println("Prediction: "+ex.getMessage());
			
		} 
	}
	
	
	public void printFortuneV0() {
		try {
			System.out.print("Your Lucky Number?");
			String value=scanner.nextLine();
			FortuneTeller fortuneTeller=new FortuneTeller();
			String luck=fortuneTeller.predict(value);
			System.out.println("Your Luck: "+luck);
		} catch(NoLuckException ex) {
			
			System.out.println("Prediction: "+ex.getMessage());
			
		} catch(NegativeLuckException ex) {
			
			System.out.println("Prediction: "+ex.getMessage());
		}
	}
	
	
}
