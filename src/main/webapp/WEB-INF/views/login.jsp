<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- Hero Section -->
<div class="container-fluid bg-primary py-5 hero-header mb-5">
  <div class="row py-3">
    <div class="col-12 text-center">
      <h1 class="display-3 text-white animated zoomIn">Login</h1>
      <a href="/" class="h4 text-white">Home</a>
      <i class="far fa-circle text-white px-2"></i>
      <a href="login" class="h4 text-white">Sign In</a>
    </div>
  </div>
</div>

<!-- Login Form -->
<div class="container-fluid my-5">
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-6 bg-white p-5 rounded shadow">
        <h2 class="text-center text-primary mb-4">Welcome Back</h2>

        <c:if test="${error != null}">
          <div class="alert alert-danger">${error}</div>
        </c:if>

        <form action="login" method="post">
          <div class="mb-3">
            <label class="form-label">Email Address</label>
            <input type="email" name="email" class="form-control" placeholder="Enter email" required />
          </div>
          <div class="mb-3">
            <label class="form-label">Password</label>
            <input type="password" name="password" class="form-control" placeholder="Enter password" required />
          </div>
          <div class="d-grid">
            <button type="submit" class="btn btn-primary py-2">Login</button>
          </div>
          <p class="text-center mt-3">
            Don’t have an account? <a href="register">Register here</a>
          </p>
        </form>
      </div>
    </div>
  </div>
</div>


