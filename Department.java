package university.gui.domain;

import java.io.Serializable;

public class Department implements Serializable{
	private String departName;
	private int noOfCourses;
	private QueueADT<UnivClass> courses;
	//Empty constructor creating a department
	//that has a name and an array of courses
	public Department(){
		departName = null;
		courses = null;
	}
    public Department(String name, int c){
    	departName = name;
    	noOfCourses = c;
    	courses = new QueueADT<UnivClass>(UnivClass.class);
    	
    }
	//get the name of the department
	public String getDepartment(){
		return departName;
	}
	//add the course to the rear of the queue
	public void setCourse(UnivClass c){
		courses.enqueue(c);
	}
	//get the course at the front of the queue
	public UnivClass getCourse(){
		return courses.dequeue();
	}


}
