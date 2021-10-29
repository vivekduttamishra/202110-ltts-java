package testapp13.exceptions;

public class NegativeLuckException extends LuckException {
	
	int value;
	
	
	public int getValue() {
		return value;
	}

	public NegativeLuckException(String message,int value) {
		super(message);
		this.value=value;
	}
	
	public NegativeLuckException(int value) {		
		this("You have too much Negativity around you!",value);

	}
}
