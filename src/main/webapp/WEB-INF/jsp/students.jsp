<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>School Management System</title>
</head>
<body>
    <div>
        <div>
            <h2>School Management System</h2>
            <hr/>
            <a href="/new-student">
                <button type="submit">Add new Student</button>
            </a> 
            <a href="/new-course">
                <button type="submit">Add new Course</button>
            </a>
            <br/><br/>
            <div>
                <div>
                    <div>Students list</div>
                </div>
                <div>
                    <table>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Address</th>
                        </tr>
                        <c:forEach var="student" items="${students}">
                            <tr>
                                <td>${student.sid}</td>
                                <td>${student.sname}</td>
                                <td>${student.address}</td>
                                <td>
                                    <a href="/${student.sid}">Edit</a>
                                    <form action="/${student.sid}/delete" method="post">
                                        <input type="submit" value="Delete" />
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div>
                    <table>
                        <tr>
                            <th>Id</th>
                            <th>Course Name</th>
                            <th>Description</th>
                        </tr>
                        <c:forEach var="course" items="${courses}">
                            <tr>
                                <td>${course.cid}</td>
                                <td>${course.courseName}</td>
                                <td>${course.description}</td>
                                <td>
                                    <a href="/${course.cid}/edit-course">Edit</a>
                                    <form action="/${course.cid}/delete-course" method="post">
                                        <input type="submit" value="Delete" />
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>