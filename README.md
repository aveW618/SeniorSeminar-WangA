# SeniorSeminar
A student project for Managing Scheduling and Optimizing a Solution that reduces conflicts

## Develop a Java Based Solution to Minimize Scheduling Conflicts

The attached CSV/Spreadsheet file is the result of sending out a google form and having students enter their top 5 ranked choices, using the mini table in the spreadsheet that contains the sessions, IDs and speakers.

**Feel free to clean up the spreadsheets, and even create new ones if needed, HOWEVER - you many not alter student preferences in the fiel or spreadsheet.

- 5 Time Slots 
- 5 Classrooms (16 students max/ class)
- Sessions Cannot Run more than Twice
- Notice that some sessions are taught by same person
- Student May Not Repeat a Session
- Schedule a Student for 5 Session

**Goal is to design and code an algorithm that generates a schedule for the students, given structure above, with the fewest number of conflicts

- Generate a schedule for the sessions and speakers, 
- Create lists for each student so they know what sessions to attend, rooms and times.


Update for the weekend of 2/21-2/22 (missed class, makeup):
I worked on fixing some syntax errors and also deleting redundant code for my counter class, instead choosing to use loops to keep track on info in arrays. I used counters to keep track of popularity for each of the instructor sessions to help determine which ones should have 1 or 2 sessions running. I also reorganized some of the timeslot and session room info into 5 x 5 arrays to better place and keep track of students and their locations for the day (this was in the loading and assignment array I created to help assign students). I started my main class that helps overall organization and keeping track of info from all 5  other classes to merge in the end when I assign students to their individual classes. I also refined my oragnization of Instructor info by starting to work on a list to keep track of them and the sessions they are teaching (still in progress). My next steps would be to refine any syntax errors and finish loading Instructor info as well as checking to make sure they aren't teaching overlapping sessions. I also need to rethink through my logic on how my students will be assigned to sessions now that a lot of my foundational structures are finished.

Update for February 23 (in-class): 
I talked a bit with Mr. Twyford about my next steps for the project which will now include loading the Student objects into the 5 x 5 array (prioritizing timeslots because there are the highest risks of conflicts there in comparison to the rooms). I also talked about more of my logic (ranking by popularity) and some of the advantages/disadvanategs of ranking my timestamps. I realized I hadn't actually dedicated a specific class and code to my Student object so I created that using the same coding basis as my instructor object clas. I also commented a bit more about my code. My next steps are to load the student objects and also to merge all of my components (instructor objects, student objects, 5 x 5 arrays, counter arrays, etc.) together to actually apply them in my system that will assign the students to their respective classes.

