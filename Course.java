package hw4;

import java.util.ArrayList;

public class Course{
	private int ID;
	private String title;
	private String location;
	private int instructor;
	
	public Course(int iD, String title, int instructor, String location) {
		super();
		ID = iD;
		this.title = title;
		this.location = location;
		this.instructor = instructor;
	}
	
	public Course() {
		ID = 0;
		this.title = null;
		this.location = null;
		this.instructor = 0;
	}
	
	@Override
	public String toString() {
		return "Course [ID=" + ID + ", title=" + title + ", location=" + location + ", instructor=" + instructor + "]";
	}

	public ArrayList<Student> getRoster(){
		return null;
	}
	
	public void getClassAverage() {
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getInstructor() {
		return instructor;
	}

	public void setInstructor(int instructor) {
		this.instructor = instructor;
	}

	
	
	
}
