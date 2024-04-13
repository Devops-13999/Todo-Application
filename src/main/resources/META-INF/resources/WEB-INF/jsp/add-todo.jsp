<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head> 
	<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
	<title>Add To-Do</title>  </head>
<body> 
	
	<div class="container">
	<h1>Add New To-Do</h1>
	<form:form method="post" modelAttribute="todo">
				<fieldset class="mb-3">
					 <form:label path="description">Description</form:label>
					 <form:input type="text" path="description" required="required"/>
					 <form:errors path="description" cssClass="text-warning"/>
				</fieldset>	 
				
				<fieldset class="mb-3">
					 <form:label path="targetdate">Target Date</form:label>
					 <form:input type="text" path="targetdate" required="required"/>
					 <form:errors path="targetdate" cssClass="text-warning"/>
				</fieldset>	 
					 <form:input type="hidden" path="id"/>
					 <form:input type="hidden" path="isdone"/>
		<input type="submit" class="btn btn-success">
	
	</form:form>
	
	

	</div>
	<script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.7.1/jquery.min.js"></script>

</body>
</html>