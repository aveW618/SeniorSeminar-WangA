import java.io.*;
import java.util.*; 

public class Session {
	//instance variables for session info
	private int sessionID;
	private String sessionName;
	private String instructor;
	
	//constructor for a session
	public Session(int sessionID, String sessionName, String instructor) {
		this.sessionID = sessionID;
		this.sessionName = sessionName;
		this.instructor = instructor;
	}
	
	//getters
	public int getSessionID() {
		return sessionID;
	}
	public String getSessionName() {
		return sessionName;
	}
	public String getInstructor() {
		return instructor;
	}
	
	//toString method
	public String toString() {
		return("Session ID: " + sessionID + "\n" + "Session Name: " + sessionName + "\n" + "Instructor: " + instructor);
	}
}
	
	
	
	
	
	
	
	
