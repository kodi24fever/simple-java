package question_2;

public class Test {
    public static void main(String[] args) {
        A a = new B();
        a.m1(new A());

        B b = new B();
        b.m2(new B());
    }
}
