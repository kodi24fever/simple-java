package question_3;
//Given the following program and class Date, pick the correct implementation of the compareTo method from Comparable interface for class Date so that the program can successfully sort and print the dates stored in array days. Your implementation should work for any valid list of dates in the array.

        import java.util.*;
class Date implements Comparable{
    int month, day, year;
    public int compareTo(Object another){
        if(another instanceof Date){
            /*your code*/
        }
        return 0;
    }
    Date(String rep, char delimiter){
        month = Integer.parseInt(rep.substring(0, rep.indexOf(delimiter)));
        rep = rep.substring(rep.indexOf(delimiter) + 1);
        day = Integer.parseInt(rep.substring(0, rep.indexOf(delimiter)));
        year = Integer.parseInt(rep.substring(rep.indexOf(delimiter) + 1));
    }
    public String toString(){
        return month + "/" + day + "/" + year;
    }
}
class MyClass {
    public static void main(String args[]) {
        Date[] days = new Date[] { new Date ( "2/7/2022" , '/' ) , new Date ( "1 5 2022" , ' ' ) , new Date ( "10,5,2020" , ',' ) };
        Arrays.sort(days);//sorts days from earliest to oldest!
        for (Date d: days)
            System.out.println(d);
    }
}
