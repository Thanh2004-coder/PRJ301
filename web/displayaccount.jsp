<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <c:if test="${sessionScope.SessionLogin != null}">
        Hello, ${sessionScope.SessionLogin.username} <br>
        <form action="logout">
            <input type="submit" value="Logout">
        </form>
    </c:if>
    <c:if test="${sessionScope.SessionLogin == null}">
        <a href="index.jsp">Đăng Nhập     </a><a href="register.jsp">Đăng Kí     </a>  
    </c:if>
        
    </body>
</html>
