package util;

public class PalindromeException extends Exception{
    private String singletonString;
    private int occurrenceIndex;
    @Override
    public String getMessage() {
        return singletonString + " is a palindrome string that is found at index " + occurrenceIndex + "!";
    }
    public PalindromeException(String singletonString, int index) {
        this.singletonString = singletonString;
        occurrenceIndex = index;
    }
}