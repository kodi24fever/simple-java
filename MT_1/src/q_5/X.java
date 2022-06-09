package q_5;

class X {
    public X(int i){
        System.out.println("one");
    }
}
class Y extends X {
    public Y(){
        // calling super fix the problem
        super(0);
        System.out.println("two");
    }
}

class MainClass{
    public static void main(String[] args){
        new Y();
    }
}
