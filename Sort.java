//Avery Wang
//Senior Seminar

import java.io.*;
import java.util.*; 

public class LoadingAndAssignments {
	public static void main(String[] args) {
		//stored CSV file with student data
		String filename = "Senior Seminar Data.csv";
		
		//each student attends/picks 5 sessions
		int numChoices = 5;
		//number of available sessions
		int numSessions = 16;
		
		//load the data into a 2D array
		int [][] choiceArray = loadChoiceArray(filename, numChoices);
		
		//1D array to count how many times each session appears
		int[] tallies = tallySessions(choiceArray, numSessions);
		
	
		
		
		
		
		
