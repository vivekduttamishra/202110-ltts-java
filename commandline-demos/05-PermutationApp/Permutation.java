class Permutation {
    
    static int calculate(int n,int r){
        int fn= Factorial.calculate(n);
        int fn_r=Factorial.calculate(n-r);

        return fn/fn_r;
    }

}

