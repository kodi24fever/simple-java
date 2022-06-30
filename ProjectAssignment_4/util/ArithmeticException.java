package util;

public class ArithmeticException extends Exception{ //eg: "abc", "mnopq"
    private String singletonString;
    private int occurrenceIndex;
    @Override
    public String getMessage() {
        return singletonString + " is an arithmetic string of order 1 that is found at index " + occurrenceIndex + "!";
    }
    public ArithmeticException(String singletonString, int index) {
        this.singletonString = singletonString;
        occurrenceIndex = index;
    }
}