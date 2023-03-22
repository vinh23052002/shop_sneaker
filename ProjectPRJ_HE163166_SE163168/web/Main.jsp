<%-- 
    Document   : Main
    Created on : Oct 19, 2022, 10:42:33 PM
    Author     : asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Shop Giay</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
        <script src="https://kit.fontawesome.com/fb0121139d.js" crossorigin="anonymous"></script>
    </head>

    <body>
        <jsp:include page="Head2.jsp"></jsp:include>

            <div><img src="image/header_picture.jpg" style="width: 100%"></div>


            <!-------------------------Category----------------------------------------->
            <section class="category">


                <div class="container">
                    <div class="row">
                        <div class="category_left">
                            <ul>
                            <c:forEach items="${dao.getCategory().entrySet()}" var="i">
                                <li class="category_left_items" onclick="LoadCategory(this)" value="${i.getKey()}">${i.getValue().getCname()}</li>
                                </c:forEach>
                            <br>
                             <input oninput="SearchProduct(this)" type="text" placeholder="Search" >
                             <br><br/>
                             <div> 
                                 <div class="category_left_items">Price</div>
                            <select id="chosePrice" style="width: 90%">
                                <option  value="def" class="category_left_items">Mặc định</option>
                                <option  value="1" class="category_left_items">0$ to 500$</option>
                                <option  value="2" class="category_left_items">500$ to 1000$</option>
                                <option  value="3" class="category_left_items">more 1000$</option>
                                
                            </select>
                             </div>

                    </div>
                    <div class="category_right">
                        <div class="category_right_top">
                            <div class="category_right_top_item">
                                <select id="sort">
                                    <option  value="def">Mặc định</option>
                                    <option value="desc" >Cao đến thấp</option>
                                    <option  value="asc">Thấp đến cao</option>
                                </select>
                            </div>
                        </div>

                        <div class="category_right_content">
                            <div id="content" class="row">
                                <c:forEach items="${dao.getProduct()}" var="o">
                                    <div class="col-12 col-md-6 col-lg-3 mb-4 category_right_content_item">
                                        <div class="card">
                                            <a href="item?pid=${o.getId()}" title="View Product"><img class="card-img-top" src="image/${o.getImage()}" alt="Card image cap"></a>

                                            <div class="card-body">
                                                <h4 class="card-title show_txt"><a href="item?pid=${o.getId()}" title="View Product">${o.getName()}</a></h4>
                                                <p class="card-text show_txt"></p>
                                                <div class="row">
                                                    <div class="col">
                                                        <a href="item?pid=${o.getId()}" title="View Product"><p class="btn btn-danger btn-block">${o.getPrice()} $</p></a>
                                                    </div>
                                                    <div class="col">
                                                        <a href="ThemVaoGioHang?Pid=${o.getId()}" title="View Product"><p class="btn btn-info btn-block"><i class="fa-solid fa-cart-plus"></i></p></a>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>

                            <nav aria-label="Page navigation " >
                                <ul class="pagination" id="pag"">
                                    <c:if test="${pageIndex>1}">
                                        <c:if test="${tag==1}">
                                            <li class="page-item"><a class="page-link" href="Main?pageIndex=${pageIndex-1}&cid=${cid}">Previous</a></li>
                                            </c:if>
                                            <c:if test="${tag==0}">
                                            <li class="page-item"><a class="page-link" href="Main?pageIndex=${pageIndex-1}">Previous</a></li>
                                            </c:if>
                                            <c:if test="${tag==2}">
                                            <li class="page-item"><a class="page-link" href="Main?pageIndex=${pageIndex-1}&txt=${txt}">Previous</a></li>
                                            </c:if>
                                        </c:if>
                                        <c:forEach begin="1" end="${totalPage}" var="i">
                                            <c:if test="${tag==0}">
                                            <li class="page-item"><a class="page-link" href="Main?pageIndex=${i}">${i}</a></li>
                                            </c:if>
                                            <c:if test="${tag==1}">
                                            <li class="page-item"><a class="page-link" href="Main?pageIndex=${i}&cid=${cid}">${i}</a></li>
                                            </c:if>
                                            <c:if test="${tag==2}">
                                            <li class="page-item"><a class="page-link" href="Main?pageIndex=${i}&txt=${txt}">${i}</a></li>
                                            </c:if>
                                        </c:forEach>
                                        <c:if test="${pageIndex<totalPage}">
                                            <c:if test="${tag==1}">
                                            <li class="page-item"><a class="page-link" href="Main?pageIndex=${pageIndex+1}&cid=${cid}">Next</a></li>
                                            </c:if>
                                            <c:if test="${tag==0}">
                                            <li class="page-item"><a class="page-link" href="Main?pageIndex=${pageIndex+1}">Next</a></li>
                                            </c:if>
                                            <c:if test="${tag==2}">
                                            <li class="page-item"><a class="page-link" href="Main?pageIndex=${pageIndex+1}&txt=${txt}">Next</a></li>
                                            </c:if>
                                        </c:if>

                                </ul>
                            </nav>
                        </div>

                    </div>
                </div>
            </div>

        </section>
        <jsp:include page="Footer.jsp"></jsp:include>
        <!----------------------------------------------------------------------------->
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>-->
        <script src="js/jquery-3.6.1.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>

        <script>
            function SearchProduct(input) {
                var txt = input.value;
                document.getElementById("pag").style.display = "none";
                $.ajax({
                    url: "/ProjectPRJ_HE163166_SE163168/SearchFast",

                    data: {
                        txt: txt
                    },
                    success: function (response) {
                        var content = document.getElementById("content");
                        content.innerHTML = response;
                    },
                    error: function (xhr) {
                        //Do Something to handle error
                    }
                });
            }
            ;
            function LoadCategory(input) {
                var txt = input.value;
                document.getElementById("pag").style.display = "none";
                $.ajax({
                    url: "/ProjectPRJ_HE163166_SE163168/ChoseCategory",

                    data: {
                        txt: txt
                    },
                    success: function (response) {
                        var content = document.getElementById("content");
                        content.innerHTML = response;
                    },
                    error: function (xhr) {
                        //Do Something to handle error
                    }
                });
            }
            ;
            var inputElement = document.getElementById("sort");
            inputElement.onchange =
                    function SortProduct(input) {
                        var txt = input.target.value;
                        document.getElementById("pag").style.display = "none";
                        $.ajax({
                            url: "/ProjectPRJ_HE163166_SE163168/SortProduct",

                            data: {
                                txt: txt
                            },
                            success: function (response) {
                                var content = document.getElementById("content");
                                content.innerHTML = response;
                            },
                            error: function (xhr) {
                                //Do Something to handle error
                            }
                        });
                    }
            ;
            var inputElement = document.getElementById("chosePrice");
            inputElement.onchange =
                    function ChosePriceProduct(input) {
                        var txt = input.target.value;
                        document.getElementById("pag").style.display = "none";
                        $.ajax({
                            url: "/ProjectPRJ_HE163166_SE163168/ChosePrice",

                            data: {
                                txt: txt
                            },
                            success: function (response) {
                                var content = document.getElementById("content");
                                content.innerHTML = response;
                            },
                            error: function (xhr) {
                                //Do Something to handle error
                            }
                        });
                    }
            ;
            

        </script>
    </body>

</html>