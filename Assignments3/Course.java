//this file contains Q1 to Q4
import java.util.*;

public class Course {
	//Q1
	//field
	private int courseId;
	private String courseName;
	private int maxCapacity;
	private int professorId;
	private int credits;
	private int[] studentIds = new int[] {};
	//Q1
	//constructor
	public Course(int courseId){
		this.courseId = courseId;
	}
	
	public Course(int courseId, int professorId){
		this(courseId);
		this.professorId = professorId;
	}
	
	public Course(int courseId, int professorId, int credits){
		this(courseId, professorId);
		this.credits = credits;
	}
	//Q1
	//method
	void registerStudent(int studentId) {
		int[] newStudentIds = new int[this.studentIds.length + 1];
		for (int i = 0; i < this.studentIds.length; i++) {
			newStudentIds[i] = this.studentIds[i];
		}
		newStudentIds[this.studentIds.length] = studentId;
		this.studentIds = newStudentIds;
	}
	//Q1
	//Q2
	//setter and getter
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		if (courseId <= 0) {
			throw new IllegalArgumentException("courseId should not be negative or 0!");
		}
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		if (courseName.length() < 10 || courseName.length() > 60) {
			throw new IllegalArgumentException("courseName length should be within 10 and 60!");
		}
		this.courseName = courseName;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		if (maxCapacity < 10 || maxCapacity > 100) {
			throw new IllegalArgumentException("maxCapacity should be within 10 and 100!");
		}
		this.maxCapacity = maxCapacity;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		if (String.valueOf(professorId).length() != 6) {
			throw new IllegalArgumentException("professorId should be a six digit integer!");
		}
		this.professorId = professorId;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		if (String.valueOf(credits).length() != 1 || credits <= 0) {
			throw new IllegalArgumentException("credits should be a single digit and greater than 0!");
		}
		this.credits = credits;
	}

	public int[] getStudentIds() {
		return studentIds;
	}

	public void setStudentIds(int[] studentIds) {
		this.studentIds = studentIds;
	}
	//Q3
	public int[] removeDuplicates(int[] studentIds) {
		Set<Integer> set = new HashSet<>();
		List<Integer> ids = new ArrayList<>();
		for (int i : studentIds) {
			if (set.contains(Integer.valueOf(i))) {
				continue;
			}else {
				set.add(i);
				ids.add(i);
			}
		}
		int[] newStudentIds = new int[ids.size()];
		for (int i =0; i < ids.size(); i++) {
			newStudentIds[i] = ids.get(Integer.valueOf(i));
		}
		return newStudentIds;
		
	}
	//Q4
	public int groupsOfStudents(int[] studentIds) {
		Set<Integer> even = new HashSet<>();
		Set<Integer> odd = new HashSet<>();
		for (int i = 0; i < studentIds.length; i++) {
			if (i % 2 != 0) {
				odd.add(i);
			}else {
				even.add(i);
			}
		}
		return cnk(even.size()) + cnk(odd.size());
	}
	
	public static int factorial(int x) {
		if (x < 0) {
			throw new IllegalArgumentException("x must be>=0");
		}
		int fact = 1;
		for (int i = 2; i <= x; i++) {
			fact *= i;
		}
		return fact;
	}
	
	public static int cnk(int n) {
		if (n < 2) {
			return 0;
		}else {
			return factorial(n) / (2 * factorial(n - 2));
		}
	}
}
