import java.io.*;
import java.util.*; 

public class Instructor {
	private String instructorName;
	private int sessionID;
	private int timeslot;
	
	public InstructorInfo (String in , int sid, int ts) {
		instructorName = in;
		sessionID = sid;
		timeslot = ts;
	}
	
	//getters
	public String getInstructorName() {
		return instructorName;
	}
	public int getSessionID() {
		return sessionID;
	}
	public int getTimeslot() {
		return timeslot;
	}
	
	//separate place to keep track of instructors, their sessions, classrooms, timeslots
	public static void main(String[] args) throws IOException {
		//classrooms
		int numClassrooms = 5;
		//timeslots
		int [] timeSlots = {830, 930, 1030, 1230, 130};
		int sessions;
		
		//need to change magic number
		ArrayList<String> instructorArray = new ArrayList<String>();
		String filename = "Senior Seminar Data.csv";
		
		//counter for loops
		int count = 0;
		
			File myFile = new File(filename);
			Scanner scan = new Scanner(myFile);
			int i = 0;
		
			if (scan.hasNextLine()) {
				scan.nextLine();
			}

			//read through each student file
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] data = line.split(",");
				ArrayList<String> instructor = new ArrayList<String>();
				instructor.add(data[17]);
				instructor.add(data[18]);
				i++;
			}
			scan.close();
		}
	}
	
