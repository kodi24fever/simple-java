import java.util.*;



public class Main {
    public static void specialRemove(LinkedList<String> list){
        ListIterator<String> it = list.listIterator();
        /*while(it.hasNext()){
            it.next();
            it.remove();
            if(it.hasNext())it.next();else break;
            if(it.hasNext())it.next();else break;
            if(it.hasNext())it.next();else break;
            if(it.hasNext())it.next();else break;
        }*/
        for(int i = 0; it.hasNext();i++){
            it.next();
            if(i % 5 == 0)
                it.remove();
        }
    }
    private static String[] helper(String word){
        if(word.length() == 1)
            return new String[]{word};
        int factorial = 1;
        for(int i = 2; i <= word.length();factorial *= i++);
        String[] permutations = new String[factorial];
        int current = 0;
        for(int i = 0; i < word.length();i++){
            String shorter = word.substring(0, i) + word.substring(i+1); //all but the ith character
            for(String shorterPermutation: helper(shorter))
                permutations[current++] = (word.charAt(i) + shorterPermutation);
        }
        return permutations;
    }
    public static void printAllPermutations(String vals){
        if(vals.isEmpty())
            return;
        String[] out = helper(vals);
        Arrays.sort(out);
        String prev = null;
        for(String word: out)
            if(prev == null || !word.equals(prev))
                System.out.println(prev = word);
    }
    private static int binarySerachFindIndex(Comparable[] array, Comparable target) {
        int low = 0, high = array.length - 1;
        while(low <= high) {
            int mid = (int)(low/2.0+high/2.0);
            int comp = target.compareTo(array[mid]);
            if(comp == 0) return mid;
            if(comp > 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    private static boolean binarySerach(Comparable[] array, Comparable target) {
        int low = 0, high = array.length - 1;
        while(low <= high) {
            int mid = (int)(low/2.0+high/2.0);
            int comp = target.compareTo(array[mid]);
            if(comp == 0) return true;
            if(comp > 0) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
    private static void firstOcurrence(Comparable[] array, Comparable target) {
        int low = 0, high = array.length - 1;
        while(low <= high) {
            int mid = (int)(low/2.0+high/2.0);
            int comp = target.compareTo(array[mid]);
            if(comp == 0){
                if(mid == 0 || array[mid-1].compareTo(array[mid]) != 0){
                    System.out.print("[" + mid + ", ");
                    return;
                }else
                    high = mid - 1;
            }
            else if(comp > 0) low = mid + 1;
            else high = mid - 1;
        }
        System.out.print("[" + -1 + ", ");
    }
    private static void lastOcurrence(Comparable[] array, Comparable target) {
        int low = 0, high = array.length - 1;
        while(low <= high) {
            int mid = (int)(low/2.0+high/2.0);
            int comp = target.compareTo(array[mid]);
            if(comp == 0){
                if(mid == array.length-1 || array[mid+1].compareTo(array[mid]) != 0){
                    System.out.println(mid + "]");
                    return;
                }else
                    low = mid + 1;
            }
            else if(comp > 0) low = mid + 1;
            else high = mid - 1;
        }
        System.out.println(-1 + "]");
    }
    public static void findRange(Comparable[] list, Comparable target) {
        firstOcurrence(list, target);
        lastOcurrence(list, target);
    }
    public static void main(String args[]) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        for(String str: list)
            System.out.print(str + "\t");
        System.out.println();
        specialRemove(list);
        for(String str: list)
            System.out.print(str + "\t");
        System.out.println();
        Comparable[] sorted = new Comparable[]{1,2,5,5,5,5,5,5,8,9,10,11,12};
        findRange(sorted, 4);
        printAllPermutations("abcd");
    }
}
