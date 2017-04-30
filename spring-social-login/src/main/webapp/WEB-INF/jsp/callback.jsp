<!DOCTYPE html>
<%@page session="true"%>
<%@page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title></title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<%
		out.println("<input type='hidden' id='code' value='" + request.getParameter("code") + "'/>");
	%>

	<script>
		var url = 'http://ictportal.moph.go.th/oauth/token';
		var method = 'POST';
		var json = {
			'grant_type' : 'authorization_code',
			'client_id' : 8,
			'client_secret' : '3LGERDIEXrMLOJHaZSVA05U6fPQXwqpE1yOoKtfh',
			'redirect_uri' : 'http://localhost:8080/callback',
			'code' : $("#code").val()
		}
		/* 'redirect_uri' : encodeURIComponent('http://localhost:8080/callback'), */
		var result;
		$.ajax({
			url : url,
			type : method,
			async : false,
			data : json,
		}).done(function(data) {
			result = data;
			console.log("success");
		}).fail(function() {
			console.log("error");
		});
		
		console.log(1);
		$.ajax({
			url : "/request_login",
			type : 'POST',
			async : false,
			data : {access_token : result.access_token},
		}).done(function(data) {
			console.log(data);
			console.log("success request_login");
		}).fail(function() {
			console.log("error request_login");
		});
		console.log(2);
	</script>
</body>