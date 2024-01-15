public class Far {

    private int factorial;

    private int exponent;

    public Far(){
    }
    public int getFactorial() {
        return factorial;
    }

    public void setFactorial(int n) {
        this.factorial = factor(n);
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int n, int a) {
        this.exponent = exponentiation(n, a);
    }

    private int factor(int n){
        if (n == 1) return 1;
        return n * factor(--n);
    }

    private int exponentiation(int n, int a){
        if (a == 1) return n;
        return n * exponentiation(n, --a);
    }
}

