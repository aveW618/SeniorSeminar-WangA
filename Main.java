//Avery Wang
//Senior Seminar

import java.io.*;
import java.util.*; 

public class Main {
	public static void main(String[] args) {
		
		//collects all the student choices
		ArrayList<StudentChoices> totalChoices = new ArrayList<>();
		//collects all the individual session IDs
		ArrayList<Integer> sessionIds = new ArrayList<>();
	
		//loop through every student
		for (int i = 0; i < totalChoices.size(); i++) {
			//gets their choice from the totalChoices array list in another class
			StudentChoices sc = totalChoices.get(i);
		
			//store the student's 5 session choices into an array (getters from other class)
			int[] rankedChoices = {sc.getChoice1(), sc.getChoice2(), sc.getChoice3(), sc.getChoice4(), sc.getChoice5()};
		
			for (int t = 0; t < 5; t++) {
				
