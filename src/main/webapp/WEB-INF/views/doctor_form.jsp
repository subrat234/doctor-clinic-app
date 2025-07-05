<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Doctor Form</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">${doctor.id == null ? "Add" : "Edit"} Doctor</h2>

    <form action="<c:url value='/admin/doctors/save'/>" method="post">
        <input type="hidden" name="id" value="${doctor.id}" />

        <div class="mb-3">
            <label class="form-label">Name</label>
            <input type="text" name="name" value="${doctor.name}" class="form-control" required />
        </div>

        <div class="mb-3">
            <label class="form-label">Specialization</label>
            <input type="text" name="specialization" value="${doctor.specialization}" class="form-control" required />
        </div>

        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email" name="email" value="${doctor.email}" class="form-control" required />
        </div>

        <div class="mb-3">
            <label class="form-label">Phone</label>
            <input type="text" name="phone" value="${doctor.phone}" class="form-control" required />
        </div>

        <div class="mb-3">
            <label class="form-label">Password</label>
            <input type="password" name="password" value="${doctor.password}" class="form-control" required />
        </div>

        <div class="text-end">
            <button type="submit" class="btn btn-success">Save</button>
            <a href="<c:url value='/admin/doctors'/>" class="btn btn-secondary">Cancel</a>
        </div>
    </form>
</div>

</body>
</html>
