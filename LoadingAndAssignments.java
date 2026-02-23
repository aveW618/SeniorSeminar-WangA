//Avery Wang
//Senior Seminar

import java.io.*;
import java.util.*; 

public class LoadingAndAssignments {
	int timeSlots = 5;
	int rooms = 5;
	int roomCapacity = 16;
	public static void main(String[] args)throws IOException{
		
		//Array list for student choice objects
		ArrayList<StudentChoices> totalChoices = new ArrayList<>();
		ArrayList<String> studentNames = new ArrayList<>();
		
		//stored CSV file with student data
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
		int[] sessionRunTimes = howManyRuns(totalChoices, sessionIds);
		
		//an array list to keep track of the individual session IDs chosen by students, from the overall choice array list
		ArrayList<Integer> sessionIds = getChosenSessions(totalChoices)

			int totalStudent = 0;
			for (int i = 0; i <= data.length; i++) {
				totalStudent = totalStudent + student(i);
			}
		//load the data into a 2D array
		int [][] choiceArray = loadChoiceArray(filename, numChoices);
		
		//1D array to count how many times each session appears
		int[] tallies = tallySessions(choiceArray, numSessions);
	}
	
	
	
		
		
		
