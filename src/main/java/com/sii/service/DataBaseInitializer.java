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
		Student gabi = new Student("גבי", "ברק", "5555", gabiPassword, "gabi.barak@gmail.com");
		studentDaoImpl.createStudent(gabi);

		String daniPassword = passwordEncoder.encode("dani");
		Student dani = new Student("דני", "ברק", "6666", daniPassword, "dani.barak@gmail.com");
		studentDaoImpl.createStudent(dani);

		String rafiPassword = passwordEncoder.encode("rafi");
		Student rafi = new Student("רפי", "שלם", "7777", rafiPassword, "rafi.shalem@gmail.com");
		studentDaoImpl.createStudent(rafi);

		String eranPassword = passwordEncoder.encode("eran");
		Student eran = new Student("ערן", "כהן", "8888", eranPassword, "eran.cohen@gmail.com");
		studentDaoImpl.createStudent(eran);
	}

	private void initializeCourseAndStudentCourse() {
		// create Course
		int javaCourseNumber = 1001;
		Course java = new Course(javaCourseNumber, "java", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		// Create StudentCourse , here we assign a Course to a Student(or students) studentIdentity 
		// So when we want to get a list of Course per Student , 
		// the student will see only the course he took , or wants to take 
		StudentCourse rafiToJava = new StudentCourse("7777", javaCourseNumber);		
		StudentCourse daniToJava = new StudentCourse("6666", javaCourseNumber);
		StudentCourse odelToJava = new StudentCourse("1111", javaCourseNumber);
		StudentCourse arielToJava = new StudentCourse("3333", javaCourseNumber);
		StudentCourse avigailToJava = new StudentCourse("2222", javaCourseNumber);
		StudentCourse itamarToJava = new StudentCourse("4444", javaCourseNumber);
		java.addStudentCourse(rafiToJava);
		java.addStudentCourse(arielToJava);
		java.addStudentCourse(odelToJava);
		java.addStudentCourse(daniToJava);
		java.addStudentCourse(itamarToJava);
		java.addStudentCourse(avigailToJava);
		courseDaoImpl.createCourse(java); 
		
		int pythonCourseNumber = 2009;
		Course python = new Course(pythonCourseNumber, "python", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse rafiToPython = new StudentCourse("7777", pythonCourseNumber);
		StudentCourse daniToPython = new StudentCourse("6666", pythonCourseNumber);
		StudentCourse odelToPython = new StudentCourse("1111", pythonCourseNumber);
		StudentCourse arielToPython = new StudentCourse("3333", pythonCourseNumber);
		StudentCourse avigailToPython = new StudentCourse("2222", pythonCourseNumber);
		StudentCourse itamarToPython = new StudentCourse("4444", pythonCourseNumber);
		python.addStudentCourse(rafiToPython);
		python.addStudentCourse(daniToPython);
		python.addStudentCourse(odelToPython);
		python.addStudentCourse(arielToPython);
		python.addStudentCourse(avigailToPython);
		python.addStudentCourse(itamarToPython);		
		courseDaoImpl.createCourse(python);

		int jsCourseNumber = 3027;
		Course javascript = new Course(jsCourseNumber, "javascript", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse odelToJavascript = new StudentCourse("1111", jsCourseNumber);
		StudentCourse arielToJavascript = new StudentCourse("3333", jsCourseNumber);
		StudentCourse avigailToJavascript = new StudentCourse("2222", jsCourseNumber);
		StudentCourse itamarToJavascript = new StudentCourse("4444", jsCourseNumber);
		javascript.addStudentCourse(odelToJavascript);
		javascript.addStudentCourse(arielToJavascript);
		javascript.addStudentCourse(avigailToJavascript);
		javascript.addStudentCourse(itamarToJavascript);	
		courseDaoImpl.createCourse(javascript);

		int angularCourseNum = 4015;
		Course angular = new Course(angularCourseNum, "angular", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse odelToAngular = new StudentCourse("1111", angularCourseNum);
		StudentCourse arielToAngular = new StudentCourse("3333", angularCourseNum);
		StudentCourse avigailToAngular = new StudentCourse("2222", angularCourseNum);
		StudentCourse itamarToAngular = new StudentCourse("4444", angularCourseNum);
		angular.addStudentCourse(odelToAngular);
		angular.addStudentCourse(arielToAngular);
		angular.addStudentCourse(avigailToAngular);
		angular.addStudentCourse(itamarToAngular);	
		courseDaoImpl.createCourse(angular);

		int reactCourseNum = 5044;
		Course react = new Course(reactCourseNum, "react", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse studentCourseReact = new StudentCourse();
		studentCourseReact.setCourseNumber(reactCourseNum);
		react.addStudentCourse(studentCourseReact);
		courseDaoImpl.createCourse(react);

		int sqlCourseNum = 6077;
		Course sql = new Course(sqlCourseNum, "sql", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse studentCourseSql = new StudentCourse();
		studentCourseSql.setCourseNumber(sqlCourseNum);
		sql.addStudentCourse(studentCourseSql);
		courseDaoImpl.createCourse(sql);

		int htmlCourseNum = 7026;
		Course html = new Course(htmlCourseNum, "html", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse studentCourseHtml = new StudentCourse();
		studentCourseHtml.setCourseNumber(htmlCourseNum);
		html.addStudentCourse(studentCourseHtml);
		courseDaoImpl.createCourse(html);

		int cssCourseNum = 8091;
		Course css = new Course(cssCourseNum, "css", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse studentCourseCss = new StudentCourse();
		studentCourseCss.setCourseNumber(cssCourseNum);
		css.addStudentCourse(studentCourseCss);
		courseDaoImpl.createCourse(css);
		
		int historyCourseNum = 9003;
		Course history = new Course(historyCourseNum, "היסטוריה", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse studentCoursehistory = new StudentCourse();
		studentCoursehistory.setCourseNumber(historyCourseNum);
		history.addStudentCourse(studentCoursehistory);
		courseDaoImpl.createCourse(history);
		
		int geographyCourseNum = 1565;
		Course geography = new Course(geographyCourseNum, "גאוגרפיה", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse studentCourseGeography = new StudentCourse();
		studentCourseGeography.setCourseNumber(geographyCourseNum);
		geography.addStudentCourse(studentCourseGeography);
		courseDaoImpl.createCourse(geography);
		
		int algebraCourseNum = 2517;
		Course algebra = new Course(algebraCourseNum, "אלגברה", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse studentCourseAlgebra = new StudentCourse();
		studentCourseAlgebra.setCourseNumber(algebraCourseNum);
		algebra.addStudentCourse(studentCourseAlgebra);
		courseDaoImpl.createCourse(algebra);
		
		int statsCourseNum = 2500;
		Course stats = new Course(statsCourseNum, "סטטיסטיקה", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse odelToStats = new StudentCourse("1111", statsCourseNum);
		StudentCourse arielToStats = new StudentCourse("3333", statsCourseNum);
		StudentCourse avigailToStats = new StudentCourse("2222", statsCourseNum);
		StudentCourse itamarToStats = new StudentCourse("4444", statsCourseNum);
		stats.addStudentCourse(odelToStats);
		stats.addStudentCourse(arielToStats);
		stats.addStudentCourse(avigailToStats);
		stats.addStudentCourse(itamarToStats);	
		courseDaoImpl.createCourse(stats);
		
		int hashmalCourseNum = 2525;
		Course hashmal = new Course(hashmalCourseNum, "חשמל", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse arielToHashmal = new StudentCourse("3333", hashmalCourseNum);
		StudentCourse itamarToHashmal = new StudentCourse("4444", hashmalCourseNum);
		hashmal.addStudentCourse(arielToHashmal);
		hashmal.addStudentCourse(itamarToHashmal);
		courseDaoImpl.createCourse(hashmal);
	}
}
