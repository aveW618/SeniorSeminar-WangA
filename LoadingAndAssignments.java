//Avery Wang
//Senior Seminar

import java.io.*;
import java.util.*; 

public class LoadingAndAssignments {
	
	public static void main(String[] args)throws IOException {
		//variables for fixed values (not magic numbers)
		int timeSlots = 5;
		int rooms = 5;
		int roomCapacity = 16;
		int sessionIdNums;
		
		//Array list for student choice objects
		ArrayList<StudentChoices> totalChoices = new ArrayList<>();
		ArrayList<String> studentNames = new ArrayList<>();
		
		//stored CSV file with student data
		String filename = "Senior Seminar Data.csv";
		
		//loading data code from Runestone
		File myFile = new File(filename);
		Scanner scan = new Scanner(myFile);
		
		if (scan.hasNextLine()) {
			scan.nextLine();
		}

		//read through each student file
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] data = line.split(",");
			int c1 = Integer.parseInt(data[10]);
            int c2 = Integer.parseInt(data[11]);
            int c3 = Integer.parseInt(data[12]);
            int c4 = Integer.parseInt(data[13]);
            int c5 = Integer.parseInt(data[14]);
            
			totalChoices.add(new StudentChoices(c1, c2, c3, c4, c5));
			studentNames.add(name);
		}
		scan.close();
		
		//no magic numbers, helps define student numbers based on flexible array list
		int numStudents = totalChoices.size();
		
		//determines how many times each session runs (max of twice) based on number of people signed up
		int[] sessionRunTimes = howManyRuns(totalChoices, sessionIdNums);
		
		//an array list to keep track of the individual session IDs chosen by students, from the overall choice array list
		ArrayList<Integer> sessionIds = getChosenSessions(totalChoices);
		
		//5x5 arrays to place students into sessions (5 timeslots by 5 rooms)
		int[][] sessionTracker = new int[timeSlots][rooms];
		int[][] sessionSpots = new int[timeSlots][rooms];
		
		//load the arrays so that they are empty temporarily
		for (int c = 0; c < timeSlots; c++) {
			for (int r = 0; r < rooms; r++) {
				sessionTracker[c][r] = -1;
				sessionSpots[c][r] = 0;
			}
		}
		
		//Array to help keep track of the num of students for each timeslot
		int[][] assigned = new int[numStudents][timeSlots];
		for (int s = 0; s < numStudents; s++) {
			for (int t = 0; t < timeSlots; t++) {
				assigned[s][t] = 1;
			}
		}
	}
}
		//load students and load sessions by next class
		
	
	
	
	
	
		
		
		
