package com.rs.fer.util;

import java.io.PrintWriter;

public class HTMLUtil {

	public static void generateHeaderAndLeftFrame(PrintWriter out, String username) {
		out.println("<html>");
		out.println("<head>");
		
		out.println("<script>");
		out.println("	function submitForm(action) {");
		out.println("   	var form = document.DashboardForm; ");
		out.println("		form.action = action; ");
		out.println("		form.submit(); ");
		out.println("   }");
		out.println("</script>");
		
		out.println("</head>");

		out.println("<body>");
		out.println("<form name='DashboardForm'>");
		out.println("<table border='10' align='center' height='600px' width='800px'>");
		out.println("<tr height='100px'>");
		out.println("<td colspan='2' align='center'>Family Expense Report User: "+username);
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width='150px'>");
		out.println("<a href=\"javascript:submitForm('displayAddExpense')\">Add Expense</a><br>");
		out.println("<a href=\"javascript:submitForm('displayEditExpenseDropdown')\">Edit Expense</a><br>");
		out.println("<a href=\"javascript:submitForm('displayDeleteExpense')\">Delete Expense</a><br>");
		out.println("<a href=\"javascript:submitForm('displayExpenseReport')\">Expense Report</a><br>");
		out.println("<a href=\"javascript:submitForm('displayResetPassword')\">Reset Password</a><br>");
		out.println("<a href=\"javascript:submitForm('displayPersonalName')\">Update Personal</a><br>");
		out.println("<td>");
	}

	public static void generateFooter(PrintWriter out) {
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr height='100px'>");
		out.println("<td colspan='2' align='center'>Footer</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}
}
