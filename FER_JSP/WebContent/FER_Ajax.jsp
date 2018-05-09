<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%
	String username = request.getParameter("username");

	boolean isUsernameAvailabe = new FERServiceImpl().isUsernameAvailable(username);
	
	out.println(isUsernameAvailabe ? "Y" : "N");
%>