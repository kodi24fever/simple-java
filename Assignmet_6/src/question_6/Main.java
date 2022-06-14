package question_6;

public class Main {
}


class A {
    void m1(String x){
        System.out.println("One");
    }
    protected void m1(String x, String y){
        System.out.println("Two");
    }
    public static void main(String[] args){
        A a = new A();
        a.m1("ABC");
        a.m1("PQR", "XYZ");
    }
}
