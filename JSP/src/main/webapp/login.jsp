<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/8/3
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv">
    <form action="/JSP/loginServlet" method="post" id="form">
        <h1 id="loginMsg">LOGIN IN</h1>
        <div id="errorMsg">${Login_msg}${register_msg}</div>
        <p>Username:<input id="username" name="username" type="text" value="${cookie.username.value}"></p>

        <p>Password:<input id="password" name="password" type="password" value="${cookie.password.value}"></p>

        <p>Remember:<input id="remember" name="remember" type="checkbox" value="1" size="small"></p>

        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
            <a href="register.jsp">没有账号？点击注册</a>
        </div>
    </form>
</div>

</body>
</html>
