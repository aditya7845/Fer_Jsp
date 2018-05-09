<jsp:useBean id="address" class="com.rs.fer.bean.Address"
	scope="session" />
<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.PersonalInfo"%>

<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<%
	FERService ferService = new FERServiceImpl();

	PersonalInfo info = (PersonalInfo) session.getAttribute("info");
	boolean updateFlag = ferService.updatePersonalInfo(info.getUser(), info.getAddress());
%>

<%
	if (updateFlag) {
%>
Information Updated Succssfully

<%
	} else {
%>
Unable To Update
<%
	}
%>
<jsp:include page="Footer.jsp" />