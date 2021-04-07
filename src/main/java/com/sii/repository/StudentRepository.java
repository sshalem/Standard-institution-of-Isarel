package com.sii.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sii.entity.Student;
import com.sii.entity.StudentCourse;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findByStudentIdentity(String studentIdentity);

	// returns Set of StudentCourse.
	// I will use this set of StudentCourse to see if a Student is registered.
	// then I will use the Student Repository to update the DB of the table
	// "StudentCourse" , so the associated table with PK and FK is updated in DB
	@Query("SELECT course FROM Student student JOIN student.studentCourse AS course WHERE student.studentIdentity=:id")
	Set<StudentCourse> getAllCoursesOfStudentRegistered(@Param("id") String studentIdentity);

	@Query("SELECT st FROM Student st WHERE st.firstName=:firstName AND st.lastName=:lastName AND st.studentIdentity=:studentIdentity")
	Student getStudentByFirstnameAndLastnameAndStudentIdentification(@Param("firstName") String firstName,
			@Param("lastName") String lastName, @Param("studentIdentity") String studentIdentity);

}

//@Query("SELECT u FROM User u")
//List<User> queryGetAllUsers();

//@Query("SELECT u FROM User u WHERE u.firstname like %?1%")
//List<User> queryOfFindByFirstname(String firstname);

//@Query("SELECT user FROM User user WHERE user.firstname=:name")
//User queryByFirstName(@Param("name") String name);

//@Query("SELECT user FROM User user WHERE user.firstname LIKE %?1%")
//List<User> queryOffindByFirstnameContains(String name);

//@Query("SELECT user FROM User user WHERE user.firstname LIKE %:name%")
//List<User> queryByFirstnameContains(@Param("name") String name);

/*
 * Here I'm returning list of posts (not users) Instead I could use the
 * following code in PostRepository which will give the same results
 * 
 */
/**
 * @Query("SELECT post FROM User user JOIN user.posts AS post WHERE
 * user.id=:id") List<Post> queryOfGetAllPostsByUserId(@Param("id") int id);
 * 
 * @Query("SELECT post FROM User user JOIN user.posts AS post WHERE
 * user.firstname=:firstname") List<Post>
 * queryOfGetAllPostsByFirstname(@Param("firstname") String firstname);
 * 
 * @Query("SELECT post FROM User user JOIN user.posts AS post WHERE
 * user.email=:email") List<Post> queryOfGetAllPostsByEmail(@Param("email")
 * String email);
 * 
 */

/**
 * @Query("SELECT user FROM User user JOIN user.posts AS post WHERE post.details
 * LIKE %?1%") List<User> findUserThatContainsInPostDetails(String details);
 */

/**
 * @Query("SELECT user FROM User user JOIN user.posts AS post WHERE post.details
 * LIKE %:details%") List<User>
 * queryByUserThatContainsInPostDetails(@Param("details") String details);
 */

/**
 * @Query("SELECT up FROM User u JOIN u.posts AS up WHERE u.id=:id AND
 * up.details LIKE %:details%") List<Post>
 * queryByUserIdAndPostsDetails(@Param("id") int id, @Param("details") String
 * details);
 * 
 * @Query("SELECT cp FROM COMPANY comp JOIN comp.coupons AS cp WHERE comp.id=:id
 * AND cp.type=:couponType") List<Coupon> findCompanyCouponByType(@Param("id")
 * long compId, @Param("couponType") CouponType type);
 */