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
	public static ArrayList<Instructor> loadInstructors(String filename) throws IOException {
		
		ArrayList<Instructor> instructors = new ArrayList<>();
		
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
			int sid = Integer.parseInt(data[18]);
			
			instructors.add(name, sid);
		}
		scan.close();
		return instructors;
	}

	//main method to test if the loadInstructors method works
	public static void main(String[] args) throws IOException {
		//calls the loadInstructors method and inputs senior seminar data
		ArrayList<Instructor> instructors = loadInstructors("Senior Seminar Data.csv");
		
		//prints out the Instructor objects to make sure the program runs as intented: load instructors
		for(int i = 0; i < instructors.size(); i++) {
			System.out.println(instructors.get(i));
		}
		
		//prints out the number of instructors successfully loaded
		System.out.println("Total Instructors loaded: " + instructors.size());
			
	}
}
	
