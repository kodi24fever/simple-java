package main;

import util.*;
import util.ArithmeticException;

import java.util.*;

public class PatternFinder {
    private static String randomStringGenerator(int length) {// generates a string made of randomly generated lowercase letters.
		Random random = new Random(System.nanoTime());
		char[] array = new char[length];
		for (int i = 0; i < length; i++)
			array[i] = (char) ('a' + random.nextInt(26));
		return new String(array);
    }

	// I. Singleton String Miner
    private static void singletonMiner(String mine, int length) throws SingletonException{
		for (int start = 0; start < mine.length() - length; start++) {
			int i;
			for (i = start + 1; i < start + length; i++) {
				if (mine.charAt(i) != mine.charAt(i - 1))
					break;
			}
			if (i == start + length)
				throw new SingletonException(mine.substring(start, start + length), start);
		}
    }

	// II. Arithmetic Miner or Alphabetic Order Miner
	private static void arithmeticMiner(String mine, int length) throws ArithmeticException{
		for (int start = 0; start < mine.length() - length; start++) {
			int i;
			for (i = start + 1; i < start + length; i++) {
				if (mine.charAt(i) - mine.charAt(i - 1) != 1)
					break;
			}
			if (i == start + length)
				throw new ArithmeticException(mine.substring(start, start + length), start);
		}
	}

	// III. Arithmetic of Order -1 or Miner or Alphabetic Reverse Order Miner
	private static void arithmeticReverseMiner(String mine, int length) throws ArithmeticReverseException{
		for (int start = 0; start < mine.length() - length; start++) {
			int i;
			for (i = start + 1; i < start + length; i++) {
				if (mine.charAt(i) - mine.charAt(i - 1) != -1)
					break;
			}
			if (i == start + length)
				throw new ArithmeticReverseException(mine.substring(start, start + length), start);
		}
	}

	// IV. Balanced Tripartite Miner
	private static void balancedTripartiteMiner(String mine, int length) throws BalancedTripartiteException {
		for (int start = 0; start < mine.length() - length; start++) {

			if (length % 3 != 0)
				break;
			else {
				int i;
				for (i = start + 1; i < start + length; i++) {
					if (mine.charAt(i - 1) != mine.charAt((i - 1) + length / 3))
						break;
				}
				if (i == start + length)
					throw new BalancedTripartiteException(mine.substring(start, start + length), start);
			}
		}
	}

	// V. Balanced Bipartite Miner
	private static void balancedBipartiteMiner(String mine, int length) throws BalancedBipartiteException{
		for (int start = 0; start < mine.length() - length; start++) {
			if(length  % 2 != 0)
				break;
			else{
				int i;
				for (i = start + 1; i < start + length; i++) {
					if (mine.charAt(i - 1) != mine.charAt((i - 1) + length/2))
						break;
				}
				if (i == start + length)
					throw new BalancedBipartiteException(mine.substring(start, start + length), start);
			}
		}
	}

	// VI. Palindrome Miner
	private static void palindromeMiner(String mine, int length) throws PalindromeException{

		for (int start = 1; start < mine.length() - length; start++) {
			int i;
			int j;

			for (i = start - 1, j = start + 1; j >= 0 &&  i < start + length; i++, j--) {
				if (mine.charAt(j) != mine.charAt(i))
					break;
			}
			if (i == start + length -1)
				throw new PalindromeException(mine.substring(j + 1, i ), j + 1);
		}

	}

    public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);
	//Step 1: handling input...
	System.out.println("Enter the length of random string: ");
	//int patternMaxLength = 10;//you need to update this part so that the value is given by the user via keyboard!
	int randomStringLength = keyboard.nextInt(); // Total Length of String to create

	System.out.println("Enter the maximum length of special characters: ");
	int patternMaxLength = keyboard.nextInt(); // Total Length of the parent it will search

	while (true) {
	    try {
			if (randomStringLength < 100000 || randomStringLength > 1000000000)
				throw new NumberFormatException();
	    } catch (NumberFormatException e) {
			System.out.println("Length of random string must be between 100 thousand and 1 billion. Try again!");
			randomStringLength = keyboard.nextInt();
			continue;
	    }
		try {
			if(patternMaxLength < 3 || patternMaxLength > 15)
				throw new NumberFormatException();
		} catch (NumberFormatException e){
			System.out.println("Pattern must be greater than 5 and less than 15. Try again!");
			patternMaxLength = keyboard.nextInt();
			continue;
		}
	    break;
	}

	//Step 2: generating random string...
	String randomString = randomStringGenerator(randomStringLength);

	//Step 3: finding the interesting patterns
    	try {
    	    for (int length = patternMaxLength; length > 0; length--) {
				singletonMiner(randomString, length);
				arithmeticMiner(randomString,length);
				arithmeticReverseMiner(randomString,length);
				balancedTripartiteMiner(randomString, length);
				balancedBipartiteMiner(randomString,length);
				palindromeMiner(randomString,length);
			}
    	} catch (Exception exp) {
    	    System.out.println(exp.getMessage());
    	}
    }
}

