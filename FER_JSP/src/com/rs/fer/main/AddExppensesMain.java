package com.rs.fer.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.DBUtil.DBUtil;
import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class AddExppensesMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		Expense expense = new Expense();

		expense.setExpensetype("family");
		expense.setDate("15/9/2017");
		expense.setPrice(100);
		expense.setNumberofitems(2);
		expense.setTotal(3);
		expense.setBywhom("ramesh");
		// expense.setRemarks("festival");

		boolean addExpenseFlag = ferService.addExpense(expense);

		if (addExpenseFlag) {

			System.out.println("Expense Add Successfully");
		}

		else {
			System.out.println("Add expense Failed");
		}

	}

}