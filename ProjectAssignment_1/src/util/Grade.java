/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

public class Grade {
    private int score;
    private String letterGrade;
    public int getScore() {
        return score;
    }
    public String getLetterGrade() {
        if(score >= 90){
            letterGrade = "A";
        }
        else if(score >= 85){
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