package com.rs.fer.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.DBUtil.DBUtil;
import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class EditExpenseMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		Expense expense = new Expense();
		expense.setExpensetype("movie");
		expense.setDate("15/7/2017");
		expense.setPrice(200);
		expense.setNumberofitems(3);
		expense.setTotal(2);
		expense.setBywhom("me");
		expense.setId(3);

		boolean editExpenseReportFlag = ferService.editExpense(expense);

		if (editExpenseReportFlag) {
			System.out.println("edit successfully");
		} else {
			System.out.println("edit failed");
		}
	}

}
