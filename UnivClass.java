package university.gui.domain;

public class UnivClass {
	private String courseName;
	//course ID is the number in the array 
	protected static int courseID;
	//course No is the official course number used on syllabus
	private int courseNo;
	private Instructor instruct;
	
	//array of student objects
	private QueueADT<Student> students;
	private int noOfStuds;
	
	public UnivClass(){
		courseName = null;
		courseID = courseID + 1;
		courseNo = 0;
		students = null;
		instruct = null;
		noOfStuds = 0;
		
	}
	public UnivClass(String name, int c, Instructor i, int students){
		
		courseName = name;
		courseID = courseID + 1;
		courseNo = c;
		instruct = i;
		noOfStuds = students;
		this.students = new QueueADT<Student>(Student.class);
		
	}
	
	//I want to add the current student object at the rear of the queue
	public void addStudent(Student s){
		students.enqueue(s);
	}
	//retrieve student object at the front of the queue
	public Student removeStudent(){
		return students.dequeue();
	}
	
	//methods to retrieve instance and class variables
	public String getName(){
		return courseName;
	}
	public int getCourseID(){
		return courseID;
	}
	public int getCourseNo(){
		return courseNo;
	}
	public Instructor getInstructor(){
		return instruct;
	}
	public int getNoOfStudents(){
		return noOfStuds;
	}
	public void setName(String name){
		courseName = name;
	}
	public void setCourseNo(int g){
		courseNo = g;
	}
	public void setInstructor(Instructor i){
		instruct = i;
	}
	public void setNoOfStudents(int s){
		noOfStuds = s;
	}
	
}
