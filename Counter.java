import java.io.*;
import java.util.*; 

public class Counter {
	public static void main(String[] args) throws IOException {
		
		//importing data from the files
        String filename = "Senior Seminar Data.csv";
        File myFile = new File(filename);
        Scanner scan = new Scanner(myFile);
        
        //session number array
        int[] counts = new int[17];
        
        //checks if there is code to read
		if (scan.hasNextLine()) {
			scan.nextLine();
		}
		
		//reads the code and stores it so that I can keep track of popularity
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] data = line.split(",");
			//reads the 5 choices from the data set
			for (int choice = 10; choice < 15; choice++) {
				//takes the chosen session number from the data
				int sid = Integer.parseInt(data[choice]);
				//increases the chosen session number from above's popularity by 1 for the counts array
				if (sid >= 1 && sid <= 16) {
					counts[sid]++;
				}
			}
		}
		scan.close();
		
		//sid is session id so it prints out the results from the previous loops)
		for (int sid = 1; sid <= 16; sid++) {
			System.out.println("Session " + sid + ": " + counts[sid]);
		}
		
		//helps me check if the class works and fills up different sessions, stopping when the sessions are filled
		if (counts[sid] > 16) {
			System.out.println("Session " sid + " full");
		}
	}
}
			
	

			
		
