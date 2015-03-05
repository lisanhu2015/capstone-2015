<%--
  Created by IntelliJ IDEA.
  User: lsh
  Date: 15/3/2
  Time: 下午9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../../../resources/css/bootstrap.min.css"/>
    <style>
        body {
            padding-top: 10em;
            background-color: #c8c8c8;
        }

        div.well {
            background-color: #ffffff;
        }

        h3 {
            margin-bottom: 1em;
            text-align: center;
        }

        .error-message {
            margin-top: 5px;
        }

    </style>
</head>
<body>

<div class="container-fluid">
    <div class="well row col-md-4 col-md-offset-4">
        <h3>Please Login</h3>

        <form:form modelAttribute="login" method="post" role="form">
            <div class="form-group">
                <input class="form-control" type="text" name="userId" id="userId" placeholder="User Id" required/>
                <div class="text-danger error-message"><form:errors path="userId"/></div>
            </div>

            <div class="form-group">
                <input class="form-control" type="password" name="password" id="password" placeholder="Password"
                       required/>
                <div class="text-danger error-message"><form:errors path="password"/></div>
            </div>

            <div class="form-group">
                <label class="radio-inline">
                    <input type="radio" name="role" value="Student" checked/>
                    Student
                </label>
                <label class="radio-inline">
                    <input type="radio" name="role" value="Instructor"/>
                    Instructor
                </label>
                <label class="radio-inline">
                    <input type="radio" name="role" value="Officer"/>
                    Officer
                </label>
                <div class="text-danger error-message">
                    <form:errors path="role"/>

                    <c:if test="true">
                        <c:forEach items="${errors['general']}" var="error">
                            <div>${error.message}</div>
                        </c:forEach>
                    </c:if>
                </div>
            </div>

            <button class="btn btn-success btn-block" type="submit">Login</button>
        </form:form>
    </div>
</div>

<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.14/angular.min.js"></script>
</body>
</html>
