<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.PersonalInfo"%>

<jsp:useBean id="user" class="com.rs.fer.bean.User" scope="session" />
<jsp:useBean id="address" class="com.rs.fer.bean.Address"
	scope="session" />

<%
	PersonalInfo info = (PersonalInfo) session.getAttribute("info");

	String zipobj = request.getParameter("zip");
	int zip = Integer.parseInt(zipobj);

	info.getAddress().setStreetname(request.getParameter("streetname"));
	info.getAddress().setCity(request.getParameter("city"));
	info.getAddress().setTown(request.getParameter("town"));
	info.getAddress().setState(request.getParameter("state"));
	info.getAddress().setZip(zip);
	info.getAddress().setCountry(request.getParameter("country"));

	if (0 == info.getAddress().getId()) {
		info.getAddress().setId(info.getUser().getId());
	}
%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<table border='1'>
	<tr>
		<td>First Name</td>
		<td><%=info.getUser().getFirstname()%></td>
	</tr>

	<tr>
		<td>Middle Name</td>
		<td><%=info.getUser().getMiddlename()%></td>
	</tr>

	<tr>
		<td>Last Name</td>
		<td><%=info.getUser().getLastname()%></td>
	</tr>

	<tr>
		<td>Email Id</td>
		<td><%=info.getUser().getEmailid()%></td>
	</tr>

	<tr>
		<td>Mobile</td>
		<td><%=info.getUser().getMobile()%></td>
	</tr>

	<tr>
		<td>Streetname</td>
		<td><%=info.getAddress().getStreetname()%></td>
	</tr>

	<tr>
		<td>City</td>
		<td><%=info.getAddress().getCity()%></td>
	</tr>

	<tr>
		<td>Town</td>
		<td><%=info.getAddress().getTown()%></td>
	</tr>

	<tr>
		<td>State</td>
		<td><%=info.getAddress().getState()%></td>
	</tr>

	<tr>
		<td>ZipCode</td>
		<td><%=info.getAddress().getZip()%></td>
	</tr>
	<tr>
		<td>Country</td>
		<td><%=info.getAddress().getCountry()%></td>
	</tr>

	<tr>
		<td colspan='2'><input type='button' value='previous'
			onclick='javascript:submitForm("PersonalAddressInfoPost.jsp")'>
			<input type='button' value='update'
			onclick='javascript:submitForm("PersonalInfoUpdatePost.jsp")'></td>
	</tr>
</table>
<jsp:include page="Footer.jsp" />