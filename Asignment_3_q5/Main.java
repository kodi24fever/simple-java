package Asignment_3_q5;

import java.util.*;

public class Main {
    public static void main(String[] args){
        ArrayList<Person> list = new ArrayList<Person>();

        Person person = new Person("Alex", "B", 160);
        Student student = new Student("John", "C", 170, 123456, 3.53, "FIU");
        TA ta = new TA("M", "N", 170, 1234567, 3.67, "FIU","COP337", "U02");
        Teacher teacher = new Teacher("Ann", "D", 170, 60000.0);

        list.add(person);
        list.add(student);
        list.add(ta);
        list.add(teacher);

        System.out.println(list);
    }
}
