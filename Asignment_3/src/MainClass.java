public class MainClass{
    public static void main(String[] args){
        First f = new Second(5);
        System.out.print(f.toString() + ", " + f.i);
    }
}