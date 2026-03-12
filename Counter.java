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
		
		//sid + 100 is the session id for a second session of a session that is very popular
		//prints out the results from the while loop
		for (int sid = (1 + 100); sid <= (16 + 100); sid++) {
			System.out.println("Session " + (sid + 100) + ": " + counts[(sid + 100)]);
		}
		
		//helps me check if the class works and fills up different sessions, stopping when the sessions are filled
		if (counts[sid] > 16) {
			System.out.println("Session " sid + " full");
			//now increments every session ID by 100 so that the mod values are the same but I can keep track of a second session
			for (int sid = (1 + 100); sid <= (16 + 100); sid++) {
				//repeats the same steps for the second sessions
				//prints out firstly the results from the popularity loops from before
				System.out.println("Session " + (sid + 100) + counds[(sid + 100)]);
				//if there is more than 16 people in the second session as well, print that the sesison is full
					//don't keep going because its a max of two sessions per course
				if (counts[(sid + 100)] > 16)	{
					System.out.println("Session " sid + " full");
				}
			}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
		}
	}
}
			
	

			
		
