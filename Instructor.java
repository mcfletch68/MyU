package university.gui.domain;
import java.io.Serializable;
import java.util.Date;
public class Instructor implements Serializable{
	//instructorNo is the instructor's school ID
	private int instructorNo;
	private String firstName;
	private String middleName;
	private String lastName;
	private int age;
	private Date DOB;
	private String address;
	private String sex;
	private int tenure;
	private String race;
	private String nationality;
	private String ethnicity;
	
	public Instructor(){
		instructorNo = 0;
		firstName = null;
		middleName = null;
		lastName = null;
		age = 0;
		DOB = null;
		address = null;
		sex = address;
		tenure = 0;
		race = null;
		nationality = null;
		ethnicity = null;
	}

	//Before using the Instructor constructor create a Date object for DOB
	//by doing the following: Date d = new Date(year, month, day)...
	public Instructor(String firstName, String middleName, String lastName, int age, Date DOB,
			String address, String sex, int tenure, String race, String nationality, String ethnicity){
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
		this.DOB = DOB;
		this.address = address;
		this.sex = sex;
		this.tenure = tenure;
		this.race = race;
		this.nationality = nationality;
		this.ethnicity = ethnicity;
		
	}
	//methods to retrieve the values of instance variables
	public int getInstructorNo(){
		return instructorNo;
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
	public int getTenure(){
		return tenure;
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
	public void setInstructorNo(int ino){
		instructorNo = ino;
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
	public void setTenure(int t){
		tenure = t;
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
