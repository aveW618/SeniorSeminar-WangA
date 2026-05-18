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
		
