public class ScientificCalculator extends AdvanceCalculator {
    //Trigonmetry Functions...
    public double sin(double radians){
        double result = Math.sin(radians);
        return result;
    }
    public double cos(double radians){
        double result = Math.cos(radians);
        return result;
    }
    public double tan(double radians){
        double result = Math.tan(radians);
        return result;
    }
    
    public int modulus(int a, int b) {
        return a % b;
    }
    
    public double percentage(double total, double rate) {
        return (total * rate) / 100;
    }
}
