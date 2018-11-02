public class Student {
    String name;
    String lastName;
    int group;

    Student(String name, String lastName, int group){
        this.name = name;
        this.lastName = lastName;
        this.group = group;
    }

    public String getName(){
        return name;
    }

    public String getLastName(){
        return lastName;
    }

    public int getGroup(){
        return group;
    }

}