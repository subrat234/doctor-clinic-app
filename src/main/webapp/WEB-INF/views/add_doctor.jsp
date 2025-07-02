<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Add/Edit Doctor</title></head>
<body>
    <h2>${doctor.id == null ? 'Add' : 'Edit'} Doctor</h2>
    <form action="/doctors/save" method="post">
        <input type="hidden" name="id" value="${doctor.id}" />
        Name: <input type="text" name="name" value="${doctor.name}" /><br/>
        Email: <input type="text" name="email" value="${doctor.email}" /><br/>
        Phone: <input type="text" name="phone" value="${doctor.phone}" /><br/>
        Specialization: <input type="text" name="specialization" value="${doctor.specialization}" /><br/>
        <input type="submit" value="Save"/>
    </form>
</body>
</html>
