/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

public class Grade {
    private int score;
    private String letterGrade;

    // Score setter
    public void setScore(int newScore){ this.score = newScore;}

    // Score Getter
    public int getScore() {
        return score;
    }

    public String getLetterGrade() {
        if(score >= 90){
            letterGrade = "A";
        }
        else if(score >= 86){
            letterGrade = "-A";
        }
        else if(score >= 80){
            letterGrade = "B";
        }
        else letterGrade = "F";

        return letterGrade;
    }

    //Constructor
    public Grade(int score) {
        this.score = score;
    }
}
