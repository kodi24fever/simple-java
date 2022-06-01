package question_4;

class First{
    int i;
    public First(){
        i = 10;
    }
    public First(int value){
        i *= 3*value;
    }
    public String toString(){

        return i + "";

    }
}

class Second extends First{
    int i = 10;
    public Second(int i){
        super(i);
        i += 3;
    }

}

class MainClass{
    public static void main(String[] args){
        First f = new Second(5);
        System.out.print(f.toString() + ", " + f.i);
    }
}
