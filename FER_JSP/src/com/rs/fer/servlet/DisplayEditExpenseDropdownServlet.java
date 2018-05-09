package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class DisplayEditExpenseDropdownServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FERService ferService = new FERServiceImpl();

		List<Expense> expenses = ferService.getExpenses();

		HttpSession session = request.getSession();

		PrintWriter out = response.getWriter();

		HTMLUtil.generateHeaderAndLeftFrame(out, session.getAttribute("username").toString());

		if (expenses != null && !expenses.isEmpty()) {
			out.println("Expense ID: ");

			out.println("<select name='id'>");

			for (Expense expense : expenses) {
				out.println("<option value=" + expense.getId() + ">");
				out.println("" + expense.getId() + ", " + expense.getExpensetype() + "," + expense.getDate() + ","
						+ expense.getPrice() + "," + expense.getNumberofitems() + "," + expense.getTotal() + ","
						+ expense.getBywhom());
				out.println("</option>");

			}
			out.println("</select>");

			out.println("<input type='button' value='Edit' onclick=\"javascript:submitForm('displayEditExpense')\">");
		} else {
			out.println("No expenses are available ...");

			HTMLUtil.generateFooter(out);

		}

	}

}
