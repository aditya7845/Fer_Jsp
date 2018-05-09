<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.PersonalInfo"%>

<jsp:useBean id="address" class="com.rs.fer.bean.Address"
	scope="session" />
<jsp:useBean id="user" class="com.rs.fer.bean.User" scope="session" />

<%
	PersonalInfo info = (PersonalInfo) session.getAttribute("info");

	info.getUser().setEmailid(request.getParameter("emailid"));
	info.getUser().setMobile(request.getParameter("mobile"));

	String streetname = info.getAddress().getStreetname();
	String city = info.getAddress().getCity();
	String town = info.getAddress().getTown();
	String state = info.getAddress().getState();
	int zip = info.getAddress().getZip();
	String country = info.getAddress().getCountry();
%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<table border='1'>

	<tr>
		<td>StreetName</td>
		<td><input type='text' name='streetname'
			value='<%=info.getAddress().getStreetname()%>'></td>
	</tr>
	<tr>
		<td>Town</td>
		<td><input type='text' name='town'
			value='<%=info.getAddress().getTown()%>'></td>
	</tr>
	<tr>
		<td>City</td>
		<td><input type='text' name='city'
			value='<%=info.getAddress().getCity()%>'></td>
	</tr>
	<tr>
		<td>State</td>
		<td><input type='text' name='state'
			value='<%=info.getAddress().getState()%>'></td>
	</tr>
	<tr>
		<td>Zip</td>
		<td><input type='text' name='zip'
			value='<%=info.getAddress().getZip()%>'></td>
	</tr>
	<tr>
		<td>Country</td>
		<td><input type='text' name='country'
			value='<%=info.getAddress().getCountry()%>'></td>
	</tr>
	<tr>
		<td colspan='2' align='center'><input type='button' value='Next'
			onclick='javascript:submitForm("PersonalReviewInfoPost.jsp")'></td>
	</tr>
</table>

<jsp:include page="Footer.jsp" />
