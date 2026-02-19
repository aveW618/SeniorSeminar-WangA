//Avery Wang
//Senior Seminar

import java.io.*;
import java.util.*; 
		
public class StudentChoices {
	//5 choices of each student
	//store student choies as indices//
	private int choice1;
	private int choice2;
	private int choice3;
	private int choice4;
	private int choice5;
	
	//constructor 
	public StudentChoices (int c1, int c2, int c3, int c4, int c5) {
		choice1 = c1;
		choice2 = c2;
		choice3 = c3;
		choice4 = c4;
		choice5 = c5;
	}
	
	//getters
	public int getChoice1() {
		return choice1;
	}
	public int getChoice2() {
		return choice2;
	}
	public int getChoice3() {
		return choice3;
	}
	public int getChoice4() {
		return choice4;
	}
	public int getChoice5() {
		return choice5;
	}
	
	//toString method
	public String toString() {
		return (choice1 + " " + choice2 + " " + choice3 + " " + choice4 + " " + choice5);
	}
}
