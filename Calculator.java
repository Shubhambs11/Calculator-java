public class Calculator {

    public static void main(String[] args) {

        double num1 = 15;
        double num2 = 5;
        char operator = '+';

        double result;

        if (operator == '+') {
            result = num1 + num2;
        } 
        else if (operator == '-') {
            result = num1 - num2;
        } 
        else if (operator == '*') {
            result = num1 * num2;
        } 
        else if (operator == '/') {
            result = num1 / num2;
        } 
        else {
            System.out.println("Invalid operator");
            return;
        }

        System.out.println("Result = " + result);
    }
}
