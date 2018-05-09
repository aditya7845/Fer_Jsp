<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.User"%>
<jsp:useBean id="user" class="com.rs.fer.bean.User" />
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<%
	FERService ferservice = new FERServiceImpl();
	String userName = session.getAttribute("username").toString();
	String password = request.getParameter("currentpassword");

	String newPassword = request.getParameter("newpassword");

	boolean resetPasswordFlag = ferservice.resetPassword(userName, password, newPassword);

	if (resetPasswordFlag) {
		out.println("Password Updated Successfully");
	} else {
		out.println("Unable to reset Password");
		out.println("<a href=\"javascript:history.go(-1)\">Back</a>");
	}
%>

<jsp:include page="Footer.jsp" />