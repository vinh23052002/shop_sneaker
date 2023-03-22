<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Manager Product</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>
            body {
                color: #566787;
                background: #f5f5f5;
                font-family: 'Roboto', sans-serif;
            }
            .table-responsive {
                margin: 30px 0;
            }
            .table-wrapper {
                min-width: 1000px;
                background: #fff;
                padding: 20px;
                box-shadow: 0 1px 1px rgba(0,0,0,.05);
            }
            .table-title {
                padding-bottom: 10px;
                margin: 0 0 10px;
                min-width: 100%;
            }
            .table-title h2 {
                margin: 8px 0 0;
                font-size: 22px;
            }
            .search-box {
                position: relative;
                float: right;
            }
            .search-box input {
                height: 34px;
                border-radius: 20px;
                padding-left: 35px;
                border-color: #ddd;
                box-shadow: none;
            }
            .search-box input:focus {
                border-color: #3FBAE4;
            }
            .search-box i {
                color: #a0a5b1;
                position: absolute;
                font-size: 19px;
                top: 8px;
                left: 10px;
            }
            table.table tr th, table.table tr td {
                border-color: #e9e9e9;
            }
            table.table-striped tbody tr:nth-of-type(odd) {
                background-color: #fcfcfc;
            }
            table.table-striped.table-hover tbody tr:hover {
                background: #f5f5f5;
            }
            table.table th i {
                font-size: 13px;
                margin: 0 5px;
                cursor: pointer;
            }
            table.table td:last-child {
                width: 130px;
            }
            table.table td a {
                color: #a0a5b1;
                display: inline-block;
                margin: 0 5px;
            }
            table.table td a.view {
                color: #03A9F4;
            }
            table.table td a.edit {
                color: #FFC107;
            }
            table.table td a.delete {
                color: #E34724;
            }
            table.table td i {
                font-size: 19px;
            }
            .pagination {
                float: right;
                margin: 0 0 5px;
            }
            .pagination li a {
                border: none;
                font-size: 95%;
                width: 30px;
                height: 30px;
                color: #999;
                margin: 0 2px;
                line-height: 30px;
                border-radius: 30px !important;
                text-align: center;
                padding: 0;
            }
            .pagination li a:hover {
                color: #666;
            }
            .pagination li.active a {
                background: #03A9F4;
            }
            .pagination li.active a:hover {
                background: #0397d6;
            }
            .pagination li.disabled i {
                color: #ccc;
            }
            .pagination li i {
                font-size: 16px;
                padding-top: 6px
            }
            .hint-text {
                float: left;
                margin-top: 6px;
                font-size: 95%;
            }
        </style>
        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>
    </head>
    <body>
        <div class="container-xl">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-4"><h2>Manager <b>Product</b></h2></div>
                            <div class="col-sm-4">
                                <a href="AddNewProduct.jsp" class="btn btn-success" ><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>
                                <a href="Main" class="btn btn-success" ><i class=""></i> <span>HOME</span></a>	
                            </div>
                            <div class="col-sm-4">
                                <!--                                <div class="search-box">
                                                                    <i class="material-icons">&#xE8B6;</i>
                                                                    <input type="text" class="form-control" placeholder="Search&hellip;">
                                                                </div>-->
                                <form action="ManagerProduct" method="get" class="d-flex">
                                    <input oninput="SearchProduct(this)" class="form-control me-2" type="text" placeholder="Search" name="txt" value="${txt}">
                                    <input type="submit" value="Search" class="btn btn-primary"> 
                                    <!--<button class="btn btn-primary " type="button">Search</button>-->
                                </form>
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Price</th>
                                <th>Image</th>
                                <th>Category</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listP}" var="o">
                                <tr>
                                    <td>${o.getId()}</td>
                                    <td>${o.getName()}</td>
                                    <td>${o.getPrice()}</td>
                                    <td><image src="image/${o.getImage()}" style="width: 40%"></td>
                                    <td>${Category.get(o.getCid()).getCname()}</td>
                                    <td>
                                        <!--<a href="#" class="view" title="View" data-toggle="tooltip"><i class="material-icons">&#xE417;</i></a>-->
                                        <a href="UpProduct?Pid=${o.getId()}" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                        <a href="DeleteProduct?id=${o.getId()}&pageIndex=${pageIndex}" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                                    </td>
                                </tr>
                            </c:forEach>


                        </tbody>
                    </table>
                    <div class="clearfix">
                        <div class="hint-text">Showing <b>${((nrpp>size?size:nrpp)+(pageIndex-1)*nrpp)<size?((nrpp>size?size:nrpp)+(pageIndex-1)*nrpp):size}</b> out of <b>${size}</b> entries</div>
                        <ul class="pagination">
                            <c:if test="${pageIndex>1}">
                                <c:if test="${tag==0}">
                                    <li class="page-item"><a class="page-link" href="ManagerProduct?pageIndex=${pageIndex-1}">Previous</a></li>
                                </c:if>
                                <c:if test="${tag==1}">
                                    <li class="page-item"><a class="page-link" href="ManagerProduct?pageIndex=${pageIndex-1}&txt=${txt}">Previous</a></li>
                                </c:if>

                            </c:if>
                            <c:if test="${totalPage>1}">
                                <c:if test="${tag==0}">
                                    <c:forEach begin="1" end="${totalPage}" var="i">
                                        <li class="page-item"><a class="page-link" href="ManagerProduct?pageIndex=${i}">${i}</a></li>
                                        </c:forEach>
                                 </c:if>
                                <c:if test="${tag==1}">
                                    <c:forEach begin="1" end="${totalPage}" var="i">
                                        <li class="page-item"><a class="page-link" href="ManagerProduct?pageIndex=${i}&txt=${txt}">${i}</a></li>
                                        </c:forEach>
                                 </c:if>

                            </c:if>

                            <c:if test="${pageIndex<totalPage}">
                                <c:if test="${tag==0}">
                                    <li class="page-item"><a class="page-link" href="ManagerProduct?pageIndex=${pageIndex+1}">Next</a></li>
                                </c:if>
                                <c:if test="${tag==1}">
                                    <li class="page-item"><a class="page-link" href="ManagerProduct?pageIndex=${pageIndex+1}&txt=${txt}">Next</a></li>
                                </c:if>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>  
        </div>   
    </body>
</html>