package example;

public class Main{
    public static int counter= 0;
    public static void main_v0(String[] args){
        System.out.println("Hi");
        main_v0(null);
    }
    //outcome = Hi\nHi\nHi\nHi\nHi\nHi\nHi\nHi\n...
    public static void main_v1(String[] args){
        if(counter == 10)
            return;
        System.out.println("Hi");
        counter++;
        main_v1(null);
    }
    public static void printMultipleTimesIteratively(String message,
                                                     int repetition){
        for(int i = 0; i < repetition;i++)
            System.out.println(message);
    }
    public static void printMultipleTimesRecursively(String message,
                                                     int repetition){
        if(repetition == 0)//base case...
            return;
        //recursive step
        System.out.println(message);
        printMultipleTimesRecursively(message, repetition - 1);
    }
    public static double powerRec(double b, int exp){
        if (exp < 0)//base case #1
            return 0;
        if (exp == 0)//base case #2
            return 1;
        return b * powerRec(b, exp - 1);

    }
    public static double power(double b, int exp){
        if(exp < 0)
            return 0;
        double product = 1;
        for(int i = 0; i < exp;i++)
            product *= b;
        return product;
    }
    public static int countZeros(int[][] squareSpace, int length){
        if(length == 1){//base case #1
            if(squareSpace[0][0] == 0)
                return 1;
            else
                return 0;
        }
        if(length < 1)
            return 0;
        int[][]topLeft = new int[length/2][length/2];
        int[][]topRight = new int[length/2][length/2];
        int[][]bottomLeft = new int[length/2][length/2];
        int[][]bottomRight = new int[length/2][length/2];
        for(int i = 0;i < length;i++)
            for(int j = 0; j < length;j++)
                if(i < length/2 && j < length/2)
                    topLeft[i][j] = squareSpace[i][j];
                else if (i < length/2 && j >= length/2)
                    topRight[i][j-length/2] = squareSpace[i][j];
                else if (i >= length/2 && j < length/2)
                    bottomLeft[i-length/2][j] = squareSpace[i][j];
                else
                    bottomRight[i-length/2][j-length/2] = squareSpace[i][j];
        int topLeftSolution = countZeros(topLeft, length/2);
        int topRightSolution = countZeros(topRight, length/2);
        int bottomLeftSolution = countZeros(bottomLeft, length/2);
        int bottomRightSolution = countZeros(bottomRight, length/2);
        return topLeftSolution + topRightSolution + bottomLeftSolution + bottomRightSolution;
    }
    public  static void printNbaseB(int n, int b){
        if (n < b)
            System.out.print(n);
        else{
            printNbaseB(n/b, b);
            System.out.print(n%b);
        }
    }
    public static void main(String[] args){
        //printMultipleTimesIteratively("hello world!", 5);
        //printMultipleTimesRecursively("hello world!", 5);
        //System.out.println(powerRec(2,5));

        int[][] space = new int[][]
                {{0,2,3,4},
                        {5,0,7,8},
                        {9,10,0,12},
                        {0,14,0,16}};
        System.out.println(countZeros(space, 4));

        printNbaseB(100,2);
    }
}