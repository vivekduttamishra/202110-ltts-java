class Permutation {
    
    int calculate(int n,int r){

        Factorial f=new Factorial();

        int fn= f.calculate(n);
        int fn_r=f.calculate(n-r);

        return fn/fn_r;
    }

}

