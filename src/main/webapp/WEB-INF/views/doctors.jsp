<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Our Dentists</title>
    <meta charset="UTF-8"><img src="${doctor.photoUrl}" class="card-img-top" alt="${doctor.name}">
    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    
    <style>
        body {
            background-color: #f8f9fa;
        }
        .doctor-card img {
            height: 250px;
            object-fit: cover;
        }
        .doctor-card .card-body {
            min-height: 180px;
        }
        .section-title {
            font-weight: 600;
            color: #343a40;
            margin-bottom: 30px;
        }
    </style>
</head>
<body>

<!-- Navigation (optional) -->
<nav class="navbar navbar-expand-lg navbar-light bg-light px-3">
    <a class="navbar-brand fw-bold" href="/">🩺 Doctor Clinic</a>
</nav>

<div class="container my-5">
    <h2 class="section-title text-center">Meet Our Dentists</h2>
    <div class="row">
        <c:forEach var="doctor" items="${doctors}">
            <div class="col-md-4 mb-4">
                <div class="card doctor-card shadow-sm">
                    <img src="${pageContext.request.contextPath}${doctor.photoUrl}" class="card-img-top" alt="${doctor.name}">

                    <div class="card-body">
                        <h5 class="card-title">${doctor.name}</h5>
                        <p class="text-muted mb-1"><i class="fas fa-tooth"></i> ${doctor.specialization}</p>
                        <p class="card-text">${doctor.bio}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
