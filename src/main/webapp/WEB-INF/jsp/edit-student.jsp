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
        <h2>New Student</h2>
        <div>
            <div>
                <form:form action="${student.sid}/update" modelAttribute="student" method="put">
                    <div>
                        <div>
                            Id: ${student.sid}
                        </div>
                        <div>
                            <form:label path="sname">Student Name</form:label>
                            <form:input type="text" id="sname" path="sname"/>
                            <form:errors path="sname" />
                        </div>
                        <div>
                            <form:label path="address">Address</form:label>
                            <form:input type="text" id="address" path="address"/>
                            <form:errors path="address" />
                        </div>
                    </div>
                    <div>
                        <div>
                            <input type="submit" value="Update Student">
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
    </body>
</html>