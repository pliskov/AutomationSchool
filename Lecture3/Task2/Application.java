import java.util.*;

public class Application {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student(1, "Cristiano", "Ronaldo", 33));
        studentList.add(new Student(2, "Roberto", "Carlos", 40));
        studentList.add(new Student(3, "Vladimir", "Vysotsky", 23));
        studentList.add(new Student(4, "Paolo", "Maldini", 19));
        studentList.add(new Student(5, "Andrei", "Ivanov", 22));
        studentList.add(new Student(6, "Sergey", "Petrov", 24));
        studentList.add(new Student(7, "Alexey", "Poluyan", 25));
        studentList.add(new Student(8, "Yuriy", "Gagarin", 28));
        studentList.add(new Student(9, "Olga", "Buzova", 33));
        studentList.add(new Student(10, "Merylin", "Monro", 24));

        Collections.sort(studentList, new AgeComparator());
        System.out.println("List of students sorted by age:");
        for(int i = 0; i < studentList.size(); i++){
            System.out.println(studentList.get(i).getId() + " " + studentList.get(i).getName() + " " +
                    studentList.get(i).getSurname() + " " + studentList.get(i).getAge());
        }

        double sumAge = 0;
        for(int i = 0; i < studentList.size(); i++){
            sumAge += studentList.get(i).getAge();
        }
        System.out.println("\nAverage students age is " + (sumAge / studentList.size()));

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter first letter of surname: ");
        char searchByLetter = scanner.next().charAt(0);

        List<Student> studentListSortedBySurname = new ArrayList<>();
        for(int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getSurname().charAt(0) == searchByLetter){
                studentListSortedBySurname.add(studentList.get(i));
            }
        }

        if(studentListSortedBySurname.size() == 0){
            System.out.println("There aren't students with Surname started from " + searchByLetter);
        }
        else {
            System.out.println("List of students with Surname started from " + searchByLetter + ":");
            for(int i = 0; i < studentListSortedBySurname.size(); i++){
                System.out.println(studentListSortedBySurname.get(i).getId() + " " +
                        studentListSortedBySurname.get(i).getName() + " " +
                        studentListSortedBySurname.get(i).getSurname() + " " +
                        studentListSortedBySurname.get(i).getAge());
            }
        }
    }
}

class AgeComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2){
        return o1.getAge() - o2.getAge();
    }
}