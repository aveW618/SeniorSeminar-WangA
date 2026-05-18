/**
 * @author Avery Wang
 * @since February 2026
 * Program: Senior Seminar
 * Purpose: Helps create one student in the scheduling program by storing the student's
 * ID, name, email, and five ranked session choices. This class also loads in student information 
 * from the CSV file so that schedule can assign each student to seminar sessions.
 */

import java.io.*;
import java.util.*; 

public class Student {
	//values of where the student info is located in the csv files
	private static final int emailColumn = 1;
	private static final int nameColumn = 2;
	private static final int firstChoiceColumn = 3;
	private static final int choiceCount = 5;
	
	//declaring variables needed for student info
	private int id;
	private String name;
	private String email;
	//stores choice info
	private int[] choices;
	
	/*
	 * a constructor that creates one student object
	 * each student has an ID, name, email, and an array of ranked session choices
	 */
	public Student (int id, String name, String email, int[] choices) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.choices = choices;
	}
	
	/* a method that loads all students from the student preference CSV file
	 * it reads in the student name, email, and their five ranked session choices
	 */
	public static ArrayList<Student> loadStudents(String filename) throws IOException {
		//creates an array list to store student objects
		ArrayList<Student> students = new ArrayList<Student>();
		
		//loads in data
		File myFile = new File(filename);
		Scanner scan = new Scanner(myFile);
		
		//skips header row if it is in the data
		if (scan.hasNextLine()) {
			scan.nextLine();
		}

		//read through each student file and build a student object for each row
		while (scan.hasNextLine()) {
			
			//reads through the data, splits it by commas, and also stores the names for the student objects
			String line = scan.nextLine();
			String[] data = line.split(",");
			
			String email = "";
			String name = "";
			
			if (emailColumn < data.length) {
				email = data[emailColumn];
			}
			
			if (nameColumn < data.length) {
				name = data[nameColumn];
			}
		
			int[] choices = new int[choiceCount];
			boolean hasChoice = false;
				
			//stores the students' five choices from the csv file, blank choices are 0
			for (int i = 0; i < choiceCount; i++) {
				int column = firstChoiceColumn + i;
					
				if (column < data.length) {
					String value = data[column];
					
					//if the value is not empty, then store it into the choices array
					if (!value.equals("")) {
						choices[i] = Integer.parseInt(value);
						
						//keeps track of if there are choices ranked by the students
						if (choices[i] > 0) {
							hasChoice = true;
						}
					}
				}
			}
		
			//add the student if have a name, email, or at least one ranked choice in the CSV file
			if (!name.equals("") || !email.equals("") || hasChoice) {
				int studentId = students.size() + 1;
				
				students.add(new Student(studentId, name, email, choices));
			}
		}
		
		scan.close();
		return students;
	} 
	
	/*
	 * this method will return the rank of a session for this student
	 * it will return 1 for the first choice, 2 for the second choice, and on and on
	 * it returns 0  if the session was not one chosen by the students
	 */
	 
	 public int getChoiceRank (int sessionId) {
		for (int i = 0; i < choices.length; i++) {
			//if the choice matches the session ID being looked for, and 1 to give the choice its proper ranking
			if (choices[i] == sessionId) {
				return i + 1;
			}
		}
		//returns 0 if the session is not found in the student's choices
		return 0;
	}
	
	/*
	 * a method that returns how many choices each student has
	 */
	public static int getChoiceCount() {
		return choiceCount;
	}
	
	//getters for all the student info
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int[] getChoices() {
		return choices;
	}
	
	public String toString() {
		return (id + " " + "(" + email + ")" + " " + name + ": " + choices[0] + ", " + choices[1] + ", " + choices[2] + ", " + choices[3] + ", " + choices[4]);
	}
}
