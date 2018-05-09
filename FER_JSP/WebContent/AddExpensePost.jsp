<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl"%>
<jsp:useBean id="expense" class="com.rs.fer.bean.Expense"
	scope="session" />
<jsp:setProperty name="expense" property="*" />
<%
	FERService ferService = new FERServiceImpl();
	boolean addExpenseFlag = ferService.addExpense(expense);
%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<c:if test="${addExpenseFlag>0}" />
<c:out value="Expense added successfully" />

<c:if test="${addExpenseFlag<0}">
	<c:out value="Unable to add expense" />
</c:if>

<jsp:include page="Footer.jsp" />
