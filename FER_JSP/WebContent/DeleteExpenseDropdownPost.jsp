<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl"%>
<jsp:useBean id="expense" class="com.rs.fer.bean.Expense"
	scope="session" />
<%-- <jsp:setProperty property="user" name="id"/> 
 --%><jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<%
	FERService ferService = new FERServiceImpl();

	String idobj = request.getParameter("id");
	int expenseId = Integer.parseInt(idobj);

	boolean deleteExpenseFlag = ferService.deleteExpense(expenseId);
%>
<c:if test="${deleteExpenseFlag>0}" />

<c:out value="Items Deleted Successfully" />

<c:if test="${deleteExpenseFlag<0}">
	<c:out value="Unable To Delete" />
</c:if>

<jsp:include page="Footer.jsp" />