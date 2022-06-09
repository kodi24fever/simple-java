package q_7;

import java.util.*;

class Food {
    protected String name;
    public Food(String name){this.name = name;}
    // Getter
    public String getName(){
        return this.name;
    }

    public String toString(){
        return "Food name is " + name;
    }
}

class Appetizer extends Food{
    private ArrayList<MainCourse> courseList;

    public ArrayList<MainCourse> getCourseList(){
        return courseList;
    }

    public Appetizer(String name,  MainCourse[] courseList){
        super(name);
        this.courseList = new ArrayList<MainCourse>();
        for(MainCourse mainCourse: courseList){
            this.courseList.add(mainCourse);
        }

//        another for loop
//        for(int i = 0; i < courseList.length; i++){
//            this.courseList.add(courseList[i]);
//        }
    }
    @Override
    public String toString(){
        return "Appetizer " + super.toString();
    }

}

class MainCourse extends Food{
    private Appetizer[] appetizerList;

    public Appetizer[] getArray(){
        return this.appetizerList;
    }

    public MainCourse(String name, Appetizer[] appetizerList){
        super(name);
        this.appetizerList = appetizerList;
//        for(int i = 0; i < appetizer.length; i++){
//            this.appetizerList[i] = appetizer[i];
//        }
    }

}

class Test {
    public static void main(String[] args){

        Food f = new Food("Brownie");

        System.out.println(f);


    }
}