/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

import java.util.*;

public class Gradebook {
    private ArrayList<Student> listOfStudents = new ArrayList<>();

	// Get List
	public ArrayList<Student> getListOfStudents(){
		return listOfStudents;
	}

	// Finds min score
	public double findMinScore(){
		ArrayList<Double> scores = new ArrayList<Double>();
		for(Student s: listOfStudents){
			scores.add(s.getGrade().getScore());
		}

		Collections.sort(scores);

		return scores.get(0);
	}

	// Finds max score
	public double findMaxScore(){
		ArrayList<Double> scores = new ArrayList<Double>();
		for(Student s: listOfStudents){
			scores.add(s.getGrade().getScore());
		}

		Collections.sort(scores);

		return scores.get(scores.size()-1);
	}

	// Finds min letter
	public String findMinLetter(){
		ArrayList<String> letters = new ArrayList<String>();
		for(Student s: listOfStudents){
			letters.add(s.getGrade().getLetterGrade());
		}

		Collections.sort(letters);

		return letters.get(letters.size()-1);
	}

	// Finds max letter
	public String findMaxLetter(){
		ArrayList<String> letters = new ArrayList<String>();
		for(Student s: listOfStudents){
			letters.add(s.getGrade().getLetterGrade());
		}

		Collections.sort(letters);

		return letters.get(0);
	}

	//Find letter Grade
	public String findLetterGrade(int pid){
		String letterGrade = "";
		boolean foundLetter = false;

		for(Student s: listOfStudents){
			if(s.getPid() == pid){
				letterGrade = s.getGrade().getLetterGrade();
				foundLetter = true;
			}
		}

		if(foundLetter){
			return "The letter grade of student is: " + letterGrade;
		}else return "Could not found letter grade of student with pid: " + pid;
	}

	//Find name
	public String findName(int pid){
		String firstName = "";
		String lastName = "";
		boolean foundStudent = false;

		for(Student s: listOfStudents){
			if(s.getPid() == pid){
				firstName = s.getFirstName();
				lastName = s.getLastName();
				foundStudent = true;
			}
		}
		if(foundStudent){
			return "The full name of the student is: " + firstName + " " + lastName;
		}else return "Could not found student with pid: " + pid;
	}

	// Change grade
	public String changeGrade(int pid, double newGrade){
		boolean isNewGrade = false;
		double grade = 0.0;


		for(Student s: listOfStudents){
			if(s.getPid() == pid){
				s.getGrade().setScore(newGrade);
				isNewGrade = true;
				grade = s.getGrade().getScore();
			}
		}

		if(isNewGrade){
			return "The new grade is: " + grade;
		}else return "Could not change grade student pid: " + pid + " does not exist!";
	}

	/**
	 * Starts average and media  calculations
	 */

	// Calculate average score
	public double calculateAvg() {
		double sum = 0;
		for(Student s: listOfStudents){
			sum += s.getGrade().getScore();
		}

		return sum/ listOfStudents.size();
	}

	// Calculate average letter
	public String calculateAvgLetter(){
		Grade grade = new Grade(calculateAvg());
		return grade.getLetterGrade();
	}

	// Calculates median score
    public double calculateMedian() {
	int i = 0, n = listOfStudents.size();
	double[] scores = new double[n];
	for(Student s: listOfStudents)
	    scores[i++] = s.getGrade().getScore();
	Arrays.sort(scores);
	if (n % 2 == 0)
	    return (scores[n / 2] + scores[n / 2 - 1]) / 2.0f;
	else
	    return scores[n / 2];
    }
	// Calculate median letter
	public String calculateMedianLetter(){
		Grade grade = new Grade(calculateMedian());
		return grade.getLetterGrade();
	}

    public void printAllStudents() {
	for(Student s: listOfStudents)
	    System.out.printf("%s\t%s\t%d\t%d\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
    }

	// Adds student to arrayList in gradebook
	public void addStudent(Student student){
		listOfStudents.add(student);
	}

	// Constructor
	public Gradebook(){
		/**
		 *  Here I should be able to add students to arrayList using student class
		 */
	}
}
