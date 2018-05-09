package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class ResetPasswordServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FERService ferService = new FERServiceImpl();
		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString();
		String password = request.getParameter("currentpassword");
		String newPassword = request.getParameter("newpassword");
		boolean resetPasswordFlag = ferService.resetPassword(username, password, newPassword);
		PrintWriter out = response.getWriter();
		HTMLUtil.generateHeaderAndLeftFrame(out, username);
		if (resetPasswordFlag) {
			out.println("Password Reseted Successfully");
		} else {
			out.println("unable to reset Password");
			out.println("<a href=\"javascript:history.go(-1)\">Back</a>");

		}
		HTMLUtil.generateFooter(out);
	}
}
