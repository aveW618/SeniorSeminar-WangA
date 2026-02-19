//Avery Wang
//Senior Seminar

import java.io.*;
import java.util.*; 

public class LoadingAndAssignments {
	public static void main(String[] args)throws IOException{
		
		//Array list for student choice objects
		ArrayList<StudentChoices> totalChoices = new ArrayList<>();
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
			ArrayList<String> student = new ArrayList<String>();
			totalChoices.add(new StudentChoices(c1, c2, c3, c4, c5));
		}
		scan.close();
		

			int totalStudent = 0;
			for (int i = 0; i <= data.length; i++) {
				totalStudent = totalStudent + student(i);
			}
		//load the data into a 2D array
		int [][] choiceArray = loadChoiceArray(filename, numChoices);
		
		//1D array to count how many times each session appears
		int[] tallies = tallySessions(choiceArray, numSessions);
	}
	
	
	
		
		
		
