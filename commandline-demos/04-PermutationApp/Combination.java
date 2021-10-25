class Combination {
    
    static int calculate(int n,int r){
        int fn= Factorial.calculate(n);
        int fn_r=Factorial.calculate(n-r);
        int fr=Factorial.calculate(r);
        return fn/fn_r/fr;
    }

}

