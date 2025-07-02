<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Patients</title></head>
<body>
    <h2>Patient List</h2>
    <a href="patients/add">Add Patient</a>
    <table border="1">
        <tr><th>ID</th><th>Name</th><th>Email</th><th>Phone</th><th>Age</th><th>Actions</th></tr>
        <c:forEach var="p" items="${patients}">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.email}</td>
                <td>${p.phone}</td>
                <td>${p.age}</td>
                <td>
                    <a href="patients/edit/${p.id}">Edit</a> |
                    <a href="patients/delete/${p.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
