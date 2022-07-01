package util;

public class BalancedTripartiteException extends Exception{
    private String singletonString;
    private int occurrenceIndex;
    @Override
    public String getMessage() {
        return singletonString + " is a balanced tripartite string that is found at index " + occurrenceIndex + "!";
    }
    public BalancedTripartiteException(String singletonString, int index) {
        this.singletonString = singletonString;
        occurrenceIndex = index;
    }
}
