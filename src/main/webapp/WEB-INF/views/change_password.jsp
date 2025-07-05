<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container mt-5">
    <h2 class="mb-4">Change Password</h2>
    
    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>
    <c:if test="${not empty success}">
        <div class="alert alert-success">${success}</div>
    </c:if>

    <form method="post" action="change-password">
        <div class="mb-3">
            <label>Old Password</label>
            <input type="password" class="form-control" name="oldPassword" required />
        </div>
        <div class="mb-3">
            <label>New Password</label>
            <input type="password" class="form-control" name="newPassword" required />
        </div>
        <div class="mb-3">
            <label>Confirm New Password</label>
            <input type="password" class="form-control" name="confirmPassword" required />
        </div>
        <button type="submit" class="btn btn-primary">Change Password</button>
    </form>
</div>

