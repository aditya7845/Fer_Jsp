package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.util.HTMLUtil;

public class DisplayAddExpenseServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		HTMLUtil.generateHeaderAndLeftFrame(out, session.getAttribute("username").toString());

		out.println("<table border='10' align='center'>");
		out.println("	<tr>");
		out.println("		<td colspan='2' align='center'>Add Expense</td>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td>Expense Type</td>");
		out.println("		<td><input type='text' name='expenseType'></td>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td>Date</td>");
		out.println("		<td><input type='text' name='date'></td>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td>Price</td>");
		out.println("		<td><input type='text' name='price'></td>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td>Number Of Items</td>");
		out.println("		<td><input type='text' name='numberOfItems'></td>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td>Total</td>");
		out.println("		<td><input type='text' name='total'></td>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td>By Whom</td>");
		out.println("		<td><input type='text' name='bywhom'></td>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td colspan='2' align='center'><input type='button'");
		out.println("		value='Add Expense' onclick=\"javascript:submitForm('addExpense')\"></td>");
		out.println("	</tr>");
		out.println("</table>");

		HTMLUtil.generateFooter(out);

	}

}
