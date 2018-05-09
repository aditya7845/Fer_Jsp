package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class LoginMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		boolean loginFlag = ferService.login("xyz", "pass");
		if (loginFlag) {
			System.out.println("User Is Valid");
		} else {
			System.out.println("Please Enter a Valid Username and Password");
		}

	}
}