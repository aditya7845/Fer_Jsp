package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpensesReportMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		List<Expense> expenses = ferService.getExpenseReport("movie",
				"14/7/2017", "15/7/2017");
		if (expenses != null )
			for (Expense expense : expenses) {
				System.out.println("Type=" + expense.getExpensetype());
			}
		else {
			System.out.println("No Expenses Found For the Given input");
		}
	}
}
