<%@page import="com.paloit.paloma.service.google.GoogleAuthHelper"%>
<html>
<body>
<%
final GoogleAuthHelper helper = new GoogleAuthHelper();
out.println("<a href='" + helper.buildLoginUrl()
						+ "'>log in with google</a>");
%>
<h2>Hello lala!</h2>
</body>
</html>
