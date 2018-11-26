import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Student> studentList = FactoryStudentsLists.createStudentsList();
        studentList.add(FactoryStudents.createStudent(1, "Cristiano", "Ronaldo", 33));
        studentList.add(FactoryStudents.createStudent(2, "Roberto", "Carlos", 40));
        studentList.add(FactoryStudents.createStudent(3, "Vladimir", "Vysotsky", 23));
        studentList.add(FactoryStudents.createStudent(4, "Paolo", "Maldini", 19));
        studentList.add(FactoryStudents.createStudent(5, "Andrei", "Ivanov", 22));
        studentList.add(FactoryStudents.createStudent(6, "Sergey", "Petrov", 24));
        studentList.add(FactoryStudents.createStudent(7, "Alexey", "Poluyan", 25));
        studentList.add(FactoryStudents.createStudent(8, "Yuriy", "Gagarin", 28));
        studentList.add(FactoryStudents.createStudent(9, "Olga", "Buzova", 33));
        studentList.add(FactoryStudents.createStudent(10, "Merylin", "Monro", 24));

        studentList.sort(Comparator.comparingInt(Student::getAge));
        System.out.println("List of students sorted by age:\n" + studentList);

        System.out.println("\nAverage students age is " + getAvgAge(studentList));

        Helper.findStudentsByFirstLetterInSurname(studentList);
    }

    public static double getAvgAge(List<Student> list) {
        double sumAge = 0;
        for (Student aStudent : list) {
            sumAge += aStudent.getAge();
        }
        return sumAge / list.size();
    }
}