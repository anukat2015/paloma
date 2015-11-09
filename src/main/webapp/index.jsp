<%@page import="com.paloit.paloma.google.GoogleAuthHelper"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">
</head>
<body>

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
