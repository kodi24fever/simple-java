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

    public ArrayList getCourseList(){
        return courseList;
    }

    public Appetizer(String name,  MainCourse[] mainCourses){
        super(name);
        for(int i = 0; i < mainCourses.length; i++){
            this.courseList.add(mainCourses[i]);
        }
    }

    @Override
    public String toString(){
        return "Appetizer " + super.name;
    }

}

class MainCourse extends Food{
    private Appetizer[] appetizerList;

    public Appetizer[] getArray(){
        return this.appetizerList;
    }

    public MainCourse(String name, Appetizer[] appetizer){
        super(name);
        for(int i = 0; i < appetizer.length; i++){
            this.appetizerList[i] = appetizer[i];
        }

    }

}

class Test {
    public static void main(String[] args){


        Food f = new Food("Brownie");

        System.out.println(f);


    }
}