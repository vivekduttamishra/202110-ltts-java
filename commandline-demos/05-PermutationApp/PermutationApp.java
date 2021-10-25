public class PermutationApp {

    public static void main(String [] args){

        int n=5, r=3;
        
        

        int p=Permutation.calculate(n,r);

        System.out.printf("%d P %d is %d\n", n,r,p);
    }
}
