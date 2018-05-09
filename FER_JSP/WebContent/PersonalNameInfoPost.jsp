<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.PersonalInfo"%>


<jsp:useBean id="user" class="com.rs.fer.bean.User" scope="session" />

<jsp:setProperty property="*" name="user" />
<form action="PersonalContactInfoPost.jsp">

	<jsp:include page="Header.jsp" />
	<jsp:include page="LeftFrame.jsp" />
	<%
		FERService ferservice = new FERServiceImpl();
		String username = session.getAttribute("username").toString();
		PersonalInfo info = ferservice.getPersonalInfo(username);
		session.setAttribute("info", info);
	%>
	<table border='1' align='center'>
		<tr>
			<td colspan='2' align='center'>Update Name</td>
		</tr>
		<tr>
			<td>FirstName</td>
			<td><input type='text' name='firstname'
				value='<%=info.getUser().getFirstname()%> '></td>
		</tr>
		<tr>
			<td>MiddleName</td>
			<td><input type='text' name='middlename'
				value='<%=info.getUser().getMiddlename()%> '></td>
		</tr>
		<tr>
			<td>LastName</td>
			<td><input type='text' name='lastname'
				value='<%=info.getUser().getLastname()%> '></td>
		</tr>
		<tr>
			<td colspan='2' align='center'><input type='submit'
				value='Next'></td>
		</tr>

	</table>
	<jsp:include page="Footer.jsp" />