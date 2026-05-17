//Avery Wang
//Senior Seminar

import java.io.*;
import java.util.*; 

public class Main {
	public static void main(String[] args) throws IOException{
		
		String filename = "Senior Seminar Data.csv";
		
		ArrayList <Student> students = Student.loadStudents(filename);
		ArrayList <Session> sessions = Session.loadSessions(filename);
		
		System.out.println("Students loaded: ");
		for(int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i));
		}
		
		System.out.println();
		System.out.println("Total students loaded: " + students.size());
		
		System.out.println();
		System.out.println("Sessions loaded: ");
		for (int i = 0; i < sessions.size(); i++) {
			System.out.println(sessions.get(i));
		}
		
		System.out.println();
		System.out.println("Total sessions loaded: " + sessions.size());
		
		int largestSessionID = findLargestSessionID(sessions);
		
		public static int findLargestSessionID(ArrayList <Session> sessions) {
			int largest = 0;
			
			for (int i = 0; i < sessions.size(); i++) {
				if (sessions.get(i) > largest) {
					largest = sessions.get(i);
				}
			}
			
			return largest;
		}
		
	
		//loop through every student
		for (int i = 0; i < totalChoices.size(); i++) {
			//gets their choice from the totalChoices array list in another class
			StudentChoices sc = totalChoices.get(i);
		
			//store the student's 5 session choices into an array (getters from other class)
			int[] rankedChoices = {sc.getChoice1(), sc.getChoice2(), sc.getChoice3(), sc.getChoice4(), sc.getChoice5()};
		
			for (int t = 0; t < 5; t++) {
				
		Schedule s1 = new Schedule();
		s1. 
		
		
		
				
				
