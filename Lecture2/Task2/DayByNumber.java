import java.util.Scanner;

public class DayByNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a day number (1-7): ");
        int number = scanner.nextInt();

        switch (number){
            case 1:
                System.out.println("It's Monday");
            break;
            case 2:
                System.out.println("It's Tuesday");
            break;
            case 3:
                System.out.println("It's Wednesday");
            break;
            case 4:
                System.out.println("It's Thursday");
            break;
            case 5:
                System.out.println("It's Friday");
            break;
            case 6:
                System.out.println("It's Saturday");
            break;
            case 7:
                System.out.println("It's Sunday");
            break;
            default:
                System.out.println("There isn't a day for this number");
            break;
        }
    }
}
