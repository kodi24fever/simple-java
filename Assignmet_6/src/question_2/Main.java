package question_2;

public class Main {
}


class A {
    void m1(Object obj){
        System.out.println("One");
    }
}
class B extends A {
    void m1(Object obj){
        super.m1(null);
        System.out.println("Two");
    }
    void m2(Object obj){
        System.out.println("Three");
        this.m1(null);
    }
}
