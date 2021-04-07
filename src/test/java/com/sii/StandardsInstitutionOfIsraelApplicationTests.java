package com.sii;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sii.common.ConstantList;
import com.sii.dao.CourseDaoImpl;
import com.sii.entity.Course;

@SpringBootTest
class StandardsInstitutionOfIsraelApplicationTests {

	@Autowired
	private CourseDaoImpl courseDaoImpl;

	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	void getCourseByCoursename() {
		Course java = courseDaoImpl.getCourseByCoursename(ConstantList.JAVA);

		System.out.println(java);
	}

}
