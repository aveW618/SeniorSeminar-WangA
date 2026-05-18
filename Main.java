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
		
		System.out.print("How many time slots? ");
		int timeSlots = input.nextInt();
		
		System.out.println();
		System.out.print("How many rooms per time slot? ");
		int rooms = input.nextInt();
		
		System.out.println();
		System.out.print("What is the room capacity? ");
		int roomCapacity = intput.nextInt();
		
		System.out.println();
		System.out.println("What is the maximum number of times one session can run? ");
		int maxRunsPerSession = input.nextInt();
		

		
	public static int findLargestSessionID(ArrayList <Session> sessions) {
		int largest = 0;
		
		for (int i = 0; i < sessions.size(); i++) {	
			if (sessions.get(i) > largest) {
				largest = sessions.get(i);
			}
		}
		
		return largest;
	}
		
	public static int[] countSessionRequests(ArrayList<Student> students, int largestSessionID) {
		int[] counts = new int[largestSessionID + 1];
			
		for (Student student : students) {
			int [] choices = students.ge(ChoicesArray();
				
			for (int i = 0; i < choices.length; i++) {
				int sid = choices[i];
					
				if (sid > 0 && sid < counts.length) {
					counts[sid]++;
				}
			}
		}
		return counts;
	}
}

		
				
				
