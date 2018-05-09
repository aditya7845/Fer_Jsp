<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,java.util.*,com.rs.fer.bean.Expense,java.lang.*"%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<%
	FERService ferService = new FERServiceImpl();

	session.getAttribute(("username").toString());

	List<Expense> expenses = ferService.getExpenses();
	session.setAttribute("expenses", expenses);

	if (expenses != null && !expenses.isEmpty()) {
%>

<td>ExpenseId</td>
<td><select name='id'>



		<c:forEach var="expense" items="${expenses}">
			<option value="${expense.id}">
				${expense.id},${expense.expensetype},${expense.date},
				${expense.price},${expense.numberofitems},${expense.total},${expense.bywhom}
			</option>
		</c:forEach>

</select> <input type='Submit' value='Delete'
	onclick='javascript:submitForm("DeleteExpenseDropdownPost.jsp")'></td>

<%
	} else {
%>

No expenses found...
<%
	}
%>
<jsp:include page="Footer.jsp" />

