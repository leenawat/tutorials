<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Spring Social Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1 class="col-sm-12">Login</h1>
		<!--  -->
			<form action="login" method="POST">
				<div class="row col-sm-6">
					<div class="form-group">
						<label class="col-sm-3">Username</label> <span class="col-sm-9"><input
							class="form-control" type="text" name="username" /></span>
					</div>
					<br />
					<div class="form-group">
						<label class="col-sm-3">Password</label> <span class="col-sm-9"><input
							class="form-control" type="password" name="password" /></span>
					</div>

					<div class="col-sm-12">
						<input type="submit" value="Login" class="btn btn-default" />
					</div>
				</div>
			</form>
			<div class="clearfix"></div>
			<br /> <br />
			<div class="col-sm-12">
				<form action="/signin/facebook" method="POST">
					<input type="hidden" name="scope" value="public_profile" /> <input
						type="submit" value="Login using Facebook" class="btn btn-primary" />
				</form>
			</div>

			<div class="col-sm-12">
				<!-- 	        <form action="/signin/facebook" method="GET"> -->
				<!-- 	            <input type="hidden" name="scope" value="public_profile" /> -->
				<input type="button" onclick="login_moph_click()"
					value="Login using Moph Portal" class="btn btn-success" />
		</form>
	</div>
	<script type="text/javascript">
		function login_moph_click() {
			var uri = "";
			uri += 'http://ictportal.moph.go.th/oauth/authorize?';
			uri += 'client_id=8&';
			uri += 'redirect_uri='
					+ encodeURIComponent('http://localhost:8080/callback')
					+ '&';
			uri += 'response_type=code&';
			uri += 'scope=';
			window.location.href = uri;
		}
	</script>
	</div>
</body>
</html>