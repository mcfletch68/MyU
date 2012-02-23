package university.gui.domain;

import java.io.Serializable;
import java.util.Date;
/**this class should have a corresponding form whenever an student is created
 * the user will have the option of entering in a student's information
 * including the student's major, minor and the 
 * classes a student will take for whichever semester as well!
 * all this information will be kept on file and the student will show up on the each class' 
 * roster (which will have a frame of its own as well.*/
public class Student implements Serializable {
	//studentIDs keeps track of number of students in a course
	protected static int studentIDs;
	//studentNo is the student's school ID
	private int studentNo;
	
	private String firstName;
	private String middleName;
	private String lastName;
	private Integer age; //not saving yet
	private Date DOB;  //not saving yet
	private String address;
	private String sex;
	private String classification;
	private Double gpa; //not saving yet
	private String race;
	private String nationality;
	private String ethnicity;
	
	public Student(){
		studentIDs = studentIDs + 1;
		studentNo = 0;
		firstName = null;
		middleName = null;
		lastName = null;
		age = 0;
		DOB = null;
		address = null;
		sex = address;
		classification = null;
		gpa = 0.0;
		race = null;
		nationality = null;
		ethnicity = null;
	}

	//Before using the Instructor constructor create a Date object for DOB
	//by doing the following: Date d = new Date(year, month, day)...
	public Student(int studentNo, String firstName, String middleName, String lastName, Integer age, Date DOB,
			String address, String sex, String classification, Double gpa, String race, String nationality, String ethnicity){
		studentIDs = studentIDs + 1;
		this.studentNo = studentNo;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
		this.DOB = DOB;
		this.address = address;
		this.sex = sex;
		this.classification = classification;
		this.gpa = gpa;
		this.race = race;
		this.nationality = nationality;
		this.ethnicity = ethnicity;
		
	}
	//methods to retrieve the values of instance variables
	public int getStudentID(){
		return studentIDs;
	}
	public int getStudentNo(){
		return studentNo;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getMiddleName(){
		return middleName;
	}
	public String getLastName(){
		return lastName;
	}
	public int getAge(){
		return age;
	}
	public Date getDOB(){
		return DOB;
	}
	public String getAddress(){
		return address;
	}
	public String getSex(){
		return sex;
	}
	public String getClassification(){
		return classification;
	}
	public double getGPA(){
		return gpa;
	}
	public String getRace(){
		return race;
	}
	public String getNationality(){
		return nationality;
	}
	public String getEthnicity(){
		return ethnicity;
	}
	//methods to set instance variables
	public void setStudentNo(int sno){
		studentNo = sno;
	}
	public void setFirstName(String fn){
		firstName = fn;
	}
	public void setMiddleName(String mn){
		middleName = mn;
	}
	public void setLastName(String ln){
		lastName = ln;
	}
	public void setAge(int a){
		age = a;
	}
	public void setDOB(Date d){
		DOB = d;
	}
	public void setAddress(String add){
		address = add;
	}
	public void setSex(String s){
		sex = s;
	}
	public void setClassification(String cl){
		classification = cl;
	}
	public void setGPA(double grade){
		gpa = grade;
	}
	public void setRace(String r){
		race = r;
	}
	public void setNationality(String nat){
		nationality = nat;
	}
	public void setEthnicity(String ethnic){
		ethnicity = ethnic;
	}
}
