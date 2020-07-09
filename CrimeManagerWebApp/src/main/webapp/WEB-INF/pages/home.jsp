<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Crime Manager</title>
</head>
<body>

	<div class="container mt-3">
		<h1 class="text-center">Crime Manager</h1>
		<c:if test="${not empty msg }">
			<div class="alert alert-success">
				<b><c:out value="${msg }"></c:out></b>
			</div>
		</c:if>
		<div class="row mt-5">
			<div class="col md-2">
				<div class="list-group">
					<a href='<c:url value="/home"></c:url>'
						class="list-group-item list-group-item-action active"> Menu </a> <a
						href="<c:url value="/add"></c:url>"
						class="list-group-item list-group-item-action">Add Crime</a> <a
						href="<c:url value="/view"></c:url>"
						class="list-group-item list-group-item-action">View Crime</a><a
						href="<c:url value="/edit"></c:url>"
						class="list-group-item list-group-item-action">Edit Crime</a>
						
				</div>
			</div>
			<div class="col-md-10">
				<c:if test="${page=='home' }">
					<h3 class="text-center">Home</h3>


				</c:if>
				<c:if test="${page=='edit' }">
					<h3 class="text-center">Edit Crime</h3>
					<br>
					<form:form action="editCrime" method="post" modelAttribute="editCrime">
						<!-- modelAttribute is on clicking the button where the data should be stored and get that data where want to call -->
						<div class="form-group">
							<form:input path="crimeTitle" cssClass="form-control"
								placeholder="Enter Title of Crime" />
							<!-- path is in which object we want to store the data -->
						</div>
						<div class="form-group">
							<form:input path="crimeContent" cssClass="form-control"
								placeholder="Enter Content of Crime" cssStyle="height:300px" />
						</div>
						<div class="form-group">
							<form:input path="index" cssClass="form-control"
								placeholder="Enter Crime Id"  cssStyle="height:30px"/>
							<!-- path is in which object we want to store the data -->
						</div>
						<div class="container text-center">
							<button class="btn btn-outline-success">Edit Crime</button>
						</div>
					</form:form>

				</c:if>
				<c:if test="${page=='add' }">
					<h3 class="text-center">Add Crime</h3>
					<br>
					<form:form action="saveCrime" method="post" modelAttribute="crime">
						<!-- modelAttribute is on clicking the button where the data should be stored and get that data where want to call -->
						<div class="form-group">
							<form:input path="crimeTitle" cssClass="form-control"
								placeholder="Enter Title of Crime" />
							<!-- path is in which object we want to store the data -->
						</div>
						<div class="form-group">
							<form:input path="crimeContent" cssClass="form-control"
								placeholder="Enter Content of Crime" cssStyle="height:300px" />
						</div>
						<div class="container text-center">
							<button class="btn btn-outline-success">Add Crime</button>
						</div>
					</form:form>
				</c:if>
				<c:if test="${page=='view' }">
					<h3 class="text-center">View Crimes</h3>

					<c:forEach items="${crimes}" var="t" varStatus="lo">

						<div class="card text-center">
							<h5 class="card-header" >Crime Details   Id - ${lo.index+1} </h5>
							<div class="card-body">
								<h5 class="card-title" ><c:out value="${t.crimeTitle }"></c:out></h5>
								<p class="card-text"><c:out value="${t.crimeContent }"></c:out></p>    
								<a href="/CrimeManagerWebApplication/delete/${lo.index }" class="btn btn-primary">Delete</a>
								<p></p>
								<h6 class="card-footer" >Created At - ${t.date }</h6>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>