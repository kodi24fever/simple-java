package Asignment_3_q5;

import Asignment_3_q5.Person;

public class Teacher extends Person {
    private double salary;

    public Teacher(String firstName, String lastName, double weight, double salary){
        super(firstName, lastName, weight);
        this.salary = salary;
    }
}
