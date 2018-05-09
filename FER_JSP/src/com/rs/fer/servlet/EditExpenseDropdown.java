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

public class EditExpenseDropdown extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FERService ferservice = new FERServiceImpl();

		String idobj = request.getParameter("id");
		int id = Integer.parseInt(idobj);

		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		Expense expense = ferservice.getExpense(id);
		PrintWriter out = response.getWriter();
		HTMLUtil.generateHeaderAndLeftFrame(out, session.getAttribute("username").toString());
		if (expense != null) {
			out.println(" <table border='10' align='center'>");
			out.println(" <tr>");
			out.println("<td colspan='2' align='center'>Edit Expense</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Expense Type</td>");
			out.println("<td><input type='text' name='expenseType' value=" + expense.getNumberofitems() + "></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Date</td>");
			out.println("<td><input type='text' name='date' value=" + expense.getDate() + "></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Price</td>");
			out.println("<td><input type='text' name='price' value=" + expense.getPrice() + "></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Number Of Items</td>");
			out.println("<td><input type='text' name='numberOfItems' value=" + expense.getNumberofitems() + "></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Total</td>");
			out.println("<td><input type='text' name='total' value=" + expense.getTotal() + "></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>By Whom</td>");
			out.println("<td><input type='text' name='bywhom' value=" + expense.getBywhom() + "></td>");
			out.println("</tr>");
			out.println("<td colspan='2' align='center'><input type='button'");
			out.println("value='Edit' onclick=\"javascript:submitForm('editExpense')\"></td>");
			out.println("</tr>");
			out.println("</table>");
			HTMLUtil.generateFooter(out);

		}

	}

}
