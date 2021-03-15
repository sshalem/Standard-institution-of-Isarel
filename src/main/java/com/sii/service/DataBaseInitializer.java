package com.sii.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sii.dao.CourseDaoImpl;
import com.sii.dao.StudentDaoImpl;
import com.sii.entity.Course;
import com.sii.entity.Student;
import com.sii.entity.StudentCourse;

@Component
public class DataBaseInitializer implements CommandLineRunner {

	@Autowired
	private StudentDaoImpl studentDaoImpl;

	@Autowired
	private CourseDaoImpl courseDaoImpl;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {

		/**
		 * this method initialize the DB with students.
		 * After app runs, this method will be executed and update Students to DB
		 */
		createStudents();

		/**
		 * this method :
		 * 1. initialize the DB with courses
		 * 2. add the course to the Student_Course tabel in DB
		 */
		initializeCourseAndStudentCourse();
	}

	private void createStudents() {
		String odelPassword = passwordEncoder.encode("odel");
		Student odel = new Student("אודל", "שלם", "1111", odelPassword, "odel.shalem@gmail.com");
		studentDaoImpl.createStudent(odel);

		String avigailPassword = passwordEncoder.encode("avigail");
		Student avigail = new Student("אביגיל", "שלם", "2222", avigailPassword, "avigail.shalem@gmail.com");
		studentDaoImpl.createStudent(avigail);

		String arielPassword = passwordEncoder.encode("ariel");
		Student ariel = new Student("אריאל", "שלם", "3333", arielPassword, "ariel.shalem@gmail.com");
		studentDaoImpl.createStudent(ariel);

		String itamarPassword = passwordEncoder.encode("itamar");
		Student itamar = new Student("איתמר", "שלם", "4444", itamarPassword, "itamar.shalem@gmail.com");
		studentDaoImpl.createStudent(itamar);
		
		String gabiPassword = passwordEncoder.encode("gabi");
		Student gabi = new Student("גבי", "ברק", "5555", gabiPassword, "odel.shalem@gmail.com");
		studentDaoImpl.createStudent(gabi);

		String daniPassword = passwordEncoder.encode("dani");
		Student dani = new Student("דני", "ברק", "6666", daniPassword, "avigail.shalem@gmail.com");
		studentDaoImpl.createStudent(dani);

		String rafiPassword = passwordEncoder.encode("ariel");
		Student rafi = new Student("רפי", "שלם", "7777", rafiPassword, "ariel.shalem@gmail.com");
		studentDaoImpl.createStudent(rafi);

		String eranPassword = passwordEncoder.encode("itamar");
		Student eran = new Student("ערן", "כהן", "8888", eranPassword, "itamar.shalem@gmail.com");
		studentDaoImpl.createStudent(eran);
	}

	private void initializeCourseAndStudentCourse() {
		// create Course
		Course java = new Course((int) (Math.random() * (10) + 1000), "java", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		// Create StudentCourse , here we assign a Course to a Student(or students) studentIdentity 
		// So when we want to get a list of Course per Student , 
		// the student will see only the course he took , or wants to take 
		StudentCourse rafiToJava = new StudentCourse("7777");
		StudentCourse daniToJava = new StudentCourse("6666");
		StudentCourse odelToJava = new StudentCourse("1111");
		StudentCourse arielToJava = new StudentCourse("3333");
		StudentCourse avigailToJava = new StudentCourse("2222");
		StudentCourse itamarToJava = new StudentCourse("4444");
		java.addStudentCourse(rafiToJava);
		java.addStudentCourse(arielToJava);
		java.addStudentCourse(odelToJava);
		java.addStudentCourse(daniToJava);
		java.addStudentCourse(itamarToJava);
		java.addStudentCourse(avigailToJava);
		courseDaoImpl.createCourse(java);
		
		Course python = new Course((int) (Math.random() * (20) + 2000), "python", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse rafiToPython = new StudentCourse("7777");
		StudentCourse daniToPython = new StudentCourse("6666");
		StudentCourse odelToPython = new StudentCourse("1111");
		StudentCourse arielToPython = new StudentCourse("3333");
		StudentCourse avigailToPython = new StudentCourse("2222");
		StudentCourse itamarToPython = new StudentCourse("4444");
		python.addStudentCourse(rafiToPython);
		python.addStudentCourse(daniToPython);
		python.addStudentCourse(odelToPython);
		python.addStudentCourse(arielToPython);
		python.addStudentCourse(avigailToPython);
		python.addStudentCourse(itamarToPython);		
		courseDaoImpl.createCourse(python);

		Course javascript = new Course((int) (Math.random() * (30) + 3000), "javascript", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse odelToJavascript = new StudentCourse("1111");
		StudentCourse arielToJavascript = new StudentCourse("3333");
		StudentCourse avigailToJavascript = new StudentCourse("2222");
		StudentCourse itamarToJavascript = new StudentCourse("4444");
		javascript.addStudentCourse(odelToJavascript);
		javascript.addStudentCourse(arielToJavascript);
		javascript.addStudentCourse(avigailToJavascript);
		javascript.addStudentCourse(itamarToJavascript);	
		courseDaoImpl.createCourse(javascript);

		Course angular = new Course((int) (Math.random() * (40) + 4000), "angular", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse odelToAngular = new StudentCourse("1111");
		StudentCourse arielToAngular = new StudentCourse("3333");
		StudentCourse avigailToAngular = new StudentCourse("2222");
		StudentCourse itamarToAngular = new StudentCourse("4444");
		angular.addStudentCourse(odelToAngular);
		angular.addStudentCourse(arielToAngular);
		angular.addStudentCourse(avigailToAngular);
		angular.addStudentCourse(itamarToAngular);	
		courseDaoImpl.createCourse(angular);

		Course react = new Course((int) (Math.random() * (50) + 5000), "react", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse studentCourseReact = new StudentCourse();
		react.addStudentCourse(studentCourseReact);
		courseDaoImpl.createCourse(react);

		Course sql = new Course((int) (Math.random() * (60) + 6000), "sql", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse studentCourseSql = new StudentCourse();
		sql.addStudentCourse(studentCourseSql);
		courseDaoImpl.createCourse(sql);

		Course html = new Course((int) (Math.random() * (70) + 7000), "html", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse studentCourseHtml = new StudentCourse();
		html.addStudentCourse(studentCourseHtml);
		courseDaoImpl.createCourse(html);

		Course css = new Course((int) (Math.random() * (80) + 8000), "css", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse studentCourseCss = new StudentCourse();
		css.addStudentCourse(studentCourseCss);
		courseDaoImpl.createCourse(css);
		
		Course history = new Course((int) (Math.random() * (90) + 9000), "היסטוריה", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse studentCoursehistory = new StudentCourse();
		history.addStudentCourse(studentCoursehistory);
		courseDaoImpl.createCourse(history);
		
		Course geography = new Course((int) (Math.random() * (15) + 1500), "גאוגרפיה", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse studentCourseGeography = new StudentCourse();
		geography.addStudentCourse(studentCourseGeography);
		courseDaoImpl.createCourse(geography);
		
		Course algebra = new Course((int) (Math.random() * (25) + 2500), "אלגברה", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse studentCourseAlgebra = new StudentCourse();
		algebra.addStudentCourse(studentCourseAlgebra);
		courseDaoImpl.createCourse(algebra);
		
		Course stats = new Course((int) (Math.random() * (25) + 2500), "סטטיסטיקה", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse odelToStats = new StudentCourse("1111");
		StudentCourse arielToStats = new StudentCourse("3333");
		StudentCourse avigailToStats = new StudentCourse("2222");
		StudentCourse itamarToStats = new StudentCourse("4444");
		stats.addStudentCourse(odelToStats);
		stats.addStudentCourse(arielToStats);
		stats.addStudentCourse(avigailToStats);
		stats.addStudentCourse(itamarToStats);	
		courseDaoImpl.createCourse(stats);
		
		Course hashmal = new Course((int) (Math.random() * (25) + 2500), "חשמל", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse arielToHashmal = new StudentCourse("3333");
		StudentCourse itamarToHashmal = new StudentCourse("4444");
		hashmal.addStudentCourse(arielToHashmal);
		hashmal.addStudentCourse(itamarToHashmal);
		courseDaoImpl.createCourse(hashmal);
	}
}
