package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class EditExpenseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FERService ferService = new FERServiceImpl();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Expense expense = new Expense();

		String Priceobj = request.getParameter("price");
		int price = Integer.parseInt(Priceobj);
		String numberOfItemsobj = request.getParameter("numberOfItems");
		int numberOfItems = Integer.parseInt(numberOfItemsobj);
		String totalobj = request.getParameter("total");
		int total = Integer.parseInt(totalobj);

		expense.setId(Integer.parseInt(session.getAttribute("id").toString()));
		expense.setExpensetype(request.getParameter("expenseType"));
		expense.setDate(request.getParameter("date"));
		expense.setPrice(price);
		expense.setNumberofitems(numberOfItems);
		expense.setTotal(total);
		expense.setBywhom(request.getParameter("bywhom"));
		boolean editExpenseFlag = ferService.editExpense(expense);
		if (editExpenseFlag) {
			HTMLUtil.generateHeaderAndLeftFrame(out, "username".toString());
			out.println("Entry field successfully");
		} else {
			out.print("Unable to edit...");
			out.println("<a href=\"javascript:history.go(-1)\">Back</a>");
		}
		HTMLUtil.generateFooter(out);

	}

}
