<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head> 
	<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
	<title>To Do </title>  </head>
<body> 
	<%@ include file="common/navigation.jspf" %>
	<div>Hey, ${name}</div>
	<hr>
	<div class="container">
	<h1>Your Todos</h1>
	<table class="table">
		<thead>
			<tr>
				
				<th>Description</th>
				<th>Date</th>
				<th>Done?</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${todolist}" var="todo">
			<tr>
				
				<td>${todo.description}</td>
				<td>${todo.targetdate}</td>
				<td>${todo.isdone}</td>
				<td><a href="update-todo?id=${todo.id}" class="btn btn-success">UPDATE</a> </td>
				<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a> </td>
			</tr>
			
		</c:forEach>
		</tbody>
		
		
	
</table>
	<a href="add-todo" class="btn btn-success">Add-todo</a>

	</div>
	<script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.7.1/jquery.min.js"></script>

</body>
</html>