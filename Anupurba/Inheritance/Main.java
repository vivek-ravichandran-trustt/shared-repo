
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScientificCalculator obj = new ScientificCalculator();
        //System.out.println(obj.add(5, 6));
        Scanner sc = new Scanner(System.in);
        System.out.println("Plesae choose the operation = ");
        //System.out.println("1.Add 2.Sub 3.Mul 4.Div 5.Power 6.Sqrt 7.factorial 8.Log 9.LogBase10 10.Sin 11.Cos 12.tan 13.Modulas 14.Percentage");
        System.out.println("""
                           Please choose the operation:
                           1. Add
                           2. Sub
                           3. Mul
                           4. Div
                           5. Power
                           6. Sqrt
                           7. Factorial
                           8. Log
                           9. LogBase10
                           10. Sin
                           11. Cos
                           12. Tan
                           13. Modulus
                           14. Percentage""");

        String op = sc.nextLine();
        
        double num1,num2 = 0;

        // For operations that require two inputs
        if (op.equals("Add") || op.equals("Sub") || op.equals("Mul") || op.equals("Div") || op.equals("Power") || op.equals("Modulas") || op.equals("Percentage")) {
            System.out.println("Please Enter your first number = ");
            num1 = getInput(sc);
            System.out.println("Please enter your second number =");
            num2 = getInput(sc);
        } 
        // For operations that require one input
        else {
            System.out.println("Please Enter your number = ");
            num1 = getInput(sc);
        }

        //Consume the leftover newline character.
        //sc.nextLine();
        
        switch (op) {
            case "Add":
                double result = obj.add(num1, num2);
                System.out.println("Result is = " + result);
                break;
            case "Sub":
                double result1 = obj.subtract(num1, num2);
                System.out.println("Result is = " + result1);
                break;
            case "Mul":
                double result2 = obj.multipliaction(num1, num2);
                System.out.println("Result is = " + result2);
                break;
            case "Div":
                double result3 = obj.division(num1, num2);
                if(result3 == -1){
                    System.out.println("A number can not be divisible by 0");
                }
                else{
                    System.out.println("Result is = " + result3);
                }
                break;
            case "Power":
                double result4 = obj.Power(num1, num2);
                System.out.println("Result is = " + result4);
                break;
            case "Sqrt":
                double result5 = obj.squareRoot(num1);
                System.out.println("Result is = " + result5);
                break;
            case "Factorial":
            int factInput = (int)num1;
                double result6 = obj.factorial(factInput);
                System.out.println("Result is = " + result6);
                break;
            case "Log":
                double result7 = obj.logarithm(num1);
                System.out.println("Result is = " + result7);
                break;
            case "LogBase10":
                double result8 = obj.logarithmBase10(num1);
                System.out.println("Result is = " + result8);
                break;
            case "Sin":
                double result9 = obj.sin(num1);
                System.out.println("Result is = " + result9);
                break;
            case "Cos":
                double result10 = obj.cos(num1);
                System.out.println("Result is = " + result10);
                break;
            case "tan":
                double result11 = obj.tan(num1);
                System.out.println("Result is = " + result11);
                break;
            case "Modulas":
                int input1 = (int)num1;
                int input2 = (int)num2;
                int result12 = obj.modulus(input1, input2);
                System.out.println("Result is = " + result12);
                break;
            case "Percentage":
                double result13 = obj.percentage(num1, num2);
                if (result13 == -1) {
                    System.out.println("Cannot divide by zero.");
                } else {
                    System.out.println("Result is = " + result13 + "%");
                }
                break;
            default:
                System.out.println("Please Choose the right Operator...!");
        }

    }

    private static double getInput(Scanner sc) {
        String input = sc.next(); 
        try {
            return Integer.parseInt(input);  
        } catch (NumberFormatException e) {
            return Double.parseDouble(input);  
        }
    }
}
