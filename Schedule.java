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
	private int maxRunsPerSession;
	
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
					ArrayList<Session> sessions, ArrayList<Instructor> instructors) {
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
				studentRooms[s][t] = -1;
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
				if (sessions.get(j).getPopularityPoints() > sessions.get(i).getPopularityPoints()) {
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
	private void placeSessions() {
		//initial guidelines
		int totalSpaces = timeSlots * rooms;
		int placed = 0;

		//place each session once first
		for (int i = 0; i < sessions.size() && placed < totalSpaces; i++) {
			//calls the method that places one session 
			//actual parameter includes the obtained session number
			if (placeOneSession(sessions.get(i), 1, placed)) {
				placed++;
			}
		}
		
		boolean added = true;
		
		//add extra runs (of the session) if there is still space in the schedule
		while (placed < totalSpaces && added) {
			added = false;
			//loops through the sessions to see if there are popular sessions and count how many times they run
			for (int i = 0; i < sessions.size() && placed < totalSpaces; i++) {
				Session session = sessions.get(i);
				int currentRuns = countRuns(session.getId());
				//only add another run if the session already runs and has not reached the max number of runs
				if (currentRuns > 0 && currentRuns < maxRunsPerSession) {
					//place the sesion into an open slot in the schedule
					if (placeOneSession(session, currentRuns + 1, placed)) {
						placed++;
						added = true;
					}
				}
			}
		}
	}
		
	/*
	 * this method tries to place one session in the schedule
	 * it also avoids putting the same instructor in two rooms at the same time
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
	 * it prevents the same session and same instructor from appearing twice in that time slot
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
	
	/*
	 * this method counts how many times a session has already been placed
	 */
	private int countRuns(int sessionId) {
		int count = 0;
		//loops through the schedule (room and times) to find where sessions are placed (if so, increment counter by 1)
		for (int time = 0; time < timeSlots; time++) {
			for (int room = 0; room < rooms; room++) {
				if (sessionGrid[time][room] != null && sessionGrid[time][room].getId() == sessionId) {
					count++;
				}
			}
		}

		return count;
	}
	
	/*
	 * a method which assigns students to sessions
	 * it goes through ranked choices first, then assigns students to open sessions if needed
	 */
	 private void assignStudents() {
		 //loops through each time slot and choice ranking
		 for (int time = 0; time < timeSlots; time++) {
			for (int choiceRank = 1; choiceRank < Student.getChoiceCount(); choiceRank++) {
				for (int s = 0; s < students.size(); s++) {
					//only assigns the student if they do not already have a session for the time specified
					if (studentSchedules[s][time] == null) {
						int wantedSessionId = students.get(s).getChoices()[choiceRank - 1];
						int room = findOpenRoom(time, wantedSessionId, s);
						//if there is an open room, assign the student to that session
						if (room != -1) {
							studentSchedules[s][time] = sessionGrid[time][room];
							studentRooms[s][time] = room;
							studentChoiceRanks[s][time] = choiceRank;
							//increases the number of students in that room
							enrollments[time][room]++;
						}
					}
				}
			}
			
			//assign students with no ranked choice available
			for (int s = 0; s < students.size(); s++) {
				if (studentSchedules[s][time] == null) {
					int room = findLeastCrowdedRoom(time, s);

					if (room != -1) {
						studentSchedules[s][time] = sessionGrid[time][room];
						studentRooms[s][time] = room;
						studentChoiceRanks[s][time] = 0;
						enrollments[time][room]++;
					}
				}
			}
		}
	}
			
			
	/*
	 * this method finds an open room for a specific session during a time slot
	 */
	private int findOpenRoom(int time, int sessionId, int studentIndex) {
		for (int room = 0; room < rooms; room++) {
			Session session = sessionGrid[time][room];
			
			//if the session is not empty and also not completely full, then return the room 
			if (session != null && session.getId() == sessionId) {
				if (enrollments[time][room] < roomCapacity && !studentAlreadyHasSession(studentIndex, sessionId)) {
					return room;
				}
			}
		}

		return -1;
	}
	
	/*
	 * this method finds the least crowded room during a time slot
	 * it is used when a student cannot get one of their choices
	 * I struggled a bit here with thinking of what other methods I might need to combine
	 * together to actually be able to find the least crowded room
	 * This was also another layer of complexity which I might not need but would be 
	 * helpful in determing which room specifically to assign students
	 */
	 private int findLeastCrowdedRoom(int time, int studentIndex) {
		int bestRoom = -1;

		for (int room = 0; room < rooms; room++) {
			Session session = sessionGrid[time][room];
			
			//if the session isn't null, checks to see if it has space
			if (session != null) {
				boolean hasSpace = enrollments[time][room] < roomCapacity;
				//calls a method to see if a student already has a session
				boolean alreadyHasSession = studentAlreadyHasSession(studentIndex, session.getId());
				//if there is an empty space in the room, or the enrollment number is less than the enrollment
				//of the current best room, set the best room as this new room
				if (hasSpace && !alreadyHasSession) {
					if (bestRoom == -1 || enrollments[time][room] < enrollments[time][bestRoom]) {
						bestRoom = room;
					}
				}
			}
		}

		return bestRoom;
	}
		 

	/*
	 * this method checks if a student already has a specific session in their schedule
	 * it prevents students from repeating the same session
	 */
	private boolean studentAlreadyHasSession(int studentIndex, int sessionId) {
		for (int time = 0; time < timeSlots; time++) {
			//if the student schedule at a mentioned time isn't empty and the session ID of that time in the schedule
			//matches the session ID being checked, then return true
			if (studentSchedules[studentIndex][time] != null && studentSchedules[studentIndex][time].getId() == sessionId) {
				return true;
			}
		}

		return false;
	}
	
	/*
	 * a method which prints a summary of the final schedule
	 * it includes total conflicts and average conflicts per student, sessions and students loaded, etc.
	 */
	public void printSummary() {
		int totalConflicts = countConflicts();
		double conflictsPerStudent = 0.0;

		if (students.size() > 0) {
			conflictsPerStudent = (double) totalConflicts / students.size();
		}

		System.out.println("========== Schedule Summary ==========");
		System.out.printf("                         " +  "%d /n", "Students loaded:", students.size());
		System.out.printf("                         " +  "%d /n", "Sessions loaded:", sessions.size());
		System.out.printf("                         " +  "%d /n", "Instructors loaded:", instructors.size());
		System.out.printf("                         " +  "%d /n", "Assignments made:", countAssignments());
		System.out.printf("                         " +  "%d /n", "Total conflicts:", totalConflicts);
		System.out.printf("                         " +  "%d /n", "Conflicts per student:", conflictsPerStudent);
	}
	
	/*
	 * this method prints the session schedule as a grid
	 * each row is a time slot and each column is a room
	 * also includes how many people are enrolled in each room out of the capacity
	 */
	public void printSessionGrid() {
		System.out.println("========== Session Grid ==========");

		System.out.printf("            ", "Time Slot");
		//loops through and prints out the rooms (user-friendly spacing/design)
		for (int room = 0; room < rooms; room++) {
			System.out.printf("               ", "Room " + (room + 1));
		}

		System.out.println();
		//loops through and prints out the time slots (even spacing)
		for (int time = 0; time < timeSlots; time++) {
			System.out.printf("            ", "Slot " + (time + 1));

			for (int room = 0; room < rooms; room++) {
				Session session = sessionGrid[time][room];
				//displays empty if the session is not running/filled
				if (session == null) {
					System.out.printf("               ", "Empty");
				} 
				//otherwise, displays the session number in its correct cell
				else {
					String cell = "S" + session.getId() + " (" + enrollments[time][room] + "/" + roomCapacity + ")";
					System.out.printf("               ", cell);
				}
			}

			System.out.println();
		}

		System.out.println();
		System.out.println("S# means session ID. The number in parentheses is enrolled students / room capacity.");
	}
				
	/*
	* this method prints each speaker's schedule 
	* each speaker is listed with their room assignment and corresponding session name for each time slot
	*/
	public void printSpeakerSchedule() {
		System.out.println("========== Speaker Schedule ==========");
		//loops through the instructors, getting their info
		for (int i = 0; i < instructors.size(); i++) {
			Instructor instructor = instructors.get(i);

			System.out.println(instructor.getName() + ":");
			
			//loops through the time slots and rooms
			for (int time = 0; time < timeSlots; time++) {
				boolean foundSession = false;

				for (int room = 0; room < rooms; room++) {
					Session session = sessionGrid[time][room];
					//if the session's corresponding instructor info matches the instructor currently being looped through
						//print out the time slot, room, and session info
					if (session != null && session.getInstructor().equalsIgnoreCase(instructor.getName())) {
						System.out.println("\tTime Slot #" + (time + 1) + ": Room " + (room + 1) + ", " + session.getName());
						foundSession = true;
					}
				}
				
				//if a session is not found to match the info being looped through
				//display that the instructor has no session at that specific time slot
				if (!foundSession) {
					System.out.println("\tTime Slot #" + (time + 1) + ": No session");
				}
			}

			System.out.println();
		}
	}
	
	/*
	 * this method prints each student's schedule as a simple list
	 * each student has one line for each session they should attend
	 */
	public void printStudentLists() {
		System.out.println("========== Student Schedules ==========");

		for (int s = 0; s < students.size(); s++) {
			System.out.println(students.get(s).getName() + ":");

			for (int time = 0; time < timeSlots; time++) {
				Session session = studentSchedules[s][time];
				
				//prints out info for the users if no session is found
				if (session == null) {
					System.out.println("\tSession " + (time + 1) + ": No session found");
				} 
				//otherwise prints out the session and room info corresponding for each student
				else {
					System.out.println("\tSession " + (time + 1) + ": Room " + (studentRooms[s][time] + 1) + ", " + session.getName());
				}
			}

			System.out.println();
		}
	}
	
	/*
	 * this method counts how many conflicts one student has
	 * a conflict means the student did not get one of their ranked choices
	 */
	private int countConflictsForStudent(int studentIndex) {
		int count = 0;

		for (int time = 0; time < timeSlots; time++) {
			if (studentSchedules[studentIndex][time] == null || studentChoiceRanks[studentIndex][time] == 0) {
				count++;
			}
		}

		return count;
	}
	
	/*
	 * this method counts how many student assignments were made
	 */
	private int countAssignments() {
		int count = 0;
		//loops through the schedule, if the spot isn't empty, increment the counter by 1
		for (int s = 0; s < students.size(); s++) {
			for (int time = 0; time < timeSlots; time++) {
				if (studentSchedules[s][time] != null) {
					count++;
				}
			}
		}

		return count;
	}
	
	/*
	 * this method counts how many total conflicts there are
	 */
	private int countConflicts() {
		int count = 0;
		
		//loops through all the students and adds together their conflicts
		for (int s = 0; s < students.size(); s++) {
			count += countConflictsForStudent(s);
		}

		return count;
	}
}
