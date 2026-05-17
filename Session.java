/**
 * @author Avery Wang
 * @since February 2026
 * Program: Senior Seminar
 * Purpose: Helps create one session in the scheduling program by storing the session
 * ID, session name, presenter, request count, and popularity. This class also
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
		return popularityPoints
	
	//toString method
	public String toString() {
		return("Session ID: " + sessionID + "\n" + "Instructor: " + instructor);
	}

	//method to load sessions
	public static ArrayList<Session> loadSessions(String filename) throws IOException {
		// creates an array list to store Session objects
		ArrayList<Session> sessions = new ArrayList<>();
		
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
			
			//stores the specific data for instructor name and their session ID
			//trim to help prevent any bugs if there is an extra space at the end of file info
			String instr = data[17].trim();
			int sid = Integer.parseInt(data[18]);
			
			//method of array lists to create a new Session object to add to the arraylist sessions
			sessions.add(new Session(sid, instr));
		}
		
		//ends the scanning of the data
		scan.close();
		
		return sessions;
	}
	
		
