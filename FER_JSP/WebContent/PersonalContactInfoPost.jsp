<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.PersonalInfo"%>


<jsp:useBean id="user" class="com.rs.fer.bean.User" scope="session" />

<%
	PersonalInfo info = (PersonalInfo) session.getAttribute("info");

	info.getUser().setFirstname(request.getParameter("firstname"));
	info.getUser().setMiddlename(request.getParameter("middlename"));
	info.getUser().setLastname(request.getParameter("lastname"));

	String phone = info.getUser().getMobile();
	String email = info.getUser().getEmailid();

	session.getAttribute(("username").toString());
%>

<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<table border='1'>

	<tr>
		<td>Emailid</td>
		<td><input type='text' name='emailid'
			value='<%=info.getUser().getEmailid()%> '></td>
	</tr>
	<tr>
		<td>Mobile</td>
		<td><input type='text' name='mobile'
			value='<%=info.getUser().getMobile()%> '></td>

	</tr>

	<tr>
		<td colspan='2' align='center'><input type='button' value='Next'
			onclick='javascript:submitForm("PersonalAddressInfoPost.jsp")'></td>
	</tr>
</table>
<jsp:include page="Footer.jsp" />