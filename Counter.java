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
        
		if (scan.hasNextLine()) {
			scan.nextLine();
		}
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] data = line.split(",");
			//reads the 5 choices from the data set
			for (int choice = 10; choice < 15; choice++) {
				//takes the chosen session number from the data
				int sid = Integer.parseInt(data[c]);
				//increases the chosen session number from above's popularity by 1 for the counts array
				counts[sid]++
				
				for (int col = 0; col < choices[0].size; col++)
		{
	}
	

			
		
