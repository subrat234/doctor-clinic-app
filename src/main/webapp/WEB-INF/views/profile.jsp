<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page session="false" %>

<div class="container py-5">
    <h2 class="text-center">My Profile</h2>
    <div class="row justify-content-center">
        <div class="col-md-6 bg-light p-4 rounded shadow">
            <p><strong>Name:</strong> ${sessionScope.user.name}</p>
            <p><strong>Email:</strong> ${sessionScope.user.email}</p>
            <p><strong>Phone:</strong> ${sessionScope.user.phone}</p>
        </div>
    </div>
</div>

</body>
</html>