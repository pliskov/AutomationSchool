import java.util.Scanner;

public class Helper {
    public static char getFindRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter first letter of surname: ");
        return scanner.next().charAt(0);
    }
}