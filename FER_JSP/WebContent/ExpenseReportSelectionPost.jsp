<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,java.lang.*,java.util.*,com.rs.fer.bean.Expense"%>
<jsp:useBean id="expense" class="com.rs.fer.bean.Expense"
	scope="session" />

<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<%
	FERService ferservice = new FERServiceImpl();
	String expensetype = request.getParameter("expensetype");
	String fromdate = request.getParameter("fromdate");
	String todate = request.getParameter("todate");

	List<Expense> expenses = ferservice.getExpenseReport(expensetype, fromdate, todate);
%>


<table align='center' border='1'>
	<tr height='50px'>
		<td>Expense Type</td>
		<td>Date</td>
		<td>Price</td>
		<td>Number of Items</td>
		<td>Total</td>
		<td>By Whom</td>
		<td colspan='2'>Action</td>
	</tr>
	<%
		for (Expense expense1 : expenses) {
	%>

	<tr>


		<td><%=expense1.getExpensetype()%></td>
		<td><%=expense1.getDate()%></td>
		<td><%=expense1.getPrice()%></td>
		<td><%=expense1.getNumberofitems()%></td>
		<td><%=expense1.getTotal()%></td>
		<td><%=expense1.getBywhom()%></td>


		<td><a href='EditExpensePost.jsp?id=<%=expense.getId()%>'>Edit</a>
			<a href='DeleteExpensePost.jsp?id=<%=expense.getId()%>'>Delete</a></td>

	</tr>

	<%
		}
	%>
</table>
<jsp:include page="Footer.jsp" />