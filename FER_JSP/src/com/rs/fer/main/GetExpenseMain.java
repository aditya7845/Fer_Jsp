package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpenseMain {

	public static void main(String[] args) {

		int expenseId = 3;
		FERService ferService = new FERServiceImpl();

		Expense expense = ferService.getExpense(expenseId);

		if (expense != null) {
			
			System.out.println("Get Expense "+ expense.getBywhom());
		} else {
			System.out.println("Get Expense failed...");
		}

	}

}
