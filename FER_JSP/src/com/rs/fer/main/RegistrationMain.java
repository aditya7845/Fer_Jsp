package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class RegistrationMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		User user = new User();
		user.setFirstname("aaa");
		user.setMiddlename("aaaaa");
		user.setLastname("aaaaa");
		user.setEmailid("@gmail.com");
		user.setUsername("admin");
		user.setPassword("1234");
		user.setMobile("56789");

		boolean registrationFlag = ferService.registration(user);
		if (registrationFlag) {
			System.out.println("Registration Successfull");
		} else {
			System.out.println("Unable To Register");
		}

	}

}
