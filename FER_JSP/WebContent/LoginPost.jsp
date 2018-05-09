<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl"%>

<%
	FERService ferService = new FERServiceImpl();
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	session.setAttribute("username", username);
	boolean loginFlag = ferService.login(username, password);
	if (loginFlag) {
		out.println("User is authorised..");
%>
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="LeftFrame.jsp"></jsp:include>
<%
	out.println("Welcome:" + username);
%>
<jsp:include page="Footer.jsp"></jsp:include>
<%
	} else {
		out.println("User is not authorized");
	}
%>