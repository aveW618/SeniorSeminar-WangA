import java.io.*;
import java.util.*; 

public class Session {
	//instance variables for session info
	private int sessionID;
	private String instructor;
	
	//constructor for a session
	public Session(int sid, String instr) {
		this.sessionID = sid;
		this.instructor = instr;
	}
	
	//getters
	public int getSessionID() {
		return sessionID;
	}
	public String getInstructor() {
		return instructor;
	}
	
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
			//trim to 
			String instr = data[17].trim();
			int sid = Integer.parseInt(data[18]);
			
			//method of array lists to create a new Session object to add to the arraylist sessions
			sessions.add(new Session(sid, instr));
		}
		
		//ends the scanning of the data
		scan.close();
		
		return sessions;
	}
	
	// main method to test if the loadSessions method works
	public static void main(String[] args) throws IOException {
		// calls the loadSessions method and inputs senior seminar data
		ArrayList<Session> sessions = loadSessions("Senior Seminar Data.csv");

		// prints out the Session objects to make sure the program runs as intended: loads sessions
		for (int i = 0; i < sessions.size(); i++) {
			System.out.println(sessions.get(i));
		}

		// prints out the number of sessions successfully loaded
		System.out.println("Total Sessions loaded: " + sessions.size());
	}
}
	
		
