import java.io.*;
import java.util.*; 

public class Session {
	//instance variables for session info
	private int sessionID;
	private String sessionName;
	private String instructor;
	
	//constructor for a session
	public Session(int sessionID, String sessionName, String instructor) {
		sessionID = sid;
		sessionName = sn;
		instructor = i;
	}
	
	//getters
	public int getSessionID() {
		return sessionID;
	}
	public int getSessionName() {
		return sessionName;
	}
	public int getInstructor() {
		return instructor;
	}
	
	//toString method
	public String toString() {
		return("Session ID: " + sessionID + "\n" + "Session Name: " + sessionName + "\n" + "Instructor: " + instructor);
	}
}
	
	
	
	
	
	
	
	
