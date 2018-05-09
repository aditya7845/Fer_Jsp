<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl"%>
<jsp:useBean id="user" class="com.rs.fer.bean.User" scope="session" />
<jsp:setProperty name="user" property="*" />
<%
	FERService ferService = new FERServiceImpl();
%>
<%
	boolean registrationFlag = ferService.registration(user);
%>
<c:if test="${registrationFlag>0}" />
<c:out value="Registration Succesful" />
<jsp:include page="Login.jsp" />

<c:if test="${registrationFlag<0}">
	<c:out value="Unable To Register" />
</c:if>