package q_6;

class A {
    void m1(Object obj) {
        System.out.println("A's method ");
    }
}

class B extends A {
    void m1(Object obj){
        super.m1(null);
        System.out.println("B's first method ");
    }

    void m1(Object obj, String message){
        System.out.println("B's second method: " + message);
    }
}

class Test {
    public static void main(String[] args){
        A a = new B();
        a.m1(new A());

        B b = new B();
        b.m1(new B(), "greetings");
    }
}
