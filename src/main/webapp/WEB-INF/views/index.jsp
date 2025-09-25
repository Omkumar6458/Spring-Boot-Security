<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Task Management System</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="bg-light">

<div class="container mt-5">
    <!-- Header -->
    <div class="text-center mb-4">
        <h1 class="fw-bold">Task Management System</h1>
        <p class="text-muted">Manage TASK efficiently</p>
    </div>

    <!-- Show message if present -->


    <hr>

    <!-- Navigation Cards -->
    <div class="row justify-content-center mt-4">
        <div class="col-md-4">
            <div class="card shadow-sm rounded-3">
                <div class="card-body text-center">
                    <h5 class="card-title">Add Task</h5>
                    <p class="card-text"> new task assign.</p>
                    <a href="login" class="btn btn-primary">Add TASK</a>
                </div>
            </div>
        </div>

        <div class="col-md-4 mt-3 mt-md-0">
            <div class="card shadow-sm rounded-3">
                <div class="card-body text-center">
                    <h5 class="card-title">List TASK</h5>
                    <p class="card-text">View, edit, or delete TASK.</p>
                    <a href="login" class="btn btn-success">View TASK</a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
