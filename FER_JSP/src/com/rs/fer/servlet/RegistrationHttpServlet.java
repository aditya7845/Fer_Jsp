package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.sun.media.jfxmedia.events.NewFrameEvent;

public class RegistrationHttpServlet extends HttpServlet {

	FERService ferService = new FERServiceImpl();

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		User user = new User();
		user.setFirstname(request.getParameter("firstname"));
		user.setMiddlename(request.getParameter("middlename"));
		user.setLastname(request.getParameter("lastname"));
		user.setEmailid(request.getParameter("emailid"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setMobile(request.getParameter("mobile"));

		PrintWriter out = response.getWriter();
		boolean registrationFlag = ferService.registration(user);

		if (registrationFlag) {
			out.println("Registration Successfull");

			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
		} else {
			out.println("Unable To Register");

			out.println("<a href=\"javascript:history.go(-1)\">Back</a>");

		}
	}

}
