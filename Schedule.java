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
	private int[][] runNumbers; //keeps track of what run of the session is ongoing
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
	
	/*
	 * this method sorts the sessions from most popular to least popular (after the ranking from the countPopularity method)
	 */
	private void sortSessionsByPopularity() {
		//loops through all the sessions
		for (int i = 0; i < sessions.size() - 1; i++) {
			for (int j = i + 1; j < sessions.size(); j++) {
				//ranks the sessions from greatest to least (max value is found)
				if (sessions.get(j).getPoints() > sessions.get(i).getPoints()) {
					//uses a temporary value to swap the max value
					Session temp = sessions.get(i);
					sessions.set(i, sessions.get(j));
					sessions.set(j, temp);
				}
			}
		}
	}
	
	/*
	 * this method places sessions into the room and time slot grid
	 * each session is placed once first, and popular sessions may run again
	 */
	public void placeSessions() {
		//initial guidelines
		int totalSpaces = timeSlots + rooms;
		int placed = 0;

		//place each session once first
		for (int i = 0; i < sessions.size(); i++) {
			//calls the method that places one session 
			//actual parameter includes the obtained session number
			if (placeOneSession(sessions.get(i), 1)) {
				placed++;
			}
		}
		
		boolean added = true;
		
		//add extra runs (of the session) if there is still space in the schedule
		while (placed < totalSpaces) {
			//loops through the sessions to see if there are popular sessions and count how many times they run
			for (int i = 0; i < sessions.size(); i++) {
				Session session = sessions.get(i);
				int currentRuns = countRuns(session.getId());
				//only add another run if the session already runs and has not reached the max number of runs
				if (currentRuns > 0 && currentRuns < maxRunsPerSession) {
					//place the sesion into an open slot in the schedule
					if (placeOneSession(session, currentRuns, placed)) {
						placed++;
						added = true;
					}
				}
			}
		}
	}
		
	/*
	 * this method tries to place one session in the schedule
	 * it also avoids putting the same presenter in two rooms at the same time
	 */
	private boolean placeOneSession(Session session, int runNumber, int startingSlot) {
		for (int f = 0; f < timeSlots; f++) {
			int time = (startingSlot + f) % timeSlots;
			
			//calls a method that checks to make sure a session can be placed in the schedule
			if (canPlaceInTimeSlot(session, time)) {
				for (int room = 0; room < rooms; room++) {
					//if the spot in the 2D array is empty, assign values to it
					if (sessionGrid[time][room] == null) {
						sessionGrid[time][room] = session;
						runNumbers[time][room] = runNumber;
						return true;
					}
				}
			}
		}

		return false;
	}

	
	/*
	 * this method checks whether a session can be placed in one time slot
	 * it prevents the same session and same presenter from appearing twice in that time slot
	 */
	private boolean canPlaceInTimeSlot(Session session, int time) {
		//loops through all rooms to see if any have already been assigned
		for (int room = 0; room < rooms; room++) {
			Session alreadyPlaced = sessionGrid[time][room];
			//if the room hasn't been assigned, return true, if it has been placed, return false
			if (alreadyPlaced != null) {
				//checks if a room has been placed through comparison with the session ID or instructor
				if (alreadyPlaced.getId() == session.getId()) {
					return false;
				}
				if (alreadyPlaced.getInstructor().equalsIgnoreCase(session.getInstructor())) {
					return false;
				}
			}
		}
		return true;
	}
