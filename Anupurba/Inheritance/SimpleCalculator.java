public class SimpleCalculator {
    public int add(int a, int b){
        return a + b;
    }
    public double add(double a, double b){
        return a + b;
    }
    public int subtract(int a, int b){
        return  a-b;
    }
    public double subtract(double a, double b){
        return a-b;
    }
    public int multipliaction(int a, int b){
        return a*b;
    }
    public double multipliaction(double a, double b){
        return a*b;
    }
    public int division(int a, int b){
        if(b == 0){
            return -1;
        }
        return a/b;
    }
    public double division(double a, double b){
        return a/b;
    }
}
