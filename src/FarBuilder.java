public class FarBuilder {
    private final Far far = new Far();
    public FarBuilder factor(int n){
        far.setFactorial(n);
        return this;
    }
    public FarBuilder exponentiation(int n, int a){
        far.setExponent(n, a);
        return this;
    }

    public Far build(){
        return far;
    }

}
