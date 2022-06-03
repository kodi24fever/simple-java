package q_4;

public class A {
    protected String s = "Class A";
}

class B extends A{
    protected String s = "Class B";
    public B (){
        System.out.println(super.s);
    }
}
class C extends B{
    protected String s = "Class C";
    public C (){
        System.out.println(super.s);
    }
}

class MainClass{
    public static void main(String[] args){
        C c = new C();
        System.out.println(c.s);
    }
}
