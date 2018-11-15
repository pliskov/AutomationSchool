import java.util.List;
import java.util.Scanner;

public class Helper {
    public static void findStudentsByFirstLetterInSurname(List<Student> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter first letter of surname: ");
        char searchByLetter = scanner.next().charAt(0);
        List<Student> studentListSortedBySurname = FactoryStudentsLists.createStudentsList();
        for (Student aStudent : list) {
            if (aStudent.getSurname().charAt(0) == searchByLetter) {
                studentListSortedBySurname.add(aStudent);
            }
        }
        if (studentListSortedBySurname.size() == 0) {
            System.out.println("There aren't students with Surname started from " + searchByLetter);
        } else {
            System.out.println("List of students with Surname started from " + searchByLetter + ":\n" +
                    studentListSortedBySurname);
        }
    }
}