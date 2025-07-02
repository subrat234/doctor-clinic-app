<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Hero Section -->
<div class="container-fluid bg-primary py-5 hero-header mb-5">
  <div class="row py-3">
    <div class="col-12 text-center">
      <h1 class="display-3 text-white animated zoomIn">Register</h1>
      <a href="/" class="h4 text-white">Home</a>
      <i class="far fa-circle text-white px-2"></i>
      <a href="register" class="h4 text-white">Sign Up</a>
    </div>
  </div>
</div>
<!-- Hero End -->

<!-- Registration Form Start -->
<div class="container-fluid my-5">
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-6 bg-white p-5 rounded shadow">
        <h2 class="text-center text-primary mb-4">Create Your Account</h2>

        <c:if test="${error != null}">
          <div class="alert alert-danger">${error}</div>
        </c:if>

        <form action="register" method="post">
          <div class="mb-3">
            <label class="form-label">Full Name</label>
            <input type="text" name="name" class="form-control" placeholder="Enter full name"
                   value="${patient.name}" required />
          </div>

          <div class="mb-3">
            <label class="form-label">Email Address</label>
            <input type="email" name="email" class="form-control" placeholder="Enter email"
                   value="${patient.email}" required />
          </div>

          <div class="mb-3">
            <label class="form-label">Phone Number</label>
            <input type="text" name="phone" class="form-control" placeholder="Enter phone number"
                   value="${patient.phone}" required />
          </div>

          <div class="mb-3">
            <label class="form-label">Password</label>
            <input type="password" name="password" class="form-control" placeholder="Enter password" required />
          </div>

          <div class="mb-3">
            <label class="form-label">Confirm Password</label>
            <input type="password" name="confirmPassword" class="form-control" placeholder="Confirm password" required />
          </div>

          <div class="d-grid">
            <button type="submit" class="btn btn-primary py-2">Register</button>
          </div>

          <p class="text-center mt-3">
            Already have an account? <a href="login">Login here</a>
          </p>
        </form>
      </div>
    </div>
  </div>
</div>
<!-- Registration Form End -->


