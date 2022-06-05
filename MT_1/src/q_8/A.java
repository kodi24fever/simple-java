package q_8;

class A{
    public int x;

    public A (int x){
        this.x = x;
    }

    public String toString(){
        return "Int is: " + x;
    }
}

class B extends A{
    public B(int x){
        super(x);
    }
}

class C extends B{
    public C (int x){
        super(x);
    }
}

class Test{
    public static void main(String[] args){
        A c = new A(9);

        System.out.println(c);
    }
}
