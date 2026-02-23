import java.io.*;
import java.util.*; 

public class Instructor {
	private String instructorName;
	private int sessionID;
	private int timeSlot;
	
	public Instructor (String in , int sid, int ts) {
		this.instructorName = in;
		this.sessionID = sid;
		this.timeslot = ts;
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
		ArrayList<Instructor> instructors = new ArrayList<>();
		String filename = "Senior Seminar Data.csv";
		
		File myFile = new File(filename);
		Scanner scan = new Scanner(myFile);
		
		if (scan.hasNextLine()) {
			scan.nextLine();
		}

		//read through each student file
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] data = line.split(",");
			String name = data[17];
			int sid =Integer.parseInt(data[18]);
			instructors.add(new Instructor(name, sid));
			}
		scan.close();
		}
	}
	
