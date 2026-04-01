import java.io.*;
import java.util.*; 

public class Instructor {
	private String instructorName;

	//sessions an instructor can teacher  (1-2)
	private ArrayList<Integer> sessionIDs;
	
	public Instructor (String name) {
		this.instructorName = name;
		this.sessionIDs = new ArrayList<>();
	}
	
	//getters
	public String getInstructorName() {
		return instructorName;
	}
	
	//toString method (so printed instructors can be read)
	public String toString() {
		return (instructorName + " " + sessionIDs);
	}
	
	//keeping track of instructor info
	public static ArrayList<String> loadInstructorName(String filename) throws IOException {
		
		ArrayList<String> instructorName = new ArrayList<>();
		
		File myFile = new File(filename);
		Scanner scan = new Scanner(myFile);
		
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
	
