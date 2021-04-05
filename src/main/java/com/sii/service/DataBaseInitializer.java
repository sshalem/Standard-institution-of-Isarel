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
		 * this method initialize the DB with students. After app runs, this method will
		 * be executed and update Students to DB
		 */
		createStudents();

		/**
		 * this method : 1. initialize the DB with courses 2. add the course to the
		 * Student_Course tabel in DB
		 */
//		initializeCourseAndStudentCourse();
		
		initCoursesandStudentCoursesWithOutRegitrationDate();

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

	private void initCoursesandStudentCoursesWithOutRegitrationDate() {
		// create Course
		// Create StudentCourse , here we assign a Course to a Student(or students)
		// studentIdentity
		// So when we want to get a list of Course per Student ,
		// the student will see only the course he took , or wants to take.
		// Even if i give a registration date , I don't set the Registration Date ,
		// because the Student Himself need to do
		// But for the example in some StudentCourses I am registering the date
		int javaCourseNumber = 1001;
		Course java = new Course(javaCourseNumber, "java", 2021, LocalDate.of(2021, 3, 29), LocalDate.of(2021, 6, 1));

		StudentCourse rafiToJava = new StudentCourse();
		rafiToJava.setStudentIdentity("7777");
		rafiToJava.setCourseNumber(javaCourseNumber);

		StudentCourse daniToJava = new StudentCourse();
		daniToJava.setStudentIdentity("6666");
		daniToJava.setCourseNumber(javaCourseNumber);

		StudentCourse odelToJava = new StudentCourse();
		odelToJava.setStudentIdentity("1111");
		odelToJava.setCourseNumber(javaCourseNumber);

		StudentCourse arielToJava = new StudentCourse();
		arielToJava.setStudentIdentity("3333");
		arielToJava.setCourseNumber(javaCourseNumber);

		StudentCourse avigailToJava = new StudentCourse();
		avigailToJava.setStudentIdentity("2222");
		avigailToJava.setCourseNumber(javaCourseNumber);

		StudentCourse itamarToJava = new StudentCourse();
		itamarToJava.setStudentIdentity("4444");
		itamarToJava.setCourseNumber(javaCourseNumber);

		java.addStudentCourse(rafiToJava);
		java.addStudentCourse(arielToJava);
		java.addStudentCourse(odelToJava);
		java.addStudentCourse(daniToJava);
		java.addStudentCourse(itamarToJava);
		java.addStudentCourse(avigailToJava);
		courseDaoImpl.createCourse(java);

		/**
		 * 
		 */
		int pythonCourseNumber = 2009;
		Course python = new Course(pythonCourseNumber, "python", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse rafiToPython = new StudentCourse();
		rafiToPython.setStudentIdentity("7777");
		rafiToPython.setCourseNumber(pythonCourseNumber);
		rafiToPython.setRegistrationDate(LocalDate.of(2021, 4, 2));

		StudentCourse daniToPython = new StudentCourse();
		daniToPython.setStudentIdentity("6666");
		daniToPython.setCourseNumber(pythonCourseNumber);
		daniToPython.setRegistrationDate(LocalDate.of(2021, 4, 1));

		StudentCourse odelToPython = new StudentCourse();
		odelToPython.setStudentIdentity("1111");
		odelToPython.setCourseNumber(pythonCourseNumber);
		odelToPython.setRegistrationDate(LocalDate.of(2021, 4, 2));

		StudentCourse arielToPython = new StudentCourse();
		arielToPython.setStudentIdentity("3333");
		arielToPython.setCourseNumber(pythonCourseNumber);
		arielToPython.setRegistrationDate(LocalDate.of(2021, 4, 2));

		StudentCourse avigailToPython = new StudentCourse();
		avigailToPython.setStudentIdentity("2222");
		avigailToPython.setCourseNumber(pythonCourseNumber);
		avigailToPython.setRegistrationDate(LocalDate.of(2021, 4, 2));

		StudentCourse itamarToPython = new StudentCourse();
		itamarToPython.setStudentIdentity("4444");
		itamarToPython.setCourseNumber(pythonCourseNumber);
		itamarToPython.setRegistrationDate(LocalDate.of(2021, 4, 1));

		python.addStudentCourse(rafiToPython);
		python.addStudentCourse(daniToPython);
		python.addStudentCourse(odelToPython);
		python.addStudentCourse(arielToPython);
		python.addStudentCourse(avigailToPython);
		python.addStudentCourse(itamarToPython);
		courseDaoImpl.createCourse(python);

		/**
		 * 
		 */
		int jsCourseNumber = 3027;
		Course javascript = new Course(jsCourseNumber, "javascript", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse odelToJavascript = new StudentCourse();
		odelToJavascript.setStudentIdentity("1111");
		odelToJavascript.setCourseNumber(javaCourseNumber);
		odelToJavascript.setRegistrationDate(LocalDate.of(2021, 3, 31));

		StudentCourse arielToJavascript = new StudentCourse();
		arielToJavascript.setStudentIdentity("3333");
		arielToJavascript.setCourseNumber(javaCourseNumber);
		arielToJavascript.setRegistrationDate(LocalDate.of(2021, 3, 31));

		StudentCourse avigailToJavascript = new StudentCourse();
		avigailToJavascript.setStudentIdentity("2222");
		avigailToJavascript.setCourseNumber(javaCourseNumber);
		avigailToJavascript.setRegistrationDate(LocalDate.of(2021, 3, 31));

		StudentCourse itamarToJavascript = new StudentCourse();
		itamarToJavascript.setStudentIdentity("4444");
		itamarToJavascript.setCourseNumber(javaCourseNumber);
		itamarToJavascript.setRegistrationDate(LocalDate.of(2021, 3, 31));

		javascript.addStudentCourse(odelToJavascript);
		javascript.addStudentCourse(arielToJavascript);
		javascript.addStudentCourse(avigailToJavascript);
		javascript.addStudentCourse(itamarToJavascript);
		courseDaoImpl.createCourse(javascript);

		/**
		 * 
		 */
		int angularCourseNum = 4015;
		Course angular = new Course(angularCourseNum, "angular", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse odelToAngular = new StudentCourse();
		odelToAngular.setStudentIdentity("1111");
		odelToAngular.setCourseNumber(angularCourseNum);
		odelToAngular.setRegistrationDate(LocalDate.of(2021, 3, 31));

		StudentCourse arielToAngular = new StudentCourse();
		arielToAngular.setStudentIdentity("3333");
		arielToAngular.setCourseNumber(angularCourseNum);
		arielToAngular.setRegistrationDate(LocalDate.of(2021, 3, 31));

		StudentCourse avigailToAngular = new StudentCourse();
		avigailToAngular.setStudentIdentity("2222");
		avigailToAngular.setCourseNumber(angularCourseNum);
		avigailToAngular.setRegistrationDate(LocalDate.of(2021, 3, 31));

		StudentCourse itamarToAngular = new StudentCourse();
		itamarToAngular.setStudentIdentity("4444");
		itamarToAngular.setCourseNumber(angularCourseNum);
		itamarToAngular.setRegistrationDate(LocalDate.of(2021, 3, 31));

		angular.addStudentCourse(odelToAngular);
		angular.addStudentCourse(arielToAngular);
		angular.addStudentCourse(avigailToAngular);
		angular.addStudentCourse(itamarToAngular);
		courseDaoImpl.createCourse(angular);

		/**
		 * 
		 */
		int statsCourseNum = 2500;
		Course stats = new Course(statsCourseNum, "סטטיסטיקה", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse odelToStats = new StudentCourse();
		odelToStats.setStudentIdentity("1111");
		odelToStats.setCourseNumber(statsCourseNum);
		odelToStats.setRegistrationDate(LocalDate.of(2021, 3, 31));

		StudentCourse arielToStats = new StudentCourse();
		arielToStats.setStudentIdentity("3333");
		arielToStats.setCourseNumber(statsCourseNum);
		arielToStats.setRegistrationDate(LocalDate.of(2021, 3, 31));

		StudentCourse avigailToStats = new StudentCourse();
		avigailToStats.setStudentIdentity("2222");
		avigailToStats.setCourseNumber(statsCourseNum);
		avigailToStats.setRegistrationDate(LocalDate.of(2021, 3, 31));

		StudentCourse itamarToStats = new StudentCourse();
		itamarToStats.setStudentIdentity("4444");
		itamarToStats.setCourseNumber(statsCourseNum);
		itamarToStats.setRegistrationDate(LocalDate.of(2021, 3, 31));

		stats.addStudentCourse(odelToStats);
		stats.addStudentCourse(arielToStats);
		stats.addStudentCourse(avigailToStats);
		stats.addStudentCourse(itamarToStats);
		courseDaoImpl.createCourse(stats);

		/**
		 * in the following courses below I didn't assign any Student So in DB i should
		 * see empty Students
		 */
		int hashmalCourseNum = 2525;
		Course hashmal = new Course(hashmalCourseNum, "חשמל", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse arielToHashmal = new StudentCourse();
		arielToHashmal.setStudentIdentity("3333");
		arielToHashmal.setCourseNumber(hashmalCourseNum);
		arielToHashmal.setRegistrationDate(LocalDate.of(2021, 3, 31));

		StudentCourse itamarToHashmal = new StudentCourse();
		itamarToHashmal.setStudentIdentity("4444");
		itamarToHashmal.setCourseNumber(hashmalCourseNum);
		itamarToHashmal.setRegistrationDate(LocalDate.of(2021, 3, 31));

		hashmal.addStudentCourse(arielToHashmal);
		hashmal.addStudentCourse(itamarToHashmal);
		courseDaoImpl.createCourse(hashmal);

		/**
		 * 
		 */
		int reactCourseNum = 5044;
		Course react = new Course(reactCourseNum, "react", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse studentCourseReact = new StudentCourse();
		studentCourseReact.setCourseNumber(reactCourseNum);
		react.addStudentCourse(studentCourseReact);
		courseDaoImpl.createCourse(react);

		/**
		 * 
		 */
		int sqlCourseNum = 6077;
		Course sql = new Course(sqlCourseNum, "sql", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse studentCourseSql = new StudentCourse();
		studentCourseSql.setCourseNumber(sqlCourseNum);
		sql.addStudentCourse(studentCourseSql);
		courseDaoImpl.createCourse(sql);

		/**
		 * 
		 */
		int htmlCourseNum = 7026;
		Course html = new Course(htmlCourseNum, "html", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse studentCourseHtml = new StudentCourse();
		studentCourseHtml.setCourseNumber(htmlCourseNum);
		html.addStudentCourse(studentCourseHtml);
		courseDaoImpl.createCourse(html);

		/**
		 * 
		 */
		int cssCourseNum = 8091;
		Course css = new Course(cssCourseNum, "css", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse studentCourseCss = new StudentCourse();
		studentCourseCss.setCourseNumber(cssCourseNum);
		css.addStudentCourse(studentCourseCss);
		courseDaoImpl.createCourse(css);

		/**
		 * 
		 */
		int historyCourseNum = 9003;
		Course history = new Course(historyCourseNum, "היסטוריה", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse studentCoursehistory = new StudentCourse();
		studentCoursehistory.setCourseNumber(historyCourseNum);
		history.addStudentCourse(studentCoursehistory);
		courseDaoImpl.createCourse(history);

		/**
		 * 
		 */
		int geographyCourseNum = 1565;
		Course geography = new Course(geographyCourseNum, "גאוגרפיה", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse studentCourseGeography = new StudentCourse();
		studentCourseGeography.setCourseNumber(geographyCourseNum);
		geography.addStudentCourse(studentCourseGeography);
		courseDaoImpl.createCourse(geography);

		/**
		 * 
		 */
		int algebraCourseNum = 2517;
		Course algebra = new Course(algebraCourseNum, "אלגברה", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse studentCourseAlgebra = new StudentCourse();
		studentCourseAlgebra.setCourseNumber(algebraCourseNum);
		algebra.addStudentCourse(studentCourseAlgebra);
		courseDaoImpl.createCourse(algebra);
	}

	private void initializeCourseAndStudentCourse() {
		// create Course
		int javaCourseNumber = 1001;
		Course java = new Course(javaCourseNumber, "java", 2021, LocalDate.of(2021, 3, 29), LocalDate.of(2021, 6, 1));
		// Create StudentCourse , here we assign a Course to a Student(or students)
		// studentIdentity
		// So when we want to get a list of Course per Student ,
		// the student will see only the course he took , or wants to take
		StudentCourse rafiToJava = new StudentCourse("7777", javaCourseNumber, LocalDate.of(2021, 4, 1));
		StudentCourse daniToJava = new StudentCourse("6666", javaCourseNumber, LocalDate.of(2021, 4, 1));
		StudentCourse odelToJava = new StudentCourse("1111", javaCourseNumber, LocalDate.of(2021, 4, 1));
		StudentCourse arielToJava = new StudentCourse("3333", javaCourseNumber, LocalDate.of(2021, 4, 1));
		StudentCourse avigailToJava = new StudentCourse("2222", javaCourseNumber, LocalDate.of(2021, 4, 1));
		StudentCourse itamarToJava = new StudentCourse("4444", javaCourseNumber, LocalDate.of(2021, 4, 1));
		java.addStudentCourse(rafiToJava);
		java.addStudentCourse(arielToJava);
		java.addStudentCourse(odelToJava);
		java.addStudentCourse(daniToJava);
		java.addStudentCourse(itamarToJava);
		java.addStudentCourse(avigailToJava);
		courseDaoImpl.createCourse(java);

		int pythonCourseNumber = 2009;
		Course python = new Course(pythonCourseNumber, "python", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse rafiToPython = new StudentCourse("7777", pythonCourseNumber, LocalDate.of(2021, 4, 2));
		StudentCourse daniToPython = new StudentCourse("6666", pythonCourseNumber, LocalDate.of(2021, 4, 1));
		StudentCourse odelToPython = new StudentCourse("1111", pythonCourseNumber, LocalDate.of(2021, 4, 2));
		StudentCourse arielToPython = new StudentCourse("3333", pythonCourseNumber, LocalDate.of(2021, 4, 2));
		StudentCourse avigailToPython = new StudentCourse("2222", pythonCourseNumber, LocalDate.of(2021, 4, 2));
		StudentCourse itamarToPython = new StudentCourse("4444", pythonCourseNumber, LocalDate.of(2021, 4, 1));
		python.addStudentCourse(rafiToPython);
		python.addStudentCourse(daniToPython);
		python.addStudentCourse(odelToPython);
		python.addStudentCourse(arielToPython);
		python.addStudentCourse(avigailToPython);
		python.addStudentCourse(itamarToPython);
		courseDaoImpl.createCourse(python);

		int jsCourseNumber = 3027;
		Course javascript = new Course(jsCourseNumber, "javascript", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse odelToJavascript = new StudentCourse("1111", jsCourseNumber, LocalDate.of(2021, 3, 31));
		StudentCourse arielToJavascript = new StudentCourse("3333", jsCourseNumber, LocalDate.of(2021, 3, 31));
		StudentCourse avigailToJavascript = new StudentCourse("2222", jsCourseNumber, LocalDate.of(2021, 3, 31));
		StudentCourse itamarToJavascript = new StudentCourse("4444", jsCourseNumber, LocalDate.of(2021, 3, 31));
		javascript.addStudentCourse(odelToJavascript);
		javascript.addStudentCourse(arielToJavascript);
		javascript.addStudentCourse(avigailToJavascript);
		javascript.addStudentCourse(itamarToJavascript);
		courseDaoImpl.createCourse(javascript);

		int angularCourseNum = 4015;
		Course angular = new Course(angularCourseNum, "angular", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse odelToAngular = new StudentCourse("1111", angularCourseNum, LocalDate.of(2021, 3, 31));
		StudentCourse arielToAngular = new StudentCourse("3333", angularCourseNum, LocalDate.of(2021, 3, 31));
		StudentCourse avigailToAngular = new StudentCourse("2222", angularCourseNum, LocalDate.of(2021, 3, 31));
		StudentCourse itamarToAngular = new StudentCourse("4444", angularCourseNum, LocalDate.of(2021, 3, 31));
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
		StudentCourse odelToStats = new StudentCourse("1111", statsCourseNum, LocalDate.of(2021, 3, 31));
		StudentCourse arielToStats = new StudentCourse("3333", statsCourseNum, LocalDate.of(2021, 3, 31));
		StudentCourse avigailToStats = new StudentCourse("2222", statsCourseNum, LocalDate.of(2021, 3, 31));
		StudentCourse itamarToStats = new StudentCourse("4444", statsCourseNum, LocalDate.of(2021, 3, 31));
		stats.addStudentCourse(odelToStats);
		stats.addStudentCourse(arielToStats);
		stats.addStudentCourse(avigailToStats);
		stats.addStudentCourse(itamarToStats);
		courseDaoImpl.createCourse(stats);

		int hashmalCourseNum = 2525;
		Course hashmal = new Course(hashmalCourseNum, "חשמל", 2021, LocalDate.now(), LocalDate.of(2021, 6, 1));
		StudentCourse arielToHashmal = new StudentCourse("3333", hashmalCourseNum, LocalDate.of(2021, 3, 31));
		StudentCourse itamarToHashmal = new StudentCourse("4444", hashmalCourseNum, LocalDate.of(2021, 3, 31));
		hashmal.addStudentCourse(arielToHashmal);
		hashmal.addStudentCourse(itamarToHashmal);
		courseDaoImpl.createCourse(hashmal);
	}
}
