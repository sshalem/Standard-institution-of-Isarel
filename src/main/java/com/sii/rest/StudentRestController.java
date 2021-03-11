package com.sii.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sii.facade.StudentFacade;

@RestController("/students")
public class StudentRestController {

	@Autowired
	private StudentFacade studentFacade;
	
	
}
