package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.util.HTMLUtil;

public class DisplayResetpasswordServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		HTMLUtil.generateHeaderAndLeftFrame(out, session.getAttribute("username").toString());

		out.println(" <table border='1' align='center'>");
		out.println("<tr colspan='2'>");
		out.println("<td>Current Password</td>");
		out.println("<td><input type='text' name='currentpassword' value=''></td>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td>New Password</td>");
		out.println("		<td><input type='password' name='newpassword' value=''>");
		out.println("		</td>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td>Confirm New Password</td>");
		out.println("		<td><input type='password' name='confirmnewpassword' value=''>");
		out.println("		</td>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td colspan='2' align='center'><input type='button'");
		out.println("		value='Reset Password' onclick=\"javascript:submitForm('resetpassword')\"></td>");
		out.println("	</tr>");

		out.println("</table>");
		HTMLUtil.generateFooter(out);
	}

}
