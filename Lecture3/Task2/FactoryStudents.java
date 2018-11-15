public class FactoryStudents {
    public static Student createStudent(int id, String name, String surname, int age) {
        return new Student(id, name, surname, age);
    }
}