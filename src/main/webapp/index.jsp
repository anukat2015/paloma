<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.paloit.paloma.google.GoogleAuthHelper"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min.js"></script>
<script src='<c:url value="/resources/react-0.14.2/build/react.js"/>'></script>
<script src='<c:url value="/resources/react-0.14.2/build/react-dom.js"/>'></script>
<script type="text/babel" src='<c:url value="/resources/main.js"/>'></script>

</head>
<body>
	<div id="example"></div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6 col-md-offset-3" style="margin-top: 50px;">
				<div class="well">
					<h1>Welcome on Paloma</h1>
					<%
						final GoogleAuthHelper helper = new GoogleAuthHelper();
						out.println("Sign in : <a href='" + helper.buildLoginUrl() + "'><img src='http://www.registryvalet.com/graphics/icon_sm_google_plus.png'></a>");
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
