package question_3;
import java.util.*;

/**
 * Given the following program and class Date, pick the correct implementation
 * of the compareTo method fromComparable interface for class Date so that the
 * program can successfully sort and print the dates stored in array days.
 * Your implementation should work for any valid list of dates in the array.
 */

// Comparable interface can be implemented in any class
class Date implements Comparable{
    int month, day, year;
    public int compareTo(Object another){
        if(another instanceof Date){
            Date d = (Date)another; return year != d.year? year - d.year: month != d.month? month - d.month: day - d.day;

            //(INCORRECT) Date d = (Date)another; return 366*(year-d.y) + 31*(month-d.month)+(day-d.day);

            //Date d = (Date)another; return 372*(year-d.y) + 31*(month-d.month)+(day-d.day);
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
