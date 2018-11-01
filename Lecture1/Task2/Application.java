public class Application {
    public static void main(String[] args) {

        int count = 10; // Number of students

        Student[] students = new Student[count];
        students[0] = new Student("Name1", "LastName1", 1);
        students[1] = new Student("Name2", "LastName2", 1);
        students[2] = new Student("Name3", "LastName3", 1);
        students[3] = new Student("Name4", "LastName4", 1);
        students[4] = new Student("Name5", "LastName5", 1);
        students[5] = new Student("Name6", "LastName6", 2);
        students[6] = new Student("Name7", "LastName7", 2);
        students[7] = new Student("Name8", "LastName8", 2);
        students[8] = new Student("Name9", "LastName9", 2);
        students[9] = new Student("Name10", "LastName10",2);

        Ticket[] tickets = new Ticket[10];
        tickets[0] = new Ticket(1, "Question1");
        tickets[1] = new Ticket(2, "Question2");
        tickets[2] = new Ticket(3, "Question3");
        tickets[3] = new Ticket(4, "Question4");
        tickets[4] = new Ticket(5, "Question5");
        tickets[5] = new Ticket(6, "Question6");
        tickets[6] = new Ticket(7, "Question7");
        tickets[7] = new Ticket(8, "Question8");
        tickets[8] = new Ticket(9, "Question9");
        tickets[9] = new Ticket(10, "Question10");

        double sumMarksGroup1 = 0;
        double sumMarksGroup2 = 0;

        for(int i = 0; i < count; i++){
            int ticket = (int) (Math.random() * tickets.length);
            int result = 1 + (int) (Math.random() * 5);
            System.out.println(students[i].getName() + " " + students[i].getLastName() + " took ticket #" +
                    tickets[ticket].getTicketId() + " and got mark " + result);
            if(students[i].getGroup() == 1){
                sumMarksGroup1 += result;
            }
            else if(students[i].getGroup() == 2){
                sumMarksGroup2 += result;
            }
        }

        System.out.println("Group #1 average result: " + sumMarksGroup1 / (students.length / 2));
        System.out.println("Group #2 average result: " + sumMarksGroup2 / (students.length / 2));
    }
}