package com.sii.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sii.dto.StudentDto;
import com.sii.entity.Student;
import com.sii.facade.StudentFacade;

@RestController
@RequestMapping("/students")
@Scope("prototype")
public class StudentRestController {

	private static Logger LOGGER = LoggerFactory.getLogger(StudentRestController.class);

//	@Autowired
//	private ApplicationContext ctx;

	@Autowired
	private StudentFacade studentFacade;

	@GetMapping(path = "/get/{identity}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentDto getStudentIdentity(@PathVariable("identity") String identity) {

		LOGGER.info("return Student details to UI");
//		LOGGER.info("facade: " + studentFacade.hashCode());
//		LOGGER.info("context: " + ctx.getBean(StudentFacade.class).hashCode()); 

		Student student = studentFacade.getStudentByStudentIdentification(identity);
		StudentDto studentDto = new StudentDto(student.getStudentIdent(), student.getFirstName(), student.getLastName(),
				student.getEmail());
		LOGGER.info(" ---> " + studentDto);
		return studentDto;
	}

	@PostMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentDto updateStudentPersonalDetails(@RequestBody StudentDto studentDto) {
		LOGGER.info(" update --> " + studentDto);
		return studentFacade.updateStudentDetails(studentDto);
	}

}
