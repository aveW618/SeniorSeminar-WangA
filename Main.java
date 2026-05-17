/**
 * @author Avery Wang
 * @since February 2026
 * Program: Senior Seminar
 * Purpose: 
 */

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
		int[] sessionPopularity = countSessionRequests(students, largestSessionID);
		
		System.out.println();
		System.out.println("Number of session request: ");
		for (int sid = 1; sid < sessionPopularity.length; sid++) {
			System.out.println("Session " + sid + ": " + sessionPopularity[sid] + " requests");
		}
		
	}
		
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

		
				
				
