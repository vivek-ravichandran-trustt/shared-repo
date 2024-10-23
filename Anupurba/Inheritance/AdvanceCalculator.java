

public class AdvanceCalculator extends SimpleCalculator{
    public double  Power(double  base, double  exponent){
        double result = Math.pow(base, exponent);
        return result;
    }
    public double squareRoot(double num){
        double result = Math.sqrt(num);
        return result;
    }
    public long  factorial(int num1){
        long result = 1;
        switch (num1) {
            case 0 -> {
                return 1;
            }
            case 1 -> {
                return 1;
            }
            default -> {
                for(int i = 1 ; i<=num1;i++){
                    result = result * i;
                }
                return result;
            }
        }
    }
    //Natural Logarithm
    public double  logarithm(double num){
        double result = Math.log(num);
        return result;
    }
    //Base 10 Logarithm
    public double logarithmBase10(double num){
        double result = Math.log10(num);
        return result;
    }
    
}
