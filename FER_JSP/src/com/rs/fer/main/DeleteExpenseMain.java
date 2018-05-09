package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.DBUtil.DBUtil;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class DeleteExpenseMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		boolean deleteExpenseFlag = ferService.deleteExpense(3);
		if (deleteExpenseFlag) {
			System.out.println("delete successfully");
		} else {
			System.out.println("delete failed");
		}

	}

}
