<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>


     



        <!-- bootstrap core css -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

        <!-- fonts style -->
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700;900&display=swap" rel="stylesheet">

        <!--owl slider stylesheet -->
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />

        <!-- font awesome style -->
        <link href="css/font-awesome.min.css" rel="stylesheet" />

        <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet" />
        <!-- responsive style -->
        <link href="css/responsive.css" rel="stylesheet" />
        <style>

            .paging {
                list-style-type: none;
                padding: 0;
                display: flex;
                flex-wrap: wrap;
                justify-content: center;
            }
            .paging a {
                text-decoration: none;
                color: #007bff;
                padding: 10px 15px;
                margin: 5px;
                border: 1px solid #007bff;
                border-radius: 5px;
                transition: background-color 0.3s, color 0.3s;
            }
            .paging a:hover {
                background-color: #007bff;
                color: white;
            }
            .paging a.active {
                background-color: #007bff;
                color: white;
                border: none;
            }
             .category-list {
        list-style-type: none; /* Bỏ dấu bullet */
        padding: 0; /* Bỏ padding */
        margin: 0; /* Bỏ margin */
        display: flex; /* Hiển thị theo hàng */
        flex-wrap: wrap; /* Cho phép xuống dòng */
    }

    .category-list li {
        margin: 10px; /* Khoảng cách giữa các mục */
    }

    .category-list a {
        text-decoration: none; /* Bỏ gạch chân */
        color: #007bff; /* Màu chữ */
        padding: 10px 15px; /* Padding cho liên kết */
        border: 1px solid #007bff; /* Viền cho liên kết */
        border-radius: 5px; /* Bo góc */
        transition: background-color 0.3s; /* Hiệu ứng chuyển màu */
    }

    .category-list a:hover {
        background-color: #007bff; /* Màu nền khi hover */
        color: white; /* Màu chữ khi hover */
    }
        </style>
    </head>

    <body>

        <div class="hero_area">
            <!-- header section strats -->
            <header class="header_section">
                <div class="header_top">
                    <div class="container-fluid ">
                        <div class="contact_nav">
                            <a href="">
                                <i class="fa fa-phone" aria-hidden="true"></i>
                                <span>
                                    Call : +01 123455678990
                                </span>
                            </a>
                            <a href="">
                                <i class="fa fa-envelope" aria-hidden="true"></i>
                                <span>
                                    Email : demo@gmail.com
                                </span>
                            </a>
                            <a href="">
                                <i class="fa fa-map-marker" aria-hidden="true"></i>
                                <span>
                                    Location
                                </span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="header_bottom">
                    <div class="container-fluid">
                        <nav class="navbar navbar-expand-lg custom_nav-container ">


                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                <span class=""> </span>
                            </button>

                            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                <ul class="navbar-nav  ">


                                    <form action="search" method="post" class="form-inline my-2 my-lg-0">
                                        <div class="input-group input-group-sm">
                                            <input value="${txtS}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                                            <div class="input-group-append">
                                                <button type="submit" class="btn btn-secondary btn-number">
                                                    <i class="fa fa-search"></i>
                                                </button>
                                            </div>
                                        </div>
                                        <a class="btn btn-success btn-sm ml-3" href="listCart">
                                            <i class="fa fa-shopping-cart">${sessionScope.SessionLogin.username}</i>  
                                           
                                        </a>
                                    </form>
                                    <li class="nav-item">
                                        <a class="nav-link" href="profile"> <i class="fa fa-user" aria-hidden="true"></i> ${sessionScope.SessionLogin.username}</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="logout"> <i class="fa fa-user" aria-hidden="true"></i> Logout</a>
                                    </li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
            </header>
            <div class="container">
                <div class="row">
                    <div class="col">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="home">Home</a></li>
                                <li class="breadcrumb-item"><a href="ListProduct">Category</a></li>
                                <li class="breadcrumb-item active" aria-current="#">${tag}</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">


                    <div class="col-sm-9">
                        <div id="content" class="row">
                            <c:forEach items="${listP}" var="o">
                                <div class="product col-12 col-md-6 col-lg-4">
                                    <div class="card">
                                        <img class="card-img-top" src="${o.image}" alt="Card image cap">
                                        <div class="card-body">
                                            <h4 class="card-title show_txt"><a href="detail?pid=${o.id}" title="View Product">${o.name}</a></h4>                                       
                                            <div class="row">
                                                <div class="col">
                                                    <p class="btn btn-danger btn-block">${o.price} $</p>
                                                </div>
                                                <div class="col">
                                                    <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="card bg-light mb-3">
                            <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
                            <ul class="category-list">
                                <c:forEach items="${listCC}" var="o">
                                    <li class=""><a href="category?cid=${o.categoryID}">${o.categoryName}</a></li>
                                    </c:forEach>

                            </ul>
                        </div>
                        <div class="card bg-light mb-3">
                            <div class="card-header bg-success text-white text-uppercase">Last product</div>
                            <div class="card-body">
                                <img class="img-fluid" src="${p.image}" />
                                <h5 class="card-title">${p.name}</h5>

                                <p class="bloc_left_price">${p.price} $</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <ul class="paging" style="text-align: center">
                <c:forEach begin="1" end="${endP}" var="i">

                    <a href="ListProduct?index=${i}">
                        ${i}
                    </a>

                </c:forEach>
            </ul>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    </body>
</html>