<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
    <%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>School Management System</title>
</head>
<body>
    <div>
        <h2>New Course</h2>
        <div>
            <div>
                <form:form action="/add-course" modelAttribute="course" method="post">
                    <div>
                        <div>
                            <form:label path="courseName">Course Name</form:label>
                            <form:input type="text" id="courseName" path="courseName"/>
                            <form:errors path="courseName" />
                        </div>
                        <div>
                            <form:label path="description">Description</form:label>
                            <form:input type="text" id="description" path="description"/>
                            <form:errors path="description" />
                        </div>
                    </div>
                    <div>
                        <div>
                            <input type="submit" value="Add Course">
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
    </body>
</html>