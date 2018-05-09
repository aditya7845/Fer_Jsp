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

public class DisplayPersonalReviewServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PersonalInfo info = (PersonalInfo) session.getAttribute("info");

		String zipCode = request.getParameter("zip");
		int zip = Integer.parseInt(zipCode);

		info.getAddress().setStreetname(request.getParameter("streetname"));
		info.getAddress().setTown(request.getParameter("town"));
		info.getAddress().setCity(request.getParameter("city"));
		info.getAddress().setState(request.getParameter("state"));
		info.getAddress().setZip(zip);
		info.getAddress().setCountry(request.getParameter("country"));

		PrintWriter out = response.getWriter();
		HTMLUtil.generateHeaderAndLeftFrame(out, session.getAttribute("username").toString());
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td>FirstName</td>");
		out.println("<td>" + info.getUser().getFirstname() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>MiddleName</td>");
		out.println("<td>" + info.getUser().getMiddlename() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>LastName</td>");
		out.println("<td>" + info.getUser().getLastname() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Emailid</td>");
		out.println("<td>" + info.getUser().getEmailid() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Mobile</td>");
		out.println("<td>" + info.getUser().getMobile() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Streetname</td>");
		out.println("<td>" + info.getAddress().getStreetname() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Town</td>");
		out.println("<td>" + info.getAddress().getTown() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>City</td>");
		out.println("<td>" + info.getAddress().getCity() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>State</td>");
		out.println("<td>" + info.getAddress().getState() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Zip</td>");
		out.println("<td>" + info.getAddress().getZip() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Country</td>");
		out.println("<td>" + info.getAddress().getCountry() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td colspan='2'>");
		out.println(
				"<input type='button' value='update' onclick='javascript:submitForm(\"updatePersonalInfo\");'></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<a href=\"javascript:history.go(-1)\">Back</a>");

		HTMLUtil.generateFooter(out);

	}

}
