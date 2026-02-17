import java.io.*;
import java.util.*; 

public class Counter {
	private int session1 = 0;
	private int session2 = 0;
	private int session3 = 0;
	private int session4 = 0;
	private int session5 = 0;
	private int session6 = 0;
	private int session7 = 0;
	private int session8 = 0;
	private int session9 = 0;
	private int session10 = 0;
	private int session11 = 0;
	private int session12 = 0;
	private int session13 = 0;
	private int session14 = 0;
	private int session15 = 0;
	private int session16 = 0;
	
	String filename = "Senior Seminar Data.csv";
	File myFile = new File(filename);
	Scanner scan = new Scanner(myFile);
	int i = 0;
		
	if (scan.hasNextLine()) {
		scan.nextLine();
	}
	while (scan.hasNextLine()) {
		String line = scan.nextLine();
		String[] data = line.split(",");
		ArrayList<String> choices = new ArrayList<String>();
		student.add(data[10]);
		student.add(data[11]);
		student.add(data[12]);
		student.add(data[13]);
		student.add(data[14]);
	}
	
	for (int row = 0; row < choices.size; row++)
	{
		for (int col = 0; col < choices[0].size; col++)
		{
			
		
