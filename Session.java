/**
 * @author Avery Wang
 * @since February 2026
 * Program: Senior Seminar
 * Purpose: Helps create one session in the scheduling program by storing the session
 * ID, session name, presenter, request count, and popularity points. This class also
 * loads session information from the CSV file so the schedule can decide which
 * sessions should run and where they should be placed.
 */

import java.io.*;
import java.util.*;

public class Session {
	//values of where the session info is located in the CSV file
	private static final int sessionNameColumn = 0;
	private static final int sessionIdColumn = 1;
	private static final int presenterColumn = 2;
	
	//declaring variables needed for session info
	private int id;
	private String name;
	private String presenter;
	private int requests;
	private int points;
	
	/*
	 * a constructor that creates one session object
	 * each session has an ID, name, presenter, request count, and popularity points
	 */
	public Session(int id, String name, String presenter) {
		this.id = id;
		this.name = name;
		this.presenter = presenter;
		this.requests = 0;
		this.points = 0;
	}
	
	/*
	 * a method that loads all sessions from the session presenter CSV file
	 * it reads in the session name, session ID, and presenter for each session
	 */
	public static ArrayList<Session> loadSessions(String filename) throws IOException {
		//creates an array list to store session objects
		ArrayList<Session> sessions = new ArrayList<Session>();
		
		//loads in data
		File myFile = new File(filename);
		Scanner scan = new Scanner(myFile);
		
		//skips header row if it is in the data
		if (scan.hasNextLine()) {
			scan.nextLine();
		}
		
		//read through each session file and build a session object for each row
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] data = line.split(",", -1);
			
			if (data.length > presenterColumn) {
				String sessionName = data[sessionNameColumn].trim();
				String sessionIdText = data[sessionIdColumn].trim();
				String presenter = data[presenterColumn].trim();
				
				//only add the session if the session ID is not blank
				if (!sessionIdText.equals("")) {
					int sessionId = Integer.parseInt(sessionIdText);
					
					//removes extra information in parentheses from the presenter name
					int parenthesisSpot = presenter.indexOf("(");
					if (parenthesisSpot >= 0) {
						presenter = presenter.substring(0, parenthesisSpot).trim();
					}
					
					//prevents the same session from being added more than once
					if (findSession(sessions, sessionId) == null) {
						sessions.add(new Session(sessionId, sessionName, presenter));
					}
				}
			}
		}
		
		scan.close();
		return sessions;
	}
	
	/*
	 * this method finds a session by its ID number
	 * it returns null if the session is not found
	 */
	public static Session findSession(ArrayList<Session> sessions, int sessionId) {
		for (int i = 0; i < sessions.size(); i++) {
			if (sessions.get(i).getId() == sessionId) {
				return sessions.get(i);
			}
		}
		
		return null;
	}
	
	/*
	 * this method adds popularity information to a session
	 * requests count how many students chose the session
	 * points give more value to higher-ranked choices
	 */
	public void addRequest(int pointsToAdd) {
		requests++;
		points += pointsToAdd;
	}
	
	//getters for all the session info
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPresenter() {
		return presenter;
	}
	
	public int getRequests() {
		return requests;
	}
	
	public int getPoints() {
		return points;
	}
	
	public String toString() {
		return "Session " + id + ": " + name + " by " + presenter;
	}
}
