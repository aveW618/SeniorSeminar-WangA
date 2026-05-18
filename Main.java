/**
 * @author Avery Wang
 * @since February 2026
 * Program: Senior Seminar
 * Purpose: Runs the senior seminar scheduling program by asking for schedule rules,
 * loading student and session data, creating the schedule, and printing the results. 
 * This is where all the methods made in other classes (such as the Schedule class) are going to be called
 * to result in the final program.
 */

import java.io.*;
import java.util.*; 

public class Main {
	//initializes the files to two separate CSV files
	private static final String studentFile = "StudentPreferences.csv";
	private static final String sessionFile = "SessionInstructors.csv";
	
	/*
	 * this main method runs the scheduling program
	 * it asks for schedule rules (from user input), loads the data, creates the schedule,
	 * and prints the results/questions in a readable, understandable and user-friendly way
	 */
	public static void main(String[] args) throws IOException {
		//reads in user input
		Scanner input =  new Scanner(System.in);
		
		//the following displays questions to obain user input about the capacity for various scheduling aspects
			//including time slots, rooms, room capacity, and max session runs
		System.out.print("How many time slots? ");
		int timeSlots = input.nextInt();
		
		System.out.println();
		System.out.print("How many rooms per time slot? ");
		int rooms = input.nextInt();
		
		System.out.println();
		System.out.print("What is the room capacity? ");
		int roomCapacity = input.nextInt();
		
		System.out.println();
		System.out.println("What is the maximum number of times one session can run? ");
		int maxRunsPerSession = input.nextInt();
		
		
		//calls the load students/sessions/instructors methods to actually store info from the student and session files
		ArrayList<Student> students = Student.loadStudents(studentFile);
		ArrayList<Session> sessions = Session.loadSessions(sessionFile);
		ArrayList<Instructor> instructors = Instructor.loadInstructors(sessions);
		
		//creates a schedule object that stores in user-inputted info read from the Main class
			//it also stores in the info gained from Main class calls to methods from other classes
		Schedule schedule = new Schedule(timeSlots, rooms, roomCapacity, maxRunsPerSession, students, sessions, instructors);
	
		//calls other methods from the Schedule class on the schedule object
			//this helps display all the user info, etc. 
		schedule.createSchedule();

		System.out.println();
		schedule.printSummary();

		System.out.println();
		schedule.printSessionGrid();

		System.out.println();
		schedule.printSpeakerSchedule();

		System.out.println();
		schedule.printStudentLists();
		
		//ends the scanner function for the class
		input.close();
	}
}
		
