package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.util.HTMLUtil;

public class DisplayPersonalContactServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		PersonalInfo info = (PersonalInfo) session.getAttribute("info");

		info.getUser().setFirstname(request.getParameter("firstname"));
		info.getUser().setMiddlename(request.getParameter("middlename"));
		info.getUser().setLastname(request.getParameter("lastname"));

		PrintWriter out = response.getWriter();
		HTMLUtil.generateHeaderAndLeftFrame(out, session.getAttribute("username").toString());
		out.println("<table border='1'>");

		out.println("<tr>");
		out.println("<td>Emailid</td>");
		out.println("<td><input type='text' name='emailid' value='" + info.getUser().getEmailid() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Mobile</td>");
		out.println("<td><input type='text' name='mobile' value='" + info.getUser().getMobile() + "'></td>");

		out.println("</tr>");

		out.println("<tr>");
		out.println(
				"<td colspan='2' align='center'><input type='button' value='Next' onclick='javascript:submitForm(\"displayPersonalAddress\");'></td>");
		out.println("</tr>");
		out.println("</table>");
		HTMLUtil.generateFooter(out);

	}

}
