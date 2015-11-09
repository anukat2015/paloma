<%@page import="com.paloit.paloma.google.GoogleAuthHelper"%>
<html>
<body>
<%
	final GoogleAuthHelper helper = new GoogleAuthHelper();
	out.println("<a href='" + helper.buildLoginUrl()
							+ "'>log in with google</a>");
	if (null != request.getParameter("code")){
		out.println(helper.getUserInfoJson(request.getParameter("code")));
	}
%>
<h2>Hello lala!</h2>
</body>
</html>
