package in.conceptarchitect.maths;

public class Factorial {

	public int calculate(int x) {
		if(x<=2) 
			return 1;
		else
			return x* calculate(x-1);
	}
}
