import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class School {

	//TODO complete collections for instructors, courses, students
	private String name;
	private ArrayList<Student> students = new ArrayList<>();
	private ArrayList<Instructor> faculty = new ArrayList<>();
	private ArrayList<Course> courses = new ArrayList<>();
	

	public School(String name) {
		this.name = name;
		//TO DO complete this method
	}
	
	public void split(String inline, int count) {
		try {
			if(count == 0) {
				String[] tokens = inline.split("," , 4);
//				for(int i = 0; i < tokens.length; i ++) {
//					System.out.print(tokens[i] + " ");
//				}
//				System.out.println();
				Instructor x = new Instructor(Integer.parseInt(tokens[0]),  tokens[1], tokens[2], tokens[3]);
				faculty.add(x);
			} else if(count == 1) {
				String[] tokens = inline.split("," , 4);
//				for(int i = 0; i < tokens.length; i ++) {
//					System.out.print(tokens[i] + " ");
//				}
//				System.out.println();
				Course x = new Course(Integer.parseInt(tokens[0]),  tokens[1], Integer.parseInt(tokens[2]), tokens[3]);
				courses.add(x);
			} else if(count == 2) {
				String[] tokens = inline.split("," , 5);
//				for(int i = 0; i < tokens.length; i ++) {
//					System.out.print(tokens[i] + " ");
//				}
//				System.out.println();
				Student x = new Student(Integer.parseInt(tokens[0]),  tokens[1]);
				students.add(x);
			}	
		} catch(Exception e) {
			System.out.println("Bad Input");
			e.printStackTrace();
		}
	}

	public void readData(String filename) {
		//TODO complete this method
		try { 
			String data = "";
			int count = 0;
			File file = new File(filename);
			Scanner read = new Scanner(file);
			while(read.hasNextLine()) {
				int line = read.nextInt();
				read.nextLine();
				for(int i = 0; i < line; i++) {
					data = read.nextLine();
					split(data, count);
				}
				count++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}

	public void schoolInfo() {
		System.out.println("School Name: " + name);
		System.out.println("Instructor Information");
		//TODO complete this method
		for(Instructor x : faculty) {
			System.out.println(x.getName());
		}
		
		System.out.println("Course Information");
		//TODO complete this method
		for(Course x : courses) {
			System.out.println(x.getID() + " - " + x.getTitle());
		}
		
		System.out.println("Student Information");
		//TODO complete this method
		for(Student x : students) {
			System.out.println(x.getName() + ": " + x.getTranscript());
		}
	}

	public boolean addInstructor(int id, String name, String email, String phone) {
		//TODO complete this method
		for(Instructor x : faculty) {
			if(x.getID() == id) {
				System.out.println("Instructor addition failed - Employee number already used.");
				return false;
			}
		}
		
		Instructor x = new Instructor(id, name, email, phone);
		faculty.add(x);
		return true;
	}

	public boolean addCourse(int id, String title, int instructor_id, String location) {
		//TODO complete this method
		int exists = 0;
		for(Course x : courses) {
			if(x.getID() == id) {
				System.out.println("Course addition failed – Course number already used.");
				return false;
			}
		}
		
		for(Instructor x : faculty) {
			if(x.getID() == instructor_id) {
				exists++;
			}
		}
		
		if(exists == 0) {
			System.out.println("Course addition failed – Non-existing instructor.");
			return false;
		}
		
		Course x = new Course(id, title, instructor_id, location);
		courses.add(x);
		return true;
	}
	
	public boolean addStudent(int id, String name, int course_id, double grade, String letter_grade) {
		// TODO complete this method
		for(Student x : students) {
			if(x.getID() == id) {
				int exists = 0;
				if(!x.getName().equals(name)) {
					System.out.println("Student info addition failed - Student ID number already in use.");
					return false;
				}
				for(Course i : x.getTranscript()) {
					if(i.getID() == course_id) {
						exists++;
					}
				}
				
				if(exists != 0) {
					System.out.println("Student info addition failed - Student ID number already in use.");
					return false;
				}
			}	
		}
		
		int exists = 0;
		Course course = new Course();
		for(Course x : courses) {
			if(x.getID() == course_id) {
				exists ++;
				course = x;
			}
		}
		
		if(exists == 0) {
			System.out.println("Student info addition failed - Non-existing course number.");
			return false;
		}
		
		Student newStudent = new Student(id, name);
		newStudent.addClass(course);
		students.add(newStudent);
		

		return true;
	}

	public void courseInfo() {
		// this method will be complete in part 3
	}

	public void courseInfo(int id) {
		// this method will be complete in part 3
	}

	public Course getCourse(int courseId) {
		// this method will be complete in part 3
		return null;
	}

	public boolean deleteCourse(int id) {
		// this method will be complete in part 3
		return true;
	}


	public Student getStudentInfo(int id) {
		// this method will be complete in part 3
		return null;
	}

	public boolean graduateStudent(int id) {
		// this method will be complete in part 3
		return true;
	}

	public boolean register(int studentId, int courseId) {
		// this method will be complete in part 3
		return true;
	}

	public boolean grade(int studentId, int courseId, double grade, String letter_grade) {
		// this method will be complete in part 3
		return false;
	}

	public boolean drop(int studentId, int courseId) {
		// this method will be complete in part 3
		return false;
	}

	public boolean assign(int instructorId, int courseId) {
		// this method will be complete in part 3
		return true;

	}

	public boolean unassign(int instructorId, int courseId) {
		// this method will be complete in part 3
		return false;
	}


}
