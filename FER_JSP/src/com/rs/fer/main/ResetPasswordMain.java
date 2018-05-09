package com.rs.fer.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.DBUtil.DBUtil;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class ResetPasswordMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		boolean resetPasswordFlag = ferService.resetPassword("xyz", "password",
				"pass");
		if (resetPasswordFlag) {
			System.out.println("user is valid");
		} else {
			System.out.println("user is invalid");
		}

	}
}
