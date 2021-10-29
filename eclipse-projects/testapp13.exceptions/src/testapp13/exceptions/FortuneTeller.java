package testapp13.exceptions;

public class FortuneTeller {

	public String predict(String value) {
		
		try {
			int luckyNumber= Integer.parseInt(value);
			var finder=new FortuneFinder();
			return finder.getForutune(luckyNumber);
		} catch(ArrayIndexOutOfBoundsException ex) {
			
			return "Your luck is foggy!";
		} catch(NumberFormatException ex) {
			return "You should to learn Maths!";
		}
		
	}
	
}
