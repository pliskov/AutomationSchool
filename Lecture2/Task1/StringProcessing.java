import java.util.Scanner;

public class StringProcessing {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String line = scanner.nextLine();

        char sentence[] = new char[line.length()];
        for(int i = 0; i < line.length(); i++){
            sentence[i] = line.charAt(i);
        }

        System.out.print("\n" + "Your sentence in reverse order: ");
        for(int i = line.length() - 1; i >= 0; i--){
            System.out.print(sentence[i]);
        }

        System.out.println("\n\n" + "Your sentence separated by words: ");
        for(int i = 0; i < line.length(); i++){
            if(sentence[i] != ' '){
                System.out.print(sentence[i]);
            }
            else System.out.print("\n");
        }

        System.out.print("\n\n" + "Your sentence separated by '*': ");
        for(int i = 0; i < line.length(); i++){
            if(sentence[i] != ' '){
                System.out.print(sentence[i]);
            }
            else System.out.print("*");
        }

        System.out.println("\n\n" + "Your sentence in UpperCase: " + line.toUpperCase());
        System.out.println("\n" + "Your sentence from 5 to 10 symbol: " + line.substring(4,10));
    }
}