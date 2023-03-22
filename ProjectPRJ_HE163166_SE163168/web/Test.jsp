<%-- 
    Document   : Head2
    Created on : Oct 30, 2022, 10:24:58 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <style>
            .carousel-item {
                height: 100vh;
                min-height: 350px;
                background: no-repeat center center scroll;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
            }
        </style>
        
    </head>
    <body>
        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
            <div class="container">
                <a class="navbar-brand" href="#">Start Bootstrap</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item">
                    <a class="nav-link" href="Main">Home</a>
                </li>
                <c:if test="${sessionScope.account.getRoll()==1}">
                    <li class="nav-item">
                        <a class="nav-link" href="ManagerProduct">Manager Product</a>
                    </li>
                </c:if>


                <c:if test="${sessionScope.account.getRoll()==1}">
                    <li class="nav-item">
                        <a class="nav-link" href="Account">Manager Account</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.account.getRoll()==1}">
                    <li class="nav-item">
                        <a class="nav-link" href="ManagerOrder">Manager Order</a>
                    </li>
                </c:if>


                <c:if test="${sessionScope.account==null}">
                    <li class="nav-item">
                        <a class="nav-link" href="Login.jsp">Login</a>
                    </li>
                </c:if>


                <c:if test="${sessionScope.account==null}">
                    <li class="nav-item">
                        <a class="nav-link" href="SignUp.jsp">Sign up</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.account.getRoll()==0}">
                    <li class="nav-item">
                        <a class="nav-link" href="LoadGioHang">Gio Hang</a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.account.getRoll()==0}">
                    <li class="nav-item">
                        <a class="nav-link" href="UpInformation">Thông Tin</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.account.getRoll()==0}">
                    <li class="nav-item">
                        <a class="nav-link" href="ChangePass.jsp">Đổi Mật Khẩu</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.account!=null}">
                    <li class="nav-item">
                        <a class="nav-link" href="Logout">LogOut</a>
                    </li>
                </c:if>
                    </ul>
                </div>
            </div>
        </nav>

        <header>

            <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active" style="background-image: url('https://source.unsplash.com/LAaSoL0LrYs/1920x1080')">
                        <div class="carousel-caption">
                            <h5>First slide label</h5>
                            <p>Some representative placeholder content for the first slide.</p>
                        </div>
                    </div>
                    <div class="carousel-item" style="background-image: url('https://source.unsplash.com/bF2vsubyHcQ/1920x1080')">
                        <div class="carousel-caption">
                            <h5>Second slide label</h5>
                            <p>Some representative placeholder content for the second slide.</p>
                        </div>
                    </div>
                    <div class="carousel-item" style="background-image: url('https://source.unsplash.com/szFUQoyvrxM/1920x1080')">
                        <div class="carousel-caption">
                            <h5>Third slide label</h5>
                            <p>Some representative placeholder content for the third slide.</p>
                        </div>
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </header>

        <script src="js/bootstrap.bundle.min.js"></script>
    </body>
</html>
