package util;

public class ArithmeticReverseException extends Exception {
    private String singletonString;
    private int occurrenceIndex;
    @Override
    public String getMessage() {
        return singletonString + " is an arithmetic string of order -1 that is found at index " + occurrenceIndex + "!";
    }
    public ArithmeticReverseException(String singletonString, int index) {
        this.singletonString = singletonString;
        occurrenceIndex = index;
    }
}
