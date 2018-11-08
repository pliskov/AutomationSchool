import java.util.Scanner;

public class GuessWho {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String hiddenPerson = "Виталий Плиско";
        char hidden[] = new char[hiddenPerson.length()];
        for (int i = 0; i < hidden.length; i++) {
            hidden[i] = hiddenPerson.charAt(i);
        }

        char template[] = new char[hiddenPerson.length()];
        for (int i = 0; i < template.length; i++){
            if(hidden[i] == ' '){
                template[i] = ' ';
            }
            else template[i] = '*';
        }

        int counter;
        do {
            counter = 0;
            System.out.print("Enter a letter or try to guess Name and Last Name: ");
            String who = scanner.nextLine();
            char person[] = new char[who.length()];
            for (int i = 0; i < person.length; i++) {
                person[i] = who.charAt(i);
            }

            if(person.length == 1){
                int counterLetters = 0;
                for(int i = 0; i < hidden.length; i++){
                    if(hidden[i] == person[0]){
                        template[i] = hidden[i];
                        counterLetters++;
                    }
                }
                if(counterLetters > 0)
                    System.out.println("Wow! You guessed " + counterLetters +" letter(s)");
                else System.out.println("Unfortunately, there isn't this letter");
            }
            else if (hiddenPerson.equals(who)) {
                counter = 0;
                break;
            }
            else System.out.println("Try again");;

            for(int i = 0; i < template.length; i++) {
                if(template[i] == '*') counter++;
                System.out.print(template[i]);
            }
            System.out.println();

        } while(counter != 0);
        if(counter == 0) System.out.println("Congratulations! You guessed the word!");
    }
}