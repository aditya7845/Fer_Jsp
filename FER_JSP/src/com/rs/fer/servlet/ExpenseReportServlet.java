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

public class ExpenseReportServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FERService ferService = new FERServiceImpl();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
  
		String expenseType = request.getParameter("expenseType");
		String fromdate = request.getParameter("fromdate");
		String todate = request.getParameter("todate");
		List<Expense> expenses = ferService.getExpenseReport(expenseType, fromdate, todate);
		HTMLUtil.generateHeaderAndLeftFrame(out, session.getAttribute("username").toString());

		if (expenses != null && !expenses.isEmpty()) {

			out.println("<table border='1' align='center'>");
			out.println("<tr height='50px'>");
			out.println("<td>Expense Type</td>");
			out.println("<td>Date</td>");
			out.println("<td>Price</td>");
			out.println("<td>Number of Items</td>");
			out.println("<td>Total</td>");
			out.println("<td>By Whom</td>");
			out.println("</tr>");

			for (Expense expense : expenses) {

				out.println("<tr>");
				out.println("<td>" + expense.getExpensetype() + "</td>");
				out.println("<td>" + expense.getDate() + "</td>");
				out.println("<td>" + expense.getPrice() + "</td>");
				out.println("<td>" + expense.getNumberofitems() + "</td>");
				out.println("<td>" + expense.getTotal() + "</td>");
				out.println("<td>" + expense.getBywhom() + "</td>");
			}
			out.println("<td colspan='2'></td></tr></table>");

		} else {
			out.println("No Expenses Found For the Given input");
			out.println("<a href=\"javascript:history.go(-1)\">Back</a>");

		}
		HTMLUtil.generateFooter(out);

	}

}
