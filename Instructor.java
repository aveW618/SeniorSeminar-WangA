/**
 * @author Avery Wang
 * @since February 2026
 * Program: Senior Seminar
 * Purpose: Helps track which instructor teaches which sessions. This helps make sure that
 * the same instructor is not scheduled to teach two sessions at the same time.
 */
import java.io.*;
import java.util.*; 

public class Instructor {
	//declares instance variables for future use
	private String name;
	private ArrayList<Integer> sessionIds;
	
	public Instructor (String name) {
		this.name = name;
		this.sessionIds = new ArrayList<Integer>();
	}
	
	//getters
	public String getName() {
		return name;
	}
	
	public ArrayList<Integer> getSessionIds() {
		return sessionIds;
	}
	
	//toString method that converts the information into string format
	public String toString() {
		return (name + " teaches " + sessionIds);
	}
	
	/*
	 * this method creates a list of instructors from the session list
	 * if the same instructor teaches multiple sessions, those session IDs are then grouped together
	 * also gets instructor information to add using the accessor methods
	 */
	public static ArrayList<Instructor> loadInstructors(ArrayList<Session> sessions) {
		ArrayList<Instructor> instructors = new ArrayList<Instructor>();
		
		for (int i = 0; i < sessions.size(); i++) {
			Session session = sessions.get(i);
			Instructor instructor = findInstructor(instructors, session.getInstructor());
			
			if (instructor == null) {
				instructor = new Instructor(session.getInstructor());
				instructors.add(instructor);
			}

			instructor.addSessionId(session.getId());
		}

		return instructors;
	}

	/*
	 * this method finds an instructor by name
	 * it returns null if the instructor is not already in the list
	 */
	public static Instructor findInstructor(ArrayList<Instructor> instructors, String name) {
		for (int i = 0; i < instructors.size(); i++) {
			if (instructors.get(i).getName().equalsIgnoreCase(name)) {
				return instructors.get(i);
			}
		}
		
		return null;
	}
	
	/*
	 * this method adds a session ID to the instructor's list of sessionIds
	 */
	public void addSessionId(int sessionId) {
		if (!sessionIds.contains(sessionId)) {
			sessionIds.add(sessionId);
		}
	}
}
