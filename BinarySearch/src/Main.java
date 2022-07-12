import java.lang.reflect.Array;

public class Main {

    public static int regularLinearSearch(int[] array, int target){
        for(int i = 0; i < array.length - 1; i++){
            if(target == array[i])
                return i;
        }
        return -1;
    }

    public static int binarySearch(int[] array, int target){
        int minimum = 0;

        int maximum = array.length - 1;

        while(minimum <= maximum){

            int mid = (minimum + maximum) / 2;

            if(target == array[mid])
                return mid;

            if(target > array[mid])
                minimum = mid + 1;
            else
                maximum = mid -1;
        }
        return -1;
    }

    public static void main(String[] args){

        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        int target = 11;
        binarySearch(numbers, target);

        System.out.println("Found at index " + binarySearch(numbers, target));
    }
}
