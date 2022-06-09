package question_4;


import java.util.*;

class Student implements Comparable {

    String firstName;

    String lastName;

    Comparable gpa;

    Comparable id;

    public String toString() {

        return "Student Name is " + firstName + " " + lastName + " with id " + id.toString() + " and GPA " + gpa.toString();

    }

    public int compareTo(Object aStudent) {

        //override compareTo here . . .

        //returns zero if it's equal to the input parameter
        //returns a negative number if it's less than the input parameter
        //returns a positive number otherwise


    }

}

class Main {

    static Student[] list = getList();

    static Student[] getList() {
        // unknown implementation . . .
        return list;
    }

    public static void main(String[] args) {

        Arrays.sort(list);

        for (Student s : list)

            System.out.println(s);

    }

}
