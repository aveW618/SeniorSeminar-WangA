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
	
	//toString method (so printed students can be read)
	public String toString() {
		return (studentUsername + ": " + choice1 + ", " + choice2 + ", " + choice3 + ", " + choice4 + ", " + choice5);
	}
	
	
	//method to load students
	public static ArrayList<Student> loadStudents(String filename) throws IOException {
		//creates an array list to store student objects
		ArrayList<Student> students = new ArrayList<>();
		
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
			String name = data[3];
			
			//stores the choices from the data, converting everything into ints
			int c1 = Integer.parseInt(data[11]);
			int c2 = Integer.parseInt(data[12]);
			int c3 = Integer.parseInt(data[13]);
			int c4 = Integer.parseInt(data[14]);
			int c5 = Integer.parseInt(data[15]);
			
			//method of array lists to create a new Student object to add to the arraylist students
			students.add(new Student(name, c1, c2, c3, c4, c5));
		}
		
		//ends the scanning of the data
		scan.close();
		
		//returns the arraylist students with all the Student objects in it
		return students;
	}

	//main method to test if the loadStudents method works
	public static void main(String[] args) throws IOException {
		//calls the loadStudents method and inputs senior seminar data
		ArrayList<Student> students = loadStudents("Senior Seminar Data.csv");
		
		//prints out the Student objects to make sure the program runs as intented: load students
		for(int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i));
		}
		
		//prints out the number of students successfully loaded
		System.out.println("Total Students loaded: " + students.size());
			
	}
	
}
	

