<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘月胜
  Date: 2021/5/24
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>添加书籍</title>
</head>
<body>
<center>
<h1>添加书籍信息</h1>
    <form action="/book/addBook" method="post"enctype="multipart/form-data">
<table width="500" border="1" cellpadding="0" height="200" align="center">
<tr>
    <td>书名：<input type="text" name="bookname"></td>
</tr>
    <tr>
        <td>作者：<input type="text" name="author"></td>
    </tr>
    <tr>
        <td>价格：<input type="text" name="price"></td>
    </tr>
    <tr>
        <td>类名</td>
        <td>
            <select name="classid">

           <option value="">-请选择-</option>
            <c:forEach items="${classifyList}" var="classify">
                 <option value="${classify.id}"> ${classify.name}</option>
            </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <td>简介：<input type="text" name="descr"></td>
    </tr>
    <tr>
        <td>封面：<input type="file" name="photo"></td>
    </tr>
    <tr>
        <td>
            <input type="submit" value="添加">
        </td>
    </tr>
</table>
    </form>
</center>
</body>
</html>
