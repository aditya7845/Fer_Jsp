package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpensesMain {

	public static void main(String[] args) {
	

		FERService ferService = new FERServiceImpl();
		List<Expense> expenses = ferService.getExpenses();
		if (expenses != null){

			for (Expense expense : expenses) {
				System.out.println("expensetyppe=" + expense.getExpensetype());
			}
		}
		else {
			System.out.println("expense not found");
		}

	}
}
