package hw4;

import java.util.ArrayList;

public class Student{
	
	private String name;
	private int ID;
	private ArrayList<Course> courses = new ArrayList<>();
	private boolean isGraduate;
	
	public Student(int ID, String name) {
		this.name = name;
		this.ID = ID;
	}
	
	public void addClass(Course course) {
		courses.add(course);
	}
	
	public Course getClass(int index) {
		return courses.get(index);
	}
	
	public void getGPA() {
		
	}
	
	public ArrayList<Course> getTranscript() {
		return courses;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public boolean isGraduate() {
		return isGraduate;
	}

	public void setGraduate(boolean isGraduate) {
		this.isGraduate = isGraduate;
	}
	
	
}