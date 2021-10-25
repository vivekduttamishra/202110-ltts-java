class Permutation {
    
    static int calculate(int n,int r){
        int fn= Factorial.calculate(n);
        int fn_r=Factorial.calculate(n-r);

        return fn/fn_r;
    }

}

class Factorial {
    static int calculate(int n){
        int fn=1;

        while(n>1)
            fn*=n--;

        return fn;
    }
}
