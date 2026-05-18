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
	 */
	public static ArrayList<String> loadInstructorName(ArrayList<Session> sessions) {
		ArrayList<Instructor> instructors = new ArrayList<Instructor>();
		
		
		if (scan.hasNextLine()) {
			scan.nextLine();
		}

		//read through data and build an Instructor object for each row
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] data = line.split(",");
			String name = data[17];
			
			instructorName.add(name);
		}
		scan.close();
		return instructorName;
	}
	
	public static ArrayList<Integer> loadInstructorSID(String sessionIDFile) throws IOException {
		ArrayList<Integer> instructorSID = new ArrayList<>();
		
		File myFile = new File(sessionIDFile);
		Scanner scan = new Scanner(myFile);
		
		if (scan.hasNextLine()) {
			scan.nextLine();
		}

		//read through data and build an Instructor object for each row
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] data = line.split(",");
			int sid = Integer.parseInt(data[2]);
			
			instructorSID.add(sid);
		}
		scan.close();
		return instructorSID;
	}

	//main method to test if the loadInstructors method works
	public static void main(String[] args) throws IOException {
		//calls the loadInstructors method and inputs senior seminar data
		ArrayList<String> instructorName = loadInstructorName("Senior Seminar Data.csv");
		ArrayList<Integer> instructorSID = loadInstructorSID("Senior Seminar Session ID.csv");
		
		//prints out the Instructor objects to make sure the program runs as intented: load instructors
		for(int i = 0; i < instructorName.size(); i++) {
			System.out.println(instructorName.get(i));
		}
		
		for(int i = 0; i < instructorSID.size(); i++) {
			System.out.println(instructorSID.get(i));
		}
		
		//prints out the number of instructors successfully loaded
		System.out.println("Total Instructors loaded: " + instructorName.size());
			
	}
}
	
