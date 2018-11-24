import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CompareListImplementations {
    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        Random random = new Random();
        for (int i = 1; i <= 10000000; i++) {
            int number = random.nextInt();
            arrayList.add(number);
        }
        for (int i = 1; i <= 10000000; i++) {
            int number = random.nextInt();
            linkedList.add(number);
        }

        long arrayAddStartTime = System.nanoTime();
        for (int i = 1; i <= 1000; i++) {
            int number = random.nextInt();
            arrayList.add(number);
        }
        long arrayAddEndTime = System.nanoTime();
        System.out.println("Add 1000 elements took " + (arrayAddEndTime - arrayAddStartTime) +
                " nanoseconds for ArrayList");

        long linkedAddStartTime = System.nanoTime();
        for (int i = 1; i <= 1000; i++) {
            int number = random.nextInt();
            linkedList.add(number);
        }
        long linkedAddEndTime = System.nanoTime();
        System.out.println("Add 1000 elements took " + (linkedAddEndTime - linkedAddStartTime) +
                " nanoseconds for LinkedList");

        System.out.println();

        long arrayRemoveStartTime = System.nanoTime();
        for (int i = 1; i <= 1000; i++) {
            arrayList.remove(i);
        }
        long arrayRemoveEndTime = System.nanoTime();
        System.out.println("Remove 1000 elements took " + (arrayRemoveEndTime - arrayRemoveStartTime) +
                " nanoseconds for ArrayList");

        long linkedRemoveStartTime = System.nanoTime();
        for (int i = 1; i <= 1000; i++) {
            linkedList.remove(i);
        }
        long linkedRemoveEndTime = System.nanoTime();
        System.out.println("Remove 1000 elements took " + (linkedRemoveEndTime - linkedRemoveStartTime) +
                " nanoseconds for LinkedList");

        System.out.println();

        long arraySearchStartTime = System.nanoTime();
        for (int i = 1; i <= 1000; i++) {
            arrayList.get(i);
        }
        long arraySearchEndTime = System.nanoTime();
        System.out.println("Find 1000 elements took " + (arraySearchEndTime - arraySearchStartTime) +
                " nanoseconds for ArrayList");

        long linkedSearchStartTime = System.nanoTime();
        for (int i = 1; i <= 1000; i++) {
            linkedList.get(i);
        }
        long linkedSearchEndTime = System.nanoTime();
        System.out.println("Find 1000 elements took " + (linkedSearchEndTime - linkedSearchStartTime) +
                " nanoseconds for LinkedList");
    }
}