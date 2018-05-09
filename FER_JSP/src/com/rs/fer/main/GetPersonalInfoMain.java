package com.rs.fer.main;

import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetPersonalInfoMain {

	public static void main(String[] args) {

		User user = new User();
		FERService ferService = new FERServiceImpl();

	//	PersonalInfo info = ferService.getPersonalInfo(10);

	/*	if (info != null) {
			System.out.println(" username =" + info.getUser().getUsername());

		} else {
			System.out.println("Please Enter A valid Id");
		}
*/
	}

}
