<%-- 
    Document   : Item
    Created on : Oct 20, 2022, 9:51:18 PM
    Author     : asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
        <title>Document</title>
    </head>
    <body>
        <jsp:include page="Head.jsp"></jsp:include>
        <div class="container mt-5">
            <div class="row">
                <div class="col-sm Item_left">
                    <img src="image/${dao.getOneProduct().getImage()}" alt="">
                </div>
                <div class="col-sm Item_right">
                    <h2 class="mt-5">${dao.getOneProduct().getName()}</h2><br>
                    <h3 class="text-danger">${dao.getOneProduct().getPrice()}$</h3>
                    <hr>
                    <c:if test="${sessionScope.account.getRoll()!=1}">
                        <div class="row" >
                        <form action="${sessionScope.account==null?"Login.jsp":"ThemVaoGioHang"}" method="get">
                            <input type="hidden" name="Pid" value='${Pid}'>
                            <input type="hidden" name="Pname" value='${p.getName()}'>
                            <input type="hidden" name="Pprice" value='${p.getPrice()}'>
                            <input type="hidden" name="Pimage" value='${p.getImage()}'>
                            <input type="hidden" name="Quantity" value='1'>
                            <button type="submit button" class="btn btn-secondary col-sm-6 m-1" >Thêm vào giỏ hàng</button>
                        </form>
                        <form action="${sessionScope.account.getRoll()==1?"UpProduct":"ThemVaoGioHang"}" method="post">
                            <button type="button" class="btn btn-danger col-sm-6 m-1">Mua ngay</button>
                        </form>
                    </div>
                    </c:if>
                    <c:if test="${sessionScope.account.getRoll()==1}">
                        <button class="btn btn-success"><a href="UpProduct?Pid=${Pid}" class="text-decoration-none text-white">Edit this Product</a></button>
                    </c:if>
                    <br><br>
                    <div><b>Mã: </b>${dao.getOneProduct().getId()}</div>
                    <br>
                    <div><b>Thương Hiệu: </b><a href="Main?cid=${dao.getOneProduct().getCid()}">${Cname}</a></div>
                </div>
            </div>
        </div>


        <script src="js/bootstrap.bundle.min.js"></script>
    </body>
</html>