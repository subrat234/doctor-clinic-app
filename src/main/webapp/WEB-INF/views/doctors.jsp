<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Doctors</title></head>
<body>
    <h2>Doctor List</h2>
    <a href="doctors/add">Add Doctor</a>
    <table border="1">
        <tr><th>ID</th><th>Name</th><th>Email</th><th>Phone</th><th>Specialization</th><th>Actions</th></tr>
        <c:forEach var="d" items="${doctors}">
            <tr>
                <td>${d.id}</td>
                <td>${d.name}</td>
                <td>${d.email}</td>
                <td>${d.phone}</td>
                <td>${d.specialization}</td>
                <td>
                    <a href="doctors/edit/${d.id}">Edit</a> |
                    <a href="doctors/delete/${d.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
