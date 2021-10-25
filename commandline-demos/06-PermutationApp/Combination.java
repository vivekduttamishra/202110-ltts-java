class Combination {
    
    static int calculate(int n,int r){
        Factorial f=new Factorial();
        int fn= f.calculate(n);
        int fn_r=f.calculate(n-r);
        int fr=f.calculate(r);
        return fn/fn_r/fr;
    }

}

