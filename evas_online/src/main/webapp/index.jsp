<!DOCTYPE html>
<html>

<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>EVAS</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>

<div>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		crossorigin="anonymous">

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous">
		
	</script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous">
		
	</script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous">
		
	</script>
</div>

<link rel='stylesheet' type='text/css' media='screen' href='main.css'>

</head>

<body>
	<%
		if (session.getAttribute("activeAccount") == null) {
			response.sendRedirect("login.html");
		}
	%>
	<div id="logout-panel">
		<h5 class="inherit align-middle">Are you sure you wish to log
			out?</h5>
		<form class="inherit" action="LogoutServlet" method="POST">
			<input type="submit" value="Yes" type="button"
				class="btn btn-warning">
			<!-- <button id = "logout-panel-yes" type="button" class="btn btn-warning">Yes</button> -->
			<button id="logout-panel-no" type="button" class="btn btn-secondary"
				onclick="declineLogout()">No</button>
		</form>
	</div>
	<div id="overlay"></div>

	<div id="blurMe" class="container-fluid">
		<div class="row">

			<!-- logo/title: self explanatory -->
			<div id="logo" class="col-md-8">
				<h2>
					<span class="badge badge-secondary">EVAS</span> Expense
					Reimbursement
				</h2>
			</div>

			<!-- buffer div -->
			<div id="top-filler" class="col"></div>

			<!-- Here is the clickable that brings up account options such as logout -->
			<div id="account-panel" class="col-md-3 align-self-center"
				align="center">
				<div class="dropdown">
					<button id="account-button"
						class="btn btn-secondary dropdown-toggle" type="button"
						id="dropdownMenuButton" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">
						<%=session.getAttribute("activeAccount")%></button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="#">Account settings</a> <a
							class="dropdown-item" href="#">Account activity</a> <a
							id="dropdown-logout" class="dropdown-item" href="#"
							onclick="confirmLogout()">Log out</a>
					</div>
				</div>
			</div>

			<!-- banner with happy looking employees -->
			<!-- <div id="carousel-banner" class="col">
                <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel" align="center">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="banner" style="width:640px;height:240px;" src="Images/32-12_team.jpg"
                                class="d-block w-100" alt="Image failed to load">
                        </div>
                        <div class="carousel-item">
                            <img class="banner" style="width:640px;height:240px;" src="Images/32-12_hand_stack.jpg"
                                class="d-block w-100" alt="Image failed to load">
                        </div>
                        <div class="carousel-item">
                            <img class="banner" style="width:640px;height:240px;" src="Images/32-12_relaxed.jpg"
                                class="d-block w-100" alt="Image failed to load">
                        </div>
                    </div>
                </div>
            </div> -->
		</div>


		<div class="row">
			<!-- file new report button -->
			<div id="new-report" class="col-sm-4 m-3 p-3 mx-auto" align="center">
				<H4 class="inherit">Require Reimbursement?</H4>
				<h4 class="inherit">Start here:</h4>
				<!-- <h6 class="inherit">Start here:</h6> -->
				<!-- <div class="mx-auto">Owed Reimbursement?   Look no further:</div> -->
				<button type="btn" class="btn btn-warning btn-lg">File New
					Report</button>

			</div>

			<div id="recent-activity" class="col-lg-6 m-3 p-3 mx-auto">
				<H4 class="inherit" align="center">
					<a href="recent.html">Recent Activity</a>
				</H4>
				<table align="center" style="width: 100%">
					<tr>
						<th>Date</th>
						<th>Request</th>
						<th>Status</th>
					</tr>
					<tr>
						<td>9/12</td>
						<td>Transportation expense request</td>
						<td>Pending</td>
					</tr>
					<tr>
						<td>8/24</td>
						<td>Food expense request</td>
						<td>Resolved</td>
					</tr>
					<tr>
						<td>8/19</td>
						<td>Fuel Reimbursement</td>
						<td>Resolved</td>
					</tr>
				</table>
			</div>


		</div>

	</div>

	<script src="index.js"></script>
</body>

</html>