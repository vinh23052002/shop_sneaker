<%-- 
    Document   : Head2
    Created on : Oct 30, 2022, 10:24:58 PM
    Author     : asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
            <div class="container">
                <a class="navbar-brand" href="Main">VinShoe</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    
                    <ul class="navbar-nav ms-auto">
<!--                        <li class="nav-item">
                    <a class="nav-link" href="Main">Home</a>
                </li>-->
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
<!--                    <form action="Main" method="get" class="d-flex">
                <input oninput="SearchProduct(this)" class="form-control me-2" type="text" placeholder="Search" name="txt" value="${txt}">
                <input type="submit" value="Search" class="btn btn-primary"> 
                <button class="btn btn-primary " type="button">Search</button>
            </form>-->
                </div>
            </div>
        </nav>

        

        
    
