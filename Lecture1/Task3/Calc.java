import java.util.Scanner;

public class Calc {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        System.out.println("Enter your expression");
        String Expression = scanner.next();
        while (!Expression.equals("quit")){

            double result = 0;
            for(int i = 0; i < Expression.length(); i++){
                switch (Expression.charAt(i)){
                    case '+':
                        result = Double.parseDouble(Expression.substring(0, i)) +
                                Double.parseDouble(Expression.substring(i + 1, Expression.length()));
                        break;
                    case '-':
                        result = Double.parseDouble(Expression.substring(0, i)) -
                                Double.parseDouble(Expression.substring(i + 1, Expression.length()));
                        break;
                    case '*':
                        result = Double.parseDouble(Expression.substring(0, i)) *
                                Double.parseDouble(Expression.substring(i + 1, Expression.length()));
                        break;
                    case '/':
                        result = Double.parseDouble(Expression.substring(0, i)) /
                                Double.parseDouble(Expression.substring(i + 1, Expression.length()));
                        break;
                }
            }

            if(result != 0) System.out.println("Result: " + result);
            System.out.println("\nEnter your expression");
            Expression = scanner.next();
        }
    }
}