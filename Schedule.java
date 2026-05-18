/**
 * @author Avery Wang
 * @since February 2026
 * Program: Senior Seminar
 * Purpose: Creates the seminar schedule by placing sessions into time slots and rooms,
 * then assigning students to sessions while trying to reduce conflicts. This class also makes sure to 
 * display the info in an organized and user-friendly way.
 */
import java.util.*;

public class Schedule {
	//declaraing instance variables (no magic numbers) 
	private int timeSlots;
	private int rooms;
	private int roomCapacity;
	private final int maxSessionRuns;
	
	//declaring arrayLists that store student, session, and instructor info for later usage
	private ArrayList<Student> students;
	private ArrayList<Session> sessions;
	private ArrayList<Instructor> instructors;
	
	//declaring 2D arrays to keep track of sessions and enrollment numbers
	private Session[][] sessionGrid;
	private int[][] enrollments;
	
	//declaring more 2D arrays to keep track of student schedules, session rooms, and their session rankings
	private Session[][] studentSchedules;
	private int[][] studentRooms;
	private int[][] studentChoiceRanks;
	
	/*
	 * a constructor that creates the Schedule object
	 * it stores the schedule guidlines, students, sessions, and instructors
	 */
	public Schedule(int timeSlots, int rooms, int roomCapacity, int maxRunsPerSession, ArrayList<Student> students, 
					ArrayList<Session> sessions, <Instructor> instructors) {
		this.timeSlots = timeSlots;
		this.rooms = rooms;
		this.roomCapacity = roomCapacity;
		this.maxRunsPerSession = maxRunsPerSession;

		this.students = students;
		this.sessions = sessions;
		this.instructors = instructors;
		
		//initializing the arrays with student inputted info about the number of time slots and rooms
		sessionGrid = new Session[timeSlots][rooms];
		runNumbers = new int[timeSlots][rooms];
		enrollments = new int[timeSlots][rooms];
		
		//initializing the arrays with inputted info as well as the students ArrayList size
		studentSchedules = new Session[students.size()][timeSlots];
		studentRooms = new int[students.size()][timeSlots];
		studentChoiceRanks = new int[students.size()][timeSlots];
		
		//loops through all the students and time slots and sets the position in the studdent Rooms array to -1
		//the -1 means the student has not been assigned to a room ye
		for (int s = 0; s < students.size(); s++) {
			for (int t = 0; t < timeSlots; t++) {
				studentRoom[s][t] = -1;
			}
		}
	}
	
	/*
	 * a method which counts how popular each session is (based on ranking)
	 * first choices get more points than later choices
	 */
	private void countPopularity() {
		for (int s = 0; s < students.size(); s++) {
			//gets the student choices and stores them in the choices array
			Student student = students.get(s);
			int[] choices = student.getChoices();
			
			//loops through the sessions
			for (int c = 0; c < choices.length; c++) {
				Session session = Session.findSession(sessions, choices[c]);
				
				//tallies up the point values for student choices
				if (session != null) {
					int points = Student.getChoiceCount() - c;
					session.addRequest(points);
				}
			}
		}
	}
		
