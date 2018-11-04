import java.util.*;

public class Marathon {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James",
                "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
        int[] times  = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };

        Map<Integer, String> hashMap = new HashMap<>();
        for(int i = 0; i < names.length; i++){
            hashMap.put(times[i], names[i]);
        }

        Arrays.sort(times);

        for(int i = 0; i < times.length; i++){
            System.out.println(hashMap.get(times[i]) + ": " + times[i]);
        }

        System.out.println("\n2nd place: " + hashMap.get(times[1]) + " - " + times[1]);
        System.out.println("Marathon winner: " + hashMap.get(times[0]) + " - " + times[0]);

        System.out.print("\nYou can find person result by place. Enter place number: ");
        int place = scanner.nextInt();

        if (place > 0 & place <= times.length) {
            System.out.println("Place " + place + ": " + hashMap.get(times[place - 1]) + " - " + times[place - 1]);
        } else System.out.println("There are only 16 results");
    }
}