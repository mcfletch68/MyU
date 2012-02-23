package university.gui.domain;

import java.io.Serializable;

//college object contains departments 
public class College implements Serializable{
	private String collegeName;
	private int noOfDepart;
	private QueueADT<Department> departments;
	public College(String n, int dp){
		//set name of college
		collegeName = n;
		//set number of departments it has
		noOfDepart = dp;
		//set array of departments to empty
		departments = new QueueADT<Department>(Department.class);
		
	}
	public String getCollege(){
		return collegeName;
	}
	//lets add the department
	public void setDepartment( Department d){
		departments.enqueue(d);
	}
	//get department name
	public Department getDepartment(){
		return departments.dequeue();
	}

}
