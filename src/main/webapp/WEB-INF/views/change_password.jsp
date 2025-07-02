<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container py-5">
    <h2 class="text-center">Change Password</h2>
    <div class="row justify-content-center">
        <div class="col-md-6 bg-white p-4 rounded shadow">
            <form action="change-password" method="post">
                <div class="mb-3">
                    <label class="form-label">Current Password</label>
                    <input type="password" name="currentPassword" class="form-control" required />
                </div>
                <div class="mb-3">
                    <label class="form-label">New Password</label>
                    <input type="password" name="newPassword" class="form-control" required />
                </div>
                <div class="mb-3">
                    <label class="form-label">Confirm New Password</label>
                    <input type="password" name="confirmPassword" class="form-control" required />
                </div>
                <button type="submit" class="btn btn-primary w-100">Change Password</button>
            </form>
        </div>
    </div>
</div>


</body>
</html>