<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<nav class="navbar navbar-default">
     <div class="container-fluid">
         <div class="navbar-header">
                   <a class="navbar-brand" href="http://localhost:8080/calculator">Calculator</a>
         </div>
         <ul class="nav navbar-nav navbar-left">
                     <li class="active"><a href="${pageContext.request.contextPath}/allNumbers"> All operations </a></li>
                     </ul>
                     <ul class="nav navbar-nav navbar-right">
                         <li><a>Welcome, ${sessionScope.username}</a></li>
                         <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
         </ul>
     </div>
</nav>