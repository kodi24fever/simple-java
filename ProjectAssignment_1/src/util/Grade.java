/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

public class Grade {
    private double score;
    private String letterGrade;

    // Score setter
    public void setScore(double newScore){ this.score = newScore;}

    // Score Getter
    public double getScore() {
        return score;
    }

    public String getLetterGrade() {
        if(score >= 90){
            letterGrade = "A";
        }
        else if(score >= 86.67){
            letterGrade = "A-";
        }
        else if(score >= 83.33){
            letterGrade = "B+";
        }
        else if(score >= 80.00){
            letterGrade = "B";
        }
        else if(score >= 76.77){
            letterGrade = "B-";
        }
        else if(score >= 73.33){
            letterGrade = "C+";
        }
        else if(score >= 70.00){
            letterGrade = "C";
        }
        else if(score >= 60.00){
            letterGrade = "D";
        }
        else letterGrade = "F";

        return letterGrade;
    }

    //Constructor
    public Grade(double score) {
        this.score = score;
    }
}
