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
			int sid = Integer.parseInt(data[18]);

		scan.close();
		}
		
		//print out instructor list
		for (Instructor instr : instructors) {
			System.out.println(instr)
		}
	}
	
