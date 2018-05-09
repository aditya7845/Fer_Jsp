<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.Expense"%>

<jsp:useBean id="expense" class="com.rs.fer.bean.Expense"
	scope="session" />
<jsp:setProperty property="*" name="expense" />

<jsp:useBean id="ferService" class="com.rs.fer.service.FERServiceImpl"
	scope="session" />

<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<%
	expense.setId(Integer.parseInt(session.getAttribute("id").toString()));

	boolean editExpenseFlag = ferService.editExpense(expense);
%>
<c:if test="${editExpenseFlag>0}" />
<c:out value="Entry Edited Successfully" />
<c:if test="${editExpenseFlag<0}">
	<c:out value="Unable to Edit" />
</c:if>

<jsp:include page="Footer.jsp" />