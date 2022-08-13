<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.itheima.pojo.Brand" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/8/1
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>brands</title>
</head>
<body>
<%--使用的是session中的数据--%>
<h1>${user.username}，欢迎你！</h1>
<input type="button" value="新增" id="add"><br>
<hr>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>

    </tr>
<%--  el语法  ${} {}内的相当于变量名--%>
<%-- jstl 语句 常用 c:foreach c:if --%>
    <c:forEach items="${brands}" var="brand" varStatus="status">
        <tr align="center">
                <%--<td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>

            <c:if test="${brand.status == 1}">
                <td>启用</td>
            </c:if>
            <c:if test="${brand.status != 1}">
                <td>禁用</td>
            </c:if>

            <td><a href="/JSP/selectByIdServlet?id=${brand.id}">修改</a> <a href="/JSP/deleteByIdServlet?id=${brand.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
<%--
另一种循环
<c:forEach begin="0" end="10" var="i">
    ${i}
</c:forEach>--%>

<%--可以直接写Java代码
<% %>  直接写java代码 例如 System.out.printfln("hahahah");
<%= %> 写什么控制台输出什么，等价于
<%! %> 放在方法外，属于成员变量和成员方法
--%>

<script>
    document.getElementById("add").onclick = function(){
        location.href="/JSP/addBrand.jsp";
    }
</script>

</body>
</html>
