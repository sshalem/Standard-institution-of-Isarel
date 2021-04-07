package com.sii.DBinitialize;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sii.common.ConstantList;
import com.sii.dao.CourseDaoImpl;
import com.sii.dao.StudentDaoImpl;
import com.sii.entity.Course;
import com.sii.entity.Student;

@Component
public class DataBaseInitializer implements CommandLineRunner {

	@Autowired
	private AssignRegister assignRegister;

	@Autowired
	private StudentDaoImpl studentDaoImpl;

	@Autowired
	private CourseDaoImpl courseDaoImpl;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {

		/**
		 * this method initialize the DB with students. After app runs, this method will
		 * be executed and update Students to DB
		 */
		createNewStudents();

		/**
		 * Create Courses
		 */
		createNewCourses();

		/**
		 * in this method I ASSIGN Student to Course For example: assign students to
		 * JAVA. I will assign multiple students to Course or Courses. NOTE: I can also
		 * register the Student to a course here so the Student , once he is logged in ,
		 * will immediately will see that he is registered to a course. the second
		 * option is that the Student him self will register to a course/courses.
		 */

		/**
		 * this method : 1. initialize the DB with courses 2. add the course to the
		 * Student_Course tabel in DB
		 */

		initCoursesandStudentCoursesWithOutRegitrationDate();

	}

	public void createNewStudents() {
		// (firstName, lastName, StudentIdentity, password, email)
		createStudent("אודל", "שלם", StudentID.ODEL, "odel", "odel.shalem@gmail.com");
		createStudent("אביגיל", "שלם", StudentID.AVIGAIL, "avigail", "avigail.shalem@gmail.com");
		createStudent("אריאל", "שלם", StudentID.ARIEL, "ariel", "ariel.shalem@gmail.com");
		createStudent("איתמר", "שלם", StudentID.ITAMAR, "itamar", "itamar.shalem@gmail.com");
		createStudent("גבי", "ברק", StudentID.GABI, "gabi", "gabi.barak@gmail.com");
		createStudent("דני", "ברק", StudentID.DANI, "dani", "dani.barak@gmail.com");
		createStudent("רפי", "שלם", StudentID.RAFI, "rafi", "rafi.shalem@gmail.com");
		createStudent("ערן", "כהן", StudentID.ERAN, "eran", "eran.cohen@gmail.com");
	}

	public void createStudent(String firstName, String lastName, String studentIdentity, String password,
			String email) {
		Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setStudentIdentity(studentIdentity);
		student.setEncryptedPassword(passwordEncoder.encode(password));
		student.setEmail(email);
		studentDaoImpl.createStudent(student);
	}

	public void createNewCourses() {
		// (courseNumber, courseName, year, startDate, endDate)
		createCourse(6077, ConstantList.SQL, 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		createCourse(7026, ConstantList.HTML, 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		createCourse(8091, ConstantList.CSS, 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		createCourse(9003, ConstantList.HISTORY, 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		createCourse(1565, ConstantList.GEOGRAPHY, 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		createCourse(2517, ConstantList.ALGEBRA, 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		createCourse(5044, ConstantList.REACT, 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		createCourse(2525, ConstantList.HASHMAL, 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		createCourse(2500, ConstantList.STATISTICS, 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		createCourse(4015, ConstantList.ANGULAR, 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		createCourse(3027, ConstantList.JAVASCRIPT, 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		createCourse(2009, ConstantList.PYTHON, 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		createCourse(1001, ConstantList.JAVA, 2021, LocalDate.of(2021, 3, 29), LocalDate.of(2021, 6, 1));
	}

	public void createCourse(int courseNumber, String courseName, int year, LocalDate startDate, LocalDate endDate) {
		Course course = new Course();
		course.setCourseNumber(courseNumber);
		course.setCourseName(courseName);
		course.setYear(year);
		course.setStartDate(startDate);
		course.setEndDate(endDate);
		courseDaoImpl.createCourse(course);
	}

	private void initCoursesandStudentCoursesWithOutRegitrationDate() {
		// create Course
		// Create StudentCourse , here we assign a Course to a Student(or students)
		// studentIdentity
		// So when we want to get a list of Course per Student ,
		// the student will see only the course he took , or wants to take.
		// Even if i give a registration date , I don't set the Registration Date ,
		// because the Student Himself need to do
		// But for the example in some StudentCourses I am registering the date
		java();
		python();
		javascript();
		angular();
		statistics();
		hashmal();
		react();
		sql();
		html();
		css();
		history();
		geography();
		algebra();
	}

	private void java() {
		assignRegister.assignStudentToCourse(ConstantList.JAVA, StudentID.RAFI);
		assignRegister.assignStudentToCourse(ConstantList.JAVA, StudentID.DANI);
		assignRegister.assignStudentToCourse(ConstantList.JAVA, StudentID.ODEL);
		assignRegister.assignStudentToCourse(ConstantList.JAVA, StudentID.ARIEL);
		assignRegister.assignStudentToCourse(ConstantList.JAVA, StudentID.AVIGAIL);
		assignRegister.assignStudentToCourse(ConstantList.JAVA, StudentID.ITAMAR);
	}

	private void python() {
		assignRegister.assignStudentToCourse(ConstantList.PYTHON, StudentID.RAFI);
		assignRegister.registerStudentToCourse(ConstantList.PYTHON, StudentID.RAFI);

		assignRegister.assignStudentToCourse(ConstantList.PYTHON, StudentID.DANI);
		assignRegister.registerStudentToCourse(ConstantList.PYTHON, StudentID.DANI);

		assignRegister.assignStudentToCourse(ConstantList.PYTHON, StudentID.ODEL);
		assignRegister.registerStudentToCourse(ConstantList.PYTHON, StudentID.ODEL);

		assignRegister.assignStudentToCourse(ConstantList.PYTHON, StudentID.ARIEL);
		assignRegister.registerStudentToCourse(ConstantList.PYTHON, StudentID.ARIEL);

		assignRegister.assignStudentToCourse(ConstantList.PYTHON, StudentID.AVIGAIL);
		assignRegister.registerStudentToCourse(ConstantList.PYTHON, StudentID.AVIGAIL);

		assignRegister.assignStudentToCourse(ConstantList.PYTHON, StudentID.ITAMAR);
		assignRegister.registerStudentToCourse(ConstantList.PYTHON, StudentID.ITAMAR);
	}

	private void javascript() {
		assignRegister.assignStudentToCourse(ConstantList.JAVASCRIPT, StudentID.ODEL);
		assignRegister.assignStudentToCourse(ConstantList.JAVASCRIPT, StudentID.ARIEL);
		assignRegister.assignStudentToCourse(ConstantList.JAVASCRIPT, StudentID.AVIGAIL);
		assignRegister.assignStudentToCourse(ConstantList.JAVASCRIPT, StudentID.ITAMAR);
	}

	private void angular() {
		assignRegister.assignStudentToCourse(ConstantList.ANGULAR, StudentID.ODEL);
		assignRegister.assignStudentToCourse(ConstantList.ANGULAR, StudentID.ARIEL);
		assignRegister.assignStudentToCourse(ConstantList.ANGULAR, StudentID.AVIGAIL);
		assignRegister.assignStudentToCourse(ConstantList.ANGULAR, StudentID.ITAMAR);
		assignRegister.assignStudentToCourse(ConstantList.ANGULAR, StudentID.GABI);
	}

	private void statistics() {
		assignRegister.assignStudentToCourse(ConstantList.STATISTICS, StudentID.ODEL);
		assignRegister.assignStudentToCourse(ConstantList.STATISTICS, StudentID.ARIEL);
		assignRegister.assignStudentToCourse(ConstantList.STATISTICS, StudentID.AVIGAIL);
		assignRegister.assignStudentToCourse(ConstantList.STATISTICS, StudentID.ITAMAR);
		assignRegister.assignStudentToCourse(ConstantList.STATISTICS, StudentID.GABI);
		assignRegister.assignStudentToCourse(ConstantList.STATISTICS, StudentID.RAFI);
	}

	private void hashmal() {
		assignRegister.assignStudentToCourse(ConstantList.HASHMAL, StudentID.ARIEL);
		assignRegister.assignStudentToCourse(ConstantList.HASHMAL, StudentID.ITAMAR);
	}

	private void sql() {
		assignRegister.assignStudentToCourse(ConstantList.SQL, null);
	}

	private void html() {
		assignRegister.assignStudentToCourse(ConstantList.HTML, null);
	}

	private void css() {
		assignRegister.assignStudentToCourse(ConstantList.CSS, null);
	}

	private void react() {
		assignRegister.assignStudentToCourse(ConstantList.REACT, null);
	}

	private void algebra() {
		assignRegister.assignStudentToCourse(ConstantList.ALGEBRA, null);
	}

	private void history() {

	}

	private void geography() {

	}

}
