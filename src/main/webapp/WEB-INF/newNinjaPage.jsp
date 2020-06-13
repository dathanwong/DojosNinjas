<!doctype html>
<html lang="en">
    <head>
        <title>Title</title>
        <!-- Required meta tags -->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-6">
                    <div class="row my-2">
                        <h1>New Ninja</h1>
                    </div>
                    <form:form action="/ninjas/new" method="post" modelAttribute="ninja">
	                    <div class="row my-2">
	                        <div class="col-6">Dojo</div>
	                        <form:select path="dojo" name="dojo" id="dojo">
	                        	<c:forEach items="${dojos}" var="dojo">
	                        		<option value="${dojo.id}"><c:out value="${dojo.name}"></c:out></option>
	                        	</c:forEach>
	                        </form:select>
	                    </div>
	                    <div class="row my-2">
	                        <div class="col-6">First Name</div>
	                        <form:input path="firstName" type="text" class="col-6"/>
	                    </div>
	                    <div class="row my-2">
	                        <div class="col-6">Last Name</div>
	                        <form:input path="lastName" type="text" class="col-6"/>
	                    </div>
	                    <div class="row my-2">
	                        <div class="col-6">Age</div>
	                        <form:input path="age" type="text" class="col-6"/>
	                    </div>
	                    <div class="row my-2">
	                        <div class="col-3">
	                            <button type="submit" class="btn btn-primary">Create</button>
	                        </div>
	                    </div>
	                    <div class="row my-2">
	                        <div class="col-3">
	                            <form:errors path="*"></form:errors>
	                        </div>
	                    </div>
                    </form:form>
                </div>
            </div>
        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>