<%-- 
    Document   : cart
    Created on : Oct 28, 2024, 10:26:37 PM
    Author     : Helios 16
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .card-content {
            display: flex;
            position: relative;
            justify-content: center;
            margin: 20px;
        }

        .table {
            width: 100%;
            max-width: 700px;
            margin: 0 auto;
            border-collapse: collapse;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 12px;
            text-align: center;
            border: 1px solid #ccc;
        }

        th {
            background-color: #f4f4f4;
            color: #333;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .product-titles {
            margin: 0;
        }

        input[type="checkbox"] {
            cursor: pointer;
        }

        a {
            color: #d9534f;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }

        @media (max-width: 768px) {
            .table {
                width: 90%;
                font-size: 14px;
            }

            th, td {
                padding: 8px;
            }

            img {
                width: 100px; /* Responsive image size */
            }
        }
    </style>
    <body>
   <form action="payControl" method="post">
            <div class="card-content" style="display: flex;  position: relative;" >
                <table class="table" style="width: 700px;margin-left: 120px;margin-bottom: 100px;">
                    <thead>
                        <tr >
                            <th style="display : flex; flex-direction : row">
                                <input type="checkbox" class="check" id="checkAll">
                                <label>
                                    Chọn tất cả
                                </label>
                            </th>
                            <th scope="col">Hình ảnh</th>
                            <th scope="col">Số Lượng</th>
                            <th scope="col">name</th>
                            <th scope="col">Giá</th>
                            <th scope="col">Total</th>
                            <th scope="col">Xóa</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="totals" value="0"/>
                        <c:set var="totalr" value="0"/>
                        <c:forEach items="${listC}" var="cart">
                            <c:set var="total" value="${(totals + cart.quantity) * cart.price}"/>
                            <c:set var="totalr" value="${totalr + total}"/>
                            <tr>
                                <td><label>
                                        <input type="checkbox" name="cID" value="${cart.image}" class="check">
                                    </label>
                                </td>
                                <td style="width: 200px">
                                    <img src="image/${cart.imge}" alt="" style="width: 200px"/>
                                </td>
                                <td style="width: 100px;">
                                    <h5 class="product-titles" style="text-align: center;">${cart.quantity}</h5>
                                </td>
                                <td style="width: 100px;">
                                    <h5 class="product-titles" style="text-align: center;">${cart.name}</h5>
                                </td>
                                <td style="width: 100px;">
                                    <h5 class="product-titles" style="text-align: center;">$${cart.price}</h5>
                                </td>
                                <td style="width: 100px;">
                                    <h5 class="product-titles" style="text-align: center;">$${total}</h5>
                                </td>
                                <td style="width: 100px;">
                                    <a type="submit" href="DeleteCart?cID=${cart.cID}" style="text-align: center;">DELETE</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div class="totalprice" style="margin-top: 50px;">
                    <h2 style="color: #000; font-size: 50px;">Total Price :<span style="color: red">$${totalr}</span></h2>
                    <button type="submit" class="btn btn-success">Thanh toán</button>
                </div>
            </div>
        </form>
                </body>
                </html>
