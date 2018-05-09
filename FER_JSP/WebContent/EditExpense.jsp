<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,java.lang.*,java.util.*,com.rs.fer.bean.Expense,java.lang.*"%>
<jsp:useBean id="expense" class="com.rs.fer.bean.Expense"
	scope="session" />
<jsp:setProperty property="*" name="expense" />

<%
	FERService ferService = new FERServiceImpl();
	String idobj = request.getParameter("id");
	int id = Integer.parseInt(idobj);

	session.setAttribute("id", request.getParameter("id"));

	expense = ferService.getExpense(id);
	if (expense != null) {
%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<table border='1' align='center'>
	<tr height='50px'>
		<td align='center' colspan='2'>Edit Expense</td>
	</tr>

	<tr>
		<td>Expense Type</td>
		<td><input type='text' name='expensetype'
			value="<%=expense.getExpensetype()%>"></td>


	</tr>
	<tr>
		<td>Date</td>
		<td><input type='text' name='date' value="<%=expense.getDate()%>"></td>


	</tr>
	<tr>
		<td>Price</td>
		<td><input type='text' name='price'
			value="<%=expense.getPrice()%>"></td>


	</tr>
	<tr>
		<td>Number Of Items</td>
		<td><input type='text' name='numberofitems'
			value="<%=expense.getNumberofitems()%>"></td>


	</tr>
	<tr>
		<td>TotalAmount</td>
		<td><input type='text' name='total'
			value="<%=expense.getTotal()%>"></td>


	</tr>
	<tr>
		<td>ByWhom</td>
		<td><input type='text' name='bywhom'
			value="<%=expense.getBywhom()%>"></td>


	</tr>
	<tr>
		<td colspan='2' align='center'><input type='submit' value='edit'
			onclick='javascript:submitForm("EditExpensePost.jsp")'></td>
	</tr>
</table>
<jsp:include page="Footer.jsp" />
<%
	}

	else {
%>

Unable To Show The Expenses Due To Invalid Id
<%
	}
%>