
package testapp13.exceptions;

public class NoLuckException extends LuckException {
	
	public NoLuckException(String message) {
		super(message);
	}
	
	public NoLuckException() {
		super("Your luck just ran out!!!");
	}
}
