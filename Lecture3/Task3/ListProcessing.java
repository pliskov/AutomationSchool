import java.util.*;
import java.util.stream.Collectors;

public class ListProcessing {
    public static void main(String[] args) {

        List<Person> studentList = new ArrayList<>();

        studentList.add(new Person(1, "Cristiano", "Ronaldo", 33));
        studentList.add(new Person(2, "Roberto", "Carlos", 40));
        studentList.add(new Person(3, "Vladimir", "Vysotsky", 23));
        studentList.add(new Person(4, "Paolo", "Maldini", 19));
        studentList.add(new Person(5, "Andrei", "Ivanov", 22));
        studentList.add(new Person(6, "Sergey", "Petrov", 24));
        studentList.add(new Person(7, "Alexey", "Poluyan", 25));
        studentList.add(new Person(8, "Yuriy", "Gagarin", 28));
        studentList.add(new Person(9, "Olga", "Buzova", 33));
        studentList.add(new Person(10, "Merylin", "Monro", 24));

        studentList = ListProcessing.sortByAge(studentList);
        getCurrentList(studentList);

        System.out.println("\n" + getAverageAge(studentList));

        studentList = ListProcessing.filterByFirstCharacterInSurname(studentList);
        System.out.println();
        getCurrentList(studentList);
    }

    public static void getCurrentList(List<Person> list){
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getSurname());
        }
    }

    public static List sortByAge(List<Person> list){
        Comparator<Person> byAge = Comparator.comparingInt(Person::getAge);
        list = list.stream().sorted(byAge).collect(Collectors.toList());
        return list;
    }

    public static List filterByFirstCharacterInSurname(List<Person> list){
        list = list.stream().filter(i -> i.getSurname().charAt(0) == 'P').collect(Collectors.toList());
        return list;
    }

    public static double getAverageAge(List<Person> list){
        double avgAge = list.stream().mapToInt(Person::getAge).average().getAsDouble();
        return avgAge;
    }
}