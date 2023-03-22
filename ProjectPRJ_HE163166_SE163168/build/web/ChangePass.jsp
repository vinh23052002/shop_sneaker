<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <title>Change Password</title>
    </head>
    <body>
        <div id="logreg-forms">

            <form action="ChangePass" method="post" class="">
                <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Change Password </h1>
                <p class="text-danger">${wrongText}</p>
                <p class="text-success">${successText}</p>
                <div>Old Password </div>
                <input name="Oldpass" type="password" class="form-control" placeholder="Password" value="${Oldpass}">
                <div>New Password </div>
                <input name="Newpass" type="password" class="form-control" placeholder="New Password" value="${Newpass}">
                <div>Nhap lai New Password </div>
                <input name="Repass" type="password" class="form-control" placeholder="Re New Password" value="${Repass}">
                <button class="btn btn-primary btn-block" type="submit"><i class="fas fa-user-plus"></i> Change</button>
                <a href="Main" ><i class="fas fa-angle-left"></i> Back</a>
            </form>
            <br>

        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>

    </body>
</html>