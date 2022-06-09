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
        <h2>Map Course</h2>
        <div>
            <div>
                <form:form action="/nap-course/${student.sid}/${course.cid}" method="post">
                    <div>
                        <div>
                            
                            <select name="course">
							    <c:forEach items="${courses}" var="c">
							        <option value="${c.cid}">${c.courseName}</option>
							    </c:forEach>
							</select>
                            
                        </div>
                        <div>
                            
                            <select name="student">
							    <c:forEach items="${students}" var="s">
							        <option value="${s.sid}">${s.sname}</option>
							    </c:forEach>
							</select>
                            
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