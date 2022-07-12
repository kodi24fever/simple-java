package q_2;

public class Main {
    public static int binarySearch (Comparable[] array, Comparable target){//returns the index of array cell that contains target or -1 if not found
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = (int) (low / 2.0 + high / 2.0);
            int comp = target.compareTo(array[mid]);
            if (comp == 0){
                int lowerIndex = mid - 1;
                while(array[mid] != array[lowerIndex]){
                    return lowerIndex + 1;
                }
                lowerIndex--;
            }
            if (comp > 0)   low = mid + 1;
            else    high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args){
        Comparable [] array = new Comparable[] {1,2,2,2,2,2,2,2,2,2,5};

        binarySearch(array, 2);

        System.out.println(binarySearch(array, 2));
        System.out.println(array[binarySearch(array, 2)]);

    }
}
