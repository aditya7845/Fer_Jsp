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

public class DisplayPersonalAddressServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PersonalInfo info = (PersonalInfo) session.getAttribute("info");
		info.getUser().setEmailid(request.getParameter("emailid"));
		info.getUser().setMobile(request.getParameter("mobile"));

		PrintWriter out = response.getWriter();
		HTMLUtil.generateHeaderAndLeftFrame(out, session.getAttribute("username").toString());
		out.println("<table border='1'>");

		out.println("<tr>");
		out.println("<td>StreetName</td>");
		out.println("<td><input type='text' name='streetname' value='" + info.getAddress().getStreetname() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Town</td>");
		out.println("<td><input type='text' name='town' value='" + info.getAddress().getTown() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>City</td>");
		out.println("<td><input type='text' name='city' value='" + info.getAddress().getCity() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>State</td>");
		out.println("<td><input type='text' name='state'  value='" + info.getAddress().getState() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Zip</td>");
		out.println("<td><input type='text' name='zip' value='" + info.getAddress().getZip() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Country</td>");
		out.println("<td><input type='text' name='country'  value='" + info.getAddress().getCountry() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println(
				"<td colspan='2' align='center'><input type='button' value='Next' onclick='javascript:submitForm(\"displayPersonalReview\");'></td>");
		out.println("</tr>");
		out.println("</table>");

		HTMLUtil.generateFooter(out);
	}
}
