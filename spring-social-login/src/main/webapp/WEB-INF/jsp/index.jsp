<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Spring Social Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />
</head>
<body>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">Spring Social Login</a>
			</div>
			<p class="navbar-text navbar-right">
				<span sec:authentication="name">Username</span> &nbsp; &nbsp; &nbsp;
				<a href="logout">Logout</a>&nbsp; &nbsp; &nbsp;
			</p>
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div class="container">
		<h1 class="col-sm-12">
			Welcome, <span sec:authentication="name">Username</span>
		</h1>
		<p class="col-sm-12 text-muted" sec:authentication="authorities">User
			authorities</p>
	</div>
</body>
</html>