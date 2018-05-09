package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class LoginHttpServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("LoginHttpServlet.doGet()");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		FERService ferService = new FERServiceImpl();
		HttpSession session = request.getSession();
		boolean loginFlag = ferService.login(username, password);
		if (loginFlag) {
			HTMLUtil.generateHeaderAndLeftFrame(out, username);
			session.setAttribute("username", username);
			// session.setAttribute("userid", userid);

			out.println("Welcome to user: " + username);

			HTMLUtil.generateFooter(out);

		} else {
			out.println("Please Enter a Valid Username and Password");

			out.println("<a href=\"javascript:history.go(-1)\">Back</a>");
		}

		/*
		 * @Override protected void doGet(HttpServletRequest request,
		 * HttpServletResponse response) throws ServletException, IOException {
		 * System.out.println("LoginHttpServlet.doGet()"); String username =
		 * request.getParameter("username"); String password =
		 * request.getParameter("password"); PrintWriter out =
		 * response.getWriter(); FERService ferService = new FERServiceImpl();
		 * 
		 * boolean loginFlag = ferService.login(username,password ); if
		 * (loginFlag) { System.out.println("User Is Valid"); } else {
		 * System.out.println("Please Enter a Valid Username and Password"); }
		 * 
		 * if (username.equals("admin") && password.equals("admin")) {
		 * RequestDispatcher reqdis =
		 * request.getRequestDispatcher("Registration.html");
		 * reqdis.forward(request, response); } else { out.println("failed");
		 * RequestDispatcher reqdis =
		 * request.getRequestDispatcher("Registration.html");
		 * reqdis.include(request, response); } }
		 * 
		 * @Override protected void doPost(HttpServletRequest request,
		 * HttpServletResponse response) throws ServletException, IOException {
		 * 
		 * System.out.println("LoginHttpServlet.doPost()"); String username =
		 * request.getParameter("username"); String password =
		 * request.getParameter("password");
		 * 
		 * PrintWriter out = response.getWriter();
		 * 
		 * if (username.equals("admin") && password.equals("admin")) {
		 * 
		 * out.println("LHS-User is authorised"); } else
		 * 
		 * { out.println("LHS-User is not authorised"); } }
		 * 
		 * }
		 */
	}
}
