<%-- 
    Document   : RoHang
    Created on : Oct 25, 2022, 10:38:23 PM
    Author     : asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <script src="https://kit.fontawesome.com/fb0121139d.js" crossorigin="anonymous"></script>
        <style>
            @media (min-width: 1025px) {
.h-custom {
height: 100vh !important;
}
}

.card-registration .select-input.form-control[readonly]:not([disabled]) {
font-size: 1rem;
line-height: 2.15;
padding-left: .75em;
padding-right: .75em;
}

.card-registration .select-arrow {
top: 13px;
}

.bg-grey {
background-color: #eae8e8;
}

@media (min-width: 992px) {
.card-registration-2 .bg-grey {
border-top-right-radius: 16px;
border-bottom-right-radius: 16px;
}
}

@media (max-width: 991px) {
.card-registration-2 .bg-grey {
border-bottom-left-radius: 16px;
border-bottom-right-radius: 16px;
}
}
        </style>
    </head>
    <body>
        <section class="h-100 h-custom" style="background-color: #d2c9ff;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12">
        <div class="card card-registration card-registration-2" style="border-radius: 15px;">
          <div class="card-body p-0">
            <div class="row g-0">
              <div class="col-lg-8">
                <div class="p-5">
                  <div class="d-flex justify-content-between align-items-center mb-5">
                    <h1 class="fw-bold mb-0 text-black">Giỏ Hàng</h1>
                    <h6 class="mb-0 text-muted">Có: ${giohang.size()} sản phẩm</h6>
                  </div>
                  <c:forEach items="${giohang}" var="o">
                        <hr class="my-4">
                        <div> <input onclick="ChoseProduct(this)" type="checkbox" value="${o.getPid()}"  ${o.isIsChose()?"checked":""}></div>
                  <div class="row mb-4 d-flex justify-content-between align-items-center">
                    <div class="col-md-2 col-lg-2 col-xl-2">
                      <img
                        src="image/${o.getPimage()}"
                        class="img-fluid rounded-3" alt="Image Product">
                    </div>
                    <div class="col-md-3 col-lg-3 col-xl-3">
                      <!--<h6 class="text-muted">Shirt</h6>-->
                      <h6 class="text-black mb-0">${o.getPname()}</h6>
                    </div>
                    <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                      
                        <a href="UpdateGioHang?Pid=${o.getPid()}&Quantity=${o.getQuantity()}&u=-1" class="p-2"><i class="fas fa-minus"></i></a>

                      <input name="Quantity" value="${o.getQuantity()}" type="number"
                        class="form-control form-control-sm" />

                      <a href="UpdateGioHang?Pid=${o.getPid()}&Quantity=${o.getQuantity()}&u=1" class="p-2"><i class="fas fa-plus"></i></a>
                    </div>
                    <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                        <h6 id="$[o.getPid()]" class="mb-0">$ ${o.getPprice()}</h6>
                    </div>
                    <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                      <a href="XoaGioHang?Pid=${o.getPid()}" class="text-muted">Xóa</a>
                    </div>
                  </div>
                    </c:forEach>
                  

                  
                  <hr class="my-4">

                  <div class="pt-5">
                    <h6 class="mb-0"><a href="#!" class="text-body"><i
                                class="fas fa-long-arrow-alt-left me-2"></i><a href="Main" class="text-decoration-none text-success">Back to shop</a></h6>
                  </div>
                </div>
              </div>
              <div class="col-lg-4 bg-grey">
                <div class="p-5">
                  <h3 class="fw-bold mb-5 mt-2 pt-1">Summary</h3>
                  <hr class="my-4">

                 
                  

                  <h5 class="text-uppercase mb-3">Give code</h5>

                  <div class="mb-5">
                    <div class="form-outline">
                      <input type="text" id="form3Examplea2" class="form-control form-control-lg" />
                      <label class="form-label" for="form3Examplea2">Enter your code</label>
                    </div>
                  </div>

                  <hr class="my-4">

                  <div class="d-flex justify-content-between mb-5">
                    <h5 class="text-uppercase">Total price</h5>
<!--                    <h5>$ ${Total}</h5>-->
                    <div id="total"><h5>${Total}</h5></div>
                  </div>

                  <button type="button" class="btn btn-dark btn-block btn-lg"
                          data-mdb-ripple-color="dark"><a href="LoadAdress" class="text-decoration-none text-white">Register</a></button>

                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
        
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/jquery-3.6.1.js"></script>
        <script>
            function ChoseProduct(input){
                let txt=input.value;
                 $.ajax({
                    url: "/ProjectPRJ_HE163166_SE163168/UpdateChose",

                    data: {
                        txt: txt
                    },
                    success: function (response) {
                        var content = document.getElementById("total");
                        content.innerHTML = response;
                    },
                    error: function (xhr) {
                        //Do Something to handle error
                    }
                });
            }
        </script>
    </body>
</html>
