//Avery Wang
//Senior Seminar

import java.io.*;
import java.util.*; 

public class Student {
	//instance variables for the student object
	private String studentUsername;
	private int choice1;
	private int choice2;
	private int choice3;
	private int choice4;
	private int choice5;
	
	//constructor 
	public Student (String name, int c1, int c2, int c3, int c4, int c5) {
		this.studentUsername = name;
		this.choice1 = c1;
		this.choice2 = c2;
		this.choice3 = c3;
		this.choice4 = c4;
		this.choice5 = c5;
	}
	 
	//getters
	public String getStudentUsername() {
		return studentUsername;
	}
	
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
	
	//keeping track of student info
	public static ArrayList<Student> loadStudents(String filename) throws IOException {
		ArrayList<Student> students = new ArrayList<>();
		
		File myFile = new File(filename);
		Scanner scan = new Scanner(myFile);
		
		//skips header row if it is in the data
		if (scan.hasNextLine()) {
			scan.nextLine();
		}

		//read through each student file and build a student object for each row
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] data = line.split(",");
			String name = data[3];
			int c1 = Integer.parseInt(data[11]);
			int c2 = Integer.parseInt(data[12]);
			int c3 = Integer.parseInt(data[13]);
			int c4 = Integer.parseInt(data[14]);
			int c5 = Integer.parseInt(data[15]);
			
			students.add(new Student(name, c1, c2, c3, c4, c5));
		}
		
		scan.close();
		return students;

	public static void main(String[] args) throws IOException {
		//calls the loadStudents method and inputs senior seminar data
		ArrayList<Student> students = loadStudents("Senior Seminar Data.csv");
		
		for(int i = 0; i < students.size(); i++) {
			
	}
	

