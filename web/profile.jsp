
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Custom CSS -->
    <style>
        /* Custom styles for the profile page */
        body {
            background-color: #f2f2f2;
        }
        
        .card {
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }
        
        .form-control-lg {
            font-size: 1.25rem;
            padding: 0.5rem 1rem;
        }
        
        .btn-dark {
            background-color: #343a40;
            border-color: #343a40;
        }
        
        .btn-dark:hover {
            background-color: #23272b;
            border-color: #1d2124;
        }
        
        .mdi {
            font-size: 1.2rem;
        }
        
        .form-group {
            margin-bottom: 1.5rem;
        }
    </style>
</head>
<body>
    <div class="container-fluid page-body-wrapper">
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="row">
                    <div class="col-lg-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body container">
                                <form action="user" method="post">
                                    <div class="row">
                                        <div class="col-10" style="padding-left: 50px; font-size: 30px">
                                            <h2 style="color: black;margin-top: 50px;margin-bottom: 30px;">Profile</h2>
                                            <div class="form-group">
                                                <label>username</label>
                                                <input name="username" type="text" class="form-control form-control-lg" placeholder="Username" aria-label="Username" value="${user.username}">
                                            </div>
                                            <div class="form-group">
                                                <label>password</label>
                                                <input name="password" type="number" class="form-control form-control-lg" placeholder="password" aria-label="password" value="${user.password}">
                                            </div>
                                            <div class="form-group">
                                                <label>email</label>
                                                <input name="email" type="text" class="form-control form-control-lg" placeholder="email" aria-label="email" value="${user.email}">
                                            </div>
                                            <div class="form-group">
                                                <label>phone number</label>
                                                <input name="phone_number" type="number" class="form-control form-control-lg" placeholder="phone_number" aria-label="phone_number" value="${user.phone_number}">
                                            </div>
                                            <div class="form-group row">
                                                <div class="col-12" style="margin-top: 50px;margin-bottom: 50px;">
                                                    <button type="submit" class="btn btn-dark btn-icon-text">
                                                        Edit
                                                        <i class="mdi mdi-file-check btn-icon-append"></i>
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
