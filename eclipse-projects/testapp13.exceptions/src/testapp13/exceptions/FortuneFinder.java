package testapp13.exceptions;

public class FortuneFinder {
	
	public  String getForutune(int luckyNumber) {
		
		String [] lucks= {"You Have No Luck","Great Day Ahead","You will succeed","Don't Fly too high" };

		if(luckyNumber<0)
			throw new NegativeLuckException(luckyNumber);
		else if (luckyNumber==0)
			throw new NoLuckException("You just ran out of your luck!!!");
			
		return lucks[luckyNumber];
		
		
	}

}
