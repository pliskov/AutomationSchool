import java.util.Scanner;

public class Rhombus {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of rhombus side: ");
        int number = scanner.nextInt();
        int length = number*2 - 1;

        char line[] = new char[length];

        for(int i = 0; i <= length - 1; i++){
            line[i] = ' ';
        }
        line[length/2] = '*';

        for(int i = 0; i <= line.length - 1; i++){
            System.out.print(line[i]);
        }
        System.out.println();

        for(int i = 2, j = 1; i <= length/2 + 1; i++, j++){
            int oldPositionAsterisk1 = (length / 2) - (j-1);
            int oldPositionAsterisk2 = (length / 2) + (j-1);
            line[oldPositionAsterisk1] = ' ';
            line[oldPositionAsterisk2] = ' ';

            int newPositionAsterisk1 = (length / 2) - j;
            int newPositionAsterisk2 = (length / 2) + j;
            line[newPositionAsterisk1] = '*';
            line[newPositionAsterisk2] = '*';

            for(int k = 0; k <= line.length - 1; k++){
                System.out.print(line[k]);
            }
            System.out.println();
        }

        for(int i = length/2 + 2, j = length/2; i < length; i++, j--){
            int oldPositionAsterisk1 = (length / 2) - j;
            int oldPositionAsterisk2 = (length / 2) + j;
            line[oldPositionAsterisk1] = ' ';
            line[oldPositionAsterisk2] = ' ';

            int newPositionAsterisk1 = (length / 2) - (j-1);
            int newPositionAsterisk2 = (length / 2) + (j-1);
            line[newPositionAsterisk1] = '*';
            line[newPositionAsterisk2] = '*';

            for(int k = 0; k <= line.length - 1; k++){
                System.out.print(line[k]);
            }
            System.out.println();
        }

        for(int i = 0; i <= length - 1; i++){
            line[i] = ' ';
        }
        line[length/2] = '*';

        for(int i = 0; i <= line.length - 1; i++){
            System.out.print(line[i]);
        }
        System.out.println();
    }
}