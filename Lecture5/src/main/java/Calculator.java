import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        String expression;
        do {
            expression = getExpression();
            System.out.println("Result: " + calculateExpression(expression));
        } while (!expression.equals("quit"));
    }

    private static String getExpression() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your expression");
        return scanner.next();
    }

    public static double calculateExpression(String expression){
        double result = 0;
        for (int i = 0; i < expression.length(); i++) {
            switch (expression.charAt(i)) {
                case '+':
                    result = Double.parseDouble(expression.substring(0, i)) +
                            Double.parseDouble(expression.substring(i + 1));
                    break;
                case '-':
                    result = Double.parseDouble(expression.substring(0, i)) -
                            Double.parseDouble(expression.substring(i + 1));
                    break;
                case '*':
                    result = Double.parseDouble(expression.substring(0, i)) *
                            Double.parseDouble(expression.substring(i + 1));
                    break;
                case '/':
                    result = Double.parseDouble(expression.substring(0, i)) /
                            Double.parseDouble(expression.substring(i + 1));
                    break;
            }
        }
        return result;
    }
}