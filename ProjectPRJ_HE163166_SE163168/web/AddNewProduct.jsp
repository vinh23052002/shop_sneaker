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
        <title>Add Product</title>
    </head>
    <body>
        <div id="logreg-forms">
            
            <form action="AddNewProduct" method="post" class="">
                <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Add New Product</h1>
                <p class="text-danger">${wrongText}</p>
                <p class="text-success">${successText}</p>
                <div>ID</div>
                <input name="id" type="txt" class="form-control"  value="${id}">
                <div>Name</div>
                <input name="name" type="txt" class="form-control" placeholder="Name Product" value="${name}">
                <div>Price</div>
                <input name="price" type="txt" class="form-control" placeholder="Price" value="${price}">

                <div>Image</div>
                <input name="image" type="file" class="form-control"  value="${email}">
                <label for="sel1" class="form-label">Category:</label>
                <select class="form-select" id="sel1" name="cid">
                        <option value="1">Nike</option>
                        <option value="2">Air Jordan</option>
                        <option value="3">Adidas</option>
                        <option value="4">New Balance</option>
                        <option value="5">Vans</option>
                        <option value="6">MLB</option>
                        <option value="7">Converse</option>
                </select>
                <button class="btn btn-primary btn-block" type="submit"><i class="fas fa-user-plus"></i> Add</button>
                <a href="ManagerProduct" ><i class="fas fa-angle-left"></i> Back</a>
            </form>
            <br>

        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        
    </body>
</html>