package Asignment_3_q5;

public class Person {
    private String firstName;
    private String lastName;
    private double weight; //in pounds

    public Person(String firstname, String lastName, double weight) {
        this.firstName = firstname;
        this.lastName = lastName;
        this.weight = weight;
    }

    // Get Methods
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public double getWeight(){return weight;}

    public void showUsers() {
        System.out.println(firstName + " " + lastName);
    }
    public String toString() {
        return firstName + " " + lastName;
    }
}
