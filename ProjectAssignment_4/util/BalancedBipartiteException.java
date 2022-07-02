package util;

public class BalancedBipartiteException extends Exception{
    private String singletonString;
    private int occurrenceIndex;
    @Override
    public String getMessage() {
        return singletonString + " is a balanced bipartite string that is found at index " + occurrenceIndex + "!";
    }
    public BalancedBipartiteException(String singletonString, int index) {
        this.singletonString = singletonString;
        occurrenceIndex = index;
    }
}
