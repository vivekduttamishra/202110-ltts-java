package in.conceptarchitect.app02.permutation;

import in.conceptarchitect.maths.Permutation;

public class App {
	
	public static void main(String []args) {
		int n=5;
		int r=3;
		
		Permutation permutation=new Permutation();
		
		int result=permutation.calculate(n, r);
		
		System.out.printf("%d P %d = %d",n,r,result);
	}

}
