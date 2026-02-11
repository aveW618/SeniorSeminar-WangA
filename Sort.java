//Avery Wang
//Senior Seminar

import java.io.*;
import java.util.*; 
		
public class StudentChoices {
	//5 choices of each student
	//store student choies as indices//
	private int choice1;
	private int choice2;
	private int choice3;
	private int choice4;
	private int choice5;
	
	private String instructor;
	private String username;
	private String time;
	
	//constructor 
	public StudentChoices (int c1, int c2, int c3, int c4, int c5) {
		choice1 = c1;
		choice2 = c2;
		choice3 = c3;
		choice4 = c4;
		choice5 = c5;
	}
	
	//getters
	public int getChoice1() {
		return choice1;
	}
	public int getChoice2() {
		return choice2;
	}
	public int getChoice3() {
		return choice3;
	}
	public int getChoice4() {
		return choice4;
	}
	public int getChoice5() {
		return choice5;
	}
	
	//toString method
	public String toString() {
		return (choice1 + " " + choice2 + " " + choice3 + " " + choice4 + " " + choice5);
	}
}

public class LoadingAndAssignments {
	public static void main(String[] args) {
		
		//need to change magic number
		Student[] studentArray = new Student[100];
		//stored CSV file with student data
		String filename = "Senior Seminar Data.csv";
		
		//number of available sessions
		int numSessions = 16;
		//counter for loops
		int count = 0;
		//number of choices per student
		int numChoices = 5;
		
		public void readFile() throws IOException {
			File myFile = new File(filename);
			Scanner scan = new Scanner(myFile);
			int i = 0;
		
			if (scan.hasNextLine()) {
				scan.nextLine();
			}

			//read through each student file
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] data = line.split(",");
				String time = data[0];
				String username = data[2];
				int choice1 = data[10];
				int choice2 = data[11];
				int choice3 = data[12];
				int choice4 = data[13];
				int choice5 = data[14];
				studentArrray[i] = new Student(time, username, choice1, choice2, choice3, choice4, choice5);
				i++;
			}
			scan.close();
		}
		
			ArrayList<String> student = new ArrayList<String>();
			int totalStudent = 0;
			for (int i = 0; i <= data.length; i++) {
				totalStudent = totalStudent + student(i);
			}
		//load the data into a 2D array
		int [][] choiceArray = loadChoiceArray(filename, numChoices);
		
		//1D array to count how many times each session appears
		int[] tallies = tallySessions(choiceArray, numSessions);
	}
	
	//separate place to keep track of instructors, their sessions, classrooms, timeslots
	public static void main(String[] args) {
		//classrooms
		int numClassrooms = 5;
		//timslots
		int [] timeSlots = {830, 930, 1030, 1230, 130};
		int sessions;
		
		//need to change magic number
		Instructor[] instructorArray = new Instructor[100]
		String filename = "Senior Seminar Data.csv";
		
		//counter for loops
		int count = 0;
		
		public void readFile() throws IOException {
			File myFile = new File(filename);
			Scanner scan = new Scanner(myFile);
			int i = 0;
		
			if (scan.hasNextLine()) {
				scan.nextLine();
			}

			//read through each student file
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] data = line.split(",");
				int sessionID = data[17];
				String presenter = data[18];
				instructorArray[i] = new Instructor(sessionID, presenter);
				i++;
			}
			scan.close();
		}
		
			ArrayList<String> instructor = new ArrayList<String>();
			String instructorInfo = " ";
			for (int i = 0; i <= data.length; i++) {
				instructorInfo = instructorInfo + instructor(i);
			}
		}
	
		
}
	
	
		
		
		
