package com.sii.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sii.entity.Student;
import com.sii.facade.StudentFacade;

@Service
public class StudentUserDetailsService implements UserDetailsService {

	@Autowired
	private StudentFacade studentFacade;

	@Override
	public UserDetails loadUserByUsername(String identificationNumber) throws UsernameNotFoundException {
		Student student = studentFacade.getStudentByStudentIdentification(identificationNumber);

		User user = new User(
				student.getStudentIdent(), 
				student.getEncryptedPassword(), 
				true, 
				true, 
				true, 
				true,
				new ArrayList<>());
		return user;
	}

}
