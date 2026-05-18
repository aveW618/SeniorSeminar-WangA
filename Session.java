/**
 * @author Avery Wang
 * @since February 2026
 * Program: Senior Seminar
 * Purpose: Helps create one session in the scheduling program by storing the session
 * ID, session name, instructor, request count, and popularity. This class also
 * loads session information from the CSV file so the schedule can decide which
 * sessions should run and where they should be placed.
 */

import java.io.*;
import java.util.*; 

public class Session {
	//values of where the session info is located in the CSV file
	private static final int sessionNameColumn = 0;
	private static final int sessionIdColumn = 1;
	private static final int instructorColumn = 2;

	//declaring instance variables needed for session info
	private int id;
	private String name;
	private String instructor;
	private int requests;
	private int popularityPoints;
	
	/*
	 * a constructor that creates one session object
	 * each session contains an Id, name, instructor, request count, and popularity points
	 */
	public Session(int id, String name, String instructor) {
		this.id = id;
		this.name = name;
		this.instructor = instructor;
		this.requests = 0;
		this.popularityPoints = 0;
	}
	
	//getters for all the session info
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getInstructor() {
		return instructor;
	}
	
	public int getRequests() {
		return requests;
	}
	
	public int getPopularityPoints() {
		return popularityPoints;
	}

	//toString method
	public String toString() {
		return("Session " + id + ": " + name + " by " + instructor);
	}

	/*
	 * a method that loads all sessions from the session instructor CSV file
	 * it reads in the session name, session ID, and instructor from that file
	 */
	public static ArrayList<Session> loadSessions(String filename) throws IOException {
		
		// creates an array list to store Session objects
		ArrayList<Session> sessions = new ArrayList<Session>();
		
		// reads in data from the imported file
		File myFile = new File(filename);
		Scanner scan = new Scanner(myFile);
		
		// skips a header row if it is in the data
		if (scan.hasNextLine()) {
			scan.nextLine();
		}
		
		// reads through each row and creates session objects
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] data = line.split(",");
			
			//collects the information from the columns of the CSV file
			if (data.length > instructorColumn) {
				String sessionName = data[sessionNameColumn];
				String sessionIdText = data[sessionIdColumn];
				String instructor = data[instructorColumn];
			
				//only add the session if the session ID is not blank
				if (!sessionIdText.equals("")) {
					int sessionId = Integer.parseInt(sessionIdText);
			
					//adds session info to the sessions ArrayList if that session has not already been added
					if (findSession(sessions, sessionId) == null) {
						sessions.add(new Session(sessionId, sessionName, instructor));
					}
				}
			}
		}
		
		//ends the scanning function and returns the session ArrayList
		scan.close();
		return sessions;
	}
	
	/*
	 * this method finds a session by its ID number
	 * if the session is not found, the method returns null
	 */
	public static Session findSession(ArrayList<Session> sessions, int sessionId) {
		for (int i = 0; i < sessions.size(); i++) {
			
			//checks if the session ID being searched for is the same as the current session's ID
			if (sessions.get(i).getId() == sessionId) {
				return sessions.get(i);
			}
		}
		return null;
	}
			
	/*
	 * a method that adds popularity information about a session
	 * requests count how many students chose a specific session
	 * popularity points give more value to higher-ranked choices
	 */
	public void addRequest(int pointsToAdd) {
		requests++;
		popularityPoints += pointsToAdd;
	}
}
